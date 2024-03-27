package pages.DX_IDM.SubsOverlay;

import pages.AcquisitionBoard.AcquisitionBoardLogic;

import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.GenericHelpers.terminateSafariForiOS;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_SubsOverlay_IOS extends DX_IDM_SubsOverlay_Abstract{

    AcquisitionBoardLogic AcqHeader;

    public DX_IDM_SubsOverlay_IOS() {
        super();
        AcqHeader = new AcquisitionBoardLogic();
    }

    public void assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen() {
        validateSpecificSubsOverlayTitleText();
    }

    public void validateSpecificSubsOverlayTitleText() {
        waitForVisibility(DX_IDM_SubsOverlay_HeaderTitle);
        AssertResult(DX_IDM_SubsOverlay_HeaderTitle.getText(), "Hello, friend!");
    }

    public void assertVOXIVisitCTADisplayed() {
        waitForVisibility(DX_IDM_SubsOverlay_VisitButton);
        AssertDisplayed(DX_IDM_SubsOverlay_VisitButton.isDisplayed());
    }

    public void clickOnVOXIVisitCTA() {
     DX_IDM_SubsOverlay_VisitButton.click();
//     waitForVisibility(AcceptCookies);
//     AcceptCookies.click();

    }

    public void  validateVOXIVisitCTA() {

//     System.out.println("User Should redirect to VOXI user web Portal Successfully");

    }

    public void clickOnXIconOnVOXIWebPortal() {
    }

    public void validateAcquisitionDashboardDisplayed() {
        AcqHeader.checkAcquisitionHeader();
    }


    public void assertReturnToMyVodafoneCTADisplayed() {
        waitForVisibility(DX_IDM_SubsOverlay_ReturnToMyVodafoneButton);
        AssertDisplayed(DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.isDisplayed());
    }

    public void clickOnReturnToMyVodafoneCTA() {
        DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.click();
    }

    public void validateReturnToMyVodafoneCTA() {
        AcqHeader.checkAcquisitionHeader();
    }

    public void assertSubsOverlayXICONDisplayed() {
        AssertDisplayed(DX_IDM_SubsOverlay_CloseIcon.isDisplayed());

    }

    public void clickOnSubsOverlayXIcon() {
        DX_IDM_SubsOverlay_CloseIcon.click();

    }

    public void assertUnknownSubsOverlayLoginCTADisplayed() {
        AssertDisplayed(DX_IDM_UnKnownLoginButton.isDisplayed());
    }

    public void clickOnUnKnownSubsOverlayLoginCTA() {
        DX_IDM_UnKnownLoginButton.click();
    }

    public void validateUnKnownSubsOverlayLoginCTA() {
        AssertResult(DX_IDM_LoginTitle.getText(), "Login to my Vodafone");

    }

    public void acceptCookies(){
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
    }

    @Override
    public void pressPhysicalBackonWebPortal() {
//        navigateBackForiOS();
        terminateSafariForiOS();
        openDeepLinkForiOS("myvodafone://basicdashboardoverlay");
    }
}
