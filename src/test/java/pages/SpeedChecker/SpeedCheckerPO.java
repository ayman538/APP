package pages.SpeedChecker;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;
@Deprecated
public class SpeedCheckerPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Check Data and Wi-Fi Speed']")
    })
    public WebElement CheckDataAndWiFiSpeed;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dashboardActionButton")
    })
    public WebElement startTestButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/resultsCardSpeedIsTextView")
    })
    public WebElement resultStatement;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/resultsCardSpeedUsabilityTextView")
    })
    public WebElement usabilityResult;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Wi-Fi']")
    })
    public WebElement WiFiTab;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/previousTestItemSpeedSummaryTextView")
    })
    public WebElement wifiSummary;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/delete_prev_results_btn")
    })
    public WebElement deletePreviousTestsButton;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Yes I do']")
    })
    public WebElement yesIDoButton;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/contentRecyclerErrorMessageTextView")
    })
    public WebElement messageDeleted;

    public SpeedCheckerPO() {
        super();
    }
}