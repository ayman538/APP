package pages.SubsctionOverlay.GroupData;

public abstract class GroupDataAbstract extends GroupDataPO{

    public GroupDataAbstract(){
        super();
    }

    public abstract void checkDashboardTilesRedLeader();

    public abstract void navigateToGroupDataTab();

    public abstract void checkDataGroupCard();

    public abstract void navigateToManageGroupData();

    public abstract void checkLimitSharerInManageGroupData();

    public abstract void checkManageGroupDataCTA() throws InterruptedException;
}
