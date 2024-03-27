package pages.RedHybrid.DashboardTray;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Tray.DashboardTray.DashboardTrayPO;

public class RedHybrid_DashboardTray_PO extends DashboardTrayPO {

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payments']"),
            @FindBy(how = How.ID, using = "Payments")
    })
    public WebElement DB_PaymentsTray;

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = "android.view.View"),
            @FindBy(how = How.ID, using = "Payments")
    })
    public WebElement VerymeView;

    @FindAll({

            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSubSwitchSelectOneTitle"),
            @FindBy(how = How.ID, using = "txtSubSwitchSelectOneTitle")
    })
    public WebElement selctOne;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payment method']"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/paymentMethodHeader"),
            @FindBy(how = How.ID, using = "Payment method"),
            @FindBy(how = How.ID_OR_NAME, using = "paymentMethodHeader")


    })
    public WebElement Payment_method_icon;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/offerImageView"),
            @FindBy(how = How.ID_OR_NAME, using = "imgDrawerSettingsSubIcon")

    })
    public WebElement offersImageView;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Settings']"),
            @FindBy(how = How.ID, using = "Settings")
    })
    public WebElement RH_AppSettingsTray;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    //should be deleted as it is duplicate at add new payment po
    public WebElement RedHybrid_PaymentTitle_2;

}
