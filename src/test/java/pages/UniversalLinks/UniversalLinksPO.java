package pages.UniversalLinks;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class UniversalLinksPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Usage']"),
            @FindBy(how = How.ID, using = "btnCloseCTA")
    })
    public WebElement usageTab;
    @FindAll({
            @FindBy(how = How.XPATH, using = " //*[@text='Need some help?']"),
            @FindBy(how = How.ID, using = "btnCloseCTA")
    })
    public WebElement needSomeHelpTitle;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Top up']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Top up']"),
    })

    public WebElement topUpTab;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Extras']"),
            @FindBy(how = How.ID, using = "btnCloseCTA")
    })
    public WebElement extrasTab;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/vodafoneLogoImageView"),
            @FindBy(how = How.ID, using = "btnCloseCTA")
    })
    public WebElement vodafoneLogoImageView;
    @FindAll({
            @FindBy(how = How.XPATH, using = "(//*[@class='android.widget.Button'])[1]"),
            @FindBy(how = How.XPATH, using = "XCUIElementTypeButton[@name='\uDB80\uDD56']")
    })
    public WebElement Trade_XIcon;

    public UniversalLinksPO() {
        super();
    }

}
