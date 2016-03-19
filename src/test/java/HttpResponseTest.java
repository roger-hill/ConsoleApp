package com.roger;

import com.roger.http.HttpResponse;
import org.junit.Test;

/**
 * Created by Roger on 19/02/2016.
 */
public class HttpResponseTest {

    @Test
    public void confirmToString() {

        HttpResponse response = new HttpResponse(200, "OK", "{\"name\":\"value\"}", false);

        System.out.println(response.toString());
    }
}
