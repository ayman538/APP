package stepdefs.OnePlatform_Tutorial;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.OnePlatform_Tutorials.OnePlatform_TutorialAbstract;
import pages.OnePlatform_Tutorials.OnePlatform_TutorialAndroidLogic;
import pages.OnePlatform_Tutorials.OnePlatform_TutorialiOSLogic;

public class OnePlatform_TutorialStepDefs {


    private OnePlatform_TutorialAbstract OnePlatform_Tutorial;
    public OnePlatform_TutorialStepDefs(Config config){
        if(config.isAndroid()){
            OnePlatform_Tutorial = new OnePlatform_TutorialAndroidLogic();
        }
        else {
            OnePlatform_Tutorial = new OnePlatform_TutorialiOSLogic();
        }
    }

    @Given("Go to Dashboard")
    public void GotoDashboard(){
        OnePlatform_Tutorial.GoToDashboard();
    }

   @Then("Validate tutorial first screen")
   public void validateTutorialFirstScreen(){

       OnePlatform_Tutorial.checkFirstTutorial();
    }

   @Then("Validate tutorial second screen")
   public void validateTutorialSecondScreen(){
        OnePlatform_Tutorial.checkSecondTutorial();
   }

    @Then("Validate tutorial third screen")
    public void validateTutorialThirdScreen(){

        OnePlatform_Tutorial.checkThirdTutorial();
    }

    @Then("Validate tutorial forth screen")
    public void validateTutorialForthScreen(){

        OnePlatform_Tutorial.checkForthTutorial();
    }

    @Then("Validate PAYM Tutorials Screens")
    public void validatePAYMTutorialsScreens(){

        OnePlatform_Tutorial.checkFirstTutorial();
    }

    @Then("Click on Close tutorial CTA")
    public void userClickOnCloseCTA(){

        OnePlatform_Tutorial.closeTutorial();
        }

    @Then("Click on Go to Dashboard CTA")
    public void clickOnGoToDashboardCTA(){

        OnePlatform_Tutorial.closeTutorial();
    }

    @Then("Check RedHybrid Tutorial Screens")
    public void checkRedHybridTutorialScreens() {
        OnePlatform_Tutorial.checkRedHybridTutorialScreens();
    }

    @Then("Close Tutorial and Validate Dashboard will be displayed")
    public void CloseTutorial() {
        OnePlatform_Tutorial.CloseTutorial();
    }
}
