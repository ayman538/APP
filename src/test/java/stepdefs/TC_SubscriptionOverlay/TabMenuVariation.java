package stepdefs.TC_SubscriptionOverlay;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import pages.SubsctionOverlay.TabMenuVariationLogic;

import java.io.IOException;

import static core.Hooks.testAfterLastScenario;
@Deprecated
public class TabMenuVariation {
    TabMenuVariationLogic tabMenuVariationLogic;
    static boolean run = false;

    @Given("Init tabs variation")
    public void beforeClass() throws IOException {
        if (!run) {
            testAfterLastScenario();
            SubscriptionOverlayLogic subsOverLay = new SubscriptionOverlayLogic();
            subsOverLay.navigateToSubsOverLay();
            run = true;
        }
        tabMenuVariationLogic = new TabMenuVariationLogic();
    }

    @Then("Validate Tab Menu Variation")
    public void TC01_ValidateTabMenuVariation() {
        tabMenuVariationLogic.Validate();
    }

}
