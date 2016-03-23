package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 25/02/2016.
 */
public class DocumentCategoryManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"code\": \"HILLE\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"parentCategoryId\": null,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": 1,\n"
                + "        \"entityId\": 1,\n"
                + "        \"labelLanguageId\": 1,\n"
                + "        \"label\": \"Hill\"\n"
                + "      },\n"
                + "      \"2\": {\n"
                + "        \"id\": 2,\n"
                + "        \"entityId\": 1,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Hillhuh!\"\n"
                + "      }\n"
                + "    },\n"
                + "    \"children\": [\n"
                + "      \n"
                + "    ]\n"
                + "  }\n"
                + "}\n"
                + "]"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/documentCategory"; }
}
