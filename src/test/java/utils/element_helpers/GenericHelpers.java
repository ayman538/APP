package utils.element_helpers;

import com.google.common.collect.ImmutableMap;
import core.Hooks;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static utils.element_helpers.ActionsHelpers.TapElementIfDisplayed;
import static utils.element_helpers.ScrollHelpers.SwipeBackForIOS;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.checkElementPresence;
import static utils.element_helpers.VerifyHelpers.checkLocatorePresence;
import static utils.element_helpers.WaitHelpers.waitForInvisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class GenericHelpers  {
    public static AppiumDriver driver;
    static {driver = Hooks.getDriver();}
    public GenericHelpers() {
    }
    public static String removeDollarSign(String value) {
        String result = "";
        String regex = "£([^)]+)";

        Pattern p = Pattern.compile(regex, Pattern.DOTALL);
        Matcher m1 = p.matcher(value);
        if (m1.find()) {
            result = m1.group(1);
        }
        return result;
    }

    public static void navigateToURL(String s) {
        try {
            driver.navigate().to(s);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static String hashMSISDIN(String msisdn) {

        for (int i = 0; i < 8; i++) {
            msisdn = msisdn.substring(0, i) + "X" + msisdn.substring((i + 1));
        }
        return msisdn;
    }

    public static void CloseCookies(WebElement element) {
        TapElementIfDisplayed(element);
    }

    public static void CloseCookies(By locator) {
        TapElementIfDisplayed(locator);
    }

    public static void openDeepLinkForiOS(String deepLink){
        By safariURLBarSelector= By.xpath("//XCUIElementTypeTextField[@name='TabBarItemTitle']");
        By safariURLTextSelector= By.xpath("//XCUIElementTypeTextField[@name='URL']");
        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
        ((RemoteWebDriver) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
        ((RemoteWebDriver) driver).findElement(safariURLBarSelector).click();
        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(deepLink);
        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(Keys.ENTER);
        ((RemoteWebDriver) driver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ((RemoteWebDriver) driver).findElement(By.id("Open")).click();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void terminateSafariForiOS(){
        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
    }

    public static void navigateBackForiOS(){
        List<By> backLocators = new ArrayList<>();
        By backLocator1= By.name("return to username screen button") ;
        By backLocator2= By.name("Navigate back") ;
        By backLocator3= By.name("backIcon");
        By backLocator4= By.name("BackButton");
        backLocators.add(backLocator1);
        backLocators.add(backLocator2);
        backLocators.add(backLocator3);
        backLocators.add(backLocator4);

        List<By> closeLocators = new ArrayList<>();
        By closeLocator1= By.name("closeIcon") ;
        By closeLocator2= By.name("VFGwebCloseButton");
        By closeLocator3= By.name("Done");
        closeLocators.add(closeLocator1);
        closeLocators.add(closeLocator2);
        closeLocators.add(closeLocator3);

        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
        if(checkLocatorePresence(backLocator1) || checkLocatorePresence(backLocator2) || checkLocatorePresence(backLocator3) || checkLocatorePresence(backLocator4)) {
            for (By backLocator : backLocators) {
                if (checkLocatorePresence(backLocator)) {
                    driver.findElement(backLocator).click();
                    break;
                }
            }
        }
        else if (checkLocatorePresence(closeLocator1) || checkLocatorePresence(closeLocator2) || checkLocatorePresence(closeLocator3)) {
            for (By closeLocator : closeLocators) {
                if (checkLocatorePresence(closeLocator)) {
                    driver.findElement(closeLocator).click();
                    break;
                }
            }
        }
        else {
            SwipeBackForIOS();
        }

    }
    public static void clickOnRetryButton() {
        for (int i = 1; i < 5; i++) {
            By error = By.id("com.myvodafoneapp:id/txtAlertMessageErrorCode");
            By Retry = By.xpath(GetXpath("Retry"));
            if (checkLocatorePresence(error)) {
//             waitForVisibilityForReinvent(error,30);
                waitForInvisibility(Retry, 30);
                driver.findElement(Retry).click();
                System.out.println("clicked");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            if (!checkElementPresence(error)) {
                System.out.println("Retry button isn't displayed");
                break;
            } else {
                System.out.println(" try number" +i);
            }
        }
    }

    public static void CloseWebView(WebElement element) {
        waitForVisibility( element);
         element.click();
    }

    public static void navigateBackForAndroid(){
        driver.navigate().back();
    }

}
