package pages.RedHybrid.SubsOverlay;

public abstract class RedHybrid_SubsOverlay_Abstract extends RedHybrid_SubsOverlay_PO {

    public RedHybrid_SubsOverlay_Abstract() {
        super();
    }

    public abstract void clickOnAnyTile();

    public abstract void validateSubsOverlayUI();

    public abstract void appSoftCloseThenRelaunchIt();

    public abstract void planUsageExtrasTabsAreDisplayed();

    public abstract void clickOnXIcon();

    public abstract void DashboardIsDisplayed();

    public abstract void NavigateToExtrasTab();

    public abstract void ValidateOnContentOfExtrasTab();

    public abstract void ValidatePayAsYouGoCardIsNotDisplayed();

    public abstract void ValidateExtrasDisplayed();
}