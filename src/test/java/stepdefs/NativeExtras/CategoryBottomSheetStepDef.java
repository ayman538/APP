package stepdefs.NativeExtras;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.NativeExtras.CategoryBottomSheet.CategoryBottomSheetAbstract;
import pages.NativeExtras.CategoryBottomSheet.CategoryBottomSheetLogicAndroid;
import pages.NativeExtras.CategoryBottomSheet.CategoryBottomSheetLogicIOS;

public class CategoryBottomSheetStepDef {

    CategoryBottomSheetAbstract categoryBottomSheetAbstract;

    public CategoryBottomSheetStepDef (Config config){
        if (config.isAndroid()){
            categoryBottomSheetAbstract = new CategoryBottomSheetLogicAndroid();
        }
        if (config.isIos()){
            categoryBottomSheetAbstract = new CategoryBottomSheetLogicIOS();
        }
    }

    @And("I click on X CTA")
    public void iClickOnXCTA() {
        categoryBottomSheetAbstract.clickOnExtrasCategoryXCTA();
    }

    @And("I select one of the extras on Category Bottom Sheet")
    public void iSelectOneOfTheExtrasOnCategoryBottomSheet() {
        categoryBottomSheetAbstract.selectOneOfExtraCategory();
    }

    @Then("I should be navigated to {string} Category Bottom Screen")
    public void iShouldBeNavigatedToCategoryBottomScreen(String categoryName) throws Exception {
        categoryBottomSheetAbstract.validateExtrasCategoryScreenTitle(categoryName);

    }

    @Then("I should see {string} category bottom sheet screen details")
    public void iShouldSeeCategoryBottomSheetScreenDetails(String categoryName) throws Exception {
        categoryBottomSheetAbstract.validateExtrasContentOnCategoryScreen(categoryName);
    }
}
