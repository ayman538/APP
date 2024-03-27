package stepdefs.TC_Dashboard;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Dashboard.ConnectedApps.ConnectedAppsAbstract;
import pages.Dashboard.ConnectedApps.ConnectedAppsAndroid;
import pages.Dashboard.ConnectedApps.ConnectedAppsIOS;
import pages.Dashboard.ConnectedApps.ConnectedAppsLogic;

import static core.Hooks.testAfterLastScenario;

public class ConnectedApps {

    ConnectedAppsAbstract connectedAppsLogic;

    public ConnectedApps(Config config){
        if(config.isAndroid()) connectedAppsLogic = new ConnectedAppsAndroid();
        if(config.isIos()) connectedAppsLogic = new ConnectedAppsIOS();
    }

    @Given("Scroll down and check Connected apps Images")
    public void checkConnectedAppsImgs(){
        connectedAppsLogic.checkConnectedAppsImgs();
    }

    @Then("Check Connected apps Titles")
    public void checkConnectedAppsTitles(){
        connectedAppsLogic.checkConnectedAppsTitles();
    }

    @Then("Check Connected apps text and order")
    public void checkConnectedAppsTextOrder(){
        connectedAppsLogic.checkConnectedAppsTextOrder();
    }
}
