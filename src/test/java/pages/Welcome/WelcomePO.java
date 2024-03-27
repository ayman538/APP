package pages.Welcome;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class WelcomePO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/Welcome_GetStarted_CTA"),
            @FindBy(how = How.XPATH, using = "//*[@label='Get started']")
    })
    public WebElement WF_GetStarted_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_continue"),
            @FindBy(how = How.ID, using = "Continue")
    })
    public WebElement WF_Continue_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.android.packageinstaller:id/permission_allow_button"),
            @FindBy(how = How.ID, using = "Allow")
    })
    public WebElement WF_AllowContactPermision_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.android.packageinstaller:id/permission_allow_button"),
            @FindBy(how = How.ID, using = "//*[@label='OK']")
    })
    public WebElement WF_AllowPhonePermision_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/button3"),
            @FindBy(how = How.ID, using = "txt")
    })
    public WebElement WF_UsagePermisionNoThanks_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_noThanks"),
            @FindBy(how = How.ID, using = "No thanks")
    })
    public WebElement WF_NoThanksForLogin_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txt_welcome"),
            @FindBy(how = How.XPATH, using = "//*[@label='Welcome back!']")
    })
    public WebElement WF_welcomeBackTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "Always Allow")
    })
    public WebElement WF_LocationPermission;

    public WelcomePO() {
        super();
    }
}
