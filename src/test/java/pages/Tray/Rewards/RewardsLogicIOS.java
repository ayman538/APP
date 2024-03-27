package pages.Tray.Rewards;

import models.response.SegmentResponseModel;
import org.testng.Assert;
import utils.SegmentUtils;

import static utils.element_helpers.GenericHelpers.navigateBackForiOS;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RewardsLogicIOS extends RewardsAbstract{
    public RewardsLogicIOS(){
        super();
    }

    SegmentResponseModel segment= SegmentUtils.GetSegment();

    public void checkVeryMeInRewardsTrayForPAYGMPS() {
        waitForVisibility(DB_veryMeInDashboardTrayDrawer);
        AssertResult(DB_veryMeInDashboardTrayDrawer.getText(), "VeryMe");
    }

    public void checkOffersForYouInRewardsTray() {
        waitForVisibility(DB_OffersForYou_txt);
        AssertResult(DB_OffersForYou_txt.getText(), "Offers for you");
    }

    public void checkVeryMeInRewards() throws InterruptedException {
        assertDBLassie();
        navigateBackForiOS();
    }

    public void assertDBLassie() throws InterruptedException {
        Thread.sleep(4000);
        waitForVisibility(DB_Lassie);
        Assert.assertTrue(DB_Lassie.isDisplayed());
    }

    public void clickVeryMeInDBTray() {
        waitForVisibility(DB_veryMeInDashboardTrayDrawer);
        DB_veryMeInDashboardTrayDrawer.click();
    }

    public void checkClickingOffersForYou() {
        if (segment.segment.equalsIgnoreCase("PREPAY"))
            assertPontisOffer();
        else {
            assertLoginScreen();
            //Login_Xicon.click();
        }
        navigateBackForiOS();
    }

    public void assertPontisOffer() {
        waitForVisibility(DB_PontisOffer_webview);
        AssertResult(DB_PontisOffer_webview.getText(), "Offers for you");
    }

    public void clickOnOffersForYou() {
        waitForVisibility(DB_OffersForYou_txt);
        DB_OffersForYou_txt.click();
    }

    public void assertLoginScreen() {
        waitForVisibility(DX_IDM_X_Button);
        AssertDisplayed(DX_IDM_X_Button.isDisplayed());
    }

    public void goToRewardsTray() {
        clickOnRewardsDrawer();
    }

    public void clickOnRewardsDrawer() {
        waitForVisibility(DB_RewardsDrawer_icon);
        DB_RewardsDrawer_icon.click();
    }
}
