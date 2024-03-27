package pages.RedHybrid.RedHybrid_ChangeNextPlan_AddPaymentMethod;


import models.response.HybridBundelsResponseModel;
import org.openqa.selenium.By;
import utils.HybridBundelsUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_ChangeNextPlan_AddPaymentMethod_Android extends RedHybrid_ChangeNextPlan_AddPaymentMethod_Abstract {

    HybridBundelsResponseModel hybridBundelsResponseModel;
    Map<String, String> queryParameters ;
    String keyOrderType = "orderType";
    String valueAddNew = "add-new";

    public RedHybrid_ChangeNextPlan_AddPaymentMethod_Android(){super();}

    @Override
    public void NavigateToPlanTab() {
        waitForVisibility(RedHybrid_PlanTile);
        RedHybrid_PlanTile.click();
        RedHybrid_PlanTab.click();
    }

    @Override
    public void ClickOnChangePlanCTA() {
        scrollDownTo(RedHybrid_ChangePlanInPlanTab);
        RedHybrid_ChangePlanInPlanTab.click();
    }

    @Override
    public void ClickOnChangePlanQuickLinks() {
        scrollDownTo(imgDashboardVeryMeOffer);
        waitForVisibility(RedHybrid_ChangePlanQuickLinks);
        RedHybrid_ChangePlanQuickLinks.click();
    }

    @Override
    public void SkipCTAShouldNotAppears() {
        int elementsNo = driver.findElements(By.xpath("//*[@text='Skip']")).size();
        assertEquals(0, elementsNo);
    }

    @Override
    public void Check_Content_Of_Change_Next_Plan_Overlay() {
        queryParameters = new HashMap<String, String>() {{
            put(keyOrderType, valueAddNew);
        }};
        hybridBundelsResponseModel = HybridBundelsUtils.getHybridBundelsResponse(queryParameters);

        waitForVisibility(RedHybrid_ChangPlanOverlayContinueCTA);
        RedHybrid_ChangPlanOverlayTitle.isDisplayed();
        RedHybrid_ChangPlanOverlaySubTitle.isDisplayed();
        RedHybrid_ChangPlanOverlayContinueCTA.isDisplayed();
        RedHybrid_ChangPlanOverlayCurrentPlan.isDisplayed();
        RedHybrid_ChangPlanOverlayLink.isDisplayed();

        // assert current plan name
        String ActualCurrentPlanName= hybridBundelsResponseModel.currentPlan.name ;
        String ExpectedCurrentPlanName = currentPlanName.getText();
        assertEquals(ActualCurrentPlanName,ExpectedCurrentPlanName);


        // assert  plan name
        String ActualCPlanName= hybridBundelsResponseModel.items.get(0).name;
        String ExpectedPlanName = currentPlanName.getText();
        assertEquals(ActualCPlanName,ExpectedPlanName);



    }
}
