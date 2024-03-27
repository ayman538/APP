package pages.Dashboard.NetworkLinks;

public abstract class NetworkLinksAbstract extends NetworksPO{

    public NetworkLinksAbstract(){
        super();
    }

    public abstract void assertNetworkStatus();

    public abstract void NetworkLinksStatus();

    public abstract void assertNetworkTitleText();

    public abstract void ValidateBroadBandServiceTestLink();

    public abstract void ValidateNetworkLinksOrderAndText();

    public abstract void ValidateNetworkLinksCTA();

    //public abstract void checkFirstCard();

    //public abstract void assertNetworkCheckerLinkText();

    //public abstract void checkSecondCard();

    //public abstract void assertDataSpeedLinkText();

    public abstract void checkNetworkStatusJourney();

    public abstract void assertNetworkStatusTitleText();

    //public abstract void networkCheckerLinkCTA();

    public abstract void checkDataWIFIJourney();

    public abstract void assertSpeedCheckerTitleText();

    public abstract void scrollDownToBroadBandServiceTest() ;

    public abstract void ValidateUserName() ;

    public abstract void navigateBack();

    //public abstract void SpeedLinkCTA();
}
