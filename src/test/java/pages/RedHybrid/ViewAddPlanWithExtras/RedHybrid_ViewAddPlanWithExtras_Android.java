package pages.RedHybrid.ViewAddPlanWithExtras;

import models.response.DashboardV4ResponseModel;
import utils.DashboardUtils;

import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_ViewAddPlanWithExtras_Android extends RedHybrid_ViewAddPlanWithExtras_Abstract{

    DashboardV4ResponseModel dashboardModel = DashboardUtils.GetDashboardRedHybrid();

    public RedHybrid_ViewAddPlanWithExtras_Android(){
        super();
    }
    @Override
    public void validateAddPlanCard() {
        waitForVisibility(RH_AddPlanCard);
        AssertDisplayed(RH_AddPlanCard.isDisplayed());
    }

    @Override
    public void validateAddPlanCardContent() {
        AssertDisplayed(RH_AddPlanCardSign.isDisplayed());
        assertEquals(dashboardModel.tiles.get(0).content.get(0).title,RH_AddPlanCardTitle.getText());
        System.out.println(dashboardModel.tiles.get(0).content.get(0).title);
        assertEquals(dashboardModel.tiles.get(0).content.get(0).subtitle,RH_AddPlanCardSubTitle.getText());
        System.out.println(dashboardModel.tiles.get(0).content.get(0).subtitle);
    }

    @Override
    public void validateExtrasWithNoPlan() {
        SwipeToElement(RH_AddPlanCard, "Left");
        for (int i = 0; i < dashboardModel.tiles.size(); i++) {

            if (dashboardModel.tiles.get(i).tileType.equalsIgnoreCase("ALLOWANCES")) {

                // start from one as o is the Add Plan Card
                for (int j = 1; j < dashboardModel.tiles.get(i).content.size(); j++) {
                    assertEquals(DB_AllowanceTileHeader.getText(), dashboardModel.tiles.get(i).content.get(j).headerFallback.replace("</b>","").replace("<b>",""));
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).headerFallback);
                    assertEquals(DB_AllowanceTileTotalAmount.getText(), dashboardModel.tiles.get(i).content.get(j).subtitle); //left of 5
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).subtitle);
                    assertEquals(DB_AllowanceTileConsumedAmount.getText(), dashboardModel.tiles.get(i).content.get(j).title); //5
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).title);
                    assertEquals(DB_AllowanceTileUnit.getText(), dashboardModel.tiles.get(i).content.get(j).remainingUnit); //$
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).remainingUnit);
                    //assertEquals(RH_ExtrasCardFooter.getText(), dashboardModel.tiles.get(i).content.get(j).footer); //anothervalue
                    //System.out.println(dashboardModel.tiles.get(i).content.get(j).footer);
                    AssertDisplayed(DB_AllowanceTileProgressBar.isDisplayed());
                    System.out.println("progress bar status");
                    SwipeToElement(DB_AllowanceTileView, "Left");

                }
            }
        }
    }
}
