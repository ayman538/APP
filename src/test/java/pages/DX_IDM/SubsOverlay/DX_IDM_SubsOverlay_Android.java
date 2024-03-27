package pages.DX_IDM.SubsOverlay;

import pages.AcquisitionBoard.AcquisitionBoardLogic;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DX_IDM_SubsOverlay_Android extends DX_IDM_SubsOverlay_Abstract{


    private final boolean navigated = false;
    AcquisitionBoardLogic AcqHeader;


    public DX_IDM_SubsOverlay_Android() {
        super();
       AcqHeader = new AcquisitionBoardLogic();
//        AcqHeader.navigateToAcquisitionBoard();
    }

    @Override
    public void assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen() {
        validateSpecificSubsOverlayTitleText();
    }

    @Override
    public void validateSpecificSubsOverlayTitleText() {
        AssertResult(DX_IDM_SubsOverlay_HeaderTitle.getText(), "Hello, friend!");
    }

    @Override
    public void assertVOXIVisitCTADisplayed() {

        AssertDisplayed(DX_IDM_SubsOverlay_VisitButton.isDisplayed());
    }

    @Override
    public void clickOnVOXIVisitCTA() {
        DX_IDM_SubsOverlay_VisitButton.click();
    }

    @Override
    public void validateVOXIVisitCTA() {
        AssertDisplayed(WebPortal.isDisplayed());
        System.out.println("User Should redirect to VOXI user web Portal Successfully");
    }

    @Override
    public void pressPhysicalBackonWebPortal() {
        driver.navigate().back();
    }

    @Override
    public void clickOnXIconOnVOXIWebPortal() {
    }

    @Override
    public void validateAcquisitionDashboardDisplayed() {
       // AcqHeader.checkAcquisitionHeader();
        waitForVisibility(DX_IDM_PayMonthly);
        AssertDisplayed(DX_IDM_PayMonthly.isDisplayed());
    }

    @Override
    public void assertReturnToMyVodafoneCTADisplayed() {
        AssertDisplayed(DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.isDisplayed());
    }

    @Override
    public void clickOnReturnToMyVodafoneCTA() {
        DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.click();
    }

    @Override
    public void validateReturnToMyVodafoneCTA() {
        AcqHeader.checkAcquisitionHeader();
    }

    @Override
    public void assertSubsOverlayXICONDisplayed() {
        AssertDisplayed(DX_IDM_SubsOverlay_CloseIcon.isDisplayed());

    }

    @Override
    public void clickOnSubsOverlayXIcon() {
        DX_IDM_SubsOverlay_CloseIcon.click();

    }
    @Override

    public void assertUnknownSubsOverlayLoginCTADisplayed() {
        AssertDisplayed(DX_IDM_UnKnownLoginButton.isDisplayed());
    }

    @Override
    public void clickOnUnKnownSubsOverlayLoginCTA() {
        DX_IDM_UnKnownLoginButton.click();
    }

    @Override
    public void validateUnKnownSubsOverlayLoginCTA() {
        AssertResult(DX_IDM_LoginTitle.getText(), "Log in to My Vodafone");

    }

    @Override
    public void acceptCookies(){
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
    }
}
