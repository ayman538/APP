package pages.RedHybrid.CardDetailsBarclays;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_CardDetailsPO extends CommonPo {

    //String Month=GetCardMonthExpDate();

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Cardholder Name']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Cardholder Name']")
    })
    public WebElement RedHybrid_CardNameLabel;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Card Number']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Card Number']")
    })
    public WebElement RedHybrid_CardNumberLabel;

    @FindAll({
            @FindBy(how = How.ID, using = "expiryLabel"),
            @FindBy(how = How.ID, using = "expiryLabel")
    })
    public WebElement RedHybrid_CardExpiryDateLabel;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='expiryMonth']"),
            @FindBy(how = How.XPATH, using = "//*[@value='Month']")
    })
    public WebElement RedHybrid_CardExpiryDateMonthField;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='expiryYear']"),
            @FindBy(how = How.XPATH, using = "//*[@value='Year']")
    })
    public WebElement RedHybrid_CardExpiryDateYearField;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Card Security Code']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Card Security Code']")
    })
    public WebElement RedHybrid_CardSecurityCodeLabel;


    public RedHybrid_CardDetailsPO() {
        super();
    }

}
