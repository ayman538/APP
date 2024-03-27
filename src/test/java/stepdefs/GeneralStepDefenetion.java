package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class GeneralStepDefenetion {
    @Given("The app is opened")
    public void theAppIsOpened() {
        System.out.println("The app is opened");
    }

    @Then("The app is relaunched")
    public void TheAppRelaunch() {
        System.out.println("The app is relaunch");
    }
}
