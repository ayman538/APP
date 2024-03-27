package pages.SubsctionOverlay.GroupData;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class GroupDataPO extends CommonPo {


    @AndroidFindBy(xpath= "(//*[@resource-id='com.myvodafoneapp:id/wdgManageGroupDataCard'])[1]")
    @iOSXCUITFindBy(id= "wdgGroupDataCard")
    @iOSXCUITFindBy(id= "wdgTabContent_Group Data")
    public WebElement GD_GroupDataCard;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtGropDataTitle")
    @iOSXCUITFindBy(id= "txtGropDataTitle")
    public WebElement GD_GroupDataTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtGropDataSubTitle")
    @iOSXCUITFindBy(id= "txtGropDataSubTitle")
    public WebElement GD_GroupDataSubTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtGropDataSubItemValue")
    @iOSXCUITFindBy(id= "txtGropDataSubItemValue")
    public WebElement GD_GroupDataSubItemsValue;

    @AndroidFindBy(id= "com.myvodafoneapp:id/imgGroupDataSubItemBar")
    @iOSXCUITFindBy(id= "imgGroupDataSubItemBar")
    public WebElement GD_GroupDataSubItemsBar;

    @AndroidFindBy(id= "com.myvodafoneapp:id/imgGroupDataSubItemIcon")
    @iOSXCUITFindBy(id= "imgGroupDataSubItemIcon")
    public WebElement GD_GroupDataSubItemsIcon;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtManageGropDataHeader")
    @iOSXCUITFindBy(id= "txtManageGropDataHeader")
    public WebElement GD_manageGroupDataTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/sharer_synced_ctn_textView")
    @iOSXCUITFindBy(id= "txtManageGropDataTitle")
    public WebElement GD_manageGroupDataCardTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtManageGropDataScreenHeader")
    @iOSXCUITFindBy(id= "txtScreenTitle")
    public WebElement MGD_title;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtManageGropDataScreenTitle")
    @iOSXCUITFindBy(id= "txtManageGropDataScreenTitle")
    public WebElement MGD_CardTitle;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtSeekIndicator")
    @iOSXCUITFindBy(id= "imgManageGroupDataSceenBar")
    public WebElement MGD_setLimitValue;

    @AndroidFindBy(id= "com.myvodafoneapp:id/imgGroupDataSubItemBar")
    @iOSXCUITFindBy(id= "imgManageGroupDataSceenBar")
    public WebElement MGD_CardBar;

    @AndroidFindBy(id= "com.myvodafoneapp:id/btnManageGroupDataScreenCTA")
    @iOSXCUITFindBy(id= "btnManageGroupDataScreenCTA")
    public WebElement MGD_CardSendTextCTA;

    @AndroidFindBy(id= "com.myvodafoneapp:id/txtManageGropDataScreenFooter")
    @iOSXCUITFindBy(id= "txtManageGropDataScreenFooter")
    public WebElement MGD_CardFooter;

    @AndroidFindBy(id= "com.myvodafoneapp:id/backImageView")
    @iOSXCUITFindBy(id= "backIcon")
    public WebElement MGD_BackIcon;

    @AndroidFindBy(xpath= "(//*[@resource-id='com.myvodafoneapp:id/arrow_imageView'])")
    @iOSXCUITFindBy(id= "arrow_imageView")
    @iOSXCUITFindBy(id= "chevron right icon")
    public WebElement GD_ManageGroupDataSharerArrow;

    public GroupDataPO() {
        super();
    }
}
