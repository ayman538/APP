package pages.RedHybrid.NoActivePlan;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_NoActivePlan_Logic_Android extends RedHybrid_NoActivePlan_Abstract{


    public RedHybrid_NoActivePlan_Logic_Android() {super();}

    @Override
    public void UserLandsOnDashboard() {
        waitForVisibility(RedHybrid_AddPlan);
        assertEquals("Tap here to add Plus plan",RedHybrid_AddPlan.getText());
    }

    @Override
    public void validateDashboardCards() {
        assertEquals(DiscoverTitle.getText(), "Discover");
        DiscoverCard.isDisplayed();

        scrollDownTo(VeryMeTitle);
        assertEquals(VeryMeTitle.getText(), "VeryMe Rewards");
        VeryMeCard.isDisplayed();
        scrollDownTo(AssistanceTitle);
        assertEquals(AssistanceTitle.getText(), "Assistance");
        scrollDownTo(FrequentlyAskedQuestions);
        assertEquals(FrequentlyAskedQuestions.getText(), "Frequently Asked Questions");
        try{
            assertEquals(TradeInTool.getText(), "Trade In Tool");
        }catch (Exception e){
            System.out.println("No Trade in tool entry point");
        }
    }

    @Override
    public void validateDashboardTrayIcons() {
        TobiButton.isDisplayed();
        DB_SettingDashboardTray_icon.isDisplayed();
        assertEquals(DB_SettingDashboardTray_icon.getText(), "Settings");
    }
}