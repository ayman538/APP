package pages.StrategicTradeIn;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class StrategicTradeInPO extends CommonPo {
    public StrategicTradeInPO() {super();
    }

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtAcquisitionNewDB_HeaderTitle"),
            @FindBy(how = How.ID, using = "txtAcquisitionNewDB_HeaderTitle")
    })
    public WebElement Acquisition_NewDB_Header_Title;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Find out more']"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeStaticText[@name='Find out more'])[1]")
    })
    public WebElement Acquisition_NewDB_StrategicTradeInFindOutMoreBtn;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Trade-in Tool']"),
            @FindBy(how = How.ID, using = "txtAcquisitionNewDBTile_Trade-in Tool")

    })
    public WebElement TradeInIcon;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Trade In Tool']"),
            @FindBy(how = How.ID, using = "txtDashboardLinksMenuCellLabel_Trade In Tool")
    })
    public WebElement DB_TradeInLink;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Get a trade-in quote']"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name='Get a trade-in quote']")
    })
    public WebElement strategicTradeInTitle;
}
