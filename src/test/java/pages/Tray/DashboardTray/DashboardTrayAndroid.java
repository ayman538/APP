package pages.Tray.DashboardTray;

import org.openqa.selenium.Point;
import utils.SegmentUtils;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.GenericHelpers.CloseCookies;
import static utils.element_helpers.ScrollHelpers.SwipeDownForIOS;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;

public class DashboardTrayAndroid extends DashboardTrayAbstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    String Segment = "";
    String SubscriptionType = "";

    public DashboardTrayAndroid() {
        super();
        if(!live) {
            Segment = SegmentUtils.GetSegment_Type();
            SubscriptionType = SegmentUtils.GetSegment_subscriptionType();
        }
    }

    @Override
    public void ValidateMyAccount() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertResult(DB_MyAccountTray_icon.getText(), "My Account");
    }

    @Override
    public void ValidateVeyMeOrRewards() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertResult(DB_VeryMeTray.getText(), "Rewards");
    }

    @Override
    public void ValidateBillingOrTopUp() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        if (Segment.equalsIgnoreCase("PREPAY")) {
            AssertResult(DB_TopUpTray_icon.getText(), "Top Up");
        } else {
            AssertResult(DB_BillingTray_icon.getText(), "Billing");
        }
    }

    @Override
    public void ValidateSettings() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertResult(DB_SettingDashboardTray_icon.getText(), "Settings");
    }

    @Override
    public void clickTobiUsingReturningUserWithBioPref() {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        waitForVisibility(DB_TobiTray_BiometricsIcon);
        DB_TobiTray_OfferLoginTitle.isDisplayed();
        DB_TobiTray_OfferLoginDescription.isDisplayed();
        DB_TobiTray_PromptLoginCTA.isDisplayed();
        DB_TobiTray_PromptSkipLoginCTA.isDisplayed();
    }

    @Override
    public void clickOnXIconForThePrompt(){
      waitForVisibility(DB_TobiTray_PromptXicon);
       DB_TobiTray_PromptXicon.click();
    }

    @Override
    public void validateTobiChatisOpen() {

            waitForVisibility(TobiChatTitle);
            TobiChatTitle.isDisplayed();
    }

    @Override
    public void clickSkipLoginForTobiPrompt() {
        waitForVisibility(DB_TobiTray_PromptSkipLoginCTA);
        DB_TobiTray_PromptSkipLoginCTA.click();
    }

    @Override
    public void checkTobi() {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        CloseCookies(AcceptCookies);
        waitWithCatch(TobiXIcon);
        AssertDisplayed(TobiXIcon.isDisplayed());
        checkCloseTobi();
    }

    @Override
    public void checkCloseTobi() {
        waitForVisibility(TobiXIcon);
        TobiXIcon.click();
        try {
            Confirm_TobiXIcon.click();        }
        catch (Exception e){
            System.out.println("Old Tobi is displayed");
        }
        waitForVisibility(DB_TobiTray_icon);
        AssertDisplayed(DB_TobiTray_icon.isDisplayed());
    }

    @Override
    public int GetDashboardTrayYCoordinates() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Point location = DB_TobiTray_icon.getLocation();
        return location.y;
    }

    @Override
    public void validateTobiSwipeDown() {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        waitForVisibility(AcceptCookies);
        AcceptCookies.click();
        waitForVisibility(TobiXIcon);
        SwipeDownForIOS();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    public void navigateToTobi(){
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        CloseCookies(AcceptCookies);
        waitWithCatch(TobiXIcon);
        AssertDisplayed(TobiXIcon.isDisplayed());
    }


}






