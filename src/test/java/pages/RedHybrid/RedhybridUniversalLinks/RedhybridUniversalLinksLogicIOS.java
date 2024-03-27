package pages.RedHybrid.RedhybridUniversalLinks;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.GenericHelpers.navigateToURL;

public class RedhybridUniversalLinksLogicIOS extends RedhybridUniversalLinkAbstract {
    public RedhybridUniversalLinksLogicIOS(){super();}

    @Override
    public void navigateToManageCard() {
        navigateToURL("https://www.vodafone.co.uk/myvf/flexi-card");
    }

    @Override
    public void softCloseApp() throws InterruptedException {
        Thread.sleep(2000);
        runAppInBackground();

    }
}
