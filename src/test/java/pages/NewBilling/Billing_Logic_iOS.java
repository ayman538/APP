package pages.NewBilling;

import models.response.BillingDashboardResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BillingDashboardUtils;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class Billing_Logic_iOS extends Billing_Abstract {

    BillingDashboardResponseModel billingDashboardResponseModel;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    public Billing_Logic_iOS() {
        super();
        if(!live){
            billingDashboardResponseModel = BillingDashboardUtils.getBills();

        }
    }


    public int getTheIndexOfTheBillCard(String cardType) {
        int i = 0;
        int index=0;
        for (WebElement x : BillCard_title) {
            if (x.getText().toLowerCase().contains(cardType)) {
                index= i;
            }
            i++;
        }
        return index ;
    }


    @Override
    public void closeTheTutorial() {
        try {
            waitForVisibility(WF_TUT_closeCTA);
            WF_TUT_closeCTA.click();
        } catch (Exception e) {
            System.out.println("Tutorial doesn't exist");
        }
    }

    @Override
    public void waitForTheBillingDashboard() {
        waitForVisibility(Billing_title);
        AssertDisplayed(Billing_title.isDisplayed());
    }

    public void navigateToNewBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
    }

    public void assertBillTitleIsDisplayed() {
        waitForVisibility(Billing_title);
        AssertDisplayed(Billing_title.isDisplayed());
    }

    public void assertBillTitleCardXiconIsDisplayed() {
        waitForVisibility(Billing_card_X_CTA);
        AssertDisplayed(Billing_card_X_CTA.isDisplayed());
    }

    public void ValidateTheBillingTitleCardExistence() {
        assertBillTitleIsDisplayed();
        assertBillTitleCardXiconIsDisplayed();
    }

    public void clickOnBilligTitleCardXCTA() {
        waitForVisibility(Billing_card_X_CTA);
        Billing_card_X_CTA.click();
    }

    @Override
    public  void validateTheBillCardExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        iosScrollToElement(BillCard_title.get(cardIndex),"down");
        //waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_title.get(cardIndex)).isDisplayed());

    }

    @Override
    public void validateTheBillCradContainsTheMonthOfTheBillExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_MonthOfTheBill.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateiIconExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_iIcon.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateEstimatedTotalTextExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_EstimatedChargesText.get(cardIndex)).isDisplayed());
    }

    @Override
    public void clickOnTheArrowIcon(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        (BillCard_ArrowIcon.get(cardIndex)).click();
    }

    @Override
    public void validateTheFutureBillReinventJourenyIsOpen() throws InterruptedException {
        waitForVisibility(FutureBillCard_ReinventJoureny);
        Thread.sleep(90000);
        AssertDisplayed(FutureBillCard_ReinventJoureny.isDisplayed());


    }

    @Override
    public void validateAmountOfChargesExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_AmountOfCharges.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateBillStatusInfoExistence(String cardType) {
        int cardIndex=getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_BillStatusInfo.get(cardIndex)).isDisplayed());

    }

    @Override
    public void validateTheFirstBillReinventJourneyIsOpen() {
        waitForVisibilityForReinvent(FirstBillCard_ReinventJoureny,120);

        AssertDisplayed(FirstBillCard_ReinventJoureny.isDisplayed());
    }

    @Override
    public void validateMonthCycleExistence() {
        waitForVisibility(BillCard_SubDate);
        AssertDisplayed(BillCard_SubDate.isDisplayed());
    }

    @Override
    public void validateTheLatestBillReinventJourenyIsOpen(){
        waitForVisibilityForReinvent(LatestBillCard_ReinventJourney,120);
        AssertDisplayed(LatestBillCard_ReinventJourney.isDisplayed());
    }

    @Override
    public void validatePaymentOverDueCardExistence() {
        waitForVisibility(OverdueCard_title);
        AssertDisplayed(OverdueCard_title.isDisplayed());

    }


    @Override
    public void validatePaymentOverDueCardIconExistence() {
        waitForVisibility(OverdueCard_icon);
        AssertDisplayed(OverdueCard_icon.isDisplayed());
    }

    @Override
    public void validatePaymentOverDueCardSubtitleExistence() {
        waitForVisibility(OverdueCard_subtitle);
        AssertDisplayed(OverdueCard_subtitle.isDisplayed());
    }

    @Override
    public void validatePayBillNowCTAExistence() {
        waitForVisibility(OverdueCard_PayCTA);
        AssertDisplayed(OverdueCard_PayCTA.isDisplayed());
    }
    @Override
    public void clickOnThePayBillCTA() {
        waitForVisibility(OverdueCard_PayCTA);
        OverdueCard_PayCTA.click();
    }

    @Override
    public void validateThePaymentReinventJourneyIsOpened() {
        waitForVisibility(OverDueCard_ReinventJourney);
        AssertDisplayed(OverDueCard_ReinventJourney.isDisplayed());
    }

    public void validateDashboardAppearance() {
        AssertDisplayed(DX_IDM_MyAccountTray.isDisplayed());
    }

    //Tutorial IOS Logic

    @Override
    public void validateBillingTutorialTitleExistence() {
        waitForVisibility(TutorialTittle_BillingDashboard);
        AssertDisplayed(TutorialTittle_BillingDashboard.isDisplayed());
    }

    @Override
    public void validateBillingTutorialDescriptionExistence() {
        waitForVisibility(TutorialDescription_BillingDashboard);
        AssertDisplayed(TutorialDescription_BillingDashboard.isDisplayed());
    }
    @Override
    public void validateTutorialContinueCTAExistence(){
        waitForVisibility(TutorialContinueCTA_BillingDashboard);
        AssertDisplayed(TutorialContinueCTA_BillingDashboard.isDisplayed());
    }
    @Override
    public void clickOnTutorialContinueCTA(){
        waitForVisibility(TutorialContinueCTA_BillingDashboard);
        TutorialContinueCTA_BillingDashboard.click();
    }

    @Override
    public void closeTheBillingTutorial(){
        try {
            waitForVisibility(TutorialContinueCTA_BillingDashboard);
            TutorialContinueCTA_BillingDashboard.click();
        } catch (Exception e) {
            System.out.println("Billing tutorial doesn't exist");
        }
    }

    @Override
    public void validateViewBilingFAQsCardExistence() {
        scrollDownTo(ViewBillingFAQsCardHeader);
        Assert.assertTrue(ViewBillingFAQsCardDescription.getText().contains("frequently asked questions"));
    }

    @Override
    public void clickOnViewBilingFAQsCard() {
        ViewBillingFAQsCardChevron.click();
    }

    @Override
    public void validateBillingFAQsWebView() {
        waitForVisibility(BillingFAQsWebViewHeader);
    }

    public void checkManageCardsAndPaymentsCard() {
        scrollDownTo(ManageCardsAndPaymentsCardText);
        AssertDisplayed(ManageCardsAndPaymentsCardText.isDisplayed());
    }
    public void clickOnMangeCardsAndPaymentsChevron(){
        waitForVisibility(ManageCardsAndPaymentsCardChevron);
        ManageCardsAndPaymentsCardChevron.click();

    }
    public void checkNavigationToManagePayments() throws InterruptedException {
        waitForVisibility(ManageCardsAndPaymentsHeader);
    }

    @Override
    public void ValidateLoginScreenAppearsSuccessfullyForSMB()
    {
        AssertDisplayed(LoginScreenForSMB.isDisplayed());
    }

    @Override
    public void navigateToBilling(){
        waitForVisibilityForReinvent(driver.findElement(By.name("wdgMyBillsGraphSection")),30);
        waitForVisibilityForReinvent(driver.findElement(By.name("txtMyBillsAccountName")),30);
        waitForVisibilityForReinvent(driver.findElement(By.className("XCUIElementTypeCell")),30);
    }

    @Override
    public void validateTheExistenceOfVATTextBesideTheBillCard(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        System.out.println(BillCard_IncludeVATText.get(cardIndex).getText());
        AssertDisplayed((BillCard_IncludeVATText.get(cardIndex)).isDisplayed());
    }

    public void validateBillGraphForServiceUser(){
        Assert.assertFalse(billingDashboardResponseModel.graphEnabled);
        HardAssertNotDisplayed("Bill Graph",elementIsPresent(ManageCardsAndPaymentsHeader));
    }

    public void validateManageCardsPaymentsCardForServiceUser(){
        scrollDown();
        HardAssertNotDisplayed("Manage your spending",elementIsPresent(ManageCardsAndPaymentsHeader));
    }
}


