/*package pages.SubsctionOverlay.ExtrasTab;

import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import testdata.ReadResponse;

import java.util.HashMap;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class ExtrasLogic extends ExtrasPO {

    private static SubscriptionOverlayLogic subscriptionOverlayLogic;

    public ExtrasLogic() {
        super();
        subscriptionOverlayLogic = new SubscriptionOverlayLogic();
    }

    public void navigateToExtras() {
        navigateToSubsOverlay();
        ExtrasCTA();
    }

    public void ExtrasCTA() {
        System.out.println("Swipe to Extras tab");
        SwipeToElement(SO_ExtrasTab, "Left");
        System.out.println("Click  Extras Tab");
        SO_ExtrasTab.click();
        System.out.println("Wait till the Extras tab displayed ");
        waitForVisibility(Extras_TabContainer);
    }

    public void navigateToSubsOverlay() {
        System.out.println("Navigate to the extras screen ");
        subscriptionOverlayLogic.navigateToSubsOverLay();
    }

    public void checkExtrasBarsCapsCard() {
        assertExtrasBarsCapsTitleText();
    }

    public void assertExtrasBarsCapsTitleText() {
        System.out.println("Given Check the Extras Bars Card");
        System.out.println("Scroll down to Extras bar Title ");
        scrollDownTo(Extras_ExtrasBarsCapsTitle);
        System.out.println("Should the Extras bar title displayed as " + Extras_ExtrasBarsCapsTitle.getText());
        AssertResult(Extras_ExtrasBarsCapsTitle.getText(), "Your extras, bars and caps");
    }

    public void checkAllowanceCard() {
        assertMyExtraAllowanceTitleText();
    }

    public void assertMyExtraAllowanceTitleText() {
        System.out.println("Given Check Allowance card");
        System.out.println("Wait till the my extra Allowance title  displayed ");
        waitForVisibility(Extras_MyExtraAllowencesTitle);
        System.out.println("Should the My Extras Allawences title displayed as " + Extras_MyExtraAllowencesTitle.getText());
        AssertResult(Extras_MyExtraAllowencesTitle.getText(), "My extra allowances");
    }

    public void checkBuyManageExtrasBtn() {
        assertBuyManageExtrasCTAText();
    }

    public void assertBuyManageExtrasCTAText() {
        System.out.println("Given check Buy Manage extras CTA");
        System.out.println("Scroll down to Buy mange extras CTA");
        scrollDownTo(Extras_BuyManageExtrasCTA);
        System.out.println("Assert the Buy manger extras CTA displayed as " + Extras_BuyManageExtrasCTA.getText());
        AssertResult(Extras_BuyManageExtrasCTA.getText(), "Manage Bars and Extras");
    }

    public void checkAllowances() {
        System.out.println("Given Check the Allowance displayed ");
        System.out.println("Wait till Extras allowance title displayed ");
        waitForVisibility(Extras_MyExtraAllowencesTitle);
        assertAllowancesDisplayed();
    }

    public void assertAllowancesDisplayed() {
        HashMap<String, String> extraAllowances = ReadResponse.GetExtraAllowances();
        for (String extraAllowance : extraAllowances.values()) {
            try {
                System.out.println("Should the extras allow displayed  ");
                AssertDisplayed(driver.findElementByXPath(GetXpath(extraAllowance)).isDisplayed());
            } catch (Exception e) {
                System.out.println("Couldn't find " + extraAllowance + " element");
            }
        }
    }

    public void checkExtras() {
        System.out.println("Given Check the Extras");
        System.out.println("Scroll down till the extras Bard title displayed ");
        scrollDownTo(Extras_ExtrasBarsCapsTitle);
        assertExtrasDisplayed();
    }

    public void assertExtrasDisplayed() {
        HashMap<String, String> extras = ReadResponse.GetExtras();
        for (String extra : extras.values()) {
            try {
                System.out.println("Should the Extras value displayed ");
                AssertDisplayed(driver.findElementByXPath(GetXpath(extra)).isDisplayed());
            } catch (Exception e) {
                System.out.println("Couldn't find " + extra + " element");
            }
        }
    }

    public void checkClickingAllowance() {
        System.out.println("Given click on Allowance");
        System.out.println("Wait My Extra Allowance title displayed ");
        waitForVisibility(Extras_MyExtraAllowencesTitle);
        assertAllowancesText();
        generalBackButtonCTA();
    }

    public void generalBackButtonCTA() {
        GeneralBackIcon.click();
        System.out.println("Click on the BackBtn behavior ");
        System.out.println("Wait till the Extras Tab Container displayed  ");
        waitForVisibility(Extras_TabContainer);
    }

    public void assertAllowancesText() {
        HashMap<String, String> extraAllowances = ReadResponse.GetExtraAllowances();
        for (String extraAllowance : extraAllowances.values()) {
            try {
                System.out.println("Click on extras Allowance");
                driver.findElementByXPath(GetXpath(extraAllowance)).click();
                System.out.println("Wait till the extra allowance displayed ");
                waitForVisibility(driver.findElementByXPath(GetXpath(extraAllowance)));
                System.out.println("Should the extras Allowance displayed successfully as  " + driver.findElementByXPath(GetXpath(extraAllowance)).getText());
                AssertResult(driver.findElementByXPath(GetXpath(extraAllowance)).getText(), extraAllowance);
                System.out.println("Click on the BackBtn behavior ");
            } catch (Exception e) {
                System.out.println("Couldn't find " + extraAllowance + " element");
            }
        }
    }

    public void checkClickingExtras() {
        System.out.println("Given clicking Extras");
        System.out.println("Scroll down till extras bars title displayed ");
        scrollDownTo(Extras_ExtrasBarsCapsTitle);
        assertExtrasText();
        generalBackButtonCTA();
    }

    public void assertExtrasText() {
        HashMap<String, String> extras = ReadResponse.GetExtras();
        for (String extra : extras.values()) {
            try {
                System.out.println("Click on Extras ");
                driver.findElementByXPath(GetXpath(extra)).click();
                System.out.println("Wait till the extras displayed  ");
                waitForVisibility(driver.findElementByXPath(GetXpath(extra)));
                System.out.println("Should the extras displayed successfully as " + driver.findElementByXPath(GetXpath(extra)).getText());
                AssertResult(driver.findElementByXPath(GetXpath(extra)).getText(), extra);

            } catch (Exception e) {
                System.out.println("Couldn't find " + extra + " element");
            }
        }
    }

    public void ValidateSwipeBack() {
        Extras_MyExtraAllowencesArrow.click();
        SwipeBackForIOS();
        assertExtraTebDisplayed();
    }

    public void assertExtraTebDisplayed() {
        waitForVisibility(SO_ExtrasTab);
        AssertDisplayed(SO_ExtrasTab.isDisplayed());
    }

}

 */
