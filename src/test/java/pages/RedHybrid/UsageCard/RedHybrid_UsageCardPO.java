package pages.RedHybrid.UsageCard;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class RedHybrid_UsageCardPO extends CommonPo {

    //renewal date 1 jan
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardHeaderTextView"),
            @FindBy(how = How.ID, using = "txtDashboardChargesCardHeader")

    })
    public WebElement DBControlTile;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionMSISDN"),
            @FindBy(how = How.ID, using = "txtSubscriptionMSISDN")
    })
    public WebElement SO_MSISDN;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanListItemTitle"),
            @FindBy(how = How.XPATH, using = "//*[@name='txtUsageProductTitle']")

    })
    public WebElement SO_UsageTabRHTitle;
    //hybrid 5g plan


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/recyclerView"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeOther[@name='wdgUsageProductSection'])[1]/XCUIElementTypeOther/XCUIElementTypeOther")

    })
    public WebElement SO_UsageTabRHAllowances;
    //container that holds the usages data , texts and minutes

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Return to My Vodafone']"),
            @FindBy(how = How.ID, using = "ReminderOverlay_Button_1")

    })
    public WebElement returnToMyVodafoneCTA;
    // return to my vodafone cta
    public RedHybrid_UsageCardPO() {
        super();
    }


    //For Active Extras Card

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Active Extras']"),
            @FindBy(how = How.XPATH, using = " (//XCUIElementTypeOther[@name='wdgUsageProductSection'])[2]//XCUIElementTypeStaticText[@name='txtUsageProductTitle']")

    })
    public WebElement RH_ActiveExtrasCardTitle;



    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@resource-id='com.myvodafoneapp:id/sectionsRecyclerView'])[2]"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeOther[@name='wdgUsageProductSection'])[2]")

    })
    public WebElement RH_ActiveExtras;


}

