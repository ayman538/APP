package pages.Welcome;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogic_IOS;
import utils.SegmentUtils;

import java.time.Duration;

import static core.Config.getCleanStatus;
import static core.Config.setFullFailure;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.WaitHelpers.WaitElementAndHandleFullFailureError;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class WelcomeLogic_IOS extends WelcomeLogicAbstract {
    private final DX_IDM_WelcomeFlowLogicAbstract welcomeFlowContinueCTA;
    Alert alert;

    public WelcomeLogic_IOS() {
        super();
        welcomeFlowContinueCTA = new DX_IDM_WelcomeFlowLogic_IOS();
    }

    @Override
    public void WelcomeFlow() {
        if (getCleanStatus().equalsIgnoreCase("True")) {
            welcomeFlowContinueCTA.dxIDMWelcomeFlow();

        } else {
            if (!WaitElementAndHandleFullFailureError(DB_SettingDashboardTray_icon)) {
                setFullFailure();
                throw new SkipException("Dashboard failed");
            }
        }
    }

    @Override
    public void getStartedCTA() {
        waitForVisibility(WF_GetStarted_CTA);
        WF_GetStarted_CTA.click();
    }

    @Override
    public void DismissLoginScreen() {
        String segment = SegmentUtils.GetSegment_Type();
        //System.out.println("Segment" + segment);
        if (!segment.equalsIgnoreCase("PREPAY") && !segment.equalsIgnoreCase("SMB")) {
            noThanksCTA();
        }
    }

    @Override
    public void noThanksCTA() {
        scrollDownTo(WF_NoThanksForLogin_CTA);
        waitForVisibility(WF_NoThanksForLogin_CTA);
        WF_NoThanksForLogin_CTA.click();
    }

    public void AcceptPermissionsForIOS(String PLATFORM_NAME) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // permission 1
        wait.until(ExpectedConditions.alertIsPresent());
        acceptAlert();

        // permission 2
        wait.until(ExpectedConditions.alertIsPresent());
        acceptAlert();
    }

    @Override
    public void acceptAlert() {
        alert = driver.switchTo().alert();
        alert.accept();
    }

    @Override
    public void WelcomeBackFlow() {
        welcomeFlowContinueCTA.dxIDMWelcomeFlow();
    }

    @Override
    public void continueCTA() {
        waitForVisibility(WF_welcomeBackTitle);
        scrollDownTo(WF_Continue_CTA);
        WF_Continue_CTA.click();
    }

    @Override
    public void welcomeFlowForOldApp() {
        if (!WaitElementAndHandleFullFailureError(WF_GetStarted_CTA)) {
            setFullFailure();
            throw new SkipException("SoftTOken failed");
        }
        System.out.println("Get started flow CTA: " + WF_GetStarted_CTA);
        getStartedCTA();
        DismissLoginScreen();
    }

}
