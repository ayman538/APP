package pages.Dashboard.ControlTiles;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class ControlTilesPO extends CommonPo {

    //adding new element fot subscription icon text in dashboard

            @AndroidFindAll({
                    @AndroidBy(id = "com.myvodafoneapp:id/planRecyclerView"),
                    @AndroidBy(id = "com.myvodafoneapp:id/txtPlanTitle")
            })
            @iOSXCUITFindAll({
                @iOSXCUITBy(id = "wdgTabContent_Plan"),
                @iOSXCUITBy(id = "planCardImage_1")
            })
    public WebElement SO_PlanTabContent;
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtPlanListItemTitle\"])[3]"),
                    @iOSXCUITBy(xpath = "//*[@name='txtPlanListItemTitle']"),
                    @iOSXCUITBy(id = "txtPlanListItemTitle")
                    })
            @AndroidFindBy(xpath = "//*[@text='Contract']")
    public WebElement SO_PlanTabContract;
    
            @iOSXCUITFindBy(xpath = "//*[@name='Agreement ends']")
            @AndroidFindBy(xpath="//*[@text='Agreement ends']")
    public WebElement SO_ContractAgreement;
            
            @AndroidFindBy(xpath="com.myvodafoneapp:id/dismissImageView")
            @iOSXCUITFindBy(id = "closeIcon")
    public WebElement SO_Xicon;

            @AndroidFindBy(xpath="com.myvodafoneapp:id/txtGropDataTitle")
            @iOSXCUITFindBy(id = "txtGropDataTitle")
    public WebElement GD_GroupDataCardTitle;

            @AndroidFindBy(xpath="com.myvodafoneapp:id/extrasRecyclerView")
            @iOSXCUITFindBy(id = "wdgTabContent_Extras")
    public WebElement SO_ExtrasTabContent;

            @AndroidFindBy(xpath = "//*[@text='Upgrade available']")
            @iOSXCUITFindBy(xpath= "//*[@label='Upgrade available']")
    public static WebElement YourPlanTile;

            @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/controlText'])[1]")
            @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtDashboardControlTileCardTitle\"])[1]")
    public WebElement DB_AirtimePlanTile;

            @AndroidFindBy(id = "cardHeaderTextView")
            @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"txtDashboardChargesCardHeader\"]")
    public WebElement DB_AirtimeCurrentChargesTile;

            @AndroidFindAll({
                    @AndroidBy(xpath = "//*[@text='Device Plan']"),
                    @AndroidBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/controlText'])[2]")
            })
            @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtDashboardControlTileCardTitle\"])[2]")
    public WebElement DB_DevicePlanTile;

            @AndroidFindBy(xpath = "(//*[@resource-id='com.myvodafoneapp:id/controlText'])[3]")
            @iOSXCUITFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"txtDashboardControlTileCardTitle\"])[3]")
    public WebElement DB_ControlAndExtrasTile;

            @AndroidFindBy(xpath = "(//*[@selected='true'])[2]")
            @iOSXCUITFindBy(xpath = "//XCUIElementTypeScrollView[@name=\"wdgTabContent_Device Plan\"]")
    public WebElement DB_DevicePlanSuboverlayscreen;

            @AndroidFindAll({
                    @AndroidBy(xpath = "//*[@text='Extras']"),
                    @AndroidBy(id = "Extras")
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@label='Extras']"),
                    @iOSXCUITBy(id = "Extras")
            })
    public WebElement ExtrasTab;

            @AndroidFindBy(xpath="com.myvodafoneapp:id/txtDashboardNudgeTypeATitle")
            @iOSXCUITFindBy(id = "txtDashboardNudgeTypeATitle")
    public WebElement DB_Nudge;

            @AndroidFindBy(xpath="com.myvodafoneapp:id/btnDashboardNudgeTypeACloseCTA")
            @iOSXCUITFindBy(id = "btnDashboardNudgeTypeACloseCTA")
    public WebElement DB_NudgeXIcon;

            @AndroidFindBy(xpath="com.myvodafoneapp:id/btnDashboardNudgeCTA")
            @iOSXCUITFindBy(id = "btnDashboardNudgeCTA")
    public WebElement DB_NudgeUpgradeNowCTA;



    public ControlTilesPO() {
        super();
    }
}
