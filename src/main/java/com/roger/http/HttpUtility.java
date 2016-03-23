package com.roger.http;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: Roger Hill
 * Date: 17/02/2016
 *
 * REST Client application for testing endpoints
 */
public class HttpUtility {

    public static HttpResponse sendRequest(HttpRequest request) throws IOException {

        HttpURLConnection connection = openConnection(request);

        connection.setRequestMethod(request.getVerb());

        for (String property: request.getProperties().keySet()) {
            connection.setRequestProperty(property, request.getProperties().get(property));
        }

        if (HttpRequest.VERB_POST.equals(request.getVerb())) {

            connection.setDoOutput(true);
            if (request.getPayload() != null) {
                DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(wr, "UTF-8"));
                writer.write(request.getPayload());
                writer.flush();
                writer.close();
            }
        }

        return getResponse(connection);

    }

    private static HttpURLConnection openConnection(HttpRequest request)
            throws IOException {

        URL url = new URL(request.getUrl());
        return (HttpURLConnection) url.openConnection();
    }

    private static HttpResponse getResponse(HttpURLConnection connection) throws IOException {

        int code = connection.getResponseCode();
        String message = connection.getResponseMessage();
        boolean error= false;

        BufferedReader payload;

        try {
            payload = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        } catch (IOException ioe) {
            error = true;
            System.out.println("Error: " + ioe.getMessage());
            try {
                payload = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            } catch (Exception e) {
                System.out.println("Error when trying to read the error stream: " + e.getMessage());
                payload = null;
            }
        }

        String inputLine;

        StringBuilder sb = new StringBuilder();

        if (payload != null) {
            while ((inputLine = payload.readLine()) != null) {
                sb.append(inputLine);
            }
            payload.close();
        }

        HttpResponse response = new HttpResponse(code, message, sb.toString(), error);
        return response;
    }
}
