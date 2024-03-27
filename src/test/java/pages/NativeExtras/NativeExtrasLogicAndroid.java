package pages.NativeExtras;

import models.response.DashboardV4ResponseModel;
import models.response.NativeExtrasResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.NativeExtras.CategoryBottomSheet.CategoryBottomSheetLogicAndroid;
import utils.DashboardUtils;
import utils.NativeExtrasUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NativeExtrasLogicAndroid extends NativeExtrasAbstract {

    DashboardV4ResponseModel dashboardV4ResponseModel = DashboardUtils.GetDashboardNativeExtrasAndControls();
    NativeExtrasResponseModelAnalyticsVersion nativeExtrasResponseModelAnalyticsVersion = NativeExtrasUtils.getNativeExtrasResponseModelAnalyticsVersion();
    ArrayList<NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveExtras = nativeExtrasResponseModelAnalyticsVersion.activeProducts.activeProductsDetails;

    @Override
    public void validateAddExtrasTileExistence() {
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
        AssertDisplayed(extrasTab.isSelected());
    }

    @Override
    public void validateActiveExtrasCardContent() {
        scrollDownElementOverCenterScreen(ActiveExtrasTitle);
        if (actualActiveExtras.size() > 0) {
            Assert.assertEquals(removeHtmlTag(actualActiveExtras.get(0).name), ActiveExtrasTitle.getText());
            Assert.assertEquals(actualActiveExtras.get(0).productStatus, ActiveExtrasStatus.getText());

            if(actualActiveExtras.get(0).priceType != null && actualActiveExtras.get(0).startDate != null) {
                Assert.assertEquals(actualActiveExtras.get(0).priceType, ActiveExtrasType.getText());
                Assert.assertEquals(actualActiveExtras.get(0).startDate, ActiveExtrasDate.getText());
            }

            if(actualActiveExtras.get(0).cta != null && actualActiveExtras.get(0).cta.text != null)
                Assert.assertEquals(actualActiveExtras.get(0).cta.text, reOptInRecurringExtraCTA.getText());

            if (actualActiveExtras.get(0).formattedPriceFreq != null)
                Assert.assertEquals(removeHtmlTag(actualActiveExtras.get(0).formattedPriceFreq), ActiveExtrasPrice.getText());


            if(actualActiveExtras.get(0).cta != null && actualActiveExtras.get(0).cta.text != null){
                assertEquals(actualActiveExtras.get(0).findOutMore, ActiveExtrasFindOutMoreTitle.getText());
                assertDisplayed(ActiveExtrasFindOutMoreCTA, 3);
            }

        }
    }

    @Override
    public void validateClickingOnFindOutMoreCTA(){
        if(actualActiveExtras.size()>0) {
            for (int i = 0; i < actualActiveExtras.size(); i++) {
                if(actualActiveExtras.get(i).cta != null && actualActiveExtras.get(i).cta.text != null){
                    scrollDownTo(ActiveExtrasFindOutMoreCTA);
                    ActiveExtrasFindOutMoreCTA.click();
                    waitForVisibility(ActiveExtrasDescription);
                    assertDisplayed(ActiveExtrasDescription, 3);
                    break;
                }
            }
        }
    }

    @Override
    public void validateAddedExtraWithPendingStatus() {
//        NativeExtrasResponseModelAnalyticsVersion nativeExtrasResponseModelAnalyticsVersion = NativeExtrasUtils.getNativeExtrasResponseModelAnalyticsVersion();
//        ArrayList<NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail> actualActiveExtras = nativeExtrasResponseModelAnalyticsVersion.activeProducts.activeProductsDetails;
        String extraCategoryName = CategoryBottomSheetLogicAndroid.getExtraCategoryName();
        for (int i=0; i< actualActiveExtras.size(); i++){
            scrollDownTo(removeHtmlTag(actualActiveExtras.get(i).name));
            if(removeHtmlTag(actualActiveExtras.get(i).name).equalsIgnoreCase(extraCategoryName)){
                assertEquals(actualActiveExtras.get(i).productStatus, "Pending");
                return;
            }
        }
    }


    @Override
    public void validateOnOptingCTARecurringExtra(String buttonName) {
        for (NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail actualActiveExtra : actualActiveExtras) {
            scrollDownTo(removeHtmlTag(actualActiveExtra.name));
            scrollDownAndroid();
            if (actualActiveExtra.cta != null && !actualActiveExtra.ctaDisabled && actualActiveExtra.cta.text.equalsIgnoreCase(buttonName)){
                scrollDownTo(actualActiveExtra.cta.text);
                if (buttonName.equals("Opt out")) {
                    AssertDisplayed(optOutRecurringExtraCTA.isDisplayed());
                } else
                    AssertDisplayed(reOptInRecurringExtraCTA.isDisplayed());
                return;
            }
        }
    }


    @Override
    public void clickOnOptingCTARecurringExtra(String buttonName) {
        if (buttonName.equals("Opt out")) {
            optOutRecurringExtraCTA.click();
        }
        else
            reOptInRecurringExtraCTA.click();
    }

    public void validateOnOptingCTAStatus(String buttonName) {
        for (NativeExtrasResponseModelAnalyticsVersion.ActiveProductsDetail actualActiveExtra : actualActiveExtras) {
            scrollDownTo(removeHtmlTag(actualActiveExtra.name));
            if (actualActiveExtra.cta != null && !actualActiveExtra.ctaDisabled && actualActiveExtra.cta.text.equalsIgnoreCase(buttonName)){
                scrollDownTo(actualActiveExtra.cta.text);
                if (buttonName.equals("Opt out")) {
                    Assert.assertFalse(optOutRecurringExtraCTA.isEnabled());
                } else
                    Assert.assertFalse(reOptInRecurringExtraCTA.isEnabled());
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
