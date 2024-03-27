package pages.NativeControlsAndLimits.ControlsCategoryBottomSheet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.List;

public class ControlsCategoryBottomSheetPO extends CommonPo{
    @FindAll({
            @FindBy(how = How.ID, using = "controlsListHeaderTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"),
            @FindBy(how = How.ID, using = "confirmScreenCategoryHeader"),

    })
    public WebElement controlsCategoryScreenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsListHeaderXCTA"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier"),
    })
    public WebElement controlsCategoryScreenXCTA;


    @FindAll({
            @FindBy(how = How.ID, using = "controlsTrayItem"),
            @FindBy(how = How.ID, using = "controlsTrayItem")
    })
    public WebElement controlsCategoryItem;


    @FindAll({
            @FindBy(how = How.ID, using = "controlsListTitle"),
            @FindBy(how = How.ID, using = "controlsListTitle")
    })
    public WebElement controlsCategoryTitle;

    /*
    @FindAll({
            @FindBy(how = How.ID, using = "controlsTrayItemTitle"),
            @FindBy(how = How.ID, using = "controlsTrayItemTitle")
    })
    public List<WebElement> controlsCategoryItemTitle;

     */

    @FindAll({
            @FindBy(how = How.ID, using = "controlsTrayItemArrow"),
            @FindBy(how = How.ID, using = "controlsTrayItemArrow")
    })
    public WebElement controlsCategoryItemArrow;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsSubListHeaderBackArrow"),
            @FindBy(how = How.ID, using = "bottomSheetBackButtonIdentifier")
    })
    public WebElement controlsSubCategoryScreenBackCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsSubListHeaderXCTA"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
    })
    public WebElement controlsSubCategoryScreenXCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsSubListHeaderTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement controlsSubCategoryScreenHeaderTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsSubListTitle"),
            @FindBy(how = How.ID, using = "controlsListTitle")
    })
    public WebElement controlsSubCategoryTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsSubListDescription"),
            @FindBy(how = How.ID, using = "controlsListDescription")
    })
    public WebElement controlsSubCategoryDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsTrayItemTitle"),
            @FindBy(how = How.ID, using = "controlsTrayItemTitle")
    })
    public List<WebElement> controlsSubCategoryItemTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "controlsTrayItemArrow"),
            @FindBy(how = How.ID, using = "controlsTrayItemArrow")
    })
    public WebElement controlsSubCategoryItemArrow;
}
