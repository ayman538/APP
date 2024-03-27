package pages.Tray.DashboardTray;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class DashboardTrayPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='My Account']"),
            @FindBy(how = How.ID, using = "My Account")
    })
    public WebElement DB_MyAccountTray_icon;



    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Rewards']"),
            @FindBy(how = How.ID, using = "Rewards")
    })

    public WebElement DB_VeryMeTray;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tobi"),
            @FindBy(how = How.XPATH, using = "//*[@name='wdgDashboardTrayContainer']/XCUIElementTypeOther[1]")
    })
    public WebElement DB_TobiTray_icon;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/biometrics_view"),
            @FindBy(how = How.ID, using = "biometrics_view")
    })
    public WebElement DB_TobiTray_BiometricsIcon;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/offer_login_option_title"),
            @FindBy(how = How.ID, using = "offer_login_option_title")
    })
    public WebElement DB_TobiTray_OfferLoginTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/offer_login_option_description"),
            @FindBy(how = How.ID, using = "offer_login_option_description")
    })
    public WebElement DB_TobiTray_OfferLoginDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/loginCTAButton"),
            @FindBy(how = How.ID, using = "loginCTAButton")
    })
    public WebElement DB_TobiTray_PromptLoginCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/skipLoginCTAButton"),
            @FindBy(how = How.ID, using = "skipLoginCTAButton")
    })
    public WebElement DB_TobiTray_PromptSkipLoginCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/closePartialImageView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement DB_TobiTray_PromptXicon;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='App Settings']"),
            @FindBy(how = How.ID, using = "Settings")
    })
    public WebElement appSettingsTray;

    public DashboardTrayPO() {
        super();
    }

}
