package pages.SubsctionOverlay.SubscriptionOverlayHeader;

import org.json.simple.parser.ParseException;
import testdata.ReadResponse;
import testdata.TestData;

import java.util.HashMap;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.SwipeDownForIOS;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class SubscriptionOverlayLogic extends SubscriptionOverlayPO {

    private static String segment = "";
    private static HashMap<String, String> chargesCardContent = null;
    private static String currentBalance = "";
    boolean run = false;

    public SubscriptionOverlayLogic() {
        super();
        if (!run) {
            run = true;
        }
    }

    public void SetBeforeClass() throws ParseException {
        System.out.println("Validate the user segment ");
        segment = ReadResponse.GetSegment();
        if (segment.equalsIgnoreCase("PREPAY")) {
            System.out.println(" if the user segment is PREPAY");
            currentBalance = ReadResponse.GetPAYGBalance();
        } else {
            System.out.println(" Else the user segment is PREPAY");
            chargesCardContent = ReadResponse.GetChargesCard();
        }
    }

    public void navigateToSubsOverLay() {
        System.out.println("Wait till the DB_SettingDashboardTray_icon displayed " + DB_SettingDashboardTray_icon);
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Get the VOV hide CTA ");
        HideVOV(DB_VOVhideCTA);
        System.out.println("Wait till the control tile displayed ");
        waitForVisibility(DB_ControlTile);
        System.out.println(" Click on the control tile ");
        DB_ControlTile.click();
        System.out.println("Wait till the plan tab displayed ");
        //waitForVisibility(SO_MSISDN);
    }

    public void ValidateMSISDN() {
        System.out.println("Given Validate the MSISDN");
        String MSISDN = TestData.GetMSISDN();
        MSISDN = MSISDN.replaceFirst("447", "07");
        System.out.println("Should the MSISDN displayed as " + MSISDN);
        //AssertResult(SO_MSISDN.getText(), MSISDN);
    }

    public void ValidateSubscriptionType() {
        System.out.println("Given Validate the subscription type");
        String segment = ReadResponse.GetSegment();
        String subscriptionType = ReadResponse.GetSubscriptionType();

        if (subscriptionType.equalsIgnoreCase("MBB")) {
            System.out.println("if the user type is MBB");
            System.out.println(" Should the SO Subscription type displayed as " + SO_subscriptionType.getText());
            AssertResult(SO_subscriptionType.getText(), "Mobile Broadband");
        } else if (segment != "PREPAY") {
            System.out.println("else the segment user is PREPAY");
            System.out.println("should the So subscription type displayed as " + SO_subscriptionType.getText());
            AssertResult(SO_subscriptionType.getText(), "Pay monthly");
        } else {
            System.out.println("if the user is not MBB and ");
            System.out.println("should the so subscription type is d");
            AssertResult(SO_subscriptionType.getText(), "Pay as you go");
        }
    }

    public void ValidateSubscriptionIcon() {
        AssertDisplayed(SO_subscriptionIcon.isDisplayed());
    }

    public void ValidatesUpgradeCTA() {
        AssertDisplayed(CheckElementNotExistWithoutScroll(SO_UpgradeCTA));
    }

    public void ValidateXIconDisplayed() {
        AssertDisplayed(SO_Xicon.isDisplayed());
    }

    public void ValidateXIconFunctionality() {
        SO_Xicon.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    public void ValidatesAmount() {
        if (segment.equalsIgnoreCase("PREPAY")) {
            System.out.println("if the user us PREPAY");
            System.out.println("billing tile amount displayed as " + SO_Amount.getText());
            AssertResult(SO_Amount.getText(), currentBalance + "credit spend");
            System.out.println(" The billing tile amount displayed successfully ");

        } else {
            System.out.println("Else the user is PREPAY");
            String amount = chargesCardContent.get("balance");
            amount = amount.replaceAll("Â", "");
            System.out.println("The billing tile amount displayed as " + SO_Amount.getText());
            AssertResult(SO_Amount.getText(), amount + " current spend");
            System.out.println("the billing tile amount displayed successfully");
        }
    }

    public void ValidatesSwipeDown() {
        SwipeDownForIOS();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }
}
