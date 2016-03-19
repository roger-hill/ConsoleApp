package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 29/02/2016.
 */
public class LanguageClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"languageTag\": \"en-F\",\n"
                + "    \"readOnly\": true,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"E\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 17,\n"
                + "        \"label\": \"Anglais Francaise\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/language"; }
}
