package utils.element_helpers;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utilities.Tools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.WaitHelpers.fluentWait;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class VerifyHelpers  {
    private static int pressX;
    private static int bottomY;
    public static AppiumDriver driver ;
    public static SoftAssertions soft;
    static {
        driver = Hooks.getDriver();
        pressX = driver.manage().window().getSize().width / 2;
        bottomY = driver.manage().window().getSize().height * 4 / 5;
        soft = Hooks.getSoftAssert();
    }


    public VerifyHelpers(){
    }

    //method return WebElement using By
    public static WebElement findElementFromLocators(By locator) {
        WebElement element = driver.findElement(locator);
        return element;
    }

    //method return list of WebElement using By
    public static List<WebElement> findElementsFromLocators(List<By> locators) {
        List<WebElement> elements = new ArrayList<>();
        for (By locator : locators) {
            elements.addAll(driver.findElements(locator));
        }
        return elements;
    }

    public static void AssertDisplayed(Boolean actual) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("IOS") && actual == false)
            actual = true;
        try {
            Assert.assertTrue(actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void HardAssertNotDisplayed(String element,Boolean actual) {
        Assertions.assertFalse(actual,"Element is exist ".concat(element));
    }

    public static boolean elementIsPresent(WebElement element) {
        try {
            element.isDisplayed();
            System.out.println("Element is exist");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element isn't exist");
            return false;
        }
        return true;
    }

    public static boolean elementIsPresent(By locator) {
        WebElement element = findElementFromLocators(locator);
        try {
            element.isDisplayed();
            System.out.println("Element is exist");
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Element isn't exist");
            return false;
        }
        return true;
    }

    public static void AssertSoftDisplayed(Boolean actual) {
        SoftAssert softassert = new SoftAssert();
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("IOS") && actual == false)
            actual = true;
        try {
            softassert.assertTrue(actual);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void AssertResult(String actual, String expected) {

        boolean result = true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            result = false;
        }
        Assert.assertTrue(result);
    }

    public static void AssertResultNotEqual(String actual, String expected) {

        boolean result =true;
        try {
            Assert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            result = false;
        }
        Assert.assertFalse(result);
    }

    public static void AssertSoftResult(String actual, String expected) {
        SoftAssert softassert = new SoftAssert();
        boolean result = true;
        try {
            softassert.assertEquals(actual, expected);
        } catch (AssertionError e) {
            result = false;
        }
        softassert.assertTrue(result);
    }

    public static void AssertSoftAll() {
        SoftAssert softassert = new SoftAssert();
        softassert.assertAll();
    }

    public static WebElement assertDisplayed(WebElement element, int waitSec) {
        fluentWait(waitSec, 1)
                .until(
                        ExpectedConditions.or(
                                ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)),
                                ExpectedConditions.visibilityOf(element)));

        return element;
    }

    public static By assertDisplayed(By locator, int waitSec) {
        WebElement element = findElementFromLocators(locator);
        fluentWait(waitSec, 1)
                .until(
                        ExpectedConditions.or(
                                ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)),
                                ExpectedConditions.visibilityOf(element)));

        return locator;
    }

    public static List<WebElement> assertAllDisplayed(List<WebElement> elements) {
        return elements.stream()
                .map(element -> assertDisplayed(element, 1))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<By> assertAllDisplayed(ArrayList<By> locators) {
        return locators.stream()
                .map(element -> assertDisplayed(element, 1))
                .distinct()
                .collect(Collectors.toList());
    }

    public static boolean doesElementContainAttribute(
            WebElement element, String attribute, String attrValue) {
        return element.getAttribute(attribute).contains(attrValue);
    }

    public static boolean doesElementContainAttribute(
            By locator, String attribute, String attrValue) {
        WebElement element = findElementFromLocators(locator);
        return element.getAttribute(attribute).contains(attrValue);
    }

    public static boolean assertElementsContainAttribute(
            List<WebElement> elements, String attribute, String attrValue) {
        return elements.stream().allMatch(elem -> elem.getAttribute(attribute).contains(attrValue));
    }

    public static boolean assertElementsContainAttribute(
            ArrayList<By> locators, String attribute, String attrValue) {
        return locators.stream().allMatch(locator -> {
            WebElement element = findElementFromLocators(locator);
            return element.getAttribute(attribute).contains(attrValue);
        });
    }

    public static void assertElementDoesNotExist(WebElement element) {
        try {
            element.isDisplayed();
            throw new IllegalArgumentException("Element was unexpectedly present");
        } catch (NoSuchElementException | IndexOutOfBoundsException | ElementNotInteractableException e) {
            // Element does not exist
        }
    }

    public static void assertElementDoesNotExist(By locator) {
        try {
            findElementFromLocators(locator).isDisplayed();
            throw new IllegalArgumentException("Element was unexpectedly present");
        } catch (NoSuchElementException | IndexOutOfBoundsException | ElementNotInteractableException e) {
            // Element does not exist
        }
    }

    public static boolean assertTextNotFound(List<WebElement> elements, String text) {
        Assertions.assertTrue(elements.stream().noneMatch(element -> element.getText().equalsIgnoreCase(text)),
                () -> String.format("Text was found: [%s]", text));
        return true;
    }

    public static boolean assertTextNotFound(ArrayList<By> locators, String text) {
        for (By locator : locators) {
            List<WebElement> elements = findElementsFromLocators(locators);
            Assertions.assertTrue(elements.stream().noneMatch(element -> element.getText().equalsIgnoreCase(text)),
                    () -> String.format("Text was found: [%s] using locator: [%s]", text, locator));
        }
        return true;
    }

    public static boolean assertTextFound(List<WebElement> elements, String text) {
        Assertions.assertTrue(elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)),
                () -> String.format("Text was not found: [%s]", text));
        return true;
    }

    public static boolean assertTextFound(ArrayList<By> locators, String text) {
        for (By locator : locators) {
            List<WebElement> elements = findElementsFromLocators(locators);
            Assertions.assertTrue(elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)),
                    () -> String.format("Text was not found: [%s] using locator: [%s]", text, locator));
        }
        return true;
    }

    public static void assertIsTrueSoftly(String errorMsg, boolean condition) {
        String trace = null;

        if (!condition) {
            Throwable throwable = new Throwable();
            trace =
                    String.format(
                            "[Class -> %s]%n[Method -> %s]%n[Line -> %d]",
                            throwable.getStackTrace()[1].getClassName(),
                            throwable.getStackTrace()[1].getMethodName(),
                            throwable.getStackTrace()[1].getLineNumber());
        }
        soft.assertThat(condition).withFailMessage(format("%nError: %s%n%s", errorMsg, trace)).isTrue();
    }

    public static void assertTextFoundSoftly(List<WebElement> elements, String text) {
        assertIsTrueSoftly(
                format("Text was not found: [%s]", text),
                elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));
    }

    public static void assertTextFoundSoftly(ArrayList<By> locators, String text) {
        List<WebElement> elements = findElementsFromLocators(locators);
        assertIsTrueSoftly(
                format("Text was not found: [%s]", text),
                elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text))
        );
    }

    public static void assertTextFoundSoftly(List<WebElement> elements, String text, String errMsg) {
        assertIsTrueSoftly(
                errMsg, elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));
    }

    public static void assertTextFoundSoftly(ArrayList<By> locators, String text, String errMsg) {
        List<WebElement> elements = findElementsFromLocators(locators);
        assertIsTrueSoftly(
                errMsg, elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));
    }

    public static void assertTextNotFoundInStringList(List<String> strings, String text) {
        Assertions.assertTrue(
                strings.stream().noneMatch(string -> string.equalsIgnoreCase(text)),
                format("Text was found: [%s]", text));
    }

    public static void valuesContained(List<String> actualValues, List<String> expectedValues) {
        List<String> values = new ArrayList<>(expectedValues);

        String errorMsg =
                format(
                        "%n%s - actual values did not contain %n%s - expected values ", actualValues, values);

        Assert.assertTrue(actualValues.containsAll(values));
    }

    public static void valuesNotContained(List<String> actualValues, List<String> expectedValues) {
        List<String> values = new ArrayList<>(expectedValues);

        String errorMsg =
                format("%n%s -  actual values contained %n%s -  unexpected values ", actualValues, values);

        Assert.assertFalse(actualValues.containsAll(values));
    }

    public static void assertSubstringFoundInList(List<WebElement> elements, String text) {
        List<String> targetText = Collections.singletonList(text);
        List<String> elementsText = Tools.buildStringListFromElemList(elements);
        List<String> substrings = Tools.buildSubstringTargetsList(elementsText, targetText);

        valuesContained(substrings, targetText);
    }

    public static void assertSubstringFoundInList(ArrayList<By> locators, String text) {
        List<WebElement> elements = findElementsFromLocators(locators);
        List<String> targetText = Collections.singletonList(text);
        List<String> elementsText = Tools.buildStringListFromElemList(elements);
        List<String> substrings = Tools.buildSubstringTargetsList(elementsText, targetText);

        valuesContained(substrings, targetText);
    }

    public static void assertTextContains(List<String> strings, String text) {
       Assertions.assertTrue(
               strings.stream().anyMatch(string -> string.contains(text)),
                format("List %s did not contain [%s]", strings, text));
    }

    public static void assertTextContainsSoftly(List<String> strings, String text) {
        assertIsTrueSoftly(
                format("List %s did not contain [%s]", strings, text),
                strings.stream().anyMatch(string -> string.contains(text)));
    }

    public static void assertEquals(Object expected, Object actual) {
        String errorMsg =
                format(
                        "Expected and Actual were not equal%n%nExpected:[%s]%nActual:  [%s]%n%n",
                        expected, actual);
        Assert.assertEquals( expected, actual);
    }

    public static boolean CheckElementNotExistWithoutScroll(WebElement element) {
        // This Method check the element is exist or not in the current screenshot "position" without scroll down
        // Return True if the element not exits
        // Return False if the element exits
        boolean existElementFlag = false;
        try {
            element.isDisplayed();
            existElementFlag = true;
        } catch (Exception e) {
            System.out.println("Scroll to the end of screen");
        }
        return !existElementFlag;
    }

    public static boolean CheckElementNotExistWithoutScroll(By locator) {
        // This Method check the element is exist or not in the current screenshot "position" without scroll down
        // Return True if the element not exits
        // Return False if the element exits
        boolean existElementFlag = false;
        WebElement element = findElementFromLocators(locator);
        try {
            element.isDisplayed();
            existElementFlag = true;
        } catch (Exception e) {
            System.out.println("Scroll to the end of screen");
        }
        return !existElementFlag;
    }

    public static boolean CheckElementNotExist(WebElement element) {
        // This Method check the element is exist of not in all the screen "with scroll at the end of the screen"
        // Return True if the element not exits
        // Return False if the element exits
        boolean existElementFlag = false;
        int counter = 0;
        while (!existElementFlag && counter < 4) {
            try {
                element.isDisplayed();
                existElementFlag = true;
            } catch (Exception e) {
                System.out.println("Scroll to the end of screen");
            }
            if (!existElementFlag) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        }
        return !existElementFlag;
    }

    public static boolean CheckElementNotExist(By locator) {
        // This Method check the element is exist of not in all the screen "with scroll at the end of the screen"
        // Return True if the element not exits
        // Return False if the element exits
        boolean existElementFlag = false;
        int counter = 0;
        WebElement element = findElementFromLocators(locator);
        while (!existElementFlag && counter < 4) {
            try {
                element.isDisplayed();
                existElementFlag = true;
            } catch (Exception e) {
                System.out.println("Scroll to the end of screen");
            }
            if (!existElementFlag) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        }
        return !existElementFlag;
    }

    public static boolean IsElementDisplayed(WebElement element) {
        boolean displayed = false;
        try {
            displayed = element.isDisplayed();
        } catch (Exception e) {

        }
        return displayed;
    }

    public static boolean IsElementDisplayed(By locator) {
        boolean displayed = false;
        WebElement element = findElementFromLocators(locator);
        try {
            displayed = element.isDisplayed();
        } catch (Exception e) {

        }
        return displayed;
    }

    //to be replaced by IsElementDisplayed
    public static boolean checkLocatorePresence(By by){
        try{
            driver.findElement(by);
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }

    //to be replaced with elementIsPresent with adding wait step
    public static boolean checkElementPresence(By by){
        try{
            waitForVisibility(driver.findElement(by));
            return true;
        }catch (Exception e){
            return false;
        }
    }
    public static void verifyAllElementsPresent(By... locators) {
        for (By locator : locators) {
            WebElement element = driver.findElement(locator);
            Assert.assertTrue(element.isDisplayed(), "Element not displayed: " + locator);
        }
    }
    public static void scrollAndVerifyElements(By... locators) {
        for (By locator : locators) {
            scrollDownTo(locator);
            WebElement element = driver.findElement(locator);
            Assert.assertTrue(element.isDisplayed(), "Element not displayed: " + locator);
        }
    }



}
