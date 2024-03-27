package stepdefs.StrategicTradeIn;

import core.Config;
import io.cucumber.java.en.When;
import pages.StrategicTradeIn.StrategicTradeInAbstract;
import pages.StrategicTradeIn.StrategicTradeInAndroid;
import pages.StrategicTradeIn.StrategicTradeInIOS;

public class StrategicTradeIn_VF_Customer {
    StrategicTradeInAbstract strategicTradeInPage;

    public StrategicTradeIn_VF_Customer(Config config) {
        if (config.isAndroid()) {
            strategicTradeInPage = new StrategicTradeInAndroid();
        }
        if (config.isIos()) {
            strategicTradeInPage = new StrategicTradeInIOS();
        }
    }

    @When("the user clicks on trade in tool assistance link")
    public void theUserClicksOnTradeInToolAssistanceLink() {
        strategicTradeInPage.clickOnTradeInAssistanceLink();
    }

}
