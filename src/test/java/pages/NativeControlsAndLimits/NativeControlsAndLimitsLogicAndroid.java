package pages.NativeControlsAndLimits;

import models.response.DashboardV4ResponseModel;
import models.response.NativeControlsResponseModel;
import models.response.NativeControlsResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.NativeControlsUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ActionsHelpers.findElementBytext;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NativeControlsAndLimitsLogicAndroid extends NativeControlsAndLimitsAbstract{
    DashboardV4ResponseModel dashboardV4ResponseModel = DashboardUtils.GetDashboardNativeExtrasAndControls();
    NativeControlsResponseModel nativeControlsResponseModel = NativeControlsUtils.getControls();

    NativeControlsResponseModelAnalyticsVersion nativeControlsResponseModelPhase1 = NativeControlsUtils.getNativeControlsResponseModelAnalyticsVersion();

    ArrayList<NativeControlsResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveControls = nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails;

    public boolean validateIfBingo() {
        try {
            dashboardV4ResponseModel.tooltips.get(0).journeyName.contains("HOME");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void validateControlsAndLimitsTileExistence() {
        if (validateIfBingo())
            Assert.assertEquals(removeHtmlTag(dashboardV4ResponseModel.tiles.get(4).content.get(0).title), "Manage Controls");
        else
            Assert.assertEquals(removeHtmlTag(dashboardV4ResponseModel.tiles.get(4).content.get(0).title), "Manage Controls and Limits");
    }

    @Override
    public void clickOnAddControlsAndLimitsTile() {
        waitForVisibility(DB_controlsAndLimits);
        scrollDown();
        DB_controlsAndLimits.click();
    }

    @Override
    public void validateControlsTabIsOpened() {
        waitForVisibility(controlTab);
        controlTab.isSelected();
    }

    @Override
    public List<WebElement> getActiveControls(){
        scrollDownTo(ActiveControlsCard);
        List<WebElement> activeControls = driver.findElements(By.id("activeExtraControlTitle"));
        return activeControls;
    }


    @Override
    public void validateActiveControls() {
        scrollDownTo(ActiveControlsCard);
        if(actualActiveControls.size()>0) {
            assertEquals(removeHtmlTag(actualActiveControls.get(0).name), ActiveControlsTitle.getText());

        }
    }

    @Override
    public void validateActiveControlsCardContent(){
        scrollDownTo(ActiveControlsCardTitle);
        if(actualActiveControls.size()>0) {
            assertEquals(removeHtmlTag(actualActiveControls.get(0).name), ActiveControlsTitle.getText());
            assertEquals(actualActiveControls.get(0).productStatus, ActiveControlsStatus.getText());
            assertEquals(actualActiveControls.get(0).startDate, ActiveControlsDate.getText());
            assertEquals(actualActiveControls.get(0).description, findElementBytext("text", actualActiveControls.get(0).description).getText());

            if(actualActiveControls.get(0).startDate != null)
                Assert.assertEquals(actualActiveControls.get(0).startDate, ActiveControlsDate.getText());

            if (actualActiveControls.get(0).findOutMore != null) {
                assertEquals(actualActiveControls.get(0).findOutMore, ActiveControlsFindOutMoreTitle.getText());
                assertDisplayed(ActiveControlsFindOutMoreCTA, 3);
            }
        }

     }


    @Override
    public void validateClickingOnFindOutMoreCTAForControls(){
        if(nativeControlsResponseModel.activeProducts.activeProductsDetails.size()>0) {
            for (int i = 0; i < nativeControlsResponseModel.activeProducts.activeProductsDetails.size(); i++) {
                if (actualActiveControls.get(i).findOutMore != null) {
                    scrollDownTo(ActiveControlsFindOutMoreCTA);
                    ActiveControlsFindOutMoreCTA.click();
                    waitForVisibility(ActiveControlsDescription);
                    assertDisplayed(ActiveControlsDescription, 3);
                    break;
                }
            }
        }
        else {
            System.out.println("This test data has no active controls");
        }
    }

    @Override
    public void validateTurnOffControlCTA(String buttonName){

        for (int i = 0; i < nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.size(); i++) {
            scrollDownTo(removeHtmlTag(actualActiveControls.get(i).name));
            if (!(actualActiveControls.get(i).productStatus.contains("Spend Limit")) && !actualActiveControls.get(i).ctaDisabled && actualActiveControls.get(i).cta.text.equals(buttonName)) {
                scrollDownTo(removeHtmlTag(actualActiveControls.get(i).cta.text));

                if (buttonName.equals("Turn off")) {
                    AssertDisplayed(turnOffControlCTA.isDisplayed());
                } else
                    AssertDisplayed(manageSpendManagerControlCTA.isDisplayed());
                return;
            }
        }
    }

    @Override
    public void clickOnTurnOffControlCTA(String buttonName){
        if (buttonName.equals("Turn off")) {
            turnOffControlCTA.click();
        }
        else
            manageSpendManagerControlCTA.click();
    }

    @Override
    public void validateOnTurnOffCTAStatus(String buttonName){
        for (int i = 0; i < nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.size(); i++) {
            scrollDownTo(removeHtmlTag(actualActiveControls.get(i).name));
            if (!(actualActiveControls.get(i).productStatus.contains("Spend Limit")) && !actualActiveControls.get(i).ctaDisabled &&actualActiveControls.get(i).cta.text.equals(buttonName)) {
                scrollDownTo(removeHtmlTag(actualActiveControls.get(i).cta.text));
                if (buttonName.equals("Turn off")) {
                    Assert.assertFalse(turnOffControlCTA.isEnabled());
                }
                else
                    Assert.assertFalse(manageSpendManagerControlCTA.isEnabled());
                return;
            }
        }
    }



    @Override
    public void clickOnControlsTabFromAdjacentTabs() {
        controlTab.click();
    }
}
