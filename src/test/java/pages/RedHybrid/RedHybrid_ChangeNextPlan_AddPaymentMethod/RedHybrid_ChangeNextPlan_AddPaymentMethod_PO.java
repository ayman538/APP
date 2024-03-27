package pages.RedHybrid.RedHybrid_ChangeNextPlan_AddPaymentMethod;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ChangeNextPlan_AddPaymentMethod_PO extends CommonPo {

    public RedHybrid_ChangeNextPlan_AddPaymentMethod_PO(){
        super();
    }

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change plan for next month']"),
            @FindBy(how = How.ID, using = "DashboardLinksMenuCellLeftIcon_Change plan for next month")
    })
    public static WebElement RedHybrid_ChangePlanQuickLinks;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.ID, using = "Change Plan")
    })
    public static WebElement RedHybrid_ChangePlanInPlanTab;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/currentChargesContainer"),
            @FindBy(how = How.ID, using = "Dashboard_CurrentSpends_Section")
    })
    public static WebElement RedHybrid_PlanTile;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Plan']")
    })
    public static WebElement RedHybrid_PlanTab;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanTitle"),
            @FindBy(how = How.ID, using = "choosePlanTitle")
    })
    public static WebElement RedHybrid_ChangPlanOverlayTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanDescription"),
            @FindBy(how = How.ID, using = "choosePlanDescription")
    })
    public static WebElement RedHybrid_ChangPlanOverlaySubTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID, using = "planActionViewCTA_0")
    })
    public static WebElement RedHybrid_ChangPlanOverlayContinueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/currentPlanTitle"),
            @FindBy(how = How.ID, using = "Your current plan")
    })
    public static WebElement RedHybrid_ChangPlanOverlayCurrentPlan;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='View plan details']"),
            @FindBy(how = How.ID, using = "planActionViewCTA_1")
    })
    public static WebElement RedHybrid_ChangPlanOverlayLink;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Skip']"),
            @FindBy(how = How.ID, using = "action_1")
    })
    public static WebElement RedHybrid_PaymentOverlaySkipCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Skip']"),
            @FindBy(how = How.ID, using = "changePlanChoosePlanCurrentPlanDescription")
    })
    public static WebElement currentPlanName;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Skip']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Plus plan']")
    })
    public static WebElement selectPlanDescription;


}
