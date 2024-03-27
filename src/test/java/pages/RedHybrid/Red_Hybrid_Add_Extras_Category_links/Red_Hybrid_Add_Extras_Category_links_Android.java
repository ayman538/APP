package pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links;

import models.response.common.ListExtrasResponseModel;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ListExtrasUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.DriverHelps.getContextHandles;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.*;
import static utils.element_helpers.GenericHelpers.*;

public class Red_Hybrid_Add_Extras_Category_links_Android extends Red_Hybrid_Add_Extras_Category_links_Abstract{
    ArrayList<String> actualExtrasNames;
    ArrayList<WebElement> expectedExtraselements;
    ArrayList<String> expectedExtrasNames;
    String expectedTitle;
    String actualTitle;
    String expectedSubtitle;
    String typeOfExtra;
    ListExtrasResponseModel listExtrasResponseModel;
    public Red_Hybrid_Add_Extras_Category_links_Android(){super();}

    @Override
    public void chooseExtra(String extraType) {
        typeOfExtra = extraType;
        expectedExtraselements = expectedAvailableExtras(extrasList, "android.view.ViewGroup");
        //expectedExtraselements contains all the elements of extras
        expectedExtrasNames = expectedAvailableExtrasNames(extrasList, "android.widget.TextView");
        //expectedExtrasNames contains all extras names
        int i = 0;
        for (i = 0; i < expectedExtrasNames.size(); i++) {
            System.out.println(expectedExtrasNames.get(i));
            if (expectedExtrasNames.get(i).equalsIgnoreCase(typeOfExtra)) {
                System.out.println(typeOfExtra);
                expectedExtraselements.get(i).click();
            }else {
                System.out.println("User has no " + typeOfExtra + "Extra");
            }
        }
    }

    @Override
    public void extraOverlayAppears() {
        waitForVisibility(screenTitle);
        AssertDisplayed(ExtrasSubtitle.isDisplayed());
    }

    @Override
    public void extraOverlayUIComplyWithListExtraResponse() {
        Map<String, String> headers;
        headers = new HashMap<String, String>() {{

        }};
        Map<String, String> queryParameters;
        queryParameters = new HashMap<String, String>() {{
        }};
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers ,queryParameters);
        expectedTitle = screenTitle.getText();
        actualTitle = listExtrasResponseModel.title;
        Assert.assertEquals(actualTitle, expectedTitle);

        expectedSubtitle = ExtrasSubtitle.getText();
        actualExtrasNames = actualavailableExtras(listExtrasResponseModel);
        for (int i = 0; i < actualExtrasNames.size(); i++) {
            if (listExtrasResponseModel.categories.get(i).text == expectedSubtitle)
                Assert.assertEquals(listExtrasResponseModel.categories.get(i).text, expectedSubtitle);
        }

        WebElement firstElement = listOfDataOptions.findElements(By.className("android.view.ViewGroup"))
                .get(0).findElement(By.className("android.widget.RadioButton"));
        Assert.assertTrue(firstElement.isSelected());

        try {
            Assert.assertTrue(continueCTA.isDisplayed());
        }catch (Exception e){
            androidScrollToElement(continueCTA,"down");
        }

        String expectedCtaName = continueCTA.getText();
        String actualCtaName = listExtrasResponseModel.categories.get(0).addonCategoryInfo.action.get(0).text;
        Assert.assertEquals(actualCtaName, expectedCtaName);
    }

    @Override
    public void clickOnExtrasDescriptionLink() {

        if(typeOfExtra.equalsIgnoreCase("Premium Rate Credit Extra")){
            try {
                Assert.assertTrue(whatIsPremiumRateCredit.isDisplayed());
            }
            catch (Exception e){
                scrollDownTo(whatIsPremiumRateCredit);
            }
            whatIsPremiumRateCredit.click();
        }
        else {
            try {
                Assert.assertTrue(WhatDestinationsAreIncludedCTA.isDisplayed());
            }
            catch (Exception e){
                scrollDownTo(WhatDestinationsAreIncludedCTA);
            }
            WhatDestinationsAreIncludedCTA.click();
        }
    }

    @Override
    public void userInTheCorrectWebView(String webViewTitle, String url) {
        //check on Title
        String CurrentTitle=  AddExtrasWebViewTitle.getText();
        AssertResult(CurrentTitle,webViewTitle);
        //check on URL
        String CurrentURL = getContextHandles();
        AssertResult(CurrentURL,url);
        //check on X CTA
        AssertDisplayed(X_CTA.isDisplayed());
    }

    @Override
    public void AssertRenewPlanEarlyIsDisplayed() {
        waitForVisibility(RenewPlanEarlyCTA);

    }

    @Override
    public void ClickOnRenewEarlyCTA() {
        RenewPlanEarlyCTA.click();
    }

    public ArrayList<String> actualavailableExtras(ListExtrasResponseModel listExtrasResponse) {
        ArrayList<String> extrasNames = new ArrayList<>();
        int extrasNumber = listExtrasResponse.categories.size();
        for (int i = 0; i < extrasNumber; i++) {
            extrasNames.add(i, listExtrasResponse.categories.get(i).text);
        }
        return extrasNames;
    }

    public ArrayList<WebElement> expectedAvailableExtras(WebElement element, String ClassName) {
        //element "com.myvodafoneapp:id/extrasListView"
        //elements "android.view.ViewGroup"

        ArrayList<WebElement> extrasElements = new ArrayList<>();
        int size = element.findElements(By.className(ClassName)).size();
        for (int i = 0; i < size; i++) {
            extrasElements.add(i, element.findElements(By.className(ClassName)).get(i));
        }
        return extrasElements;

    }

    public ArrayList<String> expectedAvailableExtrasNames(WebElement element, String elements) {
        //element "com.myvodafoneapp:id/extrasListView"
        //elements "android.widget.TextView"

        ArrayList<String> extrasNames = new ArrayList<>();
        int size = element.findElements(By.className(elements)).size();
        for (int i = 0; i < size; i++) {
            extrasNames.add(i, element.findElements(By.className(elements)).get(i).getText());
        }
        return extrasNames;

    }

}
