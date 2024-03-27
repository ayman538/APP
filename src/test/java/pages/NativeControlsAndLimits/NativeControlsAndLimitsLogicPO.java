package pages.NativeControlsAndLimits;

import pages.Commons.CommonPo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class NativeControlsAndLimitsLogicPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "wdgControlTile_3"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage Controls and Limits']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage Controls']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Manage Controls']")
    })
    public WebElement DB_controlsAndLimits;

    @FindAll({
            @FindBy(how = How.ID, using = "wdgTabContent_Controls"),
            @FindBy(how = How.ID, using = "Controls"),
            @FindBy(how = How.XPATH, using = "//*[@text='Controls']")

    })
    public WebElement controlTab;


    @FindAll({
            @FindBy(how = How.ID, using = "activeControlsCard"),
            @FindBy(how = How.ID, using = "activeExtrasCard")

    })
    public WebElement ActiveControlsCard;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlStatus"),
            @FindBy(how = How.ID, using = "activeExtraControlStatus")

    })
    public WebElement ActiveControlsStatus;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlTitle"),
            @FindBy(how = How.ID, using = "activeExtraControlTitle")

    })
    public WebElement ActiveControlsTitle;

    /*
    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlType"),
            @FindBy(how = How.ID, using = "activeExtraControlType")

    })
    public WebElement ActiveControlsType;

     */

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlPrice"),
            @FindBy(how = How.ID, using = "activeExtraControlPrice")

    })
    public WebElement ActiveControlsPrice;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlDate"),
            @FindBy(how = How.ID, using = "activeExtraControlDate")

    })
    public WebElement ActiveControlsDate;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreTitle"),
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreTitle")

    })
    public WebElement ActiveControlsFindOutMoreTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreCTA"),
            @FindBy(how = How.ID, using = "activeExtraControlFindOutMoreCTA")

    })
    public WebElement ActiveControlsFindOutMoreCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtraControlDescription"),
            @FindBy(how = How.ID, using = "activeExtraControlDescription"),
            @FindBy(how = How.ID, using = "activeExtrasFindMoreExpandableCard")

    })
    public WebElement ActiveControlsDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "noActiveExtraControlDescription"),
            @FindBy(how = How.ID, using = "noControlsTextView")

    })
    public WebElement NoActiveControlsDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "activeExtrasControlCardTitle"),
            @FindBy(how = How.ID, using = "controlsHeaderTextView")

    })
    public WebElement ActiveControlsCardTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "shopCategoryTitle"),
            @FindBy(how = How.ID, using = "shopCategoryTitle")

    })
    public WebElement ControlsCategories;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Turn off']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Turn off']")
    })
    public WebElement turnOffControlCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@label='Manage']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Manage']")
    })
    public WebElement manageSpendManagerControlCTA;
}
