package pages.RedHybrid.ConfirmExtrasPurchase_BeforeAuthorizationStatus;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ConfirmExtrasPurchase_BeforeAuthorizationStatus_PO extends CommonPo {

    @FindAll({

            @FindBy(how = How.XPATH, using ="//*[@resource-id='confirmCsc']"),
            @FindBy(how = How.ID, using = "confirmCsc")

    })

    public static WebElement CardSecurityCode;




    @FindAll({
            @FindBy(how = How.ID, using = "confirmCardholderName")
    })
    public WebElement confirmCardHolderName;


    @FindAll({
            @FindBy(how = How.ID, using = "confirmCsc")
    })
    public WebElement confirmCsc;


    @FindAll({
            @FindBy(how = How.ID, using = "btnSubmit")
    })
    public WebElement submitBtn;

    @FindAll({
            @FindBy(how = How.ID, using = "passcode")
    })
    public WebElement passCode;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//input[@type='submit'])"),
    })
    public WebElement authSubmitBtn;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Continue']")
    })
    public WebElement addExtrasContinueCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeButton' and @label='Continue']")
    })
    public WebElement continueCTA;


    @FindAll({
            //  @FindBy(how = How.XPATH, using = "//*[@text='Extra 2GB data (monthly)']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeGigaByte"),
            @FindBy(how = How.ID, using = "confirmPlanProductName")

    })
    public WebElement productName;
    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangePrice"),
            @FindBy(how = How.ID, using = "confirmPlanProductPrice")

    })
    public WebElement productPrice;
    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangePlanDeatils"),
            @FindBy(how = How.ID, using = "confirmPlanChangePlanDeatils")


    })
    public WebElement productDesc;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")


    })
    public WebElement xCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeTitle"),
            @FindBy(how = How.ID, using = "confirmPlanChangeTitle")


    })
    public WebElement confirmPlanHeader;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeNote"),
            @FindBy(how = How.ID, using = "confirmPlanChangePlanSecondDescription")

    })
    public WebElement confirmPlanChangeNote;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")

    })
    public WebElement RedHybridTitle;


}
