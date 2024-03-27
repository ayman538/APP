package pages.NativeExtras.CategoryBottomSheet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class CategoryBottomSheetPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "closePartialIV"),
            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/closePartialImageView"),
            @FindBy(how = How.ID, using = "confirmScreenXCTA"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/closePartialImageView"),
            @FindBy(how = How.ID, using = "controlsListHeaderXCTA")
    })
    public WebElement extrasCategoryXCTA;

    @FindBy(how = How.ID, using = "rvExtraServiceCategoryGroups")
    public WebElement extrasCategoryCardDetailsSection;

    @FindBy(how = How.ID, using = "extrasCategoryDetailsName")
    public WebElement extrasCategoryDetailsName;

    @FindBy(how = How.ID, using = "extrasCategoryDetailsDescription")
    public WebElement extrasCategoryDetailsDescription;

    @FindBy(how = How.ID, using = "rvExtraSubCategoryGroups")
    public WebElement extraCategorySelectionCard;

    @FindBy(how = How.ID, using = "dataItemName")
    public WebElement extrasCategoryAmount;

    @FindBy(how = How.ID, using = "dataItemValidity")
    public WebElement extrasCategoryPrice;

    @FindBy(how = How.ID, using = "dataItemSelectionButton")
    public WebElement extrasCategorySelectionButton;

    @FindAll({
            @FindBy(how = How.ID, using = "extrasCategoryContinueCTA")
    })
    public WebElement extrasCategoryContinueCTA;
}
