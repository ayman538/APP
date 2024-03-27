package pages.SSOs;

import models.response.TopUpResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.SegmentUtils;
import utils.TopUpUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.GenericHelpers.openDeepLinkForiOS;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class SSOios extends SSOabstract {
    By shop_extra_title = By.xpath("//XCUIElementTypeStaticText[@name='shopExtrasCardTitle']");
    By active_extras_title = By.xpath("//XCUIElementTypeStaticText[@name='activeExtrasControlCardTitle']");
    TopUpResponseModel TopUpResponse;
    Boolean live = System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true");

    @Override
    public void navigateToBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
    }

    @Override
    public void validateLatestBillingSSO() {
        if (live) {
            waitForVisibility(Bill_Xicon);
            Bill_latestBill.click();
        }else {
            String Segment = SegmentUtils.GetSegment_Type();
            if (Segment.equalsIgnoreCase("CONSUMER")) {
                waitForVisibility(Bill_Xicon);
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
        AssertDisplayed(WV_Xicon.isDisplayed());
        waitForVisibility(SSO_EstimateCharges);
        AssertResult(SSO_EstimateCharges.getText(),"Estimated total");
    }


    @Override
    public void validateManageExtrasCTA() {
        waitForVisibility(SSO_ManageBarsExtras);
        AssertResult(SSO_ManageBarsExtras.getAttribute("name"), "Manage extras");
        waitForVisibility(shop_extra_title);
        Assert.assertTrue(driver.findElement(shop_extra_title).isDisplayed());
        scrollDownTo(active_extras_title);
        Assert.assertTrue(driver.findElement(active_extras_title).isDisplayed());
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
        waitForVisibility(Extras_DataCap);
        Extras_DataCap.click();
        waitForVisibility(Extras_ManageDataCap);
        Extras_ManageDataCap.click();
    }

    @Override
    public void validateDataCapSSO() {
        waitForVisibility(SSO_DataCap);
        AssertDisplayed(SSO_DataCap.isDisplayed());
    }

    @Override
    public void validateUpgradeNowSSO() {
        /*waitForVisibility(UpgradeNow_CTA);
        UpgradeNow_CTA.click();
        waitForVisibility(tradeInUpgradeOnlyCTA);
        tradeInUpgradeOnlyCTA.click();*/
        waitForVisibility(SSO_UpgradeNow);
        AssertDisplayed(SSO_UpgradeNow.isDisplayed());
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
        openDeepLinkForiOS("myvodafone://DISCOVER_NBA_SIMO");
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "My Vodafone");
        waitForVisibility(Additional_Plan);
        AssertDisplayed(Additional_Plan.isDisplayed());
    }

    @Override
    public void validateDISCOVER_NBA_FLBB_SSO() {
        openDeepLinkForiOS("myvodafone://DISCOVER_NBA_FLBB");
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "My Vodafone");
        waitForVisibility(Additional_Plan);
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
        AssertResult(FLN.getText(), "Home Phone");
    }

    @Override
    public void BBdashboard() {
        waitForVisibility(DX_IDM_MyAccountTray);
        AssertResult(BB.getText(), "Broadband");
    }

    @Override
    public void openChangeYourPlan() {
        try {
            scrollDownTo(PT_ChangeYourPlan);
            waitForVisibility(PT_ChangeYourPlan);
        } catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(PT_ChangeYourPlan);
        PT_ChangeYourPlan.click();
    }

    public void validateChangeYourPlan() {
//         Assert internal screen header
        waitForVisibility(SSO_ChangeYourBundle);
        System.out.println("Internal webView header: " +SSO_ChangeYourBundle.getAttribute("name"));
        AssertResult(SSO_ChangeYourBundle.getAttribute("name"),"Change your bundle");
        waitForVisibility(WV_Xicon);
        AssertDisplayed(WV_Xicon.isDisplayed());

//         Asserting "change you plan" inside the webview
        waitForVisibility(SSO_ChangeYourPlan);
        AssertDisplayed(SSO_ChangeYourPlan.isDisplayed());
        AssertResult(SSO_ChangeYourPlan.getText(),"Change your plan");
    }

    @Override
    public void openTrackAnOrder() {
        scrollDownTo(DB_TrackAnOrder);
        waitForVisibility(DB_TrackAnOrder);
        doubleClick(DB_TrackAnOrder);
    }

    @Override
    public void validateTrackAnOrder() {
        waitForVisibility(SSO_TrackMyOrder);
        System.out.println(SSO_TrackMyOrder.getAttribute("name"));
        AssertResult(SSO_TrackMyOrder.getAttribute("name"), "Track my order");
    }

    @Override
    public void openMakeAPayment() {
        try {
            scrollDownTo(SO_DevicePlanMakePaymentCTA);
            waitForVisibility(SO_DevicePlanMakePaymentCTA);
        } catch (Exception e) {
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
        } catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanPaymentHistoryCTA);
        SO_DevicePlanPaymentHistoryCTA.click();
    }

    @Override
    public void validatePaymentHistory() {
        waitForVisibility(SSO_PaymentHistory);
        System.out.println(SSO_PaymentHistory.getText());
        AssertResult(SSO_PaymentHistory.getText(), "Payment history");
        AssertResult(SSO_DeviceTittle.getText(), "Device");
    }

    @Override
    public void openViewMoreDetails() {
        try {
            scrollDownTo(SO_DevicePlanViewMoreDetailsCTA);
            waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        } catch (Exception e) {
            scrollDown();
        }
        waitForVisibility(SO_DevicePlanViewMoreDetailsCTA);
        SO_DevicePlanViewMoreDetailsCTA.click();
    }

    @Override
    public void validateViewMoreDetails() {
        waitForVisibility(SSO_ViewDetails);
        System.out.println(SSO_ViewDetails.getText());
        AssertResult(SSO_ViewDetails.getText(), "Important documents");
        AssertResult(SSO_ActiveDevicePlans.getText(),"Active Device Plans");
    }

    @Override
    public void validateTrackAnOrderContent() {
        waitForVisibility(WV_Xicon);
        AssertResult(WV_Title.getText(), "My Vodafone");
        AssertDisplayed(WV_Xicon.isDisplayed());
    }

    @Override
    public void validateTopupIsDisplayed() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_TopUpTray_icon.isDisplayed());
    }

    @Override
    public void ClickOnTopup() {
        waitForVisibility(DB_TopUpTray_icon);
        DB_TopUpTray_icon.click();
    }

    @Override
    public void ClickOnActivateVoucher() {
        waitForVisibility(SO_TopUpTab);
        SO_ActivateVoucher.click();
    }

    @Override
    public void validateActivateVoucher() {
        waitForVisibility(WV_Xicon);
        AssertResult(WV_Title.getText(), "Activate Voucher");
        AssertDisplayed(WV_Xicon.isDisplayed());
    }

    @Override
    public void validateManageBarsContent() {
        waitForVisibility(SSO_ManageBarsExtras);
        AssertResult(WV_Title.getText(), "Manage Controls and Extras");
        AssertDisplayed(WV_Xicon.isDisplayed());
        HardAssertNotDisplayed("back arrow", elementIsPresent(WV_TitleBackCTA));
    }


    @Override
    public void validateIntCallsContent() {
        waitForVisibility(SSO_ManageBarsCallingOptionsTitle);
        AssertResult(SSO_ManageBarsCallingOptionsTitle.getText(), "Calling options");
        SSO_ManageBarsCallingOptionsTitle.click();
        waitForVisibility(WV_TitleBackCTA);
        AssertDisplayed(WV_Xicon.isDisplayed());
        AssertDisplayed(WV_TitleBackCTA.isDisplayed());
    }

    @Override
    public void ValidateMarketingPrefrences() {
        waitForVisibility(SSO_MarketingprefrencesTitle);
        AssertResult(SSO_MarketingprefrencesTitle.getText(), "Marketing preferences");
        waitForVisibility(SSO_Marketingprefrence_POST);
        AssertResult(SSO_Marketingprefrence_POST.getText(),"Post");
    }

    @Override
    public void NavigateToChargesSSO() {
        waitForVisibility(ChargesSSOTitle);
        AssertDisplayed(ChargesSSOTitle.isDisplayed());
    }

    @Override
    public void ValidateChargesSSOScreen() {
        waitForVisibility(ChargesSSOTitle);
        AssertResult(ChargesSSOTitle.getText(), "Estimated charges");
    }

    @Override
    public void ValidateTopUpItems() {
        waitForVisibility(SO_TopUpTab);
        assertEquals(SO_TopUpTab.getText(), "Top up");
        System.out.println("Size of TopUp items is  " + getTopupLItemsList().size());
        for (int i = 0; i < getTopupLItemsList().size(); i++) {
            System.out.println(getTopupLItemsList().get(i));
            TopUpResponse = TopUpUtils.getTopUp();
            String ApiTopUpTitle = (TopUpResponse.topUp.cards.get(i).title);
            assertEquals(getTopupLItemsList().get(i), ApiTopUpTitle);
            Assert.assertTrue(getElementByText(ApiTopUpTitle).isDisplayed());
        }
    }

    @Override
    public List<String> getTopupLItemsList(){
        List<String> TopUpItemsText = new ArrayList<>();
        List<WebElement> TopUpItemsElements= driver.findElements(By.name("lnkTopUpOptionsLabel"));
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
