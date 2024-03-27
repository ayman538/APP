package pages.RedHybrid.Dashboard_AddDataOverlay;

public abstract class Dashboard_AddDataOverlay_Abstract extends Dashboard_AddDataOverlay_PO {
    public Dashboard_AddDataOverlay_Abstract() {
        super();
    }

    public abstract void clickOnAddDataTileFromDashboard() throws InterruptedException;

    public abstract void assertThatAddDataOverlayShouldBeDisplayed();

    public abstract void assertThatAddDataOverlayUIShouldBeDisplayedCorrectly();
}
