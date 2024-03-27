package pages.Dashboard.VeryMe;

import org.testng.Assert;

public abstract class VeryMeAbstract extends VeryMeOffersPO{

    public VeryMeAbstract(){
        super();
    }

    public abstract void scrollDownToVeryMe();

    public abstract void checkVeryMeTitle();

    public abstract void checkVeryMeViewAllCTA() throws InterruptedException;

    public abstract void checkVeryMeUI();

    public abstract void checkVeryMeDisappearForSpecificUsers();

    public abstract void validateVeryMeDeepLink();

    public abstract void validateVeryMeUniversalLink();
}
