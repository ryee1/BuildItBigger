/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.udacity.gradle.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokesource.JokeGenerator;

/** An endpoint class we are exposing */
@Api(
  name = "jokesApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.gradle.udacity.com",
    ownerName = "backend.gradle.udacity.com",
    packagePath=""
  )
)
public class MyEndpoint {

    JokeGenerator jokeGenerator = new JokeGenerator();
    @ApiMethod(name = "getJokes")
    public Jokes getJokes() {
        Jokes response = new Jokes();
        response.setData(jokeGenerator.getJoke());
        System.out.println("endpoint: " + jokeGenerator.getJoke());
        return response;
    }

}
