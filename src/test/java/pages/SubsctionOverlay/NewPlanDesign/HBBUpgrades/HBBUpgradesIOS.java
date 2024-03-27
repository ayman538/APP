package pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades;

import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class HBBUpgradesIOS extends HBBUpgradesAbstract {

    public HBBUpgradesIOS() {
        super();
    }

    @Override
    public void ClickOnHBBEligibilityCTA() {
        waitForVisibility(CheckUpgradeEligibilityCTA);
        CheckUpgradeEligibilityCTA.click();
    }

    @Override
    public void ClickOnYourPlanHBB() {
        waitForVisibility(SO_PlanTab);
        SO_PlanTab.click();
    }

    @Override
    public void ValidateCheckEligibilityCTAJourney() {
        waitForVisibility(UpgradEligibilityBrowserTitle);
        AssertDisplayed(UpgradEligibilityBrowserTitle.isDisplayed());
    }

    @Override
    public void ValidateUpgradeEligibilityCardForHBB() {
        waitForVisibility(CheckUpgradeEligibilityCTA);
        AssertDisplayed(CheckUpgradeEligibilityCTA.isDisplayed());
        Assert.assertEquals(CheckUpgradeEligibilityCTA.getText(),"Check eligibility");
        AssertDisplayed(HBBUpgradeCardTitle.isDisplayed());
        Assert.assertEquals(HBBUpgradeCardTitle.getText(),"Find out if you can upgrade ");
    }
}
