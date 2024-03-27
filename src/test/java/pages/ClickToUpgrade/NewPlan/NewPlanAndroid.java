package pages.ClickToUpgrade.NewPlan;

import models.response.SelectedUpgradePlanResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.SelectedUpgradePlanUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;


public class NewPlanAndroid extends NewPlanAbstract {
    Properties envProp = readPropertyFile("config/env.properties");
    SelectedUpgradePlanResponseModel selectedUpgradePlan ;

    public NewPlanAndroid() {

        super();
        if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")){
            selectedUpgradePlan = SelectedUpgradePlanUtils.getSelectedUpgradePlan();
        }

    }

    @Override
    public void verifyThatNewPlanPageTitleIsCorrect() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitForVisibility((By.xpath("//*[@text='Upgrade your plan']")));
        //Assert.assertEquals(ClickToUpgrade_NewPlanPage_PageTitle.getText(), selectedUpgradePlan.title);
    }

    @Override
    public void verifyThatNewPlanCardContainsCorrectDetails() {
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_PlanName.getText(), selectedUpgradePlan.recommendedPlan.planName);
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_CommitmentPeriod.getText(), selectedUpgradePlan.recommendedPlan.commitmentPeriod);
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_DataHeader.getText(), selectedUpgradePlan.recommendedPlan.allowances.get(0).header);
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_DataValue.getText(), selectedUpgradePlan.recommendedPlan.allowances.get(0).value);
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_MonthlyHeader.getText(), selectedUpgradePlan.recommendedPlan.priceHeader);
        Assert.assertEquals(ClickToUpgrade_NewPlanCard_MonthlyValue.getText(), selectedUpgradePlan.recommendedPlan.price);
    }

    @Override
    public void verifyThatNewPlanPaymentSummaryContainsCorrectDetails() {
        Assert.assertEquals(paymentSummaryHeader.getText(), selectedUpgradePlan.paymentSummary.header);
        Assert.assertEquals(paymentSummaryText.getText(), selectedUpgradePlan.paymentSummary.text);
        Assert.assertEquals(paymentSummaryPlanPrice.getText(), selectedUpgradePlan.paymentSummary.newPlanPrice);
        Assert.assertEquals(paymentSummaryPriceCycle.getText(), selectedUpgradePlan.paymentSummary.priceCycle);
        Assert.assertEquals(paymentSummaryContractStartDateLabel.getText(), selectedUpgradePlan.paymentSummary.contractStartDateLabel);
        Assert.assertEquals(paymentSummaryContractStartDate.getText(), selectedUpgradePlan.paymentSummary.contractStartDate);
        Assert.assertEquals(paymentSummaryCommitmentPeriodLabel.getText(), selectedUpgradePlan.paymentSummary.commitmentPeriodLabel);
        Assert.assertEquals(paymentSummaryCommitmentPeriod.getText(), selectedUpgradePlan.paymentSummary.commitmentPeriod);
        Assert.assertEquals(paymentSummaryCurrentPlanPriceLabel.getText(), selectedUpgradePlan.paymentSummary.currentPlanPriceLabel);
        Assert.assertEquals(paymentSummaryCurrentPlanPrice.getText(), selectedUpgradePlan.paymentSummary.currentPlanPrice);
        Assert.assertEquals(paymentSummaryNewPlanPriceLabel.getText(), selectedUpgradePlan.paymentSummary.newPlanPriceLabel);
        Assert.assertEquals(paymentSummaryNewPlanPrice.getText(), selectedUpgradePlan.paymentSummary.newPlanPrice);
        Assert.assertEquals(paymentSummaryNextBillHeader.getText(), selectedUpgradePlan.paymentSummary.nextBillHeader);
        Assert.assertEquals(paymentSummaryNextBillText.getText(), selectedUpgradePlan.paymentSummary.nextBillText);
    }

    @Override
    public void verifyThatNewPlanTermsAndConditionsContainsCorrectData() {
        scrollDownTo(newPlanTermAndCondTitle);
        String termsAndConditionsTextLink = " Terms and conditions.";
        String termAndConditionsDescription = newPlanTermAndCondDescriptionTextView.getText().substring(0, (newPlanTermAndCondDescriptionTextView.getText().length() - termsAndConditionsTextLink.length()));
        Assert.assertEquals(newPlanTermAndCondTitle.getText(), selectedUpgradePlan.termAndCond.title);
        Assert.assertTrue(selectedUpgradePlan.termAndCond.description.contains(termAndConditionsDescription));
    }

    @Override
    public void toggleTermsAndConditionsConfirmation() {
        newPlanTermAndCondToggleBtn.click();
    }

    @Override
    public void clickOnContinueCTA() {
        newPlanTermAndCondContinueBtn.click();
    }

    @Override
    public void verifyThatCheckoutModalIsDisplayed() {
        waitForVisibility(checkoutModalHeader);
        AssertDisplayed(checkoutModalHeader.isDisplayed());
    }

    @Override
    public void verifyThatApiFailureErrorScreenIsDisplayed() {
        waitForVisibility(errorScreenShortMessage);
        AssertDisplayed(errorScreenShortMessage.isDisplayed());
    }

    @Override
    public void clickOnConfirmThisChangeCTA() {
        waitForVisibility(confirmedPlanSummaryConfirmButton);
        confirmedPlanSummaryConfirmButton.click();
    }

    @Override
    public void verifyThatTheConfirmationScreenAppears() {
        waitForVisibility(upgradePlanConfirmationScreenTitle);
        AssertDisplayed(upgradePlanConfirmationScreenTitle.isDisplayed());
    }

    @Override
    public void verifyThatNewPlanCardSubscriptionsDisplayed() {
        waitForVisibility(newPlanCardSubscriptionsTitle);
        Assert.assertEquals(newPlanCardSubscriptionsTitle.getText(), selectedUpgradePlan.recommendedPlan.subscriptions.text);
        AssertDisplayed(newPlanCardSubscriptionsIcons.isDisplayed());
    }

    @Override
    public void verifyThatNewPlanCardHighlightsDisplayed() {
        waitForVisibility(newPlanCardHighlights);
        AssertDisplayed(newPlanCardHighlights.isDisplayed());
    }
    @Override
    public void clickOnSeeAllPlansCTA() {
        waitForVisibility(seeAllPlansCTA);
        seeAllPlansCTA.click();
    }
}
