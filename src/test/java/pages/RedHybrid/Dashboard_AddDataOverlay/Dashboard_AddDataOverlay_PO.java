package pages.RedHybrid.Dashboard_AddDataOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class Dashboard_AddDataOverlay_PO extends CommonPo {


    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/controlText"),
            @FindBy(how = How.XPATH, using = "//*[@text='Add Data']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add Data']")

    })
    public WebElement AddDashboardDataTile;


    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addDataSubtitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Buy more data']"),
            @FindBy(how = How.ID, using = "SelectExtraOverlySubTitle")

    })
    public WebElement addDataExtraTitle;

    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dataItemRootId"),
            @FindBy(how = How.ID, using = "SelectExtraOverlyChooseExtraView_0")


    })
    public WebElement firstDataOption;
    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dataItemRootId"),
            @FindBy(how = How.ID, using = "SelectExtraOverlyChooseExtraView_1")



    })
    public WebElement secondtDataOption;
    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addDataCTAsContainer"),
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Continue']")

    })
    public WebElement addingDataCTA;


    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Add data']"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")

    })
    public WebElement AddDataTitle;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@text='Extra 1GB data (monthly)']"),
            @FindBy(how = How.XPATH, using = "Extra 1GB data (monthly)"),



    })
    public WebElement SecondOptionName;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@text='Extra 2GB data (monthly)']"),
            @FindBy(how = How.ID, using = "Extra 2GB data (monthly)")


    })
    public WebElement FirstOptionName;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement screenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addDataList"),
            @FindBy(how = How.ID, using = "listOfDataOptions")
    })

    public WebElement listOfDataOptions;

}
