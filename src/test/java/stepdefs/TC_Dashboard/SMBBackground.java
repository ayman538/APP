package stepdefs.TC_Dashboard;/*
package StepDefinition.TC_Dashboard;

import config.Configurations;
import pages.Dashboard.NetworksLogic;
import pages.Dashboard.SMBBackgroundLogic;
import pages.Tutorials.TutorialLogic;
import Utilities.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class SMBBackground extends BaseTest {

    public SMBBackground() throws IOException {
        if (!getBeforeSuiteRunStatus())
            setUFLStatus("False");
    }

   @BeforeClass
    public void beforeClass() {
        if (getCleanStatus().equals("True") && getTutorialsClosedStatus().equals("False")) {
            TutorialLogic tutorial = new TutorialLogic();
            tutorial.Close();
        }
       SMBBackgroundLogic SMB = new SMBBackgroundLogic(getDriver());
       SMB.navigateToSubs();
    }

    @Test
    public void TC01_checkSubsOverlayBackground() throws IOException {
        SMBBackgroundLogic SMB = new SMBBackgroundLogic(getDriver());
        SMB.checkSubsOverlayBackground();
    }
}
*/
