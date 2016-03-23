package com.roger.http;

/**
 * Created by Roger on 19/02/2016.
 */
public class HttpResponse {

    private int responseCode;
    private String responseMessage;
    private String responseBody;
    private boolean error;

    public HttpResponse(int code, String message, String body, boolean error) {

        responseCode = code;
        responseMessage = message;
        responseBody = body;
        this.error = error;
    }

    @Override
    public String toString() {

        return String.format("Response Code: %1$d%nResponse Message: %2$s%nResponseBody: %3$s",
                responseCode,
                responseMessage,
                responseBody);
    }

    public boolean getError() { return error; }

    public String getResponseBody() {
        return responseBody;
    }
}
