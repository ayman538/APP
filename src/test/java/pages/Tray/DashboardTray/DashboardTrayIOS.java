package pages.Tray.DashboardTray;

import org.openqa.selenium.Point;
import utils.SegmentUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.GenericHelpers.CloseCookies;
import static utils.element_helpers.ScrollHelpers.SwipeDownForIOS;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;

public class DashboardTrayIOS extends DashboardTrayAbstract {
Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    private String Segment = "";
    private String SubscriptionType = "";

    public DashboardTrayIOS() {
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
        if(live){
            waitForVisibility(DB_SettingDashboardTray_icon);
            AssertResult(DB_RewardsDrawer_icon.getText(), "Rewards");
        }else {
            waitForVisibility(DB_SettingDashboardTray_icon);
            if (Segment.equalsIgnoreCase("CONSUMER") && SubscriptionType.equalsIgnoreCase("MPS")) {
                AssertResult(DB_VeryMeTray.getText(), "Rewards");
            } else {
                AssertResult(DB_RewardsDrawer_icon.getText(), "Rewards");
            }
        }
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
    public void clickSkipLoginForTobiPrompt() {
        waitForVisibility(DB_TobiTray_PromptSkipLoginCTA);
        DB_TobiTray_PromptSkipLoginCTA.click();
    }

    @Override
    public void clickOnXIconForThePrompt(){
        waitForVisibility(DB_TobiTray_PromptXicon);
        DB_TobiTray_PromptXicon.click();
    }

    @Override
    public void validateTobiChatisOpen() {
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        }
        else {
            System.out.println("Cookies has not been displayed");
        }
        waitForVisibility(TobiChatHeader);
        TobiChatHeader.isDisplayed();
    }

    public void navigateToTobi(){
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        CloseCookies(AcceptCookies);
        waitWithCatch(TobiXIcon);
        AssertDisplayed(TobiXIcon.isDisplayed());
    }
}






