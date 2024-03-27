package pages.Dashboard.B2BRemoveBlockingUpgradeCard;

import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class B2BUpgradesAndroid extends B2BUpgradesAbstract{
    @Override
    public void ValidateAirTimeTabDisplayed() {
        waitForVisibility(AirtimeTab);

    }

    @Override
    public void ValidateUpgradeNowCard() {
        waitForVisibility(UpgradenowCTA);

    }

}
