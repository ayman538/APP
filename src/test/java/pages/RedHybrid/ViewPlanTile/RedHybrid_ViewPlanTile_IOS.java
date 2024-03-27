package pages.RedHybrid.ViewPlanTile;

import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;

public class RedHybrid_ViewPlanTile_IOS extends RedHybrid_ViewPlanTile_Abstract {
    public RedHybrid_ViewPlanTile_IOS() {
        super();
    }


    @Override
    public void ValidatePlanTile() {
        DashboardV4ResponseModel dashboardResponse = DashboardUtils.GetDashboard();
        AssertDisplayed(PlanCard.isDisplayed());
        for (int i = 0; i < dashboardResponse.tiles.size(); i++) {
            if (dashboardResponse.tiles.get(i).tileType.equalsIgnoreCase("CHARGES_CREDIT")) {
                for (int j = 0; j < dashboardResponse.tiles.get(i).content.size(); j++) {
                    assertEquals(TitleOFPlanTile.getText(), dashboardResponse.tiles.get(i).content.get(j).header.replace("</b>", "").replace("<b>", ""));
                    assertEquals(PlanDetails.getText(), dashboardResponse.tiles.get(i).content.get(j).title);
                    assertEquals(ExpiryOrRenewText.getText(), dashboardResponse.tiles.get(i).content.get(j).footer);
                }
            }
        }

    }


}
