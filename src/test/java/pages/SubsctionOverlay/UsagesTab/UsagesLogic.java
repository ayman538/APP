/*package pages.SubsctionOverlay.UsagesTab;

import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import testdata.ReadResponse;

import java.util.HashMap;

import static core.Config.getPlatformType;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class UsagesLogic extends UsagesPO {
    private final SubscriptionOverlayLogic subscriptionOverlayLogic;

    public UsagesLogic() {
        super();
        subscriptionOverlayLogic = new SubscriptionOverlayLogic();
    }

    public void navigateToUsage() {
        subscriptionOverlayLogic.navigateToSubsOverLay();
        clickOnUsagesTab();
    }

    public void checkUsagePlan() {
        HashMap<String, String> usagePlans = ReadResponse.GetUsageAPIPlanResponse();
        for (String usagePlan : usagePlans.values()) {
            try {
                assertUsagePlanTextAndroid(usagePlan);
            } catch (Exception e) {
                if (getPlatformType().equalsIgnoreCase("IOS")) {
                    assertUsagePlanTextIOS(usagePlan);
                }
                System.out.println("Couldn't find " + usagePlan + " element");
            }
        }
    }

    public void assertTextIOS(String text) {
        scrollDownTo(driver.findElementByXPath(GetXpath(text)));
        AssertResult(driver.findElementByXPath(GetXpath(text)).getText(), text);
    }

    public void assertUsagePlanTextIOS(String text) {
        assertTextIOS(text);
    }

    public void assertTextAndroid(String text) {
        scrollDownTo(driver.findElementByXPath(GetXpath(text)));
        AssertResult(driver.findElementByXPath(GetXpath(text)).getText(), text);
    }

    public void assertUsagePlanTextAndroid(String text) {
        assertTextAndroid(text);
    }

    public void checkPressingViewPlanBtn() {
        createViewPlanBVBCTAString();
        assertPlanTabContentDisplayed();
        clickOnUsagesTab();
    }

    public void createViewPlanBVBCTAString() {
        HashMap<String, String> usagePlans = ReadResponse.GetUsageAPIPlanResponse();
        String viewPlanBtnText = usagePlans.get(Integer.toString(usagePlans.size()));
        viewPlanBVBCTA(viewPlanBtnText);
    }

    public void assertPlanTabContentDisplayed() {
        try {
            AssertDisplayed(Plan_TabContent.isDisplayed());
        } catch (Exception e) {
            System.out.println("Assertion failed");
        }
    }

    public void clickOnUsagesTab() {
        SO_UsageTab.click();
    }

    public void checkUsageRecurringExtras() {
        HashMap<String, String> usageRecurringExtras = ReadResponse.GetUsageAPIRecurringExtrasResponse();
        for (String usageRecurringExtra : usageRecurringExtras.values()) {
            try {
                assertUsageRecurringExtraTextAndroid(usageRecurringExtra);
            } catch (Exception e) {
                if (getPlatformType().equalsIgnoreCase("IOS")) {
                    assertUsageRecurringExtraTextIOS(usageRecurringExtra);
                }
                System.out.println("Couldn't find " + usageRecurringExtra + " element");
            }
        }
    }

    public void assertUsageRecurringExtraTextIOS(String text) {
        assertTextIOS(text);
    }

    public void assertUsageRecurringExtraTextAndroid(String text) {
        assertTextAndroid(text);
    }

    public void checkPressingManageExtrasBtn() throws InterruptedException {
        manageExtrasCTA();
        assertExtrasTabContainerDisplayed();
        clickOnUsagesTab();
    }

    public void assertExtrasTabContainerDisplayed() {
        try {
            AssertDisplayed(Extras_TabContainer.isDisplayed());
        } catch (Exception e) {
            System.out.println("Assertion failed");
        }
    }

    public void manageExtrasCTA() throws InterruptedException {
        HashMap<String, String> usageRecurringExtras = ReadResponse.GetUsageAPIRecurringExtrasResponse();
        String ManageExtrasBtnText = usageRecurringExtras.get(Integer.toString(usageRecurringExtras.size()));
        Thread.sleep(3000);
        scrollDown();
        scrollDown();
        System.out.println(driver.findElementByXPath(GetXpath(ManageExtrasBtnText)));
        waitForVisibility(driver.findElementByXPath(GetXpath(ManageExtrasBtnText)));
        scrollDownTo(driver.findElementByXPath(GetXpath(ManageExtrasBtnText)));
        driver.findElementByXPath(GetXpath(ManageExtrasBtnText)).click();
        waitForVisibility(Extras_TabContainer);
    }

    public void checkUsageBVB() {
        HashMap<String, String> usageBVBs = ReadResponse.GetUsageAPIBVBResponse();
        for (String usageBVB : usageBVBs.values()) {
            try {
                assertUsageBVBTextAndroid(usageBVB);
            } catch (Exception e) {
                if (getPlatformType().equalsIgnoreCase("IOS")) {
                    assertUsagePlanTextIOS(usageBVB);
                }
                System.out.println("Couldn't find " + usageBVB + " element");
            }
        }
    }

    public void assertUsageBVBTextAndroid(String text) {
        assertTextAndroid(text);
    }

    public void checkPressingViewPlanBVBBtn() {
        InitializePlanBVBCTA();
        assertSOPlanTabContentDisplayed();
        clickOnUsagesTab();
    }

    public void assertSOPlanTabContentDisplayed() {
        try {
            scrollDownTo(Plan_TabContent);
            AssertDisplayed(Plan_TabContent.isDisplayed());
        } catch (Exception e) {
            System.out.println("Assertion failed");
        }
    }

    public void InitializePlanBVBCTA() {
        HashMap<String, String> usageBVBs = ReadResponse.GetUsageAPIBVBResponse();
        String ViewPlanBVBBtnText = usageBVBs.get(Integer.toString(usageBVBs.size()));
        viewPlanBVBCTA(ViewPlanBVBBtnText);
    }

    public void viewPlanBVBCTA(String viewPlanBVBBtnText) {
        scrollDownTo(driver.findElementByXPath(GetXpath(viewPlanBVBBtnText)));
        driver.findElementByXPath(GetXpath(viewPlanBVBBtnText)).click();
        waitForVisibility(Plan_TabContent);
    }

    public void checkUsagePAYGSimply() {
        HashMap<String, String> usagePAYGSimplys = ReadResponse.GetUsageAPIBVBResponse();
        for (String usagePAYGSimply : usagePAYGSimplys.values()) {
            try {
                assertUsagePAYGSimplyTextAndroid(usagePAYGSimply);
            } catch (Exception e) {
                System.out.println("Couldn't find " + usagePAYGSimply + " element");
            }
        }
    }

    public void assertUsagePAYGSimplyTextAndroid(String text) {
        assertTextAndroid(text);
    }

    public void checkUsagePAYG1() {
        HashMap<String, String> usagePAYG1s = ReadResponse.GetUsageAPIBVBResponse();
        for (String usagePAYG1 : usagePAYG1s.values()) {
            try {
                assertUsagePAYG1TextAndroid(usagePAYG1);
            } catch (Exception e) {
                System.out.println("Couldn't find " + usagePAYG1 + " element");
            }
        }
    }

    public void assertUsagePAYG1TextAndroid(String text) {
        assertTextAndroid(text);
    }


    public void checkUsageOneTimeExtras() {
        HashMap<String, String> usageOneTimeExtras = ReadResponse.GetUsageAPIOneTimeExtrasResponse();
        for (String usageOneTimeExtra : usageOneTimeExtras.values()) {
            try {
                assertUsageOneTimeExtrasTextAndroid(usageOneTimeExtra);
            } catch (Exception e) {
                System.out.println("Couldn't find " + usageOneTimeExtra + " element");
            }
        }
    }

    public void assertUsageOneTimeExtrasTextAndroid(String text) {
        assertTextAndroid(text);
    }

    public void checkAddExtraBtn() {
        scrollDownTo(US_addExtraCTA);
        AssertDisplayed(US_addExtraCTA.isDisplayed());
    }

    public void checkPressingAddExtraBtn() {
        addExtraCTA();
        assertAdditionalExtrasDisplayed();
        clickOnUsagesTab();
    }

    public void assertAdditionalExtrasDisplayed() {
        try {
            assertExtrasDisplayed();
        } catch (Exception e) {
            System.out.println("Assertion failed");
        }
    }

    public void assertExtrasDisplayed() {
        scrollDownTo(Extras_TabContainer);
        AssertDisplayed(Extras_TabContainer.isDisplayed());
    }

    public void addExtraCTA() {
        scrollDownTo(US_addExtraCTA);
        US_addExtraCTA.click();
        waitForVisibility(Extras_TabContainer);
    }

}
 */