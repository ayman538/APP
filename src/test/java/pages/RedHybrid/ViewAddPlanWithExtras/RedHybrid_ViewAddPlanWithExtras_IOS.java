package pages.RedHybrid.ViewAddPlanWithExtras;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import utils.DashboardUtils;


import java.time.Duration;

import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.swipe;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;

public class RedHybrid_ViewAddPlanWithExtras_IOS extends RedHybrid_ViewAddPlanWithExtras_Abstract{

    DashboardV4ResponseModel dashboardModel = DashboardUtils.GetDashboardRedHybrid();

    @Override
    public void validateAddPlanCard() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
    //add specific function to swipe left
    public void swipeToExtrasForIOS(WebElement element, String direction){
        int startX = 0;
        int pressY = 0;
        int endX = 0;
        Duration SCROLL_DUR = Duration.ofMillis(300);
        switch (direction) {
            case "Left":
                startX = element.getRect().width*3/5;
                System.out.println(element.getRect().width);
                System.out.println(startX);
                endX = element.getLocation().x;
                pressY = element.getLocation().getY();
                swipe(new Point(startX, pressY), new Point(endX, pressY), SCROLL_DUR);
                break;
        }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }

    @Override
    public void validateExtrasWithNoPlan() {
        swipeToExtrasForIOS(RH_AddPlanCard, "Left");

        for (int i = 0; i < dashboardModel.tiles.size(); i++) {
            if (dashboardModel.tiles.get(i).tileType.equalsIgnoreCase("ALLOWANCES")) {
                // start from one as o is the Add Plan Card
                for (int j = 1; j < dashboardModel.tiles.get(i).content.size(); j++) {
                    assertEquals(DB_AllowanceTileHeader.getText(), dashboardModel.tiles.get(i).content.get(j).headerFallback.replace("</b>","").replace("<b>",""));
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).headerFallback);
                    assertEquals(DB_AllowanceTileConsumedAmount.getText(), dashboardModel.tiles.get(i).content.get(j).subtitle); //left of 5
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).subtitle);
                    assertEquals(DB_AllowanceTileTotalAmount.getText(), dashboardModel.tiles.get(i).content.get(j).title); //5
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).title);
//                    assertEquals(DB_AllowanceTileUnit.getText(), dashboardModel.tiles.get(i).content.get(j).remainingUnit); //$
//                    System.out.println(dashboardModel.tiles.get(i).content.get(j).remainingUnit);
                    assertEquals(RH_ExtrasCardFooter.getText(), dashboardModel.tiles.get(i).content.get(j).footer); //anothervalue
                    System.out.println(dashboardModel.tiles.get(i).content.get(j).footer);
                    AssertDisplayed(DB_AllowanceTileProgressBar.isDisplayed());
                    System.out.println("progress bar status");
                    SwipeToElement(DB_AllowanceTileView, "Left");

                }
            }
        }
    }
}