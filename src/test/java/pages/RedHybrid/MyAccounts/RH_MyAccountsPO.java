package pages.RedHybrid.MyAccounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.ArrayList;

public class RH_MyAccountsPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchMyAccountTitle"), //And
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"), //ios
    })
    public WebElement RedHybridMyAccountTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchSelectAccountTitle"),
            @FindBy(how = How.ID, using = "txtSubSwitchSelectAccountTitle")

    })
    public WebElement RedHybridMyAccountSelectAccountTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "txtSubSwitchSelectOneTitle"),
            @FindBy(how = How.ID, using = "txtSubSwitchSelectOneTitle")
    })
    public WebElement RedHybridSelectOneTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/ddSubSwitchSelectAccountList"),
            @FindBy(how = How.ID, using = "ddSubSwitchSelectAccountList")

    })
    public WebElement RedHybrid_MyAccountSelectAccountDropDown;



    @FindAll({
            @FindBy(how =  How.XPATH , using = "//*[@resource-id='com.myvodafoneapp:id/wdgSubSwitchChildCard']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name='wdgSubSwitchChildCard']/XCUIElementTypeOther")
    })
    public ArrayList<WebElement> AccountSubscriptionsList;

    @FindAll({
            @FindBy(how = How.XPATH , using = "//android.widget.ListView/android.widget.TextView"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[contains(@name,'7')]")
    })
    public ArrayList<WebElement> MyAccountsList;


    @FindAll({
            @FindBy(how = How.ID , using = "com.myvodafoneapp:id/txtSubSwitchChildType"),
            @FindBy(how = How.ID, using = "txtSubSwitchChildType")
    })
    public WebElement myAccSubscriptionType;

}
