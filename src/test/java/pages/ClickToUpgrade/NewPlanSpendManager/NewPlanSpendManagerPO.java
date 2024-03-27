package pages.ClickToUpgrade.NewPlanSpendManager;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class NewPlanSpendManagerPO extends CommonPo {

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerHeader")
    @iOSXCUITFindBy(id = "spendManagerHeader")
    public WebElement C2U_spendManagerHeader;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerText")
    @iOSXCUITFindBy(id = "spendManagerText")
    public WebElement C2U_spendManagerText;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerNewPlanPriceLabel")
    @iOSXCUITFindBy(id = "spendManagerNewPlanPriceLabel")
    public WebElement C2U_spendManagerNewPlanPriceLabel;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerNewPlanPrice")
    @iOSXCUITFindBy(id = "spendManagerNewPlanPrice")
    public WebElement C2U_spendManagerNewPlanPrice;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerNewPlanPriceCycle")
    @iOSXCUITFindBy(id = "spendManagerNewPlanPriceCycle")
    public WebElement C2U_spendManagerNewPlanPriceCycle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerSpendLimitsLabel")
    @iOSXCUITFindBy(id = "spendManagerSpendLimitsLabel")
    public WebElement C2U_spendManagerSpendLimitsLabel;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_spendLimit_item")
    @iOSXCUITFindBy(id = "spendManagerSpendLimitsMenu")
    public WebElement C2U_spendManagerSpendLimitsMenu;

    @AndroidFindBy(xpath= "//*[@text='Unlimited']")
    @iOSXCUITFindBy(xpath= "//XCUIElementTypeApplication[@name='My Vodafone']/XCUIElementTypeWindow[3]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypePicker/XCUIElementTypePickerWheel")
    public WebElement C2U_spendManagerSpendLimitsMenuUnlimitedOption;

    @AndroidFindBy(id = "com.myvodafoneapp:id/spendManagerPostSelectionMsg")
    @iOSXCUITFindBy(id = "spendManagerPostSelectionMsg")
    public WebElement C2U_spendManagerPostSelectionMsg;

    @AndroidFindBy(id = "com.myvodafoneapp:id/tv_terms_label")
    @iOSXCUITFindBy(id = "TermsAndConditionsTitle")
    public WebElement newPlanTermAndCondTitle;
}
