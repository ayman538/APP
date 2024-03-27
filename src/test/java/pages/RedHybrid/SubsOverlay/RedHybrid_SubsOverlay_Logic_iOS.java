package pages.RedHybrid.SubsOverlay;

import models.response.DashboardV4ResponseModel;
import models.response.ExtrasResponseModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.ExtrasUtils;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_SubsOverlay_Logic_iOS extends RedHybrid_SubsOverlay_Abstract {

    public RedHybrid_SubsOverlay_Logic_iOS() {
        super();
    }

    DashboardV4ResponseModel dashboardModel = new DashboardV4ResponseModel();
    ExtrasResponseModel extrasResponseModel = new ExtrasResponseModel();

    @Override
    public void clickOnAnyTile() {
        waitForVisibility(RedHybrid_CreditTile);
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
        waitForVisibility(RedHybrid_ExtrasTab);
        RedHybrid_ExtrasTab.click();
        waitForVisibility(RedHybrid_ControlsLimitsAndExtrasTitle);
    }


    @Override
    public void ValidateOnContentOfExtrasTab() {
        extrasResponseModel = ExtrasUtils.getExtrasWithStub();
        AssertDisplayed(RedHybrid_ControlsLimitsAndExtrasTitle.isDisplayed());
        AssertDisplayed(RedHybrid_BuyExtrasCTA.isDisplayed());
        AssertDisplayed(RedHybrid_ManageControlAndLimits.isDisplayed());
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
        extrasResponseModel = ExtrasUtils.getExtras();

        if (extrasResponseModel.cards.get(0).title.equalsIgnoreCase("My extra allowances")) {
            for (int i = 0; i < extrasResponseModel.cards.get(0).list.size(); i++) {
                String cardTitleApiResponse = extrasResponseModel.cards.get(0).list.get(i).title;
                String cardExpiryTextApiResponse = extrasResponseModel.cards.get(0).list.get(i).text;
                WebElement element = getElementByText(cardTitleApiResponse);
                AssertDisplayed(element.isDisplayed());
                WebElement element2 = getElementByText(cardExpiryTextApiResponse);
                AssertDisplayed(element2.isDisplayed());
            }
        }
    }
}