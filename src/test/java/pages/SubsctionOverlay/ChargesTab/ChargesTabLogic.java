/*package pages.SubsctionOverlay.ChargesTab;

import core.Config;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import testdata.ReadResponse;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.GenericHelpers.removeDollarSign;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;
@Deprecated
public class ChargesTabLogic extends ChargesTabPO {


    private final Config config = new Config();
    private static HashMap<String, String> additionalChargesDetails = null;
    private static boolean hideVOVStatus = false;
    public String monthlyChargesValue, additionalChargesValue, totalEstimatedChargesValue = null;
    private Login_Abstract login;

    public ChargesTabLogic() {
        super();
    }

    public void setBeforeClass() {
        additionalChargesDetails = ReadResponse.getAdditionalChargesDetails();
        hideVOV();
        billingTileHeaderCTA();
    }

    public void hideVOV() {
        if (!hideVOVStatus) {
            HideVOV(DB_VOVhideCTA);
            hideVOVStatus = true;
        }
    }

    public void billingTileHeaderCTA() {
        DB_billingTileHeader.click();
        System.out.println("There is no Additional Cards for this user");
        waitForVisibility(additionalChargesQuantity);
    }

    public void validateAllowanceChargesDisplayed() {
        additionalChargesChevronCTA();
        assertAdditionalChargesHeaderDisplayed();
        additionalChargesChevron.click();
    }

    public void assertAdditionalChargesHeaderDisplayed() {
        System.out.println("Additional Charges Displayed");
        waitWithCatch(driver.findElementByXPath(GetXpath(additionalChargesDetails.get("header"))));
        AssertDisplayed(driver.findElementByXPath(GetXpath(additionalChargesDetails.get("header"))).isDisplayed());
    }

    public void additionalChargesChevronCTA() {
        waitForVisibility(additionalChargesChevron);
        additionalChargesChevron.click();
    }


    public void noAdditionalCard() {
        System.out.println("additionalChargesQuantity:" + additionalChargesQuantity.getText());
        AssertResult(additionalChargesQuantity.getText(), "£0.00");
    }

    public void ItemizedJourney() throws InterruptedException, IOException {
        additionalChargesChevronCTA();
        additionalChargesHeaderCTA();
        assertLoginTitleDisplayed();
        login();
        detailsChevronCTA();
        assertDetailChevronText();
    }

    public void additionalChargesHeaderCTA() throws InterruptedException {
        String tempString = additionalChargesDetails.get("header");
        Thread.sleep(4000);
        waitForVisibility(driver.findElementByXPath(GetXpath(tempString)));
        driver.findElementByXPath(GetXpath(tempString)).click();
    }

    public void assertLoginTitleDisplayed() {
        waitForVisibility(LoginTitle);
        System.out.println("Validate Itemized with no logged user ");
        AssertDisplayed(LoginTitle.isDisplayed());
        System.out.println("Validate Itemized with Logged user");
    }


    public void login() throws IOException {
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
        try {
            login.LoginFlow();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void detailsChevronCTA() {
        waitForVisibility(detailsChevron);
        detailsChevron.click();
    }

    public void assertDetailChevronText() {
        waitForVisibility(additionalFirstFilter);
        AssertResult(additionalFirstFilter.getText(), "Newest first");
        waitForVisibility(additionalSecondFilter);
        AssertResult(additionalSecondFilter.getText(), "Oldest first");
        waitForVisibility(additionalThirdFilter);
        AssertResult(additionalThirdFilter.getText(), "Highest price first");
        waitForVisibility(additionalFourthFilter);
        AssertResult(additionalFourthFilter.getText(), "Lowest price first");
    }

    public void validateTotalEstimatedCharges() {
        monthlyChargesValue = removeDollarSign(monthlyChargesQuantity.getText());
        additionalChargesValue = removeDollarSign(additionalChargesQuantity.getText());
        BigDecimal result = new BigDecimal(monthlyChargesValue).add(new BigDecimal(additionalChargesValue));
        totalEstimatedChargesValue = removeDollarSign(totalEstimatedChargesQuantity.getText());
        AssertResult(totalEstimatedChargesValue, result.toString());
    }

    public void unBilledChargesListMoreThanSix() {
        scrollDownTo(additionalChargesLoadMoreCTA);
        AssertDisplayed(additionalChargesLoadMoreCTA.isDisplayed());
    }

    public void chargesSSOJourney() {
        scrollDownTo(chargesViewDetails);
        chargesViewDetails.click();
        waitForVisibility(LoginTitle);
        AssertDisplayed(LoginTitle.isDisplayed());
        loginCloseIcon.click();
    }
}

 */