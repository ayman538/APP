package pages.NativeControlsAndLimits.ControlsConfirmBottomSheet;

import models.response.NativeControlsResponseModel;
import models.response.NativeControlsSubGroupResponseModelAnalyticsVersion;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.NativeControlsSubGroupProductsUtils;
import utils.NativeControlsUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ControlsConfirmBottomSheetAndroid extends ControlsConfirmBottomSheetAbstract {

    public static String controlName;
    NativeControlsResponseModel nativeControlsResponseModel = NativeControlsUtils.getControlsPhase2();
    NativeControlsSubGroupResponseModelAnalyticsVersion nativeControlsSubGroupProductsResponseModel;

    NativeControlsResponseModel nativeControlsResponseModelPhase1 = NativeControlsUtils.getControlsPhase1();
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
        nativeControlsSubGroupProductsResponseModel = NativeControlsSubGroupProductsUtils.getNativeControlsSubGroupResponseModelAnalyticsVersion(categoryName);
    }

    public void navigateToZeroLvlControlConfirmation() throws Exception {
        boolean hasZeroConfirmation = false;
        categories = getCategories();
        for(int i=0;i<categories.size();i++){
            callAPI(categories.get(i));
            if (nativeControlsSubGroupProductsResponseModel.confirmControl != null){
                hasZeroConfirmation = true;
                controlName = removeHtmlTag(nativeControlsSubGroupProductsResponseModel.confirmControl.name);
                WebElement category = driver.findElement(By.xpath("//*[@text='"+categories.get(i)+"']"));
                category.click();
                break;
            }
        }
        if(!hasZeroConfirmation){
            throw new Exception("This user doesn't have zero level confirmation sheet");
        }
    }

    public void checkZeroControlConfirmation(){
        assertEquals(confirmControlsScreenHeaderTitle.getText(),nativeControlsSubGroupProductsResponseModel.confirmControl.header.title);
        assertDisplayed(confirmControlsScreenTitle,3);
        assertEquals(confirmControlsItem.getText(),removeHtmlTag(nativeControlsSubGroupProductsResponseModel.confirmControl.name));
        assertEquals(confirmControlsItemDescription.getText(),nativeControlsSubGroupProductsResponseModel.confirmControl.description);
        if(nativeControlsSubGroupProductsResponseModel.confirmControl.moreInformationText != null){
            assertDisplayed(confirmControlsItemMoreInfoTitle,3);
            assertEquals(confirmControlsItemMoreDescription.getText(),nativeControlsSubGroupProductsResponseModel.confirmControl.moreInformationDescription);
        }
        assertDisplayed(confirmControlsScreenXCTA,3);
        assertDisplayed(confirmControlsConfirmCTA,3);
    }

    public void goToAndCheckZeroLvlConfirmationControl() throws Exception {
        navigateToZeroLvlControlConfirmation();
        checkZeroControlConfirmation();
    }

    public int navigateToFirstLvlControlConfirmation(){
        categories = getCategories();
        int j=0;
        boolean out = true;
        for(int i=0;i<categories.size() && out;i++){
            callAPI(categories.get(i));
            if(nativeControlsSubGroupProductsResponseModel.itemsGroup != null){
                int firstSubcategories = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.size();
                for(j=0;j<firstSubcategories;j++){
                    if (nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).confirmControl != null){
                        String subcategoryText = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).name;
                        controlName = removeHtmlTag(nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).confirmControl.name);
                        WebElement subcategory = driver.findElement(By.xpath("//*[@text='"+subcategoryText+"']"));
                        waitForVisibility(subcategory);
                        subcategory.click();
                        out = false;
                        break;
                    }
                }
            }
        }
        return j;
    }

    public void checkFirstControlConfirmation(){
        int itemNo = navigateToFirstLvlControlConfirmation();
        assertEquals(confirmControlsScreenHeaderTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).confirmControl.header.title);
        assertDisplayed(confirmControlsScreenTitle,3);
        assertEquals(confirmControlsItem.getText(),removeHtmlTag(nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).confirmControl.name));
        assertEquals(confirmControlsItemDescription.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).confirmControl.description);
        if(nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).confirmControl.moreInformationText != null){
            assertDisplayed(confirmControlsItemMoreInfoTitle,3);
            assertEquals(confirmControlsItemMoreDescription.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).confirmControl.moreInformationDescription);
        }
        assertDisplayed(confirmControlsScreenBackArrow,3);
        assertDisplayed(confirmControlsScreenXCTA,3);
        assertDisplayed(confirmControlsConfirmCTA,3);
    }

    public int navigateToSecondLvlControlConfirmation(){
        categories = getCategories();
        int j=0;
        boolean out = true;
        for(int i=0;i<categories.size() && out;i++){
            callAPI(categories.get(i));
            if(nativeControlsSubGroupProductsResponseModel.itemsGroup != null){
                int firstSubcategories = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.size();
                for(j=0;j<firstSubcategories;j++){
                    if (nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).itemsGroup != null){
                        //String subcategoryText = nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(j).name;
                        //WebElement subcategory = driver.findElement(By.xpath("//*[@text='"+subcategoryText+"']"));
                        //waitForVisibility(subcategory);
                        //subcategory.click();
                        out = false;
                        break;
                    }
                }
            }
        }
        return j;
    }

    public void checkSecondControlConfirmation(){
        int itemNo = navigateToSecondLvlControlConfirmation();
        controlsCategoryItemTitle.get(0).click();
        assertEquals(confirmControlsScreenHeaderTitle.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).itemsGroup.items.get(0).confirmControl.header.title);
        assertDisplayed(confirmControlsScreenTitle,3);
        assertEquals(confirmControlsItem.getText(),removeHtmlTag(nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).itemsGroup.items.get(0).confirmControl.name));
        assertEquals(confirmControlsItemDescription.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).itemsGroup.items.get(0).confirmControl.description);
        if(nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).itemsGroup.items.get(0).confirmControl.moreInformationText != null){
            assertDisplayed(confirmControlsItemMoreInfoTitle,3);
            assertEquals(confirmControlsItemMoreDescription.getText(),nativeControlsSubGroupProductsResponseModel.itemsGroup.items.get(itemNo).itemsGroup.items.get(0).confirmControl.moreInformationDescription);
        }
        assertDisplayed(confirmControlsScreenBackArrow,3);
        assertDisplayed(confirmControlsScreenXCTA,3);
        assertDisplayed(confirmControlsConfirmCTA,3);
    }

    public static String getControlName(){
        return controlName;
    }

    public void validateConfirmTurnOffControlTrayIsOpened(String buttonName){
        for (int i = 0; i < nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.size(); i++) {
            if (nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.get(i).cta.text.equals(buttonName)) {
                assertDisplayed(confirmControlsScreenTitle,3);
                assertEquals(nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.title, confirmControlsScreenTitle.getText());
                assertEquals(nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.name.replace("<b>", "").replace("</b>",""), confirmControlsItem.getText());
                assertEquals(nativeControlsResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.description, confirmControlsItemDescription.getText());
                assertDisplayed(confirmControlsScreenXCTA, 3);
                assertDisplayed(confirmControlsConfirmCTA, 3);
                break;
            }
        }
    }

    public void clickOnXCTAOnTurnOffConfirmationTray(){
        waitForVisibility(confirmControlsScreenXCTA);
        confirmControlsScreenXCTA.click();
    }

    public void clickOnTurnOffCTAOnConfirmationTray() {
        confirmControlsConfirmCTA.click();
    }
}
