package pages.RedHybrid.ConfirmYourPurchase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ConfirmYourPurchasePO extends CommonPo {


    //to be checked again after inspection
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='confirmCsc']"),
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='confirmCsc']")
    })

    public static WebElement CardSecurityCode;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Confirm your purchase']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeTitle"),
            @FindBy(how= How.ID,using = "confirmPlanChangeTitle")

    })
    public WebElement confirmPlanPurchaseTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirm_Plan_Purchase_TermAndConditionToggle"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeSwitch' and @name='confirmPlanChangeTermAndConditionToggle']"),
            @FindBy(how = How.ID, using = "confirmPlanChangeTermAndConditionToggle")
    })
    public WebElement confirmPlanPurchaseTermAndConditionToggle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirm_Plan_Purchase_PaySecurelyCTA"),
            @FindBy(how = How.ID, using = "confirmPlanChangeTermAndConditionToggle")
    })
    public WebElement confirmPlanPurchasePaySecurelyButton;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeGigaByte"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeStaticText' and @name='confirmPlanProductName']"),
            @FindBy(how = How.ID, using = "confirmPlanProductName")
    })
    public WebElement confirmPlanPurchaseProductName;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessNotification"),
            @FindBy(how = How.ID, using = "traySuccessNotification"),
    })
    public WebElement traySuccessNotification;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessSubNotification"),
            @FindBy(how = How.ID, using = "traySuccessSubNotification"),
    })
    public WebElement traySuccessSubNotification;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/planToggleMask"),
            @FindBy(how = How.ID, using = "Your plan purchase is currently being processed. Please check back shortly."),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAddNewPlanMaskDescription")
    })
    public WebElement manageYourPlaneMaskDescription;

}
