package pages.NativeExtras.ConfirmOptingExtra;

import models.response.NativeExtrasResponseModelAnalyticsVersion;
import org.testng.Assert;
import utils.NativeExtrasUtils;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmOptingExtraLogicAndroid extends ConfirmOptingExtraAbstract {
    NativeExtrasResponseModelAnalyticsVersion nativeExtrasResponseModelPhase1 = NativeExtrasUtils.getNativeExtrasResponseModelAnalyticsVersion();

    @Override
    public void validateConfirmOptOutExtraTrayIsOpened(String buttonName) {
        for (int i = 0; i < nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.size(); i++) {
            if (nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).cta != null && !nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).ctaDisabled && nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).cta.text.equals(buttonName)) {
                waitForVisibility(confirmScreenExtraTitle);
                Assert.assertEquals(nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.title, confirmScreenExtraTitle.getText());
                Assert.assertEquals(nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.description,confirmScreenExtraDescription.getText());
                Assert.assertTrue(nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.name.contains(confirmScreenExtraSubtitle.getText()));
                if (nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.productDetails != null)
                    Assert.assertEquals(nativeExtrasResponseModelPhase1.activeProducts.activeProductsDetails.get(i).confirmationCard.productDetails,confirmScreenExtraPrice.getText());
                AssertDisplayed(confirmScreenXCTA.isDisplayed());
                AssertDisplayed(confirmScreenBuyCTA.isDisplayed());
                break;
            }
        }
    }

    @Override
    public void clickOnXCTAOnRemoveConfirmationTray() {
        waitForVisibility(confirmScreenXCTA);
        confirmScreenXCTA.click();
    }

    @Override
    public void clickOnOptCTAOnOptingConfirmationTray() {
        confirmScreenBuyCTA.click();
    }

}
