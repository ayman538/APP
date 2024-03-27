package pages.SubsctionOverlay.SubscriptionOverlayHeader;

import models.response.DashboardV4ResponseModel;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.Properties;

import static core.Config.getSegment;
import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class SubscriptionOverlayIOS extends SubscriptionOverlayAbstract {


    static Properties envProp = readPropertyFile("config/env.properties");


    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");

    DashboardV4ResponseModel dashboardResponse;
    DashboardV4ResponseModel.SubsOverlay subsOverlay;

    public SubscriptionOverlayIOS() {
        super();
        if (!live) {
            dashboardResponse = DashboardUtils.GetDashboard();
            subsOverlay = dashboardResponse.subsOverlay;
        }
    }


    public void navigateToSubsOverlay() {
            if (live) {
                waitForVisibility(DB_ControlTile);
                DB_ControlTile.click();
            } else {
                if (getSegment().equalsIgnoreCase("consumer")) {
                    waitForVisibility(DB_ControlTile);
                    DB_ControlTile.click();
                } else {
                    waitForVisibility(DB_creditTileFooter);
                    DB_creditTileFooter.click();
                }
            }
    }
    public void checkSubsOverlayHeader() {
        waitForVisibility(SO_PlanTab);
//        checkSubsHeaderIcon();
        checkSubsHeaderID();
        checkSubsHeaderType();
        checkSubsHeaderCurrentCharges();
        // checkSubsHeaderCurrentChargesPeriod();
    }

    public void checkSubsHeaderIcon() {
        if (subsOverlay.header.subscriptionHeader.icon != null) {
            assertDisplayed(SO_subscriptionIcon, 5);
        }
    }

    public void checkSubsHeaderID() {
        if (live) {
            AssertDisplayed(SO_MSISDN.isDisplayed());
        }
        else { System.out.println(subsOverlay.header.subscriptionHeader.subscriptionId);
            if (subsOverlay.header.subscriptionHeader.subscriptionId != null) {
                Assert.assertEquals(subsOverlay.header.subscriptionHeader.subscriptionId, SO_MSISDN.getText());
            }

        }

    }

    public void checkSubsHeaderType() {

        if (live) {
            waitForVisibility(SO_subscriptionType);
            AssertDisplayed(SO_subscriptionType.isDisplayed());
        } else {
            if (subsOverlay.header.subscriptionHeader.subscriptionType != null) {
                Assert.assertEquals(subsOverlay.header.subscriptionHeader.subscriptionType,
                        SO_subscriptionType.getText());
            }
        }
    }

    public void checkSubsHeaderCurrentCharges() {
        if (live) {
            AssertDisplayed(SO_Amount.isDisplayed());
        } else {
            if (subsOverlay.header.currentChargesTitle != null) {
                Assert.assertEquals(subsOverlay.header.currentChargesTitle.
                        replace("<b>", "").
                        replace("</b>", ""), SO_Amount.getText());
            }

        }
    }

    public void checkSubsHeaderCurrentChargesPeriod() {
        if (live) {
            AssertDisplayed(SO_Dates.isDisplayed());
        } else {
            if (subsOverlay.header.currentChargesPeriod != null) {
                Assert.assertEquals(subsOverlay.header.currentChargesPeriod,
                        SO_Dates.getText());
            }
        }
    }

    public void checkSubsHeaderCurrentAdditionalCharges() {
        if (live) {
            AssertDisplayed(SO_AdditionalCharges.isDisplayed());
        } else {
            if (subsOverlay.header.currentChargesSubTitle != null) {
                Assert.assertEquals(subsOverlay.header.currentChargesSubTitle.
                        replace("<b>", "").
                        replace("</b>", ""), SO_AdditionalCharges.getText());
            }
        }
    }
}

