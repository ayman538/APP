package pages.RedHybrid.NoActivePlan;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_NoActivePlan_PO extends CommonPo {

    public RedHybrid_NoActivePlan_PO() {super();}

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle"),
            @FindBy(how = How.ID, using = "Tap here to add Plus plan")
    })
    public static WebElement RedHybrid_AddPlan;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Discover']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Discover']")
    })
    public WebElement DiscoverTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/offerImageView"),
            @FindBy(how = How.ID, using = "wdgDashboardDiscoverSection")
    })
    public WebElement DiscoverCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDashboardVeryMeRewardsTitle"),
            @FindBy(how = How.XPATH, using = "//*[@label='VeryMe Rewards']")
    })
    public WebElement VeryMeTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgDashboardVeryMeOffer"),
            @FindBy(how = How.ID, using = "imgDashboardVeryMeOffer")
    })
    public WebElement VeryMeCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/headerTextView"),
            @FindBy(how = How.ID, using = "txtDashboardLinksMenuSectionTitle_Assistance")
    })
    public WebElement AssistanceTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Notifications']"),
            //@FindBy(how = How.XPATH, using = "")
    })
    public WebElement Notifications;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Trade In Tool']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Trade In Tool']")
    })
    public WebElement TradeInTool;

}