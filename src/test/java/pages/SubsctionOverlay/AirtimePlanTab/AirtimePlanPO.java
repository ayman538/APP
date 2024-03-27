package pages.SubsctionOverlay.AirtimePlanTab;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class AirtimePlanPO extends CommonPo {


    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanTV")
    @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsAdditionalLabel")
    public WebElement Airtime_HelpTip_Link;

    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanDescription")
    @iOSXCUITFindBy(id = "traySuccessNotification")
    public WebElement Your_AirtimePlan_Explanation_Title;


    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanSubDescription")
    @iOSXCUITFindBy(id = "traySuccessSubNotification")
    public WebElement Your_AirtimePlan_Explanation_Msg;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindAll({
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='Ok thanks']"),
            @iOSXCUITBy(id = "action_0")
    })
    public WebElement Ok_ThanksCTA;


}
