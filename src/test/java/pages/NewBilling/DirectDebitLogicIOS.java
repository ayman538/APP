package pages.NewBilling;

import org.junit.jupiter.api.Assertions;
import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class DirectDebitLogicIOS extends DirectDebitAbstract{

    public DirectDebitLogicIOS(){

    }

    @Override
    public void validateDirectDebitCardUI() {
        if (!Bill_DirectDebitCTA.isDisplayed()) {
            scrollDownTo(Bill_DirectDebitCTA);
        } else {
            Assertions.assertEquals(Bill_DirectDebitDesc.getText(), "Set up or manage the payment of your monthly bill via direct debit");
            Assertions.assertEquals(Bill_DirectDebitCTA.getText(), "Direct Debit");
        }
    }

    @Override
    public void clickOnDirectDebit(){
        if(elementIsPresent(Bill_DirectDebitCTA)){
            Bill_DirectDebitCTA.click();
        }
        else {
        scrollDownTo(Bill_DirectDebitCTA);
        waitForVisibility(Bill_DirectDebitCTA);
        AssertDisplayed(Bill_DirectDebitCTA.isDisplayed());
        Bill_DirectDebitCTA.click();
        }
    }

    @Override
    public void checkOnDirectDebitScreen(){
        waitForVisibility(Bill_DirectDebitSSO);
        Assert.assertEquals("Direct debit",Bill_DirectDebitSSO.getText());
        waitForVisibility(DirectDebitDetails);
        AssertDisplayed(DirectDebitDetails.isDisplayed());
    }
    @Override
    public void validateDirectDebitSSOXBtn(){
        waitForVisibility(WV_Xicon);
        AssertDisplayed(WV_Xicon.isDisplayed());

    }
}
