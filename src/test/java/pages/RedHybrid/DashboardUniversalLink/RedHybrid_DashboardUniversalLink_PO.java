package pages.RedHybrid.DashboardUniversalLink;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_DashboardUniversalLink_PO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardHeaderTextView"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage plan']"),
    })
    public WebElement RedHybrid_ActivePlan;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddPlanNoActivePlanTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Tap here to select a plan']"),
    })
    public WebElement RedHybrid_NoActivePlan;

    @FindAll({
            @FindBy(how = How.ID, using = "com.sec.android.app.sbrowser:id/location_bar_edit_text"),
            @FindBy(how = How.XPATH, using = "//*[@text='www.vodafone.co.uk']"),
    })
    public WebElement RedHybrid_DashboardWebView;
}

