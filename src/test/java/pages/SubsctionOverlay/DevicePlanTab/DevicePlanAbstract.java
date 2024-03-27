package pages.SubsctionOverlay.DevicePlanTab;

public abstract class DevicePlanAbstract extends DevicePlanPo{

    public DevicePlanAbstract(){
        super();
    }

    public abstract void navigateToDevicePlanTab();

    public abstract void checkDevicePlanCard();

    public abstract void checkNextPayment();

    public abstract void checkDevicePlanAmountPaid();

    public abstract void checkDevicePlanAmountBar();

    public abstract void checkDevicePlanTitle();

    public abstract void checkDevicePlanCTAs();

    public abstract void checkViewMoreDetailsCTADisplayed();

    public abstract void checkPaymentHistoryCTADisplayed();

    public abstract void checkMakePaymentCTADisplayed();

    public abstract void checkMakePaymentCTAColour();

    public abstract void checkTotalCareWarrantyAsIncludes();

    public abstract void checkTotalCareWarrantyLink();

    public abstract void checkBatteryRefreshAsIncludes();

    public abstract void checkBatteryRefreshLink();

    public abstract void checkManageDevicePlanCTA();

    public abstract void WhatIsDevicePlanCTA();

    public abstract void WhatIsDevicePlanOverlay();

    public abstract void WhatIsDevicePlanNewCopyOverlay();

    public abstract void OkThanksCTA();

    public abstract void DevicePlanTab();

    public abstract void checkTrayList();

    public abstract void checkURL(String CTAName);

    public void clickOnCancelButton() {
    }

}
