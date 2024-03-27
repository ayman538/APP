package pages.NativeExtras.CategoryBottomSheet;

public abstract class CategoryBottomSheetAbstract extends CategoryBottomSheetPO{

    public abstract void validateExtrasCategoryScreenTitle(String categoryName) throws Exception;

    public abstract void validateExtrasContentOnCategoryScreen(String categoryName) throws Exception;

    public abstract void validateExtrasCategoryName();

    public abstract void validateExtrasCategoryDescription();

    public abstract void validateExtrasCategorySelection();


    public abstract void validateExtrasCategoryContinueCTA();

    public abstract void validateExtrasCategoryXCTA();

    public abstract void clickOnExtrasCategoryXCTA();

    public abstract void selectOneOfExtraCategory();

}
