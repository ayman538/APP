package stepdefs;

import core.Config;
import io.cucumber.java.en.Then;
import pages.NewDrivers.SampleAbstract;
import pages.NewDrivers.SampleLogicAndroid;
import pages.NewDrivers.SampleLogicIOS;
//import static stepdefs.Hooks.appiumMobileDriver;


public class NewSteps {

    private SampleAbstract sample1;


    /**
     * Constructor for the step definition to initialize the pages needed android or ios based on the config platform
     */
    public NewSteps(Config config) throws InterruptedException {

        if (config.isAndroid()) {
            sample1 = new SampleLogicAndroid();
        }
        if (config.isIos()) {
            sample1 = new SampleLogicIOS();
        }
    }



    @Then(": I should validate new implement")
    public void iShouldValidateNewImplement() throws InterruptedException {
        sample1.validateNewImplement();

    }
}
