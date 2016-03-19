package com.roger.aeris.digital.settings.business;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 11/03/2016.
 */
public class PaymentModeClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"code\": \"ROG\",\n"
                + "    \"activeItem\": true,\n"
                + "    \"readOnly\": true,\n"
                + "    \"directDebit\": true,\n"
                + "    \"creditTransfer\": true,\n"
                + "    \"onlinePayment\": true,\n"
                + "    \"labels\": {\n"
                + "      \"1\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 100,\n"
                + "        \"label\": \"Roger\"\n"
                + "      },\n"
                + "    \"2\": {\n"
                + "        \"id\": null,\n"
                + "        \"entityId\": null,\n"
                + "        \"labelLanguageId\": 2,\n"
                + "        \"label\": \"Rogeruh\"\n"
                + "      }\n"
                + "    }\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/business/paymentMode"; }
}
