package pages.Dashboard.RelocateInboxRemoveGreeting;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

public abstract class RelocateInboxRemoveGreetingAbstract extends RelocateInboxRemoveGreetingPO{

    public abstract void validateHidingGreetingFromUI();
    public abstract void validateInboxRelocation();
    public abstract void validateInboxRemoval();

    public abstract void openMessageBoxOnDashboard();

    // public abstract void SwitchToSubscription(WebElement userType)throws InterruptedException, ParseException;
}
