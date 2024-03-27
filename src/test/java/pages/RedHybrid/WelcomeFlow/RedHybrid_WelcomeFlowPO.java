package pages.RedHybrid.WelcomeFlow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_WelcomeFlowPO extends CommonPo {

    public RedHybrid_WelcomeFlowPO(){
        super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_intro_title"),
            @FindBy(how = How.ID, using = "Welcome_to_My_Vodafone_Title")
    })
    public WebElement RedHybrid_WelcomeTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_continue"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    })
    public WebElement RedHybrid_WelcomeContinueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_terms_title"),
            @FindBy(how = How.ID, using = "Welcome_to_My_Vodafone_Title")
    })
    public WebElement RedHybrid_PrivacyScreenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_terms_subtitle"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement RedHybrid_PrivacyScreenSubTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_terms_text"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement RedHybrid_TermsText;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/toggle_terms"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeSwitch']")
    })
    public WebElement RedHybrid_PrivacyAndTermsToggle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_terms_message"),
            @FindBy(how = How.XPATH, using = "//*[@label='Please agree to the Terms and \u2028Conditions before continuing']")
    })
    public WebElement RedHybrid_PrivacyAndTermsToggleMessage;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_continue"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    })
    public WebElement RedHybrid_PrivacyScreenContinueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_permissions_title"),
            @FindBy(how = How.ID, using = "One last thing")
    })
    public WebElement RedHybrid_PermissionScreenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_permissions_subtitle"),
            @FindBy(how = How.ID, using = "To get the most from the My Vodafone App, we'd like to ask for some permissions")
    })
    public WebElement RedHybrid_PermissionScreenSubTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_continue"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    })
    public WebElement RedHybrid_PermissionScreenContinueCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='NO THANKS']")
    })
    public WebElement NoThanksPermission;


}