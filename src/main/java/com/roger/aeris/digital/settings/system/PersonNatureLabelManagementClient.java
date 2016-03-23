package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 29/02/2016.
 */
public class PersonNatureLabelManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/personNatureLabel"; }

    private static String createPersonNatureLabelJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "    {\n"
                + "      \"id\":null,\n"
                + "      \"entityId\":null,\n"
                + "      \"labelLanguageId\":2,\n"
                + "      \"label\":\"\",\n"
                + "      \"personNature\":\"FIRM\"\n"
                + "    }\n"
                + "}\n"
                + "]";

        return json;
    }
}
