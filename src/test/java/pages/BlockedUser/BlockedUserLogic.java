package pages.BlockedUser;

import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class BlockedUserLogic extends BlockedUserPO {

    public BlockedUserLogic() {
        super();
    }

    private final String BlockedCantUseExpectedText = "We're working on it. The My Vodafone app isn't currently available for business customers. But we'll be updating the app soon - watch this space.";
    private final String BlockedSettingExpectedText = "If you want to access your app settings, you can do this below. If you've changed something, you might need to reset the app – which you can do here.";

    public void ValidateCantUseCardTitle() {
        assertCantUseTitleText();
    }

    public void assertCantUseTitleText() {
        waitForVisibility(BlockedU_CantUseTitle);
        AssertResult(BlockedU_CantUseTitle.getText(), "Why can't I use the app for my business?");
    }

    public void ValidateCantUseCardText() {
        assertCantUseBodyText();
    }

    public void assertCantUseBodyText() {
        waitForVisibility(BlockedU_CantUseText);
        AssertDisplayed(BlockedU_CantUseText.getText().contains(BlockedCantUseExpectedText));
    }

    public void ValidateCantUseCardCTAText() {
        assertFAQsText();
    }

    public void assertFAQsText() {
        waitForVisibility(BlockedU_FAQsCTA);
        AssertResult(BlockedU_FAQsCTA.getText(), "Go to FAQs");
    }

    public void ValidateCantUseCardCTA() {
        assertDoneCTADisplayed();
        DoneCTA();
    }

    public void DoneCTA() {
        DoneCtaInExternalbrowser.click();
    }

    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }

    public void FAQsCTA() {
        waitForVisibility(BlockedU_FAQsCTA);
        BlockedU_FAQsCTA.click();
    }

    public void ValidateSettingCardTitle() {
        assertSettingTitleText();
    }

    public void assertSettingTitleText() {
        scrollDownTo(BlockedU_SettingTitle);
        waitForVisibility(BlockedU_SettingTitle);
        AssertResult(BlockedU_SettingTitle.getText(), "Want to manage your settings?");
    }

    public void ValidateSettingCardText() {
        assertSettingBodyText();
    }

    public void assertSettingBodyText() {
        scrollDownTo(BlockedU_SettingTitle);
        waitForVisibility(BlockedU_SettingText);
        AssertResult(BlockedU_SettingText.getText(), BlockedSettingExpectedText);
    }

    public void ValidateSettingCardCTAText() {
        assertSettingCTAText();
    }

    public void assertSettingCTAText() {
        scrollDownTo(BlockedU_SettingTitle);
        waitForVisibility(BlockedU_GoToSettingCTA);
        AssertResult(BlockedU_GoToSettingCTA.getText(), "Go to settings");
    }

    public void ValidateSettingCardCTA() {
        assertAppSettingTitleDisplayed();
    }

    public void assertAppSettingTitleDisplayed() {
        waitForVisibility(AS_ScreenTitle);
        AssertDisplayed(AS_ScreenTitle.isDisplayed());
    }

    public void SettingCTA() {
        scrollDownTo(BlockedU_SettingTitle);
        waitForVisibility(BlockedU_GoToSettingCTA);
        BlockedU_GoToSettingCTA.click();
    }

}
