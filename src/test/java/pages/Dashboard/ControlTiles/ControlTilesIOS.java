package pages.Dashboard.ControlTiles;

import core.drivers_initializer.drivers.AppiumMobileDriver;
import models.response.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.*;

import java.util.Properties;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitWithCatch;

public class ControlTilesIOS extends ControlTilesAbstract {
    private final By plan_tile = By.xpath("(//XCUIElementTypeOther[@name='wdgDashboardControlTileCard'])[1]");
    private final By your_plan_text = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardControlTileCardTitle'])[1]");
    private final By add_extra_text = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardControlTileCardTitle'])[2]");
    private final By add_extra_tile = By.xpath("//XCUIElementTypeCell[@name='wdgControlTile_2']");
    private final By manage_control_and_limit_tile = By.xpath("//XCUIElementTypeCell[@name='wdgControlTile_3']");
    private final By manage_control_and_limits_text = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardControlTileCardTitle'])[3]");

    static Properties envProp = readPropertyFile("config/env.properties");
    static String flag = System.getProperty("RedHybrid_Flag", envProp.getProperty("RedHybrid_Flag"));
    Boolean live = System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse ;
    DashboardV4ResponseModel DashboardResponseRH ;


    public ControlTilesIOS() {
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
            DashboardResponseRH = DashboardUtils.GetDashboardRedHybrid();
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

    public void waitDashboardLoading() {
        waitForVisibility(DB_SettingDashboardTray_icon);
    }

    public void ValidateSecondaryControlTileText() {
        if (live) {
            Assert.assertTrue(driver.findElement(add_extra_text).getText().contains("Add Extras"));
            Assert.assertTrue(driver.findElement(add_extra_tile).isDisplayed());
            Assert.assertTrue(driver.findElement(manage_control_and_limits_text).getText().contains("Manage Controls and Limits"));
            Assert.assertTrue(driver.findElement(manage_control_and_limit_tile).isDisplayed());
        } else {
            waitForVisibility(DB_ControlTileSecondryCard);
            if (flag.equals("true")) {
                AssertResult(DB_ControlTileSecondryCard.getText(), DashboardResponseRH.tiles.get(3).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            } else {
                AssertResult(DB_ControlTileSecondryCard.getText(), DashboardResponse.tiles.get(3).content.get(0).title.replace("<b>", "").replace("</b>", ""));
            }
        }
    }

    public void ValidatePrimaryControlTileCTA() {
        firstControlTileCTA();
        assertPlanTabDisplayed();
        SOXIconCTA();
    }

    public void SOXIconCTA() {
        waitForVisibility(SO_Xicon);
        SO_Xicon.click();
    }

    public void assertPlanTabDisplayed() {
        if(live){
            Assert.assertTrue(driver.findElement(By.xpath(GetXpath("Plan"))).isSelected(), "not selected");
        }else {
            if (DashboardResponse.tiles.get(2).content.get(0).target.equals("SUBS_OVERLAY_PLAN")) {
                Assert.assertTrue(driver.findElement(By.xpath(GetXpath("Plan"))).isSelected(), "Airtime Plan");
            }
        }
    }

    public void firstControlTileCTA() {
        waitForVisibility(DB_ControlTile);
        DB_ControlTile.click();
    }

    public void ValidateSecondaryControlTileCTA() {
        secondControlTileCTA();
        assertExtrasORManageGPDataDisplayed();
        SOXIconCTA();
    }

    public void assertExtrasORManageGPDataDisplayed() {
        if(live){
            Assert.assertTrue(driver.findElement(By.xpath(GetXpath("Extras"))).isSelected(), "not selected");
        }else {
            if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_EXTRAS")) {
                waitWithCatch(SO_ExtrasTabContent);
                AssertDisplayed(SO_ExtrasTabContent.isDisplayed());
            } else if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_GROUP_DATA")) {
                waitWithCatch(GD_GroupDataCardTitle);
                AssertDisplayed(GD_GroupDataCardTitle.isDisplayed());
            } else if (DashboardResponse.tiles.get(3).content.get(0).target.equals("SUBS_OVERLAY_DEVICE_PLAN")) {
                System.out.println(SO_DevicePlanTab.getText());
                Assert.assertTrue(SO_DevicePlanTab.isSelected());
            }
        }
    }

    public void secondControlTileCTA() {
        waitForVisibility(DB_ControlTileSecondryCard);
        DB_ControlTileSecondryCard.click();
    }

    @Override
    public void VerifyYourPlanTile() {
        DiscoverV2ResponseModel discoverV2ResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();

        if (discoverV2ResponseModel.isEligibleForUpgrades) {
            waitForVisibility(YourPlanTile);
            YourPlanTile.isDisplayed();
            Assert.assertEquals(YourPlanTile.getText(), "Upgrade available");
        }

    }

    @Override
    public void ValidateTilesForBingoUser() {
        waitForVisibility(DB_AirtimeCurrentChargesTile);
        Assertions.assertEquals("Airtime current charges", DB_AirtimeCurrentChargesTile.getText());
        Assertions.assertEquals("Airtime Plan", DB_AirtimePlanTile.getText());
        Assertions.assertEquals("Device Plan", DB_DevicePlanTile.getText());
        Assertions.assertEquals("Manage Controls and Extras", DB_ControlAndExtrasTile.getText());
    }

    @Override
    public void clickonDevicePlanTile() {
        waitForVisibility(DB_DevicePlanTile);
        DB_DevicePlanTile.click();
    }

    @Override
    public void validateDevicePlanSuboverlayScreen() {
        AssertDisplayed(DB_DevicePlanSuboverlayscreen.isDisplayed());
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
        /*DiscoverV2ResponseModel discoverResponseModel = DiscoverOffersUtils.getDiscoverOffersV2();
        if (discoverResponseModel.isEligibleForUpgrades) {
            System.out.println("dashboard response " + dashboardV4ResponseModel.status.analytics.guid);
            try {
                if (dashboardV4ResponseModel.nudge.actions.get(0).text.contains("Upgrade now")) {
                    AssertDisplayed(DB_Nudge.isDisplayed());
                    AssertDisplayed(DB_NudgeUpgradeNowCTA.isDisplayed());
                    ClickOnUpgradeNowCTA();
                    waitForVisibility(DB_NudgeXIcon);
                    AssertDisplayed(DB_NudgeXIcon.isDisplayed());
                    ClickOnNudgeXIcon();
                }
            }
            catch(NullPointerException e){
               if(dashboardV4ResponseModel.lozenge.get(0).text.contains("Upgrade available"));  {
                    waitForVisibility(YourPlanTile);
                    VerifyYourPlanTile();
                }
            }
        }

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
        Assert.assertTrue(ExtrasTab.isSelected());
    }

}
