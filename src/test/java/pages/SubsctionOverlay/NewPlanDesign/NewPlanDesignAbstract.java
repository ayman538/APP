package pages.SubsctionOverlay.NewPlanDesign;

import org.testng.Assert;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import pages.SubsctionOverlay.UsagesTab.UsagesPO;
import testdata.ReadResponse;

import java.util.HashMap;
import java.util.Map;

public abstract class NewPlanDesignAbstract extends NewPlanDesignPO {
    
    public NewPlanDesignAbstract() {
        super();
    }

    public abstract void ValidatePlanMainTitle();

    public abstract void ClickOnMyAccount();

    public abstract void assertPlanTitleText();

    public abstract void ValidatePlanSectionTitles();

    public abstract void assertPlanSectionTitlesText();

    public abstract void ValidateIncludesCTA() throws InterruptedException;

    public abstract void ValidateIncludesMoreThan5Items();

    public abstract void ValidateUpgradeValue();

    public abstract void ValidateIncludesLessThan5Items();

    public abstract void assertIncludesDetailsText(HashMap<String, String> includesChevrons) throws InterruptedException ;

    public abstract void ValidateIncludes();

    public abstract void assertIncludesText(HashMap<String, String> includesChevrons);

    public abstract void ValidateNewPlanDetailsAllowances();

    public abstract void assertPlanDetailsAllowancesText();

    public abstract void ValidatePlanDetailsCTATextForBVB();

    public abstract void ValidatePlanDetailsCTAForBVB();

    public abstract void WVXIconCTAPlan();

    public abstract void planDetailsCTABVB();

    public abstract HashMap<String, String> NewPlanIncludeChevronsResponse();

    public abstract Boolean getIncludesExist(Boolean includesExist);

    public abstract void checkIncludesElements(String product, Boolean includesExist, HashMap<String, String> includesChevrons);

    public abstract void assertUnlimitedPictureMessagesTitle(String product);

//    public abstract void assertUnlimitedPictureMessagesDescription(String Description);

    public abstract void IncludesCTA(String product);

    public abstract void ValidateIncludesDisplayedDescription(String product);

    public abstract void ValidateIncludesCTA(String product);

    public abstract void assertUsagesTabDisplayed();

    public abstract void assertThat50OffCardDisplayed();

    public abstract void assertThatUnlimitedDataBoosterDisplayed();

    public abstract void assertThat51RoamFreeDestinationsDisplayed();

    public abstract void assertThat81RoamFreeDestinationsDisplayed();
    public abstract void checkVodafoneTogetherDiscount();

    public abstract void PhoneBuyBackGuaranteeCTA();

    public abstract void PhoneBuyBackGuaranteeEligibilityScreen();

    public abstract void PhoneBBGEntryPointLabel();

    public abstract void validateLifetimeWarrantyCTA();

    public abstract void clickonLifetimeWarrantyCTA();

    public abstract void LifetimeWarrantyScreen();

    public abstract void FindOutMoreCTA();

    public abstract void LifetimePromiseWebView();

    public abstract void TotalCareWarrantyCTA();

    public abstract void TotalCareWarrantyScreen();

    public abstract void validatePBBGiPhone15EntryPoint();

    public abstract void PBBGiPhone15CTA();

    public abstract void PBBGiPhone15EligibilityScreen();
}