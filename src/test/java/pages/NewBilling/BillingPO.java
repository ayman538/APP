package pages.NewBilling;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.ArrayList;
import java.util.List;

public class BillingPO extends CommonPo{


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/billingHeaderTextView"),
            @FindBy(how = How.ID, using = "billingHeaderTextView"),
            @FindBy(how = How.ID, using = "txtScreenTitleLabel"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtMyBillsViewTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Billing']")

    })
    public WebElement Billing_title;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dismissImageView"),
            @FindBy(how = How.ID, using = "dismissImageView"),
            @FindBy(how = How.ID, using = "closeIcon")

    })
    public WebElement Billing_card_X_CTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_title"),
            @FindBy(how = How.ID, using = "bill_card_title")
    })
    public ArrayList<WebElement> BillCard_title;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_sub_title"),
            @FindBy(how = How.ID, using = "bill_card_sub_title")
    })
    public ArrayList<WebElement> BillCard_MonthOfTheBill;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_status_info_icon"),
            @FindBy(how = How.ID, using = "bill_card_status_info_icon")
    })
    public ArrayList<WebElement> BillCard_iIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_rider_section_text"),
            @FindBy(how = How.ID, using = "bill_card_rider_section_text")
    })
    public ArrayList<WebElement> BillCard_EstimatedChargesText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_rider_section_icon"),
            @FindBy(how = How.ID, using = "bill_card_rider_section_icon")
    })
    public ArrayList<WebElement> BillCard_ArrowIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_rider_section_bill_amount"),
            @FindBy(how = How.ID, using = "bill_card_rider_section_bill_amount")
    })


    public ArrayList<WebElement> BillCard_AmountOfCharges;

    @FindAll({
            @FindBy(how = How.ID, using = "bill_card_sub_date"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_bill_period")
    })
    public WebElement BillCard_SubDate;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name='txtEmbeddedErrorBody'])[1]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_manage_card_sub_title")
    })
    public WebElement OverdueCard_title;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name='txtEmbeddedErrorBody'])[2]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_manage_card_description")
    })
    public WebElement OverdueCard_subtitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeButton[@name='action_0'])[1]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA")
    })
    public WebElement OverdueCard_PayCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeImage[@name='imgEmbeddedError'])[1]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/img_manage_card_icon")
    })
    public WebElement OverdueCard_icon;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_status_info_text"),
            @FindBy(how = How.ID, using = "bill_card_status_info_text")
    })
    public ArrayList<WebElement> BillCard_BillStatusInfo;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[starts-with(@name, 'Future bill')]"),
            @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(),'Future')]")
    })
    public WebElement FutureBillCard_ReinventJoureny;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[starts-with(@name, 'First bill')]"),
            @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(),'First')]")
    })
    public WebElement FirstBillCard_ReinventJoureny;


    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[starts-with(@name, 'Latest bill')]"),
            @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(),'Latest')]")
    })
    public WebElement LatestBillCard_ReinventJourney;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='Make Payment']")
    })
    public WebElement OverDueCard_ReinventJourney;

    //Tutorial screen PO
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tutorialTitleLabel"),
            @FindBy(how = How.ID, using = "tutorialTitleLabel")
    })
    public WebElement TutorialTittle_BillingDashboard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tutorialDescriptionLabel"),
            @FindBy(how = How.ID, using = "tutorialDescriptionLabel")
    })
    public WebElement TutorialDescription_BillingDashboard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tutorialPrimaryButton"),
            @FindBy(how = How.ID, using = "tutorialPrimaryButton")
    })
    public WebElement TutorialContinueCTA_BillingDashboard;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='View billing FAQs']"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name=\"txtEmbeddedErrorBody\"])[5]")
    })
    public WebElement ViewBillingFAQsCardHeader;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name=\"txtEmbeddedErrorBody\"])[6]")
    })
    public WebElement ViewBillingFAQsCardDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tv_manage_card_description")
    })
    public List<WebElement> ViewBillingFAQsCardDescriptionAndroid;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeImage[@name=\"imgEmbeddedError\"])[5]")
    })
    public WebElement ViewBillingFAQsCardChevron;

    @FindAll({
            @FindBy(how = How.ID, using ="com.myvodafoneapp:id/chevronIcon")
    })
    public List<WebElement> ViewBillingFAQsCardChevronAndroid;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Billing']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Billing']")
    })
    public WebElement BillingFAQsWebViewHeader;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage cards and payment']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage cards and payment']"),
    })
    public WebElement ManageCardsAndPaymentsCardText;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage cards and payment']"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name=\"txtEmbeddedErrorBody\"])[3]"),
    })
    public WebElement ManageCardsAndPaymentsCardChevron;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@text='Manage Cards & Payment']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage Cards & Payment']")
    })
    public WebElement ManageCardsAndPaymentsHeader;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@text='Log in to My Vodafone']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"Log in to My Vodafone\"]"),
            @FindBy(how = How.ID,using = "username-or-phone-number-field"),
    })
    public WebElement LoginScreenForSMB;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/bill_card_description"),
            @FindBy(how = How.ID, using = "bill_card_description")
    })
    public ArrayList<WebElement> BillCard_IncludeVATText;
}
