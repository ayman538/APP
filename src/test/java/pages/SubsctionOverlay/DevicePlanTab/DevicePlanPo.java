package pages.SubsctionOverlay.DevicePlanTab;


import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class DevicePlanPo extends CommonPo {


    @AndroidFindBy(id = "com.myvodafoneapp:id/deviceCardTitle")
    @iOSXCUITFindBy(id = "txtUsageProductTitle")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"txtUsageProductTitle\"]")
    public static WebElement SO_DevicePlanTitle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/textRight")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[12]")
    @iOSXCUITFindBy(xpath = "//*[@type='XCUIElementTypeStaticText']")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='']")
    public static WebElement SO_DevicePlanPaidAmountBar;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvValue")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[12]")
    public static WebElement SO_DevicePlanPaidAmount;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tvFooter")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[15]")
    public static WebElement SO_DevicePlanNextPaymentDate;

    @AndroidFindBy(id = "com.myvodafoneapp:id/textLeft")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[16]")
    public static WebElement SO_DevicePlanMonthlyPaymentTxt;

    @AndroidFindBy(id = "com.myvodafoneapp:id/textRight")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText)[17]")
    public static WebElement SO_DevicePlanMonthlyPaymentAmount;

    @AndroidFindBy(xpath = "//*[@text='Battery Refresh']")
    @iOSXCUITFindBy(id= "Battery Refresh")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Battery Refresh\"]")
    public WebElement SO_DevicePlan_BatteryRefreshLink;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtProductDetails")
    @iOSXCUITFindBy(id = "Don’t worry about your battery letting you down we’ll replace a tired battery if it needs it.")
    public WebElement SO_DevicePlan_BatteryRefreshDescription;

    @AndroidFindBy(xpath = "//*[@text='Battery Refresh Tool']")
    @iOSXCUITFindBy(id = "Battery Refresh Tool")
    public WebElement SO_DevicePlan_BatteryRefreshCTA;

    @AndroidFindBy(xpath = "//*[@text='Find a store']")
    @iOSXCUITFindBy(xpath = "//*[@name='Find a store']")
    public WebElement SO_DevicePlan_TotalCareWarrantyCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @AndroidFindBy(xpath = "//*[@text='Manage Device Plan']")
    @iOSXCUITFindBy(xpath = "//*[@name='Manage Device plan']")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"action_0\"])")
    public WebElement Manage_Device_PlanCTA;

    @AndroidFindBy(id = "ccom.myvodafoneapp:id/airtimePlanTV")
    @AndroidFindBy(id = "com.myvodafoneapp:id/infoImageView")
    @iOSXCUITFindBy(id= "txtDashboardCurrentSpendsAdditionalLabel")
    public WebElement What_Is_Device_PlanCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanScreenIcon")
    @iOSXCUITFindBy(id= "imgRedHybridTickIcon")
    public WebElement What_Is_Device_PlanIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanDescription")
    @iOSXCUITFindBy(id= "traySuccessNotification")
    public WebElement Your_DevicePlan_Explained_Title;

    @AndroidFindBy(id = "com.myvodafoneapp:id/airtimePlanSubDescription")
    @iOSXCUITFindBy(id= "traySuccessSubNotification")
    public WebElement Your_DevicePlan_ExplanationMessage;

    @AndroidFindBy(id = "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@label='Ok thanks']")
    public WebElement Ok_ThanksCTA;

    @AndroidFindBy(xpath = "//*[@text='Manage payment method']")
    @iOSXCUITFindBy(id= "ManagepaymentmethodBTN")
    public WebElement Manage_Payment_Method;

    @AndroidFindBy(xpath = "//*[@text='View or change payment details for this Device Plan']")
    @iOSXCUITFindBy(id= "VieworchangepaymentdetailsforthisDevicePlan")
    public WebElement Manage_Payment_Method_Description;

    @AndroidFindBy(xpath = "//*[@text='Complete your payment now']")
    @iOSXCUITFindBy(id= "CompleteyourpaymentnowBTN")
    public WebElement Complete_your_Payment;

    @AndroidFindBy(xpath = "//*[@text='Make a payment]")
    @iOSXCUITFindBy(id= "Makeapayment")
    public WebElement Complete_your_Payment_Description;

    @AndroidFindBy(xpath = "//*[@text='Payment history']")
    @iOSXCUITFindBy(id= "PaymenthistoryBTN")
    public WebElement Payment_History;

    @AndroidFindBy(xpath = "//*[@text='Review your payment history']")
    @iOSXCUITFindBy(id= "Reviewyourpaymenthistory")
    public WebElement Payment_History_Description;

    @AndroidFindBy(xpath = "//*[@text='Important documents']")
    @iOSXCUITFindBy(id = "ImportantdocumentsBTN")
    public WebElement Important_Documents;

    @AndroidFindBy(xpath = "//*[@text='Go to your important documents']")
    @iOSXCUITFindBy(id = "Gotoyourimportantdocuments")
    public WebElement Important_Documents_Description;

    @AndroidFindBy(xpath = "//*[@text='Cancel']")
    @iOSXCUITFindBy(id = "action_0")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Cancel']")
    public WebElement Cancel_btn;

    @AndroidFindBy(id = "btnClose")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name='VFGwebCloseButton']")
    public WebElement closeInternalWebview;

    public DevicePlanPo() {
        super();
    }


}

