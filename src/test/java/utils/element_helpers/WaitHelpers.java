package utils.element_helpers;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

public class WaitHelpers  {
    public static AppiumDriver driver ;
    static {driver = Hooks.getDriver();}

    public WaitHelpers() {
    }

    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    private static List<WebElement> elements(By by) {
        return driver.findElements(by);
    }
    public static ExpectedCondition<Boolean> invisibilityOfElement(final WebElement element) {
        return driver -> {
            try {
                return !(element.isDisplayed());
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true;
            }
        };
    }

    public static ExpectedCondition<Boolean> invisibilityOfElement(final By by) {
        return driver -> {
            try {
                return !(element(by).isDisplayed());
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                return true;
            }
        };
    }

    public static void waitForListLoad(List<WebElement> elements, Integer waitForSeconds) {
        try {
            Assert.assertFalse(elements.isEmpty());
        } catch (AssertionError | Exception e) {
            try {
                fluentWait(waitForSeconds, 1).until(ExpectedConditions.visibilityOf(elements.get(0)));
            } catch (Exception ex) {
                throw new IndexOutOfBoundsException(
                        format("List did not load after waiting [%s]", waitForSeconds.toString()));
            }
        }
    }

    public static void waitForListLoad(By by, Integer waitForSeconds) {
        List<WebElement> elements = driver.findElements(by);
        try {
            Assert.assertFalse(elements.isEmpty());
        } catch (AssertionError | Exception e) {
            try {
                fluentWait(waitForSeconds, 1).until(ExpectedConditions.visibilityOf(elements.get(0)));
            } catch (Exception ex) {
                throw new IndexOutOfBoundsException(
                        format("List did not load after waiting [%s]", waitForSeconds.toString()));
            }
        }
    }

    public static void waitForInvisibility(WebElement element) {
        fluentWait(30, 1).until(invisibilityOfElement(element));
    }

    public static void waitForInvisibility(By by, int seconds) {
        fluentWait(seconds, 1).until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitForVisibility(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibility(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public static void waitForVisibilityForReinvent(WebElement element, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForVisibilityForReinvent(By by, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element(by)));
    }

    public static void waitForInVisibility(WebElement element) {
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(element);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }

    public static void waitForInVisibility(By by) {
        List<WebElement> elementList = new ArrayList<>();
        elementList.add(element(by));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
    }

    public static void waitForAttributeToBeContained(WebElement element, String attribute, String attributeToBe, int secondsToWait) {
        fluentWait(secondsToWait, 1)
                .until(ExpectedConditions.attributeContains(element, attribute, attributeToBe));
    }

    public static void waitForAttributeToBeContained(By by, String attribute, String attributeToBe, int secondsToWait) {
        fluentWait(secondsToWait, 1)
                .until(ExpectedConditions.attributeContains(element(by), attribute, attributeToBe));
    }

    public static void waitForAttributeToNotBeContained(
            WebElement element, String attribute, String attributeToBe, int secondsToWait) {
        fluentWait(secondsToWait, 1)
                .until(not(ExpectedConditions.attributeContains(element, attribute, attributeToBe)));
    }

    public static void waitForAttributeToNotBeContained(By by, String attribute, String attributeToBe, int secondsToWait) {
        fluentWait(secondsToWait, 1)
                .until(not(ExpectedConditions.attributeContains(element(by), attribute, attributeToBe)));
    }

    public static FluentWait<WebDriver> fluentWait(Integer seconds, Integer pollTime) {
        assertWaitLimit(seconds);

        FluentWait<WebDriver> fluentWait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofSeconds(pollTime))
                        .ignoring(WebDriverException.class);

        if (seconds == 180)
            fluentWait.withMessage(
                    "Time waited reached [3 minute] mark. Test was failed for taking too long.");
        return fluentWait;
    }

    private static void assertWaitLimit(int seconds) {
        boolean timeToWaitIsLessThan3min = 0 < seconds && seconds < 181;

        if (!timeToWaitIsLessThan3min) {
            Assert.fail("Time waited needs to be greater than 0 and less than 3 minutes");
        }
    }

    public static boolean WaitElementAndHandleFullFailureError(WebElement element) {
        boolean exist = false;
        try {
            waitForVisibility(element);
            exist = true;
        } catch (Exception e) {
            System.out.println("Element Does not exits");
        }
        return exist;
    }

    public static boolean WaitElementAndHandleFullFailureError(By by) {
        boolean exist = false;
        try {
            waitForVisibility(element(by));
            exist = true;
        } catch (Exception e) {
            System.out.println("Element Does not exits");
        }
        return exist;
    }

    public static void waitWithCatch(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
        } catch (Exception e) {
            System.out.println("Element not exist");
        }
    }

    public static void waitWithCatch(By by) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(200));
        try {
            wait.until(ExpectedConditions.visibilityOf(element(by)));
        } catch (Exception e) {
            System.out.println("Element not exist");
        }
    }
}
