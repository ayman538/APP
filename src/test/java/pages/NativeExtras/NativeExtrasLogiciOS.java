package pages.NativeExtras;

import models.response.DashboardV4ResponseModel;
import models.response.NativeExtrasResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NativeExtras.CategoryBottomSheet.CategoryBottomSheetLogicIOS;
import utils.DashboardUtils;
import utils.NativeExtrasUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NativeExtrasLogiciOS extends NativeExtrasAbstract {

    DashboardV4ResponseModel dashboardV4ResponseModel = DashboardUtils.GetDashboardNativeExtrasAndControls();
    NativeExtrasResponseModelAnalyticsVersion nativeExtrasResponseModelAnalyticsVersion = NativeExtrasUtils.getNativeExtrasResponseModelAnalyticsVersion();
    ArrayList<NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveExtras = nativeExtrasResponseModelAnalyticsVersion.activeProducts.activeProductsDetails;

    public static String extraName;
    public static int extraIndex;

    public boolean validateIfBingo() {
        try {
            dashboardV4ResponseModel.tooltips.get(0).journeyName.contains("HOME");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void validateAddExtrasTileExistence() {
        if (validateIfBingo())
            Assert.assertEquals(removeHtmlTag(dashboardV4ResponseModel.tiles.get(4).content.get(0).title), DB_addExtras.getText());
        else
            Assert.assertEquals(removeHtmlTag(dashboardV4ResponseModel.tiles.get(3).content.get(0).title), DB_addExtras.getText());
    }


    @Override
    public void validateShopExtrasCard() {
        waitForVisibility(shopExtrasCard);
        AssertDisplayed(shopExtrasCard.isDisplayed());
    }

    public boolean checkShopExtrasCategories(){
        List<WebElement> shopExtrasCategories = shopCategoriesTable.findElements(By.id("shopCategoryTitle"));
        for (int i = 0; i < shopExtrasCategories.size(); i++){
            if (!nativeExtrasResponseModelAnalyticsVersion.shopCategories.serviceGroups.get(i).name.equals(shopExtrasCategories.get(i).getText()))
                return  false;
        }
        return true;
    }

    @Override
    public void validateShopExtrasDetails() {
        AssertDisplayed(shopExtrasCardTitle.isDisplayed());
        AssertDisplayed(shopExtrasCardDescription.isDisplayed());
        AssertDisplayed(shopExtrasCardIcon.isDisplayed());
    }

    @Override
    public void validateShopExtrasCategories() {
        Assert.assertTrue(checkShopExtrasCategories());
    }


    @Override
    public void clickOnCategoryCard(String category) {
        try{
            WebElement selectedCategory = getElementByText(category);
            selectedCategory.click();
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            System.out.println("This user has no " +category+ " category"  );
        }
    }

    @Override
    public void clickOnAddExtrasTile() {
        waitForVisibility(DB_addExtras);
        DB_addExtras.click();
    }

    @Override
    public void validateExtrasTabIsOpened() {
        waitForVisibility(extrasTab);
        AssertDisplayed(shopExtrasCard.isDisplayed());
    }


    @Override
    public void validateActiveExtrasCardContent(){
        int findOutMoreIndex = 0, priceIndex = 0, recurringExtraIndex = 0, dataAndTypeIndex = 0;
        for (int i = 0; i < actualActiveExtras.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(actualActiveExtras.get(i).name)).isDisplayed())
                scrollUp();

            Assert.assertEquals(removeHtmlTag(actualActiveExtras.get(i).name), findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i).getText());
            Assert.assertEquals(actualActiveExtras.get(i).productStatus, findElementElementByDynamicLocatorAndIndex("activeExtraControlStatus", i).getText());

            if (actualActiveExtras.get(i).formattedPriceFreq != null)
                Assert.assertEquals(removeHtmlTag(actualActiveExtras.get(i).formattedPriceFreq), findElementElementByDynamicLocatorAndIndex("activeExtraControlPrice", i - priceIndex).getText());
            else
                priceIndex++;

            if (actualActiveExtras.get(i).findOutMore != null){
                AssertDisplayed(findElementBytext("label" ,actualActiveExtras.get(i).findOutMore).isDisplayed());
                AssertDisplayed(findElementElementByDynamicLocatorAndIndex("chevronRight", i - findOutMoreIndex).isDisplayed());
            }
            else
                findOutMoreIndex++;

            if(actualActiveExtras.get(i).priceType != null && actualActiveExtras.get(i).startDate != null){
                Assert.assertEquals(actualActiveExtras.get(i).priceType, findElementElementByDynamicLocatorAndIndex("activeExtraControlType", i - dataAndTypeIndex).getText());
                Assert.assertEquals(actualActiveExtras.get(i).startDate, findElementElementByDynamicLocatorAndIndex("activeExtraControlDate", i - dataAndTypeIndex).getText());
            }
            else
                dataAndTypeIndex++;

            if(actualActiveExtras.get(i).cta != null && actualActiveExtras.get(i).cta.text != null)
                Assert.assertEquals(actualActiveExtras.get(i).cta.text, findElementElementByDynamicLocatorAndIndex("removeRecurringDataExtraCTA", i - recurringExtraIndex).getText());
            else
                recurringExtraIndex++;
        }
    }

    @Override
    public void validateClickingOnFindOutMoreCTA(){
        int findOutMoreIndex =0;
        for (int i = 0; i < actualActiveExtras.size(); i++) {
            if (actualActiveExtras.get(i).cta != null && actualActiveExtras.get(i).cta.text != null) {
                scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
                tap(findElementElementByDynamicLocatorAndIndex("activeExtraControlFindOutMoreTitle", i - findOutMoreIndex));
                Assert.assertEquals(removeHtmlTag(actualActiveExtras.get(i).findOutMoreDescription), findElementElementByDynamicLocatorAndIndex("activeExtraControlDescription", i - findOutMoreIndex).getText());
            } else
                findOutMoreIndex++;
        }
    }


    @Override
    public void validateAddedExtraWithPendingStatus() {
        String extraCategoryName = CategoryBottomSheetLogicIOS.getExtraCategoryName();
        for (int i = 0; i< actualActiveExtras.size(); i++){
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(actualActiveExtras.get(i).name)).isDisplayed() )
                scrollUp();
            if(actualActiveExtras.get(i).name.equalsIgnoreCase(extraCategoryName)){
                Assert.assertEquals(actualActiveExtras.get(i).productStatus, findElementElementByDynamicLocatorAndIndex("activeExtraControlStatus", i).getText());
                return;
            }
        }
    }
    @Override
    public void validateOnOptingCTARecurringExtra(String buttonName) throws Exception {
        int ctr = 1;
        for (int i = 0; i < actualActiveExtras.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (!findElementBytext("label" ,removeHtmlTag(actualActiveExtras.get(i).name)).isDisplayed() )
                scrollUp();

            if (actualActiveExtras.get(i).cta!=null &&actualActiveExtras.get(i).priceType.equals("Recurring") && actualActiveExtras.get(i).cta.text.equals(buttonName) ) {

                if (!actualActiveExtras.get(i).ctaDisabled) {
                    WebElement activeRecurringExtraButtonName = findElementBytext("label" ,buttonName);
                    extraName = actualActiveExtras.get(i).name;
                    extraIndex = ctr;
                    AssertDisplayed(activeRecurringExtraButtonName.isDisplayed());
                    return;
                }
                ctr = ctr + 1;
            }
        }
        throw new Exception("This user has no " + buttonName + " CTA");
    }


    @Override
    public void clickOnOptingCTARecurringExtra(String buttonName) {
        for (int i = 0; i < actualActiveExtras.size() ; i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (extraName.equals(actualActiveExtras.get(i).name)) {
                WebElement activeRecurringExtraButton = findElementElementByDynamicLocatorAndIndex(buttonName, extraIndex-1);
                waitForVisibility(activeRecurringExtraButton);
                activeRecurringExtraButton.click();
                return;
            }
        }
    }

    public void validateOnOptingCTAStatus(String buttonName) {
        for (int i = 0; i < actualActiveExtras.size(); i++) {
            scrollDownElementOverCenterScreen(findElementElementByDynamicLocatorAndIndex("activeExtraControlTitle", i));
            if (extraName.equals(actualActiveExtras.get(i).name)) {
                WebElement activeRecurringExtraButtonName = findElementBytext("label" ,buttonName);
                Assert.assertFalse(activeRecurringExtraButtonName.isEnabled());
                return;
            }
        }
    }

    @Override
    public void validateActiveExtrasCardEmpty() {
        scrollDownElementOverCenterScreen(ActiveExtrasCardTitle);
        Assert.assertEquals("You currently don't have any active add ons or extras.", noActiveExtraControlDescription.getText());
    }
}

