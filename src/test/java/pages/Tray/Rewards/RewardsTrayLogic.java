package pages.Tray.Rewards;

import org.testng.Assert;
import org.testng.SkipException;
import testdata.ReadResponse;

import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RewardsTrayLogic extends RewardsPO {

    public RewardsTrayLogic() {
        super();
    }


    public void checkVeryMeInRewardsTrayForPAYGMPS() {
        waitForVisibility(DB_veryMeInDashboardTrayDrawer);
        AssertResult(DB_veryMeInDashboardTrayDrawer.getText(), "VeryMe");
    }

    public void checkVeryMeInRewardsTray() {
        if (!(ReadResponse.GetSegment().equalsIgnoreCase("CONSUMER"))) {
            checkVeryMeInRewardsTrayForPAYGMPS();
        } else {
            throw new SkipException("The running user not match with Test case");
        }
    }


    public void checkOffersForYouInRewardsTray() {
        waitForVisibility(DB_OffersForYou_txt);
        AssertResult(DB_OffersForYou_txt.getText(), "Offers for you");
    }

    /*
    public static void checkTopUpRewardsInRewardsTray(){
        waitForVisibility(DB_veryMeInDashboardTrayDrawer);
        DB_veryMeInDashboardTrayDrawer.click();
        waitForVisibility(DB_Lassie);
        Assert.assertTrue(DB_Lassie.isDisplayed());
    }

    public static void checkClickingTopUpRewardsInRewardsTray(){
        System.out.println("Given click on topup reward in reward tray ");
        System.out.println("Wait till the reword icon displayed ");
        waitForVisibility(DB_RewardsDrawer_icon);
        System.out.println("Click on the reward drawer icon");
        DB_RewardsDrawer_icon.click();
        System.out.println("Wait till the offers for you displayed ");
        waitForVisibility(DB_OffersForYou_txt);
        System.out.println("Swipe to topUp Reward drawer ");
        SwipeToElement(DB_OffersForYou_txt,"Left");
        System.out.println("Check   the topup reward drawer");

        if (DB_TopupRewardsDrawer_txt.isDisplayed()){
        System.out.println("Click on the topup Reward Drawer");
        DB_TopupRewardsDrawer_txt.click();
        System.out.println("Wait till point is offer ");
        waitForVisibility(DB_PontisOffer_webview);
        System.out.println("Should the point is offer is displayed as  "+DB_PontisOffer_webview.getText());
        AssertResult(DB_PontisOffer_webview.getText(),"Spend top up rewards");
        }
        else {
            System.out.println("The Top up offer not displayed in the Reward Try  ");
        }
    }

     */


    public void checkClickingVeryMeInRewardsTrayForPAYGMPS() {
        clickVeryMeInDBTray();
        assertDBLassie();
        driver.navigate().back();
    }

    public void assertDBLassie() {
        waitForVisibility(DB_Lassie);
        Assert.assertTrue(DB_Lassie.isDisplayed());
    }

    public void clickVeryMeInDBTray() {
        waitForVisibility(DB_veryMeInDashboardTrayDrawer);
        DB_veryMeInDashboardTrayDrawer.click();
    }

    public void checkClickingVeryMeInRewardsTray() {
        if (!(ReadResponse.GetSegment().equalsIgnoreCase("CONSUMER") && ReadResponse.GetSubscriptionType().equalsIgnoreCase("MPS"))) {
            checkClickingVeryMeInRewardsTrayForPAYGMPS();
        } else {
            throw new SkipException("The running user not match with Test case");
        }
    }

    public void checkClickingOffersForYou() {
        clickOnOffersForYou();
        if (ReadResponse.GetSegment().equalsIgnoreCase("PREPAY"))
            assertPontisOffer();
        else {
            assertLoginScreen();
            Login_Xicon.click();
        }
        driver.navigate().back();
    }

    public void assertPontisOffer() {
        waitForVisibility(DB_PontisOffer_webview);
        AssertResult(DB_PontisOffer_webview.getText(), "Offers for you");
    }

    public void clickOnOffersForYou() {
        waitForVisibility(DB_OffersForYou_txt);
        DB_OffersForYou_txt.click();
    }

    public void checkClickingOffersForYouForPAYMMBB() {
        clickOnOffersForYou();
        assertLoginScreen();
        Login_Xicon.click();
    }

    public void assertLoginScreen() {
        waitForVisibility(Login_username);
        Assert.assertTrue(Login_username.isDisplayed());
    }

    public void checkClickingOffersForYouInRewardsTray() {
        if (!(ReadResponse.GetSegment().equalsIgnoreCase("CONSUMER"))) {
            checkClickingOffersForYou();
        } else {
            checkClickingOffersForYouForPAYMMBB();
        }

    }

    public void checkFirstCard() {
        if (!(ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB"))) {
            checkVeryMeInRewardsTray();
        } else {
            checkOffersForYouInRewardsTray();
        }
    }

    public void checkFirstCardCTA() {
        if (!(ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB"))) {
            checkClickingVeryMeInRewardsTray();
        } else {
            checkClickingOffersForYouInRewardsTray();
        }
    }

    public void goToRewardsTray() {
        clickOnRewardsDrawer();
    }

    public void clickOnRewardsDrawer() {
        waitForVisibility(DB_RewardsDrawer_icon);
        DB_RewardsDrawer_icon.click();
    }

    public void checkSecondCard() {
        if (!ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB"))
            checkOffersForYouInRewardsTray();
        else
            System.out.println("The user is MBB");
    }

    public void checkSecondCardCTA() {
        if (!ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB"))
            checkClickingOffersForYou();
        else
            System.out.println("The user is MBB");
    }

}
