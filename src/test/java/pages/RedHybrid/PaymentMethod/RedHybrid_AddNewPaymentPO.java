package pages.RedHybrid.PaymentMethod;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_AddNewPaymentPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement RedHybrid_PaymentTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentMethodHeader"),
            @FindBy(how = How.ID, using = "paymentMethodHeader")
    })
    public WebElement RedHybrid_PaymentHeader;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentMethodDescription"),
            @FindBy(how = How.ID, using = "paymentMethodDescription")
    })
    public WebElement RedHybrid_PaymentDesc;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgAddedPaymentCardView"),
            @FindBy(how = How.ID, using = "imgAddedPaymentCardView"),
            @FindBy(how = How.ID, using = "currentCard")
    })
    public WebElement RedHybrid_AddedPaymentCardView;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgAddedPaymentCardType"),
            @FindBy(how = How.ID, using = "imgAddedPaymentCardType"),
            @FindBy(how = How.XPATH, using = "//*[@name='currentCard']/XCUIElementTypeImage")
    })
    public WebElement RedHybrid_AddedPaymentCardType;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddedPaymentCardNumber"),
            @FindBy(how = How.ID, using = "txtAddedPaymentCardNumber"),
            @FindBy(how = How.XPATH, using = "//*[@name='currentCard']/XCUIElementTypeOther/XCUIElementTypeOther")
    })
    public WebElement RedHybrid_AddedPaymentCardNumber;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddedPaymentCardExpiryDate"),
            @FindBy(how = How.ID, using = "txtAddedPaymentCardExpiryDate"),
            @FindBy(how = How.XPATH, using = "//*[contains(@name,'Exp')]")
    })
    public WebElement RedHybrid_AddedPaymentCardExpiryDate;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgEditPaymentCardIcon"),
            @FindBy(how = How.ID, using = "imgEditPaymentCardIcon"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name='editCancelCTA']/XCUIElementTypeImage")
    })
    public WebElement RedHybrid_EditPaymentCardIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtEditPaymentCardLabel"),
            @FindBy(how = How.ID, using = "txtEditPaymentCardLabel"),
            @FindBy(how = How.ID, using = "Edit")
    })
    public WebElement RedHybrid_EditPaymentCardLabel;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "closeIcon"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement RedHybrid_PaymentXIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgPaymentCardTypes1"),
            @FindBy(how = How.ID, using = "Card Type-1")
    })
    public WebElement RedHybrid_PaymentCardType1;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgPaymentCardTypes2"),
            @FindBy(how = How.ID, using = "Card Type-2")
    })
    public WebElement RedHybrid_PaymentCardType2;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgPaymentCardTypes3"),
            @FindBy(how = How.ID, using = "Card Type-3")
    })
    public WebElement RedHybrid_PaymentCardType3;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgPaymentCardTypes4"),
            @FindBy(how = How.ID, using = "Card Type-5")
    })
    public WebElement RedHybrid_PaymentCardType4;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPrivacyTextView"),
            @FindBy(how = How.ID, using = "I consent to Vodafone storing my card details for future recurring and one-off payments and understand my personal data will be processed in accordance with Vodafone Limited's Privacy Policy."),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeScrollView//XCUIElementTypeStaticText[contains(@name,'I consent to Vodafone')]")
    })
    public WebElement RedHybrid_PaymentConfirmationText1;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtTermsTextView"),
            @FindBy(how = How.ID, using = "I confirm I have read and agree to Vodafone Limited’s Terms and conditions.")
    })
    public WebElement RedHybrid_PaymentConfirmationText2;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridBackView"),
            @FindBy(how = How.ID, using = "bottomSheetBackButtonIdentifier")
    })
    public WebElement RedHybrid_PaymentBackIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPaymentHearder"),
            @FindBy(how = How.ID, using = "Add a payment method")
    })
    public WebElement RedHybrid_AddPaymentHeader;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPaymentDesc"),
            @FindBy(how = How.XPATH, using = "//*[contains(@value,'payment method you will use for your monthly plan ')]")
    })
    public WebElement RedHybrid_AddPaymentDesc;

    public RedHybrid_AddNewPaymentPO() {
        super();
    }


}
