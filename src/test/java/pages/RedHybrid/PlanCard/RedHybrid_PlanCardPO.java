package pages.RedHybrid.PlanCard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class RedHybrid_PlanCardPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnDetailedProductPageBackButton"),
            @FindBy(how = How.ID, using = "backIcon")
    })
    public WebElement IncludesBackIcon;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='My Account']"),
            @FindBy(how = How.ID, using = "My Account")

    })

    public WebElement  RedHybrid_MyAccount;



    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Return to My Vodafone']"),
            @FindBy(how = How.ID, using = "DXIDMSubsOverlay_Button_1")
    })
    public WebElement returnToMyVodafoneCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionMSISDN"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubscriptionTitle"),
            @FindBy(how = How.ID, using = "txtSubscriptionMSISDN")
    })
    public WebElement SO_MSISDN;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanListItemTitle"),
            @FindBy(how = How.ID, using = "txtPlanListItemTitle")
    })
    public WebElement IncludeTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanListItemTitle"),
            @FindBy(how = How.NAME, using = "txtPlanListItemTitle")

    })
    public WebElement YourPlan;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnIncludesShowMore"),
            @FindBy(how = How.XPATH, using = "//*[@value='Show more']")
    })
    public WebElement Includes_seeMore;

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = "android.widget.LinearLayout"),
            @FindBy(how = How.CLASS_NAME, using = "XCUIElementTypeTable")

    })
   public WebElement IncludesContainer;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/titleTextView")
    })

    public WebElement IncludeItemText;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDetailedProductPageTitle"),
            @FindBy(how = How.XPATH, using = "txtDetailedProductPageTitle")
    })
    public WebElement Includes_DetailedTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtProductDetails"),
            @FindBy(how = How.XPATH, using = "txtDetailedProductPageTitle")
    })
    public WebElement Includes_DetailedDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnDetailedProductCTA"),
            @FindBy(how = How.XPATH, using = "txtDetailedProductPageTitle")
    })
    public WebElement Includes_DetailedCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Add card']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dismissImageView"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add card']")
    })
    public WebElement add_card_link;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage your plan']"),
            @FindBy(how = How.ID, using = "manageYourPlanCardTitle")
    })
    public WebElement manageYourPlaneTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/planToggleMask"),
            @FindBy(how = How.ID, using = "manageYourPlanMaskDescription")
    })
    public WebElement manageYourPlaneMaskDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnActionCTA"),
            @FindBy(how = How.ID, using = "confirmPlanChangePaySecurelyCTA")

    })
    public WebElement confirmNextPlanButton;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"),
    })
    public WebElement notificationTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridTickIcon"),
            @FindBy(how = How.ID, using = "imgRedHybridTickIcon")
    })

    public WebElement checkMarkIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessNotification"),
            @FindBy(how = How.ID, using = "traySuccessNotification")
    })

    public WebElement notificationDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/traySuccessSubNotification"),
            @FindBy(how = How.ID, using = "traySuccessSubNotification")
    })
    public WebElement notificationSubDescription;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement redHybridCloseView;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/maskProcessingDesc"),
            @FindBy(how = How.ID, using = "templateMaskErrorScreenAlertMessage")
    })
    public WebElement processedRequestScreenDesc;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgRedHybridCloseView"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement processedRequestScreenXCta;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/maskProcessingIconId"),
            @FindBy(how = How.ID, using = "templateMaskErrorScreenTryIcon")
    })
    public WebElement processedRequestScreenAlertIcon;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/iv_title_icon")
    })
    public WebElement RedHybrid_TealCardIcon;


    //For Plan Tab with Teal Card
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.ID, using = "planCardCTA_0_0")
    })
    public WebElement RedHybrid_TealCardCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanTitle"),
            @FindBy(how = How.ID, using = "planCardTitle_0")
    })
    public WebElement RedHybrid_TealCardTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanDetails"),
            @FindBy(how = How.ID, using = "planCardDescription_0")
    })
    public WebElement RedHybrid_TealCardDESC;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgButton"),
            @FindBy(how = How.ID, using = "ic red hybrid active toggle")
    })
    public WebElement RedHybrid_AutoRenewToggle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage your plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage your plan']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanListItemTitle")
    })
    public WebElement RedHybrid_ManageYourPlanTitle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[starts-with(@text,'Changing to Plus')]"),
            @FindBy(how = How.ID, using = "txtDashboardCurrentSpendsAdditionalLabel")
    })
    public WebElement ChangeNextPlanMessage;
    public RedHybrid_PlanCardPO() {
        super();
    }
}