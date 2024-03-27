package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Then;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingAbstract;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingAndroid;
import pages.Dashboard.RelocateInboxRemoveGreeting.RelocateInboxRemoveGreetingiOS;

import java.io.IOException;

public class RelocateInboxRemoveGreeting {

    RelocateInboxRemoveGreetingAbstract RelocateInboxRemoveGreetingItem;

    public RelocateInboxRemoveGreeting(Config config) throws IOException {
        if (config.isAndroid()) RelocateInboxRemoveGreetingItem = new RelocateInboxRemoveGreetingAndroid();
        if (config.isIos()) RelocateInboxRemoveGreetingItem = new RelocateInboxRemoveGreetingiOS();
    }

    @Then("Validate User Greeting is removed from the top of the dashboard")
    public void validateUserGreetingIsRemovedFromTheTopOfTheDashboard() {
        RelocateInboxRemoveGreetingItem.validateHidingGreetingFromUI();
    }

    @Then("Validate that Inbox is relocated to the top of the dashboard")
    public void validateThatInboxIsRelocatedToTheTopOfTheDashboard() {
        RelocateInboxRemoveGreetingItem.validateInboxRelocation();
    }


    @Then("Validate that Inbox does not exist at the top of the dashboard")
    public void validateThatInboxDoesNotExistAtTheTopOfTheDashboard() {
        RelocateInboxRemoveGreetingItem.validateInboxRemoval();
    }

    @Then("Open the messages box Notifications on the dashboard")
    public void openTheMessagesBoxNotificationsOnTheDashboard() {
        RelocateInboxRemoveGreetingItem.openMessageBoxOnDashboard();
    }
}
