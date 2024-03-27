package pages.SubsctionOverlay;

import testdata.ReadResponse;

import static core.Config.getSegment;
import static utils.element_helpers.VerifyHelpers.AssertResult;


@Deprecated
public class TabMenuVariationLogic extends TabMenuVariationPO {

    public TabMenuVariationLogic() {
        super();
    }

    public void Validate() {
        String segment = ReadResponse.GetSegment();

        if (getSegment().toLowerCase().contains("consumer")) {
            assertSOPlanTabTextBingo();
            assertSODevicePlanTabTextBingo();
        } else {
            assertSOPlanTabTextNonBingo();
        }

        assertSOUsageTabText();

        if (getSegment().toLowerCase().contains("consumer")) {
            assertSOGroupDataTabTextRed();
        }

        assertSOExtrasTabText();

        if (segment.equalsIgnoreCase("PREPAY")) {
            assertSOTopUpTabTextPREPAY();
        } else {
            assertSOCahrgesTabTextNonPREPAY();
        }
    }

    public void assertSOCahrgesTabTextNonPREPAY() {
        AssertResult(SO_ChargesTab.getText(), "Charges");
    }

    public void assertSOTopUpTabTextPREPAY() {
        AssertResult(SO_TopUpTab.getText(), "Top up");
    }

    public void assertSOExtrasTabText() {
        AssertResult(SO_ExtrasTab.getText(), "Extras");
    }

    public void assertSOGroupDataTabTextRed() {
        AssertResult(SO_DataGroupTab.getText(), "Group Data");
    }

    public void assertSOUsageTabText() {
        AssertResult(SO_UsageTab.getText(), "Usage");
    }

    public void assertSOPlanTabTextNonBingo() {
        AssertResult(SO_PlanTab.getText(), "Plan");
    }

    public void assertSODevicePlanTabTextBingo() {
        AssertResult(SO_DevicePlanTab.getText(), "Device plan");
    }

    public void assertSOPlanTabTextBingo() {
        AssertResult(SO_PlanTab.getText(), "Airtime plan");
    }
}
