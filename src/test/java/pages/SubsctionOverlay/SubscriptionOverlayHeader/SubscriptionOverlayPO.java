package pages.SubsctionOverlay.SubscriptionOverlayHeader;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;


public class SubscriptionOverlayPO extends CommonPo {


    @AndroidFindBy(xpath = "//android.widget.LinearLayout[@content-desc='Plan']/android.widget.TextView")
    @iOSXCUITFindBy(id = "Plan")

    public WebElement SO_PlanTab;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubscriptionTitle")
    @iOSXCUITFindBy(id = "txtSubscriptionMSISDN")

    public WebElement SO_MSISDN;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubscriptionAccountType")
    @iOSXCUITFindBy(id = "txtSubscriptionAccountType")

    public WebElement SO_subscriptionType;

    @AndroidFindBy(id = "com.myvodafoneapp:id/imgSubscriptionIcon")
    @iOSXCUITFindBy(id = "imgSubscriptionIcon")

    public WebElement SO_subscriptionIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnSubscriptionUpgradeCTA")
    @iOSXCUITFindBy(id = "btnSubscriptionUpgradeCTA")

    public WebElement SO_UpgradeCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubscriptionCreditSpend")
    @iOSXCUITFindBy(id = "txtSubscriptionCreditSpend")

    public WebElement SO_Amount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubscriptionAdditionalLabel")
    @iOSXCUITFindBy(id = "txtSubscriptionAdditionalLabel")

    public WebElement SO_AdditionalCharges;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtSubscriptionPeriod")
    @iOSXCUITFindBy(id = "txtSubscriptionPeriod")

    public WebElement SO_Dates;

    public SubscriptionOverlayPO() {
        super();
    }

}
