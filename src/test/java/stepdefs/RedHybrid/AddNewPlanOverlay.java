package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.RedHybrid.AddNewPlanOverlay.Redhybrid_AddNewPlanOverlay_Abstract;
import pages.RedHybrid.AddNewPlanOverlay.Redhybrid_AddNewPlanOverlay_Android;
import pages.RedHybrid.AddNewPlanOverlay.Redhybrid_AddNewPlanOverlay_IOS;


public class AddNewPlanOverlay {
    private Redhybrid_AddNewPlanOverlay_Abstract redhybrid_AddNewPlanOverlay_Abstract;

    public AddNewPlanOverlay(Config config) {
        if (config.isAndroid()) redhybrid_AddNewPlanOverlay_Abstract = new Redhybrid_AddNewPlanOverlay_Android();
        if (config.isIos()) redhybrid_AddNewPlanOverlay_Abstract = new Redhybrid_AddNewPlanOverlay_IOS();
    }



    @Then("Assert that User should be redirected to internal WebView")
    public void assertThatUserShouldBeRedirectedToInternalWebView() {
        redhybrid_AddNewPlanOverlay_Abstract.assertThatUserShouldBeRedirectedToInternalWebView();

    }


    @And("Assert that User is directed back to Dashboard")
    public void assertThatUserIsDirectedBackToDashboard() {
        redhybrid_AddNewPlanOverlay_Abstract.assertThatUserIsDirectedBackToDashboard();
    }

    @And("Click on View plan details CTA")
    public void clickOnViewPlanDetailsCTA() {
        redhybrid_AddNewPlanOverlay_Abstract.clickOnViewPlanDetailsCTA();
    }

    @Then("Add a new plan overlay should be displayed with correct components order")
    public void addANewPlanOverlayShouldBeDisplayedWithCorrectComponentsOrder() {
        redhybrid_AddNewPlanOverlay_Abstract.addANewPlanOverlayShouldBeDisplayedWithCorrectComponentsOrder();

    }

}