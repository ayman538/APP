package pages.OnePlatform_CVM_OverlayScreens;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class CVM_OverlayAndroidLogic extends CVM_OverlayAbstractLogic{


    @Override
    public void ValidateCVMOverlayIsDisplayedForVoxiUser(){
      waitForVisibility(CVM_OverlayHeaderTXT);
      AssertDisplayed(CVM_OverlayHeaderTXT.isDisplayed());
      AssertDisplayed(CVM_OverlayXClose.isDisplayed());
      AssertDisplayed(CVM_OverlayImage.isDisplayed());
      AssertDisplayed(CVM_OverlaySecondaryTXT.isDisplayed());
      AssertDisplayed(CVM_OverlayPrimarybtn.isDisplayed());
      AssertDisplayed(CVM_OverlaySecondarybtn.isDisplayed());
      CVM_OverlayPrimarybtn.click();
      AssertDisplayed(Voxi_Webview.isDisplayed());
      System.out.println("testing for Voxi is done successfully");

    }

    @Override
    public void ValidateCVMOverlayIsDisplayedForHeritageUser() {
        waitForVisibility(CVM_OverlayHeaderTXT);
        AssertDisplayed(CVM_OverlayHeaderTXT.isDisplayed());
        AssertDisplayed(CVM_OverlayXClose.isDisplayed());
        AssertDisplayed(CVM_OverlayImage.isDisplayed());
        AssertDisplayed(CVM_OverlaySecondaryTXT.isDisplayed());
        AssertDisplayed(CVM_OverlayPrimarybtn.isDisplayed());
        CVM_OverlayPrimarybtn.click();
        AssertDisplayed(AcquisitionScreen_Header.isDisplayed());
        System.out.println("testing for Heritage user is done successfully");

    }

    @Override
    public void ValidateCVMOverlayIsDisplayedForNonVFUser() {
        waitForVisibility(CVM_OverlayHeaderTXT);
        AssertDisplayed(CVM_OverlayHeaderTXT.isDisplayed());
        AssertDisplayed(CVM_OverlayXClose.isDisplayed());
        AssertDisplayed(CVM_OverlayImage.isDisplayed());
        AssertDisplayed(CVM_OverlaySecondaryTXT.isDisplayed());
        AssertDisplayed(CVM_OverlayPrimarybtn.isDisplayed());
        AssertDisplayed(CVM_OverlaySecondarybtn.isDisplayed());
        AssertDisplayed(LoginScreen_Header.isDisplayed());
    }

}


