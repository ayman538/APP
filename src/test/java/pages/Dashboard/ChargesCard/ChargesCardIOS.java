package pages.Dashboard.ChargesCard;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class ChargesCardIOS extends ChargesCardAbstract{

    public ChargesCardIOS(){
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }
    private final By charges_tile = By.id("wdgChargesTile");
    private final By charges_text = By.xpath("//XCUIElementTypeStaticText[@name='txtDashboardChargesCardHeader']");
    private final By date = By.xpath("//XCUIElementTypeOther[@name='Dashboard_CurrentSpends_Section']/XCUIElementTypeOther[2]");
    private final By charges_msisdn = By.xpath("(//XCUIElementTypeStaticText[@name='txtDashboardCurrentSpendsAccountName'])[2]");
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse;



    public void checkChargesCard() {
        if(live){
            Assert.assertTrue(driver.findElement(charges_tile).isDisplayed());
            Assert.assertTrue(driver.findElement(date).isDisplayed());
            Assert.assertTrue(driver.findElement(charges_text).isDisplayed());
            Assert.assertTrue(driver.findElement(charges_text).getText().contains("Charges"));
            Assert.assertTrue(driver.findElement(charges_msisdn).isDisplayed());
        }else {
        waitForVisibility(DB_billingTileContainer);
        for (int i = 0; i < DashboardResponse.tiles.size() - 1; i++) {
            if (DashboardResponse.tiles.get(i).tileType.equals("CHARGES_CREDIT")) {
                scrollDownTo(DB_billingTileDueDate);
                AssertDisplayed(DB_billingTileContainer.isDisplayed());
                AssertResult(DB_billingTileHeader.getText(), DashboardResponse.tiles.get(i).content.get(0).header.replace("<b>", "").replace("</b>", ""));
                AssertResult(DB_billingTileTitle.getText(), DashboardResponse.tiles.get(i).content.get(0).title);
                AssertResult(DB_billingTileAmount.getText(), DashboardResponse.tiles.get(i).content.get(0).balance);
                AssertResult(DB_billingTileDueDate.getText(), DashboardResponse.tiles.get(i).content.get(0).billPeriod);
                if (DashboardResponse.tiles.get(i).content.get(0).footer != null) {
                    AssertResult(DB_billingTileFooter.getText(), DashboardResponse.tiles.get(i).content.get(0).footer);
                }
            }
        }
        }
    }
}
