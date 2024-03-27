package pages.SubsctionOverlay.NewPlanDesign;

import models.response.PlanV3ResponseModel;
import org.testng.Assert;
import org.testng.SkipException;
import testdata.ReadResponse;
import utils.PlanUtils;

import java.util.LinkedHashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class UpgradeCardsLogicIOS extends UpgradeCardsLogicAbstract {

    @Override
    public void ValidateEligibleForUpgradeCard() throws InterruptedException {
        assertEligibleForUpgradeCardText();
        scrollUp();
    }

    @Override
    public void assertEligibleForUpgradeCardText() throws InterruptedException {
        PlanV3ResponseModel planResponse = PlanUtils.GetPlanV3();

        if (planResponse.cards.get(0).title.contains("eligible to upgrade")) {
            eligibleFlag = true;
            Thread.sleep(1000);
            waitForVisibility(getElementByText(GetXpath(planResponse.cards.get(0).text)));
            AssertDisplayed(getElementByText(GetXpath(planResponse.cards.get(0).text)).isDisplayed());
            AssertDisplayed(getElementByText(GetXpath(planResponse.cards.get(0).actions.get(0).text)).isDisplayed());
        }
        else {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateEligibleForUpgradeCardCTA() {
        assertEligibleForUpgradeCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    @Override
    public void assertEligibleForUpgradeCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Upgrade eligible")) {
                eligibleFlag = true;
                scrollDownTo((String) mapElement.getValue());
                getElementByText(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!eligibleFlag) {
            throw new SkipException("Item not exist in the response");
        }

    }

    @Override
    public void assertLoginXIconDisplayed() {
        waitForVisibility(Login_Xicon);
        AssertDisplayed(Login_Xicon.isDisplayed());
    }

    @Override
    public void ValidateNotEligibleForUpgradeCard() throws InterruptedException {
        assertNotEligibleForUpgradeCardText();
        scrollUp();
    }

    @Override
    public void assertNotEligibleForUpgradeCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Upgrade not eligible")) {
                notEligibleFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(getElementByText(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!notEligibleFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateFancyCard() throws InterruptedException {
        assertFancyCardText();
        scrollUp();
    }

    @Override
    public void assertFancyCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Fancy")) {
                fancyFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(getElementByText(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!fancyFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateFancyCardCTA() {
        assertFancyCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    @Override
    public void LoginXIconCTA() {
        waitForVisibility(DX_IDM_X_Button);
        DX_IDM_X_Button.click();
        waitForVisibility(SO_PlanTab);
    }

    @Override
    public void assertFancyCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Fancy")) {
                fancyFlag = true;
                scrollDownTo((String) mapElement.getValue());
                getElementByText(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!fancyFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateChangePlanCard() throws InterruptedException {
        assertChangePlanCardText();
        scrollUp();
    }

    @Override
    public void assertChangePlanCardText() throws InterruptedException {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            System.out.println((String) mapElement.getKey());
            if (((String) mapElement.getKey()).contains("Keep reaching")) {
                changePlanFlag = true;
                Thread.sleep(1000);
                scrollDownTo((String) mapElement.getValue());
                AssertResult(getElementByText(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
                break;
            }
        }
        if (!changePlanFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateChangePlanCardCTA() {
        assertChangePlanCardCTA();
        LoginXIconCTA();
        scrollUp();
    }

    @Override
    public void assertChangePlanCardCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("action of Keep reaching")) {
                changePlanFlag = true;
                scrollDownTo((String) mapElement.getValue());
                getElementByText(GetXpath((String) mapElement.getValue())).click();
                assertLoginXIconDisplayed();
                break;
            }
        }
        if (!changePlanFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void ValidateEligibleForUpgradeCardMBB() throws InterruptedException {
        assertEligibleForUpgradeCardText();
        scrollUp();
    }

    @Override
    public void ValidateEligibleForCallUsCardCTA() {
        assertEligibleForCallUsCTA();
        AssertDisplayed(NumberOfCallUS.isDisplayed());
        scrollUp();
    }

    @Override
    public void assertEligibleForCallUsCTA() {
        LinkedHashMap<String, String> upgradeCards = ReadResponse.GetUpgradeCards();
        for (Map.Entry mapElement : upgradeCards.entrySet()) {
            if (((String) mapElement.getKey()).contains("Ask an adviser to guide you through our available plans.")) {
                callUsFlag = true;
                scrollDownTo((String) mapElement.getValue());
                getElementByText(GetXpath((String) mapElement.getValue())).click();
                break;
            }
        }
        if (!callUsFlag) {
            throw new SkipException("Item not exist in the response");
        }
    }

    @Override
    public void clickOnUpgradeNowCTA() {
        try {
            waitForVisibility(UpgradeNowPlanCTA);
            UpgradeNowPlanCTA.click();
        }catch (Exception e){
            waitForVisibility(HandsetUpgradeCard_CTA);
            HandsetUpgradeCard_CTA.click();
        }
    }

    @Override
    public void clickOnCChoosePhonePlanCTA() {
        ChoosePhonePlanCTA.click();
    }

    @Override
    public void AssertUpgradePoPupIsDisplayed() {
        AssertDisplayed(YesPleaseTradeInUpgradePoPUP_CTA.isDisplayed());
    }

    @Override
    public void AssertRedirectToEshopAndUpgradeJourney() throws InterruptedException {
        waitForVisibilityForReinvent(closeInternalWebview,60);
        AssertDisplayed(closeInternalWebview.isDisplayed());
        closeInternalWebview.click();
    }

    @Override
    public void AssertPOPUI() {
        waitForVisibility(YesPleaseTradeInUpgradePoPUP_CTA);
        AssertSoftResult(TradeInUpgradePoPUP_title.getText(), "Got a device you'd like trade in?");
        AssertSoftResult(TradeInUpgradePoPUP_body.getText(), "Find out how much you can save on your upgrade with our Trade-in tool");
        AssertSoftDisplayed(YesPleaseTradeInUpgradePoPUP_CTA.isDisplayed());
        AssertSoftDisplayed(UpgradeOnlyCTA.isDisplayed());
        AssertSoftAll();
    }

    @Override
    public void ClosePopup() {
        XCloseCTA.click();
    }

    @Override
    public void AssertUserInPlanTab() {
        AssertResult(DataTXt.getText(), "Data");
    }

    @Override
    public void AssertRedirectToTradeInSDK() {
        waitForVisibility(tradeInTitle);
        AssertResult(tradeInTitle.getText(), "Get a trade-in quote");
    }

    @Override
    public void validateUpgradeCardHasSIMOAndHandsetUpgrades() {
        AssertResult(HandsetUpgradeCard_Title.getText(), "Upgrade Phone and Plan");
        Assert.assertTrue(HandsetUpgradeCard_Txt.getText().contains("Upgrade to a new Phone"));
        AssertResult(HandsetUpgradeCard_CTA.getText(), "Browse Phones");
        AssertResult(SIMOsetUpgradeCard_Title.getText(), "Upgrade your Plan");
        Assert.assertTrue(SIMOUpgradeCard_Txt.getText().contains("Keep your phone"));
        AssertResult(SIMOUpgradeCard_CTA.getText(), "Browse recommended plans");
    }
    public void clickOnBrowsePhone(){
        waitForVisibility(BrowsePhonesCTA);
        BrowsePhonesCTA.click();
    }

    @Override

    public void ValidateDiscountCardAppearance() {
        ScrollToElement(ViewFullOfferCTA, "up");
        AssertDisplayed(DiscountCardTitle.isDisplayed());
        AssertDisplayed(DiscountCardDeviceName.isDisplayed());
        AssertDisplayed(DiscountCardHeader.isDisplayed());
        AssertDisplayed(DiscountCardInstallmentAmount.isDisplayed());
        AssertDisplayed(DiscountCardUpfrontAmount.isDisplayed());
        AssertDisplayed(DiscountCardOldAmount.isDisplayed());
        AssertDisplayed(DiscountCardDescription.isDisplayed());
        AssertDisplayed(DiscountCardDeviceIcon.isDisplayed());
        AssertDisplayed(ViewFullOfferCTA.isDisplayed());
        ScrollToElement(SeeMoreDevicePlanCTA,"down");
        AssertDisplayed(SeeMoreDevicePlanCTA.isDisplayed());

    }

    @Override
    public void GoToViewFullOffersCTA() {
        ViewFullOfferCTA.click();
        waitForVisibilityForReinvent(closeInternalWebview, 60);
        AssertDisplayed(closeInternalWebview.isDisplayed());
        closeInternalWebview.click();
    }
    @Override
    public void GoToSeeMoreDevicePlanCTA() {
        waitForVisibility(SeeMoreDevicePlanCTA);
        SeeMoreDevicePlanCTA.click();
    }
    @Override
    public void validateASACopy(){
        waitForVisibility(ASACopy);
        Assert.assertEquals(ASACopy.getText(),"*Airtime monthly price increases each April by consumer price index rate of inflation published in January +3.9%");
    }
    public void validateAomRecommendationReason(){
        ScrollToElement(AomRecommendationReason,"up");
        PlanV3ResponseModel.Card planCardresponse = getBingoPlanResponse();
        PlanV3ResponseModel.Header AomReacommendationReason = planCardresponse.sections.get(0).recommendationCardCarousel.get(0).header;
        if(AomReacommendationReason.icon != null){
            Assert.assertTrue(AomRecommendationReason.isDisplayed());
            Assert.assertTrue(AoMRecommendationReasonIcon.isDisplayed());
            Assert.assertEquals(AoMRecommendationReasonTitle.getText(), "Great fit for you");
            Assert.assertEquals(AomReacommendationReason.description, AoMRecommendationReasonDescription.getText());
        }
    }
    @Override

    public void ValidateDiscountCardContent() {

        PlanV3ResponseModel.Card planCardResponse = getBingoPlanResponse();
        PlanV3ResponseModel.RecommendationCardCarousel recommendationCardCarouselResponse = planCardResponse.sections.get(0).recommendationCardCarousel.get(0);
        AssertResult(DiscountCardTitle.getText(), recommendationCardCarouselResponse.borderText);
        AssertResult(DiscountCardDeviceName.getText(), recommendationCardCarouselResponse.title);
        AssertResult(DiscountCardHeader.getText(), recommendationCardCarouselResponse.subTitle);

        try{
            if(recommendationCardCarouselResponse.featureAsset.localAsset != null){
                Assert.assertTrue(DiscountCard5GIcon.isDisplayed());
            }
        }
        catch (Exception e){
            System.out.println("Device Doesn't Support 5G");
        }

        Assert.assertTrue(DiscountCardInstallmentAmount.getText().contains(recommendationCardCarouselResponse.priceTextLeft.replace("<b>", "").replace("</b>", "")));
        Assert.assertTrue(DiscountCardUpfrontAmount.getText().contains(recommendationCardCarouselResponse.priceTextRight.replace("<b>", "").replace("</b>", "")));
        Assert.assertTrue(DiscountCardOldAmount.getText().contains(recommendationCardCarouselResponse.priceTextLeftSubText));
        AssertResult(DiscountCardDescription.getText(), recommendationCardCarouselResponse.description);

    }
   public void ValidateBrandsIconsCarousel() throws InterruptedException {
       PlanV3ResponseModel.Card planCardResponse = getBingoPlanResponse();
       PlanV3ResponseModel.BrandIconsCarousel brandIconsCarouselResponse = planCardResponse.sections.get(0).ctaCarousel;
       ScrollToElement(AppleIcon,"down");
       AssertResult(BrandIconTitle.getText(), "See more pay monthly phones");
       String [] brands = {"SHOP_APPLE_DEVICES","SHOP_SAMSUNG_DEVICES","SHOP_GOOGLE_DEVICES"};
       if(brandIconsCarouselResponse.ctas.get(0).journeyKey != null){
           Assert.assertTrue(brandIconsCarouselResponse.ctas.get(0).journeyKey.contains(brands[0]));
           AppleIcon.click();
           waitForVisibilityForReinvent(closeInternalWebview,60);
           AssertDisplayed(closeInternalWebview.isDisplayed());
           closeInternalWebview.click();
       }
       if(brandIconsCarouselResponse.ctas.get(1).journeyKey != null){
           Assert.assertTrue(brandIconsCarouselResponse.ctas.get(1).journeyKey.contains(brands[1]));
           SamsungIcon.click();
           waitForVisibilityForReinvent(closeInternalWebview,60);
           AssertDisplayed(closeInternalWebview.isDisplayed());
           closeInternalWebview.click();
       }
       if(brandIconsCarouselResponse.ctas.get(2).journeyKey != null){
           Assert.assertTrue(brandIconsCarouselResponse.ctas.get(2).journeyKey.contains(brands[2]));
           GoogleIcon.click();
           waitForVisibilityForReinvent(closeInternalWebview,60);
           AssertDisplayed(closeInternalWebview.isDisplayed());
           closeInternalWebview.click();
       }
    }


    @Override
    public void validateUpgradeTypes() {
        PlanV3ResponseModel planResponse = PlanUtils.GetPlanV3();
        PlanV3ResponseModel.Card planCardResponse = getBingoPlanResponse();
        waitForVisibilityForReinvent(PlanCardTitle,90);
        System.out.println("PlanCardTitle api " + planCardResponse.sections.get(0).title);
        System.out.println(PlanCardTitle.getText());
        System.out.println(planCardResponse.sections.get(0).title);
        Assert.assertTrue(PlanCardTitle.getText().contains(planCardResponse.sections.get(0).title.replace("<b>", "").replace("</b>", "")));
        try {
            ScrollToElement(UpgradeTitle, "down");
            UpgradeTitle.isDisplayed();
            System.out.println(planCardResponse.sections.get(1).title);
            System.out.println(UpgradeTitle.getText());
            Assert.assertTrue(UpgradeTitle.getText().contains((planResponse.cards.get(0).sections.get(1).title.replace("<b>", "").replace("</b>", ""))));
            Assert.assertTrue(UpgradeSubTitle.getText().contains(planResponse.cards.get(0).sections.get(1).text.get(0)));

        } catch (Exception e) {
            ScrollToElement(DiscountSubTitle, "up");
            AssertResult(DiscountSubTitle.getText(), planResponse.cards.get(0).sections.get(0).text.get(0));
        }

    }
    public PlanV3ResponseModel.Card getBingoPlanResponse(){
        PlanV3ResponseModel planResponse = PlanUtils.GetPlanV3();
        PlanV3ResponseModel.Card planResponseBingo = new PlanV3ResponseModel.Card();
        try{
            if(planResponse.cards.get(0).actions.get(0).text != null){
                planResponseBingo = planResponse.cards.get(1);
            }
        }
        catch(Exception e){
            planResponseBingo = planResponse.cards.get(0);
        }
        return planResponseBingo;
    }

}
