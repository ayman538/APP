package pages.RedHybrid.AddNewPlanOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class Redhybrid_AddNewPlanOverlay_PO extends CommonPo {




    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='View plan details']"),
            @FindBy(how = How.ID_OR_NAME, using = "planActionViewCTA_1")

    })
    public WebElement ViewPlanDetailsCTA;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Flexi']"),
            @FindBy(how = How.ID_OR_NAME, using = "bottomSheetTitleIdentifier")

    })
    public WebElement AddNewPlanFlexiHeader;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Add Flexi plan']"),
            @FindBy(how = How.ID_OR_NAME, using = "choosePlanTitle")
    })
    public WebElement AddFlexiPlanTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanContinueCTA"),
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID_OR_NAME, using = "planActionViewCTA_0")
    })
    public WebElement AddNewPlanContinueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanDescription"),
            @FindBy(how = How.XPATH, using = "//*[@text='All Flexi plans are valid for 30 days and come with unlimited calls and texts.']"),
            @FindBy(how = How.ID_OR_NAME, using = "choosePlanDescription")
    })
    public WebElement AddNewPLanDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID_OR_NAME, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement AddNewPlanXCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/rb_selected_plan"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/rb_selected_plan"),
            @FindBy(how = How.NAME, using = "imgDrawerAddNewPlanSubIcon")
    })
    public WebElement AddNewPlanRadioButton;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanPrice"),
            @FindBy(how = How.ID_OR_NAME, using = "£10")
    })
    public WebElement AddNewPLanPurchaseAmount;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/webview_title"),
            @FindBy(how = How.XPATH, using = "//*[@text='My Vodafone']")
    })
    public WebElement MyVodafoneWebViewTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/webview_title"),
            @FindBy(how = How.XPATH, using = "//*[@text='Retry']")
    })
    public WebElement AddNewPlanRetryCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/webview_title"),
            @FindBy(how = How.XPATH, using = "//*[@text='Nevermind']")
    })
    public WebElement AddNewPlanNevermindCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/webview_title"),
            @FindBy(how = How.XPATH, using = "//*[@text='Nevermind']")
    })
    public WebElement AddNewPlanErrorStatusCode;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/webview_title"),
            @FindBy(how = How.XPATH, using = "//*[@text='Nevermind']")
    })
    public WebElement AddNewPlanErrorMessage;
}

