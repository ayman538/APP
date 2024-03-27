package pages.Dashboard.AllowanceTile;

public abstract class AllowanceTileAbstract extends AllowanceTilePO {
    public AllowanceTileAbstract() {
        super();
    }

    //public abstract void setBeforeClass();

    public abstract void assertAllowanceTile() throws Exception;

    public abstract void checkAllowanceTile() throws Exception;

    public abstract void assertAllowanceTileAllUsageDisplayed() throws Exception;

    //public abstract void assertAllowanceCardText() throws ParseException;

    public abstract void assertUsageTabDisplayedAfterAllowanceTileCTA();
}
