package pages.SubsctionOverlay.ChargesTab;

import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class ChargesTabPO extends CommonPo {


    @AndroidFindBy(xpath = "//*[@text='Log in to My Vodafone']")
    @iOSXCUITFindBy(xpath = "//*[@name='Log in to My Vodafone']")
    public WebElement LoginTitle;

    @AndroidFindBy(xpath = "//*[@text='Additional charges']/following::*[@resource-id='com.myvodafoneapp:id/chevron']")
    @iOSXCUITFindBy(xpath = "(//*[@name='Additional charges']/following::*[@type='XCUIElementTypeButton'])[1]")
    public WebElement additionalChargesChevron;

    @AndroidFindBy(xpath = "//*[@text='Additional charges']/following::*[@resource-id='com.myvodafoneapp:id/chevron'][2]")
    @iOSXCUITFindBy(xpath = "(//*[@name='Additional charges']/following::*[@type='XCUIElementTypeButton'])[2]")
    public WebElement additionalChargesNavigationChevron;

    @AndroidFindBy(xpath="//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.TextView")
    @AndroidFindBy(xpath = "//*[@text='Additional charges']/following::*[@resource-id='com.myvodafoneapp:id/header']")
    @iOSXCUITFindBy(id = "Additional charges")
    public WebElement additionalChargesHeader;

    @AndroidFindBy(xpath="//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.ImageView")
    @AndroidFindBy(xpath = "//*[@text='Monthly charges']/following::*[@resource-id='com.myvodafoneapp:id/chevron']")
    @iOSXCUITFindBy(xpath = "(//*[@name='Monthly charges']/following::*[@type='XCUIElementTypeButton'])[1]")
    public WebElement monthlyChargesChevron;

    @AndroidFindAll({
            @AndroidBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"),
            @AndroidBy(xpath = "//*[@text='Additional charges']/following::*[@resource-id='\" + \"com.myvodafoneapp:id/textQuantity']")
    })
    @iOSXCUITFindBy(xpath = "(//*[@name='Additional charges']/following::*[@type='XCUIElementTypeStaticText'])[1]")
    public WebElement additionalChargesQuantity;

    @AndroidFindAll({
            @AndroidBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.view.ViewGroup/android.widget.LinearLayout/android.widget.TextView"),
            @AndroidBy(xpath = "((//*[@text='Monthly charges']/following::*[@resource-id='\" + \"com.myvodafoneapp:id/textQuantity']))[1]")
    })
    @iOSXCUITFindBy(xpath = "(//*[@name='Monthly charges']/following::*[@type='XCUIElementTypeStaticText'])[1]")
    public WebElement monthlyChargesQuantity;

    @iOSXCUITFindBy(xpath = "(//*[@name='Monthly charges']/following::*[@type='XCUIElementTypeStaticText'])[2]")
    @AndroidFindBy(id = "com.myvodafoneapp:id/subTitle")
    public WebElement monthlyChargesSubtile;

    @AndroidFindBy(xpath = "//*[@text='Monthly charges']")
    @iOSXCUITFindBy(xpath = "//*[@label='Monthly charges']")
    public WebElement monthlyChargesTile;

    @AndroidFindBy(xpath = "//*[@text='My plan']")
    @iOSXCUITFindBy(id = "My plan")
    public WebElement monthlyChargesPlan;

    @AndroidFindAll({
            @AndroidBy(xpath = "//androidx.viewpager.widget.ViewPager/android.widget.FrameLayout/android.widget.ScrollView/android.view.ViewGroup/android.widget.FrameLayout[3]/android.view.ViewGroup/android.widget.TextView[2]"),
            @AndroidBy(id = "com.myvodafoneapp:id/totalTvQuantity")
    })
    @iOSXCUITFindBy(xpath = "(//*[@name='Total estimated charges']/following::*[@type='XCUIElementTypeStaticText'])[1]")
    public WebElement totalEstimatedChargesQuantity;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/rhombus_close_button"),
            @AndroidBy(id = "com.myvodafoneapp:id/closeImg")
    })
    @iOSXCUITFindBy(id= "closeIcon")
    public WebElement loginCloseIcon;

    @AndroidFindBy(id= "com.myvodafoneapp:id/filterContainer")
    @iOSXCUITFindBy(xpath = "(//*[@name='chevron right icon'])")
    public WebElement detailsChevronInItemizedView;

    @AndroidFindBy(xpath = "((//*[@resource-id='" + "com.myvodafoneapp:id/firstFilterItemTextView']))[1]")
    @iOSXCUITFindBy(id= "Newest first")
    public WebElement additionalFirstFilter;

    @AndroidFindBy(xpath = "((//*[@resource-id='" + "com.myvodafoneapp:id/firstFilterItemTextView']))[2]")
    @iOSXCUITFindBy(id = "Oldest first")
    public WebElement additionalSecondFilter;

    @AndroidFindBy(xpath = "((//*[@resource-id='" + "com.myvodafoneapp:id/firstFilterItemTextView']))[3]")
    @iOSXCUITFindBy(id = "Highest price first")
    public WebElement additionalThirdFilter;

    @AndroidFindBy(xpath = "((//*[@resource-id='" + "com.myvodafoneapp:id/firstFilterItemTextView']))[4]")
    @iOSXCUITFindBy(id = "Lowest price first")
    public WebElement additionalFourthFilter;

    @AndroidFindBy(id= "com.myvodafoneapp:id/loadMoreButton")
    @iOSXCUITFindBy(xpath = "//*[@name='Load more']")
    public WebElement additionalChargesLoadMoreCTA;

    @AndroidFindBy(xpath = "//*[@text='Calls']")
    @iOSXCUITFindBy(xpath = "//*[@name='Calls']")
    public WebElement Calls;

    @AndroidFindBy(xpath = "//*[@text='Texts']")
    @iOSXCUITFindBy(xpath = "//*[@name='Texts']")
    public WebElement Texts;

    @AndroidFindBy(xpath = "//*[@text='Data']")
    @iOSXCUITFindBy(xpath = "//*[@name='Data']")
    public WebElement Data;

    @AndroidFindBy(xpath = "//*[@text='Other']")
    @iOSXCUITFindBy(xpath = "//*[@name='Other']")
    public WebElement Other;

    public ChargesTabPO() {
        super();
    }
}
