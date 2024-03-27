/*package pages.Dashboard.ControlTiles;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import testdata.ReadResponse;

import static core.Config.getUser;

@Deprecated
public class ControlTilesLogic extends ControlTilesPO {

    private static String Segment = "";
    private static boolean hideVOVStatus = false;
    private static WebElement DB_SettingDashboardTray_icon;

    public ControlTilesLogic() {
        super();
    }

    public void SetBeforeClass() {
        if (!hideVOVStatus) {
            Segment = ReadResponse.GetSegment();
            HideVOV(DB_VOVhideCTA);
            hideVOVStatus = true;
        }
    }

    public void ValidateFirstControlTileText() throws InterruptedException, ParseException {
        System.out.println("Given we validate the first card tile text");
        waitDashboardLoading();
        if (getUser().equalsIgnoreCase("PAYG_simply")) {
            assertFirstControlTileTitleTextPAYGSimply();
        } else if (getUser().equalsIgnoreCase("PAYG1")) {
            assertFirstControlTileTitleTextPAYG1();
        } else if (getUser().equalsIgnoreCase("PAYG_BVB")) {
            assertFirstControlTileTitleTextPAYGBVB();
        } else if (getUser().equalsIgnoreCase("Bingo") && ReadResponse.checkActiveLoans()) {
            assertFirstControlTileTitleTextBINGO();
        } else {
            assertFirstControlTileTitleTextRestOfUsers();
        }
        System.out.println("Should the first control tile text displayed successfully");
    }

    public void waitDashboardLoading() throws InterruptedException {
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Wait till the the setting dashboard try displayed successfully");
        Thread.sleep(6000);
    }

    public void assertFirstControlTileTitleTextRestOfUsers() {
        AssertResult(DB_ControlTile.getText(), "Your Plan");
        System.out.println("Else Assert on the control title ");
    }

    public void assertFirstControlTileTitleTextBINGO() {
        AssertResult(DB_ControlTile.getText(), "Your Plans");
        System.out.println("Else Assert on the control title ");
    }

    public void assertFirstControlTileTitleTextPAYGBVB() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: Big Value Bundle");
    }

    public void assertFirstControlTileTitleTextPAYG1() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: Pay as you go 1");
    }

    public void assertFirstControlTileTitleTextPAYGSimply() {
        System.out.println("Check If the Segment PREPAY user");
        AssertResult(DB_ControlTile.getText(), "Plan: PAYG Simply");
    }

    public void ValidateSecondControlTileText() throws InterruptedException {
        System.out.println("Given we validate the second control tile text ");
        waitDashboardLoading();
        if (getUser().contains("Red")) {
            assertSecondControlTileTitleTextRED();
        } else if (getUser().equalsIgnoreCase("PAYG_simply") || getUser().equalsIgnoreCase("PAYG1")) {
            assertSecondControlTileTitleTextPAYG1AndPAYGSimply();

        } else {
            assertSecondControlTileTitleTextRestOfUsers();
        }
        System.out.println("Should the secondary card tile displayed successfully ");
    }

    public void assertSecondControlTileTitleTextRestOfUsers() {
        AssertResult(DB_ControlTileSecondryCard.getText(), "Manage Bars & Extras");
        System.out.println("else control tile secondary card displayed successfully with text  " + DB_ControlTileSecondryCard.getText());
    }

    public void assertSecondControlTileTitleTextPAYG1AndPAYGSimply() {
        AssertResult(DB_ControlTileSecondryCard.getText(), "Buy a Big Value Bundle");
        System.out.println("else control tile secondary card displayed successfully with text  " + DB_ControlTileSecondryCard.getText());
    }

    public void assertSecondControlTileTitleTextRED() {
        System.out.println("Check if the user type red ");
        AssertResult(DB_ControlTileSecondryCard.getText(), "Manage group data");
        System.out.println("if control tile secondary card displayed successfully with text " + DB_ControlTileSecondryCard.getText());
    }

    public void ValidateEntryPointForFirstControlTile() throws InterruptedException {
        System.out.println("Given we validate the entry point for first control tile");
        firstControlTileCTA();
        assertPlanTabDisplayed();
        SOXIconCTA();
    }

    public void ClickOnControlTileCTA() throws InterruptedException {
        System.out.println("Given we validate the entry point for first control tile");
        firstControlTileCTA();
    }

    public void SOXIconCTA() {
        SO_Xicon.click();
        System.out.println(" Then click on the Xicon ");
    }

    public void assertPlanTabDisplayed() {
        System.out.println("when click on the Control til ");
        waitWithCatch(SO_PlanTabContent);
        System.out.println("Wait till the the Plan control tab control displayed ");
        AssertDisplayed(SO_PlanTabContent.isDisplayed());
        System.out.println("Should the plan tab displayed successfully ");
    }

    public void firstControlTileCTA() throws InterruptedException {
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println(" Wait till the the settings dashboard tray icon displayed ");
        DB_ControlTile.click();
        Thread.sleep(6000);
    }

    public void ValidateEntryPointForSecondControlTile() throws InterruptedException {
        System.out.println("Given we validate the Entry point for second control tile ");
        secondControlTileCTA();
        if (getUser().contains("Red")) {
            assertGroupDataDisplayedAfterFirstControlTileCTA();
        } else {
            assertExtrasDisplayedAfterSecondControlTileCTA();
        }
        SOXIconCTA();
    }

    public void assertExtrasDisplayedAfterSecondControlTileCTA() {
        System.out.println("Else the user is not red type ");
        waitWithCatch(SO_ExtrasTabContent);
        System.out.println("Wait till the extras tab content displayed ");
        AssertDisplayed(SO_ExtrasTabContent.isDisplayed());
        System.out.println("should the extras tab content displayed successfully ");
    }

    public void assertGroupDataDisplayedAfterFirstControlTileCTA() {
        System.out.println("Check if the user type is red ");
        waitWithCatch(GD_GroupDataCardTitle);
        System.out.println("wait till the the group data card displayed");
        AssertDisplayed(GD_GroupDataCardTitle.isDisplayed());
        System.out.println("Should the group data card displayed successfully ");
    }

    public void secondControlTileCTA() throws InterruptedException {
        waitForVisibility(DB_SettingDashboardTray_icon);
        System.out.println("Wait till the settings icon dashboard try displayed");
        DB_ControlTileSecondryCard.click();
        System.out.println("When click on the control tile of secondary card ");
        Thread.sleep(6000);
    }

}*/