package pages.RedHybrid.confirmPurchace_Cancelled_Failed;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ConfirmPurchace_Cancelled_Failed_PO extends CommonPo {

    public ConfirmPurchace_Cancelled_Failed_PO(){
        super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public static WebElement paymentFailedScreenTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentErrorScreenAlertMessage"),
            @FindBy(how = How.ID, using = "paymentErrorScreenAlertMessage"),
            @FindBy(how = How.XPATH, using ="//*[@type='XCUIElementTypeStaticText' and @label='There was a problem confirming your card']")
    })
    public static WebElement paymentFailedScreenDescription;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgFailedRedHybridTik"),
            @FindBy(how = How.ID, using = "paymentErrorScreenTryIcon")
    })
    public static WebElement paymentFailedIcon;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA"),
            @FindBy(how = How.ID, using = "Try again")
    })
    public static WebElement paymentFailedScreenTryAgain;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Done']")
    })
    public static WebElement keyBoardDoneCta;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public static WebElement paymentFailedScreenDismissButton;
}
