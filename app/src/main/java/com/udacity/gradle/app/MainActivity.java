package com.udacity.gradle.app;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.backend.jokesApi.JokesApi;
import com.udacity.gradle.jokedisplay.JokeDisplayActivity;
import com.udacity.gradle.jokesource.R;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    private String endpoint_root_url = "http://10.0.3.2:8080/_ah/api/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view){
       new EndPointsAsyncTask(this).execute();
    }

    public class EndPointsAsyncTask extends AsyncTask<Void, Void, String> {
        private Context mContext;
        private JokesApi jokesApi = null;

        public EndPointsAsyncTask(Context context) {
            this.mContext = context;
        }

        @Override
        protected String doInBackground(Void... params) {
            if(jokesApi == null){
                JokesApi.Builder builder = new JokesApi.Builder(AndroidHttp.newCompatibleTransport(),
                        new AndroidJsonFactory(), null)
                        .setRootUrl("https://builditbigger-1279.appspot.com/_ah/api/");
                jokesApi = builder.build();
            }
            try{
                return jokesApi.getJokes().execute().getData();
            }catch(IOException e){
                Log.e("AsyncTaskEndPoint", e.getMessage() + "");
                return null;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            if(s == null || JokeDisplayActivity.JOKEDISPLAYACTIVITY_JOKE_INTENT_EXTRA == null){
                return;
            }
            Log.e("test", "string: " + JokeDisplayActivity.JOKEDISPLAYACTIVITY_JOKE_INTENT_EXTRA);
            startActivity(new Intent(mContext, JokeDisplayActivity.class)
                    .putExtra(JokeDisplayActivity.JOKEDISPLAYACTIVITY_JOKE_INTENT_EXTRA, s));
        }
    }

}
