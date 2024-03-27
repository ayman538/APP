package pages.RedHybrid.LoginFlow;

import org.json.simple.parser.ParseException;

public abstract class RedHybrid_LoginLogic_Abstract extends RedHybrid_Login_PO{


    public RedHybrid_LoginLogic_Abstract() {super();}

    public abstract void loginToMyVodafoneScreenIsDisplayed();

    public abstract void clickOnSkipLoginButton();

    public abstract void disconnectWiFiAndClickContinue();

    public abstract void dashboardIsDisplayed();

    public abstract void clickOnLoginCTA();

    public abstract void enterUsernameAndPassword();

    public abstract void selectAccountAndEnterSecurityCode() throws ParseException;

    public abstract void ChoseLoginPreferenceAndClickOkAllDone();
}