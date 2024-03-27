package pages.NativeExtras.ConfirmBottomSheet;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ConfirmBottomSheetPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenBackArrow"),
            @FindBy(how = How.ID, using = "bottomSheetBackButtonIdentifier"),
            @FindBy(how = How.ID, using = "confirmControlsBackArrow"),

    })
    public WebElement confirmScreenBackArrow;

    @FindAll({
            @FindBy(how = How.ID, using = "confirmScreenCategoryHeader"),
            @FindBy(how = How.ID, using = "confirmScreenCategoryTitle")
    })
    public WebElement confirmScreenCategoryTitle;


//    @FindAll({
//            @FindBy(how = How.ID, using = "confirmScreenXCTA"),
//            @FindBy(how = How.ID, using = "bottomSheetDismissButtonIdentifier")
//
//    })
//    public WebElement confirmScreenXCTA;
//
//    @FindBy(how = How.ID, using = "confirmScreenExtraTitle")
//    public WebElement confirmScreenExtraTitle;
//
//    @FindBy(how = How.ID, using = "confirmScreenExtraAmount")
//    public WebElement confirmScreenExtraAmount;
//
//    @FindBy(how = How.ID, using = "confirmScreenExtraPrice")
//    public WebElement confirmScreenExtraPrice;
//
//    @FindBy(how = How.ID, using = "confirmScreenExtraDescription")
//    public WebElement confirmScreenExtraDescription;

    @FindBy(how = How.ID, using = "confirmScreenMoreInformationTitle")
    public WebElement confirmScreenMoreInformationTitle;

    @FindBy(how = How.ID, using = "confirmScreenMoreInformationDescription")
    public WebElement confirmScreenMoreInformationDescription;

//    @FindBy(how = How.ID, using = "confirmScreenBuyCTA")
//    public WebElement confirmScreenBuyCTA ;
}

