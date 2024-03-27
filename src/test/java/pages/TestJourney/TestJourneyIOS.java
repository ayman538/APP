package pages.TestJourney;

import static utils.element_helpers.ScrollHelpers.iosScrollToElement;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class TestJourneyIOS extends TestJourneyAbstract {


    @Override
    public void testUpgradePlanJourney() {
        waitForVisibility(testJourneyPageHeader);
        iosScrollToElement(upgradePlanJourneyBtn, "down");
        upgradePlanJourneyBtn.click();
    }

}
