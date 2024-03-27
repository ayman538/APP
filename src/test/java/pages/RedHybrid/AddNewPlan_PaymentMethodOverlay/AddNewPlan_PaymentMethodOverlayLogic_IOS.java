package pages.RedHybrid.AddNewPlan_PaymentMethodOverlay;

import models.response.HybridBundelsResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.HybridBundelsUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AddNewPlan_PaymentMethodOverlayLogic_IOS extends AddNewPlan_PaymentMethodOverlay_Abstract{

    public AddNewPlan_PaymentMethodOverlayLogic_IOS(){ super(); }
    public ArrayList<HybridBundelsResponseModel.Item> items;
    HybridBundelsResponseModel hybridBundelsResponseModel ;

    @Override
    public void paymentMethodOverlayAppears() {
        waitForVisibility(paymentMethodOverlayHeader);
        Assert.assertEquals(paymentMethodOverlayHeader.getText() , "Add a new plan");
        scrollDownTo(paymentMethodOverlayContinueCTA);
        Assert.assertEquals(paymentMethodOverlayContinueCTA.getText() , "Continue");
        Assert.assertTrue(NoPaymentMethodCloseBtn.isDisplayed());
        Assert.assertTrue(imgRedHybridBackView.isDisplayed());
        Assert.assertTrue(paymentMethodOverlayContinueCTA.isDisplayed());
    }

    @Override
    public void paymentMethodOverlayAppears(String paymentMethodOverlay_Title) {
        waitForVisibility(paymentMethodOverlayHeader);
        Assert.assertEquals(paymentMethodOverlayHeader.getText() , paymentMethodOverlay_Title);
        scrollDownTo(paymentMethodOverlayContinueCTA);
        Assert.assertEquals(paymentMethodOverlayContinueCTA.getText() , "Continue");
        Assert.assertTrue(NoPaymentMethodCloseBtn.isDisplayed());
        Assert.assertTrue(paymentMethodOverlayContinueCTA.isDisplayed());
        if(!(paymentMethodOverlay_Title.equals("Auto-Renew")))
            Assert.assertTrue(imgRedHybridBackView.isDisplayed());
    }

    @Override
    public void checkTheUIOfCellWithPromotedPlan() {
        String PlanHasPromoTotalData = null, PlanHasPromoOriginalData = null, planPrice= null;
        waitForVisibility(addFlexiPlanHeader);
        AssertDisplayed(RedHybrid_BottomSheetDismissCTA.isDisplayed());
        hybridBundelsResponseModel = getHybridBundlesResponse();

        for(int plans=0; plans < hybridBundelsResponseModel.items.size() ; plans++){
            if(hybridBundelsResponseModel.items.get(plans).originalAllowance != null){
                PlanHasPromoTotalData = hybridBundelsResponseModel.items.get(plans).allowance;
                PlanHasPromoOriginalData = hybridBundelsResponseModel.items.get(plans).originalAllowance;
                planPrice = hybridBundelsResponseModel.items.get(plans).priceText;

                //plus plan text to be removed for promos plans
                assertEquals(hybridBundelsResponseModel.items.get(plans).name,null);
                break;
            }
        }

        assertCommonUI();

        if (PlanHasPromoTotalData != null){
            while(!driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed()){
                // swipe to targeted cell
                SwipeToElement(driver.findElement(By.xpath(GetXpath(PlanHasPromoTotalData))),"Right");
            }
            // assert on promo plan sash
            AssertDisplayed(Redhybrid_PromoSashForPromotedPlans.isDisplayed());

            // assert on promo plan original data
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(PlanHasPromoOriginalData))).isDisplayed());

            // assert on promo plan total data
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(PlanHasPromoTotalData))).isDisplayed());

            // assert on promo plan price
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed());

            // assert on promo terms apply link
            AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());

        }
    }


    @Override
    public void checkTheUIOfCellWithNopromotedPlans() {
        String PlanWithNoPromoData = null, planPrice= null;
        waitForVisibility(addFlexiPlanHeader);
        AssertDisplayed(RedHybrid_BottomSheetDismissCTA.isDisplayed());

        hybridBundelsResponseModel = getHybridBundlesResponse();

        for(int plans=0; plans < hybridBundelsResponseModel.items.size() ; plans++){
            if(hybridBundelsResponseModel.items.get(plans).originalAllowance == null){
                PlanWithNoPromoData = hybridBundelsResponseModel.items.get(plans).allowance;
                planPrice = hybridBundelsResponseModel.items.get(plans).priceText;

                //plus plan text to be removed for promos plans
                assertEquals(hybridBundelsResponseModel.items.get(plans).name,null);
                break;
            }
        }

        assertCommonUI();

        if (PlanWithNoPromoData != null ){
            while (!driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed()){
                // swipe to targeted cell
                SwipeToElement(driver.findElement(By.xpath(GetXpath(PlanWithNoPromoData))),"Right");
            }

            // assert on no promo plan total data
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(PlanWithNoPromoData))).isDisplayed());

            // assert on no promo plan price
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(planPrice))).isDisplayed());

            // assert on promo terms apply link
            AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());
        }

    }


    @Override
    public void clickOnPromosTermsApplyLink() {
        AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());
        doubleClick(RedHybrid_PromoTermsApplyLink);
        AcceptCookies.isDisplayed();
        AcceptCookies.click();
        AssertDisplayed(MyVodafoneTitle.isDisplayed());
    }

    @Override
    public void promosTermsScreen() {
        AssertDisplayed(MyVodafoneTitle.isDisplayed());
        AssertDisplayed(WV_Xicon.isDisplayed());
        AssertDisplayed(WV_Title.isDisplayed());
        doubleClick(WV_Xicon);
        AssertDisplayed(RedHybrid_PromoTermsApplyLink.isDisplayed());
    }


    public HybridBundelsResponseModel getHybridBundlesResponse(){
        Map<String, String> queryParameters = new HashMap<String, String>() {{
            put("orderType", "add-new");
        }};
        return HybridBundelsUtils.getHybridBundelsResponse(queryParameters);
    }


    public void assertCommonUI(){
        // assert plan header
        String ActualPlanName= hybridBundelsResponseModel.title ;
        String ExpectedPlanName =addFlexiPlanHeader.getText();
        assertEquals(ActualPlanName,ExpectedPlanName);

        // assert Plan title
        String ActualPlanTitle= hybridBundelsResponseModel.subTitle ;
        String ExpectedPlanTitle =AddPlanTitle.getText();
        assertEquals(ActualPlanTitle,ExpectedPlanTitle);
        AssertDisplayed(RadioButtonAddPlanOverlay.isDisplayed());
    }
}
