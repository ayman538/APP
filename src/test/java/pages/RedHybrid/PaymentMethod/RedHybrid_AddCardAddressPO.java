package pages.RedHybrid.PaymentMethod;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_AddCardAddressPO extends CommonPo {


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/UKPostcodeTitle"),
            @FindBy(how = How.ID, using = "Postcode (UK only)")
    })
    public WebElement RedHybrid_UKPostcodeTitle;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/enterAddressCTA"),
            @FindBy(how = How.ID, using = "Enter address manually")
    })
    public WebElement RedHybrid_enterAddressCTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/selectAddressTitle"),
            @FindBy(how = How.ID, using = "Select an address")
    })
    public WebElement RedHybrid_selectAddressTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "android:id/text1"),
            @FindBy(how = How.XPATH, using = "//*[@name='Select an address']/following::*[@type='XCUIElementTypeTextField']")
    })
    public WebElement RedHybrid_selectAddressTextField;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/selectAddressDropdown"),
            @FindBy(how = How.ID, using = "selectAddressDropdown")
    })
    public WebElement RedHybrid_selectAddressDropdown;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/selectAddressDropdownDone"),
            @FindBy(how = How.ID, using = "Done")
    })
    public WebElement RedHybrid_selectAddressDropdownDone;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Choose one...']"),
            @FindBy(how = How.ID, using = "Toolbar")
    })
    public WebElement RedHybrid_selectAddressDropdownChooseOne;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/flatNoTitle"),
            @FindBy(how = How.ID, using = "Flat number")
    })
    public WebElement RedHybrid_flatNoTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtflatNo"),
            @FindBy(how = How.XPATH, using = "//*[@name='Flat number']/following::*[@type='XCUIElementTypeTextField'][1]")
    })
    public WebElement RedHybrid_flatNoText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/flatNoHint"),
            @FindBy(how = How.ID, using = "flatNoHint")
    })
    public WebElement RedHybrid_flatNoHint;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/houseNameTitle"),
            @FindBy(how = How.ID, using = "House name")
    })
    public WebElement RedHybrid_houseNameTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txthouseName"),
            @FindBy(how = How.XPATH, using = "//*[@name='House name']/following::*[@type='XCUIElementTypeTextField'][1]")
    })
    public WebElement RedHybrid_houseNameText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/fiftyCharHint"),
            @FindBy(how = How.ID, using = "fiftyCharHint")
    })
    public WebElement RedHybrid_50CharHint;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/houseNoTitle"),
            @FindBy(how = How.ID, using = "House number")
    })
    public WebElement RedHybrid_houseNoTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txthouseNo"),
            @FindBy(how = How.XPATH, using = "//*[@name='House number']/following::*[@type='XCUIElementTypeTextField'][1]")
    })
    public WebElement RedHybrid_houseNoText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/streetNameTitle"),
            @FindBy(how = How.ID, using = "Street name")
    })
    public WebElement RedHybrid_streetNameTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtstreetName"),
            @FindBy(how = How.XPATH, using = "//*[@name='Street name']/following::*[@type='XCUIElementTypeTextField'][1]")
    })
    public WebElement RedHybrid_streetNameText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/townTitle"),
            @FindBy(how = How.ID, using = "Town/city")
    })
    public WebElement RedHybrid_townTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txttown"),
            @FindBy(how = How.XPATH, using = "//*[@name='Street name']/following::*[@type='XCUIElementTypeTextField'][2]")
    })
    public WebElement RedHybrid_townText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/countryTitle"),
            @FindBy(how = How.ID, using = "County")
    })
    public WebElement RedHybrid_countryTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtcountry"),
            @FindBy(how = How.XPATH, using = "//*[@name='Street name']/following::*[@type='XCUIElementTypeTextField'][3]")
    })
    public WebElement RedHybrid_countryText;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/postcodeTitle"),
            @FindBy(how = How.ID, using = "Postcode")
    })
    public WebElement RedHybrid_postcodeTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtpostcode"),
            @FindBy(how = How.XPATH, using = "//*[@name='Street name']/following::*[@type='XCUIElementTypeTextField'][4]")
    })
    public WebElement RedHybrid_postcodeText;


    public RedHybrid_AddCardAddressPO() {
        super();
    }
}
