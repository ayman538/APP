package pages.RedHybrid.PaymentReminderOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;



public class RedHybrid_PaymentReminderOverlay_PO extends CommonPo {

    public RedHybrid_PaymentReminderOverlay_PO() {super();}

    @FindAll({
            @FindBy(how = How.ID, using = "userType_icon"),
            @FindBy(how = How.ID, using = "DXIDMSubsOverlayXIcon")
    })
    public WebElement RedHybrid_reminderOverlayIcon;


    @FindAll({
            @FindBy(how = How.ID, using = "bottom_sheet"),
            @FindBy(how = How.ID, using = "bottomSheetPullViewId")
    })
    public WebElement RedHybrid_AddCardDrawer;

    @FindAll({
//            @FindBy(how = How.NAME, using = "txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement RedHybrid_AddCardTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "btnActionCTA"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA"),
            @FindBy(how = How.ID, using = "Add a new card")
    })
    public WebElement RedHybrid_AddCardCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/removeCurrentCardCTA"),
            @FindBy(how = How.ID, using = "removeCurrentCardCTA")
    })

    public WebElement RedHybrid_RemoveCardCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA_2"),
            @FindBy(how = How.ID, using = "action_1"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=“action_1”]")
    })
    public WebElement SoftLoginPrompt_CloseCTA;
}
