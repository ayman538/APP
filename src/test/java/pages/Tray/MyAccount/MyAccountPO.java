package pages.Tray.MyAccount;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class MyAccountPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchMyAccountTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"),
    })
    public WebElement MyAccTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchSelectAccountTitle"),
            @FindBy(how = How.ID, using = "txtSubSwitchSelectAccountTitle")
            // TODO : find locator
    })
    public WebElement MyAccSelectAccountTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/ddSubSwitchSelectAccountList"),
    })
    public WebElement MyAccSelectAccountField;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnSubSwitchSelectAccount"),
            @FindBy(how = How.NAME, using = "Switch accounts")
    })
    public WebElement SwitchAccountCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchSelectOneTitle"),
            @FindBy(how = How.NAME, using = "txtSubSwitchSelectOneTitle")

    })
    public WebElement SelectOne;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/closePartialImageView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")

    })
    public WebElement XCloseCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchSelectAccountTitle")
    })
    public WebElement Account_ID;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvCurrentAccountTitle")
    })
    public WebElement CurrentAccountTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/quickActionMainTitle"),
            @FindBy(how = How.NAME, using = "quickActionMainTitle")
    })

    public WebElement SwitAccountsTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnCancel"),
            @FindBy(how = How.NAME, using = "Cancel")
    })
    public WebElement CancelCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/subscriptionsRecyclerView"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='txtSubSwitchSelectOneTitle']"),
            @FindBy(how = How.ID, using = "Horizontal scroll bar, 2 pages"),
            @FindBy(how = How.ID, using = "Horizontal scroll bar, 3 pages"),})

    public WebElement GetSubscription_List;

    @FindAll({
            @FindBy(how = How.ID, using = "contentView"),
            @FindBy(how = How.ID, using = "Horizontal scroll bar, 2 pages"),})


    public WebElement DataUsage_Tile;

    @FindAll({
            @FindBy(how = How.ID, using = "cardHeaderTextView"),
            @FindBy(how = How.ID, using = "Horizontal scroll bar, 2 pages"),
            @FindBy(how = How.ID, using = "txtDashboardChargesCardHeader")
    })

    public WebElement Charges_Tile;

    public MyAccountPO() {
        super();
    }

}
