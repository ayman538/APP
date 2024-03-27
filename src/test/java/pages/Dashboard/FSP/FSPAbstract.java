package pages.Dashboard.FSP;

public abstract class FSPAbstract extends FSPPO{

    public abstract void FSPExists () throws InterruptedException;

    public abstract void FSPDoesNotExist ();

    public abstract void FSPClickOnLearnMore();

    public abstract void FSPClickOnClose();

    public abstract void TUTClickOnClose();

    public abstract void assertofferpage() throws InterruptedException;

    public abstract void FSPCloseWebpage ();
}
