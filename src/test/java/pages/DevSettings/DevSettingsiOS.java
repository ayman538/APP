package pages.DevSettings;

import java.util.Properties;

import static core.Config.getUnknownUser;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ScrollHelpers.iosScrollToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DevSettingsiOS extends DevSettings {

    public DevSettingsiOS() {
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
        //there are two items with the same locator
        //if(DevSett_ServerValue.getText().equals("")) {
            EnterMSISDN();
            SelectServer();
            if (needTCC.equals("true")) {
                SelectEcareServer();
            }
            ConfigureWifiOr3GRun();
            if (stubbed.equalsIgnoreCase("true")) {
                enableStubbed();
            }
            if (ReinventServer.equals("true")) {
                SelectReinventServer();
            }
            DisableSurveysPopUps();
        if (AdobeToggle.equals("true")) {

            EnableAdobeTargetToggle();
        }
        //}
        waitForVisibility(DevSett_Save);
        DevSett_Save.click();
    }

    @Override
    public void EnterMSISDN() {
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
    public void SelectServer() throws InterruptedException {
        Properties envProp = readPropertyFile("config/env.properties");
        String Server = System.getProperty("SERVER", envProp.getProperty("SERVER")).toUpperCase();
        waitForVisibility(DevSett_Server);
        DevSett_Server.click();
        Thread.sleep(500);
        switch (Server) {
            case "INT1":
                if (System.getProperty("REMOTE", "false").equalsIgnoreCase("True")) {
                    DevSett_Server_INT1.click();
                } else {
                    iosScrollToElement(DevSett_Server_INT1, "down");
                    DevSett_Server_INT1.click();
                }
                break;
            case "PRODSUP":
                iosScrollToElement(DevSett_Server_PRODSUP, "down");
                DevSett_Server_PRODSUP.click();
                break;
            case "QC1":
                iosScrollToElement(DevSett_Server_QC1, "down");
                DevSett_Server_QC1.click();
                break;
            case "QC2":
                iosScrollToElement(DevSett_Server_QC2, "down");
                DevSett_Server_QC2.click();
                break;
            case "QCX":
                iosScrollToElement(DevSett_Server_QCX, "down");
                DevSett_Server_QCX.click();
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
                //iosScrollToElement(DevSett_TCC6, "down");
                DevSett_TCC6.click();
                break;
            case "TCC7":
                //iosScrollToElement(DevSett_TCC7, "down");
                DevSett_TCC7.click();
                break;
            case "TCC8":
                EnterTccURL(TCC);
                break;
            case "TCC9":
                //iosScrollToElement(DevSett_TCC9, "down");
                //DevSett_TCC9.click();
                DevSett_CustomCTA.click();
                DevSett_CustomBox.sendKeys("tcc9-");
                DevSett_Done.click();
                break;
            default:
                break;
        }

    }


    public void EnterTccURL(String TccURL){
        try {
            if (!DevSett_TCC8.isDisplayed()) {
            iosScrollToElement(DevSett_TCC8, "down");
            } else {
                DevSett_TCC8.click();
            }

        }catch (Error | Exception e){
            if (!DevSett_CustomCTA.isDisplayed()) {
                iosScrollToElement(DevSett_CustomCTA, "down");
            } else {
                DevSett_CustomCTA.click();
            }
            waitForVisibility(DevSett_TCCTextField);
            DevSett_TCCTextField.sendKeys(TccURL.toLowerCase()+"-");
            System.out.println(TccURL.toLowerCase()+"-"+ "  URL FOR TCC");
            DevSett_MSISDN_Save_CTA.click();
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
                    iosScrollToElement(DevSett_Reinvent_Server_INT1, "down");
                    DevSett_Reinvent_Server_INT1.click();
                    break;
                case "PRODSUP":

                    // iosScrollToElement(DevSett_Reinvent_Server_PRODSUP, "down");
                    DevSett_Reinvent_Server_PRODSUP.click();
                    break;
                case "QC1":
                    //iosScrollToElement(DevSett_Reinvent_Server_QC1, "down");
                    DevSett_Reinvent_Server_QC1.click();
                    break;
                case "QC2":
                    //iosScrollToElement(DevSett_Reinvent_Server_QC2, "down");
                    DevSett_Reinvent_Server_QC2.click();
                    break;
                case "QCX":
                    //iosScrollToElement(DevSett_Server_QCX, "down");
                    DevSett_Server_QCX.click();
                    break;
                default:
                    break;
            }



    }

    @Override
    public void ConfigureWifiOr3GRun() {
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
        iosScrollToElement(DevSett_Stubbed, "down");
        waitForVisibility(DevSett_Stubbed);
        DevSett_Stubbed.click();
        System.out.println("stubbed enabled");
    }



    @Override
    public void DisableSurveysPopUps() {
        iosScrollToElement(DevSett_Apprating_survay_toggle, "down");
        DevSett_TNPS_survay_toggle.click();
        DevSett_Apprating_survay_toggle.click();
 /*       iosScrollToElement(DevSett_TNPS_survay_toggle, "down");
        waitForVisibility(DevSett_TNPS_survay_toggle);
        DevSett_TNPS_survay_toggle.click();
        iosScrollToElement(DevSett_Apprating_survay_toggle, "down");
        waitForVisibility(DevSett_Apprating_survay_toggle);
        DevSett_Apprating_survay_toggle.click();*/
    }

    @Override
    public void set3G() {
        waitForVisibility(DevSett_ConnectionType);
        DevSett_ConnectionType.click();
        if (System.getProperty("REMOTE", "false").equalsIgnoreCase("false")) {
            waitForVisibility(DevSett_ConnectionType_MobileData);
            DevSett_ConnectionType_MobileData.click();
        }
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
        System.out.println("Build 10.99 is displayed");
        waitForVisibility(DevSett_VodafoneLogoIcon);
        DevSett_VodafoneLogoIcon.click();
        waitForVisibility(DevSett_Save);
        DevSett_Save.click();
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
        iosScrollToElement(AdobeToggle,"down");
        waitForVisibility(AdobeToggle);
        AdobeToggle.click();
    }

    @Override
    public void SaveandRestart() {
        if(elementIsPresent(WF_TUT_closeCTA))
            WF_TUT_closeCTA.click();
        waitForVisibility(DevSett_VodafoneLogoIcon);
        DevSett_VodafoneLogoIcon.click();
        waitForVisibility(DevSett_Save);
        DevSett_Save.click();
    }
}
