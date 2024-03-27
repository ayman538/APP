package pages.Tray.Rewards;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RewardsLogic extends RewardsPO {

    public RewardsLogic() {
        super();
    }

    public void checkVeryMeInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_veryMeInDashboardTrayDrawer));
        AssertResult(DB_veryMeInDashboardTrayDrawer.getText(), "VeryMe");
    }

    public void checkOffersForYouInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_OffersForYou_txt));
        AssertResult(DB_OffersForYou_txt.getText(), "Offers for you");
    }

    public void checkTopUpRewardsInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_OffersForYou_txt));
        SwipeToElement(DB_OffersForYou_txt, "Left");
        waitForVisibility((DB_TopupRewardsDrawer_txt));
        AssertResult(DB_TopupRewardsDrawer_txt.getText(), "Topup Rewards");
    }

    public void checkClickingVeryMeInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_veryMeInDashboardTrayDrawer));
        DB_veryMeInDashboardTrayDrawer.click();
        waitForVisibility((DB_Lassie));
        Assert.assertTrue(DB_Lassie.isDisplayed());
    }

    public void checkClickingOffersForYouInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_OffersForYou_txt));
        DB_OffersForYou_txt.click();
        waitForVisibility((DB_PontisOffer_webview));
        AssertResult(DB_PontisOffer_webview.getText(), "Offers for you");
    }

    public void checkClickingTopUpRewardsInRewardsTray() {
        waitForVisibility((DB_RewardsDrawer_icon));
        DB_RewardsDrawer_icon.click();
        waitForVisibility((DB_OffersForYou_txt));
        SwipeToElement(DB_OffersForYou_txt, "Left");
        waitForVisibility((DB_TopupRewardsDrawer_txt));
        DB_TopupRewardsDrawer_txt.click();
        waitForVisibility((DB_PontisOffer_webview));
        AssertResult(DB_PontisOffer_webview.getText(), "Spend top up rewards");
    }

    public void checkSecondCard() {
        checkOffersForYouInRewardsTray();
    }

    public void checkThirdCard() {
        checkTopUpRewardsInRewardsTray();
    }
}
