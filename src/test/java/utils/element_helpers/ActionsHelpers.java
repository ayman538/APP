package utils.element_helpers;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import static java.lang.String.format;

public class ActionsHelpers {
    public static AppiumDriver driver;

    static {
        driver = Hooks.getDriver();
    }

    public ActionsHelpers() {
    }

    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    private static List<WebElement> elements(By by) {
        return driver.findElements(by);
    }

    public static void jsClick(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        try {
            element.click();
        } catch (Exception e) {
            jse.executeScript("arguments[0].click();", element);
        }
    }

    public static void jsClick(By by) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement element = element(by);
        try {
            element.click();
        } catch (Exception e) {
            jse.executeScript("arguments[0].click();", element);
        }
    }

    public static void jsSetValue(WebElement element, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(format("arguments[0].value='%s';", value), element);
    }

    public static void jsSetValue(By by, String value) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(format("arguments[0].value='%s';", value), element(by));
    }

    public static void jsClear(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);
    }

    public static void jsClear(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element(by));
    }

    public static void clickSequentially(List<WebElement> elements, Integer index, Integer amount) {
        int clicked = 0;

        while (clicked < amount) {
            elements.get(index).click();
            clicked++;
            index++;
        }
    }

    public static void clickSequentially(By by, Integer index, Integer amount) {
        int clicked = 0;

        while (clicked < amount) {
            elements(by).get(index).click();
            clicked++;
            index++;
        }
    }

    public static void clickMultiple(WebElement element, Integer amount) {
        int clicked = 0;

        while (clicked < amount) {
            element.click();
            clicked++;
        }
    }

    public static void clickMultiple(By by, Integer amount) {
        int clicked = 0;

        while (clicked < amount) {
            element(by).click();
            clicked++;
        }
    }


    public static Point getCenterOfElement(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }



    public static void tap(WebElement element) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        //tap.addAction(driver);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), getCenterOfElement(element)));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public static void tap(By by) {
        WebElement element = driver.findElement(by);
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), getCenterOfElement(element)));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public static void TapElementIfDisplayed(WebElement webelement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(webelement));
            webelement.click();
            System.out.println("Cookies is displayed and closed");
        } catch (Exception e) {
            System.out.println("Cookies not displayed");
        }
    }

    public static void TapElementIfDisplayed(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        try {
            wait.until(ExpectedConditions.visibilityOf(element(by)));
            element(by).click();
            System.out.println("Cookies is displayed and closed");
        } catch (Exception e) {
            System.out.println("Cookies not displayed");
        }
    }

    public static void HideVOV(WebElement webelement) {
        TapElementIfDisplayed(webelement);
    }

    public static void HideVOV(By by) {
        TapElementIfDisplayed(element(by));
    }


    public static void tapAtt(int fromX, int fromY) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), new Point(fromX, fromY)));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public static void tapAttScreenBottom() {
        int X = driver.manage().window().getSize().width / 2;
        int Y = driver.manage().window().getSize().height - 50;
        tapAtt(X,Y);

    }

    public static void tapAtScreenCenter() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int X = driver.manage().window().getSize().width / 2;
        int Y = driver.manage().window().getSize().height / 2;
        tapAtt(X,Y);
    }

    public static void doubleClick(WebElement element) {
        element.click();
        try {
            element.click();
        } catch (Exception e) {
            //doNothing
        }
    }

    public static void doubleClick(By by) {
        WebElement element = element(by);
        element.click();
        try {
            element.click();
        } catch (Exception e) {
            //doNothing
        }
    }

    public static WebElement findElementElementByDynamicLocatorAndIndex(String locator, int index) {
        return driver.findElement(By.xpath("(//*[@name='" + locator + "'])[" + (index + 1) + "]"));
    }


    public static WebElement findElementBytext(String attribute, String name) {
        return driver.findElement(By.xpath("(//*[@" + attribute + "='" + name + "'])"));
    }

}

