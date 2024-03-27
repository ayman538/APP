//package base;
//
//import com.google.common.collect.ImmutableMap;
//import core.Hooks;
//import io.appium.java_client.*;
//import io.appium.java_client.pagefactory.AppiumFieldDecorator;
//import io.appium.java_client.touch.TapOptions;
//import io.appium.java_client.touch.WaitOptions;
//import io.appium.java_client.touch.offset.ElementOption;
//import io.appium.java_client.touch.offset.PointOption;
//import org.assertj.core.api.SoftAssertions;
//import org.jsoup.Jsoup;
//import org.openqa.selenium.NoSuchElementException;
//import org.openqa.selenium.*;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedCondition;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.FluentWait;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.asserts.SoftAssert;
//import utilities.Tools;
//
//import java.lang.reflect.Field;
//import java.time.Duration;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;
//
//import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
//import static io.appium.java_client.touch.WaitOptions.waitOptions;
//import static io.appium.java_client.touch.offset.PointOption.point;
//import static java.lang.String.format;
//import static java.time.Duration.ofMillis;
//import static org.openqa.selenium.support.ui.ExpectedConditions.not;
//import static utilities.PropertiesLoader.readPropertyFile;
//import static utilities.Tools.toCamelCase;
//
//public abstract class PageObjectBase {
//    private final int pressX;
//    private final int bottomY;
//    public MobileDriver driver;
//    public SoftAssertions soft = Hooks.getSoftAssert();
//
//
//
//    public PageObjectBase() {
//        this.driver = Hooks.getDriver();
//        setDecoratorBasedOnPlatform();
//        pressX = driver.manage().window().getSize().width / 2;
//        bottomY = driver.manage().window().getSize().height * 4 / 5;
//    }
//
//    /**
//     * An expectation for checking that an element is either invisible or not present on the DOM.
//     *
//     * @param element used to find the element
//     * @return true if the element is not displayed or the element doesn't exist or stale element
//     */
//    public static ExpectedCondition<Boolean> invisibilityOfElement(final WebElement element) {
//        return driver -> {
//            try {
//                return !(element.isDisplayed());
//            } catch (NoSuchElementException | StaleElementReferenceException e) {
//                return true;
//            }
//        };
//    }
//
//    //TODO add hardAssertion
//    public static void AssertDisplayed(Boolean actual) {
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        if (platform.equalsIgnoreCase("IOS") && actual == false)
//            actual = true;
//        try {
//            Assert.assertTrue(actual);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void HardAssertNotDisplayed(String element,Boolean actual) {
//        //Assertions.assertFalse("Element is exist ".concat(element),actual);
//    }
//    public static boolean elementIsPresent(WebElement element) {
//        try {
//            element.isDisplayed();
//            System.out.println("Element is exist");
//            return true;
//        } catch (org.openqa.selenium.NoSuchElementException e) {
//            System.out.println("Element isn't exist");
//            return false;
//        }
//    }
//
//    public static void AssertSoftDisplayed(Boolean actual) {
//        SoftAssert softassert = new SoftAssert();
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        if (platform.equalsIgnoreCase("IOS") && actual == false)
//            actual = true;
//        try {
//            softassert.assertTrue(actual);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void AssertResult(String actual, String expected) {
//
//        boolean result = true;
//        try {
//            Assert.assertEquals(actual, expected);
//        } catch (AssertionError e) {
//            result = false;
//        }
//        Assert.assertTrue(result);
//    }
//
//    public static void AssertResultNotEqual(String actual, String expected) {
//
//        boolean result =true;
//        try {
//            Assert.assertEquals(actual, expected);
//        } catch (AssertionError e) {
//            result = false;
//        }
//        Assert.assertFalse(result);
//    }
//
//    public static void AssertSoftResult(String actual, String expected) {
//        SoftAssert softassert = new SoftAssert();
//        boolean result = true;
//        try {
//            softassert.assertEquals(actual, expected);
//        } catch (AssertionError e) {
//            result = false;
//        }
//        softassert.assertTrue(result);
//    }
//
//    public static void AssertSoft() {
//        SoftAssert softassert = new SoftAssert();
//    }
//
//    public static void AssertSoftAll() {
//        SoftAssert softassert = new SoftAssert();
//        softassert.assertAll();
//    }
//
//    public static String GetXpath(String currentLabel) {
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        String tempXpath = "";
//        if (platform.equalsIgnoreCase("Android"))
//            tempXpath = "//*[@text=\"" + currentLabel + "\"]";
//        else
//            tempXpath = "//*[@label=\"" + currentLabel + "\"]";
//        return tempXpath;
//    }
//
//    public static String removeDollarSign(String value) {
//        String result = "";
//        String regex = "£([^)]+)";
//
//        Pattern p = Pattern.compile(regex, Pattern.DOTALL);
//        Matcher m1 = p.matcher(value);
//        if (m1.find()) {
//            result = m1.group(1);
//        }
//        return result;
//    }
//
//    public void scrollUp() {
//        scroll(pressX, setTop(), pressX, bottomY);
//    }
//
//    public void goToUniversalLink(String URL) {
//        driver.navigate().to(URL);
//    }
//
//    public void navigateToURL(String s) {
//        driver.navigate().to(s);
//    }
//
//    private void setDecoratorBasedOnPlatform() {
////        Config config = new Config();
////        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
////        if (config.isMobile()) setAppiumDecorator();
//    }
//
//    private void setAppiumDecorator() {
//        AppiumFieldDecorator appiumFieldDecorator =
//                new AppiumFieldDecorator(driver, Duration.ofSeconds(3));
//        PageFactory.initElements(appiumFieldDecorator, this);
//    }
//
//    public void scrollDown() {
//        scroll(pressX, bottomY, pressX, setTop());
//    }
//
//    public void scrollDownTo(String ElementText) {
//        int counter = 0;
//        boolean elementNotFound = false;
//        while (!elementNotFound && counter < 3) {
//            try {
//                driver.findElementByXPath(GetXpath(ElementText));
//                elementNotFound = true;
//            } catch (Exception e) {
//                scrollDown();
//                counter++;
//            }
//        }
//    }
//
//    public WebElement getElementByText(String ElementText) {
//        WebElement element = driver.findElementByXPath(GetXpath(ElementText));
//        return element;
//    }
//
//    public void jsClick(WebElement element) {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        try {
//            element.click();
//        } catch (Exception e) {
//            jse.executeScript("arguments[0].click();", element);
//        }
//    }
//
//    public void jsSetValue(WebElement element, String value) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript(format("arguments[0].value='%s';", value), element);
//    }
//
//    public void jsClear(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value = '';", element);
//    }
//
//    /**
//     * @param elems  list of elements to click on
//     * @param index  index to start clicking from
//     * @param amount how many times to click on elements Sequentially
//     */
//    public void clickSequentially(List<WebElement> elems, Integer index, Integer amount) {
//        int clicked = 0;
//
//        while (clicked < amount) {
//            elems.get(index).click();
//            clicked++;
//            index++;
//        }
//    }
//
//    /**
//     * @param element element that we want to click on
//     * @param amount  how many times to click on element
//     */
//    public void clickMultiple(WebElement element, Integer amount) {
//        int clicked = 0;
//
//        while (clicked < amount) {
//            element.click();
//            clicked++;
//        }
//    }
//
//    /**
//     * @param fieldName Name of declared field on page that will get camel cased
//     * @return Found field with param fieldName from class
//     */
//    private Object getField(String fieldName) {
//        String target = toCamelCase(fieldName);
//        Class aClass = null;
//
//        try {
//            aClass = getClass();
//            Field field = aClass.getDeclaredField(target);
//            field.setAccessible(true);
//            return field.get(this);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new IllegalArgumentException(
//                    format("Element not found: [%s] in Class [%s]", target, aClass.getSimpleName()));
//        }
//    }
//
//    /**
//     * @param elementField Name of element field to find
//     * @return returns found field as WebElement
//     */
//    public WebElement getElement(String elementField) {
//        return (WebElement) getField(elementField);
//    }
//
//    /**
//     * @param elementsField Name of element list field to find
//     * @return returns found field as List<WebElement>
//     */
//    public List<WebElement> getElements(String elementsField) {
//        return (List<WebElement>) getField(elementsField);
//    }
//
//    /**
//     * @param elementFields list of element fields to get
//     * @return returns found fields as List<WebElement>
//     */
//    public List<WebElement> getElements(List<String> elementFields) {
//        return elementFields.stream().map(this::getElement).distinct().collect(Collectors.toList());
//    }
//
//    /**
//     * Get element with text
//     *
//     * @param elements list of elements to search through
//     * @param text     text to look for in elements
//     * @return element found with text
//     */
//    public WebElement getElementWithText(List<WebElement> elements, String text) {
//        return elements.stream()
//                .filter(elem -> elem.getText().trim().equalsIgnoreCase(text))
//                .findFirst()
//                .orElseThrow(
//                        () ->
//                                new NoSuchElementException(
//                                        format("Element Target Text was not found: [%s]", text)));
//    }
//
//    /**
//     * Get element with text
//     *
//     * @param elements  list of elements to search through
//     * @param attrValue text to look for in elements
//     * @return element found with text
//     */
//    public WebElement getElementWithAttribute(
//            List<WebElement> elements, String attribute, String attrValue) {
//        return elements.stream()
//                .filter(elem -> elem.getAttribute(attribute).trim().equalsIgnoreCase(attrValue))
//                .findFirst()
//                .orElseThrow(
//                        () ->
//                                new NoSuchElementException(
//                                        format("Element Attribute was not found: [%s]", attrValue)));
//    }
//
//    /**
//     * Get elements with text
//     *
//     * @param elems   the elements to iterate through and get with matching text
//     * @param strings the text list to iterate through and get an element with the target text
//     * @return the elements found with target text
//     */
//    public List<WebElement> getElementsFromTextList(List<WebElement> elems, List<String> strings) {
//        return strings.stream()
//                .map(text -> getElementWithText(elems, text))
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Assert Element Displayed and return found elements
//     *
//     * @param element the WebElement we want to wait for to be displayed
//     * @param waitSec how many seconds to wait
//     * @return element to be chained off of EX:assertDisplayed(element, 5).click
//     */
//    public WebElement assertDisplayed(WebElement element, int waitSec) {
//        fluentWait(waitSec, 1)
//                .until(
//                        ExpectedConditions.or(
//                                ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(element)),
//                                ExpectedConditions.visibilityOf(element)));
//
//        return element;
//    }
//
//    /**
//     * Assert all Element Displayed and return found elements
//     *
//     * @param elements the WebElements we want to wait for to be displayed
//     * @return elements to be chained off of EX:assertAllDisplayed(element, 5).get(0);
//     */
//    public List<WebElement> assertAllDisplayed(List<WebElement> elements) {
//        return elements.stream()
//                .map(element -> assertDisplayed(element, 1))
//                .distinct()
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * assert all elements with attribute
//     *
//     * @param element   list of elements to search through
//     * @param attribute attribute to look in
//     * @param attrValue text to look for in elements
//     * @return element found with text
//     */
//    public boolean doesElementContainAttribute(
//            WebElement element, String attribute, String attrValue) {
//        return element.getAttribute(attribute).contains(attrValue);
//    }
//
//    /**
//     * assert all elements with attribute
//     *
//     * @param elements  list of elements to search through
//     * @param attribute attribute to look in
//     * @param attrValue text to look for in elements
//     * @return element found with text
//     */
//    public boolean assertElementsContainAttribute(
//            List<WebElement> elements, String attribute, String attrValue) {
//        return elements.stream().allMatch(elem -> elem.getAttribute(attribute).contains(attrValue));
//    }
//
//    /**
//     * @param element to verify as non existing
//     */
//    public void assertElementDoesNotExist(WebElement element) {
//        try {
//            element.isDisplayed();
//            throw new IllegalArgumentException("Element was unexpectedly present");
//        } catch (NoSuchElementException | IndexOutOfBoundsException | ElementNotVisibleException e) {
//            // Element does not exist
//        }
//    }
//
//    /**
//     * @param elemFoundBy By to find element with. We have to use a By to avoid an unwanted wait with
//     *                    the global implicit for an element NOT EXISTING
//     */
//    public void assertElementDoesNotExist(By elemFoundBy) {
//        try {
//            driver.findElement(elemFoundBy).isDisplayed();
//            throw new IllegalArgumentException("Element was unexpectedly present");
//        } catch (NoSuchElementException | IndexOutOfBoundsException | ElementNotVisibleException e) {
//            // Element does not exist
//        }
//    }
//
//    /**
//     * @param elements to search through
//     * @param text     to verify is not found within list
//     * @return true that the text was not found
//     */
//    public boolean assertTextNotFound(List<WebElement> elements, String text) {
//        /*Assert.assertTrue(
//                format("Text was found: [%s]", text),
//                elements.stream().noneMatch(element -> element.getText().equalsIgnoreCase(text)));*/
//        return true;
//    }
//
//    /**
//     * @param elements to search through
//     * @param text     to verify is found within list
//     * @return true that the text was found
//     */
//    public boolean assertTextFound(List<WebElement> elements, String text) {
//        /*Assert.assertTrue(
//                format("Text was not found: [%s]", text),
//                elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));*/
//        return true;
//    }
//
//    /**
//     * @param elements to search through
//     * @param text     to verify is found within list
//     * @return true that the text was found
//     */
//    public void assertTextFoundSoftly(List<WebElement> elements, String text) {
//        assertIsTrueSoftly(
//                format("Text was not found: [%s]", text),
//                elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));
//    }
//
//    /**
//     * @param elements to search through
//     * @param text     to verify is found within list
//     * @param errMsg   custom error message to use
//     * @return true that the text was found
//     */
//    public void assertTextFoundSoftly(List<WebElement> elements, String text, String errMsg) {
//        assertIsTrueSoftly(
//                errMsg, elements.stream().anyMatch(element -> element.getText().equalsIgnoreCase(text)));
//    }
//
//    /**
//     * @param strings to search through
//     * @param text    to verify is not found within list
//     */
//    public void assertTextNotFoundInStringList(List<String> strings, String text) {
//        /*Assert.assertTrue(
//                format("Text was found: [%s]", text),
//                strings.stream().noneMatch(string -> string.equalsIgnoreCase(text)));*/
//    }
//
//    /**
//     * @param elements to search through
//     * @param text     substring to find in elements
//     */
//    public void assertSubstringFoundInList(List<WebElement> elements, String text) {
//        List<String> targetText = Collections.singletonList(text);
//        List<String> elementsText = Tools.buildStringListFromElemList(elements);
//        List<String> substrings = Tools.buildSubstringTargetsList(elementsText, targetText);
//
//        valuesContained(substrings, targetText);
//    }
//
//    /**
//     * @param strings to search through
//     * @param text    to find contained within strings
//     */
//    public void assertTextContains(List<String> strings, String text) {
//       /* Assert.assertTrue(
//                format("List %s did not contain [%s]", strings, text),
//                strings.stream().anyMatch(string -> string.contains(text)));*/
//    }
//
//    /**
//     * @param strings to search through
//     * @param text    to find contained within strings
//     */
//    public void assertTextContainsSoftly(List<String> strings, String text) {
//        assertIsTrueSoftly(
//                format("List %s did not contain [%s]", strings, text),
//                strings.stream().anyMatch(string -> string.contains(text)));
//    }
//    // </editor-fold>
//
//    // <editor-fold desc="Wait Methods">
//
//    /**
//     * assert the expected object equals the actual object
//     *
//     * @param expected
//     * @param actual
//     */
//    public void assertEquals(Object expected, Object actual) {
//        String errorMsg =
//                format(
//                        "Expected and Actual were not equal%n%nExpected:[%s]%nActual:  [%s]%n%n",
//                        expected, actual);
//        Assert.assertEquals( expected, actual);
//    }
//
//    /**
//     * This is a soft assert that will only be hard failed by a soft.assertAll after the scenario has
//     * been completed in the Hooks
//     *
//     * @param condition boolean condition that we want to verify is TRUE
//     * @param errorMsg  error message to use for this specifc soft assert if failed
//     */
//    public void assertIsTrueSoftly(String errorMsg, boolean condition) {
//        String trace = null;
//
//        if (!condition) {
//            Throwable throwable = new Throwable();
//            trace =
//                    String.format(
//                            "[Class -> %s]%n[Method -> %s]%n[Line -> %d]",
//                            throwable.getStackTrace()[1].getClassName(),
//                            throwable.getStackTrace()[1].getMethodName(),
//                            throwable.getStackTrace()[1].getLineNumber());
//        }
//        soft.assertThat(condition).withFailMessage(format("%nError: %s%n%s", errorMsg, trace)).isTrue();
//    }
//
//    /**
//     * @param actualValues   list of strings to check against
//     * @param expectedValues to find contained within actualValues
//     */
//    public void valuesContained(List<String> actualValues, List<String> expectedValues) {
//        List<String> values = new ArrayList<>(expectedValues);
//
//        String errorMsg =
//                format(
//                        "%n%s - actual values did not contain %n%s - expected values ", actualValues, values);
//
//        Assert.assertTrue(actualValues.containsAll(values));
//    }
//
//    /**
//     * @param actualValues   list of strings to check against
//     * @param expectedValues to find NOT contained within actualValues
//     */
//    public void valuesNotContained(List<String> actualValues, List<String> expectedValues) {
//        List<String> values = new ArrayList<>(expectedValues);
//
//        String errorMsg =
//                format("%n%s -  actual values contained %n%s -  unexpected values ", actualValues, values);
//
//        Assert.assertFalse(actualValues.containsAll(values));
//    }
//
//    /**
//     * @param elements       we will wait to be found
//     * @param waitForSeconds time to wait for
//     */
//    public void waitForListLoad(List<WebElement> elements, Integer waitForSeconds) {
//        try {
//            Assert.assertFalse(elements.isEmpty());
//        } catch (AssertionError | Exception e) {
//            try {
//                fluentWait(waitForSeconds, 1).until(ExpectedConditions.visibilityOf(elements.get(0)));
//            } catch (Exception ex) {
//                throw new IndexOutOfBoundsException(
//                        format("List did not load after waiting [%s]", waitForSeconds.toString()));
//            }
//        }
//    }
//
//    /**
//     * @param by      to wait for invisibility of
//     * @param seconds time to wait
//     */
//    public void waitForInvisibility(By by, int seconds) {
//        fluentWait(seconds, 1).until(ExpectedConditions.invisibilityOfElementLocated(by));
//    }
//
//    /**
//     * @param element to wait for invisibility of
//     */
//    public void waitForInvisibility(WebElement element) {
//        fluentWait(30, 1).until(invisibilityOfElement(element));
//    }
//
//    /**
//     * @param element to wait for invisibility of
//     */
//    public void waitForVisibility(WebElement element) {
//        WebDriverWait wait = new WebDriverWait(driver, 60);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//
//    public void waitForVisibility(By by) {
//        WebDriverWait wait = new WebDriverWait(driver, 200);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));    }
//
//    public void waitForVisibilityForReinvent(WebElement element, int seconds) {
//        WebDriverWait wait = new WebDriverWait(driver, seconds);
//        wait.until(ExpectedConditions.visibilityOf(element));
//    }
//    public void waitForVisibilityForReinvent(By by, int seconds) {
//        WebDriverWait wait = new WebDriverWait(driver, seconds);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
//    }
//
//    public void waitForInVisibility(WebElement element) {
//        List<WebElement> elementList = new ArrayList<>();
//        elementList.add(element);
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.invisibilityOfAllElements(elementList));
//    }
//
//    /**
//     * @param element       the element to wait for
//     * @param attribute     attribute to use
//     * @param attributeToBe attribute value we are looking to be contained
//     * @param secondsToWait amount of time to wait
//     */
//    public void waitForAttributeToBeContained(
//            WebElement element, String attribute, String attributeToBe, int secondsToWait) {
//        fluentWait(secondsToWait, 1)
//                .until(ExpectedConditions.attributeContains(element, attribute, attributeToBe));
//    }
//
//    /**
//     * @param element       the element to wait for
//     * @param attribute     attribute to use
//     * @param attributeToBe attribute value we are looking to NOT be contained
//     * @param secondsToWait amount of time to wait
//     */
//    public void waitForAttributeToNotBeContained(
//            WebElement element, String attribute, String attributeToBe, int secondsToWait) {
//        fluentWait(secondsToWait, 1)
//                .until(not(ExpectedConditions.attributeContains(element, attribute, attributeToBe)));
//    }
//
//    /**
//     * @param seconds  seconds to wait
//     * @param pollTime how often the condition should be evaluated
//     * @return chain of returned wait. IMPORTANT! -> must have .until(ExpectedConditions) or it will
//     * not wait
//     */
//    public FluentWait<WebDriver> fluentWait(Integer seconds, Integer pollTime) {
//        assertWaitLimit(seconds);
//
//        FluentWait<WebDriver> fluentWait =
//                new FluentWait<WebDriver>(driver)
//                        .withTimeout(seconds, TimeUnit.SECONDS)
//                        .pollingEvery(pollTime, TimeUnit.SECONDS)
//                        .ignoring(WebDriverException.class);
//
//        if (seconds == 180)
//            fluentWait.withMessage(
//                    "Time waited reached [3 minute] mark. Test was failed for taking too long.");
//        return fluentWait;
//    }
//    // </editor-fold>
//
//    // <editor-fold desc="Mobile Methods">
//
//    private void assertWaitLimit(int seconds) {
//        boolean timeToWaitIsLessThan3min = 0 < seconds && seconds < 181;
//
//        if (!timeToWaitIsLessThan3min) {
//            Assert.fail("Time waited needs to be greater than 0 and less than 3 minutes");
//        }
//    }
//
//    private void assertWaitLimitTimeout(int secondsWaited) {
//        boolean timeLimitReached = secondsWaited == 180;
//
//        if (timeLimitReached)
//            Assert.fail(
//                    format(
//                            "Time waited [%s] reached [3 minute] mark. Test was failed for taking too long.",
//                            secondsWaited));
//    }
//
//    /**
//     * Tap Methods - MOBILE
//     */
//    public void tap(WebElement element) {
//        new TouchAction(driver)
//                .tap(
//                        TapOptions.tapOptions()
//                                .withElement(ElementOption.element(element).withCoordinates(5, 5)))
//                .release()
//                .perform();
//    }
//
////    /**
////     * Scroll Methods - MOBILE
////     */
////    public void iosScroll(String direction) {
////        HashMap<String, String> scrollObject = new HashMap<>();
////        scrollObject.put("direction", direction);
////        driver.execute("mobile:scroll", scrollObject);
////    }
//
//    protected void iosScrollToElement(WebElement element, String direction) {
//        MobileElement elem = (MobileElement) element;
//        String elementID = elem.getId();
//        JavascriptExecutor js = (JavascriptExecutor)driver;
//        HashMap<String, String> scrollObject = new HashMap<>();
//        scrollObject.put("element", elementID);
//        scrollObject.put("toVisible", "not an empty string");
//        scrollObject.put("direction", direction);
//        scrollObject.put("simpleIsVisibleCheck", "true");
//        js.executeScript("mobile: scroll", scrollObject);
//        //driver.execute("mobile: scroll", scrollObject);
//    }
//
//    protected void androidScrollToElement(WebElement element, String direction) {
//        int count = 0;
//        boolean isDisplayed = false;
//
//        while (!isDisplayed && count++ < 10) {
//            try {
//                isDisplayed = element.isDisplayed();
//            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
//                touchScroll(direction);
//            }
//        }
//
//        //Assert.assertTrue(format("Element was not found after [%s] scrolls", count), isDisplayed);
//    }
//
//    private void androidScrollToElementWithText(
//            List<WebElement> elements, String text, String direction) {
//
//        int count = 0;
//        boolean isDisplayed = false;
//
//        while (!isDisplayed && count++ < 10) {
//            try {
//                isDisplayed = getElementWithText(elements, text).isDisplayed();
//            } catch (Exception e) {
//                touchScroll(direction);
//            }
//        }
//
//        //Assert.assertTrue(
//        //format("Element with text [%s] was not found after [%s] scrolls", text, count),
//        // isDisplayed);
//    }
//    public void ScrollToElement( WebElement element, String direction) {
//        int startX = element.getLocation().getX() + element.getSize().getWidth() / 2;
//        int startY = element.getLocation().getY() + element.getSize().getHeight() / 2;
//        int endX = startX;
//        int endY;
//        switch (direction) {
//            case "up":
//                endY = startY - 200; // Adjust the value as needed
//                break;
//            case "down":
//                endY = startY + 200; // Adjust the value as needed
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid direction");
//        }
//        TouchAction action = new TouchAction(driver);
//        action.press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))) // Adjust the wait duration
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();
//    }
//
//        private void touchScroll(String scrollDirection) {
//        Map<String, Integer> map;
//        Dimension dimension = driver.manage().window().getSize();
//
//        int centerX = dimension.width / 2;
//        int centerY = dimension.height / 2;
//        int topScreen = (int) (dimension.height * .30);
//        int bottomScreen = (int) (dimension.height * .90);
//        int rightScreen = (int) (dimension.width * .70);
//        int leftScreen = (int) (dimension.width * .10);
//
//        switch (scrollDirection) {
//            case "up":
//                map = setMoveToCOORD(centerX, topScreen, centerX, bottomScreen);
//                break;
//            case "down":
//                map = setMoveToCOORD(centerX, bottomScreen, centerX, topScreen);
//                break;
//            case "right":
//                map = setMoveToCOORD(rightScreen, centerY, leftScreen, centerY);
//                break;
//            case "left":
//                map = setMoveToCOORD(leftScreen, centerY, rightScreen, centerY);
//                break;
//            default:
//                throw new IllegalArgumentException(
//                        "Incorrect scroll direction given: Direction must be [up], [down], [left], or [right]");
//        }
//
//        new TouchAction(driver)
//                .longPress(longPressOptions().withPosition(point(map.get("fromX"), map.get("fromY"))))
//                .moveTo(point(map.get("toX"), map.get("toY")))
//                .release()
//                .perform();
//    }
//    private void touchReinventScroll(String scrollDirection) {
//        Map<String, Integer> map;
//        Dimension dimension = driver.manage().window().getSize();
//        // this is just a POC that centerX is not working properly when the drop down is to right with small width
//        int centerX =(int) (dimension.width * 0.8);
//        int centerY = dimension.height / 2;
//        int topScreen = (int) (dimension.height * .30);
//        int bottomScreen = (int) (dimension.height * .70);
//        int rightScreen = (int) (dimension.width * .90);
//        int leftScreen = (int) (dimension.width * .10);
//
//        switch (scrollDirection) {
//            case "up":
//                map = setMoveToCOORD(centerX, topScreen, centerX, bottomScreen);
//                break;
//            case "down":
//                map = setMoveToCOORD(centerX, bottomScreen, centerX, topScreen);
//                break;
//            case "right":
//                map = setMoveToCOORD(rightScreen, centerY, leftScreen, centerY);
//                break;
//            case "left":
//                map = setMoveToCOORD(leftScreen, centerY, rightScreen, centerY);
//                break;
//            default:
//                throw new IllegalArgumentException(
//                        "Incorrect scroll direction given: Direction must be [up], [down], [left], or [right]");
//        }
//
//        new TouchAction(driver)
//                .longPress(longPressOptions().withPosition(point(map.get("fromX"), map.get("fromY"))))
//                .moveTo(point(map.get("toX"), map.get("toY")))
//                .release()
//                .perform();
//    }
//
//    private Map<String, Integer> setMoveToCOORD(int fromX, int fromY, int toX, int toY) {
//        Map<String, Integer> coordinates = new HashMap<>();
//        coordinates.put("fromX", fromX);
//        coordinates.put("fromY", fromY);
//        coordinates.put("toX", toX);
//        coordinates.put("toY", toY);
//        return coordinates;
//    }
//
//    //scroll to element to start from 80% of the screen height to 20% of the screen height
//    public void scrollToElement(WebElement targetElement, int maxScrolls) {
//        int scrollAttempts = 0;
//        boolean elementFound = false;
//        Dimension size = driver.manage().window().getSize();
//
//        while (!elementFound && scrollAttempts < maxScrolls) {
//            try {
//                targetElement.isDisplayed();
//                if (targetElement.isDisplayed()) {
//                    elementFound = true;
//                }
//            } catch (Exception e) {
//                // Perform swipe gesture to scroll
//                int startY = (int) (size.height * 0.8);
//                int endY = (int) (size.height * 0.2);
//                int centerX = size.width / 2;
//
//                TouchAction action = new TouchAction(driver);
//                action.press(PointOption.point(centerX, startY))
//                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
//                        .moveTo(PointOption.point(centerX, endY))
//                        .release()
//                        .perform();
//
//                scrollAttempts++;
//            }
//        }
//    }
//
//    public void SwipeToElement(WebElement element, String direction) {
//        int startX = 0;
//        int pressY = 0;
//        int endX = 0;
//        TouchAction touchAction = new TouchAction(driver);
//        switch (direction) {
//            case "Right":
//                Dimension dimension = driver.manage().window().getSize();
//                int deviceWidth = dimension.getWidth();
//                endX=deviceWidth - element.getLocation().x;
//                startX = element.getLocation().x;
//                pressY = element.getLocation().getY();
//
//
//                touchAction.longPress(PointOption.point(startX, pressY))
//                        .moveTo(PointOption.point(endX, pressY)).release().perform();
//                break;
//            case "Left":
//                startX = element.getRect().width;
//                endX = element.getLocation().x;
//                pressY = element.getLocation().getY();
//                touchAction.longPress(PointOption.point(startX, pressY)).moveTo(PointOption.point(endX, pressY)).release().perform();
//                break;
//            case "Up":
//                startX = element.getRect().height;
//                endX = element.getLocation().x;;
//                pressY = element.getLocation().getY();
//                touchAction.longPress(PointOption.point(startX, pressY))
//                        .moveTo(PointOption.point(endX, pressY)).release().perform();
//                break;
//        }
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void verticalSwipeByPercentages (double startPercentage, double endPercentage, double anchorPercentage) {
//        Dimension size = driver.manage().window().getSize();
//        int anchor = (int) (size.width * anchorPercentage);
//        int startPoint = (int) (size.height * startPercentage);
//        int endPoint = (int) (size.height * endPercentage);
//        new TouchAction(driver)
//                .press(point(anchor, startPoint))
//                .waitAction(waitOptions(ofMillis(1000)))
//                .moveTo(point(anchor, endPoint))
//                .release().perform();
//    }
//    public static String html2text(String html) {
//        return Jsoup.parse(html).text();
//    }
//    public void scrollDownTo(WebElement element) {
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        if (platform.equalsIgnoreCase("ios")) {
//            iosScrollToElement(element,"down");
//            System.out.println("Scroll Down To element");
//            //
//            int height = driver.manage().window().getSize().height - 150;
//            int counter = 0;
//            while (element.getLocation().y > height && counter < 5) {
//                scroll(pressX, bottomY, pressX, setTop());
//                counter++;
//            }
//        } else if (platform.equalsIgnoreCase("android")) {
//            androidScrollToElement(element, "down");
//        }
//    }
//
//    public void scrollUpTo(WebElement element) {
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        if (platform.equalsIgnoreCase("ios")) {
//            iosScrollToElement(element, "up");
//
//        } else if (platform.equalsIgnoreCase("android")) {
//            androidScrollToElement(element, "up");
//        }
//    }
//
//    public boolean WaitElementAndHandleFullFailureError(WebElement element) {
//        boolean exist = false;
//        try {
//            waitForVisibility(element);
//            exist = true;
//        } catch (Exception e) {
//            System.out.println("Element Does not exits");
//        }
//        return exist;
//    }
//
//    public void SwipeBackForIOS() {
//        int startX = 0;
//        int pressY = (driver.manage().window().getSize().height) / 2;
//        int endX = driver.manage().window().getSize().width;
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.longPress(PointOption.point(startX, pressY)).moveTo(PointOption.point(endX, pressY)).release()
//                .perform();
//    }
//
//    public void TapElementIfDisplayed(WebElement webelement) {
//        WebDriverWait wait = new WebDriverWait(driver, 5);
//        try {
//            wait.until(ExpectedConditions.visibilityOf(webelement));
//            webelement.click();
//            System.out.println("Cookies is displayed and closed");
//        } catch (Exception e) {
//            System.out.println("Cookies not displayed");
//        }
//    }
//
//    public void waitWithCatch(WebElement webElement) {
//        WebDriverWait wait = new WebDriverWait(driver, 30);
//        try {
//            wait.until(ExpectedConditions.visibilityOf(webElement));
//        } catch (Exception e) {
//            System.out.println("Element not exist");
//        }
//    }
//
//    public void HideVOV(WebElement webelement) {
//        TapElementIfDisplayed(webelement);
//    }
//
//    public boolean CheckElementNotExistWithoutScroll(WebElement element) {
//        // This Method check the element is exist or not in the current screenshot "position" without scroll down
//        // Return True if the element not exits
//        // Return False if the element exits
//        boolean existElementFlag = false;
//        try {
//            element.isDisplayed();
//            existElementFlag = true;
//        } catch (Exception e) {
//            System.out.println("Scroll to the end of screen");
//        }
//        return !existElementFlag;
//    }
//
//    public void tapAtt(int fromX, int fromY) {
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(PointOption.point(fromX, fromY)).release().perform();
//    }
//
//    public void tapAttScreenBottom() {
//        TouchAction touchAction = new TouchAction(driver);
//        int X = driver.manage().window().getSize().width / 2;
//        int Y = driver.manage().window().getSize().height - 50;
//        touchAction.press(PointOption.point(X, Y)).release().perform();
//    }
//
//    public void tapAtScreenCenter() {
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        TouchAction touchAction = new TouchAction(driver);
//        int X = driver.manage().window().getSize().width / 2;
//        int Y = driver.manage().window().getSize().height / 2;
//        touchAction.press(PointOption.point(X, Y)).release().perform();
//    }
//
//    public boolean CheckElementNotExist(WebElement element) {
//        // This Method check the element is exist of not in all the screen "with scroll at the end of the screen"
//        // Return True if the element not exits
//        // Return False if the element exits
//        boolean existElementFlag = false;
//        int counter = 0;
//        while (!existElementFlag && counter < 4) {
//            try {
//                element.isDisplayed();
//                existElementFlag = true;
//            } catch (Exception e) {
//                System.out.println("Scroll to the end of screen");
//            }
//            if (!existElementFlag) {
//                scroll(pressX, bottomY, pressX, setTop());
//                counter++;
//            }
//        }
//        return !existElementFlag;
//    }
//
//    public void scroll(int fromX, int fromY, int toX, int toY) {
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
//    }
//
//    protected void scrollDownElementOverCenterScreen(WebElement element) {
//        int count = 0;
//        int elementYAxes = element.getLocation().getY();
//        int screenCenter = driver.manage().window().getSize().height / 2;
//        while (elementYAxes > screenCenter && count++ < 10) {
//            System.out.println(elementYAxes);
//            System.out.println(screenCenter);
//            scrollDown();
//            elementYAxes = element.getLocation().getY();
//
//        }
//    }
//
//    public void doubleClick(WebElement element){
//        element.click();
//        try {
//            element.click();
//        }catch (Exception e){
//            //doNothing
//        }
//    }
//
//    public int setTop() {
//        Properties androidProp = readPropertyFile("config/platform.properties");
//        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
//        if (platform.equalsIgnoreCase("Android"))
//            return driver.manage().window().getSize().height / 4;
//        else
//            return driver.manage().window().getSize().height / 2;
//    }
//
//    public void SwipeDownForIOS() {
//        int screenHeight = driver.manage().window().getSize().height;
//        scroll(pressX, 100, pressX, screenHeight);
//    }
//
//    public String hashMSISDIN(String msisdn) {
//
//        for (int i = 0; i < 8; i++) {
//            msisdn = msisdn.substring(0, i) + "X" + msisdn.substring((i + 1));
//        }
//        return msisdn;
//    }
//
//    public boolean IsElementDisplayed(WebElement element) {
//        boolean displayed = false;
//        try {
//            displayed = element.isDisplayed();
//        } catch (Exception e) {
//
//        }
//        return displayed;
//    }
//
//    public void CloseCookies(WebElement element) {
//        TapElementIfDisplayed(element);
//    }
//
//    public WebElement GetElement(String text){
//        WebElement element = driver.findElementByXPath(GetXpath(text));
//        return element;
//    }
//
//
//    public void openDeepLinkForiOS(String deepLink){
//        By safariURLBarSelector= By.xpath("//XCUIElementTypeTextField[@name='TabBarItemTitle']");
//        By safariURLTextSelector= By.xpath("//XCUIElementTypeTextField[@name='URL']");
//        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//        ((RemoteWebDriver) driver).findElement(safariURLBarSelector).click();
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(deepLink);
//        ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(Keys.ENTER);
//        ((RemoteWebDriver) driver).manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        ((RemoteWebDriver) driver).findElement(By.id("Open")).click();
//        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
//    }
//
//    public void terminateSafariForiOS(){
//        ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
//    }
//
//    public boolean checkLocatorePresence(By by){
//        try{
//            driver.findElement(by);
//            return true;
//        }
//        catch (NoSuchElementException e){
//            return false;
//        }
//    }
//
//    public void navigateBackForiOS(){
//        List<By> backLocators = new ArrayList<>();
//        By backLocator1= By.name("return to username screen button") ;
//        By backLocator2= By.name("Navigate back") ;
//        By backLocator3= By.name("backIcon");
//        By backLocator4= By.name("BackButton");
//        backLocators.add(backLocator1);
//        backLocators.add(backLocator2);
//        backLocators.add(backLocator3);
//        backLocators.add(backLocator4);
//
//        List<By> closeLocators = new ArrayList<>();
//        By closeLocator1= By.name("closeIcon") ;
//        By closeLocator2= By.name("VFGwebCloseButton");
//        By closeLocator3= By.name("Done");
//        closeLocators.add(closeLocator1);
//        closeLocators.add(closeLocator2);
//        closeLocators.add(closeLocator3);
//
//        driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
//        if(checkLocatorePresence(backLocator1) || checkLocatorePresence(backLocator2) || checkLocatorePresence(backLocator3) || checkLocatorePresence(backLocator4)) {
//            for (By backLocator : backLocators) {
//                if (checkLocatorePresence(backLocator)) {
//                    driver.findElement(backLocator).click();
//                    break;
//                }
//            }
//        }
//        else if (checkLocatorePresence(closeLocator1) || checkLocatorePresence(closeLocator2) || checkLocatorePresence(closeLocator3)) {
//            for (By closeLocator : closeLocators) {
//                if (checkLocatorePresence(closeLocator)) {
//                    driver.findElement(closeLocator).click();
//                    break;
//                }
//            }
//        }
//        else {
//            SwipeBackForIOS();
//        }
//
//    }
//    /**
//     * this method is used to swipe to specific text into carousel using carousel resource ID
//     * @param text
//     * @param resourceId
//     * @return webElement
//     */
//    public WebElement SwipeToText(String text , String resourceId){
//
//        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
//                "new UiScrollable(new UiSelector().resourceId(\"" + resourceId + "\"))." +
//                        "setAsHorizontalList().scrollIntoView("+ "new UiSelector().text(\""+text+"\"));"));
//        return element ;
//    }
//    public void navigateBackForAndroid(){
//        driver.navigate().back();
//    }
//
//    public boolean checkElementPresence(By by){
//        try{
//            waitForVisibility(driver.findElement(by));
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//    }
//    public void scrollDownAndroid(){
//        touchScroll("down");
//    }
//    public void swipeMobileElement(MobileElement element, String direction) {
//        int startX = element.getLocation().getX() + (element.getSize().getWidth() / 2);
//        int startY = element.getLocation().getY() + (element.getSize().getHeight() / 2);
//        int endX, endY;
//
//        // Calculate the end coordinates based on the specified direction
//        switch (direction.toLowerCase()) {
//            case "left":
//                endX = (int) (startX * 0.1);
//                endY = startY;
//                break;
//            case "right":
//                endX = (int) (startX * 1.9);
//                endY = startY;
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid direction specified. Use 'left' or 'right'.");
//        }
//
//        // Perform the swipe action
//        TouchAction action = new TouchAction((PerformsTouchActions) element.getWrappedDriver());
//        action.press(PointOption.point(startX, startY))
//                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))  // Optional: Add a small wait before moving to the end position
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();
//    }
//
//    public String removeHtmlTag(String input){
//        String htmlTagPattern = "<[^>]*>";
//        Pattern pattern = Pattern.compile(htmlTagPattern);
//        Matcher matcher = pattern.matcher(input);
//        return matcher.replaceAll("");
//    }
//
//    public WebElement findElementElementByDynamicLocatorAndIndex(String locator, int index){
//            return driver.findElement(By.xpath("(//*[@name='"+locator+"'])[" + (index + 1) + "]"));
//    }
//
//
//    public WebElement findElementBytext(String attribute ,String name){
//        return driver.findElement(By.xpath("(//*[@"+attribute+"='" + name + "'])"));
//    }
//    public void clickOnRetryButton() {
//         for (int i = 1; i < 5; i++) {
//             By error = By.id("com.myvodafoneapp:id/txtAlertMessageErrorCode");
//             By Retry = By.xpath(GetXpath("Retry"));
//             if (checkLocatorePresence(error)) {
////             waitForVisibilityForReinvent(error,30);
//                 waitForVisibilityForReinvent(Retry, 30);
//                 driver.findElement(Retry).click();
//                 System.out.println("clicked");
//                 try {
//                     Thread.sleep(5000);
//                 } catch (InterruptedException e) {
//                     throw new RuntimeException(e);
//                 }
//             }
//             if (!checkElementPresence(error)) {
//                System.out.println("Retry button isn't displayed");
//                break;
//           } else {
//               System.out.println(" try number" +i);
//            }
//        }
//    }
//}