package com.roger.aeris.digital.settings;

import com.roger.aeris.digital.DigitalHttpUtility;
import com.roger.aeris.digital.settings.business.ManufacturerBrandClient;
import com.roger.aeris.digital.settings.business.MembershipProgramClient;
import com.roger.aeris.digital.settings.business.PaymentModeClient;
import com.roger.aeris.digital.settings.business.PersonGenderClient;
import com.roger.aeris.digital.settings.business.PersonTitleClient;
import com.roger.aeris.digital.settings.business.ProductBrandClient;
import com.roger.aeris.digital.settings.business.UnsaleabilityReasonClient;
import com.roger.aeris.digital.settings.business.VatClient;
import com.roger.aeris.digital.settings.system.CountryClient;
import com.roger.aeris.digital.settings.system.DocumentCategoryManagementClient;
import com.roger.aeris.digital.settings.system.LanguageClient;
import com.roger.aeris.digital.settings.system.PaymentFrequencyLabelManagementClient;
import com.roger.aeris.digital.settings.system.PersonNatureLabelManagementClient;
import com.roger.aeris.digital.settings.system.ProductCalculationTypeLabelManagementClient;
import com.roger.aeris.digital.settings.system.ProductCategoryManagementClient;
import com.roger.aeris.digital.settings.system.ProviderManagementClient;
import com.roger.http.HttpRequest;

import java.io.IOException;

/**
 * Created by Roger Hill
 * Date 11/03/2016.
 */
public abstract class AbstractSettingsClient {

    public static void main(String[] args) {

        manageBusinessSettings();
        //manageSystemSettings();
    }

    private static void manageBusinessSettings() {

        ManufacturerBrandClient manufacturerBrandClient = new ManufacturerBrandClient();
        MembershipProgramClient membershipProgramClient = new MembershipProgramClient();
        PaymentModeClient paymentModeClient = new PaymentModeClient();
        ProductBrandClient productBrandClient = new ProductBrandClient();
        PersonGenderClient personGenderClient = new PersonGenderClient();
        PersonTitleClient personTitleClient = new PersonTitleClient();
        UnsaleabilityReasonClient unsaleabilityReasonClient = new UnsaleabilityReasonClient();
        VatClient vatClient = new VatClient();


        //manufacturerBrandClient.readAll();
        //manufacturerBrandClient.save();

        //membershipProgramClient.readAll();
        //membershipProgramClient.save();

        //paymentModeClient.readAll();
        //paymentModeClient.save();

        //personGenderClient.readAll();
        //personGenderClient.save();

        //personTitleClient.readAll();
        //personTitleClient.save();

        //productBrandClient.readAll();
        //productBrandClient.save();

        vatClient.readAll();
        //vatClient.save();

        //unsaleabilityReasonClient.readAll();
        //unsaleabilityReasonClient.save();
    }

    private static void manageSystemSettings() {

        ProviderManagementClient providerManagementClient = new ProviderManagementClient();
        CountryClient countryClient = new CountryClient();
        DocumentCategoryManagementClient documentCategoryManagementClient = new DocumentCategoryManagementClient();
        LanguageClient languageClient = new LanguageClient();
        PaymentFrequencyLabelManagementClient paymentFrequencyLabelManagementClient = new PaymentFrequencyLabelManagementClient();
        PersonNatureLabelManagementClient personNatureLabelManagementClient = new PersonNatureLabelManagementClient();
        ProductCalculationTypeLabelManagementClient productCalculationTypeLabelManagementClient = new ProductCalculationTypeLabelManagementClient();
        ProductCategoryManagementClient productCategoryManagementClient = new ProductCategoryManagementClient();

        //providerManagementClient.readAll();
        //providerManagementClient.save();

        //countryClient.readAll();
        //countryClient.save();

        //documentCategoryManagementClient.readAll();
        //documentCategoryManagementClient.save();

        //languageClient.readAll();
        //languageClient.save();

        //paymentFrequencyLabelManagementClient.readAll();
        //paymentFrequencyLabelManagementClient.save();

        //personNatureLabelManagementClient.readAll();
        //personNatureLabelManagementClient.save();

        //productCalculationTypeLabelManagementClient.readAll();
        //productCalculationTypeLabelManagementClient.save();

        //productCategoryManagementClient.readAll();
        //productCategoryManagementClient.save();
    }

    private static final String URL = "http://localhost:18080/easi-api/api/";

    protected void readAll() {

        try {
            System.out.println("Response: " +
                    DigitalHttpUtility.handleRequest(
                            getReadAllRequest()
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void save() {

        try {
            System.out.println("Response: " +
                    DigitalHttpUtility.handleRequest(
                            getSaveRequest()
                    ));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected HttpRequest getSaveRequest() {

        return HttpRequest.getJSONHttpRequest(HttpRequest.VERB_POST,
                URL + getEndpoint(),
                getJSON());
    }

    protected HttpRequest getReadAllRequest() {

        return HttpRequest.getJSONHttpRequest(HttpRequest.VERB_GET,
                URL + getEndpoint(),
                null);
    }

    protected abstract String getJSON();

    protected abstract String getEndpoint();
}
