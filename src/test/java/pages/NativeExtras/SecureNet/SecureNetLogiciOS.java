package pages.NativeExtras.SecureNet;

import models.response.NativeExtrasResponseModelAnalyticsVersion;
import utils.NativeExtrasUtils;
import utils.element_helpers.ScrollHelpers;
import utils.element_helpers.VerifyHelpers;

import java.util.ArrayList;

public class SecureNetLogiciOS extends SecureNetLogicAbstract{
    NativeExtrasResponseModelAnalyticsVersion nativeExtrasResponseModelAnalyticsVersion = NativeExtrasUtils.getNativeExtrasResponseModelAnalyticsVersion();
    ArrayList<NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveExtras = nativeExtrasResponseModelAnalyticsVersion.activeProducts.activeProductsDetails;

    public void scrollToSecureNetExtraExists(){
        for (NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail actualActiveExtra : actualActiveExtras) {
            String extraName = actualActiveExtra.name;
            if(extraName.contains("Vodafone Secure Net"))
                ScrollHelpers.androidScrollToElement(ActiveExtrasFindOutMoreCTA,"down");
        }
    }

    public void checkSecureNetExtraUpdated(){
        VerifyHelpers.assertEquals(manageSecureNetCTA.getText(),"Manage in the Secure Net App");
        VerifyHelpers.assertElementDoesNotExist(ActiveExtrasDate);
        VerifyHelpers.assertElementDoesNotExist(ActiveExtrasPrice);
        VerifyHelpers.assertElementDoesNotExist(ActiveExtrasType);
    }

    public void checkSecureNetExtraUpdatedDescription(){
        ActiveExtrasFindOutMoreCTA.click();
        VerifyHelpers.assertEquals(ActiveExtrasDescription.getText(),"You are benefiting from online protection, 24/7 ID monitoring and advanced parental controls for just £1.10 / month. You can choose to cancel anytime");
    }
}
