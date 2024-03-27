package pages.SubsctionOverlay.SubscriptionOverlayHeader;

import models.response.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.*;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static core.Config.getSegment;

public class SubscriptionOverlayAndroid extends SubscriptionOverlayAbstract{
    DashboardV4ResponseModel DashboardResponse ;
    DashboardV4ResponseModel.SubsOverlay subsOverlay ;
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By your_plan = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/controlText') and @text='Your Plan']");


    public SubscriptionOverlayAndroid(){
        super();
        if(!live) {
            DashboardResponse = DashboardUtils.GetDashboard();
            subsOverlay = DashboardResponse.subsOverlay;
        }
    }


    public void navigateToSubsOverlay(){
        if(live){
            waitForVisibility(your_plan);
            driver.findElement(your_plan).click();
        }else {
            if (getSegment().equalsIgnoreCase("consumer")) {
                waitForVisibility(DB_ControlTile);
                DB_ControlTile.click();
            } else {
                waitForVisibility(DB_creditTileFooter);
                DB_creditTileFooter.click();
            }
        }
    }

    public void checkSubsOverlayHeader(){
        waitForVisibility(SO_PlanTab);
        checkSubsHeaderIcon();
        checkSubsHeaderID();
        checkSubsHeaderType();
        checkSubsHeaderCurrentCharges();
        checkSubsHeaderCurrentChargesPeriod();
    }

    public void checkSubsHeaderIcon(){
        if(subsOverlay.header.subscriptionHeader.icon != null) {
            assertDisplayed(SO_subscriptionIcon, 5);
        }

    }

    public void checkSubsHeaderID(){
        if(subsOverlay.header.subscriptionHeader.subscriptionId != null){
            Assert.assertEquals(subsOverlay.header.subscriptionHeader.subscriptionId,SO_MSISDN.getText());
        }
    }

    public void checkSubsHeaderType(){
        if(subsOverlay.header.subscriptionHeader.subscriptionType != null){
            Assert.assertEquals(subsOverlay.header.subscriptionHeader.subscriptionType,
                    SO_subscriptionType.getText());        }
    }

    public void checkSubsHeaderCurrentCharges(){
        if(subsOverlay.header.currentChargesTitle != null){
            Assert.assertEquals(subsOverlay.header.currentChargesTitle.
                    replace("<b>","").
                    replace("</b>",""), SO_Amount.getText());        }
    }

    public void checkSubsHeaderCurrentChargesPeriod(){
        if(subsOverlay.header.currentChargesPeriod != null){
            Assert.assertEquals(subsOverlay.header.currentChargesPeriod,
                    SO_Dates.getText());        }
    }

    public void checkSubsHeaderCurrentAdditionalCharges(){
        if(subsOverlay.header.currentChargesSubTitle != null){
            Assert.assertEquals(subsOverlay.header.currentChargesSubTitle.
                    replace("<b>","").
                    replace("</b>",""), SO_AdditionalCharges.getText());        }
    }

}
