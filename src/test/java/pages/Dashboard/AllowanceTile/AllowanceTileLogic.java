package pages.Dashboard.AllowanceTile;

import org.json.simple.parser.ParseException;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ActionsHelpers.*;
@Deprecated
public class AllowanceTileLogic extends AllowanceTilePO {
    private boolean hideVOVStatus = false;
    //TODO Add the ios Id's

    public AllowanceTileLogic() {
        super();
    }

    public void setBeforeClass() {
        if (!hideVOVStatus) {
            HideVOV(DB_VOVhideCTA);
            hideVOVStatus = true;
        }
    }


    public void checkAllowanceTile() throws ParseException {
        //ToDo need to add the case of the allownce tiel with data ( more than on card )§
        //assertAllowanceCardText();
        assertAllowanceTileAllUsageDisplayed();
        assertUsageTabDisplayedAfterAllowanceTileCTA();
    }

    public void assertAllowanceTileAllUsageDisplayed() {
        AssertDisplayed(DB_AllowanceTileViewAllUsage.isDisplayed());
    }

    /*
    public void assertAllowanceCardText() throws ParseException {
        for (int i = 0; i < ReadResponse.getAllowanceTile().size() - 1; i++) {

            AssertResult(DB_AllowanceTileHeader.getText(), ReadResponse.getAllowanceTileHeader(i));
            AssertResult(DB_AllowanceTileSubTitle.getText(), ReadResponse.getAllowanceTileSubTitle(i));
            AssertResult(DB_AllowanceTileTitle.getText(), ReadResponse.getAllowanceTileTitle(i));
            AssertResult(DB_AllowanceTileUnit.getText(), ReadResponse.getAllowanceTileUnit(i));
            SwipeToElement(DB_AllowanceTileView, "Left");

        }
    }

     */

    public void assertUsageTabDisplayedAfterAllowanceTileCTA() {
        DB_AllowanceTileViewAllUsage.click();
        waitForVisibility(SO_UsageTab);
        AssertDisplayed(SO_UsageTab.isSelected());
    }

}
