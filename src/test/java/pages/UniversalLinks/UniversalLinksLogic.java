package pages.UniversalLinks;

import core.Config;
import models.response.SegmentResponseModel;
import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import utils.SegmentUtils;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.*;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class UniversalLinksLogic extends UniversalLinksPO {


    private final Config config=new Config ();
    private DX_IDM_FullLoginLogic_Abstract dx_idm_fullLoginLogic;
    public SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();


    public UniversalLinksLogic() {
        super();
        if (config.isAndroid()) dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_Android();
        if (config.isIos()) dx_idm_fullLoginLogic = new DX_IDM_FullLoginLogic_IOS();
    }

    public void navigateToPaymentFlow() {
        navigateToURL("myvodafone://VIEW_PAYMENT_CARD");
    }

    public void checkPaymentFlow() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        AssertDisplayed(RedHybrid_PaymentXIcon.isDisplayed());
    }

    public void UsageFlow() {
        navigateToURL("https://www.vodafone.co.uk/myvf/usage");
        Assert.assertEquals(usageTab.isSelected(), true);
    }

    public void faqsFlow() {
        navigateToURL("https://www.vodafone.co.uk/myvf/faqs");
        Assert.assertEquals(needSomeHelpTitle.isDisplayed(), true);

    }

    public void extrasFlow() {
        navigateToURL("https://www.vodafone.co.uk/myvf/extras");
        Assert.assertEquals(extrasTab.isSelected(), true);
    }

    public void topUpFlow() {
        navigateToURL("https://www.vodafone.co.uk/myvf/topup");
        if (segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            Assert.assertEquals(topUpTab.isSelected(), true);
        } else if (segmentResponseModel.segment.equalsIgnoreCase("CONSUMER")) {
            Assert.assertEquals(vodafoneLogoImageView.isDisplayed(), true);

        }
    }

    public void ValidateBroadBandServiceUniversalLink()
    {
        navigateToURL("https://www.vodafone.co.uk/myvf/bbservicetest");
    }
    public void ValidateSpendManagerUniversalLink()
    {
        navigateToURL("https://www.vodafone.co.uk/myvf/spendmanager");
    }
    public void ValidateDevicePlanUniversalLink()
    {
        navigateToURL("https://www.vodafone.co.uk/myvf/deviceplan");
    }

    //TODO
    public void softCloseApp(int duration) {
        runAppInBackground();
    }

    public void TradeInOpened() {
        navigateToURL("https://www.vodafone.co.uk/myvf/trade-in-tool");
        waitForVisibility(Trade_XIcon);
    }

    public void TradeInAfterHardClose() {
       killApp();
       startActivity();
        navigateToURL("https://www.vodafone.co.uk/myvf/trade-in-tool");
        waitForVisibility(Trade_XIcon);
    }

    public void TradeInWhileAppInBackground() {
        runAppInBackground();
        navigateToURL("https://www.vodafone.co.uk/myvf/trade-in-tool");
        waitForVisibility(Trade_XIcon);
    }

    //TODO
    public void hardClose() {
        killApp();
        startActivity();
    }

    //TODO
    public void fullLogin() throws InterruptedException {
        dx_idm_fullLoginLogic.loginJourney();
    }

    //TODO
    public void loginWithPin() throws InterruptedException {
        dx_idm_fullLoginLogic.enterPINAndClickOnContinue();
    }

    public void ValidateBillingUniversalLink() {
        navigateToURL("http://www.vodafone.co.uk/myvf/viewbill");
        waitForVisibility(Bill_Xicon);
    }

    public void ValidateYourPlanUniversalLink()
    {
        navigateToURL("https://www.vodafone.co.uk/myvf/yourplan");
    }

    public void ValidateAccountSettingsUniversalLink(){
        navigateToURL("https://www.vodafone.co.uk/myvf/accountsetting");
    }

    public void validateCardsAndPaymentsUniversalLink(){
        navigateToURL("https://www.vodafone.co.uk/myvf/cardsandpayments");
    }

    public void clickOnControlsAndLimitsUniversalLink() {
        navigateToURL("https://www.vodafone.co.uk/myvf/controlsandlimits");
    }

    public void validateExtrasControlsTabIsOpened() {
        if ((segmentResponseModel.segment.equalsIgnoreCase("CONSUMER") || segmentResponseModel.segment.equalsIgnoreCase("SOLE_TRADER")) && segmentResponseModel.subscriptionType.name.equalsIgnoreCase("MPS")) {
            Assert.assertEquals(controlTab.isSelected(), true);
        } else{
            Assert.assertEquals(extrasTab.isDisplayed(), true);
        }
    }

    public void clickOnExtrasUniversalLink() {
        navigateToURL("https://www.vodafone.co.uk/myvf/extras");
    }


    public void validateNewExtrasTabIsOpened() {
         waitForVisibility(shopExtrasCard);
        Assert.assertTrue(shopExtrasCard.isDisplayed());

}}

