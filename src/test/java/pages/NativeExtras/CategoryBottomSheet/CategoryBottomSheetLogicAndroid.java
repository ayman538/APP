package pages.NativeExtras.CategoryBottomSheet;

import models.response.NativeExtrasSubGroupResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.NativeExtrasProductsDetailsUtils;

import java.util.List;

import static utils.element_helpers.ActionsHelpers.findElementBytext;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class CategoryBottomSheetLogicAndroid extends CategoryBottomSheetAbstract{
    NativeExtrasSubGroupResponseModelAnalyticsVersion nativeExtrasSubGroupResponseModelAnalyticsVersion;

    private static String extraCategoryName;
    private void callAPI(String categoryName){
        nativeExtrasSubGroupResponseModelAnalyticsVersion = NativeExtrasProductsDetailsUtils.getNativeExtrasSubGroupResponseModelAnalyticsVersion(categoryName);
    }

    @Override
    public void validateExtrasCategoryScreenTitle(String categoryName) throws Exception {
        callAPI(categoryName);
        if (nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups !=null) {
            extraCategoryName = nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.serviceSubGroups.get(0).extras.get(0).name;
            WebElement extrasCategoryScreenTitle = findElementBytext("text" , nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.header.title);
            waitForVisibility(extrasCategoryScreenTitle);
            Assert.assertEquals(nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.header.title, extrasCategoryScreenTitle.getText());
        }
        else
            throw new Exception("This category has single extra");
    }

    @Override
    public void validateExtrasContentOnCategoryScreen(String categoryName) throws Exception {
        callAPI(categoryName);
        if (nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups !=null){
            validateExtrasCategoryName();
            validateExtrasCategoryDescription();
            validateExtrasCategorySelection();
            validateExtrasCategoryXCTA();
          //  validateExtrasCategoryContinueCTA();
        }
        else
            throw new Exception("This category has single extra");
    }

    @Override
    public void validateExtrasCategoryName(){
        List<WebElement> extrasCategoryCardName = driver.findElements(By.id("extrasCategoryDetailsName"));

        for(int i =0; i < extrasCategoryCardName.size(); i++) {
            String actualExtrasCategoryName = nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.serviceSubGroups.get(i).name;
            Assert.assertEquals(actualExtrasCategoryName, extrasCategoryCardName.get(i).getText());
        }
    }

    @Override
    public void validateExtrasCategoryDescription() {
        List<WebElement> extrasCategoryCardDescription = driver.findElements(By.id("extrasCategoryDetailsDescription"));

        for (int i =0; i < extrasCategoryCardDescription.size(); i++) {
            String actualExtrasCategoryDescription = nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.serviceSubGroups.get(i).description;
            Assert.assertEquals(actualExtrasCategoryDescription, extrasCategoryCardDescription.get(i).getText());
        }
    }

    @Override
    public void validateExtrasCategorySelection() {
        List<WebElement> categorySelectionCardsSectionForOneExtra = driver.findElements(By.id("rvExtraSubCategoryGroups"));

        for (int i = 0; i < categorySelectionCardsSectionForOneExtra.size(); i++){
            List<WebElement> extraSelectionCard = categorySelectionCardsSectionForOneExtra.get(i).findElements(By.id("dataItemRootId"));

            for (int j = 0; j < extraSelectionCard.size(); j++){
                String expectedExtrasCategoryName = extraSelectionCard.get(j).findElement(By.id("dataItemName")).getText();
                String expectedExtrasCategoryPrice = extraSelectionCard.get(j).findElement(By.id("dataItemValidity")).getText();
                WebElement extrasCategorySelectionButton = extraSelectionCard.get(j).findElement(By.id("dataItemSelectionButton"));

                String actualExtrasCategoryName = nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.serviceSubGroups.get(i).extras.get(j).name;
                String actualExtrasCategoryPrice = nativeExtrasSubGroupResponseModelAnalyticsVersion.itemGroups.serviceSubGroups.get(i).extras.get(j).price;

                Assert.assertEquals(actualExtrasCategoryName, expectedExtrasCategoryName);
                Assert.assertEquals(actualExtrasCategoryPrice, expectedExtrasCategoryPrice);
                AssertDisplayed(extrasCategorySelectionButton.isDisplayed());
            }
        }
    }

    @Override
    public void validateExtrasCategoryContinueCTA() {
        scrollDownTo(extrasCategoryContinueCTA);
        AssertDisplayed(extrasCategoryContinueCTA.isDisplayed());
    }

    @Override
    public void validateExtrasCategoryXCTA() {
        AssertDisplayed(extrasCategoryXCTA.isDisplayed());
    }

    @Override
    public void clickOnExtrasCategoryXCTA() {
        extrasCategoryXCTA.click();
    }

    @Override
    public void selectOneOfExtraCategory() {
        extrasCategorySelectionButton.click();
    }

    public static String getExtraCategoryName() {
        return extraCategoryName;
    }
}
