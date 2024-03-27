package pages.RedHybrid.AddNewPlan_PaymentMethodOverlay;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AddNewPlan_PaymentMethodOverlay_PO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public static WebElement paymentMethodOverlayHeader;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtBeginPaymentTitle"),
            @FindBy(how = How.ID, using = "Payment method")
    })
    public static WebElement paymentMethodOverlayTitle;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='confirmCardLabel']"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeStaticText' and contains(@label,'Card ending')]")
    })
    public WebElement paymentMethodOverlayPaymentMethodNumber;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@class='android.view.View' and @resource-id='confirmCardExpiryLabel']"),
            @FindBy(how = How.XPATH, using = "//*[@type='XCUIElementTypeStaticText' and contains(@label,'Expires')]")
    })
    public WebElement paymentMethodOverlayPaymentMethodExpiryDate;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/rb_selected_plan"),
            @FindBy(how = How.NAME, using = "imgDrawerAddNewPlanSubIcon")
    })
    public WebElement RadioButtonAddPlanOverlay;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/choosePlanTitle"),
            @FindBy(how = How.ID, using = "choosePlanTitle")
    })
    public static WebElement AddPlanTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/promo_tv_id"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name='PromoSash']")
    })
    public static WebElement Redhybrid_PromoSashForPromotedPlans;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtOrigAllowance")
    })
    public static WebElement Redhybrid_OriginalDataForPromotedPlans;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanPackage")
    })
    public static WebElement Redhybrid_NewDataForPromotedPlans;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Promo terms apply']"),

    })
    public static WebElement RedHybrid_PromoTermsApplyLink;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanPrice")
    })
    public static WebElement Redhybrid_PlanPrice;

    @FindAll({
            @FindBy(how = How.ID, using = ""),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='My Vodafone']")
    })
    public static WebElement MyVodafoneTitle;
}
