package pages.NativeExtras;

public abstract class NativeExtrasAbstract extends NativeExtrasPO {
    public abstract void validateAddExtrasTileExistence();

    public abstract void clickOnAddExtrasTile();

    public abstract void validateExtrasTabIsOpened();

    public abstract void validateActiveExtrasCardContent();

    public abstract void validateClickingOnFindOutMoreCTA();

    public abstract void validateShopExtrasCard();

    public abstract boolean checkShopExtrasCategories();

    public abstract void validateShopExtrasDetails();

    public abstract void validateShopExtrasCategories();

    public abstract void clickOnCategoryCard(String category);

    public abstract void validateAddedExtraWithPendingStatus();

    public abstract void validateOnOptingCTARecurringExtra(String buttonName) throws Exception;

    public abstract void clickOnOptingCTARecurringExtra(String buttonName);

    public abstract void validateOnOptingCTAStatus(String buttonName);

    public abstract void validateActiveExtrasCardEmpty();

}
