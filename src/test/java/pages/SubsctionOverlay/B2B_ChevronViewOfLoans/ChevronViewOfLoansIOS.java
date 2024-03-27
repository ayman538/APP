package pages.SubsctionOverlay.B2B_ChevronViewOfLoans;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;

public class ChevronViewOfLoansIOS extends ChevronViewOfLoansAbstract {

    public ChevronViewOfLoansIOS(){
        super();
    }
    @Override
    public void validateChevronIconFunctionalityofFirstLoan() {
        AssertDisplayed(chevronIconOfFirstLoan.isDisplayed());
        AssertDisplayed(extrasSection.isDisplayed());
        chevronIconOfFirstLoan.click();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } ;
        Assert.assertFalse(extrasSection.isDisplayed());
        System.out.println(" loan card is in closed accordion view after" + "clicking on the chevron icon of the first loan");
    }



    @Override
    public void validateChevronIconFunctionalityofSecondLoan() {
        chevronIconOfSecondLoan.click();
        scrollDownTo(ManageDevicePlansCTA);
        AssertDisplayed(extrasSection.isDisplayed());
    }

    @Override
    public void validateChevronIconnotdisplayed() {
        Assert.assertFalse(elementIsPresent(chevronIconOfFirstLoan));
    }
}
