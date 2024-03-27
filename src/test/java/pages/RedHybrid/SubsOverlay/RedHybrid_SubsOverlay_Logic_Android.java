package pages.RedHybrid.SubsOverlay;

import models.response.DashboardV4ResponseModel;
import models.response.ExtrasResponseModel;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.ExtrasUtils;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.*;
import static utils.element_helpers.GenericHelpers.*;


public class RedHybrid_SubsOverlay_Logic_Android extends RedHybrid_SubsOverlay_Abstract {

    public RedHybrid_SubsOverlay_Logic_Android() {
        super();
    }

    DashboardV4ResponseModel dashboardModel = new DashboardV4ResponseModel();
    ExtrasResponseModel extrasResponseModel = new ExtrasResponseModel();


    @Override
    public void clickOnAnyTile() {
        scrollDownTo(RedHybrid_CreditTile);
        waitForVisibility(RedHybrid_CreditTile);
        RedHybrid_CreditTile.click();
    }

    @Override
    public void validateSubsOverlayUI() {
        dashboardModel = DashboardUtils.GetDashboard();
        waitForVisibility(RedHybrid_subscriptionType);
        assertEquals(RedHybrid_subscriptionType.getText(), dashboardModel.subscriptionHeader.subscriptionType);
        assertEquals(RedHybrid_subscriptionId.getText(), dashboardModel.subscriptionHeader.subscriptionId);
        assertEquals(RedHybrid_subscriptionBalance.getText(), dashboardModel.subsOverlay.header.currentChargesTitle);
    }

    @Override
    public void appSoftCloseThenRelaunchIt() {
        runAppInBackground();
    }

    @Override
    public void planUsageExtrasTabsAreDisplayed() {
        waitForVisibility(RedHybrid_subscriptionType);
        assertEquals(RedHybrid_PlanTab.getText(), "Plan");
        assertEquals(RedHybrid_UsageTab.getText(), "Usage");
        assertEquals(RedHybrid_ExtrasTab.getText(), "Extras");
    }

    @Override
    public void clickOnXIcon() {
        Bill_Xicon.click();
    }


    //For Extras Tab Content
    @Override
    public void DashboardIsDisplayed() {
        scrollDownTo(RedHybrid_CreditTile);
        waitForVisibility(RedHybrid_CreditTile);
    }

    @Override
    public void NavigateToExtrasTab() {
        RedHybrid_CreditTile.click();
        RedHybrid_ExtrasTab.isDisplayed();
        RedHybrid_ExtrasTab.click();
        waitForVisibility(RedHybrid_ControlsLimitsAndExtrasTitle);
    }


    @Override
    public void ValidateOnContentOfExtrasTab() {
        extrasResponseModel = ExtrasUtils.getExtrasWithStub();
        RedHybrid_ControlsLimitsAndExtrasTitle.isDisplayed();
        scrollDownTo(RedHybrid_ManageControlAndLimits);
        RedHybrid_BuyExtrasCTA.isDisplayed();
        RedHybrid_ManageControlAndLimits.isDisplayed();
        assertEquals(extrasResponseModel.cards.get(2).actions.get(1).text, RedHybrid_ManageControlAndLimits.getText());

    }

    @Override
    public void ValidatePayAsYouGoCardIsNotDisplayed() {
        extrasResponseModel = ExtrasUtils.getExtrasWithStub();
        assertElementDoesNotExist(PayAsYouGoCard);
        for (int i = 0; i < extrasResponseModel.cards.size(); i++) {
            Assert.assertNotEquals(extrasResponseModel.cards.get(i).title, "<b>Pay as you go extras<b>");
        }
    }

    @Override
    public void ValidateExtrasDisplayed() {
        extrasResponseModel = ExtrasUtils.getExtrasWithStub();
        if (extrasResponseModel.cards.get(0).title == "My extra allowances") {
            for (int i = 0; i < extrasResponseModel.cards.get(0).list.size(); i++) {
                String cardTitleApiResponse = extrasResponseModel.cards.get(0).list.get(i).title;
                String cardExpiryTextApiResponse = extrasResponseModel.cards.get(0).list.get(i).text;
                Assert.assertTrue(getElementByText(cardTitleApiResponse).isDisplayed());
                Assert.assertTrue(getElementByText(cardExpiryTextApiResponse).isDisplayed());
            }
        }
    }


}