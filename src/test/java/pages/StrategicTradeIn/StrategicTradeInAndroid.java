package pages.StrategicTradeIn;

import org.testng.Assert;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class StrategicTradeInAndroid extends StrategicTradeInAbstract{
    public StrategicTradeInAndroid() {super();
    }

    @Override
    public void assertAcqNewDBHeaderTitleText() {
        waitForVisibility(Acquisition_NewDB_Header_Title);
        AssertResult(Acquisition_NewDB_Header_Title.getText(), "Vodafone Together");
    }

    @Override
    public void goToStrategicTradeInPage() {
        scrollDownTo(Acquisition_NewDB_StrategicTradeInFindOutMoreBtn);
        Acquisition_NewDB_StrategicTradeInFindOutMoreBtn.click();
    }

    @Override
    public  void clickOnTradeInIcon()
    {
        waitForVisibility(TradeInIcon);
        TradeInIcon.click();
    }

    @Override
    public void clickOnTradeInAssistanceLink() {
        scrollDownTo(DB_TradeInLink);
        DB_TradeInLink.click();
    }


    @Override
    public void verifyStrategicTradeInPageTitle() {
        waitForVisibility(strategicTradeInTitle);
        Assert.assertTrue(strategicTradeInTitle.isDisplayed());
    }
}
