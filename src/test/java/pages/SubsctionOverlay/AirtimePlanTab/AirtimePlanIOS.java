package pages.SubsctionOverlay.AirtimePlanTab;

import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AirtimePlanIOS extends AirtimePlanAbstract{

    public AirtimePlanIOS(){
        super();
    }

    @Override
    public void NavigateToAirtimePlanTab() {
        waitForVisibility(DB_ControlTile);
        DB_ControlTile.click();
        waitForVisibility(SO_AirtimePlanTab);
    }

    @Override
    public void WhatIsAirtimePlanCTA() {
        waitForVisibility(Airtime_HelpTip_Link);
        Airtime_HelpTip_Link.click();
    }

    @Override
    public void WhatIsAirtimePlanOverlay() {
        waitForVisibility(Your_AirtimePlan_Explanation_Msg);
        Assert.assertTrue(Your_AirtimePlan_Explanation_Title.getText().contains("Your Airtime Plan explained"));
    }

    @Override
    public void OkThanksCTA() {
        waitForVisibility(Ok_ThanksCTA);
        Ok_ThanksCTA.click();
    }

    @Override
    public void AirtimePlanTab() {
        waitForVisibility(SO_AirtimePlanTab);;
        AssertDisplayed(Airtime_HelpTip_Link.isDisplayed());
    }

    @Override
    public void WhatIsAirtimePlanNewCopyOverlay() {
        waitForVisibility(Your_AirtimePlan_Explanation_Msg);
        Assert.assertTrue(Your_AirtimePlan_Explanation_Title.getText().contains("Your Airtime Plan explained"));
        Assert.assertTrue(Your_AirtimePlan_Explanation_Msg.getText().contains("Your Airtime Plan includes your data"));
    }
}
