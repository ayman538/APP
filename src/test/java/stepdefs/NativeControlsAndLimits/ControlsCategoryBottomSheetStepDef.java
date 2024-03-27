package stepdefs.NativeControlsAndLimits;

import core.Config;
import io.cucumber.java.en.Then;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetAbstract;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetAndroid;
import pages.NativeControlsAndLimits.ControlsCategoryBottomSheet.ControlsCategoryBottomSheetIOS;

public class ControlsCategoryBottomSheetStepDef {

    ControlsCategoryBottomSheetAbstract controlsCategoryBottomSheetAbstract;

    public ControlsCategoryBottomSheetStepDef(Config config){
        if(config.isAndroid()) controlsCategoryBottomSheetAbstract = new ControlsCategoryBottomSheetAndroid();
        if(config.isIos()) controlsCategoryBottomSheetAbstract = new ControlsCategoryBottomSheetIOS();
    }

    @Then("I navigate and check first level control subcategory")
    public void checkFirstLevelControlSubCategory() throws Exception {
        controlsCategoryBottomSheetAbstract.checkFirstLevelControlSubCategory();
    }

    @Then("I navigate and check second level control subcategory")
    public void checkSecondLevelControlSubCategory() throws Exception {
        controlsCategoryBottomSheetAbstract.checkSecondLevelControlSubCategory();
    }
}
