package pages.Dashboard.AllowanceTile;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class AllowanceTileIOS extends AllowanceTileAbstract {
    By allowance_Bdg = By.xpath("//*[@name='wdgDashboardAllowences']");
    By allowance_title = By.id("txtDashboardAllowencesTitle");
    int numOfAllowances = 0;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    DashboardV4ResponseModel DashboardResponse;


    public AllowanceTileIOS() {
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
        }
    }


    @Override
    public void checkAllowanceTile() throws Exception {
        if (live) {
            waitForVisibility(allowance_title);
            Assert.assertTrue(driver.findElement(allowance_Bdg).isDisplayed());
            Assert.assertTrue(driver.findElement(allowance_title).isDisplayed());
        } else {

            //ToDo need to add the case of the allownce tiel with data ( more than on card )§
            assertAllowanceTile();
            try {
                assertAllowanceTileAllUsageDisplayed();
            } catch (Exception e) {
                System.out.println("This User has more than one allowance card");
            }
            //TODO Check TC mapped to Usage card after pressing View All Usage CTA
            //assertUsageTabDisplayedAfterAllowanceTileCTA();
        }
    }

    @Override
    public void assertAllowanceTileAllUsageDisplayed() throws Exception {
        if (numOfAllowances == 1) {
            waitForVisibility(DB_AllowanceTileView);
            SwipeToElement(DB_AllowanceTileView, "Left");
            waitForVisibility(DB_AllowanceTileViewAllUsage);
            AssertDisplayed(DB_AllowanceTileViewAllUsage.isDisplayed());
        } else {
            throw new Exception("This user has more than one allowance");
        }
    }

    /*
    @Override
    public void assertAllowanceCardText() throws ParseException {
        for (int i = 0; i < ReadResponse.getAllowanceTile().size() - 1; i++) {
            AssertResult(DB_AllowanceTileHeader.getText(), ReadResponse.getAllowanceTileHeader(i));
            AssertResult(DB_AllowanceTileSubTitle.getText(), ReadResponse.getAllowanceTileSubTitle(i));
            AssertResult(DB_AllowanceTileTitle.getText(), ReadResponse.getAllowanceTileTitle(i));
            AssertResult(DB_AllowanceTileUnit.getText(), ReadResponse.getAllowanceTileUnit(i));

        }
    }

     */

    @Override
    public void assertUsageTabDisplayedAfterAllowanceTileCTA() {
        DB_AllowanceTileViewAllUsage.click();
        waitForVisibility(SO_UsageTab);
        AssertDisplayed(SO_UsageTab.isSelected());
    }

    @Override
    public void assertAllowanceTile() throws Exception {
        boolean hasAllowance = false;
        for (int i = 0; i < DashboardResponse.tiles.size() - 1; i++) {
            if (DashboardResponse.tiles.get(i).tileType.equals("ALLOWANCES")) {
                numOfAllowances++;
                hasAllowance = true;
                AssertResult(DB_AllowanceTileHeader.getText(), DashboardResponse.tiles.get(i).content.get(0).headerFallback.replace("<b>", "").replace("</b>", ""));
                // will fail if user with unlimited amount
                if (!DashboardResponse.tiles.get(i).content.get(0).unlimited) {
                    waitForVisibility(DB_AllowanceTileConsumedAmount);
                    AssertResult(DB_AllowanceTileConsumedAmount.getText(), DashboardResponse.tiles.get(i).content.get(0).subtitle);
                } else {
                    System.out.println("User with unlimited amount");
                    waitForVisibility(DB_AllowanceTileTotalAmount);
                }
                AssertResult(DB_AllowanceTileTotalAmount.getText(), DashboardResponse.tiles.get(i).content.get(0).title);
                AssertResult(DB_AllowanceTileRenewal.getText(), DashboardResponse.tiles.get(i).content.get(0).footer);
            }
        }
        if (!hasAllowance) {
            throw new Exception("The user does not have allowance tile");
        }
    }
}