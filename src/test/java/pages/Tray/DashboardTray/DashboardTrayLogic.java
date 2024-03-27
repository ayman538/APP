package pages.Tray.DashboardTray;

import org.openqa.selenium.Point;
import testdata.ReadResponse;

import static utils.element_helpers.GenericHelpers.CloseCookies;
import static utils.element_helpers.ScrollHelpers.SwipeDownForIOS;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;

@Deprecated
public class DashboardTrayLogic extends DashboardTrayPO {

    private static boolean openTobi = false;
    private String Segment = "";
    private String SubscriptionType = "";
    private boolean getResponse = false;

    public DashboardTrayLogic() {
        super();
        Segment = ReadResponse.GetSegment();
        SubscriptionType = ReadResponse.GetSubscriptionType();
    }


    public void ValidateMyAccount() {
        GetResponse();
        System.out.println("Given ValidateMyAccount");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("wait till the settings of dashboard displayed on try " + DB_SettingDashboardTray_icon);
        AssertResult(DB_MyAccountTray_icon.getText(), "My Account");
        System.out.println("Should the My account displayed in the try ");
    }

    public void ValidateVeyMeOrRewards() {
        GetResponse();
        System.out.println("Given ValidateVeyMeOrRewards");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Wait till the Setting icon displayed in try ");
        //Thread.sleep(2500);
        if (Segment.equalsIgnoreCase("CONSUMER") && SubscriptionType.equalsIgnoreCase("MPS")) {
            System.out.println("if user segment is equal concumer and equal MPS");
            AssertResult(DB_VeryMeTray.getText(), "VeryMe");
            System.out.println(" Should the Very me tray displayed successfully");
        } else {
            System.out.println(" Else the user  segment is not equal concumer and equal MPS");
            AssertResult(DB_RewardsDrawer_icon.getText(), "Rewards");
            System.out.println(" Should the Reword drawer icon displayed successfully");
        }
    }

    public void ValidateBillingOrTopUp() {
        GetResponse();
        System.out.println("Given the ValidateBillingOrTopUp");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Wait till the setting icon  displayed in the try " + DB_SettingDashboardTray_icon);
        //Thread.sleep(2500);
        if (Segment.equalsIgnoreCase("PREPAY")) {
            System.out.println("if the user segment is equal PREPAY");
            AssertResult(DB_TopUpTray_icon.getText(), "Topup");
            System.out.println("should the topup try title  ");
        } else {
            System.out.println("else the segment is PREPAY");
            AssertResult(DB_BillingTray_icon.getText(), "Billing");
            System.out.println("should the Billing try icon displayed ");
        }
    }

    public void ValidateSettings() {
        System.out.println("Given ValidateSettings ");
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("wait till the setting icon displayed in try " + DB_SettingDashboardTray_icon);
        AssertResult(DB_SettingDashboardTray_icon.getText(), "Settings");
        System.out.println("Should the setting dashboard try icon displayed  ");
    }

    public void GetResponse() {
        if (!getResponse) {
            Segment = ReadResponse.GetSegment();
            SubscriptionType = ReadResponse.GetSubscriptionType();
            getResponse = true;
        }
    }

    public void checkTobi() {
        waitForVisibility(DB_TobiTray_icon);
        DB_TobiTray_icon.click();
        openTobi = true;
        CloseCookies(AcceptCookies);
        waitWithCatch(TobiXIcon);
        AssertDisplayed(TobiXIcon.isDisplayed());
    }

    public void checkCloseTobi() {
        if (!openTobi) {
            waitForVisibility(DB_TobiTray_icon);
            DB_TobiTray_icon.click();
            CloseCookies(AcceptCookies);
            waitWithCatch(TobiXIcon);
        }
        AssertDisplayed(TobiXIcon.isDisplayed());
        TobiXIcon.click();
        waitForVisibility(DB_TobiTray_icon);
        AssertDisplayed(DB_TobiTray_icon.isDisplayed());
    }


    public int GetDashboardTrayYCoordinates() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Point location = DB_TobiTray_icon.getLocation();
        return location.y;
    }

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


}






