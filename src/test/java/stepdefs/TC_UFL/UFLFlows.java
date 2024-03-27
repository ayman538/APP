/*package stepdefs.TC_UFL;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.json.simple.parser.ParseException;
import pages.UFL.UFLLogic;

import java.io.IOException;

public class UFLFlows {

    UFLLogic ufl;

    @Given("Init UFL Flow")
    public void BeforeClass() {
        ufl = new UFLLogic();
    }
    //Check app behavior when click on the link (please contact us ) in the footer of  (further security verification requierd)screen


    @Then("Validate Please Contact Us")
    public void pleaseContactUsFlow() throws ParseException, InterruptedException, IOException {
        ufl.pleaseContactUsFlow();
    }

    //Check that "Biometrics FingerPrint" screen will be displayed if device has the FingerPrint feature (Android-iOS)_Functional
    @Then("Validate Biometrics Screen")
    public void biometricsFingerPrintscreen() throws ParseException, InterruptedException, IOException {
        ufl.biometricsFingerPrintscreen();
    }


    //Check reset pin journey from login option after upfront login journey
    @Then("Validate Reset Pin After UFL")
    public void restPinAfterUFL() throws ParseException, InterruptedException, IOException {
        ufl.restPinAfterUFL();
    }
}

 */