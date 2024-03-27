package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import pages.Dashboard.ChargesCard.ChargesCardAbstract;
import pages.Dashboard.ChargesCard.ChargesCardAndroid;
import pages.Dashboard.ChargesCard.ChargesCardIOS;


public class ChargesCard {

    ChargesCardAbstract chargesCard;

    public ChargesCard(Config config){
        if (config.isAndroid()) chargesCard = new ChargesCardAndroid();
        if (config.isIos()) chargesCard = new ChargesCardIOS();
    }

    @Then("Validate charges card")
    public void checkChargesCard(){
        chargesCard.checkChargesCard();
    }

    /*
    ChargesCardLogic chargesCardLogic;
    static boolean getValues = false;
    static boolean navigatedToDashboard = false;

    @Given("Init charges card")
    public void beforeClass() throws IOException {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        chargesCardLogic = new ChargesCardLogic();
        if (!getValues) {
            chargesCardLogic.SetBeforeClass();
            getValues = true;
        }
    }

    @Then("Validate charges card header")
    public void TC01_ChargesCardTC_ValidateChargesCardHeader() {
        chargesCardLogic.checkChargesCardHeader();
    }

    @Then("Validate charges card title")
    public void TC02_ChargesCardTC_ValidateChargesCardTitle() {
        chargesCardLogic.checkChargesCardTitle();
    }

    @Then("Validate charges card amount")
    public void TC03_ChargesCardTC_ValidateChargesCardAmount() {
        chargesCardLogic.checkChargesCardAmount();
    }

    @Then("Validate charges card footer")
    public void TC04_ChargesCardTC_ValidateChargesCardFooter() {
        chargesCardLogic.checkChargesCardFooter();
    }

     */
}
