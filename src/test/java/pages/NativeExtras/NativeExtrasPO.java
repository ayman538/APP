package pages.NativeExtras;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class NativeExtrasPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Add Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Add and manage Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add and manage Extras']")
    })
    public WebElement DB_addExtras;

    @FindAll({
            @FindBy(how = How.ID, using = "wdgTabContent_Extras"),
            @FindBy(how = How.ID, using = "Extras"),
            @FindBy(how = How.XPATH, using = "//*[@text='Extras']")

    })
    public WebElement extrasTab;


    @FindAll({
            @FindBy(how = How.ID, using = "activeExtrasCard"),
            @FindBy(how = How.ID, using = "activeExtrasCard")

    })
    public WebElement ActiveExtrasCard;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtrasControlCardTitle"),
            @FindBy(how = How.ID, using = "extraHeaderTextView")

    })
    public WebElement ActiveExtrasCardTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlStatus"),
            @FindBy(how = How.ID, using = "activeExtraControlStatus")

    })
    public WebElement ActiveExtrasStatus;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlTitle"),
            @FindBy(how = How.ID, using = "activeExtraControlTitle")

    })
    public WebElement ActiveExtrasTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlType"),
            @FindBy(how = How.ID, using = "activeExtraControlType")

    })
    public WebElement ActiveExtrasType;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlPrice"),
            @FindBy(how = How.ID, using = "activeExtraControlPrice")

    })
    public WebElement ActiveExtrasPrice;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlDate"),
            @FindBy(how = How.ID, using = "activeExtraControlDate")

    })
    public WebElement ActiveExtrasDate;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreTitle"),
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreTitle")

    })
    public WebElement ActiveExtrasFindOutMoreTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreCTA"),
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreCTA")

    })
    public WebElement ActiveExtrasFindOutMoreCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlDescription"),
            @FindBy(how = How.ID, using = "activeControlFindMoreDescription")

    })
    public WebElement ActiveExtrasDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "noActiveExtraControlDescription"),
            @FindBy(how = How.ID, using = "noExtraTextView")

    })
    public WebElement NoActiveExtrasDescription;



    @FindBy(how = How.ID, using = "shopExtrasCardIcon")
    public WebElement shopExtrasCardIcon;

    @FindBy(how = How.ID, using = "shopExtrasCardTitle")
    public WebElement shopExtrasCardTitle;

    @FindBy(how = How.ID, using = "shopExtrasCardDescription")
    public WebElement shopExtrasCardDescription;

    @FindBy(how = How.ID, using = "hideShowShopExtrasCardCTA")
    public WebElement hideShowShopExtrasCardCTA;

    @FindBy(how = How.ID, using = "rvShopCategories")
    public WebElement shopCategoriesTable;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Opt out']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Opt out']"),
    })
    public WebElement optOutRecurringExtraCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Re-Opt In']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Re-Opt In']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Remove']")

    })
    public WebElement reOptInRecurringExtraCTA;

    @FindBy(how = How.ID, using = "noActiveExtraControlDescription")
    public WebElement noActiveExtraControlDescription;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Manage in the Secure Net App']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage in the Secure Net App']")
    })
    public WebElement manageSecureNetCTA;
}


