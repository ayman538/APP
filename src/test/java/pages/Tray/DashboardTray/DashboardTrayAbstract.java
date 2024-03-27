package pages.Tray.DashboardTray;

import org.openqa.selenium.Point;
import testdata.ReadResponse;

public abstract class DashboardTrayAbstract extends DashboardTrayPO {

    public DashboardTrayAbstract() {
        super();
    }

    public abstract void ValidateMyAccount();

    public abstract void ValidateVeyMeOrRewards();

    public abstract void ValidateBillingOrTopUp();

    public abstract void ValidateSettings();

//    public abstract void GetResponse();

    public abstract void checkTobi();

    public abstract void checkCloseTobi();


    public abstract int GetDashboardTrayYCoordinates();

    public abstract void validateTobiSwipeDown();

    public abstract void clickTobiUsingReturningUserWithBioPref();
    public abstract void clickSkipLoginForTobiPrompt();

    public abstract void clickOnXIconForThePrompt();

    public abstract void validateTobiChatisOpen();

    public abstract void navigateToTobi();
}






