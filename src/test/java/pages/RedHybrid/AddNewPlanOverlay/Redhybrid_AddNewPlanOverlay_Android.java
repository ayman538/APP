package pages.RedHybrid.AddNewPlanOverlay;


import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertSoftAll;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Redhybrid_AddNewPlanOverlay_Android extends Redhybrid_AddNewPlanOverlay_Abstract {
    public Redhybrid_AddNewPlanOverlay_Android() {
        super();
    }



    @Override
    public void assertThatUserShouldBeRedirectedToInternalWebView() {
        waitForVisibility(MyVodafoneWebViewTitle);
        AssertDisplayed(MyVodafoneWebViewTitle.isDisplayed());
    }


    @Override
    public void assertThatUserIsDirectedBackToDashboard() {
        waitForVisibility(AddNewPlanRetryCTA);
        AssertDisplayed(AddNewPlanRetryCTA.isDisplayed());

    }

    @Override
    public void clickOnViewPlanDetailsCTA() {
        waitForVisibility(ViewPlanDetailsCTA);
        ViewPlanDetailsCTA.click();

    }

    @Override
    public void addANewPlanOverlayShouldBeDisplayedWithCorrectComponentsOrder() {
        waitForVisibility(AddNewPlanFlexiHeader);
        AssertDisplayed(AddFlexiPlanTitle.isDisplayed());
        AssertDisplayed(AddNewPLanDescription.isDisplayed());
        AssertDisplayed(AddNewPLanPurchaseAmount.isDisplayed());
        AssertDisplayed(AddNewPlanRadioButton.isDisplayed());
        AssertDisplayed(AddNewPlanContinueCTA.isDisplayed());
        AssertDisplayed(AddNewPlanXCTA.isDisplayed());
        AssertDisplayed(AddNewPlanFlexiHeader.isDisplayed());
        AssertSoftAll();

    }


}
