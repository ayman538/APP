package stepdefs.TC_Dashboard.TC_VOV;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.VOV.VOVAbstract;
import pages.Dashboard.VOV.VOVAndroid;
import pages.Dashboard.VOV.VOVIOS;

import static core.Hooks.testAfterLastScenario;

public class VOVTCs {

    VOVAbstract vovLogic;

    public VOVTCs(Config config){
        if(config.isAndroid()) vovLogic = new VOVAndroid();
        if (config.isIos()) vovLogic = new VOVIOS();
    }

    @Given("Dashboard loaded and checking VOV items")
    public void checkVOVItems(){
        vovLogic.checkVOVItems();
    }

    @When("Accept VOV")
    public void VOVCTA(){
        vovLogic.VOVCTA();
    }

    @Then("Press back button to find VOV not dismissed")
    public void VOVWebViewBackCTA(){
        vovLogic.VOVWebViewBackCTA();
    }

    @When("Dismiss VOV")
    public void DismissVOV(){
        vovLogic.DismissVOV();
    }

    @Then("VOV should not be displayed")
    public void checkVOVAfterSoftClose(){
        vovLogic.checkVOVAfterSoftClose();
    }


    /*
    static boolean navigatedToDashboard = false;

    @Given("Init VOV")
    public void setBeforeClass() {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        vovLogic = new VOVLogic();
    }

    @Given("Set Further Roaming Flag")
    public void setFurtherRoamingFlag() {
        vovLogic.setFurtherRoamingFlag();
    }

    @Then("Validate Further Roaming VOV")
    public void ValidateFurtherRoamingVOV() {
        vovLogic.ValidateFurtherRoamingVOV();
    }

    @Then("Validate Further Roaming VOV CTA")
    public void ValidateFurtherRoamingVOVCTA() {
        vovLogic.ValidateFurtherRoamingVOVCTA();
    }

    @Then("Validate Close CTA for Showing VOV")
    public void TC03_ValidateCloseCTAForShowingVOV() {
        vovLogic.ValidateCloseCTAForShowingVOV();
    }

    @Given("Set Low Credit Flag")
    public void setLowCreditFlag() {
        vovLogic.setLowCreditFlag();
    }

    @Then("Validate Second VOV")
    public void ValidateSecondVOV() {
        vovLogic.ValidateSecondVOV();
    }

    @Then("Validate Second VOV CTA")
    public void ValidateSecondVOVCTA() {
        vovLogic.ValidateSecondVOVCTA();
    }

    @Then("Validate Low Credit VOV")
    public void ValidateLowCreditVOV() {
        vovLogic.ValidateLowCreditVOV();
    }

    @Then("Validate Low Credit VOV Top Up CTA")
    public void ValidateLowCreditVOVTopUpCTA() {
        vovLogic.ValidateLowCreditVOVTopUpCTA();
    }

    @Then("Validate Low Credit VOV Close CTA")
    public void ValidateLowCreditVOVCloseCTA() {
        vovLogic.ValidateLowCreditVOVCloseCTA();
    }

    @Then("Validate Swipe Back")
    public void ValidateSwipeBack() {
        vovLogic.ValidateSwipeBack();
    }

     */
}
