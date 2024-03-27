//package pages.DX_IDM.SubsOverlay;
//
//import pages.AcquisitionBoard.AcquisitionBoardLogic;
//
//public class DX_IDM_SubsOverlayLogic extends DX_IDM_SubsOverlayPO {
//
//    private final boolean navigated = false;
//    AcquisitionBoardLogic AcqHeader;
//
//
//    public DX_IDM_SubsOverlayLogic() {
//        super();
//        AcqHeader = new AcquisitionBoardLogic();
//        AcqHeader.navigateToAcquisitionBoard();
//    }
//
//    public void assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen() {
//        waitForVisibility(DX_IDM_SubsOverlay_HeaderTitle);
//        validateSpecificSubsOverlayTitleText();
//    }
//
//    public void validateSpecificSubsOverlayTitleText() {
//        AssertResult(DX_IDM_SubsOverlay_HeaderTitle.getText(), "Hello, friend!");
//    }
//
//    public void assertVOXIVisitCTADisplayed() {
//
//        AssertDisplayed(DX_IDM_SubsOverlay_VisitButton.isDisplayed());
//    }
//
//    public void clickOnVOXIVisitCTA() {
//        DX_IDM_SubsOverlay_VisitButton.click();
//    }
//
//    public void validateVOXIVisitCTA() {
//
//        System.out.println("User Should redirect to VOXI user web Portal Successfully");
//    }
//
//    public void clickOnXIconOnVOXIWebPortal() {
//    }
//
//    public void validateAcquisitionDashboardDisplayed() {
//        AcqHeader.checkAcquisitionHeader();
//    }
//
//
//    public void assertReturnToMyVodafoneCTADisplayed() {
//        AssertDisplayed(DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.isDisplayed());
//    }
//
//    public void clickOnReturnToMyVodafoneCTA() {
//        DX_IDM_SubsOverlay_ReturnToMyVodafoneButton.click();
//    }
//
//    public void validateReturnToMyVodafoneCTA() {
//        AcqHeader.checkAcquisitionHeader();
//    }
//
//    public void assertSubsOverlayXICONDisplayed() {
//        AssertDisplayed(DX_IDM_SubsOverlay_CloseIcon.isDisplayed());
//
//    }
//
//    public void clickOnSubsOverlayXIcon() {
//        DX_IDM_SubsOverlay_CloseIcon.click();
//
//    }
//
//    public void assertUnknownSubsOverlayLoginCTADisplayed() {
//        AssertDisplayed(DX_IDM_UnKnownLoginButton.isDisplayed());
//    }
//
//    public void clickOnUnKnownSubsOverlayLoginCTA() {
//        DX_IDM_UnKnownLoginButton.click();
//    }
//
//    public void validateUnKnownSubsOverlayLoginCTA() {
//        AssertResult(DX_IDM_LoginTitle.getText(), "Login to my Vodafone");
//
//    }
//}
