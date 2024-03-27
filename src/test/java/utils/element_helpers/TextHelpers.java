package utils.element_helpers;

import core.Hooks;
import io.appium.java_client.AppiumDriver;
import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static utilities.PropertiesLoader.readPropertyFile;
import static utilities.Tools.toCamelCase;
import static utils.element_helpers.VerifyHelpers.findElementsFromLocators;

public class TextHelpers  {
    public static AppiumDriver driver ;
    static {driver = Hooks.getDriver();}
    public TextHelpers() {
    }

    public static String GetXpath(String currentLabel) {
        Properties androidProp = readPropertyFile("config/platform.properties");
        String platform = System.getProperty("PLATFORM", androidProp.getProperty("PLATFORM"));
        String tempXpath = "";
        if (platform.equalsIgnoreCase("Android"))
            tempXpath = "//*[@text=\"" + currentLabel + "\"]";
        else
            tempXpath = "//*[@label=\"" + currentLabel + "\"]";
        return tempXpath;
    }

    public static WebElement getElementByText(String ElementText) {
        WebElement element = driver.findElement(By.xpath(GetXpath(ElementText)));
        return element;
    }

    private static Object getField(String fieldName) {
        TextHelpers textHelpersObject = new TextHelpers();
        String target = toCamelCase(fieldName);
        Class aClass = null;

        try {
            aClass = textHelpersObject.getClass();
            Field field = aClass.getDeclaredField(target);
            field.setAccessible(true);
            return field.get(textHelpersObject);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException(
                    format("Element not found: [%s] in Class [%s]", target, aClass.getSimpleName()));
        }
    }

    public static WebElement getElement(String elementField) {
        return (WebElement) getField(elementField);
    }

    public static By getElementForBy(String elementField) {
        return (By) getField(elementField);
    }

    public static List<WebElement> getElements(String elementsField) {
        return (List<WebElement>) getField(elementsField);
    }
    public static List<By> getByElements(String elementsField) {
        return (List<By>) getField(elementsField);
    }

    public static List<WebElement> getElements(List<String> elementFields) {
        return elementFields.stream().map(TextHelpers::getElement).distinct().collect(Collectors.toList());
    }

    public static List<By> getByElements(List<String> elementFields) {
        return elementFields.stream()
                .map(TextHelpers::getElement)
                .map(element -> By.xpath(element.getAttribute("xpath"))) // Convert WebElement to By locator
                .distinct()
                .collect(Collectors.toList());
    }

    public static WebElement getElementWithText(List<WebElement> elements, String text) {
        return elements.stream()
                .filter(elem -> elem.getText().trim().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(
                        () ->
                                new NoSuchElementException(
                                        format("Element Target Text was not found: [%s]", text)));
    }

    public static By getElementWithText(ArrayList<By> locators, String text) {
        List<WebElement> elements = findElementsFromLocators(locators);
        return (By) elements.stream()
                .filter(elem -> elem.getText().trim().equalsIgnoreCase(text))
                .findFirst()
                .orElseThrow(
                        () ->
                                new NoSuchElementException(
                                        format("Element Target Text was not found: [%s]", text)));
    }

    public static WebElement getElementWithAttribute(
            List<WebElement> elements, String attribute, String attrValue) {
        return elements.stream()
                .filter(elem -> elem.getAttribute(attribute).trim().equalsIgnoreCase(attrValue))
                .findFirst()
                .orElseThrow(
                        () ->
                                new NoSuchElementException(
                                        format("Element Attribute was not found: [%s]", attrValue)));
    }

    /*public By getElementWithAttribute(
            List<By> locators, String attribute, String attrValue) {
        return locators.stream()
                .filter(elem -> elem.getAttribute(attribute).trim().equalsIgnoreCase(attrValue))
                .findFirst()
                .orElseThrow(
                        () ->
                                new NoSuchElementException(
                                        format("Element Attribute was not found: [%s]", attrValue)));
    }

     */

    public static List<WebElement> getElementsFromTextList(List<WebElement> elems, List<String> strings) {
        return strings.stream()
                .map(text -> getElementWithText(elems, text))
                .distinct()
                .collect(Collectors.toList());
    }

    public static List<By> getElementsFromTextList(ArrayList<By> locators, List<String> strings) {
        return strings.stream()
                .map(text -> getElementWithText(locators, text))
                .distinct()
                .collect(Collectors.toList());
    }


    public static String html2text(String html) {
        return Jsoup.parse(html).text();
    }
    public static String removeHtmlTag(String input){
        String htmlTagPattern = "<[^>]*>";
        Pattern pattern = Pattern.compile(htmlTagPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll("");
    }

}
