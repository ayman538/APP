package pages.Dashboard.RelocateInboxRemoveGreeting;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RelocateInboxRemoveGreetingPO extends CommonPo {

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/messagesCountTextView")
            @iOSXCUITFindBy(id = "imgVOVCount")
    
    public WebElement DB_UserGreetingIcon;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/salutationTextView")
            @iOSXCUITFindBy(id = "txtDashboardSalutation")
    
    public WebElement DB_UserGreetingDescription;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/notificationsImageView")
            @iOSXCUITFindBy(id = "notificationsImageView")
    
    public WebElement DB_NewInboxIcon;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/notificationsImageView")
            @iOSXCUITFindBy(id = "receivedNotificationsLabel")
    
    public WebElement DB_NewInboxDescription;
}
