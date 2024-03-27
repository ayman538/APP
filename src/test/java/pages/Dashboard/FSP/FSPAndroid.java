package pages.Dashboard.FSP;

import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class FSPAndroid extends FSPAbstract{

    public FSPAndroid () {super();}

    @Override
    public void FSPExists() throws InterruptedException {
        waitForVisibility(FSP_Close_CTA);
        AssertDisplayed(FSP_Close_CTA.isDisplayed());
        AssertDisplayed(FSP_LearnMore_CTA.isDisplayed());
    }

    @Override
    public void FSPDoesNotExist() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Assert.assertFalse(elementIsPresent(FSP_Close_CTA));
    }


    @Override
    public void FSPClickOnLearnMore() {
        waitForVisibility(FSP_Close_CTA);
        FSP_LearnMore_CTA.click();
    }

    @Override
    public void FSPClickOnClose() {
        waitForVisibility(FSP_Close_CTA);
        FSP_Close_CTA.click();
    }
    @Override
    public void TUTClickOnClose(){
        waitForVisibility(TUT_closeCTA);
        TUT_closeCTA.click();
    }

    @Override
    public void assertofferpage() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("login"));
    }

    @Override
    public void FSPCloseWebpage() {
        waitForVisibility(Webpage_closeCTA);
        Webpage_closeCTA.click();
    }
}
