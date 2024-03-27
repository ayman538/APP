package stepdefs.ClickToUpgrade;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAbstract;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansAndroid;
import pages.ClickToUpgrade.RecommendedPlans.RecommendedPlansIOS;

public class ShowMorePlansAndFiltersSection {
    RecommendedPlansAbstract recommendedPlansPage;

    public ShowMorePlansAndFiltersSection(Config config) {
        if (config.isAndroid()) {
            recommendedPlansPage = new RecommendedPlansAndroid();
        }

        if (config.isIos()) {
            recommendedPlansPage = new RecommendedPlansIOS();
        }
    }

    @Then("Show more plans CTA should be displayed")
    public void verifyThatShowMorePlansCTADisplayed() {
        recommendedPlansPage.verifyThatShowMorePlansCTADisplayed();
    }

    @When("I click on show more plans CTA")
    public void clickOnShowMorePlansCTA() {recommendedPlansPage.clickOnShowMorePlansCTA();}

    @Then("Show more plans CTA should dimmed")
    public void verifyThatShowMorePlansCTADimmed() {
        recommendedPlansPage.verifyThatShowMorePlansCTADimmed();
    }

    @And("Filters CTA should be displayed")
    public void verifyThatFiltersCTADisplayed() {recommendedPlansPage.verifyThatFiltersCTADisplayed();}

    @When("I click on Filters CTA")
    public void iClickOnFiltersCTA() {recommendedPlansPage.clickOnFiltersCTA();}

    @When("After I click on {string} filter the results should be matching the desired filter")
    public void iClickOnCTAFromTheFilterSection(String FilterCTA) {recommendedPlansPage.ClickOnFilterCTA(FilterCTA);}

    @When("I set {string} as a min price")
    public void iSetMinPrice(String minPrice) {
        recommendedPlansPage.setMinPrice(minPrice);
    }

    @And("I set {string} as a max price")
    public void iSetAsAMaxPrice(String maxPrice) {
        recommendedPlansPage.setMaxPrice(maxPrice);
    }
    @Then("The results should be in the range of min and max price")
    public void theResultsShouldBeInTheRangeOfMinAndMaxPrice() {
        recommendedPlansPage.validatePriceFilterResult();
    }
    @Given("I do not change any filter the filter counter and the clear all CTA not exist")
    public void iDoNotChangeAnyFilterTheFilterCounterAndTheClearAllCTANotExist() {
        recommendedPlansPage.verifyThatTheFilterCounterAndClearAllCTANotExist();
    }

    @When("I change {string} and {string} and {string} and {string} and {string} filters")
    public void iChangeAndAndAndAndFilters(String planLength, String minPrice, String maxPrice, String data, String features) {
        recommendedPlansPage.changeFilters(planLength, minPrice, maxPrice, data, features);
    }

    @Then("The filter counter and clear all CTA should displayed and filter counter should be equal to the number of changed filters")
    public void theFilterCounterAndClearAllCTAShouldDisplayedAndFilterCounterShouldBeEqualToTheNumberOfChangedFilters() {
        recommendedPlansPage.verifyThatTheFilterCounterAndClearAllCTADisplayed();
    }

    @When("I click on clear all CTA")
    public void iClickOnClearAllCTA() {
        recommendedPlansPage.clickOnClearAllCTA();
    }

    @Then("The filter counter and clear all CTA not displayed and the filters back to default")
    public void theFilterCounterAndClearAllCTANotDisplayedAndTheFiltersBackToDefault() {
        recommendedPlansPage.verifyThatTheFilterCounterAndClearAllCTANotDisplayedAndTheFiltersBackToDefault();
    }

}

