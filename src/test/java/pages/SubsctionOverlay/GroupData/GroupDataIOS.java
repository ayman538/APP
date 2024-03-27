package pages.SubsctionOverlay.GroupData;

import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForInVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class GroupDataIOS extends GroupDataAbstract{

    public GroupDataIOS(){
        super();
    }

    DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();

    public void checkDashboardTilesRedLeader(){
        waitForVisibility(DB_AllowanceTileView);

        AssertResult(DB_AllowanceTileHeader.getText(),
                DashboardResponse.tiles.get(0).content.get(0).
                        headerFallback.replace("<b>","").
                        replace("</b>",""));

        AssertDisplayed(DB_billingTileContainer.isDisplayed());

        AssertDisplayed(DB_ControlTile.isDisplayed());

        AssertResult(DB_ControlTileSecondryCard.getText(),
                DashboardResponse.tiles.get(3).content.get(0).title.
                        replace("<b>","").
                        replace("</b>",""));

    }

    public void navigateToGroupDataTab(){
        waitForVisibility(DB_ControlTileSecondryCard);
        DB_ControlTileSecondryCard.click();
    }

    public void checkDataGroupCard(){
        waitForVisibility(GD_GroupDataCard);
        AssertDisplayed(GD_GroupDataCard.isDisplayed());
        AssertDisplayed(GD_GroupDataSubItemsValue.isDisplayed());
    }

    public void navigateToManageGroupData(){
        waitForVisibility(GD_GroupDataCard);
        scrollDownTo(GD_ManageGroupDataSharerArrow);
        GD_ManageGroupDataSharerArrow.click();
    }

    public void checkLimitSharerInManageGroupData(){
        waitForVisibility(MGD_CardTitle);
        if(MGD_setLimitValue.getText().equals("Off")){
            org.testng.Assert.assertFalse(MGD_CardSendTextCTA.isEnabled());
            MGD_CardBar.click();
        }

    }

    public void checkManageGroupDataCTA() {
        MGD_CardSendTextCTA.click();
        waitForInVisibility(MGD_CardTitle);
    }
}
