package pages.Dashboard.AllowanceTile;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class AllowanceTilePO extends CommonPo {
            @AndroidFindBy(id = "com.myvodafoneapp:id/viewAllButton")
            @iOSXCUITFindBy(xpath= "(//*[@label='View all usage'])[1]")
    public WebElement DB_AllowanceTileViewAllUsage;

            @AndroidFindBy(id = "com.myvodafoneapp:id/footerTextView")
            @iOSXCUITFindBy(id = "txtDashboardAllowencesResetsIn")
    public WebElement DB_AllowanceTileRenewal;

    public AllowanceTilePO() {
        super();
    }
}
