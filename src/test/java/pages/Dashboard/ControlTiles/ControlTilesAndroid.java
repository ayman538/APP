package pages.Dashboard.ControlTiles;

import models.response.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.*;

import java.util.Properties;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;

public class ControlTilesAndroid extends ControlTilesAbstract{

    static Properties envProp = readPropertyFile("config/env.properties");
    static String flag = System.getProperty("RedHybrid_Flag", envProp.getProperty("RedHybrid_Flag"));
    Boolean live = System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("true");
    private final By x_close_plan = By.id("com.myvodafoneapp:id/dismissImageView");
    private final By add_extra_text = By.xpath("//*[@text='Add Extras']");
    private final By add_extra_tile = By.id("com.myvodafoneapp:id/controlBackground");
    private final By add_extra_logo = By.id("com.myvodafoneapp:id/controlIcon");
    private final By manage_control_and_limits_text = By.xpath("//*[@text='Manage Controls and Limits']");
    private final By manage_control_and_limits_icon = By.id("com.myvodafoneapp:id/controlText");
    private final By manage_control_and_limit_tile = By.id("com.myvodafoneapp:id/controlBackground");
    private final By your_plan_text = By.id("com.myvodafoneapp:id/controlText");
    private final By plan_tile = By.id("com.myvodafoneapp:id/controlBackground");

    DashboardV4ResponseModel DashboardResponse ;
    DashboardV4ResponseModel DashboardResponseRH ;
    SegmentResponseModel segmentResponseModel;
    CRODashboardResponseModel dashboardV4ResponseModel;
    DeviceLoanDetailsResponseModel deviceLoanDetailsResponseModel;
    PlanV3ResponseModel planResponse;

    public ControlTilesAndroid() {
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
            DashboardResponseRH = DashboardUtils.GetDashboardRedHybrid();
            segmentResponseModel = SegmentUtils.GetSegment();
            dashboardV4ResponseModel=DashboardUtils.GetDashboardWithUserTypeCRO("MPSCONSUMEREligibleToUpgrade");
            deviceLoanDetailsResponseModel = DeviceLoanDetailsUtils.getDeviceLoanDetailsNoStub();
            planResponse = PlanUtils.GetPlanV3();
        }
    }

    public void SetBeforeClass() {
//        if (hideVOVStatus.equals("Success")) {
//            HideVOV(DB_VOVhideCTA);
//        }
    }

    public void ValidatePrimaryControlTileText() {
        if (live) {
            waitForVisibility(plan_tile);
            Assert.assertTrue(driver.findElement(plan_tile).isDisplayed());
            Assert.assertTrue(driver.findElement(your_plan_text).isDisplayed());
        } else {
            waitDashboardLoading();
            if (flag.equals("true")) {
                AssertResult(DB_ControlTile.getText(), DashboardResponseRH.tiles.get(2).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            } else {
                AssertResult(DB_ControlTile.getText(), DashboardResponse.tiles.get(2).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            }
        }
    }

    public void waitDashboardLoading(){
        waitForVisibility(DB_SettingDashboardTray_icon);
        //Thread.sleep(6000);
    }

    /*
    public void assertFirstControlTileTitleTextRestOfUsers() {
        AssertResult(DB_ControlTile.getText(), "Your Plan");
        System.out.println("Else Assert on the control title ");
    }

    public void assertFirstControlTileTitleTextBINGO() {
        AssertResult(DB_ControlTile.getText(), "Your Plans");
        System.out.println("Else Assert on the control title ");
    }

    public void assertFirstControlTileTitleTextPAYGBVB() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: Big Value Bundle");
    }

    public void assertFirstControlTileTitleTextPAYG1() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: Pay as you go 1");
    }

    public void assertFirstControlTileTitleTextPAYGSimply() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: PAYG Simply");
    }

     */
    public void ValidateSecondaryControlTileText() {
                /*
        System.out.println("Given we validate the second control tile text ");
        waitDashboardLoading();
        if (getUser().contains("Red")) {
            assertSecondControlTileTitleTextRED();
        } else if (getUser().equalsIgnoreCase("PAYG_simply") || getUser().equalsIgnoreCase("PAYG1")) {
            assertSecondControlTileTitleTextPAYG1AndPAYGSimply();

        } else {
            assertSecondControlTileTitleTextRestOfUsers();
        }
        System.out.println("Should the secondary card tile displayed successfully ");

         */

        if (live) {
            Assert.assertTrue(driver.findElement(add_extra_text).getText().contains("Add Extras"));
            Assert.assertTrue(driver.findElement(add_extra_tile).isDisplayed());
            Assert.assertTrue(driver.findElement(add_extra_logo).isDisplayed());
            Assert.assertTrue(driver.findElement(manage_control_and_limits_icon).isDisplayed());
            Assert.assertTrue(driver.findElement(manage_control_and_limits_text).getText().contains("Manage Controls and Limits"));
            Assert.assertTrue(driver.findElement(manage_control_and_limit_tile).isDisplayed());
            driver.findElement(add_extra_text).click();
            waitForVisibility(x_close_plan);
        } else {
            waitDashboardLoading();
            if (flag.equals("true")) {
                AssertResult(DB_ControlTileSecondryCard.getText(), DashboardResponseRH.tiles.get(3).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            } else {
                AssertResult(DB_ControlTileSecondryCard.getText(), DashboardResponse.tiles.get(3).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            }
        }
    }

    /*

    public void assertSecondControlTileTitleTextRestOfUsers() {
        AssertResult(DB_ControlTileSecondryCard.getText(), "Manage Bars & Extras");
        System.out.println("else control tile secondary card displayed successfully with text  " + DB_ControlTileSecondryCard.getText());
    }

    public void assertSecondControlTileTitleTextPAYG1AndPAYGSimply() {
        AssertResult(DB_ControlTileSecondryCard.getText(), "Buy a Big Value Bundle");
        System.out.println("else control tile secondary card displayed successfully with text  " + DB_ControlTileSecondryCard.getText());
    }

    public void assertSecondControlTileTitleTextRED() {
        System.out.println("Check if the user type red ");
        AssertResult(DB_ControlTileSecondryCard.getText(), "Manage group data");
        System.out.println("if control tile secondary card displayed successfully with text " + DB_ControlTileSecondryCard.getText());
    }

     */

    public void ValidatePrimaryControlTileCTA(){
        firstControlTileCTA();
        assertPlanTabDisplayed();
        SOXIconCTA();

    }

/*
    public void ClickOnControlTileCTA() throws InterruptedException {
        System.out.println("Given we validate the entry point for first control tile");
        firstControlTileCTA();
    }

 */
    public void SOXIconCTA() {
        waitForVisibility(x_close_plan);
        driver.findElement(x_close_plan).click();
        System.out.println("plan closed");
    }

    public void assertPlanTabDisplayed() {
        if(live){
            Assert.assertTrue(driver.findElement(By.xpath(GetXpath("Plan"))).isSelected(), "not selected");
        }else {
            String Upgrade = "<b>Upgrade Phone and Plan</b>";
            String Fancy = "Fancy a new phone";
            try {
                if (DashboardResponse.tiles.get(2).content.get(0).target.equals("SUBS_OVERLAY_PLAN")) {
                    if ((planResponse.cards.get(1).sections.get(0).title != null &&
                            planResponse.cards.get(1).sections.get(0).title.contains(Upgrade) ||
                            planResponse.cards.get(1).sections.get(0).title.contains(Fancy))) {
                        selectUserType(1, "Airtime Plan", "Bingo");
                    } else if ((planResponse.cards.get(0).sections.get(0).title != null &&
                            planResponse.cards.get(0).sections.get(0).title.contains(Upgrade) ||
                            planResponse.cards.get(0).sections.get(0).title.contains(Fancy))) {
                        selectUserType(0, "plan", "PAYM");
                    }

                }
            } catch (Exception e) {
                System.out.println("user is  not eligible ");
                if (DashboardResponse.tiles.get(2).content.get(0).target.equals("SUBS_OVERLAY_PLAN")) {
                    waitWithCatch(SO_PlanTabContent);
                    AssertDisplayed(SO_PlanTabContent.isDisplayed());
                }
            }
        }
    }
    private void selectUserType(int cardIndex , String planType , String user){
            System.out.println( user + " user eligible for upgrade");
            Assert.assertTrue(getElementByText(planType).isSelected(), planType);
            scrollDownTo(SO_PlanTabContract);
            waitForVisibility(SO_PlanTabContract);
            System.out.println(planResponse.cards.get(cardIndex + 1 ).sections.get(1).title);
            System.out.println(SO_PlanTabContract.getText());
            Assert.assertEquals(SO_PlanTabContract.getText(), planResponse.cards.get(cardIndex + 1 ).sections.get(1).title.replace("<b>", "").replace("</b>", ""));

        }

    public void firstControlTileCTA(){
        waitForVisibility(DB_ControlTile);
        DB_ControlTile.click();
    }

    public void ValidateSecondaryControlTileCTA(){
        if(!live)secondControlTileCTA();
        assertExtrasORManageGPDataDisplayed();
        SOXIconCTA();

    }

    public void assertExtrasORManageGPDataDisplayed(){
        if(live){
            Assert.assertTrue(driver.findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Extras']")).isSelected(), "not selected");
        }else {
            if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_EXTRAS")) {
                waitWithCatch(SO_ExtrasTabContent);
                AssertDisplayed(SO_ExtrasTabContent.isDisplayed());
            } else if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_GROUP_DATA")) {
                waitWithCatch(GD_GroupDataCardTitle);
                AssertDisplayed(GD_GroupDataCardTitle.isDisplayed());
            } else if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_DEVICE_PLAN")) {
                Assert.assertTrue(SO_DevicePlanTab.isSelected());
            }
        }
    }

    /*
    public void assertExtrasDisplayedAfterSecondControlTileCTA() {
        System.out.println("Else the user is not red type ");
        waitWithCatch(SO_ExtrasTabContent);
        System.out.println("Wait till the extras tab content displayed ");
        AssertDisplayed(SO_ExtrasTabContent.isDisplayed());
        System.out.println("should the extras tab content displayed successfully ");
    }

    public void assertGroupDataDisplayedAfterFirstControlTileCTA() {
        System.out.println("Check if the user type is red ");
        waitWithCatch(GD_GroupDataCard);
        System.out.println("wait till the the group data card displayed");
        AssertDisplayed(GD_GroupDataCard.isDisplayed());
        System.out.println("Should the group data card displayed successfully ");
    }

     */

    public void secondControlTileCTA() {
        waitForVisibility(add_extra_tile);
        driver.findElement(add_extra_tile).click();
    }

    @Override
    public void VerifyYourPlanTile() {
      try {
          DiscoverV2ResponseModel discoverResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
          if (discoverResponseModel.isEligibleForUpgrades == true) {
              waitForVisibility(YourPlanTile);
              Assertions.assertEquals(YourPlanTile.getText(), "Upgrade available");
          }
      }catch (Exception e){
          System.out.println("discover offer fails and here is the error ===>" + e.getMessage());
      }
    }

    @Override
    public void ValidateTilesForBingoUser() {
        waitForVisibility(DB_AirtimeCurrentChargesTile);
        Assertions.assertEquals("Airtime current charges",DB_AirtimeCurrentChargesTile.getText());
        Assertions.assertEquals("Airtime Plan",DB_AirtimePlanTile.getText());
        Assertions.assertEquals("Device Plan",DB_DevicePlanTile.getText());
        Assertions.assertEquals("Manage Controls and Extras", DB_ControlAndExtrasTile.getText());
    }

    @Override
    public void clickonDevicePlanTile() {
        waitForVisibility(DB_DevicePlanTile);
        DB_DevicePlanTile.click();
    }

    @Override
    public void validateDevicePlanSuboverlayScreen() {
        Assertions.assertEquals("Device Plan",DB_DevicePlanSuboverlayscreen.getText());
    }


    @Override
    public void ClickOnNudgeXIcon() {
        waitForVisibility(DB_Nudge);
        DB_NudgeXIcon.click();
        HardAssertNotDisplayed("Nudge", elementIsPresent(DB_Nudge));
    }
    @Override
    public void ClickOnUpgradeNowCTA() {
        DB_NudgeUpgradeNowCTA.click();
        waitForVisibility(SO_PlanTab);
        AssertDisplayed(SO_PlanTab.isDisplayed());
        runAppInBackground();
    }

    @Override
    public void ValidateCroExperience() {
        //DiscoverV2ResponseModel discoverResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
        //if (discoverResponseModel.isEligibleForUpgrades) {
         //  System.out.println("dashboard response " + dashboardV4ResponseModel.status.analytics.guid);
         //  try {
               /*if (dashboardV4ResponseModel.nudge.actions.get(0).text.contains("Upgrade now")) {
                   AssertDisplayed(DB_Nudge.isDisplayed());
                   AssertDisplayed(DB_NudgeUpgradeNowCTA.isDisplayed());
                   ClickOnUpgradeNowCTA();
                   waitForVisibility(DB_NudgeXIcon);
                   AssertDisplayed(DB_NudgeXIcon.isDisplayed());
                   ClickOnNudgeXIcon();
               }
           }
               catch(NullPointerException e){
           if( dashboardV4ResponseModel.lozenge.get(0).text.contains("Upgrade available")) ; {
               waitForVisibility(YourPlanTile);
               VerifyYourPlanTile();
           }*/
           //}
       /*}

        else
            System.out.println("User is not eligible for Upgrade");*/
    }

    @Override
    public void clickonManageControlsAndExtrasTile() {
        DB_ControlAndExtrasTile.click();
    }

    @Override
    public void ExtrasTab() {
        waitForVisibility(ExtrasTab);
        Assertions.assertTrue(ExtrasTab.isSelected());
    }
}


