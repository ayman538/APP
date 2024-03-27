package pages.RedHybrid.AddNewPlanOverlay;

public abstract class Redhybrid_AddNewPlanOverlay_Abstract extends Redhybrid_AddNewPlanOverlay_PO {
    public Redhybrid_AddNewPlanOverlay_Abstract() {
        super();
    }


    public abstract void assertThatUserShouldBeRedirectedToInternalWebView();

    public abstract void assertThatUserIsDirectedBackToDashboard();

    public abstract void clickOnViewPlanDetailsCTA();

    public abstract void addANewPlanOverlayShouldBeDisplayedWithCorrectComponentsOrder();
}
