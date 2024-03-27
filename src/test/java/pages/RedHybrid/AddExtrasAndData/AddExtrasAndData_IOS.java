package pages.RedHybrid.AddExtrasAndData;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AddExtrasAndData_IOS extends AddExtrasAndData_Abstract
{

    public AddExtrasAndData_IOS(){ super(); }
    public void ClickOnAddDataDashboard()
    {
        AssertDisplayed(addData.isDisplayed());
        addData.click();
    }
    public void ValidateAddDataOverlay()
    {
        AssertDisplayed(addDataOverlay.isDisplayed());
        Assert.assertTrue(addDataOverlay.getText().contains("start adding data."));
    }
    public void ClickOnAddExtras()
    {
        AssertDisplayed(addExtras.isDisplayed());
        addExtras.click();
    }
    public void ValidateAddExtrasOverlay()
    {
        AssertDisplayed(addExtrasOverlay.isDisplayed());
        Assert.assertTrue(addExtrasOverlay.getText().contains("start adding an extra."));
    }
    public void ClickOnPlanTile()
    {
        AssertDisplayed(planTile.isDisplayed());
        planTile.click();
    }
    public void ClickOnExtrasTab()
    {
        waitForVisibility(extrasTab);
        AssertDisplayed(extrasTab.isDisplayed());
        extrasTab.click();
    }
    public void ClickOnAddExtrasSubsOverlay()
    {
        waitForVisibility(RedHybrid_ControlsLimitsAndExtrasTitle);
        scrollDownTo("Buy Extras");
        waitForVisibility(buyExtras);
        buyExtras.click();
    }
}