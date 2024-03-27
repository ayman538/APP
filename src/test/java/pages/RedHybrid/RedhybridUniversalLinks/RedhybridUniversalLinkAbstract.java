package pages.RedHybrid.RedhybridUniversalLinks;

public abstract class RedhybridUniversalLinkAbstract extends RedhybridUniversalLinksPO{
    public RedhybridUniversalLinkAbstract(){super();}

    public abstract void navigateToManageCard();
    public abstract void softCloseApp() throws InterruptedException;
}
