package pages.RedHybrid.QuickLinks;

import models.response.DashboardV4ResponseModel;
import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginPO;
import testdata.ReadTestData;
import utils.DashboardUtils;

import static utils.element_helpers.ActionsHelpers.doubleClick;
import static utils.element_helpers.ScrollHelpers.scrollDownElementOverCenterScreen;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class QuickLinks_IOS extends QuickLinks_Abstract {

    String username = ReadTestData.getUsername();
    DX_IDM_FullLoginPO dX_IDM_FullLoginPO = new DX_IDM_FullLoginPO();
    DashboardV4ResponseModel dashboardV4ResponseModel ;


    public QuickLinks_IOS() {
        super();
    }

    @Override
    public void iAmARedHybridUserAndSkipLogin() {
        waitForVisibility(SkipLoginCTA);
        SkipLoginCTA.click();
        try {
            waitForVisibility(ReturnToMyVodafoneCTA);
            ReturnToMyVodafoneCTA.click();
        } catch (Exception e) {
            //doNothing
        }
    }


    @Override
    public void iExpectToSeeANewSectionDisplayedUnderTheDiscoverCarouselAs() throws InterruptedException {
        Thread.sleep(3000);
        scrollDownTo(QuickLinks);
        AssertDisplayed(QuickLinks.isDisplayed());
    }


    @Override
    public void iClickOnTheManagePaymentsItem() throws InterruptedException {
        Thread.sleep(2000);
        scrollDownTo(QuickLinks_ManagePayments);
        waitForVisibility(QuickLinks_ManagePayments);
        doubleClick(QuickLinks_ManagePayments);
    }

    @Override
    public void iExpectToBeRedirectedToThePaymentsFlow() {
        AssertDisplayed(QuickLinks_ManagePaymentsPage.isDisplayed());
    }

    @Override
    public void acceptCookies() {
        try {
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        } catch (Exception e) {
            //doNothing
        }
    }

    @Override
    public void iAmARedHybridUserAndLoggedIn() throws InterruptedException {
        try {
            waitForVisibility(LoginCTA);
            LoginCTA.click();
            acceptCookies();
            waitForVisibility(DX_IDM_Username);
            System.out.println(username);
            DX_IDM_Username.sendKeys(username);
            Thread.sleep(1000);
            DX_IDM_ContinueCTA.click();
            waitForVisibility(DX_IDM_Password);
            DX_IDM_Password.sendKeys("testing1");
            DX_IDM_PasswordLoginCTA.click();
            Thread.sleep(5000);
            waitForVisibility(dX_IDM_FullLoginPO.DX_IDM_LoginPreferencesTitle);
            AssertDisplayed(dX_IDM_FullLoginPO.DX_IDM_LoginPreferencesOkCTA.isDisplayed());
            dX_IDM_FullLoginPO.DX_IDM_LoginPreferencesOkCTA.click();
            Thread.sleep(5000);
        } catch (Exception e) {
            //doNothing
        }
        try {
            waitForVisibility(ReturnToMyVodafoneCTA);
            ReturnToMyVodafoneCTA.click();
        } catch (Exception e) {
            //doNothing
        }
    }


    @Override
    public void changePlanQuickLinkUiIsRespected() {
        dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();
        System.out.println("guid for dashboard is " + dashboardV4ResponseModel.status.analytics.guid);
        Assert.assertTrue(dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).title.contains("Quick Links"));
        String expectedChangePlanQuickLinkText = quickLinkChangePlan.getText();
        String actualChangePlanQuickLinkText = dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).subLinks.get(0).title;
        Assert.assertEquals(expectedChangePlanQuickLinkText,actualChangePlanQuickLinkText);

    }

    @Override
    public void managePaymentQuickLinkUiIsRespected(String Version) {
        if(Version.equalsIgnoreCase("Beta")) {
            dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();
            Assert.assertTrue(dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).title.contains("Quick Links"));
            String expectedManagePlanQuickLinkText = quickLinkManagePayment.getText();
            String actualManagePlanQuickLinkText = dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).subLinks.get(1).title;
            Assert.assertEquals(expectedManagePlanQuickLinkText, actualManagePlanQuickLinkText);
        } else if (Version.equalsIgnoreCase("PostBeta")) {
            dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();
            Assert.assertTrue(dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).title.contains("Quick Links"));
            String expectedManagePlanQuickLinkText = quickLinkManagePayment.getText();
            String actualManagePlanQuickLinkText = dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).subLinks.get(2).title;
            Assert.assertEquals(expectedManagePlanQuickLinkText, actualManagePlanQuickLinkText);
        }
    }

    @Override
    public void scrollToQuickLinks() {
        scrollDownElementOverCenterScreen(QuickLinks);
        waitForVisibility(changeNextPlanQuickLinks);
    }

    @Override
    public void renewEarlyQuickLinkUiIsRespected(){
        dashboardV4ResponseModel = DashboardUtils.GetDashboardRedHybrid();
        Assert.assertTrue(dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).title.contains("Quick Links"));
        String expectedRenewEarlyQuickLinkText = quickLinkRenewEarly.getText();
        String actualRenewEarlyQuickLinkText = dashboardV4ResponseModel.quickLinksMenu.quickLinks.get(0).subLinks.get(1).title;
        Assert.assertEquals(expectedRenewEarlyQuickLinkText,actualRenewEarlyQuickLinkText);

    }

    @Override
    public void iClickOnRenewEarlyFromQuickLinks() {
        scrollDownTo(quickLinkRenewEarly);
        waitForVisibility(quickLinkRenewEarly);
        doubleClick(quickLinkRenewEarly);

    }
    @Override
    public void changeNextPlanFromQuickLinksWithoutClickOnPaymentSkipCTA(){
        scrollDownElementOverCenterScreen(quickLinkChangePlan);
        waitForVisibility(quickLinkChangePlan);
        doubleClick(quickLinkChangePlan);
    }

}
