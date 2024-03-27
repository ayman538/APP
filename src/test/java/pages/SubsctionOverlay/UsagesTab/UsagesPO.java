package pages.SubsctionOverlay.UsagesTab;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.List;


public class UsagesPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH,using = "//*[@text='Add extras']"),
            @FindBy(how = How.XPATH,using = "//*[@label='Add extras']"),
            @FindBy(how = How.XPATH, using = "//*[@text='See more available Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='See more available Extras']")

    })
    public WebElement US_addExtraCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Data add-ons')]")

    })
    public WebElement US_FirstTile;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")

    })
    public WebElement US_SecondTile;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")

    })
    public WebElement US_ThirdTile;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Buy Data']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Data']"),
    })
    public WebElement BuyDataOption;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Buy Calling']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Calling']"),
    })
    public WebElement BuyCallsOption;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Buy Roaming']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Roaming']"),
    })
    public WebElement BuyRoamingOption;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/closePartialIV"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=\"bottomSheetDismissButtonIdentifier\"]")
    })
    public WebElement XiConExtras;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/cardsRecyclerView"),
            @FindBy(how = How.ID, using = "wdgTabContent_Usage")
    })
    public WebElement SO_UsageTabContainer;
    /*
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Plan' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement SO_UsageTabPlanCardTitle;

     */
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='View plan']"),
            @FindBy(how = How.XPATH, using = "//*[@label='View plan']")

    })
    public WebElement US_ViewPlanCTA;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Plan' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']"),
            @FindBy(how = How.XPATH, using = "//*[@name='txtUsageProductTitle' and @label='Plan']")
    })
    public WebElement US_PlanCardTitlePAYM;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Big value bundle' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Big value bundle' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']")

    })
    public WebElement US_PlanCardTitleBVB;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/extra_main_title"),
            @FindBy(how = How.ID, using = "extra_main_title")
    })
    public WebElement US_ExtrasHeader;
    @FindAll({
            //           @FindBy(how = How.ID, using = ""),
            @FindBy(how = How.ID, using = "extra_header")
    })
    public List<WebElement> US_ExtrasImage;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Data add-ons')]")

    })
    public WebElement US_CarouselTitle1;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")
    })
    public WebElement US_CarouselTitle2;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")

    })
    public WebElement US_CarouselTitle3;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data add-ons']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text(), 'Data add-ons')]")

    })
    public WebElement US_ListTitle1;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Call abroad - 75 minutes']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")
    })
    public WebElement US_ListTitle2;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Travelling abroad']"),
            @FindBy(how = How.XPATH, using = "//*[contains(text() , 'Call abroad')]")

    })
    public WebElement US_ListTitle3;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/extra_title"),
            @FindBy(how = How.ID, using = "extra_title")
    })
    public List<WebElement> US_ListTitle;


    @FindAll({

            @FindBy(how = How.ID, using = "extra_arrow")
    })
    public List<WebElement> US_ListArrow;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage extras, caps and bars']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage extras, caps and bars']")

    })
    public WebElement US_manageExtrasCapsBarsCTA;

    public UsagesPO() {
        super();
    }
}
