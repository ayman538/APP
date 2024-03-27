package pages.NativeControlsAndLimits.ControlsConfirmBottomSheet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ControlsConfirmBottomSheetPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "confirmControlsBackArrow"),
            @FindBy(how = How.ID, using = "bottomSheetBackButtonIdentifier")

    })
    public WebElement confirmControlsScreenBackArrow;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmControlsXCTA"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier"),
            @FindBy(how = How.ID, using = "confirmControlsXCTA"),
    })
    public WebElement confirmControlsScreenXCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmControlsTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier"),
            @FindBy(how = How.ID, using = "confirmScreenCategoryHeader")

    })
    public WebElement confirmControlsScreenHeaderTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenControlsTitle"),
            @FindBy(how = How.ID, using = "confirmScreenControlsTitle")

    })
    public WebElement confirmControlsScreenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmControlsText"),
            @FindBy(how = How.ID, using = "confirmControlsText")

    })
    public WebElement confirmControlsItem;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenControlsDescription"),
            @FindBy(how = How.ID, using = "confirmScreenControlsDescription")

    })
    public WebElement confirmControlsItemDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenMoreInformationDescription"),
            @FindBy(how = How.ID, using = "")

    })
    public WebElement confirmControlsItemMoreDescription;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenMoreInformationTitle"),
            @FindBy(how = How.ID, using = "")

    })
    public WebElement confirmControlsItemMoreInfoTitle;

}
