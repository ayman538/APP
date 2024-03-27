package pages.SubsctionOverlay.NewPlanDesign.HBBUpgrades;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class HBBUpgradesPO extends CommonPo {

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnPlanCTA")
    @iOSXCUITFindBy(id = "Check eligibility")
    public WebElement CheckUpgradeEligibilityCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtPlanTitle")
    @iOSXCUITFindBy(id = "planCardTitle_0")
    public WebElement HBBUpgradeCardTitle;

    @AndroidFindBy(xpath = "//*[@text='Check Upgrade Eligibility']")
    @iOSXCUITFindBy(id = "Check Upgrade Eligibility")//to be added
    public WebElement UpgradEligibilityBrowserTitle;

}

