package pages.SubsctionOverlay.NewPlanDesign;

import models.response.DiscoverV2ResponseModel;
import models.response.PlanV3ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import pages.SubsctionOverlay.DevicePlanTab.DevicePlanPo;
import pages.SubsctionOverlay.UsagesTab.UsagesPO;
import testdata.ReadResponse;
import utils.PlanUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;

public class NewPlanDesignIOS extends NewPlanDesignAbstract {

    private PlanV3ResponseModel planResponse;

    public NewPlanDesignIOS() {
        super();
        planResponse = PlanUtils.GetPlanV3();
    }

    public void ValidatePlanMainTitle() {
        String planTitleXpath = "";
        for (int i=0 ; i<planResponse.cards.size() ; i++){
            if(planResponse.cards.get(i).sections != null)
            {
                planTitleXpath = GetXpath((planResponse.cards.get(i).title));
                break;
            }
        }
        waitForVisibility(PlanTitle);
        assertPlanTitleText();
    }

    public void ClickOnMyAccount(){
        waitForVisibility(DB_MyAccountTray_icon);
        DB_MyAccountTray_icon.click();
    }

    public void assertPlanTitleText() {
        scrollDownTo(PlanTitle);
        AssertDisplayed(PlanTitle.isDisplayed());
    }

    public void ValidatePlanSectionTitles() {
        waitForVisibility(PlanTitle);
        assertPlanSectionTitlesText();
        scrollUp();
    }

    public void assertPlanSectionTitlesText() {
        List<PlanV3ResponseModel.Section> sectionTitles = null;
        for (int i=0 ; i<planResponse.cards.size() ; i++){
            if(planResponse.cards.get(i).sections != null)
            {
                sectionTitles = planResponse.cards.get(i).sections;
                for(int j=0 ; j<sectionTitles.size() ; j++){
                    String sectionTitle = sectionTitles.get(j).title.replace("<b>","").replace("</b>","");
                    try {
                        scrollDownTo(sectionTitle);
                        System.out.println(getElementByText(GetXpath(sectionTitle)).getText());
                        System.out.println(sectionTitle);
                        AssertResult(getElementByText(GetXpath(sectionTitle)).getText(), sectionTitle);
                    } catch (Exception e) {
                        System.out.println("Couldn't find " + sectionTitle + " element");
                    }
                }
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

    public void ValidateIncludesMoreThan5Items() {
        int size = IncludesItemsSize();
        if(size > 5) {
            scrollDownTo(Includes_seeMore);
            AssertDisplayed(Includes_seeMore.isDisplayed());
        }
        //throw new SkipException("Item not exist in the response");
    }

    public void ValidateIncludesLessThan5Items() {
        int size = IncludesItemsSize();
        if(size > 5) {
            throw new SkipException("Item not exist in the response");
        }
        else
        {
            boolean isExist = false;
            try {
                scrollDown();
                isExist = Includes_seeMore.isDisplayed();
            }
            catch (Exception e){
                System.out.println("The element is exist");
            }
            AssertDisplayed(!isExist);
        }
    }

    public int IncludesItemsSize() {
        boolean finish = false;
        int size = 0;
        for (int i=0 ; i<planResponse.cards.size() ; i++){
            if(planResponse.cards.get(i).sections != null)
            {
                for (int j=0 ; j<planResponse.cards.get(i).sections.size() ; j++) {
                    if(planResponse.cards.get(i).sections.get(j).title.contains("Includes")){
                        size = planResponse.cards.get(i).sections.get(j).list.size();
                        finish = true;
                    }
                }
                if(finish) break;
            }
        }
        return size;
    }

    public void ValidateUpgradeValue(){
        boolean finish = false;
        List<PlanV3ResponseModel.List> contracts = null;
        for (int i=0 ; i<planResponse.cards.size() ; i++){
            if(planResponse.cards.get(i).sections != null)
            {
                for (int j=0 ; j<planResponse.cards.get(i).sections.size() ; j++) {
                    if(planResponse.cards.get(i).sections.get(j).title.contains("Contract")){
                        contracts = planResponse.cards.get(i).sections.get(j).list;
                        finish = true;
                        break;
                    }
                }
                if(finish) break;
            }
        }
        for (int i=0 ; i<contracts.size() ; i++){
            if(contracts.get(i).leftAlignedText.equals("Upgrade from")) {
                scrollDownTo(contracts.get(i).rightAlignedText);
                AssertDisplayed(GetElement(contracts.get(i).rightAlignedText).isDisplayed());
            }
        }
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
        String Upgrade = "<b>Upgrade Phone and Plan</b>";
        String Fancy = "Fancy a new phone";
        if ((planResponse.cards.get(0).sections.get(0).title != null && planResponse.cards.get(0).sections.get(0).title.contains(Upgrade))) {
            for (int i = 0; i < planResponse.cards.get(1).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product)) {
                    // qc2           planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product);
                    //Includes_seeMore.click();
                    System.out.println("upgrade");
                    scrollDownTo(getElementByText(GetXpath(product)));
                    waitForVisibility(getElementByText(GetXpath(product)));
                    getElementByText(GetXpath(product)).click();
                }
        } else if (planResponse.cards.get(0).sections.get(0).title.contains(Fancy)) {
            for (int i = 0; i < planResponse.cards.get(1).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product)) {
                    // qc2           planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product);
                    //Includes_seeMore.click();
                    System.out.println("fancy");
                    AssertResult(getElementByText(GetXpath(product)).getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentHeader);
                }

        } else {
            for (int i = 0; i < planResponse.cards.get(0).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(0).sections.get(2).list.get(i).title.equals(product)) {
                    // qc2           planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product);
                    //     QC1      planResponse.cards.get(0).sections.get(1).list.get(i).title.equals(product));
                    AssertResult(getElementByText(GetXpath(product)).getText(), planResponse.cards.get(0).sections.get(2).list.get(i).subContent.subContentHeader);
                }
        }

    }

    public void assertUnlimitedPictureMessagesDescription(String Description) {
        waitForVisibility(getElementByText(GetXpath(Description)));
//        driver.findElementByXPath(GetXpath(Description)).click();
        AssertResult(getElementByText(GetXpath(Description)).getText(), "Send endless picture and video messages at no extra cost.");

    }

    public void IncludesCTA(String product) {
        String Upgrade = "<b>Upgrade Phone and Plan</b>";
        String Fancy = "Fancy a new phone";
        if (elementIsPresent(SO_PlanTabContract)){
            scrollDownTo(Includes_seeMore);
            Includes_seeMore.click();
            scrollUpTo(SO_PlanTabContract);
        }else {
            scrollDownTo(SO_PlanTabContract);
            System.out.println(SO_PlanTabContract.getText());
            scrollDownTo(Includes_seeMore);
            Includes_seeMore.click();
            scrollUpTo(SO_PlanTabContract);
        }
        if ((planResponse.cards.get(1).sections.get(0).title != null && planResponse.cards.get(1).sections.get(0).title.contains(Upgrade))) {
            for (int i = 0; i < planResponse.cards.get(2).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(2).sections.get(2).list.get(i).title.equals(product)) {
                    System.out.println("upgrade");
                    waitForVisibility(getElementByText(GetXpath(product)));
                    getElementByText(GetXpath(product)).click();
                    WebElement ProductName = getElementByText(GetXpath(product));
                    Assert.assertTrue(ProductName.isDisplayed());
                    System.out.println(planResponse.cards.get(2).sections.get(2).list.get(i).subContent.subContentHeader);
                    System.out.println(getElementByText(GetXpath(product)).getText());
                    AssertResult(getElementByText(GetXpath(product)).getText(), planResponse.cards.get(2).sections.get(2).list.get(i).subContent.subContentHeader);
                }
        } else if (planResponse.cards.get(1).sections.get(0).title.contains(Fancy)) {
            for (int i = 0; i < planResponse.cards.get(2).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(2).sections.get(2).list.get(i).title.equals(product)) {//Includes_seeMore.click();
                    System.out.println("fancy");
                    waitForVisibility(getElementByText(GetXpath(product)));
                    getElementByText(GetXpath(product)).click();
                    System.out.println(planResponse.cards.get(2).sections.get(2).list.get(i).subContent.subContentHeader);
                    AssertResult(getElementByText(GetXpath(product)).getText(), planResponse.cards.get(2).sections.get(2).list.get(i).subContent.subContentHeader);
                }
        } else {
            for (int i = 0; i < planResponse.cards.get(1).sections.get(2).list.size(); i++)
                if (planResponse.cards.get(1).sections.get(2).list.get(i).title.equals(product)) {
                    getElementByText(GetXpath(product)).click();
                    System.out.println(getElementByText(GetXpath(product)).getText());
                    AssertResult(getElementByText(GetXpath(product)).getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentHeader);
                }
        }
    }

    public void ValidateIncludesDisplayedDescription(String product) {
        for (int i = 0; i < planResponse.cards.get(1).sections.get(1).list.size(); i++)
            if (planResponse.cards.get(1).sections.get(1).list.get(i).title.equals(product)) {
                AssertResult(Includes_DetailedDescription.getText(), planResponse.cards.get(1).sections.get(1).list.get(i).subContent.subContentText);
            }
    }

    public void ValidateIncludesCTA(String product) {
        if (product.equalsIgnoreCase("Unlimited picture messages")) {
            AssertResult(Includes_DetailedCTA.getText(), "View my usage");
            Includes_DetailedCTA.click();
            waitForVisibility(SO_UsageTabRHExpiryOrRenewalDate);
            AssertDisplayed(SO_UsageTabRHExpiryOrRenewalDate.isDisplayed());
            //assertUsagesTabDisplayed();
        }
    }

    public void assertUsagesTabDisplayed() {
        UsagesPO usagesPO = new UsagesPO();
        waitForVisibility(usagesPO.SO_UsageTabContainer);
        AssertDisplayed(usagesPO.SO_UsageTabContainer.isDisplayed());
    }

    public void assertThat50OffCardDisplayed() {
        for (int i = 0; i < planResponse.cards.get(1).sections.get(1).list.size(); i++)
            if (planResponse.cards.get(1).sections.get(1).list.get(i).title.equals("50% off Smartwatch Connectivity")) {
                AssertResult(Includes_DetailedTitle.getText(), planResponse.cards.get(1).sections.get(1).list.get(i).subContent.subContentHeader);
                //AssertResult(Includes_DetailedDescription.getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentText);
                HardAssertNotDisplayed("Expiry Date",elementIsPresent(ExpiryOfProducts));
            }
    }

    @Override
    public void assertThatUnlimitedDataBoosterDisplayed() {
        for (int i = 0; i < planResponse.cards.get(1).sections.get(2).list.size(); i++)
            if (planResponse.cards.get(1).sections.get(2).list.get(i).title.equals("Unlimited Data Booster")) {
                AssertResult(Includes_DetailedTitle.getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentHeader);
                AssertResult(Includes_DetailedDescription.getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentText);
            }
    }

    public void assertThat51RoamFreeDestinationsDisplayed() {
        for (int i = 0; i < planResponse.cards.get(0).sections.get(2).list.size(); i++)
//            (int i = 0; i < planResponse.cards.get(1).sections.get(1).list.size(); i++)QC2
            if (planResponse.cards.get(0).sections.get(2).list.get(i).title.equals("Inclusive roaming in 51 European destinations")) {
                AssertResult(Includes_DetailedTitle.getText(), planResponse.cards.get(0).sections.get(2).list.get(i).subContent.subContentHeader);
                //AssertResult(Includes_DetailedDescription.getText(), planResponse.cards.get(1).sections.get(2).list.get(i).subContent.subContentText);
                HardAssertNotDisplayed("Expiry Date",elementIsPresent(ExpiryOfProducts));
            }
    }

    public void assertThat81RoamFreeDestinationsDisplayed() {
        scrollDownTo(Plan_81roamFreeDestinations);
        Plan_81roamFreeDestinations.isDisplayed();
        Assert.assertEquals(Plan_81roamFreeDestinations.getText(), "81 roam-free destinations");
    }
    public void checkVodafoneTogetherDiscount(){
        System.out.println(VodafoneTogetherDiscount.getText());
        Assert.assertTrue(VodafoneTogetherDiscount.getText().contains("Vodafone Together Discount"));
    }

    @Override
    public void PhoneBuyBackGuaranteeCTA() {
        waitForVisibility(PhoneBuyBackGuaranteeCTA);
        PhoneBuyBackGuaranteeCTA.click();
    }

    @Override
    public void PhoneBuyBackGuaranteeEligibilityScreen() {
        waitForVisibility(PhoneBuyBackGuaranteeTitle);
        Assert.assertTrue(PhoneBuyBackGuaranteeDescription.getText().contains("Come back from 1 September"));
    }

    @Override
    public void PhoneBBGEntryPointLabel() {
        waitForVisibility(PhoneBuyBackGuaranteeCTA);
        Assert.assertEquals(PhoneBBGEntryPointLabel.getText(),"Available soon");
    }

    @Override
    public void validateLifetimeWarrantyCTA() {
        if (elementIsPresent(LifetimeWarrantyCTA))
        {
            scrollDownTo(LifetimeWarrantyCTA);
        }
        else {
            SO_DevicePlan_Chevron.click();
            scrollDownTo(LifetimeWarrantyCTA);
        }
        Assert.assertEquals(LifetimeWarrantyCTA.getText(),"Lifetime Warranty");
    }

    @Override
    public void clickonLifetimeWarrantyCTA() {
        LifetimeWarrantyCTA.click();
    }

    @Override
    public void LifetimeWarrantyScreen() {
        waitForVisibility(LifetimeWarrantyTitle);
        Assert.assertTrue(LifetimeWarrantyDescription.getText().contains("Lifetime Service Promise"));
    }

    @Override
    public void FindOutMoreCTA() {
        FindOutMoreCTA.click();
    }

    @Override
    public void LifetimePromiseWebView() {
        waitForVisibility(LifeTimeServiceWarrantyWebview);
        AssertDisplayed(LifeTimeServiceWarrantyWebview.isDisplayed());
    }

    @Override
    public void TotalCareWarrantyCTA() {
        SO_DevicePlan_TotalCareWarrantyLink.click();
    }

    @Override
    public void TotalCareWarrantyScreen() {
        waitForVisibility(SO_DevicePlan_TotalCareWarrantyDescription);
        AssertDisplayed(SO_DevicePlan_TotalCareWarrantyDescription.isDisplayed());
    }

    @Override
    public void validatePBBGiPhone15EntryPoint() {
        if (elementIsPresent(PBBGiPhone15CTA))
        {
            scrollDownTo(PBBGiPhone15CTA);
        }
        else {
            SO_DevicePlan_Chevron.click();
            scrollDownTo(PBBGiPhone15CTA);
        }
        Assert.assertEquals(PBBGiPhone15Lozenge.getText(),"Available soon");
    }

    @Override
    public void PBBGiPhone15CTA() {
        PBBGiPhone15CTA.click();
    }

    @Override
    public void PBBGiPhone15EligibilityScreen() {
        Assert.assertEquals(PBBGiPhone15ScreenTitle.getText(),"Phone Buy-Back Price Guarantee");
        Assert.assertTrue(PBBGiPhone15ElibilityDescription.getText().contains("upgrade your Apple iPhone 15"));
    }
}