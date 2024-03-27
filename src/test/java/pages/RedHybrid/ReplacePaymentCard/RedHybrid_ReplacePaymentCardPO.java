package pages.RedHybrid.ReplacePaymentCard;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ReplacePaymentCardPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentMethodHeader"),
            @FindBy(how = How.ID, using = "paymentMethodHeader")
    })
    public WebElement RedHybrid_paymentMethodHeader;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentMethodDescription"),
            @FindBy(how = How.ID, using = "paymentMethodDescription")
    })
    public WebElement RedHybrid_paymentMethodDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "imgRedHybridCloseView")
    })
    public WebElement RedHybrid_PaymentXIcon;


    public RedHybrid_ReplacePaymentCardPO() {
        super();
    }

}
