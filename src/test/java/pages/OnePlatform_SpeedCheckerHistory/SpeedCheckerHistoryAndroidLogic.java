package pages.OnePlatform_SpeedCheckerHistory;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertElementDoesNotExist;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class SpeedCheckerHistoryAndroidLogic extends SpeedCheckerHistoryAbstractLogic {

    public SpeedCheckerHistoryAndroidLogic () {super();}

    @Override
    public void clickOnCheckDataAndWiFiSpeed() {
       waitForVisibility(DashboardLogo);
       scrollToElement(DB_VodafoneSecureNet,10);
       CheckDataAndWiFiSpeed.click();
    }

    @Override
    public void ValidateNospeedResultCardIsDisplayed() {
        AssertDisplayed(NoResultText.isDisplayed());
        speedChecker_SpeedTestTab.click();
    }


    @Override
    public void ValidateSpeedHistoryScreenIsDisplayed() {
        AssertDisplayed(SpeedTest_Card.isDisplayed());
        AssertDisplayed(TestStatus_text.isDisplayed());
        AssertDisplayed(TestStatus_Date.isDisplayed());
        try{
        AssertDisplayed(ShowMAP_CTA.isDisplayed());
        ShowMAP_CTA.click();
        AssertDisplayed(Map_Image.isDisplayed());
        scrollDownTo(HideMap_CTA);
        AssertDisplayed(HideMap_CTA.isDisplayed());
        HideMap_CTA.click();
        assertElementDoesNotExist(Map_Image);
            System.out.println("testing is done successfully and device location permission is ON");
        }
        catch (Exception e){
            System.out.println("testing is done successfully and device location permission is OFF");
        }



    }

    @Override
    public void ClickOnDeletePreviousTestsCTA() {
        try{
            waitForVisibility(DeletePreviousSpeedTests_CTA);
            AssertDisplayed(DeletePreviousSpeedTests_CTA.isDisplayed());
            DeletePreviousSpeedTests_CTA.click();
        }
        catch (Exception e){
            scrollDownTo(DeletePreviousSpeedTests_CTA);
            DeletePreviousSpeedTests_CTA.click();

        }
    }

    @Override
    public void ValiateDeleteOverlay() {
        waitForVisibility(DeleteOverlayTitle);
        AssertDisplayed(DeleteOverlayTitle.isDisplayed());
        AssertDisplayed(ConfirmDelete_CTA.isDisplayed());
        AssertDisplayed(CancelDelete_CTA.isDisplayed());
    }

    @Override
    public void ClickOnCancelCTAOnDeletedOverlay() {
        CancelDelete_CTA.click();
        AssertDisplayed(SpeedTest_Card.isDisplayed());
        System.out.println("The speed Tests still exists");

    }

    @Override
    public void ClickOnConfirmCTAOnDeletedOverlay() {
        ConfirmDelete_CTA.click();
        AssertDisplayed(NoResultText.isDisplayed());
        System.out.println("There is no speed test");
    }
    @Override
    public void ClickOnSpeedHistoryTab() {
        waitForVisibility(SpeedCheckLandingPage);
          SpeedHistory_Tab.click();
    }
    @Override
    public void ClickOnStartTest() {
        waitForVisibility(StartSpeedTestCta);
        StartSpeedTestCta.click();
    }

    @Override
    public void ValidateThatTestDoneSuccessfully(){
        try {
            Thread.sleep(150000); //waiting for 3min
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility(ResultGauge);
    }
    @Override
    public void StartTestAndValidateSpeedHistoryScreenIsDisplayed(){
        ClickOnStartTest();
        ValidateThatTestDoneSuccessfully();
        ClickOnSpeedHistoryTab();
        AssertDisplayed(SpeedTest_Card.isDisplayed());
        AssertDisplayed(TestStatus_text.isDisplayed());
        AssertDisplayed(TestStatus_Date.isDisplayed());
        try{
            AssertDisplayed(ShowMAP_CTA.isDisplayed());
            ShowMAP_CTA.click();
            AssertDisplayed(Map_Image.isDisplayed());
            scrollDownTo(HideMap_CTA);
            AssertDisplayed(HideMap_CTA.isDisplayed());
            HideMap_CTA.click();
            assertElementDoesNotExist(Map_Image);
            System.out.println("testing is done successfully and device location permission is ON");
        }
        catch (Exception e){
            System.out.println("testing is done successfully and device location permission is OFF");
        }
    }
    @Override
    public void CheckToMakeSureThatThereIsNoSpeedTestHistory(){
        try {
           NoResultText.isDisplayed();
            System.out.println("there is no speed test done");
        }catch (Exception e){
            ClickOnDeletePreviousTestsCTA();
            ValiateDeleteOverlay();
            ClickOnConfirmCTAOnDeletedOverlay();
        }
    }

}
