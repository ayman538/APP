package pages.RedHybrid.PaymentMethodOverlayNoPaymentMethodAdded;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class RedHybrid_PaymentMethodOverlayNoPaymentMethodAdded_PO extends CommonPo {

    //the NoPaymentMethod overlay
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public static WebElement NoPaymentMethodTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/PaymentMethodOverlayDescription"),
            @FindBy(how = How.ID, using = "paymentMethodOverlayDescription")
    })
    public static WebElement NoPaymentMethodDescription;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Tap here to add Plus plan']"),
            @FindBy(how = How.ID, using = "Tap here to add Plus plan"),
            @FindBy(how = How.XPATH, using = "//*[@label='Tap here to add Plus plan']"),



    })
    public static WebElement NoPlanStateAllowanceTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanSubtitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Select a Plus plan to get started. All plans last for 30 days and come with unlimited calls and texts.']"),
            @FindBy(how = How.ID, using = "Select a Plus plan to get started. All plans last for 30 days and come with unlimited calls and texts."),
            @FindBy(how = How.XPATH, using = "//*[@label='Select a Plus plan to get started. All plans last for 30 days and come with unlimited calls and texts.']"),

    })
    public static WebElement NoPlanStateAllowanceSubTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanTitle"),
            @FindBy(how = How.ID, using = "choosePlanTitle")

    })
    public static WebElement AddPlanTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanDescription"),
            @FindBy(how = How.ID, using = "choosePlanDescription")
    })
    public static WebElement ChoosePlanDisc;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Add a new card']"),
            @FindBy(how = How.ID, using = "Add a new card")


    })
    public static WebElement NoPaymentMethodBtn;

    @FindAll({
            @FindBy(how = How.ID, using = "addPlanChangeAutoRenewToggle"),
            @FindBy(how = How.ID, using = "addPlanChangeAutoRenewToggle")
    })
    public static WebElement AutoRenewToggle_AddNewPlanScreen;

    @FindAll({
            @FindBy(how = How.ID, using = "addPlanChangeAutoRenewDescription"),
            @FindBy(how = How.ID, using = "Auto-renew my plan every 30 days")
    })
    public static WebElement AutoRenewText_AddNewPlanScreen;

    @FindAll({
            @FindBy(how = How.ID, using = "addNewPlanFooter"),
            @FindBy(how = How.ID, using = "Please note: Auto-renew settings can be changed at any time.")
    })
    public static WebElement AutoRenewNote_AddNewPlanScreen;
}
