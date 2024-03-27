package pages.NativeControlsAndLimits.ThankYouTurnOnControls;


import models.response.NativeControlsResponseModelAnalyticsVersion;
import pages.NativeControlsAndLimits.ControlsConfirmBottomSheet.ControlsConfirmBottomSheetAndroid;
import utils.NativeControlsUtils;

import static utils.element_helpers.ActionsHelpers.findElementBytext;
import static utils.element_helpers.ActionsHelpers.findElementElementByDynamicLocatorAndIndex;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.ScrollHelpers.scrollUp;
import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class ControlThankYouBottomSheetIOS extends ControlThankYouBottomSheetAbstract{

    public void CheckControlThankYouBottomSheet(){
        waitForVisibility(RedHybrid_PaymentAddCTA);
        AssertResult(traySuccessNotification.getText(),"Thanks for adding a control");
        AssertDisplayed(RedHybrid_SuccessTik.isDisplayed());
        AssertResult(traySuccessSubNotification.getText(),"It may take up to 6 hours for your control to display in the My Vodafone app.");
        AssertDisplayed(RedHybrid_PaymentAddCTA.isDisplayed());
    }

    public void CheckAddedControlReflectedPending(){
        String controlName = ControlsConfirmBottomSheetAndroid.getControlName();
        NativeControlsResponseModelAnalyticsVersion nativeControlsResponseModelAnalyticsVersion = NativeControlsUtils.getNativeControlsResponseModelAnalyticsVersion();
        for (int i = 0; i <nativeControlsResponseModelAnalyticsVersion.activeProducts.activeProductsDetails.size(); i++){
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(nativeControlsResponseModelAnalyticsVersion.activeProducts.activeProductsDetails.get(i).name)).isDisplayed() )
                scrollUp();
            if(removeHtmlTag(nativeControlsResponseModelAnalyticsVersion.activeProducts.activeProductsDetails.get(i).name).equalsIgnoreCase(controlName)){
                assertEquals(nativeControlsResponseModelAnalyticsVersion.activeProducts.activeProductsDetails.get(i).productStatus, "Pending");
                return;
            }
        }
    }

    public void clickOnTurnOnCTA(){
        waitForVisibility(confirmControlsConfirmCTA);
        confirmControlsConfirmCTA.click();
    }

}
