package pages.RedHybrid.ViewAddPlanWithExtras;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ViewAddPlanWithExtras_PO extends CommonPo {


    public RedHybrid_ViewAddPlanWithExtras_PO(){
        super();
    }
   @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/contentView"),
            @FindBy(how = How.ID, using = "cardNoPlan")
    })
    public WebElement RH_AddPlanCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle"),
            @FindBy(how = How.ID, using = "Tap here to select a plan")
    })
    public WebElement RH_AddPlanCardTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanSubtitle"),
            @FindBy(how = How.ID, using = "Select a Flexi plan to get started. All plans last for 30 days and come with unlimited calls and texts.")
    })
    public WebElement RH_AddPlanCardSubTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/iconAddPlanNoActivePlan"),
            @FindBy(how = How.ID, using = "signNoPlan")
    })
    public WebElement RH_AddPlanCardSign;

    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@resource-id='com.myvodafoneapp:id/footerTextView'])[1]"),
            @FindBy(how = How.ID, using = "txtDashboardAllowencesResetsIn")
    })
    public WebElement RH_ExtrasCardFooter;
}
