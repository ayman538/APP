package pages.TestJourney;

public class TestJourneyAndroid extends TestJourneyAbstract{

    @Override
    public void testUpgradePlanJourney() {
        journeyNameTextField.sendKeys("UPGRADE_PLAN");
        targetTextField.sendKeys("myvodafone://clickToUpgradePlan");
        typeSpinner.click();
        appScreenChoice.click();
        connectionRequiredToggle.click();
        startJourneyBtn.click();
    }

}
