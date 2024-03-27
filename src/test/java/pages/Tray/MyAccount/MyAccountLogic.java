package pages.Tray.MyAccount;

import core.Config;
import models.response.AccountsResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.SkipException;
import pages.Login.Login_Abstract;
import pages.Login.Login_Logic_Android;
import pages.Login.Login_Logic_IOS;
import testdata.ReadResponse;
import utils.AccountsUtils;
import utils.SegmentUtils;
import utils.SubscriptionsUtils;

import java.io.IOException;
import java.util.List;

import static core.Config.getLoginStatus;
import static core.Config.setLoginStatusStatus;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class MyAccountLogic extends MyAccountPO {

    private final Config config = new Config();
    private Login_Abstract login;


    public MyAccountLogic() throws IOException {
        super();
        if (config.isAndroid()) login = new Login_Logic_Android();
        if (config.isIos()) login = new Login_Logic_IOS();
    }

    public void checkLoginStatus() throws IOException, InterruptedException {
        if (getLoginStatus().equalsIgnoreCase("False")) {
            login.LoginFlow();
        } else {
            checkPinLoginForUserWithoutBiometrics();
            checkPinLoginForUserWithBiometrics();
        }
    }

    public void checkPinLoginForUserWithoutBiometrics() throws  InterruptedException {
        boolean exist = true;
        boolean displayed = true;
        try {
            exist = Pin_Field.isDisplayed();
        } catch (Exception e) {
            exist = false;
        }
        try {
            displayed = CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }
        if (exist) {
            login.enterPin();
            Pin_ContinueCTA.click();
            setLoginStatusStatus("LoggedIn");
        } else if (displayed) {
            CancelFingerPrintCTA.click();
            waitForVisibility(Pin_Field);
        }
    }

    public void checkPinLoginForUserWithBiometrics() throws  InterruptedException {
        boolean displayed = true;
        try {
            displayed = login.CancelFingerPrintCTA.isDisplayed();
        } catch (Exception e) {
            displayed = false;
        }
        if (displayed) {
            login.CancelFingerPrintCTA.click();
            System.out.println("Wait till pin field");
            login.enterPin();
            System.out.println("Send the Pin key");
            Pin_ContinueCTA.click();
            setLoginStatusStatus("LoggedIn");
        }
    }

    public void ValidateMyAccountDrawer() throws ParseException {
        waitForVisibility(MyAccTitle);
        String MSISDN = "";
        if (ReadResponse.getSubsList().size() <= 1) {
            System.out.println("user has no subscriptions");
        } else {
            MSISDN = ReadResponse.getSubsList().get(0).get("msisdn");
            if (!ReadResponse.getSubsType(0).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
            for (int i = 1; i < ReadResponse.getSubsList().size() - 1; i++) {
                MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
                if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                    MSISDN = "0" + MSISDN.substring(2);
                }
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
        }
    }

    public void assertSubscriptionCardIsDisplayed(String MSISDN) {
        SwipeToElement(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")), "Right");
        AssertDisplayed(driver.findElement(By.xpath("//*[@text='" + MSISDN + "']")).isDisplayed());
    }

    public void clickOnMyAccount() {
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void ValidateMultipleAccountsUsers() throws ParseException {
        waitForVisibility(MyAccTitle);
        AssertDisplayed(MyAccSelectAccountTitle.isDisplayed());
        if (ReadResponse.getAccountIds().size() > 1)
            MultiAccountsValidation();
        else throw new SkipException("The user has single account");
    }

    private void MultiAccountsValidation() throws ParseException {
        String MSISDN;
        String AccountID;
        for (int i = 0; i < ReadResponse.getAccountIds().size() - 1; i++) {
            MyAccSelectAccountField.click();
            AccountID = ReadResponse.getAccountIds().get(i).get("accountId");
            driver.findElement(By.xpath("//*[@text='" + AccountID + "']")).click();
            for (int j = 0; j < ReadResponse.getSubsList().size() - 1; j++) {
                MSISDN = ReadResponse.getSubsList().get(j).get("msisdn");
                if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                    MSISDN = "0" + MSISDN.substring(2);
                }
                assertSubscriptionCardIsDisplayed(MSISDN);
            }
        }
    }

    public void SwitchToSubscription(String userType) throws ParseException {
        waitForVisibility(MyAccTitle);
        SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();
        AccountsResponseModel accountsResponseModel = AccountsUtils.getAccounts(segmentResponseModel.segment, segmentResponseModel.subscriptionType.name);

        SubscriptionsResponseModel subscriptionsResponseModel = SubscriptionsUtils.getSubscriptions(segmentResponseModel.segment,
                segmentResponseModel.subscriptionType.name,
                System.getProperty("LOA3AccountId"),
                accountsResponseModel.accounts.get(0).accountIdHash,
                accountsResponseModel.accounts.get(0).accountType);

        if (subscriptionsResponseModel.subscriptions.size() > 1)
            SwitchingToAnotherSubscription(subscriptionsResponseModel.subscriptions,userType);
        else throw new SkipException("The user has single account");
    }

    private void SwitchingToAnotherSubscription(List<SubscriptionsResponseModel.Subscription> subscriptions, String userType) throws ParseException {
//        String Segment;
        String MSISDN;
        String SubType;
        for (int i = 1; i < subscriptions.size(); i++) {
//            Segment = subscriptions.get(i).segment;
            MSISDN = subscriptions.get(i).msisdn;
            SubType = subscriptions.get(i).subscriptionType.name;
            if (!SubType.equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            SwipeToElement(driver.findElement(By.xpath(GetXpath(MSISDN))), "Right");
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
            if (SubType.equalsIgnoreCase(userType)) {
                assertSubscriptionDashboardIsDisplayed(MSISDN);
                break;
            }
        }
    }

    private void SwitchingToAnotherSubscription(String userType) throws ParseException {
        String Segment;
        String MSISDN;
        for (int i = 1; i < ReadResponse.getSubsList().size(); i++) {
            Segment = ReadResponse.getSubsType(i);
            MSISDN = ReadResponse.getSubsList().get(i).get("msisdn");
            if (!ReadResponse.getSubsType(i).equalsIgnoreCase("BB")) {
                MSISDN = "0" + MSISDN.substring(2);
            }
            SwipeToElement(driver.findElement(By.xpath(GetXpath(MSISDN))), "Right");
            AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
            if (Segment.equalsIgnoreCase(userType)) {
                assertSubscriptionDashboardIsDisplayed(MSISDN);
                break;
            }
        }
    }

    public void assertSubscriptionDashboardIsDisplayed(String MSISDN) {
        driver.findElement(By.xpath(GetXpath(MSISDN))).click();
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(driver.findElement(By.xpath(GetXpath(MSISDN))).isDisplayed());
    }

}



