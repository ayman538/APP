package pages.SSOs;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SegmentUtils;

import java.time.Duration;

import static utils.element_helpers.GenericHelpers.CloseCookies;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class SsoLogic extends SsoPO {

    public SsoLogic() {
        super();
    }

    public void navigateToBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
    }

    public void validateBillingSSO() {
        String Segment = SegmentUtils.GetSegment_Type();
        if (Segment.equalsIgnoreCase("CONSUMER")) {
            waitForVisibility(Bill_Xicon);
            scrollDownTo(Bill_viewAllCTA);
            Bill_viewAllCTA.click();
        }
        CloseCookies(AcceptCookies);
        waitForVisibility(SSO_BillAndPayment);
        AssertDisplayed(SSO_BillAndPayment.isDisplayed());
    }

    public void validateLatestBillingSSO() {
        String Segment = SegmentUtils.GetSegment_Type();
        if (Segment.equalsIgnoreCase("CONSUMER")) {
            waitForVisibility(Bill_Xicon);
            Bill_latestBill.click();
        }
        waitForVisibility(SSO_LatestBill);
        AssertDisplayed(SSO_LatestBill.isDisplayed());
    }

    public void validateViewChargesCTA() {
        scrollDownTo(chargesViewDetails);
        chargesViewDetails.click();
        waitForVisibility(SSO_EstimateCharges);
        AssertResult(SSO_EstimateCharges.getText(),"Price Breakdown");
    }

    public void validateManageExtrasCTA() {
        scrollDownTo(Extras_BuyManageExtrasCTA);
        Extras_BuyManageExtrasCTA.click();
        waitForVisibility(SSO_ManageBarsExtras);
        AssertResult(SSO_ManageBarsExtras.getText(), "Manage extras");
    }

    public void navigateToAccountSettings() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        DB_SettingDashboardTray_icon.click();
        waitForVisibility(DB_AccountSetting);
        DB_AccountSetting.click();
        waitForVisibility(AS_SpendManager);
        AS_SpendManager.click();

    }

    public void validateSpendManagerSSO() {
        waitForVisibility(SSO_SpendManager);
        AssertDisplayed(SSO_SpendManager.isDisplayed());
    }

    public void ClickOnSpendManagerSSO(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(SSO_SpendManager));
       // wait(SSO_SpendManager);
        SSO_SpendManager.click();
    }

    public void ClickOnDataCapJourney() {
        waitForVisibility(Extras_DataCap);
        Extras_DataCap.click();
        waitForVisibility(Extras_ManageDataCap);
        Extras_ManageDataCap.click();
    }

    public void validateDataCapSSO() throws InterruptedException {
        Thread.sleep(1000);
        waitForVisibility(SSO_DataCap);
        AssertDisplayed(SSO_DataCap.isDisplayed());
    }

    public void validateUpgradeNowSSO() {
        waitForVisibility(UpgradeNow_CTA);
        UpgradeNow_CTA.click();
        waitForVisibility(SSO_UpgradeNow);
        AssertResult(SSO_UpgradeNow.getText(),"Upgrades");

    }

    public void validateDISCOVER_NBA_SIMOSSO() {
        driver.navigate().to("myvodafone://DISCOVER_NBA_SIMO");
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "My Vodafone");
    }

    public void validateDISCOVER_NBA_FLBB_SSO() {
        driver.navigate().to("myvodafone://DISCOVER_NBA_FLBB");
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "My Vodafone");
    }

    public void CloseWebView() throws InterruptedException {
        WV_Xicon.click();
        Thread.sleep(1000);
    }

    public void FLNdashboard(){
        waitForVisibility(DX_IDM_MyAccountTray);
        AssertResult(FLN.getText(),"Home Phone");
    }

    public void BBdashboard(){
        waitForVisibility(DX_IDM_MyAccountTray);
        AssertResult(BB.getText(),"Broadband");
    }

    public void openChangeYourPlan(){
        try {
            scrollDownTo(PT_ChangeYourPlan);
            waitForVisibility(PT_ChangeYourPlan);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(PT_ChangeYourPlan);
        PT_ChangeYourPlan.click();
    }

    public void validateChangeYourPlan(){
        waitForVisibility(SSO_ChangeYourPlan);
        AssertResult(SSO_ChangeYourPlan.getText(),"Change your plan");
    }

    public void openTrackAnOrder(){
        waitForVisibility(DB_TrackAnOrder);
        DB_TrackAnOrder.click();
    }

    public void validateTrackAnOrder(){
        waitForVisibility(SSO_TrackMyOrder);
        AssertResult(SSO_TrackMyOrder.getText(),"Track my order");
    }

    public void openMakeAPayment(){
        try {
            scrollDownTo(SO_DevicePlanMakePaymentCTA);
            waitForVisibility(SO_DevicePlanMakePaymentCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanMakePaymentCTA);
        SO_DevicePlanMakePaymentCTA.click();
    }

    public void validateMakeAPayment(){
        waitForVisibility(SSO_MakeAPayment);
        AssertResult(SSO_MakeAPayment.getText(),"Make a payment to your Device Plan");
    }

    public void openPaymentHistory(){
        try {
            scrollDownTo(SO_DevicePlanPaymentHistoryCTA);
            waitForVisibility(SO_DevicePlanPaymentHistoryCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanPaymentHistoryCTA);
        SO_DevicePlanPaymentHistoryCTA.click();
    }

    public void validatePaymentHistory(){
        waitForVisibility(SSO_PaymentHistory);
        AssertResult(SSO_PaymentHistory.getText(),"Payment history");
    }

    public void openViewMoreDetails(){
        try {
            scrollDownTo(SO_DevicePlanViewMoreDetailsCTA);
            waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        }catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        SO_DevicePlanViewMoreDetailsCTA.click();
    }

    public void validateViewMoreDetails(){
        waitForVisibility(SSO_ViewDetails);
        AssertResult(SSO_ViewDetails.getText(),"Device Plan documents");
    }

}