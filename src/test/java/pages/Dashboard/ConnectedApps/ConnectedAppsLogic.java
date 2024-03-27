package pages.Dashboard.ConnectedApps;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class ConnectedAppsLogic extends ConnectedAppsPO {


    public ConnectedAppsLogic() {
        super();
        waitForVisibility(DB_SettingDashboardTray_icon);
    }

    public void assertDreamLapTitleText() {
        System.out.println("Given validate the Dream lab App title");
        scrollDownTo(DB_DreamLabApp);
        //scrollDownTo(DB_DreamLabApp);
        System.out.println(" Scroll to the Dream Lab App");
        AssertResult(DB_DreamLabApp.getText(), "DreamLab");
        System.out.println("Should the dream lab app title displayed successfully ");
    }

    public void assertDreamLabCTADisplayed() {
        System.out.println("Given Validate Dream lab app CTA");
        scrollDownTo(DB_DreamLabApp);
        System.out.println("Scroll to the Dream Lab App");
        AssertDisplayed(DB_DreamLabAppCTA.isDisplayed());
        System.out.println("The Dream Lab App CTA displayed successfully ");
    }

    public void assertVodBBTitleText() {
        System.out.println("Given Validate Vodafone Broadband app title");
        scrollDownTo(DB_VodafoneBroadbandApp);
        System.out.println("Scroll to vodafone broadband app ");
        System.out.println("The broadband app title displayed as : " + DB_VodafoneBroadbandApp.getText());
        AssertResult(DB_VodafoneBroadbandApp.getText(), "Vodafone Broadband");
        System.out.println("Should the vodafone broadband app title displayed successfully ");
    }

    public void assertVodBBCTADisplayed() {
        System.out.println("Given validate vodafone broadband app CTA");
        scrollDownTo(DB_VodafoneBroadbandApp);
        System.out.println("Scroll to the vodafone broad band apps ");
        System.out.println("The vodafone broadband App CTA dispalyed as " +
                (DB_VodafoneBroadbandAppCTA));
        AssertDisplayed(DB_VodafoneBroadbandAppCTA.isDisplayed());
        System.out.println(" Should the vodafone broadband app cta displayed ");
    }
}
