package pages.Dashboard.RelocateInboxRemoveGreeting;

import org.junit.jupiter.api.Assertions;

import java.io.IOException;

import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RelocateInboxRemoveGreetingAndroid extends RelocateInboxRemoveGreetingAbstract {

    public RelocateInboxRemoveGreetingAndroid() throws IOException {
        super();
    }


    @Override
    public void validateHidingGreetingFromUI() {

        assertDisplayed(DB_MyAccountTray_icon, 10);
        Assertions.assertFalse(elementIsPresent(DB_UserGreetingIcon));
        Assertions.assertFalse(elementIsPresent(DB_UserGreetingDescription));

    }

    @Override
    public void validateInboxRelocation() {
        assertDisplayed(DB_MyAccountTray_icon, 10);
        Assertions.assertTrue(elementIsPresent(DB_NewInboxIcon));
        Assertions.assertTrue(elementIsPresent(DB_NewInboxDescription));
    }

    @Override
    public void validateInboxRemoval() {
        assertDisplayed(DB_MyAccountTray_icon, 10);
        Assertions.assertFalse(elementIsPresent(DB_NewInboxIcon));
        Assertions.assertFalse(elementIsPresent(DB_NewInboxDescription));
    }

    @Override
    public void openMessageBoxOnDashboard(){
      waitForVisibility(DB_NewInboxIcon);
        DB_NewInboxIcon.click();
        waitForVisibility(Notification_title);
        Assertions.assertTrue(elementIsPresent(Notification_title));
        System.out.println(Notification_title.getText());
        DB_NotificationXicon.click();
    }

}


