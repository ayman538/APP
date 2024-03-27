package pages.AcquisitionBoard;

import org.openqa.selenium.WebElement;

public abstract class AcquisitionBoardAbstract extends AcquisitionBoardPO {

    public AcquisitionBoardAbstract() {
        super();
    }

    public abstract void checkAcquisitionHeader();

    public abstract void assertAcqNewDBHeaderBodyText();

    public abstract void assertAcqNewDBHeaderTitleText();

    public abstract void checkAcquisitionTiles();

    public abstract void assertAcqNewDBTradeInTitleTextiOS();

    public abstract void assertAcqNewDBHBBTitleText();

    public abstract void assertAcqNewDBSIMOnlyTitleText();

    public abstract void assertAcqNewDBPAYMTitleText();

    public abstract void checkMoreToLoveSections() throws InterruptedException;

    public abstract void assertAcqNewDBMoreToLoveThirdOffer() throws InterruptedException;

    public abstract void swipeAcqMoreToLoveBodyLeft();

    public abstract void assertAcqNewDBMoreToLoveCTAText();

    public abstract void assertAcqNewDBMoreToLoveSecondOffer() throws InterruptedException;

    public abstract void assertAcqNewDBTitleText();

    public abstract void scrollDownToMoreToLoveTitle();

    public abstract void assertAcqNewDBMoreToLoveFirstOffer() throws InterruptedException;

    public abstract void checkVeryMeSections();

    public abstract void assertAcqNewDBVeryMeBodyText();

    public abstract void assertAcqNewDBVeryMeImageDisplayed();

    public abstract void assertAcqNewDBVeryMeTitleText();

    public abstract void checkFooterSection() throws InterruptedException;

    public abstract void assertAcqNewDBUKTitleDisplayed();

    public abstract void assertAcqNewDBUKBodyDisplayed() throws InterruptedException;

    public abstract void assertAcqNewDB14DayReturnBodyDisplayed();

    public abstract void assertAcqNewDB14DayReturnTitleDisplayed();

    public abstract void assertAcqNewDBFreeHomeDeliveryBodyDisplayed() throws InterruptedException;

    public abstract void assertAcqNewDBFreeHomeDeliveryTitleDisplayed();

    public abstract void assertAcqNewDBOnlineAssistBodyDisplayed() throws InterruptedException;

    public abstract void assertAcqNewDBOnlineAssistTitleDisplayed();

    public abstract void checkPressingXBtn();

    public abstract void assertAcqCTAText();

    public abstract void acqXIconCTA();

    public abstract void checkPressingBackBtn();

    public abstract void assertAcqCTATextAfterNavBack();

    public abstract void validateWhyVodafoneHeader();

    public abstract void navigateToAcquisitionBoard();

    public WebElement Acquisition_NewDB_PAYM_Title() {
        return Acquisition_NewDB_PAYM_Title;
    }

    public WebElement Acquisition_NewDB_Xicon() {
        return Acquisition_NewDB_Xicon;
    }

    public abstract void assertAcqOfferPageUrl() throws InterruptedException;

    public abstract void ClickOnAcqBackgroundImage();

    public abstract void ClickOnAcqBackgroundCTA();

    public abstract void CheckDiscoverHeader();
    public abstract void validateNewBasicDBHeader();
    public abstract  void clickOnAlreadyVodafoneCustomer();
    public abstract void validateWhyVodafoneV2 ()throws InterruptedException;

    public abstract void validateDiscoverVodafone();


    public abstract void validatePayMonthly() ;

    public abstract void validateSimOnly() ;

    public abstract void validateBroadbandCta() ;

    public abstract void validateTradeInTool() ;

    public abstract void validateLatestOffers();
}
