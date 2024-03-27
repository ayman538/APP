package pages.RedHybrid.QuickLinks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class QuickLinks_PO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDLogin_Button"),
            @FindBy(how = How.ID, using = "action_0")
    })
    public WebElement LoginCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Quick Links']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Quick Links']")
    })
    public WebElement QuickLinks;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage payments']"),
            @FindBy(how = How.ID, using = "DashboardLinksMenuCellLeftIcon_Manage payments")

    })
    public WebElement QuickLinks_ManagePayments;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payments']"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement QuickLinks_ManagePaymentsPage;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardHeaderTextView"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage plan']")
    })
    public WebElement ManagePlanCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDMSkipLogin_Button"),
            @FindBy(how = How.XPATH, using = "//*[@text='Skip Login']"),
            @FindBy(how = How.ID, using = "action_1")

    })
    public WebElement SkipLoginCTA;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDMSubsOverlay_Button"),
            @FindBy(how = How.XPATH, using = "//*[@text='Return to My Vodafone']"),
            @FindBy(how = How.ID, using = "DXIDMSubsOverlay_Button_1"),

    })
    public WebElement ReturnToMyVodafoneCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "txtDashboardLinksMenuCellLabel_Change plan for next month"),
            @FindBy(how = How.XPATH, using = "//*[@label='Change plan for next month']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Change plan for next month']"),

    })
    public WebElement quickLinkChangePlan;

    @FindAll({
            @FindBy(how = How.ID, using = "txtDashboardLinksMenuCellLabel_Manage payments"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage payments']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage payments']"),


    })
    public WebElement quickLinkManagePayment;

    @FindAll({
            @FindBy(how = How.ID, using = "DashboardLinksMenuCellLeftIcon_Renew plan early"),
            @FindBy(how = How.XPATH, using = "//*[@label='Renew plan early']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Renew plan early']"),



    })
    public WebElement quickLinkRenewEarly;






}






