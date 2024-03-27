package pages.Dashboard.CreditTilePayG;

import models.response.DashboardV4ResponseModel;
import models.response.SegmentResponseModel;
import org.junit.jupiter.api.Assertions;
import org.testng.Assert;
import org.testng.SkipException;
import utils.DXIDMUtils;
import utils.DashboardUtils;
import utils.SegmentUtils;

import static utils.element_helpers.TextHelpers.html2text;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class CreditTilePayGAndroid extends CreditTilePayGAbstract{

    public CreditTilePayGAndroid() {super();}


    DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
    SegmentResponseModel segmetResponseModel = SegmentUtils.GetSegment();


    @Override
    public void ValidateCreditHeaderTextPREPAY() {

        assertCreditHeaderTextPREPAY();
    }

    @Override
    public void ValidateCreditTitleTextPREPAY() {

        assertCreditTitleTextPrePayIsLow();
        //yellow lozenge

    }

    @Override
    public void ValidateCreditAmountTextPREPAY() {

        assertCreditAmountTextPREPAYIsLow();

    }

    @Override
    public void ValidateCreditFooterTextPREPAY() {

        assertCreditFooterTextPREPAY();

    }

    @Override
    public void assertCreditHeaderTextPREPAY() {
        waitForVisibility(DB_creditTileHeader);
        AssertDisplayed(DB_creditTileHeader.isDisplayed());
        AssertResult(DB_creditTileHeader.getText(),"Top up credit");
    }

    @Override
    public void assertCreditTitleTextPrePayIsLow() {
        waitForVisibility(DB_creditTileText);
        AssertDisplayed(DB_creditTileText.isDisplayed());
        AssertResult(DB_creditTileText.getText(),"Your credit is low");
    }

    @Override
    public void assertCreditTitleTextPrePay() {

        waitForVisibility(DB_creditTileText);
        AssertDisplayed(DB_creditTileText.isDisplayed());
//        System.out.println(DB_creditTileText.getText());
        AssertResult(DB_creditTileText.getText(),"Your current credit is:");

    }


    @Override
    public void assertCreditAmountTextPREPAYIsLow() {
        waitForVisibility(DB_creditTileAmount);
        AssertDisplayed(DB_creditTileAmount.isDisplayed());
        String stringAmount=DB_creditTileAmount.getText().replace("£","");
        float floatAmount= Float.parseFloat(stringAmount);
        boolean low= false;
        if (floatAmount < 5.00) {
            low= true;
            Assertions.assertTrue(low);
        }
        else throw new SkipException("the user credit is greater than 5");
    }

    @Override
    public void ValidateChargesTile() {
        String TileHeader;
        String Title;
        String TileFooter;
        DashboardV4ResponseModel DashboardResp = DashboardUtils.GetDashboard(
                System.getProperty("SwitchedMSISDN"),
                System.getProperty("SwitchedSegment"),
                System.getProperty("SwitchedSubsType"),
                DXIDMUtils.getLOA1Token(System.getProperty("SwitchedMSISDN")),
                System.getProperty("SwitchedAccount"));
        TileHeader = html2text(DashboardResp.tiles.get(0).content.get(0).header);
        Title = html2text(DashboardResp.tiles.get(0).content.get(0).title);
        TileFooter = html2text(DashboardResp.tiles.get(0).content.get(0).footer);
        for (int i = 0; i < DashboardResp.tiles.size() - 1; i++) {
            if (DashboardResp.tiles.get(i).tileType.equals("CHARGES_CREDIT")) {
                AssertResult(DB_creditTileHeader.getText(), TileHeader);
                AssertResult(DB_creditTileText.getText(), Title);
                AssertResult(DB_creditTileFooter.getText(), TileFooter);
                AssertResult(DB_creditTileAmount.getText(), DashboardResp.tiles.get(0).content.get(0).balance);
                break;
            }
        }
    }

    @Override
    public void ValidateTilesForHbbUser() {
        DashboardV4ResponseModel DashboardResp = DashboardUtils.GetDashboard();
        String subscritionType = DashboardResp.tiles.get(0).content.get(0).allowanceType;
        AssertResult(subscritionType, "BB");
    //chrges tile
        String   TileHeader = DashboardResp.tiles.get(1).content.get(0).header.replace("<b>", "").replace("</b>", "");
        String  TileFooter = DashboardResp.tiles.get(1).content.get(0).footer;
        String chargesTile = DashboardResp.tiles.get(1).tileType.replace("<b>", "").replace("</b>", "");
       AssertResult(chargesTile, "CHARGES_CREDIT");
        AssertResult(DB_creditTileHeader.getText(), TileHeader);
        AssertResult(DB_creditTileFooter.getText(), TileFooter);
        //Secondary control tile
        String broadbandTile = DashboardResp.tiles.get(3).content.get(0).title.replace("<b>", "").replace("</b>", "");
        AssertResult(broadbandTile, "Broadband Service Test");
        System.out.println(broadbandTile);
        //primary control tile
        String planTile = DashboardResp.tiles.get(2).content.get(0).title.replace("<b>", "").replace("</b>", "");
        AssertResult(planTile, "Your Plan");
    }



    @Override
    public void assertCreditAmountTextPREPAY() {

        waitForVisibility(DB_creditTileAmount);
        AssertDisplayed(DB_creditTileAmount.isDisplayed());
        String stringAmount=DB_creditTileAmount.getText().replace("£","");
        System.out.println(stringAmount);
        float floatAmount= Float.parseFloat(stringAmount);
        boolean low= true;
        if (floatAmount >= 5.00){
            low= false;
            Assert.assertFalse(low);
        }
        else throw new SkipException("the user credit is lower than 5");
    }


    @Override
    public void assertCreditFooterTextPREPAY() {
        waitForVisibility(DB_creditTileFooter);
        AssertDisplayed(DB_creditTileFooter.isDisplayed());
        AssertResult(DB_creditTileFooter.getText(),"Top up now");
        System.out.println(DB_creditTileFooter.getText());
    }

    @Override
    public void creditTileIsDisplayed() {

        waitForVisibility(DB_creditTileIcon);
        AssertDisplayed(DB_creditTileIcon.isDisplayed());
    }

    @Override
    public void assertCreditTile() throws Exception {

        for(int i = 0; i < DashboardResponse.tiles.size() - 1; i++) {
            if (DashboardResponse.tiles.get(i).tileType.equals("CHARGES_CREDIT")) {
                AssertResult(DB_creditTileHeader.getText(),DashboardResponse.tiles.get(i).content.get(0).header.replace("<b>","").replace("</b>",""));
                AssertResult(DB_creditTileText.getText(), DashboardResponse.tiles.get(i).content.get(0).title.replace("<b>","").replace("</b>",""));
                AssertResult(DB_creditTileAmount.getText(), DashboardResponse.tiles.get(i).content.get(0).balance);
                AssertResult(DB_creditTileFooter.getText(), DashboardResponse.tiles.get(i).content.get(0).footer.replace("<u>","").replace("</u>",""));
            }
        }
    }
    @Override
    public void ValidateVestaJoruneys() {
        String segment = segmetResponseModel.segment;
        String subsType = segmetResponseModel.subscriptionType.name;
        //mbb
        if (segment.equalsIgnoreCase("PREPAY") && subsType.equalsIgnoreCase("MBB")) {
            AssertResult(AddDataPack.getText(),"Add a data Pack");
        }
        AssertResult(TopUpThisNumberByCard.getText(),"Top up this number by card");
        AssertResult(AutoTopUp.getText(),"Auto top up");
        AssertResult(ManagePaymentCards.getText(),"Manage payment cards");
        AssertResult(ActivateVoucher.getText(),"Activate voucher");
        AssertResult(TopUpWithPayPal.getText(),"Top up with PayPal");
        AssertResult(TopUpAnyNumber.getText(),"Top up any number");
    }
    @Override
    public void ValidateVestaJoruneysforPayGChild() {
        String segment = segmetResponseModel.segment;
        String subsType = segmetResponseModel.subscriptionType.name;
        //mbb
        if (segment.equalsIgnoreCase("PREPAY") && subsType.equalsIgnoreCase("MBB")) {
            AssertResult(AddDataPack.getText(),"Add a data Pack");
        }
        AssertResult(ActivateVoucher.getText(),"Activate voucher");
        AssertResult(TopUpWithPayPal.getText(),"Top up with PayPal");
        AssertResult(TopUpAnyNumber.getText(),"Top up any number");
    }

    @Override
    public void navigateToPlanPayg() {
        waitForVisibility(PaygPlan);
        PaygPlan.click();
    }

    @Override
    public void navigateToBugBigValue() {
        waitForVisibility(DB_ControlTileSecondryCard);
        DB_ControlTileSecondryCard.click();
    }

    @Override
    public void validateBigValueBundleScreen() {
        if(!elementIsPresent(Extras_TabContainer)) {
            AssertResult(WV_Title.getText(), "Big Value Bundle");
            waitForVisibility(SSO_BigValue);
            Assert.assertTrue(SSO_BigValue.getText().contains("Add or manage"));
        }
    }

    @Override
    public void validatePlanForPayg() {
        AssertDisplayed(plancontainerPAYG.isDisplayed());
    }

    @Override
    public void validateUsageForPayg() {
        AssertDisplayed(usagecontainerPAYG.isDisplayed());
    }

}


