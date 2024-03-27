package pages.NewBilling;

import org.junit.jupiter.api.Assertions;

import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DirectDebitLogicAndroid extends DirectDebitAbstract {

    public DirectDebitLogicAndroid(){
        super();
    }

    @Override
    public void validateDirectDebitCardUI() {
        androidScrollToElement(Bill_DirectDebitCTA,"down");
        Assertions.assertEquals(Bill_DirectDebitDesc.getText(), "Set up or manage the payment of your monthly bill via direct debit");
        Assertions.assertEquals(Bill_DirectDebitCTA.getText(), "Direct Debit");
    }

    @Override
    public void clickOnDirectDebit(){
        androidScrollToElement(Bill_DirectDebitCTA,"down");
        waitForVisibility(Bill_DirectDebitCTA);
        AssertDisplayed(Bill_DirectDebitCTA.isDisplayed());
        Bill_DirectDebitCTA.click();
    }

    @Override
    public void checkOnDirectDebitScreen(){
        waitForVisibility(Bill_DirectDebitSSO);
        Assertions.assertEquals("Direct debit",Bill_DirectDebitSSO.getText());
        waitForVisibility(DirectDebitDetails);
        AssertDisplayed(DirectDebitDetails.isDisplayed());
    }

    @Override
    public void validateDirectDebitSSOXBtn(){
        waitForVisibility(DirectDebitDetails);
        AssertDisplayed(DirectDebitSSOCloseBtn.isDisplayed());



    }
}
