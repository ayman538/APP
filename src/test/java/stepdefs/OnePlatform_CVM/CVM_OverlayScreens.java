package stepdefs.OnePlatform_CVM;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.OnePlatform_CVM_OverlayScreens.CVM_OverlayAbstractLogic;
import pages.OnePlatform_CVM_OverlayScreens.CVM_OverlayAndroidLogic;
import pages.OnePlatform_CVM_OverlayScreens.CVM_OverlayiOSLogic;


public class CVM_OverlayScreens {

    CVM_OverlayAbstractLogic CVM_OverlayScreens ;

    public  CVM_OverlayScreens (Config config) {
        if (config.isAndroid()) CVM_OverlayScreens = new CVM_OverlayAndroidLogic();
        if (config.isIos()) CVM_OverlayScreens = new CVM_OverlayiOSLogic();
    }

    @Then("User should see a full screen overlay OF VOXI user")
    public void userShouldSeeAFullScreenOverlayOfVoxiUser() {
            CVM_OverlayScreens.ValidateCVMOverlayIsDisplayedForVoxiUser();
    }


    @Then("user should see a full screen overlay of HERITAGE user")
    public void userShouldSeeAFullScreenOverlayOfHeritageUser() {
        CVM_OverlayScreens.ValidateCVMOverlayIsDisplayedForHeritageUser();
    }


    @Then("user should see a full screen overlay of non VF user")
    public void userShouldSeeAFullScreenOverlayOfNonVFUser() {
        CVM_OverlayScreens.ValidateCVMOverlayIsDisplayedForNonVFUser();
    }


    }




