package stepdefs;


import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.response.DiscoverV2ResponseModel;
import pages.ExamplePage.ExamplePage;
import pages.ExamplePage.ExamplePageAndroid;
import pages.ExamplePage.ExamplePageiOS;
import utils.DiscoverOffersUtils;


public class ExampleSteps {

    private ExamplePage page;

    public ExampleSteps(Config config) {
        if (config.isAndroid()) page = new ExamplePageAndroid();
        if (config.isIos()) page = new ExamplePageiOS();
    }

    @Given("the user navigates to the app")
    public void theUserNavigatesToTheSite() {
    }

    @Given("login")
    public void login() {
    }

    @Then("searches for a neat gif")
    public void searchesForANeatGif() {
    }

    @Then("verifies \"([^\"]*)\"$ is displayed")
    public void verifirezIsDisplayed(String elementField) {
    }

    @And("taps \"([^\"]*)\"$")
    public void taps(String elementField) {
    }
}
