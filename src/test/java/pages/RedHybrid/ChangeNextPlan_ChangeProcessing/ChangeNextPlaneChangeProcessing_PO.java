package pages.RedHybrid.ChangeNextPlan_ChangeProcessing;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ChangeNextPlaneChangeProcessing_PO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "txtDashboardLinksMenuCellLabel_Change plan for next month"),
            @FindBy(how = How.XPATH, using = "//*[@label='Change plan for next month']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Change plan for next month']"),

    })
    public WebElement quickLinkChangePlan;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA"),
            @FindBy(how = How.ID, using = "confirmPlanChangePaySecurelyCTA")

    })
    public WebElement confirmNextPlanButton;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgProcessingRedHybrid"),
            @FindBy(how = How.ID, using = "scrollView")
    })
    public WebElement vodafoneLogoAnimation;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtProcessingRedHybridBody"),
            @FindBy(how = How.ID, using = "Processing ..."),
    })
    public WebElement processingTxt;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"),
    })
    public WebElement notificationTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridTickIcon"),
            @FindBy(how = How.ID, using = "imgRedHybridTickIcon")
    })

    public WebElement checkMarkIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessNotification"),
            @FindBy(how = How.ID, using = "traySuccessNotification")
    })

    public WebElement notificationDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessSubNotification"),
            @FindBy(how = How.ID, using = "traySuccessSubNotification")
    })
    public WebElement notificationSubDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement redHybridCloseView;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Skip']"),
            @FindBy(how = How.ID, using = "action_1")
    })
    public static WebElement RedHybrid_PaymentOverlaySkipCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/planItem"),
            @FindBy(how = How.ID, using = "choosePlanRecyclerView_0")
    })
    public WebElement changePlanChoosePlanPlanItem;

}
