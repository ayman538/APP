package pages.RedHybrid.DashboardUniversalLink;

public abstract class RedHybrid_DashboardUniversalLink_Abstract extends RedHybrid_DashboardUniversalLink_PO {

    public RedHybrid_DashboardUniversalLink_Abstract() {
        super();
    }

    public abstract void theUserClicksOnDashBoardLink();

    public abstract void assertThatUserNavigatesToDashBoardWithActivePlan();

    public abstract void assertThatUserNavigatesToDashBoardWithNoActivePlan();


    public abstract void SoftCloseApp();


}
