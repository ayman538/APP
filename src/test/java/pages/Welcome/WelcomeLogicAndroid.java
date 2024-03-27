package pages.Welcome;

import org.openqa.selenium.Alert;
import org.testng.SkipException;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAbstract;
import pages.DX_IDM.WelcomeFlow.DX_IDM_WelcomeFlowLogicAndroid;
import pages.RedHybrid.WelcomeFlow.RedHybrid_WelcomeFlowLogic_Abstract;
import utils.SegmentUtils;

import static core.Config.getCleanStatus;
import static core.Config.setFullFailure;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.WaitHelpers.WaitElementAndHandleFullFailureError;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class WelcomeLogicAndroid extends WelcomeLogicAbstract {

    private final DX_IDM_WelcomeFlowLogicAbstract welcomeFlowContinueCTA;
    Alert alert;
    private RedHybrid_WelcomeFlowLogic_Abstract redHybrid_welcomeFlowLogic_abstract;

    public WelcomeLogicAndroid() {
        super();
        welcomeFlowContinueCTA = new DX_IDM_WelcomeFlowLogicAndroid();
    }

    @Override
    public void WelcomeFlow() {
        if (getCleanStatus().equalsIgnoreCase("True")) {
            //TODO what is the diff. between welcome DX_IDM and redHybrid ?
            welcomeFlowContinueCTA.dxIDMWelcomeFlow();
//            if (UI.equalsIgnoreCase("old")) {
//                welcomeFlowForOldApp();
//            } else if (UI.equalsIgnoreCase("new")){
//                welcomeFlowContinueCTA.dxIDMWelcomeFlow();
//            } else if (UI.equalsIgnoreCase("redhybrid")){
//                redHybrid_welcomeFlowLogic_abstract = new RedHybrid_WelcomeFlowLogic_Android();
//                redHybrid_welcomeFlowLogic_abstract.redHybridWelcomeFlow();
//            }


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
    public void DismissLoginScreen(){
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
