package pages.SubsctionOverlay.NewPlanDesign.OneNumberCard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class OneNumberCardPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/controlText"),
            @FindBy(how = How.XPATH, using = "//*[@label='Your Plan']")

    })
    public WebElement SO_PlanTabContent;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnPlanCTA"),
            @FindBy(how = How.XPATH, using = "//*[@text='Get connected']")
    })
    public WebElement Plan_OneNumber_GetConnected;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Find out more']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Find out more']")
    })
    public WebElement Plan_OneNumber_Findoutmore;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='" + "com.myvodafoneapp:id/btnPlanCTA' and @text='Manage Devices']"),
            @FindBy(how = How.ID, using = "planCardCTA_2_0")
    })
    public WebElement Plan_OneNumber_Managedevices;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanTitle"),
            @FindBy(how = How.XPATH, using = "//*[@text='Vodafone OneNumber']")
    })
    public WebElement Plan_OneNumber_title;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtPlanDetails"),
            @FindBy(how = How.XPATH, using = "//*[@text='Our Service that lets you share your mobile number and allowance across a range of different devices.']")
    })
    public WebElement Plan_OneNumber_description;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgOneNumberImage"),

    })
    public WebElement Plan_OneNumber_Hero_Image;



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDMSkipLogin_Button"),
            @FindBy(how = How.XPATH, using = "//*[@text='Skip Login']")


    })
    public WebElement SkipLoginCTA;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/DXIDMSubsOverlay_Button"),
            @FindBy(how = How.XPATH, using = "//*[@text='Return to My Vodafone']")


    })
    public WebElement ReturnToMyVodafoneCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.android.chrome:id/toolbar"),



    })
    public WebElement GetConnected_WebView;

    @FindAll({
            @FindBy(how = How.ID, using = "com.android.chrome:id/toolbar"),



    })
    public WebElement FindOutMore_WebView;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/one_number_title"),
            @FindBy(how = How.XPATH, using = "//*[@name='one_number_title']")
    })
    public WebElement OneNumber_Title;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/one_number_description"),
            @FindBy(how = How.XPATH, using = "//*[@name='one_number_description']")
    })
    public WebElement OneNumber_Body;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/one_number_video_thumbnail"),
            @FindBy(how = How.XPATH, using = "//*[@name='one_number_video_thumbnail']")
    })
    public WebElement OneNumber_Image;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/one_number_connections"),
            @FindBy(how = How.XPATH, using = "//*[@name='one_number_connections']")
    })
    public WebElement OneNumber_Connections;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/one_number_icon"),
            @FindBy(how = How.XPATH, using = "//*[@name='one_number_icon']")
    })
    public WebElement OneNumber_Icon;

    public OneNumberCardPO() {
        super();
    }
}
