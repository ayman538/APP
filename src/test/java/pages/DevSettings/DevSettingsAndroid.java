package pages.DevSettings;

import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DevSettingsAndroid extends DevSettings {

    public DevSettingsAndroid() {
        super();
    }

    @Override
    public void setDevSetting() throws InterruptedException {
        Thread.sleep(500);
        Properties envProp = readPropertyFile("config/env.properties");
        String stubbed = System.getProperty("Stubbed", envProp.getProperty("Stubbed"));
        String ReinventServer = System.getProperty("ReinventServer", envProp.getProperty("Reinvent_Server"));
        String needTCC = System.getProperty("NeedTcc",envProp.getProperty("Need_Tcc"));
        String AdobeToggle = System.getProperty("AdobeToggle", envProp.getProperty("AdobeToggle"));
        if(elementIsPresent(WF_TUT_closeCTA))
            WF_TUT_closeCTA.click();
        waitForVisibility(DevSett_VodafoneLogoIcon);
        DevSett_VodafoneLogoIcon.click();
        if(DevSett_ServerValue.getText().equals("Live")) {
            EnterMSISDN();
            SelectServer();
            if (needTCC.equals("true")) {
                SelectEcareServer();
            }
            if (ReinventServer.equals("true")) {
                SelectReinventServer();
            }
            ConfigureWifiOr3GRun();
            if (stubbed.equalsIgnoreCase("true")) {
                enableStubbed();
            }
            if (AdobeToggle.equals("true")) {

                EnableAdobeTargetToggle();
            }
            DisableSurveysPopUps();
        }
        androidScrollToElement(DevSett_Save, "down");
        DevSett_Save.click();

    }

    @Override
    protected void EnterMSISDN() {
        Properties envProp = readPropertyFile("config/env.properties");
        if (System.getProperty("UFL", envProp.getProperty("UFL")).equalsIgnoreCase("3G")) {
            String MSISDN = System.getProperty("MSISDN", envProp.getProperty("MSISDN"));
            waitForVisibility(DevSett_MSISDN);
            DevSett_MSISDN.click();
            DevSett_MSISDN_textfield.clear();
            DevSett_MSISDN_textfield.sendKeys(MSISDN);
            DevSett_MSISDN_Save_CTA.click();
        }
    }

    @Override
    protected void SelectServer() throws InterruptedException {
        Properties envProp = readPropertyFile("config/env.properties");
        waitForVisibility(DevSett_Server);
        DevSett_Server.click();
        String Server = System.getProperty("SERVER", envProp.getProperty("SERVER")).toUpperCase();
        Thread.sleep(500);
        switch (Server) {
            case "INT1":
                androidScrollToElement(DevSett_Server_INT1, "down");
                DevSett_Server_INT1.click();
                break;
            case "PRODSUP":
                androidScrollToElement(DevSett_Server_PRODSUP, "down");
                DevSett_Server_PRODSUP.click();
                break;
            case "QC1":
                androidScrollToElement(DevSett_Server_QC1, "down");
                DevSett_Server_QC1.click();
                break;
            case "QC2":
                androidScrollToElement(DevSett_Server_QC2, "down");
                DevSett_Server_QC2.click();
                break;
            case "QCX":
                androidScrollToElement(DevSett_Server_QCX, "down");
                DevSett_Server_QCX.click();
                break;
            default:
                break;
        }
    }
    @Override
    protected void SelectReinventServer() throws InterruptedException {
        Properties envProp = readPropertyFile("config/env.properties");
        waitForVisibility(DevSett_ReinventServer);
        DevSett_ReinventServer.click();
        String Server = System.getProperty("SERVER", envProp.getProperty("SERVER")).toUpperCase();
        Thread.sleep(500);

            switch (Server) {
                case "INT1":
                    androidScrollToElement(DevSett_Server_INT1, "down");
                    DevSett_Server_INT1.click();
                    break;
                case "PRODSUP":
                    androidScrollToElement(DevSett_Server_PRODSUP, "down");
                    DevSett_Server_PRODSUP.click();
                    break;
                case "QC1":
                    androidScrollToElement(DevSett_Server_QC1, "down");
                    DevSett_Server_QC1.click();
                    break;
                case "QC2":
                    androidScrollToElement(DevSett_Server_QC2, "down");
                    DevSett_Server_QC2.click();
                    break;
                case "QCX":
                    androidScrollToElement(DevSett_ReinventServer_QCX, "down");
                    DevSett_ReinventServer_QCX.click();
                    break;
                default:
                    break;
            }

        }

        @Override
        protected void SelectEcareServer() throws InterruptedException {
            Properties envProp = readPropertyFile("config/env.properties");
            waitForVisibility(DevSett_EcareURL);
            DevSett_EcareURL.click();
            String TCC = System.getProperty("TCC", envProp.getProperty("TCC")).toUpperCase();
            Thread.sleep(500);

            switch (TCC) {
                case "TCC6":
                    androidScrollToElement(DevSett_TCC6, "down");
                    DevSett_TCC6.click();
                    break;
                case "TCC7":
                    androidScrollToElement(DevSett_TCC7, "down");
                    DevSett_TCC7.click();
                    break;
                case "TCC8":
                    androidScrollToElement(DevSett_TCC8, "down");
                    DevSett_TCC8.click();
                    break;
                case "TCC9":
                    androidScrollToElement(DevSett_TCC9, "down");
                    DevSett_TCC9.click();
                    break;
                default:
                    break;
            }

        }



    @Override
    protected void ConfigureWifiOr3GRun() {
        Properties envProp = readPropertyFile("config/env.properties");
        if (System.getProperty("UFL", envProp.getProperty("UFL")).equalsIgnoreCase("3G")) {
            set3G();


        } else if (System.getProperty("UFL", envProp.getProperty("UFL")).equalsIgnoreCase("WIFI")) {

            waitForVisibility(DevSett_ConnectionType);
            DevSett_ConnectionType.click();
            waitForVisibility(DevSett_ConnectionType_WIFI);
            DevSett_ConnectionType_WIFI.click();
//            switchTheToggles();
        }
    }

    @Override
    protected void enableStubbed() {
        androidScrollToElement(DevSett_Stubbed, "down");
        DevSett_Stubbed.click();
    }


    @Override
    protected void DisableSurveysPopUps() {
        androidScrollToElement(DevSett_TNPS_survay_toggle, "down");
        DevSett_TNPS_survay_toggle.click();
        androidScrollToElement(DevSett_Apprating_survay_toggle, "down");
        DevSett_Apprating_survay_toggle.click();
    }

    @Override
    protected void set3G() {
        waitForVisibility(DevSett_ConnectionType);
        DevSett_ConnectionType.click();
        waitForVisibility(DevSett_ConnectionType_MobileData);
        DevSett_ConnectionType_MobileData.click();
        switchTheToggles();
    }

    @Override
    protected void switchTheToggles() {
        waitForVisibility(DevSett_UseHardCodeBuild_radiobutton);
        if(getUnknownUser().equalsIgnoreCase("false")) {
            DevSett_UseHardCodeBuild_radiobutton.click();
            DevSett_UseTestToken_radiobutton.click();
        }
    }

    @Override
    public void resetAppForIOS() {

    }

    @Override
    public void goToTestJourneyPage() {
        waitForVisibility(DB_VFLogo);
        DB_VFLogo.click();
        scrollDownTo(testJourneyBtn);
        testJourneyBtn.click();
    }
    @Override
    public void EnableAdobeTargetToggle()
    {
        androidScrollToElement(AdobeToggle,"down");
        waitForVisibility(AdobeToggle);
        AdobeToggle.click();
    }

    @Override
    public void SaveandRestart() {
        if(elementIsPresent(WF_TUT_closeCTA))
            WF_TUT_closeCTA.click();
        waitForVisibility(DevSett_VodafoneLogoIcon);
        DevSett_VodafoneLogoIcon.click();
        androidScrollToElement(DevSett_Save, "down");
        DevSett_Save.click();
    }
}
