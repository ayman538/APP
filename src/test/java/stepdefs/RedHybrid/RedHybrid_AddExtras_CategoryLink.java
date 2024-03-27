package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links.Red_Hybrid_Add_Extras_Category_links_Abstract;
import pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links.Red_Hybrid_Add_Extras_Category_links_Android;
import pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links.Red_Hybrid_Add_Extras_Category_links_IOS;

public class RedHybrid_AddExtras_CategoryLink {
    Red_Hybrid_Add_Extras_Category_links_Abstract categorylinks_abstract;

    public RedHybrid_AddExtras_CategoryLink(Config config) {
        if (config.isAndroid()) categorylinks_abstract = new Red_Hybrid_Add_Extras_Category_links_Android();
        if (config.isIos()) categorylinks_abstract = new Red_Hybrid_Add_Extras_Category_links_IOS();
    }

    @And("I navigate to Extra overlay")
    public void extraOverlayAppearToTheUser() {
        categorylinks_abstract.extraOverlayAppears();
    }

    @Then("I should be navigated to Extra overlay")
    public void extraOverlayUIShouldComplyWithListExtrasResponse() {
        categorylinks_abstract.extraOverlayUIComplyWithListExtraResponse();
    }


    @And("I click on {string} extra")
    public void userClicksOnRoaming_In_Europe_Extra(String extraType) {
        categorylinks_abstract.chooseExtra(extraType);

    }

    @And("I click on extras Description Link")
    public void ClickonExtrasDescriptionLink() {
        categorylinks_abstract.clickOnExtrasDescriptionLink();
    }


    @Then("I should be redirect to the correct {string} and {string}")
    public void userShouldBeRedirectToTheCorrectWebView(String webViewTitle, String url) {
        categorylinks_abstract.userInTheCorrectWebView(webViewTitle,url);
    }

    @Then("I should see Renew Plan Early CTA is Displayed")
    public void CheckRenewPlanEarlyCTA() {
        categorylinks_abstract.AssertRenewPlanEarlyIsDisplayed();
    }

    @When("I click on Renew Plan Early CTA")
    public void iClickOnRenewPlanEarlyCTA() {
        categorylinks_abstract.ClickOnRenewEarlyCTA();
    }
}

