package pages.RedHybrid.Dashboard_ExtrasList_overlay;


public abstract class Dashboard_ExtrasList_Overlay_Abstract extends Dashboard_ExtrasList_Overlay_PO {
    public Dashboard_ExtrasList_Overlay_Abstract() {
        super();
    }

    public abstract void addExtrasTileClick() throws InterruptedException;

    public abstract void addExtrasOverlayAppears();

    public abstract void addExtrasOverlayUIValidation();


}
