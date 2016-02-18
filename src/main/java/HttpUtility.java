package com.roger;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Author: Roger Hill
 * Date: 17/02/2016
 *
 * REST Client application for testing endpoints
 */
public class HttpUtility {

    public static void main(String[] args) {

        String ping = "http://localhost:18080/easi-api/api/ping";
        String specs = "http://localhost:18080/easi-api/api/specs/v1.0.json";
        String status = "http://localhost:18080/easi-api/api/status";

        // Get URLs
        String providersGet = "http://localhost:18080/easi-api/api/provider/2";
        String providersListAll = "http://localhost:18080/easi-api/api/provider";

        // Delete URLs and post data
        String providersDelete = "http://localhost:18080/easi-api/api/provider/delete";
        String listOfIntJSON = "[ 2, 3]";

        // Update URLs and post data
        String providersCreate = "http://localhost:18080/easi-api/api/provider";
        String updateProvider2JSON = "{\"id\":2,\"code\":\"roger\",\"name\":\"very new name of the roger code\"}";
        String createProviderJSON = "{\"code\":\"stanley\",\"name\":\"name of the peter code\"}";

        // Test 1 post too long code
        String tooLongCodeJSON = "{\"code\":\"THIS_CODE_IS_FAR_TOO_LONG\",\"name\":\"name of the peter code\"}";

        // Test 2 post too long name
        String tooLongNameJSON = "{\"code\":\"THIS_CODE\",\"name\":\"name of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter code\"}";

        // Test 3 post to existing provider with too long code
        String updateProviderCodeTooLongJSON = "{\"id\":6,\"code\":\"THIS_CODE_IS_FAR_TOO_LONG\",\"name\":\"Roger\"}";

        // Test 4 post to existing provider with too long name
        String updateProviderNameTooLongJSON = "{\"id\":6,\"code\":\"ROGER\",\"name\":\"name of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter codename of the peter code\"}";

        // Test 5 post with existing code
        String duplicateCodeJSON = "{\"code\":\"ROGER\",\"name\":\"name of the peter code\"}";

        // Test 6 post with existing code
        String duplicateNameJSON = "{\"code\":\"PETER\",\"name\":\"Roger\"}";

        // Test 7 post with existing id and a code that exists on another provider
        String updateProviderWithDuplicateCodeJSON = "{\"id\":6,\"code\":\"RCI\",\"name\":\"Poger\"}";

        // Test 8 post with existing id and a name that exists on another provider
        String updateProviderWithDuplicateNameJSON = "{\"id\":6,\"code\":\"ROGER\",\"name\":\"RCI Banque\"}";

        // Test 9 post with an id that does not exist in Providers
        String updateNonExistentProviderJSON = "{\"id\":7,\"code\":\"PETER\",\"name\":\"Peter\"}";

        // Test 10 delete
        String deleteAddress = "http://localhost:18080/easi-api/api/provider/delete";
        String idsToDeleteJSON = "[ 6, 7]";

        try {
            //get(providersListAll);
            post(deleteAddress, idsToDeleteJSON);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void get(String address) throws IOException {

        HttpURLConnection connection = openConnection(address);

        connection.setRequestMethod("GET");

        getResponse(connection);
    }

    private static void post(String address, String payload) throws IOException {

        HttpURLConnection connection = openConnection(address);

        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");
        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(payload);
        wr.flush();
        wr.close();

        getResponse(connection);
    }

    private static HttpURLConnection openConnection(String address) throws IOException {

        URL url = new URL(address);
        return (HttpURLConnection) url.openConnection();
    }

    private static void getResponse(HttpURLConnection connection) throws IOException {

        int code = connection.getResponseCode();
        String message = connection.getResponseMessage();
        System.out.println("Response: " + code + ": " + message);

        BufferedReader payload;

        try {
            payload = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException ioe) {
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

        System.out.println("Payload: " + sb.toString());
    }
}
