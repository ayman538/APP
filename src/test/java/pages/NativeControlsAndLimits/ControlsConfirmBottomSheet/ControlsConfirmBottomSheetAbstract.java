package pages.NativeControlsAndLimits.ControlsConfirmBottomSheet;

import java.util.List;

public abstract class ControlsConfirmBottomSheetAbstract extends ControlsConfirmBottomSheetPO {

    public abstract List<String> getCategories();

    public abstract void callAPI(String categoryName);

    public abstract void navigateToZeroLvlControlConfirmation() throws Exception;

    public abstract void goToAndCheckZeroLvlConfirmationControl() throws Exception;

    public abstract void checkZeroControlConfirmation();

    public abstract int navigateToFirstLvlControlConfirmation();

    public abstract void checkFirstControlConfirmation();

    public abstract int navigateToSecondLvlControlConfirmation();

    public abstract void checkSecondControlConfirmation();

    public abstract void validateConfirmTurnOffControlTrayIsOpened(String buttonName);

    public abstract void clickOnXCTAOnTurnOffConfirmationTray();

    public abstract void clickOnTurnOffCTAOnConfirmationTray();
}
