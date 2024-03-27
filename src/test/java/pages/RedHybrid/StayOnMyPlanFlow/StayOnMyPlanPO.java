package pages.RedHybrid.StayOnMyPlanFlow;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class StayOnMyPlanPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.ID, using = "planCardCTA_0_0")
    }
    )
    public WebElement RedHybrid_TealCardCTA;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgCancelPlanRedHybridTik"), //Android
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeScrollView[@name='scrollView']/XCUIElementTypeImage")} //iOS}
    )
    public WebElement RedHybrid_StayOnMyPlanOrNOTTrayIcon;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/cancelChangePlanErrorScreenAlertMessage"), //Android
            @FindBy(how = How.XPATH, using = "//*[starts-with(@name,'Are you sure you want')]")} //iOS}
    )
    public WebElement RedHybrid_StayOnMyPlanOrNOTTrayHeader;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/cancelChangePlanErrorScreenDescription"), //Android
            @FindBy(how = How.XPATH, using = "//*[starts-with(@name,'If so, your Plus Plan')]")} //iOS}
    )
    public WebElement RedHybrid_StayOnMyPlanOrNOTTrayDescription;

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@text='Stay on my plan']"), //Android
            @FindBy(how = How.ID, using = "action_0")} //iOS}
    )
    public WebElement RedHybrid_StayOnMyPlanOrNOTTrayStayOnCurrentPlanCTA;

    @FindAll({@FindBy(how = How.XPATH, using = "//*[@text='No thanks']"), //Android
            @FindBy(how = How.ID, using = "No thanks")} //iOS}
    )
    public WebElement RedHybrid_StayOnMyPlanOrNOTTrayNoThanksCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridTickIcon"),
            @FindBy(how = How.ID, using = "imgRedHybridTickIcon")
    })
    public WebElement RedHybrid_CancelChangeNextPlanTrayTikIcon;

    @FindAll({
            @FindBy(how = How.ID, using = "traySuccessNotification") // for both android & iOS
    })
    public WebElement RedHybrid_ConfirmationTrayDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "traySuccessSubNotification") // for both android & iOS
    })
    public WebElement RedHybrid_ConfirmationTraySubDescription;

}
