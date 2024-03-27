package pages.RedHybrid.LoginFlow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_Login_PO extends CommonPo {

    public RedHybrid_Login_PO() {super();}

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDMWifiDisconnectedContinue_Button"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement RedHybrid_WifiDisconnectedContinueCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='My Account']"),
            @FindBy(how = How.ID_OR_NAME, using = "My Account"),
            @FindBy(how = How.XPATH, using = "//*[@label='My Account']"),
            @FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView"),
    })
    public WebElement RedHybrid_MyAccount;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeTextField']"),
            @FindBy(how = How.XPATH, using = "//*[@resource-id='user']"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeTextField']")
    })
    public WebElement RedHybrid_Username;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.XPATH, using = "//*[@name='Continue']")
    })
    public WebElement RedHybrid_ContinueCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='pass']"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeSecureTextField']")
    })
    public WebElement RedHybrid_Password;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Log in']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Log in']")
    })
    public WebElement RedHybrid_Password_LoginCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Choose a phone from the list']"),
            @FindBy(how = How.XPATH, using = "//*[@value='Choose a phone from the list']")
    })

    public WebElement RedHybrid_SelectSecurityAccount;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Request security code']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Request security code']")
    })
    public WebElement RedHybrid_RequestSecurityTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Enter security code']"),
            @FindBy(how = How.XPATH, using = "(//*[@label='Enter security code'])[1]")
    })
    public WebElement RedHybrid_EnterSecurityCodeTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.EditText'])[1]"),
            @FindBy(how = How.XPATH, using = "(//*[@type= 'XCUIElementTypeSecureTextField'])[1]")
    })
    public WebElement RedHybrid_EnterSecurityCodeField1;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.EditText'])[2]"),
            @FindBy(how = How.XPATH, using = "(//*[@type= 'XCUIElementTypeSecureTextField'])[2]")
    })
    public WebElement RedHybrid_EnterSecurityCodeField2;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.EditText'])[3]"),
            @FindBy(how = How.XPATH, using = "(//*[@type= 'XCUIElementTypeSecureTextField'])[3]")
    })
    public WebElement RedHybrid_EnterSecurityCodeField3;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.EditText'])[4]"),
            @FindBy(how = How.XPATH, using = "(//*[@type= 'XCUIElementTypeSecureTextField'])[4]")
    })
    public WebElement RedHybrid_EnterSecurityCodeField4;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.EditText'])[5]"),
            @FindBy(how = How.XPATH, using = "(//*[@type= 'XCUIElementTypeSecureTextField'])[5]")
    })
    public WebElement RedHybrid_EnterSecurityCodeField5;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Login successful']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Login successful']"),
            @FindBy(how = How.ID, using = "Login successful")
    })
    public WebElement RedHybrid_LoginPreferencesTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='OK, all done']"),
            @FindBy(how = How.XPATH, using = "//*[@label='OK, all done']")
    })
    public WebElement RedHybrid_LoginPreferencesOkCTA;
}