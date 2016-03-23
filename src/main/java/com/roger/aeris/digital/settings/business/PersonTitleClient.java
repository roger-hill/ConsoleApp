package com.roger.aeris.digital.settings.business;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 11/03/2016.
 */
public class PersonTitleClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": 1,\n"
                + "    \"code\": \"MR\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"personGender\": {\n"
                + "      \"id\": 176,\n"
                + "      \"code\": \"M\",\n"
                + "      \"activeItem\": true,\n"
                + "      \"readOnly\": false,\n"
                + "      \"labels\": {\n"
                + "        \"1\": {\n"
                + "          \"id\": 23,\n"
                + "          \"entityId\": 1,\n"
                + "          \"labelLanguageId\": 1,\n"
                + "          \"label\": \"Mal\",\n"
                + "          \"shortLabel\": \"M\"\n"
                + "        },\n"
                + "        \"2\": {\n"
                + "          \"id\": 24,\n"
                + "          \"entityId\": 1,\n"
                + "          \"labelLanguageId\": 2,\n"
                + "          \"label\": \"Homm\",\n"
                + "          \"shortLabel\": \"M\"\n"
                + "        }\n"
                + "      }\n"
                + "    },\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Mister\",\n"
                + "        \"shortLabel\": \"Mr\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Monsieur\",\n"
                + "        \"shortLabel\": \"Mn\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "}\n"
                + "]"
                ;
        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/business/personTitle"; }
}
