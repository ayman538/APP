package pages.RedHybrid.ViewAllowance;

import models.response.DashboardV4ResponseModel;
import models.response.UsagesResponseModel;
import org.testng.Assert;
import utils.DashboardUtils;
import utils.UsageUtils;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;

public class RedHybrid_ViewAllowance_iOS extends RedHybrid_ViewAllowance_Abstract {
    private boolean hideVOVStatus = false;
    DashboardV4ResponseModel D = DashboardUtils.GetDashboardWithStubbed("HYBRID","PREPAY","10.100");

    @Override
    public void setBeforeClass() {
        if (!hideVOVStatus) {
            HideVOV(DB_VOVhideCTA);
            hideVOVStatus = true;
        }
    }

    @Override
    public void checkAllowanceTile() {
        assertAllowanceCardText();
        assertAllowanceTileProgressBarDisplayed();
    }

    @Override
    public void assertAllowanceCardText() {
        for (int i = 0; i < D.tiles.size(); i++) {
            if (D.tiles.get(i).tileType.equalsIgnoreCase("ALLOWANCES")) {
                for (int j = 0; j < D.tiles.get(i).content.size(); j++) {
                    assertEquals(DB_AllowanceTileTitle.getText(), D.tiles.get(i).content.get(j).headerFallback.replace("</b>","").replace("<b>",""));
                    System.out.println(D.tiles.get(i).content.get(j).headerFallback);
                    assertEquals(DB_AllowanceTileTotalAmount.getText(), D.tiles.get(i).content.get(j).subtitle); //m2lob
                    System.out.println(D.tiles.get(i).content.get(j).subtitle);
                    assertEquals(DB_AllowanceTileSubTitle.getText(), D.tiles.get(i).content.get(j).title); //null!!
                    System.out.println(D.tiles.get(i).content.get(j).title);
                    if(D.tiles.get(i).content.get(j).headerFallback.equals("<b>Data</b>") || D.tiles.get(i).content.get(j).headerFallback.equals("<b>Premium rate credit</b>")) {
                        assertEquals(DB_AllowanceTileUnit.getText(), D.tiles.get(i).content.get(j).remainingUnit);
                        System.out.println(D.tiles.get(i).content.get(j).remainingUnit);
                    }
                    assertEquals(DB_AllowanceTileFooter.getText(), D.tiles.get(i).content.get(j).footer); //anothervalue
                    System.out.println(D.tiles.get(i).content.get(j).footer);
                    System.out.println("truee");
                    SwipeToElement(DB_AllowanceTileView, "Left");

                }
            }
        }
        System.out.println(D.tiles.size());
        System.out.println(D.tiles.get(0).content.size());
    }

    @Override
    public void assertAllowanceTileProgressBarDisplayed() {
        AssertDisplayed(DB_AllowanceTileProgressBar.isDisplayed());
    }

    @Override
    public void assertOnTotalGBForPromotedPlan() {
        DashboardV4ResponseModel dashboardV4ResponseModel = DashboardUtils.GetDashboard();
        UsagesResponseModel usagesResponseModel = UsageUtils.getUsagesV2();

        String extraPlanGB= null;
        String actualTitle = dashboardV4ResponseModel.tiles.get(0).content.get(0).subtitle;

        for(int i=0; i<usagesResponseModel.cards.get(1).sections.size(); i++){
            if(usagesResponseModel.cards.get(1).sections.get(i).header.contains("Data  - Promo extra")){
                extraPlanGB = usagesResponseModel.cards.get(1).sections.get(i).allowances.get(0).quantity;
                break;
            }
        }
        String actualPlanGB = usagesResponseModel.cards.get(0).sections.get(0).allowances.get(0).quantity;
        double totalGBs = Double.parseDouble(actualPlanGB) + Double.parseDouble(extraPlanGB);
        String expectedTotalGB = String.valueOf(totalGBs);

        Assert.assertTrue(actualTitle.contains(expectedTotalGB));
        Assert.assertTrue(DB_AllowanceTileConsumedAmount.getText().contains(expectedTotalGB));
    }
}
