package stepdefs.TC_Dashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import pages.Dashboard.VeryMe.VeryMeTitleCTALogic;

import java.io.IOException;

import static core.Hooks.testAfterLastScenario;

@Deprecated
public class VeryMeTitleCTA {

    VeryMeTitleCTALogic veryMeTitleCTALogic;
    static boolean closed = false;
    static boolean navigatedToDashboard = false;

    @Given("Init VeryMeTitleCTA")
    public void beforeClass() throws IOException {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        veryMeTitleCTALogic = new VeryMeTitleCTALogic();
        if (!closed) {
            veryMeTitleCTALogic.SetBeforeClass();
            closed = true;
        }
    }

    @Then("Validate VeryMe Title And CTA is Displayed")
    public void TC01_ValidateVeryMeTitleAndCTADisplayed() {
        veryMeTitleCTALogic.ValidateVeryMeTitleAndCTADisplayed();
    }

    @Then("Validate VeryMe Title And CTA is opened")
    public void TC02_ValidateVeryMeViewAllCTAFunctionality() throws InterruptedException, ParseException {
        veryMeTitleCTALogic.ValidateVeryMeViewAllCTAFunctionality();
    }

}
