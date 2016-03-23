package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 19/02/2016.
 */
public class ProductCategoryManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        return withoutChildJSON();
        //return withChildJSON();
    }

    private String withoutChildJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\":\"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": 45,\n"
                + "    \"code\": \"ROGER\",\n"
                + "    \"activeItem\": false,\n"
                + "    \"readOnly\": true,\n"
                + "    \"parentCategoryId\": 45,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": 130,\n"
                + "        \"entityId\": 40,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Roger\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": 131,\n"
                + "        \"entityId\": 40,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Roger\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"children\": null\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    private String withChildJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\":\"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": 45,\n"
                + "    \"code\": \"ROGER\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"parentCategoryId\": null,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": 130,\n"
                + "        \"entityId\": 40,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Roger\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": 131,\n"
                + "        \"entityId\": 40,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Roger\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"children\": [\n"
                + "      {\n"
                + "        \"id\": 46,\n"
                + "        \"code\": \"JOHN\",\n"
                + "        \"activeItem\": false,\n"
                + "        \"readOnly\": true,\n"
                + "        \"parentCategoryId\": null,\n"
                + "        \"labels\": {\n"
                + "          \"1\": {\n"
                + "            \"id\": 128,\n"
                + "            \"entityId\": 41,\n"
                + "            \"labelLanguageId\": 1,\n"
                + "            \"label\": \"Johnny\"\n"
                + "          },\n"
                + "          \"2\": {\n"
                + "            \"id\": 129,\n"
                + "            \"entityId\": 41,\n"
                + "            \"labelLanguageId\": 2,\n"
                + "            \"label\": \"Jeanny\"\n"
                + "          }\n"
                + "        },\n"
                + "        \"children\": [\n"
                + "          \n"
                + "        ]\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/productCategory"; }
}
