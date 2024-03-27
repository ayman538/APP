package pages.Tray.Billing;


import core.Config;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import pages.NewBilling.DirectDebitPO;

import static core.Config.getLoginStatus;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForInVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
@Deprecated
public class DirectDebitLogic extends DirectDebitPO {


    private final Config config = new Config();
    private Login_Abstract login;


    public DirectDebitLogic()  {
        super();
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
    }

    public void navigateToBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
        waitForVisibility(Bill_Xicon);
        scrollDownTo(Bill_DirectDebitCTA);
    }

    public void validateDirectDebitDesc() {
        AssertResult(Bill_DirectDebitDesc.getText(), "Set up or manage the payment of your monthly bill via direct debit");
    }

    public void validateDirectDebitCTA() {
        AssertResult(Bill_DirectDebitCTA.getText(), "Direct Debit");
    }

    public void validateDirectDebitCTAFunc() {
        Bill_DirectDebitCTA.click();
        if (getLoginStatus().equalsIgnoreCase("False")) {
            waitForInVisibility(Bill_DirectDebitCTA);
            AssertDisplayed(Login_username.isDisplayed());
            Login_Xicon.click();
        }
    }

}