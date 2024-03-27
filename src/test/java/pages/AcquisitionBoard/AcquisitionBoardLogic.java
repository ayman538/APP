package pages.AcquisitionBoard;
import models.response.BasicDashboardResponseModel;

import org.openqa.selenium.WebElement;
import utils.BasicDashboardUtils;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

import static core.Config.getPlatformType;

@Deprecated
public class AcquisitionBoardLogic extends AcquisitionBoardPO {
    BasicDashboardResponseModel basicDashboardUtils= BasicDashboardUtils.getBasicDashboard();

    private final boolean navigated = false;

    public AcquisitionBoardLogic() {
        super();
    }

    public void checkAcquisitionHeader() {
        assertAcqNewDBHeaderTitleText();
        assertAcqNewDBHeaderBodyText();
    }

    public void assertAcqNewDBHeaderBodyText() {
        //AssertResult(Acquisition_NewDB_Header_Body.getText(), "Unlimited home broadband and unlimited mobile data in one great deal.");
        AssertResult(basicDashboardUtils.header.title,Acquisition_NewDB_Header_Title.getText());
       // System.out.println();
    }

    public void assertAcqNewDBHeaderTitleText() {
       AssertResult(Acquisition_NewDB_Header_Title.getText(), "Latest Offers");
       // AssertDisplayed(WhyVodafone_Title.isDisplayed());
        AssertResult(WhyVodafone_Title.getText(), "Why Vodafone");
    }

    public void checkAcquisitionTiles() {
        assertAcqNewDBPAYMTitleText();
        assertAcqNewDBSIMOnlyTitleText();
        assertAcqNewDBHBBTitleText();
        assertAcqNewDBTradeInTitleTextiOS();
    }

    public void assertAcqNewDBTradeInTitleTextiOS() {
        if (getPlatformType().equalsIgnoreCase("IOS")) {
            AssertResult(Acquisition_NewDB_TradeIn_Title.getText(), "Trade-in Tool");
        }
    }

    public void assertAcqNewDBHBBTitleText() {
        AssertResult(Acquisition_NewDB_HBBicon_Title.getText(), "Broadband");
    }

    public void assertAcqNewDBSIMOnlyTitleText() {
        AssertResult(Acquisition_NewDB_SIMonly_Title.getText(), "SIM only deals");
    }

    public void assertAcqNewDBPAYMTitleText() {
        AssertResult(Acquisition_NewDB_PAYM_Title.getText(), "Pay monthly phones");
    }

    public void checkDiscoverSections() {
        scrollDownToDiscoverCTA();
        checkDiscoverSectionTradeIniOS();
        assertAcqNewDBTitleText();
        assertAcqNewDBDiscoverBodyText();
        assertAcqNewDBDiscoverCTAText();
        swipeAcqDiscoverBodyLeft();
        assertAcqNewDBDiscoverTitleTextAfterSwipe();
        assertAcqNewDBDiscoverBodyTextAfterSwipe();
        assertAcqNewDBDiscoverCTAText();
    }

    public void assertAcqNewDBDiscoverBodyTextAfterSwipe() {
        AssertResult(Acquisition_NewDB_MoreToLove_Body.getText(), "The newest, fastest generation of mobile networking.");
    }

    public void assertAcqNewDBDiscoverTitleTextAfterSwipe() {
        waitForVisibility(Acquisition_NewDB_Moretolove_Title);
        AssertResult(Acquisition_NewDB_Moretolove_Title.getText(), "5G");
    }

    public void swipeAcqDiscoverBodyLeft() {
        SwipeToElement(Acquisition_NewDB_MoreToLove_Body, "Left");
    }

    public void assertAcqNewDBDiscoverCTAText() {
        AssertResult(Acquisition_NewDB_MoreToLove_Body.getText(), "Find out more");
    }

    public void assertAcqNewDBDiscoverBodyText() {
        AssertResult(Acquisition_NewDB_MoreToLove_Body.getText(), "Maintaining the reliability and capacity of our network is our number one priority");
    }

    public void assertAcqNewDBTitleText() {
        waitForVisibility(Acquisition_NewDB_Moretolove_Title);
        AssertResult(Acquisition_NewDB_Moretolove_Title.getText(), "Keep Connecting");
    }

    public void checkDiscoverSectionTradeIniOS() {
        if (getPlatformType().equalsIgnoreCase("IOS")) {
            checkDiscoverSectionsIOSTradeIN();
        }
    }

    public void scrollDownToDiscoverCTA() {
        scrollDownTo(Acquisition_NewDB_MoreToLove_CTA);
    }

    public void checkDiscoverSectionsIOSTradeIN() {
        AssertResult(Acquisition_NewDB_MoreToLove_Body.getText(), "Use our Trade-in Tool to find out if you're guaranteed a saving on iPhone 12");
        AssertResult(Acquisition_NewDB_MoreToLove_CTA.getText(), "Find out more");
        SwipeToElement(Acquisition_NewDB_MoreToLove_Body, "Left");
    }

    public void checkVeryMeSections() {
        assertAcqNewDBVeryMeTitleText();
        assertAcqNewDBVeryMeImageDisplayed();
        assertAcqNewDBVeryMeBodyText();
    }

    public void assertAcqNewDBVeryMeBodyText() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Body);
        AssertResult(Acquisition_NewDB_VeryMe_Body.getText(), "From savings on cinema tickets to your morning coffee on us - there's bound to be something you love with VeryMe Rewards on the My Vodafone app.");
    }

    public void assertAcqNewDBVeryMeImageDisplayed() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Image);
        AssertDisplayed(Acquisition_NewDB_VeryMe_Image.isDisplayed());
    }

    public void assertAcqNewDBVeryMeTitleText() {
        scrollDownTo(Acquisition_NewDB_VeryMe_Title);
        AssertResult(Acquisition_NewDB_VeryMe_Title.getText(), "VeryMeRewards");
    }

    public void checkFooterSection() {
        assertAcqNewDBOnlineAssistTitleDisplayed();
        assertAcqNewDBOnlineAssistBodyDisplayed();

        assertAcqNewDBFreeHomeDeliveryTitleDisplayed();
        assertAcqNewDBFreeHomeDeliveryBodyDisplayed();

        assertAcqNewDB14DayReturnTitleDisplayed();
        assertAcqNewDB14DayReturnBodyDisplayed();

        assertAcqNewDBUKTitleDisplayed();
        assertAcqNewDBUKBodyDisplayed();

    }

    public void assertAcqNewDBUKTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_UK);
        AssertDisplayed(Acquisition_NewDB_UK.isDisplayed());
    }

    public void assertAcqNewDBUKBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_UK_Body);
        AssertDisplayed(Acquisition_NewDB_UK_Body.isDisplayed());
    }

    public void assertAcqNewDB14DayReturnBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_14DayReturns_Body);
        AssertDisplayed(Acquisition_NewDB_14DayReturns_Body.isDisplayed());
    }

    public void assertAcqNewDB14DayReturnTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_14DayReturns_Title);
        AssertDisplayed(Acquisition_NewDB_14DayReturns_Title.isDisplayed());
    }

    public void assertAcqNewDBFreeHomeDeliveryBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_FreeHomeDelivery_Body);
        AssertDisplayed(Acquisition_NewDB_FreeHomeDelivery_Body.isDisplayed());
    }

    public void assertAcqNewDBFreeHomeDeliveryTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_FreeHomeDelivery_Title);
        AssertDisplayed(Acquisition_NewDB_FreeHomeDelivery_Title.isDisplayed());
    }

    public void assertAcqNewDBOnlineAssistBodyDisplayed() {
        scrollDownTo(Acquisition_NewDB_OnlineAssistance_Body);
        AssertDisplayed(Acquisition_NewDB_OnlineAssistance_Body.isDisplayed());
    }

    public void assertAcqNewDBOnlineAssistTitleDisplayed() {
        scrollDownTo(Acquisition_NewDB_OnlineAssistance_Title);
        AssertDisplayed(Acquisition_NewDB_OnlineAssistance_Title.isDisplayed());
    }

    public void checkPressingXBtn() {
        assertAcqCTAText();
    }

    public void assertAcqCTAText() {
        waitForVisibility(Acquisition_CTA);
        AssertResult(Acquisition_CTA.getText(), "See offers");
    }

    public void acqXIconCTA() {
        scrollUpTo(Acquisition_NewDB_Xicon);
        waitForVisibility(Acquisition_NewDB_Xicon);

        Acquisition_NewDB_Xicon.click();
    }

    public void checkPressingBackBtn() {
        acqCTA();
        assertAcqCTATextAfterNavBack();
    }

    public void assertAcqCTATextAfterNavBack() {
        scrollUpTo(Acquisition_NewDB_Xicon);
        waitForVisibility(Acquisition_NewDB_Xicon);

        driver.navigate().back();
        waitForVisibility(Acquisition_Link);
        AssertResult(Acquisition_CTA.getText(), "See offers");
    }

    public void acqCTA() {
      //  Acquisition_CTA.click();
    }


    public WebElement Acquisition_NewDB_PAYM_Title() {
        return Acquisition_NewDB_PAYM_Title;
    }

    public WebElement Acquisition_NewDB_Xicon() {
        return Acquisition_NewDB_Xicon;
    }



}
