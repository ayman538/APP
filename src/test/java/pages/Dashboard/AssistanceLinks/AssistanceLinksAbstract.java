package pages.Dashboard.AssistanceLinks;

import java.util.List;

public abstract class AssistanceLinksAbstract extends AssistanceLinksPO{

    public AssistanceLinksAbstract(){
        super();
    }

    public abstract void AssistanceLinksStatus();

    public abstract void ValidateAssistanceLinksOrderAndText();

    public abstract List<String> getAPIAssistanceLinksText();

    public abstract void ValidateAssistanceLinksCTA() throws InterruptedException;

    //public abstract void assertFreeBusinessLinkText();

    public abstract void assertAssistanceTitleText();
    public abstract void assertNotificationsIsRemoved();
    public abstract void ValidateAssistanceLinksOrderAndTextAfterNotificationIsRemoved();

    public abstract void assertOnlyFourLinksDisplayed(int count);

    public abstract void assertAssistanceStatus();

    public abstract void assistanceLinkSeeMoreCTA();

    public abstract void assertDoneCTADisplayedFreeBusiness();

    public abstract void DoneCTAAfterFreeBusiness();

    //public abstract void assertNotificationLinkText();

    //public abstract void assertBatteryRefreshText();

    //public abstract void assertFindStoreLinkText();

    //public abstract void assertFAQsText();

    //public abstract void assertTradInText();

    //public abstract void assertTrackOrderText();

    public abstract void CheckNotificationScreen();

    public abstract void notificationXIconCTA();

    public abstract void assertNotificationTitleText();

    public abstract void CheckStoreLocator();

    public abstract void doneCTA();

    public abstract void assertDoneCTADisplayed();

    //public abstract void findStoreCTA();

    public abstract void checkTopUpFriend();

 //   public abstract void checkConnectAnotherDevice();

    public abstract void checkManageYouDevice();

    public abstract void CheckTrackAnOrder();

    public abstract void trackOrderXIconCTA();

    public abstract void assertTrackOrderTitleText();

    public abstract void checkBatteryRefresh();

    //public abstract void BatteryRefreshCTA();

    //public abstract void BatteryRefreshXIconCTA();

    public abstract void assertBatteryRefreshXIconDisplayed();

    public abstract void BatteryRefreshBackCTA();

    public abstract void CheckFAQs();

    public abstract void DoneCTAAfterFAQs();

    public abstract void assertDoneCTADisplayedFAQs();

     public abstract void CheckTradeIN();

   // public abstract void TradeInXIconCTA();

   // public abstract void assertTradInXIconDisplayed();

    public abstract void validateConnectedAnotherDeviceAndTradeinLinksIsRemoved();

    public abstract void assistanceLinkSeeLessCTA();

    public abstract void scrollDownToAssistanceLinks();

    public abstract void CheckChildAssistanceLinks();

    public abstract void ClickOnBatteryRefresh() ;

    public abstract void ValidateBatteryRefreshPage() ;

    public abstract void CheckBatteryRefreshExistence();

    public abstract void checkFreeBuisnessSupport();

    public abstract void checkBatteryRefreshForPAYG();


    /*

    public abstract void trackOrderCTA();

    public abstract void TradeInCTA();



    public abstract void FAQCTA();

    public abstract void CheckOneNumber(WebElement element);

    public abstract void notificationsLinkCTA();

    public abstract void ValidateOneNumberLink();

    public abstract void assertManageDeviceLinkTextForNonPREPAY();

    public abstract void assertManageDeviceLinkTextForPREPAY();

    public abstract void ValidateAssistanceLabel();

    public abstract void ValidateFreeBusinessLink();

    public abstract void FreeBusinessCTA();

    public abstract void ValidateNotificationLink();

    public abstract void ValidateOneNumberLinkFunc();

    public abstract void assertManageDeviceLinkCTAForNonPREPAY();

    public abstract void assertManageDeviceLinkCTAForPREPAY();

    public abstract void ValidateFAQsLink();

    public abstract void ValidateTradeInLink();

    public abstract void ValidateStoreLocatorLink();

    public abstract void ValidateTrackAndOrderLink();
     */
}

