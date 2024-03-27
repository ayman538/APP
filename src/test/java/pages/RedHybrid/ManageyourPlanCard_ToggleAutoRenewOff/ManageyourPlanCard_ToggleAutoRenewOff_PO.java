package pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ManageyourPlanCard_ToggleAutoRenewOff_PO extends CommonPo {

    public ManageyourPlanCard_ToggleAutoRenewOff_PO() {
        super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.ID, using = "Change Plan"),
    })
    public static WebElement ChangeYourPlanCTA;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage your plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage your plan']")


    })
    public static WebElement ManageYourPlanTitle;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Change your plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Change your plan']")

    })
    public static WebElement ChangeYourPlanTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanListItemDetails"),
            @FindBy(how = How.ID, using = "sectionsSubTitle_1"),

    })
    public static WebElement ChangeYourPlanDescription;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Auto-renew']"),
            @FindBy(how = How.ID, using = "Auto-renew"),

    })
    public static WebElement ManageYourPlanAutoRenew;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payment card']"),
            @FindBy(how = How.ID, using = "Payment card")
    })
    public static WebElement ManageYourPlanPaymentCard;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgButton"),
            @FindBy(how = How.ID, using = "ic red hybrid active toggle"),
            @FindBy(how = How.ID, using = "ic red hybrid non active toggl"),
            @FindBy(how = How.XPATH, using = "//*[@label='ic red hybrid active toggle']"),
            @FindBy(how = How.XPATH, using = "//*[@label='ic red hybrid non active toggl']"),
    })
    public static WebElement ManageYourPlanToggle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[contains(@text, 'Jan') or contains(@text, 'Feb') or contains(@text, 'Mar') or contains(@text, 'Apr') or contains(@text, 'May') or contains(@text, 'Jun') or contains(@text, ' Jul') or contains(@text, 'Aug') or contains(@text, 'Sep') or contains(@text, 'Oct') or contains(@text, 'Nov') or contains(@text, 'Dec')]"),
            @FindBy(how = How.XPATH, using = "//*[contains(@label, 'Jan') or contains(@label, 'Feb') or contains(@label, 'Mar') or contains(@label, 'Apr') or contains(@label, 'May') or contains(@label, 'Jun') or contains(@label, 'Jul') or contains(@label, 'Aug') or contains(@label, 'Sep') or contains(@label, 'Oct') or contains(@label, 'Nov') or contains(@label, 'Dec')]"),

    })
    public static WebElement ManageYourPlanExpirationDate;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[contains(@text,'••••')]"),
            @FindBy(how = How.XPATH, using = "//*[contains(@label,'••••')]")

    })
    public static WebElement ManageYourPlanCardNumber;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/planToggleMask"),
            @FindBy(how = How.ID, using = "manageYourPlanMaskDescription")

    })
    public static WebElement DisclaimerMaskMsg;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtHyperlink"),
            @FindBy(how = How.ID, using = "Add card")

    })
    public static WebElement addCardLink;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[contains(@text,'Amount')]"),
            @FindBy(how = How.ID, using = "Amount")

    })
    public static WebElement manageYourPlanAmount;


}
