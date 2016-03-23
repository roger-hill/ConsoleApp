package com.roger.http;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Roger on 19/02/2016.
 */
public class HttpRequest {

    public static final String VERB_GET = "GET";
    public static final String VERB_POST = "POST";
    public static final String PROPERTY_NAME__CONTENT_TYPE = "Content-Type";
    public static final String PROPERTY_NAME__ACCEPT_CHARSET = "Accept-Charset";
    public static final String CONTENT_TYPE__APPLICATION_JSON = "application/json";
    public static final String CONTENT_TYPE__CHARSET_UTF8 = "UTF-8";

    private String verb;
    private String url;
    private String payload;
    private Map<String, String> properties;
    boolean acceptAnyCertificate = false;

    public static HttpRequest getJSONHttpRequest(String verb, String url, String payload) {

        HttpRequest request = new HttpRequest();

        request.verb = verb;
        request.url = url;
        request.payload = payload;
        request.getProperties().put(
                HttpRequest.PROPERTY_NAME__CONTENT_TYPE,
                HttpRequest.CONTENT_TYPE__APPLICATION_JSON);

        return request;
    }

    private HttpRequest() {}

    public String getVerb() {

        return verb;
    }

    public String getUrl() {

        return url;
    }

    public String getPayload() {

        return payload;
    }

    public Map<String, String> getProperties() {

        if (properties == null) {

            properties = new HashMap<String, String>();
        }

        return properties;
    }

    public boolean getAcceptAnyCertificate() {
        return acceptAnyCertificate;
    }

    public void setAcceptAnyCertificate(boolean acceptAnyCertificate) {
        this.acceptAnyCertificate = acceptAnyCertificate;
    }
}
