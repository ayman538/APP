package pages.NativeControlsAndLimits.ControlsCategoryBottomSheet;

import models.response.NativeControlsResponseModel;
import models.response.NativeControlsSubGroupProductsResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.NativeControlsSubGroupProductsUtils;
import utils.NativeControlsUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ControlsCategoryBottomSheetIOS extends ControlsCategoryBottomSheetAbstract {

    NativeControlsResponseModel nativeControlsResponseModel = NativeControlsUtils.getControlsPhase2();
    NativeControlsSubGroupProductsResponseModel nativeControlsSubGroupProductsResponseModel;

    List<String> categories;
    public List<String>getCategories(){
        List<String> controlsCategories = new ArrayList<>();
        int numberOfControls = nativeControlsResponseModel.shopCategories.serviceGroups.size();
        for(int i=0;i<numberOfControls;i++){
            controlsCategories.add(nativeControlsResponseModel.shopCategories.serviceGroups.get(i).name);
        }
        return controlsCategories;
    }

    public void callAPI(String categoryName){
        nativeControlsSubGroupProductsResponseModel = NativeControlsSubGroupProductsUtils.getnativeControlsSubGroupProducts(categoryName);
    }

    public void navigateToFirstLevelControlSubCategory() throws Exception {
        boolean hasFirstCategory = false;
        categories = getCategories();
        for(int i=0;i<categories.size() && !hasFirstCategory;i++){
            callAPI(categories.get(i));
            if (nativeControlsSubGroupProductsResponseModel.itemsGroup != null){
                int firstLvlItems = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.size();
                for (int j=0;j<firstLvlItems;j++) {
                    if (nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).confirmControl != null) {
                        hasFirstCategory = true;
                        //waitForVisibility(driver.findElement(By.xpath("//*[@label='"+categories.get(i)+"']")));
                        Thread.sleep(3000);
                        WebElement category = driver.findElement(By.xpath("//*[@label='"+categories.get(i)+"']"));
                        category.click();
                        break;
                    }
                }
            }
        }
        if(!hasFirstCategory){
            throw new Exception("This user doesn't have First level category sheet");
        }
    }

    public void checkFirstLevelControlSubCategory() throws Exception {
        navigateToFirstLevelControlSubCategory();
        checkControlCategory();
    }

    public void checkControlCategory(){
        waitForVisibility(controlsCategoryScreenTitle);
        assertDisplayed(controlsCategoryScreenXCTA,3);
        assertEquals(controlsCategoryScreenTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.header.title);
        assertEquals(controlsCategoryTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.title);
        int itemsSize = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.size();
        for(int i=0;i<itemsSize;i++){
            scrollDownTo(controlsCategoryItemTitle.get(i));
            assertEquals(controlsCategoryItemTitle.get(i).getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(i).name);
        }
    }

    public int navigateToSecondLevelControlSubCategory() throws Exception {
        boolean hasSecondCategory = false;
        int j= 0;
        categories = getCategories();
        for(int i=0;i<categories.size() && !hasSecondCategory;i++){
            callAPI(categories.get(i));
            if (nativeControlsSubGroupProductsResponseModel.itemsGroup != null){
                int firstLvlItems = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.size();
                for (j=0;j<firstLvlItems;j++) {
                    if (nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).itemsGroup != null) {
                        hasSecondCategory = true;
                        WebElement category = driver.findElement(By.xpath("//*[@label='"+categories.get(i)+"']"));
                        category.click();
                        String subcategoryText = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).name;
                        Thread.sleep(1000);
                        driver.findElement(By.xpath("//*[@label='"+subcategoryText+"']")).click();
                        break;
                    }
                }
            }
        }
        if(!hasSecondCategory){
            throw new Exception("This user doesn't have Second level category sheet");
        }

        return j;
    }

    public void checkControlSubCategory() throws Exception {
        int subCatNo = navigateToSecondLevelControlSubCategory();
        waitForVisibility(controlsSubCategoryScreenHeaderTitle);
        assertDisplayed(controlsSubCategoryScreenXCTA,3);
        assertEquals(controlsSubCategoryScreenHeaderTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(subCatNo).itemsGroup.header.title);
        assertEquals(controlsSubCategoryTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(subCatNo).itemsGroup.title);
        assertEquals(controlsSubCategoryDescription.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(subCatNo).itemsGroup.description);
        int itemsSize = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(subCatNo).itemsGroup.items.size();
        scrollDown();
        for(int k=0;k<itemsSize;k++){
            scrollDownTo(controlsSubCategoryItemTitle.get(k));
            assertEquals(controlsSubCategoryItemTitle.get(k).getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(subCatNo).itemsGroup.items.get(k).name);
        }
    }

    public void checkSecondLevelControlSubCategory() throws Exception {
        checkControlSubCategory();
    }
}
