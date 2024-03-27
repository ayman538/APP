package pages.RedHybrid.AddExtrasAndData;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AddExtrasAndData_PO extends CommonPo
{
    @FindAll({
            @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout/android.widget.TextView[@text=\"Add Data\"]"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add Data']")
    })
    public static WebElement addData;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout/android.widget.TextView[@text=\"Add Extras\"]"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add Extras']")
    })
    public static WebElement addExtras;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Buy Extras']")
    })
    public static WebElement buyExtras;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/currentChargesContainer"),
            @FindBy(how = How.ID, using = "Dashboard_CurrentSpends_Section")
    })
    public static WebElement planTile;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Extras']"),
            @FindBy(how = How.ID, using = "Extras")
    })
    public static WebElement extrasTab;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/AddPaymentBeforePlanDescription" +
                    ""),
            @FindBy(how = How.XPATH, using = "(//*[@type='XCUIElementTypeScrollView'])[2]/child::*/child::*/child::*[@type='XCUIElementTypeStaticText']")
    })
    public static WebElement addExtrasOverlay;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/AddPaymentBeforePlanDescription"),
            @FindBy(how = How.XPATH, using = "(//*[@type='XCUIElementTypeScrollView'])[2]/child::*/child::*/child::*[@type='XCUIElementTypeStaticText']")
    })
    public static WebElement addDataOverlay;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text[contains(.,'Active controls, limits and extras')]]"),
            @FindBy(how = How.ID, using = "Active controls, limits and extras")
    })
    public static WebElement RedHybrid_ControlsLimitsAndExtrasTitle;



}