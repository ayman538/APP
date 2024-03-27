package pages.ClickToUpgrade.NewPlan;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class NewPlanPO extends CommonPo {
    public NewPlanPO() {
        super();
    }

    /* ---------------------------------------------New Plan Card Section------------------------------------------*/

    @AndroidFindBy(id= "com.myvodafoneapp:id/toolbar_title_tv")
    @iOSXCUITFindBy(id= "yourNewPlanTitle")
    public WebElement ClickToUpgrade_NewPlanPage_PageTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/plan_name")
    @iOSXCUITFindBy(id= "planName")
    public WebElement ClickToUpgrade_NewPlanCard_PlanName;

    @AndroidFindBy(id= "com.myvodafoneapp:id/commitment_period")
    @iOSXCUITFindBy(id= "planNameValue")
    public WebElement ClickToUpgrade_NewPlanCard_CommitmentPeriod;

    @AndroidFindBy(id= "com.myvodafoneapp:id/DataTxt")
    @iOSXCUITFindBy(id= "dataHeader")
    public WebElement ClickToUpgrade_NewPlanCard_DataHeader;

    @AndroidFindBy(id= "com.myvodafoneapp:id/data")
    @iOSXCUITFindBy(id= "dataValue")
    public WebElement ClickToUpgrade_NewPlanCard_DataValue;

    @AndroidFindBy(id= "com.myvodafoneapp:id/MonthlyTxt")
    @iOSXCUITFindBy(id= "monthlyHeader")
    public WebElement ClickToUpgrade_NewPlanCard_MonthlyHeader;

    @AndroidFindBy(id= "com.myvodafoneapp:id/monthly_payment")
    @iOSXCUITFindBy(id= "monthlyValue")
    public WebElement ClickToUpgrade_NewPlanCard_MonthlyValue;

    @AndroidFindBy(id= "com.myvodafoneapp:id/subscription_title")
    @iOSXCUITFindBy(id= "plusOneSubscription_Entertainment")
    public WebElement newPlanCardSubscriptionsTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/subscription_image")
    @iOSXCUITFindBy(id= "plusOneSubscriptionImage_Entertainment")
    public WebElement newPlanCardSubscriptionsIcons;

    @AndroidFindBy(id= "com.myvodafoneapp:id/highlight_recyclerView")
    @iOSXCUITFindBy(id= "Plan_Highlights_List_Entertainment")
    public WebElement newPlanCardHighlights;

    /* --------------------------------------Payment Summary Details Section------------------------------------------*/

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryHeader")
    @iOSXCUITFindBy(id= "paymentSummaryHeader")
    public WebElement paymentSummaryHeader;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryText")
    @iOSXCUITFindBy(id= "paymentSummaryText")
    public WebElement paymentSummaryText;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryPlanPrice")
    @iOSXCUITFindBy(id= "paymentSummaryPlanPrice")
    public WebElement paymentSummaryPlanPrice;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryPriceCycle")
    @iOSXCUITFindBy(id= "paymentSummaryPriceCycle")
    public WebElement paymentSummaryPriceCycle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryContractStartDateLabel")
    @iOSXCUITFindBy(id= "paymentSummaryContractStartDateLabel")
    public WebElement paymentSummaryContractStartDateLabel;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryContractStartDate")
    @iOSXCUITFindBy(id= "paymentSummaryContractStartDate")
    public WebElement paymentSummaryContractStartDate;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryCommitmentPeriodLabel")
    @iOSXCUITFindBy(id= "paymentSummaryCommitmentPeriodLabel")
    public WebElement paymentSummaryCommitmentPeriodLabel;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryCommitmentPeriod")
    @iOSXCUITFindBy(id= "paymentSummaryCommitmentPeriod")
    public WebElement paymentSummaryCommitmentPeriod;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryCurrentPlanPriceLabel")
    @iOSXCUITFindBy(id= "paymentSummaryCurrentPlanPriceLabel")
    public WebElement paymentSummaryCurrentPlanPriceLabel;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryCurrentPlanPrice")
    @iOSXCUITFindBy(id= "paymentSummaryCurrentPlanPrice")
    public WebElement paymentSummaryCurrentPlanPrice;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryNewPlanPriceLabel")
    @iOSXCUITFindBy(id= "paymentSummaryNewPlanPriceLabel")
    public WebElement paymentSummaryNewPlanPriceLabel;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryNewPlanPrice")
    @iOSXCUITFindBy(id= "paymentSummaryNewPlanPrice")
    public WebElement paymentSummaryNewPlanPrice;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryNextBillHeader")
    @iOSXCUITFindBy(id= "paymentSummaryNextBillHeader")
    public WebElement paymentSummaryNextBillHeader;

    @AndroidFindBy(id= "com.myvodafoneapp:id/paymentSummaryNextBillText")
    @iOSXCUITFindBy(id= "paymentSummaryNextBillText")
    public WebElement paymentSummaryNextBillText;

    /*-----------------------------------------Terms and Conditions---------------------------------------------------*/

    @AndroidFindBy(id= "com.myvodafoneapp:id/tv_terms_label")
    @iOSXCUITFindBy(id= "TermsAndConditionsTitle")
    public WebElement newPlanTermAndCondTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/tv_terms_description")
    @iOSXCUITFindBy(id= "TermsAndConditions")
    public WebElement newPlanTermAndCondDescriptionTextView;

    @AndroidFindBy(id= "com.myvodafoneapp:id/toggle_terms_agreement")
    @iOSXCUITFindBy(id= "Toggle")
    public WebElement newPlanTermAndCondToggleBtn;

    @AndroidFindBy(id= "com.myvodafoneapp:id/confirmedPlanSummaryHeader")
    @iOSXCUITFindBy(id= "confirmedPlanSummaryHeader")
    public WebElement checkoutModalHeader;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtClickToUpgrade_shortMessage")
    @iOSXCUITFindBy(id= "changeYourPlanFailureTitle")
    public WebElement errorScreenShortMessage;

    @AndroidFindBy(id= "com.myvodafoneapp:id/confirmedPlanSummaryConfirmButton")
    @iOSXCUITFindBy(id= "confirmedPlanSummaryConfirmButton")
    public WebElement confirmedPlanSummaryConfirmButton;

    @AndroidFindBy(id= "com.myvodafoneapp:id/upgradePlanConfirmationScreenTitle")
    @iOSXCUITFindBy(id= "upgradePlanConfirmationScreenTitle")
    public WebElement upgradePlanConfirmationScreenTitle;

    @AndroidFindBy(xpath= "//*[@text='Browse recommended plans']")
    @iOSXCUITFindBy(xpath= "//*[@label='Browse recommended plans']")
    public WebElement seeAllPlansCTA;

}
