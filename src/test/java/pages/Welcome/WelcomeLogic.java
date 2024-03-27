//package pages.Welcome;
//
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.SkipException;
//import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic;
//import testdata.ReadResponse;
//
//import java.io.IOException;
//import java.util.Properties;
//
//import static core.Config.*;
//import static utilities.PropertiesLoader.readPropertyFile;
//
//public class WelcomeLogic extends WelcomePO {
//
//    private final DX_IDM_WelcomeFlowLogic welcomeFlowContinueCTA;
//    Alert alert;
//
//    public WelcomeLogic() {
//        super();
//        welcomeFlowContinueCTA = new DX_IDM_WelcomeFlowLogic();
//    }
//
//    public void WelcomeFlow() {
//        //TODO: handling DX-IDM welcome flow
//        if (getCleanStatus().equalsIgnoreCase("True")) {
//            String PLATFORM_NAME = getPlatformType();
//            String segment = ReadResponse.GetSegment();
//            if (PLATFORM_NAME.equalsIgnoreCase("IOS")) {
//                //TODO: handling DX-IDM login
//                getStartedCTA();
//                continueCTA();
//            } else if (PLATFORM_NAME.equalsIgnoreCase("Android")) {
//                Properties envProp = readPropertyFile("config/env.properties");
//                String UI = System.getProperty("UI", envProp.getProperty("UI"));
//                if (UI.equalsIgnoreCase("old")) {
//                    welcomeFlowForOldApp();
//                } else {
//                    welcomeFlowContinueCTA.dxIDMWelcomeFlow();
//                }
//            }
//
//            AcceptPermissionsForIOS(PLATFORM_NAME);
//            // DismissLoginScreen(segment);
//
//        } else {
//            if (!WaitElementAndHandleFullFailureError(DB_SettingDashboardTray_icon)) {
//                setFullFailure();
//                throw new SkipException("Dashboard failed");
//            }
//        }
//    }
//
//    public void getStartedCTA() {
//        waitForVisibility(WF_GetStarted_CTA);
//        WF_GetStarted_CTA.click();
//    }
//
//    public void DismissLoginScreen(String segment) {
//        System.out.println("Segment" + segment);
//        if (!segment.equalsIgnoreCase("PREPAY") && !segment.equalsIgnoreCase("SMB")) {
//            noThanksCTA();
//        }
//    }
//
//    public void noThanksCTA() {
//        scrollDownTo(WF_NoThanksForLogin_CTA);
//        waitForVisibility(WF_NoThanksForLogin_CTA);
//        WF_NoThanksForLogin_CTA.click();
//    }
//
//    public void AcceptPermissionsForIOS(String PLATFORM_NAME) {
//        if (PLATFORM_NAME.equalsIgnoreCase("IOS")) {
//            WebDriverWait wait = new WebDriverWait(driver, 5);
//            // permission 1
//            wait.until(ExpectedConditions.alertIsPresent());
//            acceptAlert();
//
//            // permission 2
//            wait.until(ExpectedConditions.alertIsPresent());
//            acceptAlert();
//        }
//    }
//
//    public void acceptAlert() {
//        alert = driver.switchTo().alert();
//        alert.accept();
//    }
//
//    public void WelcomeBackFlow() throws IOException {
//        String segment = ReadResponse.GetSegment();
//        continueCTA();
//        if (segment != "PREPAY" && segment != "SMB") {
//            noThanksCTA();
//        }
//        setLoginStatusStatus("False");
//    }
//
//    public void continueCTA() {
//        waitForVisibility(WF_welcomeBackTitle);
//        scrollDownTo(WF_Continue_CTA);
//        WF_Continue_CTA.click();
//    }
//
//    public void welcomeFlowForOldApp() {
//        if (!WaitElementAndHandleFullFailureError(WF_GetStarted_CTA)) {
//            setFullFailure();
//            throw new SkipException("SoftTOken failed");
//        }
//        System.out.println("Get started flow CTA: " + WF_GetStarted_CTA);
//        getStartedCTA();
//    }
//
//}
