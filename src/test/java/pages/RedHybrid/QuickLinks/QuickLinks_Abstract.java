package pages.RedHybrid.QuickLinks;

public abstract class QuickLinks_Abstract extends QuickLinks_PO {
    public QuickLinks_Abstract() {
        super();
    }

    public abstract void iAmARedHybridUserAndSkipLogin();

    public abstract void iExpectToSeeANewSectionDisplayedUnderTheDiscoverCarouselAs() throws InterruptedException;

    public abstract void iClickOnTheManagePaymentsItem() throws InterruptedException;

    public abstract void iExpectToBeRedirectedToThePaymentsFlow();

    public abstract void acceptCookies();

    public abstract void iAmARedHybridUserAndLoggedIn() throws InterruptedException;

    public abstract void changePlanQuickLinkUiIsRespected();

    public abstract void managePaymentQuickLinkUiIsRespected(String Version);

    public abstract void scrollToQuickLinks();

    public abstract void iClickOnRenewEarlyFromQuickLinks();

    public abstract void renewEarlyQuickLinkUiIsRespected();

    public abstract void changeNextPlanFromQuickLinksWithoutClickOnPaymentSkipCTA();
}
