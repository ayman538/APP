package pages.SubsctionOverlay.NewPlanDesign.OneNumberCard;

public abstract class OneNumberCard_Abstract extends OneNumberCardPO {
    public OneNumberCard_Abstract(){
        super();
    }



    public abstract void navigateToPlanTab();
    public abstract void validateImage();
    public abstract void assertPlanOneNoImageDisplayedNonMBB();
    public abstract void assertPlanOneNoImageDisplayedMBB();
    public abstract void assertElementNotExistForMBB();
    public abstract void validateTitle();
    public abstract void assertPlanOneNoTitleTextMBB();
    public abstract void assertPlanOneNoTitleDisplayedMBB();
    public abstract void validateDescription();
    public abstract void assertPlanOneNoDescriptionTextNonMBB();
    public abstract void assertPlanOneNoDescriptionDisplayedMBB();
    public abstract void validateCTAsDisplayed();
    public abstract void assertPanOneNoFindOutMoreTextNonMBB();
    public abstract void assertPlanOneNoGetConnectedTextNonMBB();
    public abstract void assertPanOneNoFindOutMoreDisplayedMBB();
    public abstract void assertPlanOneNoManageDevicesTextNonMBB();
    public abstract void assertPlanOneNoManageDevicesDisplayedMBB();
    public abstract void validateCTAsFunctional() throws InterruptedException;
    public abstract void DoneCTA();
    public abstract void PlanOneNoGetConnectedCTA();
    public abstract void PlanOneNoManageDevicesCTA();
    public abstract void assertDoneCTADisplayed();
    public abstract void PlanOneNoFindOutMoreCTA() throws InterruptedException;
    public abstract void assertPlanOneNoGetConnectedDisplayedMBB();
    public abstract void clickOnYourPlanAndNavigateToOneNumberCard();
    public abstract void clickOnGetConnectedCTA();
    public abstract void clickOnFindOutMoreCTA();
    public abstract void assertThatGetConnectedWebViewIsDisplayedSuccessfully();
    public abstract void assertThatFindOutMoreWebViewIsDisplayedSuccessfully();
    public abstract void ClickOnYourPlanAndNavigateToTheNewOneNumber();
    public abstract void AssertOneNumberTitleAndBody();
    public abstract void ClickOnAddaConnectionCTA(int No);
    public abstract void AssertOneNumberPortalWeb();
    public abstract void AssertSubscriptionTray();
    public abstract void ClickOnViewDetailsCTA();
    public abstract void AssertMangeSubsctionTray();
    public abstract void assertOneNumberAgreementSectionAndManageConnectionCTA();
    public abstract void clickOnTooltipIcon();
    public abstract void validateTooltipContent();
    public abstract void clickOnToolTipThanksCTA();
    public abstract void clickOnManageConnectionCTA();
    public abstract void validateTheExistenceOfVideoPlayer();
    public abstract void clickOnVideoPlayerInOneNumberCard();
}
