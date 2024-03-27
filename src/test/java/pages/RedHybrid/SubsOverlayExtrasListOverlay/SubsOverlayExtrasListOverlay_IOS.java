package pages.RedHybrid.SubsOverlayExtrasListOverlay;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class SubsOverlayExtrasListOverlay_IOS extends SubsOverlayExtrasListOverlayAbstract {


    public SubsOverlayExtrasListOverlay_IOS() {
        super();
    }

    @Override
    public void clickOnSubsOverlayExtrasTab(){
        waitForVisibility(ExtrasTab);
        ExtrasTab.click();
        scrollDownTo(BuyExtrasCTA);

    }

    @Override
    public void clickOnBuyExtras(){
        waitForVisibility(BuyExtrasCTA);
        BuyExtrasCTA.click();
    }

    @Override
    public void ValidateThatExtrasTabOpens(){
        waitForVisibility(BuyExtrasCTA);
        AssertDisplayed(ExtrasTab.isDisplayed());
        AssertDisplayed(BuyExtrasCTA.isDisplayed());

    }

    @Override
    public void ValidateThatAddExtrasOverlayOpens(){
        waitForVisibility(addExtrasOverlaySubtitle);
        AssertDisplayed(addExtrasOverlaySubtitle.isDisplayed());
    }
}
