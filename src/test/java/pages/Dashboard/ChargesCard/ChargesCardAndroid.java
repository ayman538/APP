package pages.Dashboard.ChargesCard;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DashboardUtils;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class ChargesCardAndroid extends ChargesCardAbstract {
    DashboardV4ResponseModel DashboardResponse;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    public ChargesCardAndroid() {
        super();
        if (!live) DashboardResponse = DashboardUtils.GetDashboard();
    }

    private final By charges_card = By.id("com.myvodafoneapp:id/currentChargesContainer");
    private final By charges_title = By.id("com.myvodafoneapp:id/cardHeaderTextView");
    private final By charges_msisdn = By.id("com.myvodafoneapp:id/cardTitleTextView");
    private final By charges_date = By.id("com.myvodafoneapp:id/billPeriodTextView");

    public void checkChargesCard() {
        if (live) {
            Assert.assertTrue(driver.findElement(charges_card).isDisplayed());
            Assert.assertTrue(driver.findElement(charges_date).isDisplayed());
            Assert.assertTrue(driver.findElement(charges_title).isDisplayed());
            Assert.assertTrue(driver.findElement(charges_title).getText().contains("Charges"));
            Assert.assertTrue(driver.findElement(charges_msisdn).isDisplayed());
        } else {
            waitForVisibility(DB_billingTileContainer);
            for (int i = 0; i < DashboardResponse.tiles.size() - 1; i++) {
                if (DashboardResponse.tiles.get(i).tileType.equals("CHARGES_CREDIT")) {
                    scrollDownTo(DB_billingTileDueDate);
                    AssertDisplayed(DB_billingTileContainer.isDisplayed());
                    AssertResult(DB_billingTileHeader.getText(), DashboardResponse.tiles.get(i).content.get(0).header.replace("<b>", "").replace("</b>", ""));
                    AssertResult(DB_billingTileTitle.getText(), DashboardResponse.tiles.get(i).content.get(0).title);
                    Assert.assertTrue(DashboardResponse.tiles.get(i).content.get(0).balance.contains(DB_billingTileAmount.getText()));
                    AssertResult(DB_billingTileDueDate.getText(), DashboardResponse.tiles.get(i).content.get(0).billPeriod);
                    if (DashboardResponse.tiles.get(i).content.get(0).footer != null) {
                        AssertResult(DB_billingTileFooter.getText(), DashboardResponse.tiles.get(i).content.get(0).footer);
                    }
                }
            }
        }
    }
}
