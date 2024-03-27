package pages.RedHybrid.ViewAllowance;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ViewAllowance_PO extends CommonPo {

    public RedHybrid_ViewAllowance_PO() {
        super();
    }


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/headerTextView"),
            @FindBy(how = How.ID, using = "txtDashboardAllowencesCurrentConsumption")
    })
    public WebElement DB_AllowanceTileTitle; /*data - ""headerFallback": ": */

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/totalAmountTextView"),
            @FindBy(how = How.ID, using = "txtDashboardAllowencesCurrentConsumption")
    })
    public WebElement DB_AllowanceTileTotalAmount; /*left of 50 - "subtitle": */
    @FindAll({
            @FindBy(how = How.XPATH, using = "((//*[@resource-id='" + "com.myvodafoneapp:id/txtPlanListItemTitle']))[1]"),
            @FindBy(how = How.ID, using = "txtDashboardAllowencesRemaining")
    })
    public WebElement DB_AllowanceTileSubTitle; /* 50 - "title":  */
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/unitTextView"),
            @FindBy(how = How.XPATH, using = "(//*[@name='txtDashboardAllowencesCurrentConsumption']/following::*[@type='XCUIElementTypeStaticText'])[1]")
    })
    public WebElement DB_AllowanceTileUnit; /* GB - "remainingUnit":  */


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/footerTextView"),
            @FindBy(how = How.ID, using = "wdgDashboardAllowences")
    })
    public WebElement DB_AllowanceTileFooter;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/contentView"),
            @FindBy(how = How.ID, using = "wdgDashboardAllowences")
    })
    public WebElement DB_AllowanceTileView;
    /*
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/viewAllButton"),
            @FindBy(how = How.XPATH, using = "(//*[@label='View all usage'])[1]")
    })
    public WebElement DB_AllowanceTileViewAllUsage;


     */

}
