package pages.SubsctionOverlay.B2B_ChevronViewOfLoans;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ChevronViewOfLoansPO extends CommonPo {

    @AndroidFindBy(xpath = "(//*/android.widget.LinearLayout[1]/android.widget.ImageView)[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Button\"])[1]")
    public WebElement chevronIconOfFirstLoan;

    @AndroidFindBy(xpath = "(//*/android.widget.LinearLayout[1]/android.widget.ImageView)[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Button\"])[2]")
    public WebElement chevronIconOfSecondLoan;

    @AndroidFindBy(id= "bingoView")
    @iOSXCUITFindBy(xpath = "//*[@label='Includes']")
    public WebElement extrasSection;

    @AndroidFindBy(id= "com.myvodafoneapp:id/btnActionCTA")
    @iOSXCUITFindBy(xpath = "//*[@label='Manage Device plans']")
    public WebElement ManageDevicePlansCTA;
}
