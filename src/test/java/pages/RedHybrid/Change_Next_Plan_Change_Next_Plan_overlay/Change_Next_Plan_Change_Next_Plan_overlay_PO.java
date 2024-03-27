package pages.RedHybrid.Change_Next_Plan_Change_Next_Plan_overlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class Change_Next_Plan_Change_Next_Plan_overlay_PO extends CommonPo {
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change Plan']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.ID, using = "Change Plan")
    })
    public WebElement planTabChangePlanCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanRecyclerView"),
            @FindBy(how = How.ID, using = "planBundelsContainerView")
    })
    public WebElement changePlanChoosePlanRecyclerView;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/planItem"),
            @FindBy(how = How.ID, using = "choosePlanRecyclerView_0")
    })
    public WebElement changePlanChoosePlanPlanItem;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changeNextPlanFooterTv"),
            @FindBy(how = How.ID, using = "changePlanChoosePlanChargesNotes")
    })
    public WebElement changePlanChoosePlanChargesNotes;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID, using = "Continue")
    })
    public WebElement changePlanChoosePlanContinueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanChoosePlanViewPlanDetails"),
            @FindBy(how = How.XPATH, using = "//*[@text='View plan details']"),
            @FindBy(how = How.ID, using = "planActionViewCTA_1")
    })
    public WebElement changePlanChoosePlanViewPlanDetails;


    @FindAll({
            @FindBy(how = How.ID, using = "Promo terms apply")
    })
    public static WebElement RedHybrid_PromoTermsApplyLink;
    @FindAll({
            @FindBy(how = How.ID, using = "currentPlanDesc"),
            @FindBy(how = How.ID, using = "Unlimited calls and texts")
    })
    public static WebElement RedHybrid_PlanDetails;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/promo_tv_id"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name='PromoSash']")
    })
    public static WebElement RedHybrid_PromoSashForPromotedPlans;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='My Vodafone']")
    })
    public static WebElement MyVodafoneTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanSubTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Change your plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Change your plan']"),

    })
    public static WebElement ChangePlanSubTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/changePlanDesc"),
            @FindBy(how = How.XPATH, using = "//*[@text='When would you like to change your Plus plan?']"),
            @FindBy(how = How.ID, using = "When would you like to change your Plus plan?"),

    })
    public static WebElement ChangePlanDesc;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/4-choosePlanCard_1"),
            @FindBy(how = How.XPATH, using = "//*[@text='Change plan for next month']"),
            @FindBy(how = How.ID, using = "Change plan for next month"),

    })
    public static WebElement ChangePlanForNextMonthCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/renewPlanEarlyCard"),
            @FindBy(how = How.XPATH, using = "//*[@text='Renew plan early']"),
            @FindBy(how = How.ID, using = "Renew plan early"),

    })
    public static WebElement RenewPlanEarlyCard;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='How our Flexi plans work']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='How our Flexi plans work']")
    })
    public static WebElement webviewTitle;
}
