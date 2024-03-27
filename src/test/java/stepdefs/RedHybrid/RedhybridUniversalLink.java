package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.When;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;
import pages.RedHybrid.RedhybridUniversalLinks.RedhybridUniversalLinkAbstract;
import pages.RedHybrid.RedhybridUniversalLinks.RedhybridUniversalLinksLogicAndroid;
import pages.RedHybrid.RedhybridUniversalLinks.RedhybridUniversalLinksLogicIOS;

public class RedhybridUniversalLink {
    private RedhybridUniversalLinkAbstract universalLinkabstract;


    public RedhybridUniversalLink(Config config) {
        if (config.isAndroid()) universalLinkabstract = new RedhybridUniversalLinksLogicAndroid();
        if (config.isIos()) universalLinkabstract = new RedhybridUniversalLinksLogicIOS();
    }

    @When("Navigate to manage card")
    public void navigateToManageCard(){
        universalLinkabstract.navigateToManageCard();
    }
    @When("soft close the app")
    public void softCloseApp() throws InterruptedException {
        universalLinkabstract.softCloseApp();
    }
}
