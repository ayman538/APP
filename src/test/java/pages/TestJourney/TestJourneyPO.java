package pages.TestJourney;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class TestJourneyPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = ""),
            @FindBy(how = How.XPATH, using = "//*[@name='Test a Journey']")
    })
    public WebElement testJourneyPageHeader;

    @FindBy(how = How.ID, using = "com.myvodafoneapp:id/ed_joureny_name") //this element exists only in android to insert the journey name
    public WebElement journeyNameTextField;

    @FindBy(how = How.ID, using = "com.myvodafoneapp:id/ed_joureny_target") //this element exists only in android to insert the target
    public WebElement targetTextField;

    @FindBy(how = How.ID, using = "com.myvodafoneapp:id/type_spinner") //this element exists only in android to choose the type of the journey
    public WebElement typeSpinner;

    @FindBy(how = How.XPATH, using = "//*[ @text='APP_SCREEN']")//this element exists only in android which is the type of the journey
    public WebElement appScreenChoice;

    @FindBy(how = How.ID, using = "com.myvodafoneapp:id/toggle_connection_required")//this element exists only in android to enable the connection
    public WebElement connectionRequiredToggle;

    @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btn_start_joureny")//this element exists only in android to start the journey
    public WebElement startJourneyBtn;

    @FindBy(how = How.XPATH, using = "//*[@name='testJourneyWithName_UPGRADE_PLAN']")
    public WebElement upgradePlanJourneyBtn;


}
