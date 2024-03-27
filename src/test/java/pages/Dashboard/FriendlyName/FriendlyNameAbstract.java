package pages.Dashboard.FriendlyName;

public abstract class FriendlyNameAbstract extends FriendlyNamePO {
    public FriendlyNameAbstract(){
        super();
    }

    public abstract void verifyPencilIconExist();
    public abstract void verifyPencilIconNotExist();
    public abstract void enterValidFriendlyName();
    public abstract void clickOnSaveCTA();
    public abstract void verifyFriendlyNameUpdatedScreen();
    public abstract void closeUpdatingScreen();
    public abstract void verifyFriendlyNamePendingScreen();
    public abstract void enterInvalidFriendlyName();
    public abstract void verifyInvalidFriendlyNameMsg();
    public abstract void clickOnSubsInfoContainer();
    public abstract void validateFriendlyNameOverlay();

}
