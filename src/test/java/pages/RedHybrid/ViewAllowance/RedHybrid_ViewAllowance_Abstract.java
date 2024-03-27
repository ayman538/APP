package pages.RedHybrid.ViewAllowance;

public abstract class RedHybrid_ViewAllowance_Abstract extends RedHybrid_ViewAllowance_PO {
    RedHybrid_ViewAllowance_Abstract(){super();}

    public abstract void setBeforeClass();

    public abstract void checkAllowanceTile();

    public abstract void assertAllowanceCardText();

    public abstract void assertAllowanceTileProgressBarDisplayed();

    public abstract void assertOnTotalGBForPromotedPlan();
}
