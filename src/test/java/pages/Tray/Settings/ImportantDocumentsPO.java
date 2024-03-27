package pages.Tray.Settings;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ImportantDocumentsPO extends CommonPo {
    public ImportantDocumentsPO() {
        super();
    }

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Important documents']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Important documents']")
            // TODO : find locator
    })
    public WebElement AS_ImportantDocuments;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Important documents']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Important documents']")
            // TODO : find locator
    })
    public WebElement SSO_ImportantDocuments;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Account']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Account']"),
            @FindBy(how = How.XPATH, using ="//*[@text='Account settings']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Account settings']")
    })
    public WebElement AS_AccountSetting;



}
