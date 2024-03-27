package pages.SubsctionOverlay.NewPlanDesign.OneNumberCard;

import io.appium.java_client.AppiumBy;
import models.response.DashboardV4ResponseModel;
import models.response.OneNumberDetailResponseModel;
import models.response.PlanV3ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import testdata.ReadResponse;
import utils.DashboardUtils;
import utils.OneNumberDetailUtils;
import utils.PlanUtils;
import java.util.List;


import static core.Config.getSegment;
import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class OneNumberCard_Android extends OneNumberCard_Abstract {
    PlanV3ResponseModel PlanResponseModel;
    OneNumberDetailResponseModel OneNumberDetailsResponse;
    DashboardV4ResponseModel dashboardV4ResponseModel;
    public OneNumberCard_Android() {
        super();
        PlanResponseModel = PlanUtils.GetPlanV3();
        OneNumberDetailsResponse = OneNumberDetailUtils.getOneNumberDetail();
        dashboardV4ResponseModel = DashboardUtils.GetDashboard();
    }
    //Webelement Locators
    By UsageTab = By.xpath("//android.widget.LinearLayout[@content-desc=\"Usage\"]/android.widget.TextView");
    By OneNumber_ConnectionsNo = By.id("com.myvodafoneapp:id/one_number_connections");
    By AddaConnectionCTA = By.id("com.myvodafoneapp:id/one_number_add_connection_action");
    By ConnectionIcon = By.id("com.myvodafoneapp:id/one_number_connections_icon");
    By ConnectionName = By.id("com.myvodafoneapp:id/one_number_connections_name");
    By ConnectionSerial = By.id("com.myvodafoneapp:id/one_number_connections_serial");
    By WebviewClose = By.id("com.myvodafoneapp:id/btnClose");
    By ViewDetailsCTA = By.id("com.myvodafoneapp:id/one_number_connections_view_details_action");

    //manage subscription tray
    By SubscriptionTrayTitle = By.id("com.myvodafoneapp:id/view_details_tray_title");
    By SubscriptionTrayFriendlyName = By.id("com.myvodafoneapp:id/one_number_connection_name");
    By SubscriptionTrayIcon = By.id("com.myvodafoneapp:id/one_number_connection_icon");
    By SubscriptionTrayCTN = By.id("com.myvodafoneapp:id/one_number_connection_serial");
    By SubscriptionPlanCostTitleLeft = By.id("com.myvodafoneapp:id/plan_cost_left_title_text_view");
    By SubscriptionPlanCostTitleRight = By.id("com.myvodafoneapp:id/plan_cost_right_title_text_view");
    By SubscriptionPlanCostTextLeft = By.id("com.myvodafoneapp:id/plan_cost_left_text");
    By SubscriptionPlanCostTextRight = By.id("com.myvodafoneapp:id/plan_cost_right_text");
    By agreementTitle = By.id("com.myvodafoneapp:id/plan_agreement_title");
    By tooltipIcon = By.id("com.myvodafoneapp:id/imgManagementTrayAgreementView_0");
    By toolTipDescription = By.id("com.myvodafoneapp:id/pageBannerBody");
    By toolTipThanksCTA = By.id("com.myvodafoneapp:id/pageBannerPositiveActionButton");
    By manageConnectionCTA = By.id("com.myvodafoneapp:id/one_number_manage_connection_action");
    By videoPlayer = By.id("com.myvodafoneapp:id/one_numbervideo_view");


    //subscription state tray elements
    By TrayTitle = By.id("com.myvodafoneapp:id/bottomSheetTitle");
    By TrayClose = By.id("com.myvodafoneapp:id/bottomSheetCloseImg");
    By TrayIcon = By.id("com.myvodafoneapp:id/bottomSheetIcon");
    By TrayDescription = By.id("com.myvodafoneapp:id/bottomSheetDescription");
    By TraySubDescritpion = By.id("com.myvodafoneapp:id/bottomSheetSubDescription");
    By TrayActionCTA = By.id("com.myvodafoneapp:id/btnActionCTA");




    @Override
    public void navigateToPlanTab() {
        System.out.println("Wait till the DB_SettingDashboardTray_icon displayed " + DB_SettingDashboardTray_icon);
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Get the VOV hide CTA ");
        HideVOV(DB_VOVhideCTA);
        System.out.println("Wait till the control tile displayed ");
        waitForVisibility(DB_ControlTile);
        System.out.println(" Click on the control tile ");
        DB_ControlTile.click();
        System.out.println("Wait till the plan tab displayed ");
        //waitForVisibility(SO_MSISDN);
        waitForVisibility(SO_PlanTabContent);
    }

    @Override
    public void validateImage() {
        System.out.println("Given validate the one number image");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoImageDisplayedMBB();
        } else {
            assertPlanOneNoImageDisplayedNonMBB();
        }
    }

    @Override
    public void assertPlanOneNoImageDisplayedNonMBB() {
        System.out.println("Else the user type is not MBB");
        scrollDownTo(Plan_OneNumber_Hero_Image);
        System.out.println("Scroll to one number hero image");
        AssertDisplayed(Plan_OneNumber_Hero_Image.isDisplayed());
        System.out.println("Should the one number hero image displayed ");
    }

    @Override
    public void assertPlanOneNoImageDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_Hero_Image);
    }

    @Override
    public void assertElementNotExistForMBB() {

    }


    public void assertElementNotExistForMBB(WebElement element) {
        System.out.println("if the user type is MBB");
        AssertDisplayed(CheckElementNotExist(element));
        System.out.println("Check the one number element " + (element));
    }

    @Override
    public void validateTitle() {
        System.out.println(" Given validate the one number title ");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoTitleDisplayedMBB();
        } else {
            assertPlanOneNoTitleTextMBB();
        }
    }

    @Override
    public void assertPlanOneNoTitleTextMBB() {
        AssertDisplayed(Plan_OneNumber_title.isDisplayed());

    }

    @Override
    public void assertPlanOneNoTitleDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_title);
    }

    @Override
    public void validateDescription() {
        System.out.println("Given validate the one number description ");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoDescriptionDisplayedMBB();
        } else {
            assertPlanOneNoDescriptionTextNonMBB();
        }
    }

    @Override
    public void assertPlanOneNoDescriptionTextNonMBB() {
        AssertDisplayed(Plan_OneNumber_description.isDisplayed());


    }

    @Override
    public void assertPlanOneNoDescriptionDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_description);
    }

    @Override
    public void validateCTAsDisplayed() {
        System.out.println(" Given validate the CTA displayed for one login");
        if (getSegment().toLowerCase().contains("consumer")) {
            System.out.println("if the user type is eligible to one login ");
            if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
                assertPlanOneNoManageDevicesDisplayedMBB();
            } else {
                assertPlanOneNoManageDevicesTextNonMBB();
            }
        } else {
            System.out.println("Else the user is not MBB and not eligible ");
            if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
                System.out.println("if the uses MBB  ");
                assertPlanOneNoGetConnectedDisplayedMBB();
                assertPanOneNoFindOutMoreDisplayedMBB();

            } else {
                assertPlanOneNoGetConnectedTextNonMBB();
                assertPanOneNoFindOutMoreTextNonMBB();
            }
        }
    }

    @Override
    public void assertPanOneNoFindOutMoreTextNonMBB() {
        AssertDisplayed(Plan_OneNumber_Findoutmore.isDisplayed());


    }

    @Override
    public void assertPlanOneNoGetConnectedTextNonMBB() {
        AssertDisplayed(Plan_OneNumber_GetConnected.isDisplayed());


    }

    @Override
    public void assertPanOneNoFindOutMoreDisplayedMBB() {
        AssertDisplayed(CheckElementNotExist(Plan_OneNumber_Findoutmore));
        System.out.println("Check The one number find more button is not displayed ");
    }

    @Override
    public void assertPlanOneNoGetConnectedDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_GetConnected);
    }

    @Override
    public void clickOnYourPlanAndNavigateToOneNumberCard() {
        waitForVisibility(SO_PlanTabContent);
        SO_PlanTabContent.click();
        scrollDownTo(Plan_OneNumber_Hero_Image);
        scrollDown();
    }

    @Override
    public void clickOnGetConnectedCTA() {
        scrollDownTo(Plan_OneNumber_GetConnected);
        Plan_OneNumber_GetConnected.click();
    }

    @Override
    public void clickOnFindOutMoreCTA() {
        scrollDownTo(Plan_OneNumber_Findoutmore);
        Plan_OneNumber_Findoutmore.click();
    }

    @Override
    public void assertThatGetConnectedWebViewIsDisplayedSuccessfully() {
        waitForVisibility(DoneCtaInExternalbrowser);
        DoneCtaInExternalbrowser.click();
    }

    @Override
    public void assertThatFindOutMoreWebViewIsDisplayedSuccessfully() {
        waitForVisibility(DoneCtaInExternalbrowser);
        DoneCtaInExternalbrowser.click();
    }


    @Override
    public void assertPlanOneNoManageDevicesTextNonMBB() {
        System.out.println("Else the user type is not MBB");
        scrollDownTo(Plan_OneNumber_Managedevices);
        System.out.println("scroll down to the one number manged devices " + (Plan_OneNumber_Managedevices));
        AssertResult(Plan_OneNumber_Managedevices.getText(), "Manage Devices");
        System.out.println("Should the the one number manged " + Plan_OneNumber_Managedevices.getText());
    }

    @Override
    public void assertPlanOneNoManageDevicesDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_Managedevices);
    }

    @Override
    public void validateCTAsFunctional() throws InterruptedException {
        if (getSegment().toLowerCase().contains("consumer")) {
            PlanOneNoManageDevicesCTA();
            assertDoneCTADisplayed();
        } else {
            PlanOneNoGetConnectedCTA();
            assertDoneCTADisplayed();
            DoneCTA();
            PlanOneNoFindOutMoreCTA();
            assertDoneCTADisplayed();
            DoneCTA();
        }
    }

    @Override
    public void PlanOneNoFindOutMoreCTA() throws InterruptedException {
        scrollDownTo(Plan_OneNumber_Findoutmore);
        Plan_OneNumber_Findoutmore.click();
        Thread.sleep(3000);
    }

    @Override
    public void DoneCTA() {
        DoneCtaInExternalbrowser.click();
        waitForVisibility(SO_PlanTabContent);
    }

    @Override
    public void PlanOneNoGetConnectedCTA() {
        scrollDownTo(Plan_OneNumber_GetConnected);
        Plan_OneNumber_GetConnected.click();
    }

    @Override
    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }

    @Override
    public void PlanOneNoManageDevicesCTA() {
        System.out.println("If the user has eligibility contain One Number ");
        scrollDownTo(Plan_OneNumber_Managedevices);
        System.out.println("Scroll down to ");
        Plan_OneNumber_Managedevices.click();
    }

    @Override
    public void ClickOnYourPlanAndNavigateToTheNewOneNumber() {
        waitForVisibility(SO_PlanTabContent);
        SO_PlanTabContent.click();
        //Check whether there is "Add a connection" CTA or not
        String NoOfConnections = PlanResponseModel.cards.get(PlanResponseModel.cards.size()-1).label ;
        String substring = NoOfConnections.substring(0, NoOfConnections.lastIndexOf(" of"));
        int ConnectionsNo =  Integer.parseInt(substring);
        if(ConnectionsNo != 3){
            scrollDownTo(AddaConnectionCTA);
        }
        else {
            scrollDownTo(ConnectionSerial);
        }
    }

    @Override
    public void AssertOneNumberTitleAndBody() {
        waitForVisibility(OneNumber_Title);
        //One Number card must be the last Card in the plan tab
        int OneNumberCardNo = PlanResponseModel.cards.size()-1;
        Assert.assertEquals(OneNumber_Title.getText(),PlanResponseModel.cards.get(OneNumberCardNo).title);
        Assert.assertEquals(OneNumber_Connections.getText(),PlanResponseModel.cards.get(OneNumberCardNo).label);
        System.out.println(OneNumber_Body.getText());
        Assert.assertTrue(OneNumber_Body.getText().contains("Learn about OneNumber"));
        AssertDisplayed(OneNumber_Image.isDisplayed());
        AssertDisplayed(OneNumber_Icon.isDisplayed());
        //Assertions for connection cards
        if(OneNumberConnectionNo() != 0) {
            List<WebElement> ConnectionIcons = driver.findElements(ConnectionIcon);
            List<WebElement> ConnectionNames = driver.findElements(ConnectionName);
            List<WebElement> ConnectionSerials = driver.findElements(ConnectionSerial);
            for (int i = 0; i < ConnectionIcons.size(); i++) {
                AssertDisplayed(ConnectionIcons.get(i).isDisplayed());
                AssertDisplayed(ConnectionSerials.get(i).isDisplayed());
                Assert.assertEquals(ConnectionNames.get(i).getText(),PlanResponseModel.cards.get(OneNumberCardNo).connectionsList.get(i).title);
            }
            AssertDisplayed(driver.findElement(AddaConnectionCTA).isDisplayed());
        }
    }

    @Override
    public void ClickOnAddaConnectionCTA(int No) {
        if(OneNumberConnectionNo() < No){
            waitForVisibility(AddaConnectionCTA);
            driver.findElement(AddaConnectionCTA).click();
        }
    }

    @Override
    public void AssertOneNumberPortalWeb() {
        waitForVisibility(WebviewClose);
        driver.findElement(WebviewClose).click();
    }

    @Override
    public void AssertSubscriptionTray() {
        waitForVisibility(TrayTitle);
        AssertDisplayed(driver.findElement(TrayIcon).isDisplayed());
        Assert.assertEquals(driver.findElement(TrayTitle).getText(),PlanResponseModel.cards.get(PlanResponseModel.cards.size()-1).nextJourneysList.get(0).nextJourneyCardDto.title);
        Assert.assertEquals(driver.findElement(TrayDescription).getText(),PlanResponseModel.cards.get(PlanResponseModel.cards.size()-1).nextJourneysList.get(0).nextJourneyCardDto.description);
        Assert.assertEquals(driver.findElement(TraySubDescritpion).getText(),PlanResponseModel.cards.get(PlanResponseModel.cards.size()-1).nextJourneysList.get(0).nextJourneyCardDto.subDescription);
        driver.findElement(TrayActionCTA).click();
        waitForVisibility(UsageTab);
        AssertDisplayed(driver.findElement(UsageTab).isDisplayed());
    }


    public int OneNumberConnectionNo(){
        WebElement OneNumberConnections = driver.findElement(OneNumber_ConnectionsNo);
        String input = OneNumberConnections.getText();
        String substring = input.substring(0, input.lastIndexOf(" of"));
        return Integer.parseInt(substring);
    }

    @Override
    public void ClickOnViewDetailsCTA() {
        waitForVisibility(ViewDetailsCTA);
        driver.findElement(ViewDetailsCTA).click();
    }

    @Override
    public void AssertMangeSubsctionTray() {
        waitForVisibility(SubscriptionTrayTitle);
        Assert.assertEquals(driver.findElement(SubscriptionTrayFriendlyName).getText(),OneNumberDetailsResponse.header.name);
        AssertDisplayed(driver.findElement(SubscriptionTrayIcon).isDisplayed());
        AssertDisplayed(driver.findElement(SubscriptionTrayCTN).isDisplayed());
        String TitleWithoutHTML = OneNumberDetailsResponse.planCost.title.leftAlignedText.replaceAll("<[^>]*>", "");
        Assert.assertEquals(driver.findElement(SubscriptionPlanCostTitleLeft).getText(),TitleWithoutHTML);
        Assert.assertEquals(driver.findElement(SubscriptionPlanCostTitleRight).getText(),OneNumberDetailsResponse.planCost.title.rightAlignedText);
        List <WebElement> PlanCostLeftTexts = driver.findElements(SubscriptionPlanCostTextLeft);
        List <WebElement> PlanCostRightTexts = driver.findElements(SubscriptionPlanCostTextRight);
        for (int i=0; i<OneNumberDetailsResponse.planCost.list.size(); i++){
            Assert.assertEquals(PlanCostLeftTexts.get(i).getText(),OneNumberDetailsResponse.planCost.list.get(i).leftAlignedText);
            Assert.assertEquals(PlanCostRightTexts.get(i).getText(),OneNumberDetailsResponse.planCost.list.get(i).rightAlignedText);
        }

    }

    @Override
    public void assertOneNumberAgreementSectionAndManageConnectionCTA() {
        waitForVisibility(agreementTitle);
        AssertDisplayed(driver.findElement(agreementTitle).isDisplayed());
        waitForVisibility(tooltipIcon);
        AssertDisplayed(driver.findElement(tooltipIcon).isDisplayed());
        List<WebElement> manageSubscriptionLeftText = driver.findElements(SubscriptionPlanCostTextLeft);
        List<WebElement> manageSubscriptionRightText = driver.findElements(SubscriptionPlanCostTextRight);
        for(int i=0, j=OneNumberDetailsResponse.planCost.list.size(); i<OneNumberDetailsResponse.planAgreement.list.size(); i++,j++)
        {
            AssertDisplayed(manageSubscriptionLeftText.get(j).isDisplayed());
            Assert.assertEquals(manageSubscriptionLeftText.get(j).getText(), OneNumberDetailsResponse.planAgreement.list.get(i).leftAlignedText);
            AssertDisplayed(manageSubscriptionRightText.get(j).isDisplayed());
            Assert.assertEquals(manageSubscriptionRightText.get(j).getText(), OneNumberDetailsResponse.planAgreement.list.get(i).rightAlignedText);
        }
        waitForVisibility(manageConnectionCTA);
        AssertDisplayed(driver.findElement(manageConnectionCTA).isDisplayed());
    }

    @Override
    public void clickOnTooltipIcon() {
        waitForVisibility(tooltipIcon);
        driver.findElement(tooltipIcon).click();
    }

    @Override
    public void validateTooltipContent() {
        waitForVisibility(toolTipDescription);
        AssertDisplayed(driver.findElement(toolTipDescription).isDisplayed());
        Assert.assertEquals(driver.findElement(toolTipDescription).getText(), dashboardV4ResponseModel.tooltips.get(0).items.get(0).description);
    }

    @Override
    public void clickOnToolTipThanksCTA() {
        waitForVisibility(toolTipThanksCTA);
        driver.findElement(toolTipThanksCTA).click();
    }

    @Override
    public void clickOnManageConnectionCTA() {
        waitForVisibility(manageConnectionCTA);
        driver.findElement(manageConnectionCTA).click();
    }

    @Override
    public void validateTheExistenceOfVideoPlayer() {
        waitForVisibility(videoPlayer);
        AssertDisplayed(driver.findElement(videoPlayer).isDisplayed());
    }

    @Override
    public void clickOnVideoPlayerInOneNumberCard() {
        driver.findElement(videoPlayer).click();
    }
}

