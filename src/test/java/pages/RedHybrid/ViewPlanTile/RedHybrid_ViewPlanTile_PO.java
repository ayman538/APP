package pages.RedHybrid.ViewPlanTile;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ViewPlanTile_PO extends CommonPo
{
    public RedHybrid_ViewPlanTile_PO(){super();}

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/currentChargesContainer"),
            @FindBy(how = How.ID, using = "Dashboard_CurrentSpends_Section")
    })
    public WebElement PlanCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardHeaderTextView"),
            @FindBy(how = How.ID, using = "txtDashboardChargesCardHeader")
    })
    public WebElement TitleOFPlanTile;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardTitleTextView"),
            @FindBy(how = How.ID, using = "txtDashboardCurrentSpendsAccountName")
    })
    public WebElement PlanDetails;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Renews in 30 days']"), //to be enhanced
            @FindBy(how = How.ID, using = "txtDashboardCurrentSpendsAdditionalLabel")
    })
    public WebElement ExpiryOrRenewText;


}
