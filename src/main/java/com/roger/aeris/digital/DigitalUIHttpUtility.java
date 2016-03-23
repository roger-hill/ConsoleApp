package com.roger.aeris.digital;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.roger.http.HttpRequest;
import com.roger.http.HttpResponse;
import com.roger.http.HttpUtility;

import java.io.IOException;

/**
 * Created by Roger Hill
 * Date 02/03/2016.
 */
public class DigitalUIHttpUtility {

    private static String XSessionToken = null;
    private static final String X_SESSION_TOKEN_NAME = "X-SessionToken";

    public static HttpResponse handleRequest(HttpRequest request) throws IOException {

        HttpResponse response = null;

        if (XSessionToken == null) {
            loginAsAdmin();
        }

        if (XSessionToken != null) {

            request.getProperties().put(X_SESSION_TOKEN_NAME, XSessionToken);
            response = HttpUtility.sendRequest(request);
        }

        return response;
    }

    private static boolean loginAsAdmin() {

        boolean retVal = true;

        HttpResponse response = null;
        try {
            response = HttpUtility.sendRequest(
                    HttpRequest.getJSONHttpRequest(HttpRequest.VERB_POST,
                            "http://localhost:18080/easi-api/api/session",
                            getLoginJSON())
            );
        } catch (IOException e) {
            System.out.println("Failure when sending login request: " + e.getMessage());
            retVal = false;
        }

        try {
            if (response != null) {

                if (!response.getError()) {
                    ObjectMapper mapper = new ObjectMapper();
                    JsonNode rootNode = mapper.readTree(response.getResponseBody());
                    XSessionToken = rootNode.get("sessionTokenId").textValue();
                    System.out.println("XSessionToken: " + XSessionToken);
                } else {
                    System.out.println(response.getResponseBody());
                }
            }
        } catch (Throwable e) {
            System.out.println("Failure reading token from response: " + response.getResponseBody());
            System.out.println("Error is: " + e.getMessage());
            retVal = false;
        }

        return retVal;
    }

    private static String getLoginJSON() {

        String json = ""
                + "{"
                + "  \"login\": \"admin\","
                + "  \"password\": \"easi-admin\","
                + "  \"clientIpAddress\": \"0.0.0.0\""
                + "}"
                ;

        return json;
    }
}
