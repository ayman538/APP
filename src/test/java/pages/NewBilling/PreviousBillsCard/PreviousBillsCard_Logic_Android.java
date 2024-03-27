package pages.NewBilling.PreviousBillsCard;

import models.response.BillingDashboardResponseModel;
import org.testng.Assert;
import utils.BillingDashboardUtils;

import java.util.Locale;

import static utils.element_helpers.ScrollHelpers.scrollDown;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class PreviousBillsCard_Logic_Android extends PreviousBillsCard_Abstract{

    public PreviousBillsCard_Logic_Android(){super();}

    BillingDashboardResponseModel billingDashboardResponse = BillingDashboardUtils.getBills();

    @Override
    public void iScrollDownToPreviousBillCard(){
        scrollDown();
        waitForVisibility(Previous_Bill_Title);
        AssertDisplayed(Previous_Bill_Title.isDisplayed());
    }

    @Override
    public void iShouldValidatePreviousBillCardContent() {
     Assert.assertEquals(billingDashboardResponse.previousBills.bills.get(0).title, Month_Name.getText());
     AssertDisplayed(Billing_Period.isDisplayed());
     Assert.assertEquals(billingDashboardResponse.previousBills.bills.get(0).billAmount, Bill_Amount.getText());
     Assert.assertEquals(billingDashboardResponse.previousBills.action.text, LoadMore_CTA.getText());
    }

    @Override
    public void iCheckLoadMoreCTAFunctionality() {
        int Bill_Size = billingDashboardResponse.previousBills.bills.size();
        if (Bill_Size >= 9 ){
            LoadMore_CTA.click();
            scrollDown();
            LoadMore_CTA.click();
            HardAssertNotDisplayed(String.valueOf(LoadMore_CTA), false);
        }
        else if (Bill_Size < 8 && Bill_Size > 4){
            LoadMore_CTA.click();
            HardAssertNotDisplayed(String.valueOf(LoadMore_CTA), false);
        }
        else {
            HardAssertNotDisplayed(String.valueOf(LoadMore_CTA), false);
        }
    }

    @Override
    public void iClickOnArrowIcon() {
        waitForVisibility(Arrow_Icon);
        Arrow_Icon.click();
    }

    @Override
    public void iValidateThePreviousBillReinventJourneyIsOpen() {
        waitForVisibility(PreviousBillCard_ReinventJourney);
        String actualText = PreviousBillCard_ReinventJourney.getText();
        System.out.println(actualText.substring(0, 8).toLowerCase(Locale.ROOT));
        AssertResult(actualText.substring(0, 8).toLowerCase(Locale.ROOT), "previous");
    }
}