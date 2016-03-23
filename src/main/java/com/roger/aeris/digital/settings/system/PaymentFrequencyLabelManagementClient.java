package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 25/02/2016.
 */
public class PaymentFrequencyLabelManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"UPDATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": 100,\n"
                + "    \"entityId\": null,\n"
                + "    \"labelLanguageId\": 2,\n"
                + "    \"label\": \"Bi\",\n"
                + "    \"paymentFrequency\": \"BIMONTHLY\"\n"
                + "  }\n"
                + "}\n"
                + "]\n"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/paymentFrequencyLabel"; }
}
