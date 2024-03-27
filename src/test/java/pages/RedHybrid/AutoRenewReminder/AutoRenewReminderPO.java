package pages.RedHybrid.AutoRenewReminder;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

import java.util.List;

public class AutoRenewReminderPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.ID, using = "userType_icon"),
            @FindBy(how = How.ID, using = "DXIDMSubsOverlayXIcon")
    })
    public WebElement RedHybrid_reminderOverlayIcon;

    @FindAll({
            @FindBy(how = How.ID, using = "tabSubscriptionMenuItem"),
            @FindBy(how = How.ID, using = "tabSubscriptionMenuItem")
    })
    public WebElement planTab;

    @FindAll({
            @FindBy(how = How.ID, using = "Plan"),
            @FindBy(how = How.XPATH, using = "//android.widget.LinearLayout[@content-desc='Plan']"),
            @FindBy(how = How.XPATH, using = "//*[@text='Your Plan']"),
            @FindBy(how = How.ID, using = "txtPlanListItemTitle"),
            @FindBy(how = How.ID, using = "txtPlanListItemTitle")
    })
    public WebElement planTitle;

}
