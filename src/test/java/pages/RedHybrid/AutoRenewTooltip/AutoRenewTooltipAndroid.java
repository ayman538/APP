package pages.RedHybrid.AutoRenewTooltip;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import utils.DashboardUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.assertIsTrueSoftly;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class AutoRenewTooltipAndroid extends AutoRenewTooltipAbstract{
    DashboardV4ResponseModel dashboard = DashboardUtils.GetDashboard() ;

    public void SubmitiIcon(){
        assertIsTrueSoftly("something wrong from MW",dashboard.tooltips.get(0).journeyName.contains("PLAN"));
        waitForVisibility(iIcon);
        iIcon.click();

    }

    public void navigateToPlan() throws InterruptedException {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Thread.sleep(500);
        waitForVisibility(DB_ControlTile);
        scrollDownTo(DBControlTile);
        DBControlTile.click();
    }
    public void ValidateAutoRenewTip(){
        waitForVisibility(ThanksCTA);
        assertIsTrueSoftly("invalid tip Title",driver.findElement(
                By.xpath("//*[@text='" + dashboard.tooltips.get(0).items.get(0).title +"']")).isDisplayed());
        assertIsTrueSoftly("invalid tip description",driver.findElement(
                By.xpath("//*[@text='" + dashboard.tooltips.get(0).items.get(0).description +"']")).isDisplayed());
        ThanksCTA.click();
        System.out.println(dashboard.tooltips.get(0).journeyName );

    }
}
