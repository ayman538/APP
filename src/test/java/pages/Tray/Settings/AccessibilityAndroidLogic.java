package pages.Tray.Settings;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AccessibilityAndroidLogic extends AccessibilityAbstractLogic{

    public AccessibilityAndroidLogic(){super();}

 @Override
    public void validateAccessibility() throws InterruptedException {
     waitForVisibility(AS_Accessibility);
     Thread.sleep(4000);
     AssertDisplayed(AS_Accessibility.isDisplayed());
 }

    public void clickOnAccessibility(){
        AS_Accessibility.click();

    }
    public void validateAccessibilitySSO() throws InterruptedException {
        waitForVisibility(SSO_Accessibility);
        Thread.sleep(11000);
        AssertDisplayed(SSO_Accessibility.isDisplayed());
    }
}
