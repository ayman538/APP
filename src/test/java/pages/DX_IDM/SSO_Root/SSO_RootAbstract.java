package pages.DX_IDM.SSO_Root;

import org.json.simple.parser.ParseException;

import java.io.IOException;

public abstract class SSO_RootAbstract {

    public SSO_RootAbstract(){
    }

    public abstract void validateUserHasLoggedIn_FullLogin() throws InterruptedException;

    public abstract void validateUserHasLoggedIn_UFL() throws ParseException, InterruptedException;

    public abstract void navigateToAccountSettings() throws IOException;

    public abstract void clickOnManageAssountSSO();

    public abstract void navigateToExtras();

    public abstract void clickOnManageBarsAndExtrasSSO();

    public abstract void navigateToCurrentCharges();

    public abstract void clickOnViewDetailsSSO();

    public abstract void clickOnDirectDebitSSO();

    public abstract void clickOnSimSwapSSO();

    public abstract void clickOnSpendManagerSSO();
}
