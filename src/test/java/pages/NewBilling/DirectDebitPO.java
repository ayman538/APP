package pages.NewBilling;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class DirectDebitPO extends CommonPo {

    public DirectDebitPO() {
        super();
    }

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Set up or manage the payment of your monthly bill via direct debit']"),
            @FindBy(how = How.ID, using = "Set up or manage the payment of your monthly bill via direct debit")
    })
    public WebElement Bill_DirectDebitDesc;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle"),
            @FindBy(how = How.ID, using = "Direct debit")
    })
    public WebElement Bill_DirectDebitSSO;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnClose"),
            @FindBy(how = How.ID_OR_NAME, using = "closeIcon")
    })
    public WebElement DirectDebitSSOCloseBtn;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Direct Debit Details']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Direct Debit Details']")
    })
    public WebElement DirectDebitDetails;




}