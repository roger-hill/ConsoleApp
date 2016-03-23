package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 27/02/2016.
 */
public class CountryClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"isoCode\": \"AO\",\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Anganistan\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 3,\n"
                + "        \"label\": \"Anganistane\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/country"; }
}
