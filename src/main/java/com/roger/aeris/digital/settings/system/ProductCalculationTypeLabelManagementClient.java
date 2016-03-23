package com.roger.aeris.digital.settings.system;

import com.roger.aeris.digital.settings.AbstractSettingsClient;

/**
 * Created by Roger Hill
 * Date 26/02/2016.
 */
public class ProductCalculationTypeLabelManagementClient extends AbstractSettingsClient {

    @Override
    protected String getJSON() {

        String json = ""
                + "[\n"
                + "{\n"
                + "  \"entityAction\": \"CREATE\",\n"
                + "  \"entity\":\n"
                + "  {\n"
                + "    \"id\": null,\n"
                + "    \"entityId\": null,\n"
                + "    \"labelLanguageId\": 3,\n"
                + "    \"label\": \"Grid\",\n"
                + "    \"productCalculationType\": \"GRID\"\n"
                + "  }"
                + "}"
                + "]"
                ;

        return json;
    }

    @Override
    protected String getEndpoint() { return "settings/system/productCalculationTypeLabel"; }
}
