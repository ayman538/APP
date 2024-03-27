package pages.RedHybrid.RemovePaymentCard;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_RemovePaymentCardPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/alertTitle"),
            @FindBy(how = How.XPATH, using = "//*[contains(@name,'Remove this card?')]")
    })
    public WebElement RedHybrid_removePopUpTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/message"),
            @FindBy(how = How.XPATH, using = "//*[starts-with(@name,'Removing this card')]")
    })
    public WebElement RedHybrid_removePopUpDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button2"),
            @FindBy(how = How.ID, using = "Cancel")
    })
    public WebElement RedHybrid_removePopUpCancelRemoveCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button1"),
            @FindBy(how = How.ID, using = "removePopUpProceedRemoveCTA")
    })
    public WebElement RedHybrid_removePopUpProceedRemoveCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/removeCurrentCardCTA"),
            @FindBy(how = How.ID, using = "removeCurrentCardCTA")
    })
    public WebElement RedHybrid_removeCurrentCardCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement RedHybrid_PaymentXIcon;

    public RedHybrid_RemovePaymentCardPO() {
        super();
    }
}
