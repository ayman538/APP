package pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay;

import models.response.HybridBundelsResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.HybridBundelsUtils;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Change_Next_Plan_Change_Next_Plan_overlay_Logic_IOS extends Change_Next_Plan_Change_Next_Plan_overlay_Abstract {
    HybridBundelsResponseModel hybridBundelsResponseModel;
    Map<String, String> queryParameters;

    public Change_Next_Plan_Change_Next_Plan_overlay_Logic_IOS() {
        super();
    }


    @Override
    public void changePlanCTAClick() {
        waitForVisibility(PlanTitleRedHybrid);
        ScrollToElement(planTabChangePlanCTA,"down");
        planTabChangePlanCTA.click();
    }

//    @Override
//    public void clickChangeNextPlanCTA() {
//        scrollDownTo(imgDashboardVeryMeOffer);
//        waitForVisibility(changeNextPlanQuickLinks);
//        //TouchAction tap = new TouchAction(driver).tap(TapOptions.tapOptions().withElement(ElementOption.element(changeNextPlanQuickLinks))).perform();
//        changeNextPlanQuickLinks.click();
//    }

    @Override
    public void changeNextPlanOverlayAppears() {

        waitForVisibility(changePlanChoosePlanHeader);
        AssertDisplayed(changePlanChoosePlanTitle.isDisplayed());
    }

    @Override
    public void planItemSelection() {
        waitForVisibility(changePlanChoosePlanPlanItem);
        changePlanChoosePlanPlanItem.click();
    }

    @Override
    public void continueCTAIsDimmed() {
        Assert.assertTrue(changePlanChoosePlanContinueCTA.isEnabled());
    }

    @Override
    public void screenUIValidation() throws InterruptedException {
        hybridBundelsResponseModel = GetHybridBundlesResponseForChangeNext();
        Thread.sleep(1000);

        String expectedHeader = changePlanChoosePlanHeader.getText();
        String actualHeader = hybridBundelsResponseModel.title;
        Assert.assertEquals(expectedHeader, actualHeader);


        String expectedTitle = changePlanChoosePlanTitle.getText();
        String actualTitle = hybridBundelsResponseModel.subTitle;
        Assert.assertEquals(expectedTitle, actualTitle);

        String expectedDescription = changePlanChoosePlanDescription.getText();
        String actualDescription = hybridBundelsResponseModel.headerText;
        Assert.assertEquals(expectedDescription, actualDescription);

        String expectedCurrentPlanTitle = changePlanChoosePlanCurrentPlanTitle.getText();
        String actualCurrentPlanTitle = hybridBundelsResponseModel.currentPlan.title;
        Assert.assertEquals(expectedCurrentPlanTitle, actualCurrentPlanTitle);

        String expectedCurrentPlanDescription = changePlanChoosePlanCurrentPlanDescription.getText();
        String actualCurrentPlanDescription = hybridBundelsResponseModel.currentPlan.name;
        Assert.assertEquals(expectedCurrentPlanDescription, actualCurrentPlanDescription);

        String expectedCurrentPlanAmount = changePlanChoosePlanCurrentPlanAmount.getText();
        String actualCurrentPlanAmount = hybridBundelsResponseModel.currentPlan.price;
        Assert.assertEquals(expectedCurrentPlanAmount, actualCurrentPlanAmount);

       // line stating minutes and texts
        AssertDisplayed(RedHybrid_PlanDetails.isDisplayed());
        String expectedCurrentPlanDesc = RedHybrid_PlanDetails.getText();
        String actualCurrentPlanDesc = hybridBundelsResponseModel.currentPlan.description;
        Assert.assertEquals(expectedCurrentPlanDesc, actualCurrentPlanDesc);

        AssertDisplayed(changePlanChoosePlanViewPlanDetails.isDisplayed());


        int i;
        int planItems = changePlanChoosePlanRecyclerView.findElements(By.id("planBundelsContainerView")).size();
        for (i = 0; i < planItems; i++) {
            Assert.assertFalse(changePlanChoosePlanRecyclerView.findElements(By.id("planBundelsContainerView")).get(i).isSelected());
        }

        String expectedChargesNotes = changePlanChoosePlanChargesNotes.getText().substring(0,77);
        String actualChargesNotes = hybridBundelsResponseModel.footerText.substring(0,77);

        Assert.assertEquals(expectedChargesNotes, actualChargesNotes);
        String expectedChoosePlanContinueCTA = changePlanChoosePlanContinueCTA.getText();
        String actualChoosePlanContinueCTA = hybridBundelsResponseModel.actions.get(0).text;
        Assert.assertEquals(expectedChoosePlanContinueCTA, actualChoosePlanContinueCTA);

    }

    @Override

    public void checkUIWithPromoOrNoPromo(){
        hybridBundelsResponseModel = GetHybridBundlesResponseForChangeNext();
        if(changePlanChoosePlanChargesNotes.getText().contains("Promo terms apply")){
            checkTheUIOfCellWithPromotedPlan(hybridBundelsResponseModel);
            checkThatPlusPlanTextNotAppear(hybridBundelsResponseModel);
            System.out.println("UI with Promoted Plans");
         }else {
            //plus plan text appears
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(hybridBundelsResponseModel.items.get(0).name))).isDisplayed());
            // terms apply text appears
            Assert.assertTrue(changePlanChoosePlanChargesNotes.getText().contains("Terms apply"));
         }

    }


    public void checkTheUIOfCellWithPromotedPlan(HybridBundelsResponseModel hybridBundelsResponseModel) {
        String PlanHasPromoTotalData = null, PlanHasPromoOriginalData = null, planPrice= null;

        for(int plans=0; plans < hybridBundelsResponseModel.items.size() ; plans++){
            if(hybridBundelsResponseModel.items.get(plans).originalAllowance != null){
                PlanHasPromoTotalData = hybridBundelsResponseModel.items.get(plans).allowance;
                PlanHasPromoOriginalData = hybridBundelsResponseModel.items.get(plans).originalAllowance;
                planPrice = hybridBundelsResponseModel.items.get(plans).priceText;
                break;
            }
        }

            boolean isDisplayed = false;
            while(!isDisplayed){
                // swipe to targeted cell
                try {
                    driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed();
                    isDisplayed = true;
                }catch (Error | Exception e){
                    SwipeToElement(driver.findElement(By.xpath(GetXpath(PlanHasPromoTotalData))),"Right");
                }
            }
            // assert on promo plan sash
            AssertDisplayed(RedHybrid_PromoSashForPromotedPlans.isDisplayed());

            // assert on promo plan original data
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(PlanHasPromoOriginalData))).isDisplayed());

            // assert on promo plan total data
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(PlanHasPromoTotalData))).isDisplayed());
            driver.findElement(By.xpath(GetXpath(PlanHasPromoTotalData))).click();

            // assert on promo plan price
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed());

            // assert on promo terms apply link
            Assert.assertTrue(RedHybrid_PromoTermsApplyLink.isDisplayed());
            System.out.println(RedHybrid_PromoTermsApplyLink.getText()  +  "  hyper link");
            Assert.assertTrue(RedHybrid_PromoTermsApplyLink.getText().contains("Promo terms apply"));
        }


    public void checkThatPlusPlanTextNotAppear(HybridBundelsResponseModel hybridBundelsResponseModel) {
        for(int plans=0; plans < hybridBundelsResponseModel.items.size() ; plans++){
            //plus plan text to be removed for promos plans
            assertEquals(hybridBundelsResponseModel.items.get(plans).name,null);
        }
    }


    public HybridBundelsResponseModel GetHybridBundlesResponseForChangeNext(){
        queryParameters = new HashMap<String, String>() {{
            put("orderType", "change-next");
        }};
        return HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
    }

    @Override
    public void clickOnPromosTermsApplyHyperLink() {
        if(changePlanChoosePlanChargesNotes.getText().contains("Promo terms apply")){
            AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());
            RedHybrid_PromoTermsApplyLink.click();
            try {
                AcceptCookies.isDisplayed();
                AcceptCookies.click();
            }catch (Exception | Error e){
                System.out.println("Cookies is already accepted");
            }
            promosTermsWebScreen();
        }
    }

    public void promosTermsWebScreen() {
        AssertDisplayed(MyVodafoneTitle.isDisplayed());
        AssertDisplayed(WV_Xicon.isDisplayed());
        AssertDisplayed(WV_Title.isDisplayed());
        doubleClick(WV_Xicon);
        AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());
    }

    @Override
    public void ChangePlanOverlayDisplayed() {
        waitForVisibility(paymentMethodOverlayHeader);
        AssertDisplayed(ChangePlanDesc.isDisplayed());
    }

    @Override
    public void ChangePlanOverlayUIValidation() {
        hybridBundelsResponseModel = HybridBundelsUtils.getHybridBundelsResponseWithoutQueryParam();

        // assert on Change plan title
        String expectedChangePlanTitle = paymentMethodOverlayHeader.getText();
        String actualChangePlanTitle = hybridBundelsResponseModel.title;
        Assert.assertEquals(expectedChangePlanTitle, actualChangePlanTitle);

        // assert on Change plan Subtitle
        String expectedChangePlanSubTitle = ChangePlanSubTitle.getText();
        String actualChangePlanSubTitle = hybridBundelsResponseModel.subTitle;
        Assert.assertEquals(expectedChangePlanSubTitle, actualChangePlanSubTitle);

        // assert on Change plan Description
        String expectedChangePlanDesc = ChangePlanDesc.getText();
        String actualChangePlanSubDesc = hybridBundelsResponseModel.headerText;
        Assert.assertEquals(expectedChangePlanDesc, actualChangePlanSubDesc);

        // assert on Change plan ChangePlanForNextMonthCard
        String expectedChangePlanForNextMonthCard = ChangePlanForNextMonthCard.getText();
        String actualChangePlanForNextMonthCard= hybridBundelsResponseModel.items.get(0).name;
        Assert.assertEquals(expectedChangePlanForNextMonthCard, actualChangePlanForNextMonthCard);

        // assert on Change plan RenewPlanEarlyCard
        String expectedRenewPlanEarlyCard = RenewPlanEarlyCard.getText();
        String actualRenewPlanEarlyCard= hybridBundelsResponseModel.items.get(1).name;
        Assert.assertEquals(expectedRenewPlanEarlyCard, actualRenewPlanEarlyCard);

        // assert on Change plan Continue CTA
        String expectedContinueCTA = changePlanChoosePlanContinueCTA.getText();
        String actualContinueCTA= hybridBundelsResponseModel.actions.get(0).text;
        Assert.assertEquals(expectedContinueCTA, actualContinueCTA);

    }

    @Override
    public void ChoseChangePlanForNextMonthCardAndClickContinueCTA() {
        waitForVisibility(paymentMethodOverlayHeader);
        ChangePlanForNextMonthCard.click();
        changePlanChoosePlanContinueCTA.click();

    }

    @Override
    public void ChoseRenewPlanEarlyCardAndClickContinueCTA(){
        waitForVisibility(paymentMethodOverlayHeader);
        RenewPlanEarlyCard.click();
        changePlanChoosePlanContinueCTA.click();
    }
}
