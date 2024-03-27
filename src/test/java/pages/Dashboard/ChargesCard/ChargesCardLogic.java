package pages.Dashboard.ChargesCard;

import testdata.ReadResponse;

import java.util.HashMap;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;

@Deprecated

public class ChargesCardLogic extends ChargesCardPO {

    static private String segment = "";
    static private HashMap<String, String> chargesCardContent = null;
    static private boolean hideVOVStatus = false;
    static private String currentBalance = "";


    public void SetBeforeClass() {
        segment = ReadResponse.GetSegment();
        if (segment.equalsIgnoreCase("PREPAY"))
            currentBalance = ReadResponse.GetPAYGBalance();
        else
            chargesCardContent = ReadResponse.GetChargesCard();

    }

    public void beforeClass() {
        System.out.println("Validate the user segment ");
        segment = ReadResponse.GetSegment();
        if (segment.equalsIgnoreCase("PREPAY")) {
            System.out.println(" if the user segment is PREPAY");
            currentBalance = ReadResponse.GetPAYGBalance();
        } else {
            System.out.println(" Else the user segment is PREPAY");
            chargesCardContent = ReadResponse.GetChargesCard();
        }
    }

    public ChargesCardLogic() {
        super();
        waitForVisibility(DB_SettingDashboardTray_icon);
        if (!hideVOVStatus) {
            System.out.println("if the VOV displayed ");
            HideVOV(DB_VOVhideCTA);
            hideVOVStatus = true;
            System.out.println("Hide the VOV");
        }
    }

    public void checkChargesCardHeader() {
        System.out.println(" Given Check the Charges card header");
        if (segment.equalsIgnoreCase("PREPAY")) {
            assertChargesHeaderTextPREPAY();
        } else {
            assertChargesHeaderTextNonPREPAY();
        }
    }

    public void assertChargesHeaderTextPREPAY() {
        System.out.println(" if the user segment is PREPAY ");
        System.out.println("The actual billing tile header displayed is :" + DB_billingTileHeader.getText());
        AssertResult(DB_billingTileHeader.getText(), "Credit");
        System.out.println("Should the credit displayed ");
    }

    public void assertChargesHeaderTextNonPREPAY() {
        System.out.println("else the user segment is PREPAY");
        String header = chargesCardContent.get("header");
        System.out.println("the billing tile header displayed as :" + DB_billingTileHeader.getText());
        header = header.replaceAll("</b>", "");
        header = header.replaceAll("<b>", "");
        System.out.println("the billing tile header displayed as :" + DB_billingTileHeader.getText());
        AssertResult(DB_billingTileHeader.getText(), header);
        System.out.println("Should the the billing tile header");
    }

    public void checkChargesCardTitle() {
        System.out.println("Given Check the Charge card tile");
        if (segment.equalsIgnoreCase("PREPAY")) {
            assertChargesTitleTextPREPAY();
        } else {
            assertChargesTitleTextNonPREPAY();
        }
    }

    public void assertChargesTitleTextPREPAY() {
        System.out.println("if the segment user PREPAY");
        System.out.println("The billing tile title displayed as : " + DB_billingTileTitle.getText());
        AssertResult(DB_billingTileTitle.getText(), "Your current credit is:");
        System.out.println("The billing tile title displayed successfully");
    }

    public void assertChargesTitleTextNonPREPAY() {
        System.out.println("else the user segment is PREPAY");
        System.out.println("The billing tile title " + DB_billingTileTitle.getText());
        AssertResult(DB_billingTileTitle.getText(), chargesCardContent.get("title"));
        System.out.println("The billing title displayed successfully ");
    }

    public void checkChargesCardAmount() {
        System.out.println("Given check charge card amount");
        if (segment.equalsIgnoreCase("PREPAY")) {
            assertChargesAmountTextPREPAY();
        } else {
            assertChargesAmountTextNonPREPAY();
        }
    }

    public void assertChargesAmountTextPREPAY() {
        System.out.println("if the user us PREPAY");
        System.out.println("billing tile amount displayed as " + DB_billingTileAmount.getText());
        AssertResult(DB_billingTileAmount.getText(), currentBalance);
        System.out.println(" The billing tile amount displayed successfully ");
    }

    public void assertChargesAmountTextNonPREPAY() {
        System.out.println("Else the user is PREPAY");
        String amount = chargesCardContent.get("balance");
        amount = amount.replaceAll("Â", "");
        System.out.println("The billing tile amount displayed as " + DB_billingTileAmount.getText());
        AssertResult(DB_billingTileAmount.getText(), amount);
        System.out.println("the billing tile amount displayed successfully");
    }

    public void checkChargesCardFooter() {
        System.out.println("Given check charges card footer");

        if (segment.equalsIgnoreCase("PREPAY")) {
            assertChargesFooterTextPREPAY();
        } else {
            assertChargesFooterTextNonPREPAY();
        }
    }

    public void assertChargesFooterTextNonPREPAY() {
        System.out.println("else the user is segment PREPAY");
        System.out.println("The billing tile due date" + DB_billingTileDueDate.getText());
        AssertResult(DB_billingTileDueDate.getText(), chargesCardContent.get("billPeriod"));
        System.out.println("Should billing tile due date displayed successfully ");
    }

    public void assertChargesFooterTextPREPAY() {
        System.out.println("if the user segment PREPAY");
        System.out.println("The billing tile footer displayed as " + DB_billingTileFooter.getText());

        AssertResult(DB_billingTileFooter.getText(), "Top up");
        System.out.println("The billing tile footer displayed successfully");
    }

}
