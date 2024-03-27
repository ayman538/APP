package pages.RedHybrid.DashboardUniversalLink;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_DashboardUniversalLink_Android extends RedHybrid_DashboardUniversalLink_Abstract {
    public RedHybrid_DashboardUniversalLink_Android() {
        super();
    }

    public void theUserClicksOnDashBoardLink() {
        navigateToURL("https://www.vodafone.co.uk/myvf/app");
    }

    public void assertThatUserNavigatesToDashBoardWithNoActivePlan() {
        AssertDisplayed(RedHybrid_NoActivePlan.isDisplayed());
    }

    public void assertThatUserNavigatesToDashBoardWithActivePlan() {
        waitForVisibility(RedHybrid_ActivePlan);
        AssertDisplayed(RedHybrid_ActivePlan.isDisplayed());
    }


    @Override
    public void SoftCloseApp() {
        runAppInBackground();

    }
}
