package pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AddNewPlan_AddPaymentMethodBeforeJourney_PO extends CommonPo {

    public AddNewPlan_AddPaymentMethodBeforeJourney_PO(){super();}

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle"),
            @FindBy(how = How.ID, using = "Tap here to select a plan")
    })
    public static WebElement RedHybrid_AddPlanCard;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public static WebElement RedHybrid_PaymentOverlayTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Add a new card']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@label = \"Add a new card\"]")
    })
    public static WebElement RedHybrid_PaymentOverlayAddCardCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/AddPaymentBeforePlanDescription"),
            @FindBy(how = How.ID, using = "paymentMethodOverlayDescription"),
            @FindBy(how = How.XPATH, using = "(//*[@type='XCUIElementTypeScrollView'])[2]/child::*/child::*/child::*[@type='XCUIElementTypeStaticText']")
    })
    public static WebElement RedHybrid_PaymentOverlayDesc;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanTitle"),
            @FindBy(how = How.ID, using = "choosePlanTitle")
    })
    public static WebElement RedHybrid_AddPlanOverlayTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanDescription"),
            @FindBy(how = How.ID, using = "choosePlanDescription")
    })
    public static WebElement RedHybrid_AddPlanOverlaySubTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID, using = "planActionViewCTA_0")
    })
    public static WebElement RedHybrid_AddPlanOverlayContinueCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='View plan details']"),
            @FindBy(how = How.ID, using = "planActionViewCTA_1")
    })
    public static WebElement RedHybrid_AddPlanOverlayLink;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public static WebElement RedHybrid_PaymentOverlayXCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='How our Flexi plans work']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='How our Flexi plans work']")
    })
    public static WebElement webviewTitle;
}
