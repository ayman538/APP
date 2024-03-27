package pages.RedHybrid.ViewPlanTile;

import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;

public class RedHybrid_ViewPlanTile_Android extends RedHybrid_ViewPlanTile_Abstract {

    public RedHybrid_ViewPlanTile_Android() {
        super();
    }


    @Override
    public void ValidatePlanTile() {
        DashboardV4ResponseModel dashboardObject = DashboardUtils.GetDashboardRedHybrid();
        AssertDisplayed(PlanCard.isDisplayed());
        for (int i = 0; i < dashboardObject.tiles.size(); i++) {
            if (dashboardObject.tiles.get(i).tileType.equalsIgnoreCase("CHARGES_CREDIT")) {
                for (int j = 0; j < dashboardObject.tiles.get(i).content.size(); j++) {
                    assertEquals(TitleOFPlanTile.getText(), dashboardObject.tiles.get(i).content.get(j).header.replace("</b>", "").replace("<b>", ""));
                    assertEquals(PlanDetails.getText(), dashboardObject.tiles.get(i).content.get(j).title);
                    assertEquals(ExpiryOrRenewText.getText(), dashboardObject.tiles.get(i).content.get(j).footer);
                }
            }
        }
    }
}
