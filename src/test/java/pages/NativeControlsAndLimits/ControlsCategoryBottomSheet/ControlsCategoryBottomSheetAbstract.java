package pages.NativeControlsAndLimits.ControlsCategoryBottomSheet;

import java.util.List;

public abstract class ControlsCategoryBottomSheetAbstract extends ControlsCategoryBottomSheetPO {
    public abstract void callAPI(String categoryName);

    public abstract List<String> getCategories();

    public abstract void navigateToFirstLevelControlSubCategory() throws Exception;

    public abstract void checkFirstLevelControlSubCategory() throws Exception;

    public abstract void checkSecondLevelControlSubCategory() throws Exception;

    public abstract void checkControlCategory();

    public abstract int navigateToSecondLevelControlSubCategory() throws Exception;

    public abstract void checkControlSubCategory() throws Exception;
}
