package stepdefs.TC_Tray.TC_Settings;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Tray.Settings.AccessibilityAbstractLogic;
import pages.Tray.Settings.AccessibilityAndroidLogic;
import pages.Tray.Settings.AccessibilityIOSLogic;

public class AccessibilityStepDefs {
    AccessibilityAbstractLogic accessibilityAbstractLogic;
    public AccessibilityStepDefs (Config config){
        if (config.isAndroid()) accessibilityAbstractLogic = new AccessibilityAndroidLogic();
        if (config.isIos()) accessibilityAbstractLogic= new AccessibilityIOSLogic();


    }

    @Then("Validate Accessibility Options item")
    public void validateAccessibilityOptionsItem() throws InterruptedException {
        accessibilityAbstractLogic.validateAccessibility();

    }
    @When("click on Accessibility")
    public void clickOnAccessibility() {
        accessibilityAbstractLogic.clickOnAccessibility();
    }

    @Then("Validate Accessibility SSO is opened")
    public void validateAccessibilitySSOIsOpened() throws InterruptedException {
        accessibilityAbstractLogic.validateAccessibilitySSO();

    }


}
