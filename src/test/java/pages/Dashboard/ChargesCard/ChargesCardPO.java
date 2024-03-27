package pages.Dashboard.ChargesCard;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class ChargesCardPO extends CommonPo {

            @AndroidFindBy(id = "com.myvodafoneapp:id/cardHeaderTextView")
            @iOSXCUITFindBy(id = "txtDashboardChargesCardHeader")
    public WebElement DB_billingTileHeader;
            @AndroidFindBy(id = "com.myvodafoneapp:id/cardTitleTextView")
            @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsAccountName")
    public WebElement DB_billingTileTitle;
            @AndroidFindBy(id = "com.myvodafoneapp:id/billPeriodTextView")
            @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsPeriod")
    public WebElement DB_billingTileDueDate;
            @AndroidFindBy(id = "//*[@resource-id='com.myvodafoneapp:id/currentChargesContainer']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/footerTextView']")
            @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsAdditionalLabel")
    public WebElement DB_billingTileFooter;
            @AndroidFindBy(id = "com.myvodafoneapp:id/balanceTextView")
            @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsDetails")
    public WebElement DB_billingTileAmount;

            @AndroidFindBy(id = "com.myvodafoneapp:id/currentChargesContainer")
            @iOSXCUITFindBy(id = "Dashboard_CurrentSpends_Section")
    public WebElement DB_billingTileContainer;

    public ChargesCardPO() {
        super();
    }

}
