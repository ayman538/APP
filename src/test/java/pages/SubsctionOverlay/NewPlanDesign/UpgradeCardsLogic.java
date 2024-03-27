/*package pages.SubsctionOverlay.NewPlanDesign;

import org.testng.SkipException;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import testdata.ReadResponse;

import java.util.LinkedHashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollUp;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
public class UpgradeCardsLogic extends UpgradeCardsPO {

    static boolean eligibleFlag = false;
    static boolean notEligibleFlag = false;
    static boolean fancyFlag = false;
    static boolean changePlanFlag = false;
    static boolean callUsFlag = false;
    static private SubscriptionOverlayLogic subscriptionOverlayLogic;

    public UpgradeCardsLogic() {
        super();
        subscriptionOverlayLogic = new SubscriptionOverlayLogic();
    }

    public void navigateToPlan() {
        subscriptionOverlayLogic.navigateToSubsOverLay();
    }

    public void ValidateEligibleForUpgradeCard() throws InterruptedException {
        assertEligibleForUpgradeCardText();
        scrollUp();
    }

    public void assertEligibleForUpgradeCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Upgrade eligible")) {
                eligibleFlag = true;
                Thread.sleep(1000);
                waitForVisibility(driver.findElementByXPath(GetXpath((String) mapElement.getValue())));
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!eligibleFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateEligibleForUpgradeCardCTA() {
        assertEligibleForUpgradeCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    public void assertEligibleForUpgradeCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Upgrade eligible")) {
                eligibleFlag = true;
                scrollDownTo((String) mapElement.getValue());
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!eligibleFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void assertLoginXIconDisplayed() {
        waitForVisibility(Login_Xicon);
        AssertDisplayed(Login_Xicon.isDisplayed());
    }

    public void ValidateNotEligibleForUpgradeCard() throws InterruptedException {
        assertNotEligibleForUpgradeCardText();
        scrollUp();
    }

    public void assertNotEligibleForUpgradeCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Upgrade not eligible")) {
                notEligibleFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!notEligibleFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateFancyCard() throws InterruptedException {
        assertFancyCardText();
        scrollUp();
    }

    public void assertFancyCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Fancy")) {
                fancyFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!fancyFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateFancyCardCTA() {
        assertFancyCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    public void LoginXIconCTA() {
        Login_Xicon.click();
        waitForVisibility(SO_PlanTab);
    }

    public void assertFancyCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Fancy")) {
                fancyFlag = true;
                scrollDownTo((String) mapElement.getValue());
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!fancyFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateChangePlanCard() throws InterruptedException {
        assertChangePlanCardText();
        scrollUp();
    }

    public void assertChangePlanCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            System.out.println((String) mapElement.getKey());
            if (((String) mapElement.getKey()).contains("Keep reaching")) {
                changePlanFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!changePlanFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateChangePlanCardCTA() {
        assertChangePlanCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    public void assertChangePlanCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Keep reaching")) {
                changePlanFlag = true;
                scrollDownTo((String) mapElement.getValue());
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!changePlanFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    public void ValidateEligibleForUpgradeCardMBB() throws InterruptedException {
        assertEligibleForUpgradeCardText();
        scrollUp();
    }

    public void ValidateEligibleForCallUsCardCTA() {
        assertEligibleForCallUsCTA();
        AssertDisplayed(NumberOfCallUS.isDisplayed());
        scrollUp();
    }

    private void assertEligibleForCallUsCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Ask an adviser to guide you through our available plans.")) {
                callUsFlag = true;
                scrollDownTo((String) mapElement.getValue());
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                break;
            }
        }
        if (!callUsFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }



}
 */