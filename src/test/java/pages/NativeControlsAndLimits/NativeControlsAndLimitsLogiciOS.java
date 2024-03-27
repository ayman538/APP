package pages.NativeControlsAndLimits;

import models.response.DashboardV4ResponseModel;
import models.response.NativeControlsResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.NativeControlsUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NativeControlsAndLimitsLogiciOS extends NativeControlsAndLimitsAbstract{
    DashboardV4ResponseModel dashboardV4ResponseModel = DashboardUtils.GetDashboardNativeExtrasAndControls();

    NativeControlsResponseModelAnalyticsVersion nativeControlsResponseModelPhase1 = NativeControlsUtils.getNativeControlsResponseModelAnalyticsVersion();

    ArrayList<NativeControlsResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveControls = nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails;


    public static String controlName;
    public static int controlIndex;

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
        for (int i = 0; i < actualActiveControls.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(actualActiveControls.get(i).name)).isDisplayed())
                scrollUp();

            Assert.assertEquals(removeHtmlTag(actualActiveControls.get(i).name), findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i).getText());
        }

    }

    @Override
    public void validateActiveControlsCardContent(){
        int controlCTAIndex = 0,  descriptionExtraIndex = 0, dataExtraIndex = 0;
        for (int i = 0; i < actualActiveControls.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(actualActiveControls.get(i).name)).isDisplayed())
                scrollUp();

            Assert.assertEquals(removeHtmlTag(actualActiveControls.get(i).name), findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i).getText());
            Assert.assertEquals(actualActiveControls.get(i).productStatus, findElementElementByDynamicLocatorAndIndex("activeExtraControlStatus", i).getText());
            Assert.assertEquals(actualActiveControls.get(i).description.replace("'", "’"), findElementBytext("label", actualActiveControls.get(i).description).getText().replace("'", "’"));
            AssertDisplayed(findElementBytext("label" ,actualActiveControls.get(i).findOutMore).isDisplayed());
            AssertDisplayed(findElementElementByDynamicLocatorAndIndex("chevronRight", i ).isDisplayed());

            if(actualActiveControls.get(i).startDate != null)
                Assert.assertEquals(actualActiveControls.get(i).startDate, findElementElementByDynamicLocatorAndIndex("activeExtraControlDate", i - dataExtraIndex).getText());
            else
                dataExtraIndex++;

            if( actualActiveControls.get(i).description != null)
                Assert.assertEquals(actualActiveControls.get(i).description, findElementBytext("label", actualActiveControls.get(i).description).getText());
            else
                descriptionExtraIndex++;

            if(actualActiveControls.get(i).cta != null && actualActiveControls.get(i).cta.text != null)
                Assert.assertEquals(actualActiveControls.get(i).cta.text, findElementElementByDynamicLocatorAndIndex("removeRecurringDataExtraCTA", i - controlCTAIndex).getText());
            else
                controlCTAIndex++;

        }
    }

    @Override
    public void validateClickingOnFindOutMoreCTAForControls(){
        int findOutMoreIndex = 0;
        for (int i = 0; i < actualActiveControls.size(); i++) {
            try {
                scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
                tap(findElementElementByDynamicLocatorAndIndex("activeExtraControlFindOutMoreTitle", i-findOutMoreIndex));
                Assert.assertEquals(removeHtmlTag(actualActiveControls.get(i).findOutMoreDescription), findElementElementByDynamicLocatorAndIndex("activeExtraControlDescription",i-findOutMoreIndex).getText());
            }
            catch (Exception e){
                findOutMoreIndex++;
            }
        }
    }

    @Override
    public void validateTurnOffControlCTA(String buttonName){

        int ctr = 1;

        for (int i = 0; i < actualActiveControls.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));

            if (!findElementBytext("label" , removeHtmlTag(actualActiveControls.get(i).name)).isDisplayed() )
                scrollUp();

            if (actualActiveControls.get(i).cta!=null  && actualActiveControls.get(i).cta.text.equals(buttonName) ) {
                if (!actualActiveControls.get(i).ctaDisabled) {
                    WebElement activeRecurringExtraButtonName = findElementBytext("label" ,buttonName);
                    controlName = actualActiveControls.get(i).name;
                    controlIndex = ctr;
                    AssertDisplayed(activeRecurringExtraButtonName.isDisplayed());
                    return;
                }
                ctr = ctr + 1;
            }
        }
    }

    public void clickOnTurnOffControlCTA(String buttonName){

        for (int i = 0; i < actualActiveControls.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (controlName.equals(actualActiveControls.get(i).name)) {
                WebElement activeControlTurnoffButton = findElementElementByDynamicLocatorAndIndex(buttonName, controlIndex - 1);
                waitForVisibility(activeControlTurnoffButton);
                activeControlTurnoffButton.click();
                return;
            }
        }
    }

    @Override
    public void validateOnTurnOffCTAStatus(String buttonName){
        for (int i = 0; i < actualActiveControls.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (controlName.equals(actualActiveControls.get(i).name)) {
                WebElement activeRecurringExtraButtonName = findElementBytext("label" ,buttonName);
                Assert.assertFalse(activeRecurringExtraButtonName.isEnabled());
                return;
            }
        }
    }

    @Override
    public void clickOnControlsTabFromAdjacentTabs() {
        controlTab.click();
    }
}
