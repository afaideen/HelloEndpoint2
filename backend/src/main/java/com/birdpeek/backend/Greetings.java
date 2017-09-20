/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.birdpeek.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.response.NotFoundException;
import com.google.appengine.api.users.User;

import java.util.ArrayList;

import javax.inject.Named;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "helloworld",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.birdpeek.com",
                ownerName = "backend.birdpeek.com",
                packagePath = ""
        ),
        scopes = {Constants.EMAIL_SCOPE},
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE}
)
public class Greetings {

    public static ArrayList<HelloGreeting> greetings = new ArrayList<HelloGreeting>();

    static {
        greetings.add(new HelloGreeting("hello world!"));
        greetings.add(new HelloGreeting("goodbye world!"));
    }
//[END api_def]
//[START getgreetings]

    public HelloGreeting getGreeting(@Named("id") Integer id) throws NotFoundException {
        try {
            return greetings.get(id);
        } catch (IndexOutOfBoundsException e) {
            throw new NotFoundException("Greeting not found with an index: " + id);
        }
    }

    public ArrayList<HelloGreeting> listGreeting() {
        return greetings;
    }
//[END getgreetings]
//[START multiplygreetings]

    @ApiMethod(name = "greetings.multiply", httpMethod = "post")
    public HelloGreeting insertGreeting(@Named("times") Integer times, HelloGreeting greeting) {
        HelloGreeting response = new HelloGreeting();
        StringBuilder responseBuilder = new StringBuilder();
        for (int i = 0; i < times; i++) {
            responseBuilder.append(greeting.getMessage());
        }
        response.setMessage(responseBuilder.toString());
        return response;
    }
//[END multiplygreetings]
//[START auth]

    @ApiMethod(name = "greetings.authed", path = "hellogreeting/authed")
    public HelloGreeting authedGreeting(User user) {
        HelloGreeting response = new HelloGreeting("hello " + user.getEmail());
        return response;
    }
//[END auth]
}
