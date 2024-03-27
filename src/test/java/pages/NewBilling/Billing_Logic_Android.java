package pages.NewBilling;

import models.response.BillingDashboardResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BillingDashboardUtils;

import java.util.Locale;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class Billing_Logic_Android extends Billing_Abstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    BillingDashboardResponseModel billingDashboardResponseModel ;
    public Billing_Logic_Android() {
        super();
        if(!live) billingDashboardResponseModel = BillingDashboardUtils.getBills();
    }

    @Override
    public int getTheIndexOfTheBillCard(String cardType) {
        int i = 0;
        int index = 0;
        for (WebElement x : BillCard_title) {
            if (x.getText().toLowerCase().contains(cardType)) {
                index = i;
                break;
            }
            i++;
        }
        return index;
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
    public void navigateToNewBilling() {
        waitForVisibility(DB_BillingTray_icon);
        DB_BillingTray_icon.click();
    }

    @Override
    public void assertBillTitleIsDisplayed() {
        waitForVisibility(Billing_title);
        AssertDisplayed(Billing_title.isDisplayed());
    }

    @Override
    public void assertBillTitleCardXiconIsDisplayed() {
        waitForVisibility(Billing_card_X_CTA);
        AssertDisplayed(Billing_card_X_CTA.isDisplayed());
    }

    @Override
    public void ValidateTheBillingTitleCardExistence() {
        assertBillTitleIsDisplayed();
        assertBillTitleCardXiconIsDisplayed();
    }

    @Override
    public void clickOnBilligTitleCardXCTA() {
        waitForVisibility(Billing_card_X_CTA);
        Billing_card_X_CTA.click();
    }

    @Override
    public void validateDashboardAppearance() {
        AssertDisplayed(DX_IDM_MyAccountTray.isDisplayed());
    }

    @Override
    public void waitForTheBillingDashboard() {
        waitForVisibility(Billing_title);
        // this try and catch needs to be removed after new billing go live
        try {
            Assert.assertTrue(Billing_title.isDisplayed());
        }
        catch(Exception e) {
            Assert.assertTrue(Billing_title.getText().equals("Billing"));
            System.out.println("New billing is displayed");
        }
//

    }

    @Override
    public void validateTheBillCardExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_title.get(cardIndex)).isDisplayed());

    }

    @Override
    public void validateTheBillCradContainsTheMonthOfTheBillExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_MonthOfTheBill.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateiIconExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_iIcon.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateEstimatedTotalTextExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_EstimatedChargesText.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateAmountOfChargesExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_AmountOfCharges.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateBillStatusInfoExistence(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        AssertDisplayed((BillCard_BillStatusInfo.get(cardIndex)).isDisplayed());
    }

    @Override
    public void validateTheFirstBillReinventJourneyIsOpen() {
        waitForVisibilityForReinvent(FirstBillCard_ReinventJoureny, 120);
        String actualText = FirstBillCard_ReinventJoureny.getText();
        AssertResult(actualText.substring(0, 5).toLowerCase(Locale.ROOT), "first");
    }

    @Override
    public void clickOnTheArrowIcon(String cardType) {
        int cardIndex = getTheIndexOfTheBillCard(cardType);
        waitForVisibility(BillCard_title.get(cardIndex));
        (BillCard_ArrowIcon.get(cardIndex)).click();
    }

    @Override
    public void validateTheFutureBillReinventJourenyIsOpen() throws InterruptedException {
        waitForVisibility(FutureBillCard_ReinventJoureny);
        Thread.sleep(90000);
        String actualText = FutureBillCard_ReinventJoureny.getText();
        AssertResult(actualText.substring(0, 6).toLowerCase(Locale.ROOT), "future");

    }

    @Override
    public void validateMonthCycleExistence() {
        waitForVisibility(BillCard_SubDate);
        AssertDisplayed(BillCard_SubDate.isDisplayed());
    }

    @Override
    public void validateTheLatestBillReinventJourenyIsOpen() {
        waitForVisibilityForReinvent(LatestBillCard_ReinventJourney, 120);
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

   //Tutorial Android Logic
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
        Assert.assertTrue(ViewBillingFAQsCardDescriptionAndroid.get(1).getText().contains("frequently asked questions"));
    }

    @Override
    public void clickOnViewBilingFAQsCard() {
        ViewBillingFAQsCardChevronAndroid.get(1).click();
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
        waitForVisibilityForReinvent(driver.findElement(By.id("com.myvodafoneapp:id/barchart")),30);
        waitForVisibilityForReinvent(driver.findElement(By.id("com.myvodafoneapp:id/txtMyBillsAccountName")),30);
        waitForVisibilityForReinvent(driver.findElement(By.id("com.myvodafoneapp:id/wdgMyBillCard")),30);
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