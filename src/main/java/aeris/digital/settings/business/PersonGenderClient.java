package com.roger.aeris.digital.settings.business;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 11/03/2016.
 */
public class PersonGenderClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"code\": \"Z\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 100,\n"
                + "        \"label\": \"Zulu\",\n"
                + "        \"shortLabel\": \"F\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Femme\",\n"
                + "        \"shortLabel\": \"F\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "},\n"
                + "{\n"
                + "  \"entityAction\": \"DELETE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": 9,\n"
                + "    \"code\": \"M\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Masturbator\",\n"
                + "        \"shortLabel\": \"F\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Masturbateur\",\n"
                + "        \"shortLabel\": \"F\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/business/personGender"; }
}
