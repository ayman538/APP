package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard.Tooltips.TooltipsAbstract;
import pages.Dashboard.Tooltips.TooltipsAndroid;
import pages.Dashboard.Tooltips.TooltipsIOS;
import pages.Tray.Settings.AppSetting.AppSettingsAbstract;
import pages.Tray.Settings.AppSetting.AppSettingsAndroid;
import pages.Tray.Settings.AppSetting.AppSettingsIOS;

import java.io.IOException;

public class DashboardTooltips {
    TooltipsAbstract Tooltips;
    AppSettingsAbstract AS;

    public DashboardTooltips(Config config){
        if (config.isAndroid()) {
            Tooltips = new TooltipsAndroid();
            AS = new AppSettingsAndroid();
        }
        if (config.isIos()){
            Tooltips = new TooltipsIOS();
            AS = new AppSettingsIOS();
        }
    }


    @When("I Validate and Submit First Tip")
    public void iValidateAndSubmitFirstTip() {
        Tooltips.SubmitFirstTip();

    }

    @And("I Validate and Submit Second Tip")
    public void iValidateAndSubmitSecondTip() {
        Tooltips.SubmitSecondTip();

    }

    @And("I validate and Submit third Tip")
    public void iValidateAndSubmitThirdTip() {
        Tooltips.SubmitThirdTip();

    }

    @Then("Tooltips will not be displayed")
    public void tooltipsWillNotBeDisplayed() {
        Tooltips.TooltipsNotDisplayed();
    }

    @And("I Dismiss The Second Tip")
    public void iDismissTheSecondTip() {
        Tooltips.DismissSecondTip();

    }

    @When("I Dismiss The First Tip")
    public void iDismissTheFirstTip() {
        Tooltips.DismissFirstTip();
    }

    @Then("Reset App from Dashboard")
    public void resetAppFromDashboard() throws IOException {
        AS.resetAppFromDashboard();
    }

    @And("Reset the app from new settings tray")
    public void resetTheAppFromNewSettingsTray() {
        AS.resetAppFromNewSettingsTray();
    }
}
