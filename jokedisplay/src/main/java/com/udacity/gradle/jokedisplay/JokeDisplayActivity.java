package com.udacity.gradle.jokedisplay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKEDISPLAYACTIVITY_JOKE_INTENT_EXTRA =
            "com.udacity.gradle.jokedisplay.joke_intent_extra";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display);

        String joke = getIntent().getStringExtra(JOKEDISPLAYACTIVITY_JOKE_INTENT_EXTRA);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.joke_display_fragment_container, JokeDisplayFragment.newInstance(joke))
                    .commit();
        }
    }
}
