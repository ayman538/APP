package pages.RedHybrid.RenewPlanEarly;

import models.response.HybridBundelsResponseModel;
import org.testng.Assert;
import utils.HybridBundelsUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RenewPlanEarly_Android extends RenewPlanEarly_Abstract {
    public RenewPlanEarly_Android() {
        super();
    }

    HybridBundelsResponseModel hybridBundelsResponseModel;
    Map<String, String> queryParameters;

    @Override
    public void renewEarlyOverlayAppears() {
        waitForVisibility(changePlanChoosePlanHeader);
        AssertDisplayed(changePlanChoosePlanTitle.isDisplayed());

    }

    public HybridBundelsResponseModel GetHybridBundlesResponseForRenewEarly() {
        queryParameters = new HashMap<String, String>() {{
            put("orderType", "change-now");
        }};
        return HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
    }


    @Override
    public void RenewEarlyScreenUIValidation() throws InterruptedException {
        hybridBundelsResponseModel = GetHybridBundlesResponseForRenewEarly();

        waitForVisibility(addFlexiPlanHeader);
        AssertDisplayed(addFlexiPlanHeader.isDisplayed());

        // assert Header text is renew early
        String expectedDescription = addFlexiPlanHeader.getText();
        String actualDescription = hybridBundelsResponseModel.title;
        Assert.assertEquals(expectedDescription, actualDescription);

        // assert title is renew early
        Thread.sleep(1000);
        String expectedRenewEarlyHeader = changePlanChoosePlanTitle.getText();
        String actualRenewEarlyHeader = hybridBundelsResponseModel.subTitle;
        Assert.assertEquals(expectedRenewEarlyHeader, actualRenewEarlyHeader);

        // assert subtitle is renew early
        String expectedTitle = changePlanChoosePlanDescription.getText();
        String actualTitle = hybridBundelsResponseModel.headerText;
        Assert.assertEquals(expectedTitle, actualTitle);



        // Assert current plan title , name,  price

        String expectedCurrentPlanTitle = changePlanChoosePlanCurrentPlanTitle.getText();
        String actualCurrentPlanTitle = hybridBundelsResponseModel.currentPlan.title;
        Assert.assertEquals(expectedCurrentPlanTitle, actualCurrentPlanTitle);

        String expectedCurrentPlanName = changePlanChoosePlanCurrentPlanDescription.getText();
        String actualCurrentPlanName = hybridBundelsResponseModel.currentPlan.name;
        Assert.assertEquals(expectedCurrentPlanName, actualCurrentPlanName);

        String expectedCurrentPlanAmount = changePlanChoosePlanCurrentPlanAmount.getText();
        String actualCurrentPlanAmount = hybridBundelsResponseModel.currentPlan.price;
        Assert.assertEquals(expectedCurrentPlanAmount, actualCurrentPlanAmount);


        // Assert on continue button
        AssertDisplayed(ContinueCTA.isDisplayed());
        String expectedContinueCTA = ContinueCTA.getText();
        String actualContinueCTA = hybridBundelsResponseModel.actions.get(0).text;
        Assert.assertEquals(expectedContinueCTA, actualContinueCTA);

    }


}
