package pages.SSOs;

import models.response.TopUpResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.SegmentUtils;
import utils.TopUpUtils;

import java.util.ArrayList;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class SSOandroid extends SSOabstract{
    TopUpResponseModel TopUpResponse;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    @Override
    public void navigateToBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
    }

    @Override
    public void validateLatestBillingSSO() {
        if(live){
            waitForVisibility(Bill_latestBill);
            Bill_latestBill.click();
        }else {
        String Segment = SegmentUtils.GetSegment_Type();
        if (Segment.equalsIgnoreCase("CONSUMER")) {
            waitForVisibility(Bill_latestBill);
            Bill_latestBill.click();
        }
        }
        waitForVisibility(SSO_LatestBill);
        AssertDisplayed(SSO_LatestBill.isDisplayed());
    }

    @Override
    public void validateViewChargesCTA() {
        waitForVisibility(ChargesSSOTitle);
        AssertResult(ChargesSSOTitle.getText(),"Estimated charges");
        AssertDisplayed(ChargesSSOXIcon.isDisplayed());
        waitForVisibility(SSO_EstimateCharges);
        AssertResult(SSO_EstimateCharges.getText(),"Estimated total");
    }

    @Override
    public void validateManageExtrasCTA() {
        if(live) {
            By Shop_Extras = By.id("com.myvodafoneapp:id/shopExtrasCardTitle");
            By Active_Extras = By.id("com.myvodafoneapp:id/extraHeaderTextView");
            waitForVisibility(Shop_Extras);
            Assert.assertTrue(driver.findElement(Shop_Extras).getText().contains("Shop Extras"));
            Assert.assertTrue(driver.findElement(Active_Extras).getText().contains("Active Extras"));
        }else{
            waitForVisibilityForReinvent(SSO_ManageBarsExtras, 100);
            AssertResult(SSO_ManageBarsExtras.getText(), "Manage extras");
        }
    }
    public void openManageExtrasCTA(){
        waitForVisibilityForReinvent(Extras_BuyManageExtrasCTA,100);
        doubleClick(Extras_BuyManageExtrasCTA);
    }

    @Override
    public void navigateToAccountSettings() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
        waitForVisibility(AS_SpendManager);

    }

    @Override
    public void validateSpendManagerSSO() {
        waitForVisibility(AS_SpendManager);
        AS_SpendManager.click();
        waitForVisibility(SSO_SpendManager);
        AssertDisplayed(SSO_SpendManager.isDisplayed());
    }

    @Override
    public void ClickOnSpendManagerSSO() {
        waitForVisibility(SSO_SpendManager);
        SSO_SpendManager.click();
    }

    @Override
    public void ClickOnDataCapJourney() {
        waitForVisibilityForReinvent(Extras_DataCap,100);
        doubleClick(Extras_DataCap);
        waitForVisibilityForReinvent(Extras_ManageDataCap,100);
        Extras_ManageDataCap.click();
    }

    @Override
    public void validateDataCapSSO() throws InterruptedException {
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            System.out.println("cookies already accepted");
        }
        Thread.sleep(1000);
        waitForVisibility(SSO_DataCap);
        AssertDisplayed(SSO_DataCap.isDisplayed());
    }

    @Override
    public void validateUpgradeNowSSO() {
        waitForVisibility(SSO_UpgradeNow);
        AssertResult(SSO_UpgradeNow.getText(),"tab 1 of 2 Upgrades");
    }

    @Override
    public void ExitWebView() {
        waitForVisibility(ExitWebView_Icon);
        ExitWebView_Icon.click();
    }

    @Override
    public void AssertExitConfirmationMsg(String ConfirmationMsg) {
        waitForVisibility(ExitWebView_ConfirmationMsg);
        AssertResult(ExitWebView_ConfirmationMsg.getText(),ConfirmationMsg);

    }
    @Override
    public void validateDISCOVER_NBA_SIMOSSO() {
        driver.navigate().to("myvodafone://DISCOVER_NBA_SIMO");
        waitForVisibility(Additional_Plan);
        AssertResult(WV_Title.getText(), "My Vodafone");
        AssertDisplayed(Additional_Plan.isDisplayed());
    }

    @Override
    public void validateDISCOVER_NBA_FLBB_SSO() {
        driver.navigate().to("myvodafone://DISCOVER_NBA_FLBB");
        waitForVisibility(Additional_Plan);
        AssertResult(WV_Title.getText(), "My Vodafone");
        AssertDisplayed(Additional_Plan.isDisplayed());
    }

    @Override
    public void CloseWebView() throws InterruptedException {
        WV_Xicon.click();
        Thread.sleep(1000);
    }

    @Override
    public void FLNdashboard() {
        waitForVisibility(DX_IDM_MyAccountTray);
        AssertResult(FLN.getText(),"Home Phone");
    }

    @Override
    public void BBdashboard() {
        waitForVisibility(DX_IDM_MyAccountTray);
        AssertResult(BB.getText(),"Broadband");
    }

    @Override
    public void openChangeYourPlan() {
        try {
            scrollDownTo(PT_ChangeYourPlan);
            waitForVisibility(PT_ChangeYourPlan);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(PT_ChangeYourPlan);
        PT_ChangeYourPlan.click();
    }

    @Override
    public void validateChangeYourPlan() {
        // Assert internal screen header
        waitForVisibility(SSO_ChangeYourBundle);
        System.out.println(SSO_ChangeYourBundle.getAttribute("name"));
        AssertResult(SSO_ChangeYourBundle.getText(),"Change your bundle");

        // Asserting change you plan inside the webview
        waitForVisibility(SSO_ChangeYourPlan);
        AssertDisplayed(SSO_ChangeYourPlan.isDisplayed());
        AssertResult(SSO_ChangeYourPlan.getText(),"Change your plan");
    }


    @Override
    public void openTrackAnOrder() {
        scrollDownTo(DB_NetworkTitle);
        DB_TrackAnOrder.click();
    }

    @Override
    public void validateTrackAnOrder() {
        waitForVisibility(SSO_TrackMyOrder);
        AssertResult(SSO_TrackMyOrder.getText(),"Track my order");
    }

    @Override
    public void openMakeAPayment() {
        try {
            scrollDownTo(SO_DevicePlanMakePaymentCTA);
            waitForVisibility(SO_DevicePlanMakePaymentCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanMakePaymentCTA);
        SO_DevicePlanMakePaymentCTA.click();
    }

    @Override
    public void validateMakeAPayment() {
        waitForVisibility(SSO_MakeAPayment);
        AssertResult(SSO_MakeAPayment.getText(),"Make a payment to your Device Plan");
        AssertResult(SSO_MakeFullPaymentCTA.getText(),"Make full payment");
    }

    @Override
    public void openPaymentHistory() {
        try {
            scrollDownTo(SO_DevicePlanPaymentHistoryCTA);
            waitForVisibility(SO_DevicePlanPaymentHistoryCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanPaymentHistoryCTA);
        SO_DevicePlanPaymentHistoryCTA.click();
    }

    @Override
    public void validatePaymentHistory() {
        waitForVisibility(SSO_PaymentHistory);
        AssertResult(SSO_PaymentHistory.getText(),"Payment history");
        AssertResult(SSO_DeviceTittle.getText(), "Device");
    }

    @Override
    public void openViewMoreDetails() {
        try {
            scrollDownTo(SO_DevicePlanViewMoreDetailsCTA);
            waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        SO_DevicePlanViewMoreDetailsCTA.click();
    }

    @Override
    public void validateViewMoreDetails() {
        waitForVisibility(SSO_ViewDetails);
        AssertResult(SSO_ViewDetails.getText(),"Important documents");
        AssertResult(SSO_ActiveDevicePlans.getText(),"Active Device Plans");
    }

    @Override
    public void validateTrackAnOrderContent()
    {
        waitForVisibility(WV_Xicon);
        AssertResult(SSO_TrackMyOrder.getText(),"Track my order");
        AssertDisplayed(WV_Xicon.isDisplayed());

    }

    @Override
    public void validateTopupIsDisplayed()
    {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_TopUpTray_icon.isDisplayed());

    }

    @Override
    public void ClickOnTopup()
    {
        waitForVisibility(DB_TopUpTray_icon);
        DB_TopUpTray_icon.click();
        waitForVisibility(SO_TopUpTab);

    }

    @Override
    public void ClickOnActivateVoucher()
    {
        waitForVisibility(SO_TopUpTab);
        SO_ActivateVoucher.click();
    }

    @Override
    public void validateActivateVoucher() {
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(),"Activate Voucher");
        AssertDisplayed(WV_Xicon.isDisplayed());
    }

    @Override
    public void validateManageBarsContent(){
        waitForVisibility(SSO_ManageBarsExtras);
        AssertResult(SSO_ManageBarsExtras.getText(),"Manage extras");
        AssertDisplayed(WV_Xicon.isDisplayed());
        HardAssertNotDisplayed("back arrow",elementIsPresent(WV_TitleBackCTA));
    }

    @Override
    public void validateIntCallsContent(){
        waitForVisibility(SSO_ManageBarsCallingOptionsTitle);
        AssertResult(SSO_ManageBarsCallingOptionsTitle.getText(),"Calling options");
        SSO_ManageBarsCallingOptionsTitle.click();
        waitForVisibility(WV_TitleBackCTA);
        AssertDisplayed(WV_Xicon.isDisplayed());
        AssertDisplayed(WV_TitleBackCTA.isDisplayed());
    }

    @Override
    public  void ValidateMarketingPrefrences(){
        waitForVisibility(SSO_MarketingprefrencesTitle);
        AssertResult(SSO_MarketingprefrencesTitle.getText(),"Marketing preferences");
        waitForVisibility(SSO_Marketingprefrence_POST);
        AssertResult(SSO_Marketingprefrence_POST.getText(),"Post");
    }
    @Override
    public void NavigateToChargesSSO(){
        waitForVisibility(ChargesSSOTitle);
        AssertDisplayed(ChargesEstimatedSSO.isDisplayed());
    }

    @Override
    public void ValidateChargesSSOScreen(){
        waitForVisibility(ChargesSSOTitle);
        AssertResult(ChargesSSOTitle.getText(),"Estimated charges");
        AssertDisplayed(ChargesSSOXIcon.isDisplayed());
    }

    @Override
    public void ValidateTopUpItems() {
        TopUpResponse= TopUpUtils.getTopUp();
        waitForVisibility(SO_TopUpTab);
        assertEquals(SO_TopUpTab.getText(), "Top up");
            System.out.println("Size of TopUp items is  " + getTopupLItemsList().size());
            for (int i = 0; i < getTopupLItemsList().size(); i++) {
                System.out.println(getTopupLItemsList().get(i));
                String ApiTopUpTitle = (TopUpResponse.topUp.cards.get(i).title);
                assertEquals(getTopupLItemsList().get(i), ApiTopUpTitle);
                Assert.assertTrue(getElementByText(ApiTopUpTitle).isDisplayed());
            }
        }


    @Override
    public List<String> getTopupLItemsList(){
        List<String> TopUpItemsText = new ArrayList<>();
        List<WebElement> TopUpItemsElements= driver.findElements(By.xpath("//*[@resource-id='com.myvodafoneapp:id/lnkTopUpOptionsLabel']"));
        for (WebElement TopUpItemElement: TopUpItemsElements){
            TopUpItemsText.add(TopUpItemElement.getText());
        }
        return TopUpItemsText;

    }
    public void UpgradeNow(){
        waitForVisibility(UpgradeNow_CTA);
        UpgradeNow_CTA.click();

    }
    public void validateUpgradeScreen(){
        waitForVisibility(tradeInUpgradeOnlyCTA);
        AssertDisplayed(driver.findElement(By.xpath(GetXpath("Trade-in and upgrade"))).isDisplayed());

    }

}
