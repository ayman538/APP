package pages.DX_IDM.SubsOverlay;


public abstract class DX_IDM_SubsOverlay_Abstract extends DX_IDM_SubsOverlayPO{

    public DX_IDM_SubsOverlay_Abstract() {
        super();
    }

    public abstract void assertSpecificSubsOverlayDisplayedAfterAcquisitionScreen() ;

    public abstract void validateSpecificSubsOverlayTitleText() ;

    public abstract void assertVOXIVisitCTADisplayed() ;

    public abstract void clickOnVOXIVisitCTA();

    public abstract void validateVOXIVisitCTA() ;

    public abstract void pressPhysicalBackonWebPortal();

    public abstract void clickOnXIconOnVOXIWebPortal() ;

    public abstract void validateAcquisitionDashboardDisplayed() ;


    public abstract void assertReturnToMyVodafoneCTADisplayed();

    public abstract void clickOnReturnToMyVodafoneCTA();


    public abstract void validateReturnToMyVodafoneCTA();

    public abstract void assertSubsOverlayXICONDisplayed() ;

    public abstract void clickOnSubsOverlayXIcon() ;

    public abstract void assertUnknownSubsOverlayLoginCTADisplayed() ;

    public abstract void clickOnUnKnownSubsOverlayLoginCTA() ;

    public abstract void validateUnKnownSubsOverlayLoginCTA() ;

    public  abstract void acceptCookies();

}
