package pages.SubsctionOverlay.DevicePlanTab;


import com.google.common.collect.ImmutableMap;
import models.response.SegmentResponseModel;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import utils.SegmentUtils;

import static core.Config.getPlatformType;
import static utils.element_helpers.GenericHelpers.navigateToURL;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;

@Deprecated
public class DevicePlanLogic extends DevicePlanPo {
    SubscriptionOverlayLogic sl;
    public SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();

    public DevicePlanLogic() {
        super();
        sl = new SubscriptionOverlayLogic();
    }

    public void checkDevicePlanTabOpened() {
        navigateToURL("https://www.vodafone.co.uk/myvf/DevicePlan");
        if (segmentResponseModel.segment.equalsIgnoreCase("CONSUMER"))
            AssertDisplayed(SO_DevicePlanTabContainer.isDisplayed());
        else
            AssertDisplayed(DB_VFLogo.isDisplayed());
    }

    public void checkDevicePlanTabOpenedwhileAppInBackground() {
        //TODO need to double check if it works with IOS or not
        if (getPlatformType().equalsIgnoreCase("Android"))
            driver.navigate().back();
        else
            driver.execute("mobile: pressButton", ImmutableMap.of("name", "home"));

        navigateToURL("https://www.vodafone.co.uk/myvf/usage");
        AssertDisplayed(SO_DevicePlanTabContainer.isDisplayed());
    }

    /*

    public void assertBatteryRefreshText() {
        System.out.println("Given Validate the Battery Refresh link displayed ");
        scrollDownTo((DevicePlan_BatteryRefreshLink));
        System.out.println("Scroll to the Battery Refresh Link ");
        AssertResult(DevicePlan_BatteryRefreshLink.getText(), "Battery Refresh Tool");
        System.out.println("Should the validate Battery Refresh link displayed ");
    }

    public void BatteryRefreshCTA() {
        System.out.println("Given check Battery refresh CTA ");
        DevicePlan_BatteryRefreshLink.click();
        System.out.println("Click on Battery Refresh CTA link");
        waitForVisibility((DevicePlan_BatteryRefreshXIcon));
        AssertDisplayed(DevicePlan_BatteryRefreshXIcon.isDisplayed());
    }

    public void BatteryRefreshXIconCTA() {

        DevicePlan_BatteryRefreshXIcon.click();
        System.out.println("Click on the X icon ");
        waitForVisibility((DevicePlan_BatteryRefreshLink));
        System.out.println("Wait till the dashboard displayed successfully");
        AssertDisplayed(DevicePlan_BatteryRefreshLink.isDisplayed());
    }

     */

    public void navigateToDevicePlanTab() {

        sl.navigateToSubsOverLay();

        SO_DevicePlanTab.click();


    }



}

