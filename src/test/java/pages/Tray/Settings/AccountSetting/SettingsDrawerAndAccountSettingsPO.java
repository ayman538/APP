package pages.Tray.Settings.AccountSetting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class SettingsDrawerAndAccountSettingsPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='My account controls']"),
            @FindBy(how = How.XPATH, using = "//*[@label='My account controls']")
            // TODO : find locator
    })
    public WebElement AS_AccountControls;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Direct debit']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Direct debit']")
    })
    public WebElement AS_DirectDebit;
    @FindAll({
            @FindBy(how = How.XPATH, using = "((//*[@resource-id='com.myvodafoneapp.dev:id/wdgSubSwitchChildCard']))[1]"),
            @FindBy(how = How.XPATH, using = "((//XCUIElementTypeOther[@name='wdgSubSwitchChildCard']))[1]")
    })
    public WebElement MyAcc_SubscriptionCard;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/backImageView"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name='back icon']")
    })
    public WebElement AS_BackButton;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage account']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage account']")
            // TODO : find locator
    })
    public WebElement AS_ManageAccount;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Address details']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Address details']")
            // TODO : find locator
    })
    public WebElement AS_AddressDetails;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='SIM swap']"),
            @FindBy(how = How.XPATH, using = "//*[@label='SIM swap']")
            // TODO : find locator
    })
    public WebElement AS_SIMSwap;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/img_close"),
            @FindBy(how = How.XPATH, using = "//*[@label='SIM swap']")
            // TODO : find locator
    })
    public WebElement eCare_XButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/img_back"),
            @FindBy(how = How.XPATH, using = "//*[@label='SIM swap']")
            // TODO : find locator
    })
    public WebElement eCare_BackButton;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dismissImageView")
    })

    public WebElement AppScreenCloseButton;


        @FindAll({
                @FindBy(how = How.XPATH, using = "//*[@text='Account settings']"),
                @FindBy(how = How.XPATH, using = "//*[@label='Account settings']")

        })
        public WebElement AS_AccountSettingTittle;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Spend Manager']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Spend Manager']")
    })
   public WebElement SpendManagerCTA;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Spend manager']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Spend manager']")
    })
   public WebElement SpendManagerWebViewHeader;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Cards & Payments']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Cards & Payments']")
    })
    public WebElement CardsAndPaymentsCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage Cards & Payment']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage Cards & Payment']")
    })
    public WebElement ManageCardsAndPaymentWebviewHeader;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Profile & Address']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Profile & Address']")
    })
    public WebElement ProfileAndAddressCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Profile']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Profile']")
    })
    public WebElement ProfileWebviewHeader;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Addresses']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Addresses']")
    })
    public WebElement AddressesWebviewHeader;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Activate SIM']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Activate SIM']")
    })
    public WebElement ActivateSimCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Activate my SIM card']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Activate my SIM card']")
    })
    public WebElement ActivateSimWebviewHeader;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='SIM Swap']"),
            @FindBy(how = How.XPATH, using = "//*[@label='SIM Swap']")
    })
    public WebElement SimSwapCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Swap my SIM']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"Swap my SIM\"]")
    })
    public WebElement SimSwapWebviewHeader;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='SIM Swap']")
    })
    public WebElement SimSwapWebViewTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data notifications']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data notifications']")
    })
    public WebElement DataNotificationsCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data notifications']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data notifications']")
    })
    public WebElement DataNotificationsWebviewHeader;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data spend controls']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data spend controls']")
    })
    public WebElement SSO_DataNotifications;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Send my alerts to preferred number :']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Send my alerts to preferred number :']")
    })
    public WebElement SSO_SendMyAlertstoPreferredNumberCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/iconImageView"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeScrollView[@name=\"scrollView\"]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther[1]/XCUIElementTypeImage")
    })
    public WebElement LogoutLogo;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Logout']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Logout']")
    })
    public WebElement LogoutCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/titleTextView"),
            @FindBy(how = How.XPATH, using ="//*[@label='Are you sure you want to log out?']")
    })
    public WebElement LogoutMessage;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Confirm']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Confirm']")
    })
    public WebElement Logout_Confirm;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Cancel']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Cancel']")
    })
    public WebElement Logout_Cancel;

    public SettingsDrawerAndAccountSettingsPO() {
        super();
    }


}
