package pages.NativeControlsAndLimits;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class NativeControlsAndLimitsAbstract extends NativeControlsAndLimitsLogicPO{
    public abstract void validateControlsAndLimitsTileExistence();

    public abstract void clickOnAddControlsAndLimitsTile();

    public abstract void validateControlsTabIsOpened();


    public abstract List<WebElement> getActiveControls();

    public abstract void validateActiveControls();

    public abstract void validateActiveControlsCardContent();

    public abstract void validateClickingOnFindOutMoreCTAForControls();

    public abstract void validateTurnOffControlCTA(String buttonName);

    public abstract void clickOnTurnOffControlCTA(String buttonName);

    public abstract void validateOnTurnOffCTAStatus(String buttonName);

    public abstract void clickOnControlsTabFromAdjacentTabs();
}
