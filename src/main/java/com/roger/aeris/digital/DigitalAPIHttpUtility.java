package com.roger.aeris.digital;

import com.roger.http.HttpRequest;
import com.roger.http.HttpResponse;
import com.roger.http.HttpUtility;

import java.io.IOException;

/**
 * Created by Roger Hill
 * Date 23/03/2016.
 */
public class DigitalAPIHttpUtility {

    private static final String X_API_TOKEN_NAME = "X-ApiToken";
    private static final String X_API_TOKEN_VALUE = "DRUPAL";

    public static HttpResponse handleRequest(HttpRequest request) throws IOException {

        request.getProperties().put(X_API_TOKEN_NAME, X_API_TOKEN_VALUE);
        return HttpUtility.sendRequest(request);
    }
}
