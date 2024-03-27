package pages.PushNotification;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class PushNotificationPo extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "android:id/title"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement pushNotificationItem;

    @FindAll({
            @FindBy(how = How.ID, using = "android:id/text"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement NotificationText;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp.dev:id/INBOX_DETAILS_TITLE"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement MessageCenterTopLabel;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp.dev:id/splash_animation_view"),
            @FindBy(how = How.ID, using = "")
    })
    public WebElement SplashScreen;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@text='Device plan']"),

            @FindBy(how = How.ID, using = "Device plan")

    })
    public WebElement SO_DevicePlanTab;

    @FindAll({

            @FindBy(how = How.XPATH, using = "//*[@type='submit']"),

            @FindBy(how = How.XPATH, using = "//*[@type='submit']")

    })
    public WebElement Google_search_btn;


    public PushNotificationPo() {
        super();
    }


}
