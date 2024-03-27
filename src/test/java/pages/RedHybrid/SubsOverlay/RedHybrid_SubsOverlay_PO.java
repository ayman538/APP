package pages.RedHybrid.SubsOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_SubsOverlay_PO extends CommonPo {

    public RedHybrid_SubsOverlay_PO() {
        super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/currentChargesContainer"),
            @FindBy(how = How.ID, using = "txtDashboardChargesCardHeader")
    })
    public WebElement RedHybrid_CreditTile;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Plan']")
    })
    public WebElement RedHybrid_PlanTab;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Usage']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Usage']")
    })
    public WebElement RedHybrid_UsageTab;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Extras']")
    })
    public WebElement RedHybrid_ExtrasTab;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionAccountType"),
            @FindBy(how = How.ID, using = "txtSubscriptionAccountType")
    })
    public WebElement RedHybrid_subscriptionType;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionMSISDN"),
            @FindBy(how = How.ID, using = "txtSubscriptionMSISDN")
    })
    public WebElement RedHybrid_subscriptionId;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionCreditSpend"),
            @FindBy(how = How.ID, using = "txtSubscriptionCreditSpend")
    })
    public WebElement RedHybrid_subscriptionBalance;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text[contains(.,'Active controls, limits and extras')]]"),
            @FindBy(how = How.ID, using = "Active controls, limits and extras")
    })
    public WebElement RedHybrid_ControlsLimitsAndExtrasTitle;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Extras']"),
            @FindBy(how = How.ID, using = "action_0")
    })
    public WebElement RedHybrid_BuyExtrasCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='com.myvodafoneapp:id/btnTopUpCTA' and @class='android.widget.Button' and @text='Manage Controls and Limits']"),
            @FindBy(how = How.ID, using = "action_1")
    })
    public WebElement RedHybrid_ManageControlAndLimits;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text[contains(.,'Pay as you go extras')]]"),
            @FindBy(how = How.XPATH, using = "//*[@label[contains(.,'Pay as you go extras')]]")
    })
    public WebElement PayAsYouGoCard;


}