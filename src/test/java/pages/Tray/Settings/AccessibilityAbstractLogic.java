package pages.Tray.Settings;

public abstract class AccessibilityAbstractLogic extends AccessibilityPO{

    public AccessibilityAbstractLogic(){super();}

    public abstract void validateAccessibility() throws InterruptedException;
    public abstract void clickOnAccessibility();
    public abstract void validateAccessibilitySSO() throws InterruptedException;



}
