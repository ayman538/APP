package pages.NativeExtras.ConfirmBottomSheet;

public abstract class ConfirmBottomSheetAbstract extends ConfirmBottomSheetPO{

    public abstract void validateConfirmBottomSheetTitle(String categoryName) throws Exception;

    public abstract void validateConfirmBottomSheetContent(String categoryName);

    public abstract void clickOnConfirmScreenBuyCTA();

    public abstract void clickOnConfirmScreenBackArrowIcon();

}
