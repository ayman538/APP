package stepdefs.TC_Dashboard;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import org.json.simple.parser.ParseException;
import pages.Dashboard.AssistanceLinks.AssistanceLinksAbstract;
import pages.Dashboard.AssistanceLinks.AssistanceLinksAndroid;

import static core.Hooks.testAfterLastScenario;


public class TradeINForAndroid {

    AssistanceLinksAbstract assistanceLinksLogic;
    static boolean navigatedToDashboard = false;

    @Given("Init TradeIn for Android")
    public void setBeforeClass() throws ParseException {
        if (!navigatedToDashboard) {
            testAfterLastScenario();
            navigatedToDashboard = true;
        }
        assistanceLinksLogic = new AssistanceLinksAndroid();
    }

    @When("Click on See More CTA")
    public void TC01_ValidateOrdering() throws ParseException {
        assistanceLinksLogic.assistanceLinkSeeMoreCTA();
    }

    @Then("Assert on TradeIn Title")
    public void ValidateOrdering() throws ParseException {
       //assistanceLinksLogic.assertStatus();
    }


    @Then("Validate TradeIn link displayed")
    @Description("Regression per Module / Trade-in  \n\n" +
            "TC: Test Case 175941: P1_Check UI of Trade in menu item in Assitance Menu for a whitelisted user_UI")
    public void TC02_ValidateTradeInLinkIsDisplayed() throws ParseException {
        //assistanceLinksLogic.assertTradInText();
    }

    @Then("Check TradeIn CTA and X-Icon")
    public void TC03_ValidateTradeInLinkFunctionality() throws ParseException {
        assistanceLinksLogic.CheckTradeIN();
    }

}
