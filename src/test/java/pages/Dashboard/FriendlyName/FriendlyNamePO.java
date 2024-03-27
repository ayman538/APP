package pages.Dashboard.FriendlyName;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class FriendlyNamePO extends CommonPo {
    public FriendlyNamePO() {
        super();
    }
    @AndroidFindBy(id = "friendlyNamePencilImageView")
    @iOSXCUITFindBy(id = "ic pencil white")
    public WebElement DB_PencilIcon;

    @AndroidFindAll({
            @AndroidBy(xpath = "*//android.view.ViewGroup/android.widget.EditText"),
            @AndroidBy(id = "friendlyNameEditText")
    })
    @iOSXCUITFindBy(xpath = "*//XCUIElementTypeOther[1]/XCUIElementTypeTextField")
    public WebElement FriendlyNameText;

    @AndroidFindBy(xpath = "*//android.widget.LinearLayout/android.widget.Button")
    @iOSXCUITFindBy(id = "action_0")
    public WebElement FriendlyNameSaveCTA;

    @AndroidFindBy(id = "pendingDescription")
    @iOSXCUITFindBy(id = "traySuccessNotification")
    public WebElement FriendlyNameUpdatingScreen;

    @AndroidFindBy(id = "continueFriendlyNameCTA")
    @iOSXCUITFindBy(id = "action_0")
    public WebElement UpdatingScreenClosCTA;

    @AndroidFindBy(id = "pendingDescription")
    @iOSXCUITFindBy(id = "traySuccessNotification")
    public WebElement FriendlyNamePendingScreen;

    @AndroidFindBy(id = "friendlyNameValidationError")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[contains (@name 'less than')]")
    public WebElement InvalidFriendlyNameMsg;

    @AndroidFindBy(id = "subscription_info_container")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name=\"subscription_info_container\"]")
    public WebElement SubscriptionInfoContainer;
}
