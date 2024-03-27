package pages.DX_IDM.SubsOverlay;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class DX_IDM_SubsOverlayPO extends CommonPo {


    @AndroidFindBy(xpath = "(//*[@class='android.widget.ImageView'])[2]")
    @iOSXCUITFindBy(id = "icCloseWhite")
    public WebElement DX_IDM_SubsOverlay_CloseIcon;

    @AndroidFindBy(id = "com.myvodafoneapp:id/txtDXIDMSubsOverlay_HeaderTitle")
    @iOSXCUITFindBy(id = "Hello friend!")
    public WebElement DX_IDM_SubsOverlay_HeaderTitle;

    @iOSXCUITFindBy(xpath = "//*[@label='Sign in: Voxi.co.uk']")
    @AndroidFindBy(xpath = "(//*[@class='android.widget.Button'])[1]")
    @iOSXCUITFindBy(id = "CVMconfirmButton")
    public WebElement DX_IDM_SubsOverlay_VisitButton;

    @AndroidFindBy(xpath = "//*[@text='Return to My Vodafone']")
    @AndroidFindBy(id = "com.myvodafoneapp:id/DXIDMSubsOverlay_Button")
    @iOSXCUITFindBy(xpath = "//*[@label='Return to My Vodafone']")
    public WebElement DX_IDM_SubsOverlay_ReturnToMyVodafoneButton;

    @AndroidFindBy(xpath = "//*[@text='Log in']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_UnKnownLoginButton;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[1]")
    @AndroidFindBy(xpath = "//*[@text='Login to my Vodafone']")
    @iOSXCUITFindBy(id = "txtAcquisitionNewDBTile_Pay monthly phones")
    public WebElement DX_IDM_LoginTitle;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[3]")
    @AndroidFindBy(id = "com.myvodafoneapp:id/dealTitle")
    public WebElement DX_IDM_PayMonthly;

    @AndroidFindBy(id = "com.sec.android.app.sbrowser:id/location_bar_edit_text")
    @AndroidFindBy(xpath = "//*[@text='www.voxi.co.uk']")
    public WebElement WebPortal;


    public DX_IDM_SubsOverlayPO() {
        super();
    }
}
