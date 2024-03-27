package pages.Tray.Billing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class BillingPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillMonth"),
            @FindBy(how = How.ID, using = "txtMyBillMonth")

    })
    public WebElement Bill_month;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillPeriod"),
            @FindBy(how = How.ID, using = "txtMyBillPeriod")

    })
    public WebElement Bill_period;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillDueDate"),
            @FindBy(how = How.ID, using = "txtMyBillDueDate")

    })
    public WebElement Bill_paymentDueBy;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillAmount"),
            @FindBy(how = How.ID, using = "txtMyBillAmount")

    })
    public WebElement Bill_amount;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsStatusLabel"),
            @FindBy(how = How.ID, using = "txtMyBillsStatusLabel")

    })
    public WebElement Bill_statusLable;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsStatusIcon"),
            @FindBy(how = How.ID, using = "txtMyBillsStatusIcon")

    })
    public WebElement Bill_statusIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/wdgMyBillCard"),
            @FindBy(how = How.ID, using = "wdgMyBillCard")

    })
    public WebElement Bill_billCard;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsAccountName"),
            @FindBy(how = How.ID, using = "txtMyBillsAccountName")

    })
    public WebElement Bill_accountName;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/barchart"),
            @FindBy(how = How.ID, using = "wdgMyBillsGraphSection")

    })
    public WebElement Bill_graph;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsViewTitle"),
            @FindBy(how = How.ID, using = "txtScreenTitle")
    })
    public WebElement Bill_graphTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/billsHeaderTextView"),
            @FindBy(how = How.ID, using = "txtMyBillsHeaderText")
    })
    public WebElement Bill_Vats;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/billingHeaderTextView"),
            @FindBy(how = How.ID, using = "billingHeaderTextView"),
            @FindBy(how = How.ID, using = "txtScreenTitleLabel"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsViewTitle")


    })
    public WebElement Billing_title;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/barchart"),
            @FindBy(how = How.ID, using = "wdgMyBillsGraphSection")
    })
    public WebElement Bill_Chart;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnMyBillsViewAllCTA"),
            @FindBy(how = How.ID, using = "View all")

    })
    public WebElement Bill_viewAllCTA;


    public BillingPO() {
        super();
    }

}
