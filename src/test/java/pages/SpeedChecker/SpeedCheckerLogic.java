package pages.SpeedChecker;

import org.testng.Assert;
import pages.Dashboard.NetworkLinks.NetworksPO;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class SpeedCheckerLogic extends SpeedCheckerPO {
    NetworksPO checkSpeed;

    public SpeedCheckerLogic() {
        super();
    }

    public void navigateToSpeedChecker() {
        scrollDownTo(checkSpeed.DB_CheckDataSpeedLink);
        CheckDataAndWiFiSpeed.click();
    }

    public void clickStartTest() {
        startTestButton.click();
    }

    public void assertCorrectHistory() {
        waitForVisibility(resultStatement);
        String resultTitle = resultStatement.getText();
        String resultValue = usabilityResult.getText();
        scrollDownTo(WiFiTab);
        WiFiTab.click();
        String wifiResult = wifiSummary.getText();
        Assert.assertEquals(resultTitle + " " + resultValue, wifiResult);
    }

    public void clickDeleteTests() {
        scrollDownTo(deletePreviousTestsButton);
        deletePreviousTestsButton.click();
        waitForVisibility(yesIDoButton);
        yesIDoButton.click();
    }

    public void assertDeleted() {
        AssertResult(messageDeleted.getText(), "You haven't run this type of speed test yet");
    }
}