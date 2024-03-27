package pages.ClickToUpgrade.RecommendedPlans;

import models.response.UpgradePlansResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.UpgradePlansUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.GenericHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.ScrollHelpers.iosScrollToElement;


public class RecommendedPlansIOS extends RecommendedPlansAbstract {
    UpgradePlansResponseModel upgradePlansResponseModel;
    Properties envProp = readPropertyFile("config/env.properties");

    public RecommendedPlansIOS() {
        super();
        if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")) {
            upgradePlansResponseModel = UpgradePlansUtils.getUpgradePlans();
        }
    }

    public void verifyThatRecommendedPlansPageIsDisplayed() {
        waitForVisibility(recommendationReason);
        AssertDisplayed(recommendationReason.isDisplayed());
    }

    @Override
    public void verifyRecommendedPlanCardDetails() {
        waitForVisibility(recommendedPlanName);
        Assert.assertTrue(driver.findElement(By.xpath(GetXpath(upgradePlansResponseModel.recommendedPlans.get(0).planName))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(GetXpath(upgradePlansResponseModel.recommendedPlans.get(0).commitmentPeriod))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(GetXpath(upgradePlansResponseModel.recommendedPlans.get(0).priceHeader))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(GetXpath(upgradePlansResponseModel.recommendedPlans.get(0).allowances.get(0).header))).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath(GetXpath(upgradePlansResponseModel.recommendedPlans.get(0).allowances.get(0).value))).isDisplayed());

    }


    @Override
    public void chooseRecommendedPlan() {
        scrollDownTo(chooseThisPlanBtn);
        chooseThisPlanBtn.click();
    }

    @Override
    public void clickOnSeeAllPlansOnOurWebsite() {
        waitForVisibility(seeAllRecommendedPlansBtn);
        seeAllRecommendedPlansBtn.click();
    }

    @Override
    public void verifyThatTheUserIsAtAllPlansWebsite() {
        waitForVisibility(allPlansPageTitle);
        AssertDisplayed(allPlansPageTitle.isDisplayed());
    }

    @Override
    public void verifyThatTheChildUserGetsFullScreenError() {
        waitForVisibility(choosePlanChildAccountErrorTitle);
        AssertDisplayed(choosePlanChildAccountErrorTitle.isDisplayed());
    }

    @Override
    public void verifyThatFreeSubscriptionsDisplayed() {
        Assert.assertEquals(freeSubscriptionsTitle.getText(), upgradePlansResponseModel.recommendedPlans.get(0).subscriptions.text);
        AssertDisplayed(freeSubscriptionsIcons.isDisplayed());
    }

    @Override
    public void clickOnSeePlanDetailsButton() {
        waitForVisibility(seePlanDetails);
        seePlanDetails.click();
    }

    @Override
    public void verifyThatTheUserIsAtSeePlanDetailsWebview() {
        waitForVisibility(seePlanDetailsPageElement);
        AssertDisplayed(seePlanDetailsPageElement.isDisplayed());
    }

    @Override
    public void verifyThatTheRecommendedPlanHighlightsDisplayed() {
        waitForVisibility(recommendedPlanCardHighlights);
        AssertDisplayed(recommendedPlanCardHighlights.isDisplayed());
    }

    @Override
    public void verifyTheCurrentPlanCardDetails() {
        waitForVisibility(currentPlanHeader);
        currentPlanCardExtendButton.click();
        waitForVisibility(currentPlanName);
        Assert.assertEquals(currentPlanHeader.getText(), upgradePlansResponseModel.currentPlan.header);
        Assert.assertEquals(currentPlanName.getText(), upgradePlansResponseModel.currentPlan.planName);
        Assert.assertEquals(currentPlanPriceHeader.getText(), upgradePlansResponseModel.currentPlan.priceHeader);
        Assert.assertEquals(currentPlanPrice.getText(), upgradePlansResponseModel.currentPlan.price);
        Assert.assertEquals(currentPlanAllowanceHeader.getText(), upgradePlansResponseModel.currentPlan.allowances.get(0).header);
        Assert.assertEquals(currentPlanAllowanceValue.getText(), upgradePlansResponseModel.currentPlan.allowances.get(0).value);
        Assert.assertEquals(currentPlanExpiryText.getText(), upgradePlansResponseModel.currentPlan.expiryText);
        Assert.assertEquals(currentPlanExpiryHint.getText(), upgradePlansResponseModel.currentPlan.expiryHint);
    }

    @Override
    public void ValidateClickingOnCheckUpgradeEligibilityRedirectToSubsoverlay() {
        CheckUpgradeEligibilty.click();
        waitForVisibility(SO_PlanTab);
        AssertDisplayed(SO_PlanTab.isDisplayed());
    }

    @Override
    public void ValidateTheErrorScreenWhenUserIsnotEligible() //universal link
    {
        //navigateToURL("myvodafone://CLICK2UPGRADE_RECOMMENDED_PLANS");
        openDeepLinkForiOS("myvodafone://CLICK2UPGRADE_RECOMMENDED_PLANS");
        AssertDisplayed(RecommendedPlanErrorScreen.isDisplayed());

    }

    @Override
    public void ClickonBacktoDashboardCTA() {
        BacktoDashboardCTA.click();
    }

    @Override
    public void ClickonXcloseCTA() {
        Close.click();
    }

    @Override
    public void verifyThatShowMorePlansCTADisplayed() {
        scrollDownTo(showMorePlansBtn);
        waitForVisibility(showMorePlansBtn);
        AssertDisplayed(showMorePlansBtn.isDisplayed());
        Assert.assertEquals(showMorePlansBtn.getText(), upgradePlansResponseModel.morePlans.masterCta.text);
    }

    @Override
    public void clickOnShowMorePlansCTA() {
        scrollDownTo(showMorePlansBtn);
        waitForVisibility(showMorePlansBtn);
        showMorePlansBtn.click();
    }

    @Override
    public void verifyThatShowMorePlansCTADimmed() {
        Assert.assertFalse(showMorePlansBtn.isEnabled());
    }

    @Override
    public void verifyThatFiltersCTADisplayed() {
        waitForVisibility(filtersBtn);
        AssertDisplayed(filtersBtn.isDisplayed());
        //Assert.assertEquals(filtersBtn.getText(), upgradePlansResponseModel.morePlans.filterSection.cta.sectionOpenLabel);
    }

    @Override
    public void clickOnFiltersCTA() {
        waitForVisibility(filtersBtn);
        filtersBtn.click();
    }


    @Override
    public void ClickOnFilterCTA(String FilterCTA) {
        int NumberOfResultsAPI = 0, NumberOfResultsUI;
        //creating lists of strings for the plan card names
        List<String> PlanCardName = new ArrayList<>();
        for (int i = 0; i < upgradePlansResponseModel.morePlans.plans.size(); i++) {
            PlanCardName.add(upgradePlansResponseModel.morePlans.plans.get(i).planName);
            System.out.println(PlanCardName.get(i));
        }
        System.out.println("Total number of plans = " + PlanCardName.size());
        switch (FilterCTA) {
            case "24 Months" -> {
                FilterCTAClick(months24Card);
                NumberOfResultsUI = PlanFilterResult();
                for (int i = 0; i < PlanCardName.size(); i++) {
                    if ((upgradePlansResponseModel.morePlans.plans.get(i).filters.commitmentPeriod.equals("24"))) {
                        FilterScroll(PlanCardName.get(i), "24 Months", "planNameValue", NumberOfResultsAPI, false);
                        NumberOfResultsAPI++;
                    }
                }
                Assert.assertEquals(NumberOfResultsAPI, NumberOfResultsUI);
            }
            case "12 Months" -> {
                FilterCTAClick(months12Card);
                NumberOfResultsUI = PlanFilterResult();
                for (int i = 0; i < PlanCardName.size(); i++) {
                    if ((upgradePlansResponseModel.morePlans.plans.get(i).filters.commitmentPeriod.equals("12"))) {
                        FilterScroll(PlanCardName.get(i), "12 Months", "planNameValue", NumberOfResultsAPI, false);
                        NumberOfResultsAPI++;
                    }
                }
                Assert.assertEquals(NumberOfResultsAPI, NumberOfResultsUI);
            }
            case "All plans" -> {
                FilterCTAClick(allPlansCard);
                NumberOfResultsUI = PlanFilterResult();
                Assert.assertEquals(PlanCardName.size(), NumberOfResultsUI);
            }
            case "Unlimited" -> {
                FilterCTAClick(allPlansCard);
                FilterCTAClick(unlimitedCard);
                NumberOfResultsUI = PlanFilterResult();
                for (int i = 0; i < PlanCardName.size(); i++) {
                    if ((upgradePlansResponseModel.morePlans.plans.get(i).filters.isUnlimitedData)) {
                        FilterScroll(PlanCardName.get(i), "Unlimited", "dataValue", NumberOfResultsAPI, false);
                        NumberOfResultsAPI++;
                    }
                }
                Assert.assertEquals(NumberOfResultsAPI, NumberOfResultsUI);
            }
            case "5G Ready" -> {
                FilterCTAClick(allPlansCard);
                FilterCTAClick(G5ReadyCard);
                NumberOfResultsUI = PlanFilterResult();
                WebElement PlanIncludes;
                for (int i = 0; i < PlanCardName.size(); i++) {
                    if (upgradePlansResponseModel.morePlans.plans.get(i).filters.is5GReady) {
                        FilterScroll(PlanCardName.get(i), "5g", "included_Highlights_Entertainment", NumberOfResultsAPI, true);
                        NumberOfResultsAPI++;
                    }
                }
                Assert.assertEquals(NumberOfResultsAPI, NumberOfResultsUI);
            }
            case "Roaming" -> {
                FilterCTAClick(allPlansCard);
                FilterCTAClick(roamingCard);
                NumberOfResultsUI = PlanFilterResult();
                WebElement PlanIncludes;
                for (int i = 0; i < PlanCardName.size(); i++) {
                    if (upgradePlansResponseModel.morePlans.plans.get(i).filters.isRoamingIncluded) {
                        FilterScroll(PlanCardName.get(i), "roaming", "included_Highlights_Entertainment", NumberOfResultsAPI, true);
                        NumberOfResultsAPI++;
                    }
                }
                Assert.assertEquals(NumberOfResultsAPI, NumberOfResultsUI);
            }
            default -> {
            }
        }
    }

    @Override
    public void setMinPrice(String minPrice) {
        waitForVisibility(minPriceTxtBox);
        minPriceTxtBox.clear();
        minPriceTxtBox.sendKeys(minPrice);
        IOSDoneCTAKeyBoard.click();
    }

    @Override
    public void setMaxPrice(String maxPrice) {
        waitForVisibility(maxPriceTxtBox);
        maxPriceTxtBox.clear();
        maxPriceTxtBox.sendKeys(maxPrice);
        IOSDoneCTAKeyBoard.click();
    }

    @Override
    public void validatePriceFilterResult() {
        Float currentMinPrice = Float.parseFloat(minPriceTxtBox.getText());
        Float currentMaxPrice = Float.parseFloat(maxPriceTxtBox.getText());
        FilterCTAClick(allPlansCard);
        int numberOfResultsUI = PlanFilterResult();
        float planPrice = 0;
        int numberOfResultsAPI = 0;
        int monthlyDiscountedIndex = 1;
        Boolean flag = false;
        System.out.println("Number of results UI = " + numberOfResultsUI);
        List<String> PlanCardName = new ArrayList<>();
        for (int i = 0; i < upgradePlansResponseModel.morePlans.plans.size(); i++) {
            PlanCardName.add(upgradePlansResponseModel.morePlans.plans.get(i).planName);
        }
        System.out.println("Total number of plans = " + PlanCardName.size());
        for (int i = 0; i < PlanCardName.size(); i++) {
            planPrice = Float.parseFloat(upgradePlansResponseModel.morePlans.plans.get(i).filters.price);
            if (currentMinPrice <= planPrice && planPrice <= currentMaxPrice) {
                flag = filterPriceScroll(currentMinPrice, currentMaxPrice, i, numberOfResultsAPI + 1, monthlyDiscountedIndex);
                if (flag == true) {
                    monthlyDiscountedIndex++;
                }
                numberOfResultsAPI++;
            }
        }
        Assert.assertEquals(numberOfResultsAPI, numberOfResultsUI);
    }

    @Override
    public void verifyThatTheFilterCounterAndClearAllCTANotExist() {
        Assert.assertFalse(elementIsPresent(filtersCounter));
        Assert.assertFalse(elementIsPresent(clearAllBtn));
    }

    @Override
    public void changeFilters(String planLength, String minPrice, String maxPrice, String data, String features) {
        switch (planLength) {
            case "12 Months":
                FilterCTAClick(months12Card);
                break;
            case "24 Months":
                FilterCTAClick(months24Card);
                break;
            case "All plans":
                FilterCTAClick(allPlansCard);
                break;
        }
        setMinPrice(minPrice);
        setMaxPrice(maxPrice);
        FilterCTAClick(unlimitedCard);
        switch (features) {
            case "5G Ready":
                FilterCTAClick(G5ReadyCard);
                break;
            case "Roaming":
                FilterCTAClick(roamingCard);
                break;
        }
    }

    @Override
    public void verifyThatTheFilterCounterAndClearAllCTADisplayed() {
        if (!filtersCounter.isDisplayed()) {
            scrollUp();
        }
        waitForVisibility(filtersCounter);
        Assert.assertTrue(filtersCounter.isDisplayed());
        Assert.assertTrue(filtersCounter.getAttribute("value").equals("4"));
        waitForVisibility(clearAllBtn);
        Assert.assertTrue(clearAllBtn.isDisplayed());
    }

    @Override
    public void clickOnClearAllCTA() {
        waitForVisibility(clearAllBtn);
        clearAllBtn.click();
    }

    @Override
    public void verifyThatTheFilterCounterAndClearAllCTANotDisplayedAndTheFiltersBackToDefault() {
        verifyThatTheFilterCounterAndClearAllCTANotExist();
        Assert.assertTrue(months24Card.isSelected());
        assertEquals(minPriceTxtBox.getText(), upgradePlansResponseModel.morePlans.filterSection.subSections.get(1).startingValue);
        assertEquals(maxPriceTxtBox.getText(), upgradePlansResponseModel.morePlans.filterSection.subSections.get(1).endingValue);
        Assert.assertFalse(unlimitedCard.isSelected());
        Assert.assertFalse(G5ReadyCard.isSelected());
        Assert.assertFalse(roamingCard.isSelected());
    }

    @Override
    public void validateTheBlackBanner() {
        AssertDisplayed(simxBannerLabel.isDisplayed());
        AssertDisplayed(simxBannerICon.isDisplayed());
    }

    @Override
    public void validateSimxTray() {
        waitForVisibility(simxTitle);
        Assert.assertEquals("What is a SIMX plan?", simxTitle.getText());
        Assert.assertEquals("Our new, exclusive SIMX plans allow you to enjoy extended device benefits for a great monthly price:", simxDescription.getText());
        AssertDisplayed(simxBodyList.isDisplayed());
        AssertDisplayed(simxBodyTitle.isDisplayed());
        AssertDisplayed(SimxFindOutMoreCTA.isDisplayed());
        AssertDisplayed(SimxCloseCTA.isDisplayed());
    }

    @Override
    public void scrollToFindSimxPlan() {
        waitForVisibility(CardTitle);
        while (!(CardTitle.getText().contains("SIMX"))) {
            SwipeToElement(CardTitle, "left");

        }
    }


    public void iClickOnSeeAllSIMOPlansCTA() {
        scrollUp();
        waitForVisibility(see_all_SIMO_plans_CTA);
        see_all_SIMO_plans_CTA.click();
    }

    public WebElement findElementElementByDynamicLocatorAndIndex(String locator, int index) {
        WebElement element;
        try {
            element = driver.findElement(By.xpath("(//*[@name='" + locator + "'])[" + (index + 1) + "]"));

        } catch (Exception e) {
            element = driver.findElement(By.xpath("(//*[@name='" + locator + "'])"));
        }
        return element;
    }

    public int PlanFilterResult() {
        scrollDownElementOverCenterScreen(FilterPlansResult);
        if (!FilterPlansResult.isDisplayed()) {
            scrollUp();
        }
        waitForVisibility(FilterPlansResult);
        String input = FilterPlansResult.getText();
        String substring = input.substring(0, input.lastIndexOf(" of"));
        int NumberOfResultsUI = Integer.parseInt(substring);
        System.out.println("Number of plans matching your filter = " + NumberOfResultsUI);
        return NumberOfResultsUI;
    }

    public void FilterCTAClick(WebElement FilterCTA) {
        scrollDownElementOverCenterScreen(FilterCTA);
        waitForVisibility(FilterCTA);
        FilterCTA.click();
    }

    public void FilterScroll(String PlanCardName, String FilterAssertion, String Locator, int index, boolean OpenIncludes) {
        WebElement PlanFilterElement;
        PlanFilterElement = findElementElementByDynamicLocatorAndIndex(Locator, index);
        System.out.println("scroll down to " + PlanCardName);
        scrollDownElementOverCenterScreen(PlanFilterElement);
        if (!PlanFilterElement.isDisplayed())
            scrollUp();
        waitForVisibility(PlanFilterElement);
        if (OpenIncludes) {
            PlanFilterElement.click();
            Assert.assertTrue(driver.getPageSource().toLowerCase().contains(FilterAssertion));
            PlanFilterElement = findElementElementByDynamicLocatorAndIndex(Locator, index);
            PlanFilterElement.click();
        } else {
            AssertResult(PlanFilterElement.getText(), FilterAssertion);
        }
    }

    public Boolean filterPriceScroll(Float currentMinPrice, Float currentMaxPrice, int i, int index, int monthlyDiscountedIndex) {
        Boolean flag = false;
        WebElement priceFilterElement = findElementElementByDynamicLocatorAndIndex("monthlyHeader", index);
        scrollDownElementOverCenterScreen(priceFilterElement);
        if (!priceFilterElement.isDisplayed()) {
            scrollUp();
        }
        try {
            Assert.assertTrue(upgradePlansResponseModel.morePlans.plans.get(i).discountedPrice.contains("£"));
            WebElement monthlyDiscountedElement = findElementElementByDynamicLocatorAndIndex("monthlyDiscountedValue", monthlyDiscountedIndex);
            monthlyDiscountedElement.isDisplayed();
            String monthlyDiscountedValue = monthlyDiscountedElement.getText().substring(1);
            Float discountedPrice = Float.parseFloat(monthlyDiscountedValue);
            System.out.println("discountedPrice--=" + discountedPrice);
            Assert.assertTrue(currentMinPrice <= discountedPrice && discountedPrice <= currentMaxPrice);
            flag = true;
        } catch (Exception e) {
            WebElement monthlyPriceElement = findElementElementByDynamicLocatorAndIndex("monthlyValue", index);
            monthlyPriceElement.isDisplayed();
            String monthlyValue = monthlyPriceElement.getText().substring(1);
            Float monthlyPrice = Float.parseFloat(monthlyValue);
            System.out.println("monthlyPrice--=" + monthlyPrice);
            Assert.assertTrue(currentMinPrice <= monthlyPrice && monthlyPrice <= currentMaxPrice);
        }
        System.out.println(flag);
        return flag;
    }

    public void iClickOnDismissalXCTA() {
        waitForVisibility(SimxCloseCTA);
        SimxCloseCTA.click();
    }

    public void iClickOnFindOutMoreBanner() {
        waitForVisibility(simxBannerLabel);
        simxBannerLabel.click();
    }

    @Override
    public void ValidatePriceIncreaseCopy() {
        waitForVisibility(PriceCopyRecommended);
        waitForVisibility(PriceCopyMorePlans);
        Assert.assertEquals(PriceCopyRecommended.getText(), upgradePlansResponseModel.hint);
        Assert.assertEquals(PriceCopyMorePlans.getText(), upgradePlansResponseModel.hint);
    }

    @Override
    public void ClickOnRecommendedPlansCTA() {
        waitForVisibility(Recommended_plans_CTA);
        Recommended_plans_CTA.click();
    }

    @Override
    public void compareRoamingDetails() {

        boolean flag = true;
        WebElement card = CardTitle;
        while (flag)
            try {
                if (Roaming_Lozenge_Layout.isDisplayed()) {
                    System.out.println("inside");
                    // waitForVisibility(includes_Icon);
                    flag = false;
                    includes_Icon.click();
                    iosScrollToElement(showMorePlansBtn, "down");
                    String roaming_destination = Roaming_Lozenge_text.getText().split(" ")[0];
                    System.out.println(roaming_destination);
                    Assert.assertTrue(Roaming_text.getText().contains(roaming_destination));
                    System.out.println(Roaming_text.getText());
                }
            } catch (Exception e) {
                SwipeToElement(CardTitle, "left");
                System.out.println("left");
            }

    }
}


