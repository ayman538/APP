package pages.RedHybrid.ConfirmChangePlanOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ConfirmChangePlanOverlayPO extends CommonPo {
    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"), @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")})
    public WebElement confirmChangePlanOverlayHeader;


    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeTitle"), @FindBy(how = How.ID, using = "confirmPlanChangeTitle")})
    public WebElement confirmChangePlanOverlayTitle;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangeGigaByte"), @FindBy(how = How.ID, using = "confirmPlanProductName")})
    public WebElement confirmPlanChangePlanDeatils;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangePlanDetails"), @FindBy(how = How.ID, using = "confirmPlanChangePlanDeatils")})
    public WebElement confirmPlanChangePlanDesc;

    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangePrice"), @FindBy(how = How.ID, using = "confirmPlanProductPrice")})
    public WebElement confirmPlanChangePlanPrice;


    @FindAll({@FindBy(how = How.ID, using = "com.myvodafoneapp:id/confirmPlanChangePlansDescription"), @FindBy(how = How.ID, using = "confirmPlanChangePlansDescription")})
    public WebElement confirmPlanChangenotesDescription;

    @FindAll({@FindBy(how = How.XPATH, using = "//android.widget.Button[@text='Confirm next plan']"), @FindBy(how = How.ID, using = "confirmPlanChangePaySecurelyCTA")})
    public WebElement confirmNextPlanCTA;


}
