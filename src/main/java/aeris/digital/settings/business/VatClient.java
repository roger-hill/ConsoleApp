package com.roger.aeris.digital.settings.business;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 11/03/2016.
 */
public class VatClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "["
                + "{"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"code\": \"2023\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": false,\n"
                + "    \"labels\": [\n"
                + "      {\n"
                + "        \"id\": null,\n"
                + "        \"validityPeriod\": {\n"
                + "          \"startDate\": [\n"
                + "            2018,\n"
                + "            1,\n"
                + "            1\n"
                + "          ],\n"
                + "          \"endDate\": [\n"
                + "            2018,\n"
                + "            2,\n"
                + "            28\n"
                + "          ]\n"
                + "        },\n"
                + "        \"value\": 0.10\n"
                + "      },\n"
                + "      {\n"
                + "        \"id\": null,\n"
                + "        \"validityPeriod\": {\n"
                + "          \"startDate\": [\n"
                + "            2018,\n"
                + "            3,\n"
                + "            2\n"
                + "          ],\n"
                + "          \"endDate\": [\n"
                + "            2018,\n"
                + "            5,\n"
                + "            1\n"
                + "          ]\n"
                + "        },\n"
                + "        \"value\": 0.11\n"
                + "      }\n"
                + "    ]\n"
                + "  }\n"
                + "}"
                + "]"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/business/vat"; }
}
