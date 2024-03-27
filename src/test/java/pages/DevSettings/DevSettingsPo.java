package pages.DevSettings;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class DevSettingsPo extends CommonPo {



    @AndroidFindBy(id = "com.myvodafoneapp:id/hardcoded_msisdn_text")
    @iOSXCUITFindBy(id = "txtDevSetMSISDNfield")
    public WebElement DevSett_MSISDN;


   @AndroidFindBy(id = "com.myvodafoneapp:id/ed_result")
   @iOSXCUITFindBy(id = "txtDevSetPopupTextField")
    public WebElement DevSett_MSISDN_textfield;


    @AndroidFindBy(id = "com.myvodafoneapp:id/btn_save")
    @iOSXCUITFindBy(id = "btnDevSetPopupDoneCTA")
    protected WebElement DevSett_MSISDN_Save_CTA;


   @AndroidFindBy(id = "com.myvodafoneapp:id/network_source_spinner")
   @iOSXCUITFindBy(id = "Server")
    public WebElement DevSett_Server;

    @AndroidFindBy(id = "com.myvodafoneapp:id/reinvent_host_spinner")
    @iOSXCUITFindBy(id = "Reinvent Servers")
    public WebElement DevSett_ReinventServer;



   @AndroidFindBy(xpath = "(//*[@resource-id='android:id/text1'])")
   @iOSXCUITFindBy(xpath = "//*[@name='Server']/following::*[@type='XCUIElementTypeStaticText'][1]")
    public WebElement DevSett_ServerValue;


   @AndroidFindBy(id = "com.myvodafoneapp:id/vf_btn_save")
   @iOSXCUITFindBy(xpath = "//*[@name='btnSaveAndRestart']")
   @iOSXCUITFindBy(xpath = "//*[@label='Save & Restart']")
    public WebElement DevSett_Save;


    @AndroidFindBy(xpath = "//*[@text='INT-1']")
    @iOSXCUITFindBy(id = "INT-1")
    public WebElement DevSett_Server_INT1;


   @AndroidFindBy(xpath = "//*[@text='PROD_SUP']")
   @iOSXCUITFindBy(id = "Prodsup")
    public WebElement DevSett_Server_PRODSUP;


   @AndroidFindBy(xpath = "(//*[@text='Qc-1']")
   @iOSXCUITFindBy(xpath = "//*[@name='QC-1']")
    public WebElement DevSett_Server_QC1;

    @AndroidFindBy(xpath = "//*[@text='Qc-2']")
    @iOSXCUITFindBy(xpath = "//*[@name='QC-2']")
    public WebElement DevSett_Server_QC2;


   @AndroidFindBy(xpath = "//*[@text='Qc-x']")
   @iOSXCUITFindBy(xpath = "//*[@name='QC-x']")
    public WebElement DevSett_Server_QCX;

   @AndroidFindBy(xpath = "//*[@text='QcX']")
    public WebElement DevSett_ReinventServer_QCX;


  @AndroidFindBy(id = "com.myvodafoneapp:id/network_type_spinner")
  @iOSXCUITFindBy(id= "Connection type")
    public WebElement DevSett_ConnectionType;


   @AndroidFindBy(xpath = "//*[@text='Tcc6']")
   @iOSXCUITFindBy(xpath= "//*[@name='tcc6-']")
    public WebElement DevSett_TCC6;


   @AndroidFindBy(xpath = "//*[@text='Tcc7']")
   @iOSXCUITFindBy(xpath= "//*[@name='tcc7-']")
    public WebElement DevSett_TCC7;


   @AndroidFindBy(xpath = "//*[@text='Tcc8']")
   @iOSXCUITFindBy(xpath= "/*[@name='tcc8-']")
    public WebElement DevSett_TCC8;

    @AndroidFindAll({
        @AndroidBy(xpath = "//*[@text='Custom']"),
        @AndroidBy(xpath = "//*[@name='Custom']")
    })
    @iOSXCUITFindAll({
        @iOSXCUITBy(id = "Custom"),
        @iOSXCUITBy(xpath = "//*[@label='Custom']")
    })

    public WebElement DevSett_CustomCTA;

   @AndroidFindBy(xpath = "//*[@name='txtDevSetPopupTextField']")
   @iOSXCUITFindBy(xpath= "//*[@label='txtDevSetPopupTextField']")
    public WebElement DevSett_CustomBox;


   @AndroidFindBy(xpath = "/*[@name='Done']")
   @iOSXCUITFindBy(xpath= "//*[@label='Done']")
    public WebElement DevSett_Done;

   @AndroidFindBy(xpath = "txtDevSetPopupTextField")
    public WebElement DevSett_TCCTextField;

    @AndroidFindBy(xpath = "///*[@text='Tcc9']")
    @iOSXCUITFindBy(xpath = "//*[@name='tcc9-']")
    public WebElement DevSett_TCC9;


    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"3G\"]")
    @iOSXCUITFindBy(id = "3G")
    @AndroidFindBy(xpath = "//*[@text='MobileData']")
    public WebElement DevSett_ConnectionType_MobileData;


    @AndroidFindBy(id = "com.myvodafoneapp:id/toggle_hardCoded_msisdn")
    @iOSXCUITFindBy(xpath= "//*[@label='Use hardCode MSISDN']")
    @iOSXCUITFindBy(xpath = "//*[@name='devSettingsTitleLabel_Use hardCode MSISDN']")
    public WebElement DevSett_UseHardCodeBuild_radiobutton;


    @AndroidFindBy(id = "com.myvodafoneapp:id/toggle_test_token")
    @iOSXCUITFindBy(xpath= "//*[@label='Use test token']")
    @iOSXCUITFindBy(xpath = "//*[@name='devSettingsTitleLabel_Use test token']")
    public WebElement DevSett_UseTestToken_radiobutton;


    @AndroidFindBy(id = "com.myvodafoneapp:id/online_context_url_spinner")
    @iOSXCUITFindBy(id = "eCare URL")
    public WebElement DevSett_EcareURL;

    @AndroidFindBy(id = "com.myvodafoneapp:id/disable_qualtrix_toggle")
    @iOSXCUITFindBy(xpath= "//*[@label='Disable surveys']")
    @iOSXCUITFindBy(xpath ="//*[@name='devSettingsTitleLabel_Disable surveys']")
    public WebElement DevSett_TNPS_survay_toggle;

    @AndroidFindBy(id = "com.myvodafoneapp:id/disable_appratings_toggle")
    @iOSXCUITFindBy(xpath= "//*[@label='Disable rating']")
    @iOSXCUITFindBy(xpath = "//*[@name='devSettingsTitleLabel_Disable rating']")
    public WebElement DevSett_Apprating_survay_toggle;

    @AndroidFindBy(xpath = "(//*[@resource-id='android:id/text1' and @text='WiFi'])")
    @iOSXCUITFindBy(id = "WiFi")
    public WebElement DevSett_ConnectionType_WIFI;

    @AndroidFindBy(id = "com.myvodafoneapp:id/build_journey")
    @iOSXCUITFindBy(id = "devSettingsTitleLabel_Test a journey")
    public WebElement testJourneyBtn;


    @AndroidFindBy(xpath = "com.myvodafoneapp:id/toggle_adobe_target")

    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "devSettingsTitleLabel_Enable Adobe Target"),
            @iOSXCUITBy(xpath = "toggle_adobe_target"),
            @iOSXCUITBy(xpath = "//*[@label='Enable Adobe Target']"),
            @iOSXCUITBy(xpath = "//XCUIElementTypeStaticText[@name='devSettingsTitleLabel_Enable Adobe Target']")
    })
    public WebElement AdobeToggle;


    @AndroidFindBy(id = "com.myvodafoneapp:id/enable_stubbed_toggle")
    @iOSXCUITFindBy(id = "Stubbed")
    public WebElement DevSett_Stubbed;

    @AndroidFindBy(xpath = "(//*[@name='INT-1'])[2]")
    public WebElement DevSett_Reinvent_Server_INT1;

    @AndroidFindBy(xpath = "(//*[@name='Prodsup'])[2]")
    public WebElement DevSett_Reinvent_Server_PRODSUP;

    @AndroidFindBy(xpath = "(//*[@name='QC-1'])[2]")
    public WebElement DevSett_Reinvent_Server_QC1;


    @AndroidFindBy(xpath = "(//*[@name='QC-2'])[2]")
    public WebElement DevSett_Reinvent_Server_QC2;


    public DevSettingsPo() {
        super();
    }
}
