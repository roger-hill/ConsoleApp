package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 19/02/2016.
 */
public class ProviderManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\":\"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\":100,\n"
                + "    \"code\":\"BULL\",\n"
                + "    \"name\":\"Bull\"\n"
                + "  }"
                + "}"
                + "]"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "provider"; }
}
