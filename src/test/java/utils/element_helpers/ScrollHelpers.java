package utils.element_helpers;

import com.google.common.collect.ImmutableList;
import core.Hooks;
import io.appium.java_client.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementWithText;

public class ScrollHelpers {
    public static AppiumDriver driver;
    private static int pressX;
    private static int bottomY;

    static {
        driver = Hooks.getDriver();
        pressX = driver.manage().window().getSize().width / 2;
        bottomY = driver.manage().window().getSize().height * 4 / 5;
    }

    public static WebElement GetElement(String text) {
        WebElement element = driver.findElement(By.xpath(GetXpath(text)));
        return element;
    }


    private static WebElement element(By by) {
        return driver.findElement(by);
    }

    private static List<WebElement> elements(By by) {
        return driver.findElements(by);
    }

    public static void scrollUp() {
        scroll(pressX, setTop(), pressX, bottomY);
    }

    public static void scrollDown() {
        scroll(pressX, bottomY, pressX, setTop());
    }

    public static void scrollDownTo(String ElementText) {
        int counter = 0;
        boolean elementNotFound = false;
        while (!elementNotFound && counter < 3) {
            try {
                driver.findElement(By.xpath(GetXpath(ElementText)));
                elementNotFound = true;
            } catch (Exception e) {
                scrollDown();
                counter++;
            }
        }
    }

    public static void iosScrollToElement(WebElement element, String direction) {
        int count = 0;
        boolean isDisplayed = false;
        boolean isWithinScreenView = false;
        int maxScrollAttempts = 10;

        while (!isDisplayed && count < maxScrollAttempts) {
            try {
                isDisplayed = element.isDisplayed();
                isWithinScreenView = isElementWithinScreenView(element);
                if (!isWithinScreenView) {
                    touchScroll(direction);
                }
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll(direction);
            }
            count++;
        }
    }


    private static boolean isElementWithinScreenView(WebElement element) {
        Dimension screenSize = driver.manage().window().getSize();
        Point elementLocation = element.getLocation();
        Dimension elementSize = element.getSize();

        int screenHeight = screenSize.getHeight();
        int elementTop = elementLocation.getY();
        int elementBottom = elementTop + elementSize.getHeight();

        return elementTop >= 0 && elementBottom <= screenHeight;
    }

    protected static void iosScrollToElement(By by, String direction) {
        int count = 0;
        boolean isDisplayed = false;
        boolean isWithinScreenView = false;
        int maxScrollAttempts = 10;

        while (!isDisplayed && count < maxScrollAttempts) {
            try {
                isDisplayed = driver.findElement(by).isDisplayed();
                isWithinScreenView = isElementWithinScreenView(driver.findElement(by));

                if (!isWithinScreenView) {
                    touchScroll(direction);
                }
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll(direction);
            }

            count++;
        }
    }

    public static void androidScrollToElement(WebElement element, String direction) {
        int count = 0;
        boolean isDisplayed = false;

        while (!isDisplayed && count++ < 10) {
            try {
                isDisplayed = element.isDisplayed();
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll(direction);
            }
        }
    }


    public static void androidScrollToElement(By by, String direction) {
        int count = 0;
        boolean isDisplayed = false;

        while (!isDisplayed && count++ < 10) {
            try {
                isDisplayed = driver.findElement(by).isDisplayed();
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll(direction);
            }
        }
    }

    private static void androidScrollToElementWithText(List<WebElement> elements, String text, String direction) {

        int count = 0;
        boolean isDisplayed = false;

        while (!isDisplayed && count++ < 10) {
            try {
                isDisplayed = getElementWithText(elements, text).isDisplayed();
            } catch (Exception e) {
                touchScroll(direction);
            }
        }
    }

    private static void touchScroll(String scrollDirection) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        Dimension dimension = driver.manage().window().getSize();
        System.out.println("size = " + dimension);
        Point midPoint = new Point((int) (dimension.width * 0.3), (int) (dimension.height * 0.3));
        int bottom = midPoint.y + (int) (midPoint.y * .9);
        int top = midPoint.y - (int) (midPoint.y * .3);
        int left = midPoint.x - (int) (midPoint.x * .1);
        int right = midPoint.x + (int) (midPoint.x * .3);

        switch (scrollDirection.toUpperCase()) {
            case "UP":
                swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
                break;
            case "DOWN":
                swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
                break;
            case "RIGHT":
                swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
                break;
            case "LEFT":
                swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
                break;
            default:
                throw new IllegalArgumentException(
                        "Incorrect scroll direction given: Direction must be [up], [down], [left], or [right]");
        }

    }

    public static void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }


    private static Map<String, Integer> setMoveToCOORD(int fromX, int fromY, int toX, int toY) {
        Map<String, Integer> coordinates = new HashMap<>();
        coordinates.put("fromX", fromX);
        coordinates.put("fromY", fromY);
        coordinates.put("toX", toX);
        coordinates.put("toY", toY);
        return coordinates;
    }

    public static void SwipeToElement(WebElement element, String direction) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        int startX = 0;
        int pressY = 0;
        int endX = 0;

        switch (direction.toUpperCase()) {
            case "RIGHT":
                startX = element.getLocation().x;
                endX = element.getRect().width;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
                break;
            case "LEFT":
                startX = element.getRect().width;
                endX = element.getLocation().x;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
                break;
            case "UP":
                startX = element.getRect().height;
                endX = element.getLocation().x;
                ;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);

                break;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void SwipeToElement(By by, String direction) {
        WebElement element = driver.findElement(by);
        Duration SCROLL_DUR = Duration.ofMillis(300);
        int startX = 0;
        int pressY = 0;
        int endX = 0;

        switch (direction.toUpperCase()) {
            case "RIGHT":
                startX = element.getLocation().x;
                endX = element.getRect().width;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
                break;
            case "LEFT":
                startX = element.getRect().width;
                endX = element.getLocation().x;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
                break;
            case "UP":
                startX = element.getRect().height;
                endX = element.getLocation().x;
                ;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);

                break;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void verticalSwipeByPercentages(double startPercentage, double endPercentage, double anchorPercentage) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        Dimension size = driver.manage().window().getSize();
        int anchor = (int) (size.width * anchorPercentage);
        int startPoint = (int) (size.height * startPercentage);
        int endPoint = (int) (size.height * endPercentage);
        swipe(new Point(startPoint, anchor), new Point(endPoint, anchor), SCROLL_DUR);
    }

    public static void scrollDownTo(WebElement element) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(element, "down");
            System.out.println("Scroll Down To element");

            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (element.getLocation().y > height && counter < 5) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(element, "down");
        }
    }

    public static void scrollDownTo(By by) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(by, "down");
            System.out.println("Scroll Down To element");
            //
            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (driver.findElement(by).getLocation().y > height && counter < 5) {
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(by, "down");
        }
    }

    public static void scrollUpTo(WebElement element) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(element, "up");

        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(element, "up");
        }
    }


    public static void scrollUpTo(By by) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(by, "up");
            System.out.println("Scroll Down To element");
            //
            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (driver.findElement(by).getLocation().y > height && counter < 5) {
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(by, "up");
        }
    }


    public static void SwipeBackForIOS() {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        int startX = 0;
        int pressY = (driver.manage().window().getSize().height) / 2;
        int endX = driver.manage().window().getSize().width;
        swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
    }

    public static void scrollDownElementOverCenterScreen(WebElement element) {
        int count = 0;
        boolean isDisplayed = false;
        boolean isWithinScreenView = false;
        int maxScrollAttempts = 10;

        while (!isDisplayed && count < maxScrollAttempts) {
            try {
                isDisplayed = element.isDisplayed();
                isWithinScreenView = isElementWithinScreenView(element);

                if (!isWithinScreenView) {
                    touchScroll("down");
                }
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll("down");
            }

            count++;
        }
    }

    public static void scrollDownElementOverCenterScreen(By by) {
        WebElement element = driver.findElement(by);
        int count = 0;
        boolean isDisplayed = false;
        boolean isWithinScreenView = false;
        int maxScrollAttempts = 10;

        while (!isDisplayed && count < maxScrollAttempts) {
            try {
                isDisplayed = element.isDisplayed();
                isWithinScreenView = isElementWithinScreenView(element);

                if (!isWithinScreenView) {
                    touchScroll("down");
                }
            } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                touchScroll("down");
            }

            count++;
        }
    }

    public static void SwipeDownForIOS() {
        int screenHeight = driver.manage().window().getSize().height;
        scroll(pressX, 100, pressX, screenHeight);
    }

    public static WebElement SwipeToText(String text, String resourceId) {

        WebElement element = driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"" + resourceId + "\"))." +
                        "setAsHorizontalList().scrollIntoView(" + "new UiSelector().text(\"" + text + "\"));"));
        return element;
    }

    public static void scrollDownAndroid() {
        touchScroll("down");
    }

    public static void swipeWebElement(WebElement element, String direction) {
        SwipeToElement(element, direction);
    }


    public static void scroll(int fromX, int fromY, int toX, int toY) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        swipe(new Point(fromX, fromY), new Point(toX, toY), SCROLL_DUR);
    }

    public static int setTop() {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("Android"))
            return driver.manage().window().getSize().height / 4;
        else
            return driver.manage().window().getSize().height / 2;
    }

    public static void scrollToElement(WebElement targetElement, int maxScrolls) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        int scrollAttempts = 0;
        boolean elementFound = false;
        Dimension size = driver.manage().window().getSize();

        while (!elementFound && scrollAttempts < maxScrolls) {
            try {
                if (targetElement.isDisplayed()) {
                    elementFound = true;
                }
            } catch (Exception e) {
                // Perform swipe gesture to scroll
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.2);
                int centerX = size.width / 2;


                swipe(new Point(centerX, startY), new Point(centerX, endY), SCROLL_DUR);

                scrollAttempts++;
            }

        }
    }

    public static void scrollToElement(By by, int maxScrolls) {
        Duration SCROLL_DUR = Duration.ofMillis(300);
        WebElement targetElement = driver.findElement(by);
        int scrollAttempts = 0;
        boolean elementFound = false;
        Dimension size = driver.manage().window().getSize();

        while (!elementFound && scrollAttempts < maxScrolls) {
            try {
                if (targetElement.isDisplayed()) {
                    elementFound = true;
                }
            } catch (Exception e) {
                // Perform swipe gesture to scroll
                int startY = (int) (size.height * 0.8);
                int endY = (int) (size.height * 0.2);
                int centerX = size.width / 2;

                swipe(new Point(centerX, startY), new Point(centerX, endY), SCROLL_DUR);

                scrollAttempts++;
            }
        }
    }

    public static void ScrollToElement(WebElement element, String direction) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(element, direction);
            System.out.println("Scroll Down To element");
            //
            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (element.getLocation().y > height && counter < 5) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(element, direction);
        }
    }


    public static void swipeUntilElementFound(WebElement element, String direction) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(element, direction);
            System.out.println("Scroll Down To element");
            //
            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (element.getLocation().y > height && counter < 5) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(element, direction);
        }
    }

    public static void swipeUntilElementFound(By by, String direction) {
        WebElement element = driver.findElement(by);
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        if (platform.equalsIgnoreCase("ios")) {
            iosScrollToElement(element, direction);
            System.out.println("Scroll Down To element");
            int height = driver.manage().window().getSize().height - 150;
            int counter = 0;
            while (element.getLocation().y > height && counter < 5) {
                scroll(pressX, bottomY, pressX, setTop());
                counter++;
            }
        } else if (platform.equalsIgnoreCase("android")) {
            androidScrollToElement(element, direction);
        }
    }

}
