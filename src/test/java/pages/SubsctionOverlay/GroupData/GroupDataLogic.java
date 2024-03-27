package pages.SubsctionOverlay.GroupData;

import testdata.TestData;

import static utils.element_helpers.ActionsHelpers.HideVOV;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class GroupDataLogic extends GroupDataPO {

    private static String msisdn;


    public GroupDataLogic() {
        super();
        msisdn = "07" + TestData.GetMSISDN().substring(3);
    }

    public void setupGD() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        HideVOV(DB_VOVhideCTA);
        DB_ControlTileSecondryCard.click();
    }

    public void setupMGD() {
        controlTileSecondaryCTA();
        GD_manageGroupDataCardTitle.click();
    }

    public void controlTileSecondaryCTA() {
        scrollDownTo(DB_ControlTileSecondryCard);
        DB_ControlTileSecondryCard.click();
    }

    public void checkGroupDataHeader() {
        assertGroupDataTitleText();
    }

    public void checkCurrentData() {
        waitForVisibility(GD_GroupDataSubItemsValue);
        AssertDisplayed(GD_GroupDataSubItemsValue.isDisplayed());
    }

    public void checkDataIcon() {
        waitForVisibility(GD_GroupDataSubItemsIcon);
        AssertDisplayed(GD_GroupDataSubItemsIcon.isDisplayed());
    }

    public void checkCurrentDataText() {
        waitForVisibility(GD_GroupDataSubTitle);
        AssertResult(GD_GroupDataSubTitle.getText(), "You currently have");
    }

    public void checkDataBar() {
        waitForVisibility(GD_GroupDataSubItemsBar);
        AssertDisplayed(GD_GroupDataSubItemsBar.isDisplayed());
    }

    public void checkManageGroupDataHeaderInGD() {
        waitForVisibility(GD_manageGroupDataTitle);
        AssertResult(GD_manageGroupDataTitle.getText(), "Manage group data");
    }

    public void checkSubscriptionIDInGD() {
        scrollDownTo(GD_manageGroupDataCardTitle);
        AssertResult(GD_manageGroupDataCardTitle.getText(), msisdn);
    }

    public void checkManageGroupDataHeaderInMGD() {
        waitForVisibility(MGD_title);
        AssertResult(MGD_title.getText(), "Manage group data");
    }

    public void checkSubscriptionIDInMGD() {
        waitForVisibility(MGD_CardTitle);
        AssertResult(MGD_CardTitle.getText(), msisdn);
    }

    public void checkLimitIndicatorInMGD() {
        waitForVisibility(MGD_setLimitValue);
        AssertDisplayed(MGD_setLimitValue.isDisplayed());
    }

    public void checkSendBtnInMGD() {
        waitForVisibility(MGD_CardSendTextCTA);
        AssertDisplayed(MGD_CardSendTextCTA.isDisplayed());
    }

    public void checkLimitBarInMGD() {
        waitForVisibility(MGD_CardBar);
        AssertDisplayed(MGD_CardBar.isDisplayed());
    }

    public void checkFooterInMGD() {
        waitForVisibility(MGD_CardFooter);
        AssertResult(MGD_CardFooter.getText(), "Please allow up to 24 hours for changes to take effect");
    }

    public void checkPressBackBtnHeader() {
        manageGroupDataBackIconCTA();
        assertGroupDataTitleText();
    }

    public void assertGroupDataTitleText() {
        waitForVisibility(GD_GroupDataTitle);
        AssertResult(GD_GroupDataTitle.getText(), "Group Data");
    }

    public void manageGroupDataBackIconCTA() {
        waitForVisibility(MGD_BackIcon);
        MGD_BackIcon.click();
    }
}

