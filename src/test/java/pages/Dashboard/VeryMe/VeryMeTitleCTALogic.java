package pages.Dashboard.VeryMe;

import org.json.simple.parser.ParseException;
import testdata.ReadResponse;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


@Deprecated
public class VeryMeTitleCTALogic extends VeryMeTitleCTAPO {

    private String Subscription_type = "";

    public VeryMeTitleCTALogic() {
        super();
        Subscription_type = ReadResponse.GetSubscriptionType();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }

    public void SetBeforeClass() {
        HideVOV(DB_VOVhideCTA);
    }

    public void ValidateVeryMeViewAllCTAFunctionality() throws InterruptedException, ParseException {
        System.out.println("Given ValidateVeryMeViewAllCTAFunctionality");
        if (!Subscription_type.equalsIgnoreCase("MBB")) {
            viewAllCTANonMBB();
            assertLassieDisplayed();
            lassieCTA();
        } else {
            System.out.println("else the user type is not equal MBB and it's " + Subscription_type);
        }
    }

    public void assertLassieDisplayed() {
        waitForVisibility(DB_Lassie);
        System.out.println("Wait till the lassie displayed ");
        AssertDisplayed(DB_Lassie.isDisplayed());
        System.out.println("should the web page displayed successfully ");
    }

    public void lassieCTA() throws InterruptedException {
        Thread.sleep(4500);
//        Point location = DB_Lassie.getLocation();
//        tapAtt(location.x - 50, location.y);
        DB_Lassie.click();
        waitForVisibility(DB_SettingDashboardTray_icon);
    }

    public void viewAllCTANonMBB() {
        scrollDownTo(DB_CarouselVeryMe_Image);
//        waitForVisibility(DB_ViewAll_CTA);
        DB_ViewAll_CTA.click();
    }

    public void ValidateVeryMeTitleAndCTADisplayed() {
        System.out.println("Given ValidateVeryMeTitleAndCTADisplayed");
        if (Subscription_type != "MBB") {
            assertVeryMeTitleTextNonMBB();
            System.out.println("the VeryMe title will be displayed successfully " + DB_VeryMe_Title.getText());
            assertViewAllCTAText();
        } else {
            assertVeryMeTitleDisplayedMBB();
        }
    }

    public void assertVeryMeTitleDisplayedMBB() {
        System.out.println("else the user type is not equal MBB and it's " + DB_VeryMe_Title.getText());
        AssertDisplayed(CheckElementNotExist(DB_VeryMe_Title));
        System.out.println("Check the very me title not exist ");
    }

    public void assertViewAllCTAText() {
        AssertResult(DB_ViewAll_CTA.getText(), "View all");
        System.out.println("The BD view all CTA displayed successfully " + DB_ViewAll_CTA.getText());
    }

    public void assertVeryMeTitleTextNonMBB() {
        System.out.println("if the user type is not equal MBB and it's " + Subscription_type);
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("wait till the DB logo displayed" + DB_VFLogo);
        System.out.println("Hide the VOV");
        scrollDownTo(DB_CarouselVeryMe_Image);
        System.out.println("scroll to the Very me title and that will be displayed " + DB_CarouselVeryMe_Image);
        AssertResult(DB_VeryMe_Title.getText(), "VeryMe Rewards");
    }
}
