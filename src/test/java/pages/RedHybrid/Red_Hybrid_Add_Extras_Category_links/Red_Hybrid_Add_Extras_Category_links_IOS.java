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

public class Red_Hybrid_Add_Extras_Category_links_IOS extends Red_Hybrid_Add_Extras_Category_links_Abstract{
    ArrayList<String> actualExtrasNames;
    String expectedTitle;
    String actualTitle;
    String expectedSubtitle;
    String typeOfExtra;
    ListExtrasResponseModel listExtrasResponseModel;
    public Red_Hybrid_Add_Extras_Category_links_IOS(){super();}

    @Override
    public void chooseExtra(String extraType) {

        typeOfExtra = extraType;
        switch (typeOfExtra) {
            case "Data Extra":
                dataExtra.click();
                break;
            case "Europe Roaming Extra":
                europeRoamingExtra.click();
                break;
            case "Around the World Roaming Extra":
                aroundTheWorldRoamingExtra.click();
                break;
            case "International Extra":
                internationalExtra.click();
                break;
            case "Premium Rate Credit Extra":
                premiumRateCreditExtra.click();
                break;
            case "Rest of the World Roaming Extra":
                restOftheWorldExtra.click();
                break;
            default:
                System.out.println("User has no " + typeOfExtra + "Extra");
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

        String expectedCtaName = continueCTA.getText();
        String actualCtaName = listExtrasResponseModel.categories.get(0).addonCategoryInfo.action.get(0).text;
        Assert.assertEquals(actualCtaName, expectedCtaName);
        WebElement firstElement = firstExtrabundle.findElement(By.xpath("(//*[@name='imgDrawerAddNewPlanSubIcon'][1])"));
        //Assert.assertTrue(firstElement.isSelected());
        Assert.assertTrue(firstElement.isEnabled());
        expectedSubtitle = ExtrasSubtitle.getText();
        actualExtrasNames = actualavailableExtras(listExtrasResponseModel);
        for (int i = 0; i < actualExtrasNames.size(); i++) {
            if (listExtrasResponseModel.categories.get(i).text == expectedSubtitle)
                Assert.assertEquals(listExtrasResponseModel.categories.get(i).text, expectedSubtitle);
        }
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
        switch (webViewTitle) {
            case "International Roaming":
                AssertDisplayed(RoamingExtraWebViewTitle.isDisplayed());
                break;
            case "International Extras":
                AssertDisplayed(internationalExtraWebViewTitle.isDisplayed());
                break;
            default:
                System.out.println("User has no " + webViewTitle + "Extra");
        }
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

}
