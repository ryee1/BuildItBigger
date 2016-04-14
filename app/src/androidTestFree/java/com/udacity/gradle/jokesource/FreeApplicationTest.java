package com.udacity.gradle.jokesource;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;

import com.udacity.gradle.app.MainActivity;
/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class FreeApplicationTest extends ActivityInstrumentationTestCase2<MainActivity> {


    public FreeApplicationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @MediumTest
    public void testTellJoke() throws Throwable{
        final MainActivity.EndPointsAsyncTask endPointsAsyncTask = getActivity().new EndPointsAsyncTask(getActivity());
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    String joke = endPointsAsyncTask.execute().get();
                    assertTrue("asynctask did not return a string: " + joke, joke != null);
                } catch (Exception e) {
                    assertTrue("asynctask could not run", false);
                }
            }
        });
    }
}