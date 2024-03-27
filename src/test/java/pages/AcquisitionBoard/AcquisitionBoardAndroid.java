package pages.AcquisitionBoard;

import models.response.BasicDashboardResponseModel;
import models.response.BasicDashboardResponseModelNew;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BasicDashboardUtils;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.GenericHelpers.*;



import static core.Config.getPlatformType;

public class AcquisitionBoardAndroid extends AcquisitionBoardAbstract {

    BasicDashboardResponseModel basicDashboardUtils;
    BasicDashboardResponseModelNew newBasicDashboard = BasicDashboardUtils.getBasicDashboardNew();


    public AcquisitionBoardAndroid() {
        super();
    }

    public void checkAcquisitionHeader() {
        assertAcqNewDBHeaderTitleText();
        assertAcqNewDBHeaderBodyText();
    }

    public void assertAcqNewDBHeaderBodyText() {
        AssertResult(Acquisition_NewDB_Header_Body.getText(), "Check out our latest deals on phones, SIM only, tablets, broadband, and more.");
    }

    public void assertAcqNewDBHeaderTitleText() {
        AssertResult(Acquisition_NewDB_Header_Title.getText(), "Latest Offers");
    }

    public void checkAcquisitionTiles() {
        assertAcqNewDBPAYMTitleText();
        assertAcqNewDBSIMOnlyTitleText();
        assertAcqNewDBHBBTitleText();
        assertAcqNewDBTradeInTitleTextiOS();
    }

    public void assertAcqNewDBTradeInTitleTextiOS() {
        if (getPlatformType().equalsIgnoreCase("IOS")) {
            AssertResult(Acquisition_NewDB_TradeIn_Title.getText(), "Trade-in Tool");
        }
    }

    public void assertAcqNewDBHBBTitleText() {
        AssertResult(Acquisition_NewDB_HBBicon_Title.getText(), "Broadband");
    }

    public void assertAcqNewDBSIMOnlyTitleText() {
        AssertResult(Acquisition_NewDB_SIMonly_Title.getText(), "SIM only deals");
    }

    public void assertAcqNewDBPAYMTitleText() {
        AssertResult(Acquisition_NewDB_PAYM_Title.getText(), "Pay monthly phones");
    }

    public void checkMoreToLoveSections() {
        basicDashboardUtils = BasicDashboardUtils.getBasicDashboard();
        scrollDownToMoreToLoveTitle();
        assertAcqNewDBTitleText();
        assertAcqNewDBMoreToLoveFirstOffer();
        swipeAcqMoreToLoveBodyLeft();
        assertAcqNewDBMoreToLoveSecondOffer();
        assertAcqNewDBMoreToLoveCTAText();
        swipeAcqMoreToLoveBodyLeftThirdOffer();
        assertAcqNewDBMoreToLoveThirdOffer();
        assertAcqNewDBMoreToLoveCTAText();
    }

    public void assertAcqNewDBMoreToLoveThirdOffer() {
        waitForVisibilityForReinvent(ThirdOffer,60);
        AssertResult(ThirdOffer.getText(), "Find out how our Network is performing where you are");
        waitForVisibilityForReinvent(Acquisition_NewDB_MoreToLove_CTA_ThirdOffer,60);
        Acquisition_NewDB_MoreToLove_CTA_ThirdOffer.click();
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        waitForVisibility(Network_Alert);
        Assert.assertTrue(driver.getPageSource().contains("Mobile network alerts"));
        Exit_WebView.click();
    }

    public void swipeAcqMoreToLoveBodyLeft() {
        SwipeToElement(Acquisition_NewDB_MoreToLove_Body, "Left");
    }
    public void swipeAcqMoreToLoveBodyLeftThirdOffer() {
        SwipeToElement(Acquisition_NewDB_MoreToLove_CTA_ThirdOffer, "Left");
    }

    public void assertAcqNewDBMoreToLoveCTAText() {
        AssertResult(Acquisition_NewDB_MoreToLove_CTA.getText(), "Find out more");
    }

    public void assertAcqNewDBMoreToLoveSecondOffer() {
        System.out.println(SecondOffer.getText());
        waitForVisibilityForReinvent(SecondOffer,60);
        AssertResult(SecondOffer.getText(), "Order a free SIM today and add a Pay as you go Bundle later");
        waitForVisibilityForReinvent(Acquisition_NewDB_MoreToLove_CTA_SecondOffer,60);
        Acquisition_NewDB_MoreToLove_CTA_SecondOffer.click();
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        waitForVisibility(Order_free_sim);
        Assert.assertTrue(driver.getPageSource().contains("Order a free SIM"));
        Exit_WebView.click();
    }

    public void assertAcqNewDBTitleText() {
        waitForVisibilityForReinvent(Acquisition_NewDB_Moretolove_Title,100);
        AssertResult(Acquisition_NewDB_Moretolove_Title.getText(), "More to love");
    }

    public void scrollDownToMoreToLoveTitle() {
        scrollDownTo(Acquisition_NewDB_MoreToLove_CTA);
    }

    public void assertAcqNewDBMoreToLoveFirstOffer() {
        AssertResult(Acquisition_NewDB_MoreToLove_Body.getText(), "Discover all our best offers and promotions in one place");
        AssertResult(Acquisition_NewDB_MoreToLove_CTA.getText(), "Find out more");
        Acquisition_NewDB_MoreToLove_CTA.click();
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        waitForVisibility(Deals_Offers);
        Assert.assertTrue(driver.getPageSource().contains("Vodafone deals and offers"));
        driver.navigate().back();
    }

    public void checkVeryMeSections() {
        assertAcqNewDBVeryMeTitleText();
        assertAcqNewDBVeryMeImageDisplayed();
        assertAcqNewDBVeryMeBodyText();
    }

    public void assertAcqNewDBVeryMeBodyText() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Body);
        AssertResult(Acquisition_NewDB_VeryMe_Body.getText(), "From savings on cinema tickets to your morning coffee on us - there's bound to be something you love with VeryMe Rewards on the My Vodafone app.");
    }

    public void assertAcqNewDBVeryMeImageDisplayed() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Image);
        AssertDisplayed(Acquisition_NewDB_VeryMe_Image.isDisplayed());
    }

    public void assertAcqNewDBVeryMeTitleText() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Title);
        AssertResult(Acquisition_NewDB_VeryMe_Title.getText(), "VeryMeRewards");
    }

    @Override
    public void validateWhyVodafoneHeader() {
        scrollDownTo(WhyVodafone_Title);
        AssertDisplayed(WhyVodafone_Title.isDisplayed());
        AssertResult(WhyVodafone_Title.getText(), "Why Vodafone");
    }

    public void checkFooterSection() {
        scrollDownTo(Acquisition_NewDB_UK_Body);
        assertAcqNewDBOnlineAssistTitleDisplayed();
        assertAcqNewDBOnlineAssistBodyDisplayed();

        assertAcqNewDBFreeHomeDeliveryTitleDisplayed();
        assertAcqNewDBFreeHomeDeliveryBodyDisplayed();

        assertAcqNewDB14DayReturnTitleDisplayed();
        assertAcqNewDB14DayReturnBodyDisplayed();

        assertAcqNewDBUKTitleDisplayed();
        assertAcqNewDBUKBodyDisplayed();

    }

    public void assertAcqNewDBUKTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_UK);
        AssertDisplayed(Acquisition_NewDB_UK.isDisplayed());
        AssertResult(Acquisition_NewDB_UK.getText(), "UK’s reliable award winning network");
    }

    public void assertAcqNewDBUKBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_UK_Body);
        AssertDisplayed(Acquisition_NewDB_UK_Body.isDisplayed());
        waitForVisibilityForReinvent(Acquisition_NewDB_UK_Body,100);
        Acquisition_NewDB_UK_Body.click();
        Assert.assertTrue(driver.getPageSource().contains("network"));
        driver.navigate().back();
    }

    public void assertAcqNewDB14DayReturnBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_14DayReturns_Body);
        AssertDisplayed(Acquisition_NewDB_14DayReturns_Body.isDisplayed());
        Acquisition_NewDB_14DayReturns_Body.click();
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        waitForVisibility(Acquisition_NewDB_14DayReturns_WebView);
        Assert.assertTrue(driver.getPageSource().contains("returns"));
        driver.navigate().back();
    }

    public void assertAcqNewDB14DayReturnTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_14DayReturns_Title);
        AssertDisplayed(Acquisition_NewDB_14DayReturns_Title.isDisplayed());
        AssertResult(Acquisition_NewDB_14DayReturns_Title.getText(), "14 day returns");
    }

    public void assertAcqNewDBFreeHomeDeliveryBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_FreeHomeDelivery_Body);
        AssertDisplayed(Acquisition_NewDB_FreeHomeDelivery_Body.isDisplayed());
        Acquisition_NewDB_FreeHomeDelivery_Body.click();
        waitForVisibility(FreeHomeDelivery_WebView);
        Assert.assertTrue(driver.getPageSource().contains("orders/delivery"));
        driver.navigate().back();
    }

    public void assertAcqNewDBFreeHomeDeliveryTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_FreeHomeDelivery_Title);
        AssertDisplayed(Acquisition_NewDB_FreeHomeDelivery_Title.isDisplayed());
        AssertResult(Acquisition_NewDB_FreeHomeDelivery_Title.getText(), "Free home delivery");
    }

    public void assertAcqNewDBOnlineAssistBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_OnlineAssistance_Body);
        AssertDisplayed(Acquisition_NewDB_OnlineAssistance_Body.isDisplayed());
        Acquisition_NewDB_OnlineAssistance_Body.click();
        if (elementIsPresent(AcceptCookies)) {
            AcceptCookies.click();
        } else {
            System.out.println("Cookies are not displayed");
        }
        Assert.assertTrue(driver.getPageSource().contains("contact-us"));
        driver.navigate().back();
    }

    public void assertAcqNewDBOnlineAssistTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_OnlineAssistance_Title);
        AssertDisplayed(Acquisition_NewDB_OnlineAssistance_Title.isDisplayed());
        AssertResult(Acquisition_NewDB_OnlineAssistance_Title.getText(), "Online assistance");
    }

    public void checkPressingXBtn() {
        assertAcqCTAText();
    }

    public void assertAcqCTAText() {
        waitForVisibility(Acquisition_CTA);
        AssertResult(Acquisition_CTA.getText(), "See offers");
    }

    public void acqXIconCTA() {
        scrollUpTo(Acquisition_NewDB_Xicon);
        waitForVisibility(Acquisition_NewDB_Xicon);

        Acquisition_NewDB_Xicon.click();
    }

    public void checkPressingBackBtn() {
        assertAcqCTATextAfterNavBack();
    }

    public void assertAcqCTATextAfterNavBack() {
        scrollUpTo(Acquisition_NewDB_Xicon);
        waitForVisibility(Acquisition_NewDB_Xicon);

        driver.navigate().back();
        waitForVisibility(Acquisition_Link);
        AssertResult(Acquisition_CTA.getText(), "See offers");
    }


    public void navigateToAcquisitionBoard() {
        startActivity();
    }

    @Override
    public void ClickOnAcqBackgroundImage() {
            waitForVisibility(Acquisition_Background_Image);
            Acquisition_Background_Image.click();
    }
    @Override
    public void ClickOnAcqBackgroundCTA() {
        waitForVisibility(Acquisition_Background_CTA);
        Acquisition_Background_CTA.click();
    }

    @Override
    public void CheckDiscoverHeader() {
        waitForVisibility(Acquisition_Background_CTA);
        //AssertResult(basicDashboardUtils.tiles.title,Acquisition_Discover_Title.getText());
      //  AssertResult(Acquisition_Discover_Title.getText(),"Discover Vodafone");
    }

    @Override
    public void assertAcqOfferPageUrl() throws InterruptedException {
        Thread.sleep(10000);
        Assert.assertTrue(driver.getPageSource().contains("deals-and-offers"));
    }

    public void validateNewBasicDBHeader(){
        basicDashboardUtils = BasicDashboardUtils.getBasicDashboard();
        waitForVisibility(NewDBHeaderTitle);
        AssertDisplayed(NewDBHeaderSubTitle.isDisplayed());
        AssertSoftResult(basicDashboardUtils.header.title ,NewDBHeaderTitle.getText() );
        AssertSoftResult(basicDashboardUtils.header.subtitle ,NewDBHeaderSubTitle.getText() );

    }
    public void clickOnAlreadyVodafoneCustomer(){
        waitForVisibility(NewDBHeaderSubTitle);
        NewDBHeaderSubTitle.click();

    }
    public void validateWhyVodafoneV2() throws InterruptedException {
        validateWhyVodafoneSectionTitle();
        validateWhyVodafoneJourneys();
    }

    private WebElement validateCardDisplayed(String label) {
        System.out.println(GetXpath(label));
        WebElement card = driver.findElement(By.xpath(GetXpath(label)));
        AssertDisplayed(card.isDisplayed());
        return card;
    }

    private void swipeToEndOfCard(String label) {
        WebElement card = driver.findElement(By.xpath(GetXpath(label)));
        swipeWebElement(card, "left");
    }

    private void validateWhyVodafoneSectionTitle() {
        WebElement why_vodafone = driver.findElement(By.xpath(GetXpath(newBasicDashboard.linksMenu.title)));
        waitForVisibility(why_vodafone);
        AssertDisplayed(why_vodafone.isDisplayed());
    }

    private void validateWhyVodafoneJourneys() throws InterruptedException {
        for (BasicDashboardResponseModelNew.BasicDashboardMenuItems item : newBasicDashboard.linksMenu.items) {
            if ("banner_card".equals(item.type)) {
                validateBannerCards(item.items.get(0).title, item.items.get(0).subtitle);
            }
            if ("dual_card".equals(item.type)) {
                validateDualCards(item.items.get(0).title, item.items.get(1).title);
            }
        }
    }

    private void getAppFromBackGround() {
        driver.navigate().back();
    }

    private static String extractLastWord(String input) {
        String[] words = input.trim().split("\\s+");
        return words[words.length - 1];
    }

    private void getAppAndSwipeToNextCard(String label) {
        getAppFromBackGround();
        swipeToEndOfCard(label);
    }

    private void validateBannerCards(String title, String subtitle) throws InterruptedException {
        validateCardDisplayed(title);
        validateCardDisplayed(subtitle).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("vodafone"));
        getAppAndSwipeToNextCard(subtitle);
    }

    private void validateDualCards(String topCardTitle, String bottomCardTitle) throws InterruptedException {
        validateCardDisplayed(topCardTitle).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains(extractLastWord(topCardTitle)));
        getAppFromBackGround();
        validateCardDisplayed(bottomCardTitle).click();
        Thread.sleep(5000);
        Assert.assertTrue(driver.getPageSource().contains("vodafone"));
        getAppAndSwipeToNextCard(bottomCardTitle);
    }

    public void validateDiscoverVodafone () {
        scrollDownTo(DiscoverVodafone);
        AssertDisplayed(DiscoverVodafone.isDisplayed());
        AssertResult(DiscoverVodafone.getText(), "Discover Vodafone");
    }
    public void validatePayMonthly (){
        waitForVisibility(PayMonthlyIcon);
        AssertResult(PayMonthlyCta.getText(), "Pay monthly phones");
        PayMonthlyIcon.click();
        waitForVisibility(PayMonthly_WebView);
        Assert.assertTrue(driver.getPageSource().contains("phones"));
        driver.navigate().back();



    }
    public void validateSimOnly (){
        waitForVisibility(SimOnlyDealsIcon);
        AssertResult(SimOnlyDeals.getText(),"SIM only deals");
        SimOnlyDealsIcon.click();
        waitForVisibility(SimOnlyDealsWebView);
        Assert.assertTrue(driver.getPageSource().contains("Plan"));
        driver.navigate().back();
    }
    public void validateBroadbandCta (){
        waitForVisibility(BroadbandIcon);
        AssertResult(BroadbandCta.getText(),"Broadband");

        BroadbandIcon.click();
        waitForVisibility(BroadBandWebView);
        Assert.assertTrue(driver.getPageSource().contains("offers"));
        driver.navigate().back();
    }

    public void validateTradeInTool (){
        try {
            waitForVisibility(TradeInToolCTA);
        } catch (Exception e) {SwipeToElement(TradeInToolCTA, "left") ; }
        AssertResult(TradeInToolCTA.getText(),"Trade-in Tool");
        TradeInToolIcon.click();
        waitForVisibility(TradeInToolsWebView);
        Assert.assertTrue(driver.getPageSource().contains("trade-in"));
        driver.navigate().back();
    }



    @Override
    public void validateLatestOffers() {
        validateLatestOffersTitle();
        validateFirstOffer();
        validateSecondOffer();
        validateThirdOffer();
    }

    private void validateLatestOffersTitle() {
        waitForVisibility(LatestOffersTitle);
        AssertResult(LatestOffersTitle.getText(), "Latest Offers");

    }

    private void validateFirstOffer() {
        waitForVisibility(LatestOffersTitle);
        FirstOffer.isDisplayed();
        offerCta.click();
        //we should add API validation
        if (elementIsPresent(AcceptCookies)){AcceptCookies.click();}
        waitForVisibility(firstOfferWebViewDescription);
        firstOfferWebViewDescription.isDisplayed();
        driver.navigate().back();

    }

    private void validateSecondOffer() {
        waitForVisibility(LatestOffersTitle);
        SwipeToElement(SecondOffer, "Left");
        SecondOffer.isDisplayed();
        //we should add API validation
        offerCta.click();
        if (elementIsPresent(AcceptCookies)){AcceptCookies.click();}
        SecondOfferWebViewDescription.isDisplayed();
        CloseWebView(WF_TUT_closeCTA);
    }

    private void validateThirdOffer() {
        waitForVisibility(LatestOffersTitle);
        SwipeToText("Find out how our Network is performing where you are", "com.myvodafoneapp:id/cta_description");
        waitForVisibility(ThirdOffer);
        ThirdOffer.isDisplayed();
        offerCta.click();
        //we should add API validation
       waitForVisibility(ThirdOfferWebView);
       thirdOfferWebViewDescription.isDisplayed();
        CloseWebView(WF_TUT_closeCTA);

    }

}
