package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.Dashboard.NewVOV.RemoveVOVAbstract;
import pages.Dashboard.NewVOV.RemoveVOVAndroid;
import pages.Dashboard.NewVOV.RemoveVOVIOS;

import java.io.IOException;

public class RemoveVOV {
    RemoveVOVAbstract RemoveVOV;

    public RemoveVOV(Config config) throws IOException {
        if (config.isAndroid()) RemoveVOV = new RemoveVOVAndroid();
        if (config.isIos()) RemoveVOV = new RemoveVOVIOS();
    }


    @Then("Validate VOV is not exist anymore from UI")
    public void RemoveVOVTC_ValidateVOVIsRemovedFromUI() {
        RemoveVOV.validateHidingVovFromUI();
    }


    @And("SwitchToSubscriptionFLN")
    public void SwitchToFLNSubscription() throws ParseException, InterruptedException {
        RemoveVOV.SwitchToSubscription(RemoveVOV.GetFLNUser);
        Assert.assertEquals(RemoveVOV.SelectedUserType.getText() , "Home Phone");
    }

    @When("The user switch to subscription HBB")
    public void SwitchToHBBSubscription() throws ParseException, InterruptedException {
        RemoveVOV.SwitchToSubscription(RemoveVOV.GetHBBUser);
        Assert.assertEquals(RemoveVOV.SelectedUserType.getText() , "Broadband");
    }

    @And("I navigate to PayG child")
    public void SwitchToSubscriptionPayG() throws ParseException, InterruptedException {
        RemoveVOV.SwitchToSubscription(RemoveVOV.GetPaygUser);
        Assert.assertEquals(RemoveVOV.SelectedUserType.getText() , "Pay as you go");
    }

    @And("I navigate to PayM child")
    public void SwitchToSubscriptionPayM() throws ParseException, InterruptedException {

        RemoveVOV.SwitchToSubscription(RemoveVOV.PayMChild);
        Assert.assertEquals(RemoveVOV.SelectedUserType.getText() , "Pay monthly");
    }
}
