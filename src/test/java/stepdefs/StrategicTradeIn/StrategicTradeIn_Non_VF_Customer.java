package stepdefs.StrategicTradeIn;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AcquisitionBoard.AcquisitionBoardLogic;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import pages.StrategicTradeIn.StrategicTradeInAbstract;
import pages.StrategicTradeIn.StrategicTradeInAndroid;
import pages.StrategicTradeIn.StrategicTradeInIOS;

public class StrategicTradeIn_Non_VF_Customer {
    DX_IDM_WelcomeFlowLogicAbstract dxidmWelcomeFlow;
    StrategicTradeInAbstract strategicTradeInPage;

    public StrategicTradeIn_Non_VF_Customer(Config config) {
        if (config.isAndroid()) {
            dxidmWelcomeFlow = new DX_IDM_WelcomeFlowLogicAndroid();
            strategicTradeInPage = new StrategicTradeInAndroid();
        }
        if (config.isIos()) {
            dxidmWelcomeFlow = new DX_IDM_WelcomeFlowLogic_IOS();
            strategicTradeInPage = new StrategicTradeInIOS();
        }
    }

    @Given("non VF user at acquisition dashboard")
    public void theUserAtAcquisitionDashboard() throws InterruptedException {
        dxidmWelcomeFlow.clickOnReturnToMyVodafoneCTA();
        strategicTradeInPage.assertAcqNewDBHeaderTitleText();

    }

    @When("the user clicks on strategic trade in at discover tile")
    public void theUserClicksOnStrategicTradeInAtDiscoverTile() {
        strategicTradeInPage.goToStrategicTradeInPage();
    }

    @Then("the user redirected to strategic diagnostic page")
    public void theUserRedirectedToStrategicDiagnosticPage() {
        strategicTradeInPage.verifyStrategicTradeInPageTitle();
    }

    @When("the user clicks on Trade in Icon")
    public void theUserClicksOnTradeInIcon(){
        strategicTradeInPage.clickOnTradeInIcon();
    }
}
