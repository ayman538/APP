package pages.Dashboard.NewVOV;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class RemoveVOVPO extends CommonPo {

    @AndroidFindBy(id = "com.myvodafoneapp:id/closeButton")
    @iOSXCUITFindBy(id = "btnVOVHideCTA")
    public WebElement DB_VOVhideCTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/dashboard_VOV_message_label")
    @iOSXCUITFindBy(id = "txtVOVDescription")
    public WebElement DB_VOVDescription;

    @AndroidFindBy(xpath = "//*[@text='My Account']")
    @iOSXCUITFindBy(id = "My Account")
    public WebElement DB_MyAccountTray_icon;

    @AndroidFindBy(xpath = "//*[@text='Home Phone']")
    @iOSXCUITFindBy(xpath = "//*[@label='Home Phone']")
    public WebElement GetFLNUser;

    @AndroidFindBy(xpath = "//*[@text='Broadband']")
    @iOSXCUITFindBy(xpath = "//*[@label='Broadband']")
    public WebElement GetHBBUser;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//*[@text='Pay monthly'])[2]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView//*[@label='Pay monthly'])[2]")
    public WebElement PayMChild;

    @AndroidFindBy(xpath = "(//androidx.recyclerview.widget.RecyclerView//*[@text='Pay monthly'])[1]")
    @iOSXCUITFindBy(xpath = "(//XCUIElementTypeCollectionView//*[@label='Pay monthly'])[1]")
    public WebElement PayMChildAfterScroll;

    @AndroidFindBy(xpath = "//*[@text='Pay as you go']")
    @iOSXCUITFindBy(xpath = "//*[@label='Pay as you go']")
    public WebElement GetPaygUser;

    @AndroidFindBy(id = "subscriptionType")
    @iOSXCUITFindBy(id = "txtSubscriptionAccountType")
    public WebElement SelectedUserType;

    @AndroidFindBy(id = "com.myvodafoneapp:id/subscriptionsRecyclerView")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "Horizontal scroll bar 2 pages"),
            @iOSXCUITBy(id = "Horizontal scroll bar 3 pages")
    })
    public WebElement GetSubscription_List;

    @AndroidFindBy(id = "bottomSheetDismissButtonIdentifier")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "closePartialImageView"),
            @iOSXCUITBy(id = "closeIcon")
    })
    public WebElement MyAccountXIcon;
}
