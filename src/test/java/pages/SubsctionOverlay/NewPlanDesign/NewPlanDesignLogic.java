package pages.SubsctionOverlay.NewPlanDesign;

import org.testng.Assert;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import pages.SubsctionOverlay.UsagesTab.UsagesPO;
import testdata.ReadResponse;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class NewPlanDesignLogic extends NewPlanDesignPO {

    static private SubscriptionOverlayLogic subscriptionOverlayLogic;

    public NewPlanDesignLogic() {
        super();
        subscriptionOverlayLogic = new SubscriptionOverlayLogic();
    }

    public void navigateToPlan() {
        HideVOV(DB_VOVhideCTA);
        subscriptionOverlayLogic.navigateToSubsOverLay();
    }

    public void ValidatePlanMainTitle() {
        String planTitleXpath = GetXpath(ReadResponse.GetNewPlanTitle());
        waitForVisibility(PlanTitle);
        assertPlanTitleText(planTitleXpath);
    }

    public void assertPlanTitleText(String planTitleXpath) {
        scrollDownTo(getElementByText(planTitleXpath));
        AssertResult(getElementByText(planTitleXpath).getText(), ReadResponse.GetNewPlanTitle());
    }

    public void ValidatePlanSectionTitles() {
        assertPlanSectionTitlesText();
        scrollUp();
    }

    public void assertPlanSectionTitlesText() {
        HashMap<String, String> sectionTitles = ReadResponse.GetNewPlanSectionTitles();
        for (String sectionTitle : sectionTitles.values()) {
            try {
                scrollDownTo(sectionTitle);
                System.out.println(getElementByText(GetXpath(sectionTitle)).getText());
                AssertResult(getElementByText(GetXpath(sectionTitle)).getText(), sectionTitle);
            } catch (Exception e) {
                System.out.println("Couldn't find " + sectionTitle + " element");
            }
        }
    }

    public void ValidateIncludesCTA() throws InterruptedException {
        scrollUp();
        Boolean includesExist = false;
        HashMap<String, String> includesChevrons = NewPlanIncludeChevronsResponse();
        HashMap<String, String> sectionTitles = ReadResponse.GetNewPlanSectionTitles();
        for (String name : sectionTitles.values()) {
            if (name.equalsIgnoreCase("Includes")) {
                includesExist = true;
                break;
            }
        }
        if (includesExist) {
            scrollDownTo("Includes");
            if (includesChevrons.size() > 5) {
                scrollDownTo(Includes_seeMore);
                Includes_seeMore.click();
            }
            assertIncludesDetailsText(includesChevrons);
        }
        scrollUpTo(PlanTitle);
    }

    public void assertIncludesDetailsText(HashMap<String, String> includesChevrons) throws InterruptedException {
        for (Map.Entry mapElement : includesChevrons.entrySet()) {
            if (!(((String) mapElement.getKey()).contains("has no chevron"))) {
                System.out.println((String) mapElement.getValue());
                scrollDownTo((String) mapElement.getValue());
                System.out.println("value is " + mapElement.getValue());
                try {
                    getElementByText(GetXpath((String) mapElement.getValue())).click();
                    System.out.println("Key is " + mapElement.getKey());
                    waitForVisibility(Includes_DetailedDescription);
                    if (mapElement.getValue().equals("Unlimited UK minutes"))
                        AssertDisplayed(Includes_DetailedDescription.isDisplayed());
                    else
                        AssertResult(Includes_DetailedDescription.getText(), (String) mapElement.getKey());
                } catch (Exception e) {
                    System.out.println(e);
                    System.out.println("Couldn't find " + mapElement.getValue() + " element");
                }
                IncludesBackIcon.click();
                Thread.sleep(1000);
                waitForVisibility(getElementByText(GetXpath((String) mapElement.getValue())));
            }
        }
    }

    public void ValidateIncludes() {
        scrollUp();
        Boolean includesExist = false;
        HashMap<String, String> includesChevrons = NewPlanIncludeChevronsResponse();
        HashMap<String, String> sectionTitles = ReadResponse.GetNewPlanSectionTitles();
        for (String name : sectionTitles.values()) {
            if (name.equalsIgnoreCase("Includes")) {
                includesExist = true;
                break;
            }
        }
        if (includesExist) {
            scrollDownTo("Includes");
            System.out.println(includesChevrons.size());
            if (includesChevrons.size() > 5) {
                scrollDownTo(Includes_seeMore);
                Includes_seeMore.click();
            }
            scrollUp();
            assertIncludesText(includesChevrons);
        }
        if (includesChevrons.size() > 5) {
            scrollDownTo(Includes_seeMore);
            Includes_seeMore.click();
        }
        scrollUp();
    }

    public void assertIncludesText(HashMap<String, String> includesChevrons) {
        for (String includesChevron : includesChevrons.values()) {
            try {
                scrollDownTo(includesChevron);
                System.out.println(getElementByText(GetXpath(includesChevron)).getText());
                AssertResult(getElementByText(GetXpath(includesChevron)).getText(), includesChevron);
            } catch (Exception e) {
                System.out.println("Couldn't find " + includesChevron + " element");
            }
        }
    }

    public void ValidateNewPlanDetailsAllowances() {
        scrollUp();
        assertPlanDetailsAllowancesText();
        scrollUp();
    }

    public void assertPlanDetailsAllowancesText() {
        HashMap<String, String> planAllowances = ReadResponse.GetNewPlanDetailsAllowances();
        for (Map.Entry mapElement : planAllowances.entrySet()) {
            scrollDownTo((String) mapElement.getValue());
            Boolean text = getElementByText(GetXpath((String) mapElement.getKey())).isDisplayed();
            Boolean value = getElementByText(GetXpath((String) mapElement.getValue())).isDisplayed();
            System.out.println("text is " + getElementByText(GetXpath((String) mapElement.getKey())).getText());
            System.out.println("value is " + getElementByText(GetXpath((String) mapElement.getValue())).getText());
            AssertDisplayed(text && value);
        }
    }

    public void ValidatePlanDetailsCTATextForBVB() {
        scrollUp();
        String planCTA = ReadResponse.GetNewPlanCTAForBVB();
        scrollDownTo(planCTA);
        AssertResult(getElementByText(GetXpath(planCTA)).getText(), "Change Plan");
        scrollUp();
    }

    public void ValidatePlanDetailsCTAForBVB() {
        scrollUp();
        planDetailsCTABVB();
        try {
            AssertResult(WV_Title.getText(), "Big Value Bundle");
        } catch (Exception e) {
            System.out.println("Assertion Failed");
        }
        WVXIconCTAPlan();
        scrollUp();
    }

    public void WVXIconCTAPlan() {
        WV_Xicon.click();
        waitForVisibility(PlanTitle);
    }

    public void planDetailsCTABVB() {
        String planCTA = ReadResponse.GetNewPlanCTAForBVB();
        scrollDownTo(planCTA);
        getElementByText(GetXpath(planCTA)).click();
        waitForVisibility(WV_Title);
    }

    public HashMap<String, String> NewPlanIncludeChevronsResponse() {
        return ReadResponse.GetNewPlanIncludesChevrons();
    }

    public Boolean getIncludesExist(Boolean includesExist) {
        HashMap<String, String> sectionTitles = ReadResponse.GetNewPlanSectionTitles();
        for (String name : sectionTitles.values()) {
            if (name.equalsIgnoreCase("Includes")) {
                includesExist = true;
            }
        }
        return includesExist;
    }

    public void checkIncludesElements(String product, Boolean includesExist, HashMap<String, String> includesChevrons) {
        if (includesExist) {
            scrollDownTo("Includes");
            if (includesChevrons.size() > 5) {
                scrollDownTo(Includes_seeMore);
                Includes_seeMore.click();
            }
            for (Map.Entry mapElement : includesChevrons.entrySet()) {
                try {
                    scrollDownTo((String) mapElement.getValue());
                    if (!(((String) mapElement.getKey()).contains("has no chevron")) && mapElement.getValue().equals(product)) {
                        AssertResult(getElementByText(GetXpath((String) mapElement.getKey())).getText(), (String) mapElement.getKey());
                    }
                } catch (Exception e) {
                    System.out.println("Couldn't find " + mapElement.getValue() + " element");
                }
            }
        }
    }

    public void assertUnlimitedPictureMessagesTitle(String product) {
        AssertResult(Includes_DetailedTitle.getText(), product);
    }

    public void IncludesCTA(String product) {
        getElementByText(GetXpath(product)).click();
        waitForVisibility(getElementByText(GetXpath(product)));
    }

    public void ValidateIncludesDisplayedDescription(String product) {
        if (product.equalsIgnoreCase("Unlimited picture messages"))
            AssertResult(Includes_DetailedDescription.getText(), "Manage your unlimited picture messages here");
    }

    public void ValidateIncludesCTA(String product) {
        if (product.equalsIgnoreCase("Unlimited picture messages")) {
            AssertResult(Includes_DetailedCTA.getText(), "View my usage");
            Includes_DetailedCTA.click();
            assertUsagesTabDisplayed();
        }
    }

    public void assertUsagesTabDisplayed() {
        UsagesPO usagesPO = new UsagesPO();
        waitForVisibility(usagesPO.SO_UsageTabContainer);
        AssertDisplayed(usagesPO.SO_UsageTabContainer.isDisplayed());
    }

    public void assertThat50OffCardDisplayed() {
        scrollDownTo(Plan_oneNumberBenefit);
        Plan_oneNumberBenefit.isDisplayed();
        Assert.assertEquals(Plan_oneNumberBenefit.getText(), "50% off Smartwatch Connectivity");
    }

    public void assertThat51RoamFreeDestinationsDisplayed() {

        scrollDownTo(Plan_51roamFreeDestinations);
        Plan_51roamFreeDestinations.isDisplayed();
        Assert.assertEquals(Plan_51roamFreeDestinations.getText(), "Inclusive roaming in 51 European destinations");
    }

    public void assertThat81RoamFreeDestinationsDisplayed() {
        scrollDownTo(Plan_81roamFreeDestinations);
        Plan_81roamFreeDestinations.isDisplayed();
        Assert.assertEquals(Plan_81roamFreeDestinations.getText(), "81 roam-free destinations");
    }
}