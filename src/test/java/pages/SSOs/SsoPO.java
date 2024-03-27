package pages.SSOs;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class SsoPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Bill and payments']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Previous bills and payments']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Bill and payments']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Previous bills and payments']")
    })
    public WebElement SSO_BillAndPayment;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Total']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Total']")
    })
    public WebElement SSO_LatestBill;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Estimated total']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Estimated total']")
    })
    public WebElement SSO_EstimateCharges;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone Spend Manager']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Vodafone Spend Manager']")
    })
    public WebElement SSO_SpendManager;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@name='Data Cap']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Data cap']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Data Cap']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Data cap']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeTable[@name='scrollView']/XCUIElementTypeCell[2]/XCUIElementTypeButton[10]")

    })
    public WebElement Extras_DataCap;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtCardbtn"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage Data cap']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage Data Cap']"),
            @FindBy(how = How.ID, using = "Manage Data cap")
    })
    public WebElement Extras_ManageDataCap;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data cap']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data cap']")
    })
    public WebElement SSO_DataCap;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage extras']"),
            @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View")
    })
    public WebElement SSO_ManageBarsExtras;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Calling options']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Calling options']")
    })
    public WebElement SSO_ManageBarsCallingOptionsTitle;

    @FindAll({
            //@FindBy(how = How.ID, using = "UPGRADE"),
            @FindBy(how = How.XPATH, using = "(//*[@text='tab 1 of 2 Upgrades'])[1]"),
            @FindBy(how = How.ID_OR_NAME, using = "tab 1 of 2 Upgrades"),
            @FindBy(how = How.XPATH, using = "(//*[@label='tab 1 of 2 Upgrades'])")
    })
    public WebElement SSO_UpgradeNow;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Browse Phones']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Browse Phones']")
    })
    public WebElement UpgradeNow_CTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Upgrade only']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Upgrade only']")
    })
    public WebElement UpgradeOnlyCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnClose"),
            @FindBy(how = How.ID, using = "VFGwebCloseButton")
    })
    public WebElement ExitWebView_Icon;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/message"),
            @FindBy(how = How.ID, using = "Are you sure you want to exit?")

    })
    public WebElement ExitWebView_ConfirmationMsg;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button2"),
            @FindBy(how = How.ID, using = "Cancel")
    })
    public WebElement ExitWebView_ConfirmationMsg_Cancel;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button1"),
            @FindBy(how = How.ID, using = "Exit")
    })
    public WebElement ExitWebView_ConfirmationMsg_Exit;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Home Phone']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Home Phone']")
    })
    public WebElement FLN;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Broadband']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Broadband']")
    })
    public WebElement BB;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change your plan']"),
            @FindBy(how = How.ID, using = "Change your plan")
    })
    public WebElement PT_ChangeYourPlan;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change your plan']"),
            @FindBy(how = How.XPATH, using ="//XCUIElementTypeStaticText[@name=\"Change your plan\"]")

    })
    public WebElement SSO_ChangeYourPlan;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Change your bundle']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"Change your bundle\"]")

    })
    public WebElement SSO_ChangeYourBundle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Make full payment']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Make full payment']")
    })
    public WebElement SSO_MakeFullPaymentCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Track my order']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Track my order']")
            //@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[1]/android.view.View/android.view.View[2]/android.view.View[1]/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[1]")
    })
    public WebElement SSO_TrackMyOrder;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Make a payment to your Device Plan']"),
            @FindBy(how = How.XPATH, using = "//*[@value='Make a payment to your Device Plan']")
    })
    public WebElement SSO_MakeAPayment;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Device']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Device']")
    })
    public WebElement SSO_DeviceTittle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payment history']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Payment history']")
    })
    public WebElement SSO_PaymentHistory;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Active Device Plans']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Active Device Plans']")
    })
    public WebElement SSO_ActiveDevicePlans;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Important documents']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Important documents']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Device Plan documents']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Device Plan documents']")
    })
    public WebElement SSO_ViewDetails;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Activate voucher']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Activate voucher']")

    })
    public WebElement SO_ActivateVoucher;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Marketing preferences']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Marketing preferences']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle")
    })
    public WebElement SSO_MarketingprefrencesTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Post']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Post']"),
    })
    public WebElement SSO_Marketingprefrence_POST;

    @FindBy(how = How.XPATH, using = "//*[@name='Upgrade only']")
    public WebElement tradeInUpgradeOnlyCTA;

    public SsoPO() {
        super();
    }
}