package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingAbstract;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingAndroid;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingiOS;
import pages.Dashboard.ViewBasket.ViewBasketAbstract;
import pages.Dashboard.ViewBasket.ViewBasketIOS;
import pages.Dashboard.ViewBasket.ViewBasketAndroid;

import java.io.IOException;

public class ViewBasket {
   ViewBasketAbstract ViewBasketItem;

    public ViewBasket(Config config) throws IOException {
        if (config.isAndroid()) ViewBasketItem = new ViewBasketAndroid();
        if (config.isIos()) ViewBasketItem = new ViewBasketIOS();
    }

    @Then("I should view a Basket icon With No Counter is at the top of the dashboard")
    public void validateBasketIsAtTheTopOfTheDashboard() {
        ViewBasketItem.viewBasketExistsWithNoCounter();
    }

    @Then("I should view a Basket icon With Counter is at the top of the dashboard")
    public void validateBasketWithCounterIsAtTheTopOfTheDashboard() {
        ViewBasketItem.viewBasketExistsWithCounter();
    }

    @Then("I should not view a Basket icon at the top of the dashboard")
    public void validateBasketIsNotAtTheTopOfTheDashboard() {
        ViewBasketItem.viewBasketDoesNotExist();
    }


    @When("I Click on Basket at the top of the dashboard")
    public void clickOnBasketAtTheTopOfTheDashboard() {
        ViewBasketItem.clickOnBasket();
    }

    @Then("I should navigate to the Shop custom tab Screen")
    public void assertThatShopWebViewIsDisplayedSuccessfully() throws InterruptedException {
        ViewBasketItem.assertShopCustomTabIsDisplayed();
    }

    @Then("I should navigate to the User's Basket Webpage")
    public void iShouldNavigateToTheUserSBasketWebpage() throws InterruptedException {
        ViewBasketItem.validateBasketWebpageIsDisplayed();
    }
}
