package com.roger.aeris.digital.customers;

import com.roger.aeris.digital.DigitalAPIHttpUtility;
import com.roger.http.HttpRequest;

import java.io.IOException;

/**
 * Created by Roger Hill
 * Date 23/03/2016.
 */
public class CustomersClient {

    public static void main(String[] args) {

        getCustomers();
    }

    private static void getCustomers() {

        CustomersClient CustomersClient = new CustomersClient();
        CustomersClient.readAll();
    }

    private static final String URL = "https://qa.easi.aeris-consulting.com/api-nl/api/customer";

    protected void readAll() {

        try {
            HttpRequest request = getReadAllRequest();
            request.setAcceptAnyCertificate(true);
            System.out.println("Response: " +
                    DigitalAPIHttpUtility.handleRequest(request));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected HttpRequest getReadAllRequest() {

        return HttpRequest.getJSONHttpRequest(HttpRequest.VERB_GET,
                URL,
                null);
    }
}
