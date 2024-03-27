package stepdefs.TC_PushNotification;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.response.UrbanAirshipResponseModel;
import org.testng.Assert;
import pages.PushNotification.PushNotificationPage;
import utils.UrbanAirshipUtils;


public class PushNotification {

    PushNotificationPage pushNotObj;

    public PushNotification(Config config) {
        if (config.isAndroid()) pushNotObj = new pages.PushNotification.PushNotificationAndroid();
        if (config.isIos()) pushNotObj = new pages.PushNotification.PushNotificationIOS();
    }

    @Given("Send a push notification")
    public void setBeforeClass() throws JsonProcessingException {
        UrbanAirshipUtils.getPushNotification();
    }

    @Given("Tap on it from Notification center")
    public void OpenPushNotification() throws JsonProcessingException {
        pushNotObj.OpenPushNotification();
    }

    @Given("Validate My vodafone app is opened")
    public void ValidateTheAppIsOpened() throws JsonProcessingException {
        pushNotObj.OpenPushNotification();
    }


    @Then("redirect to the external link in an external browser")
    public void redirectToTheExternalLinkInAnExternalBrowser() {
        pushNotObj.AssertRedirectToExternalLink();
    }

    @Then("redirected to the journey sent on the deep link")
    public void redirectedToTheJourneySentOnTheDeepLink() {
        pushNotObj.AssertRedirectToDeepLink();
    }


    @Given("app soft closed")
    public void appSoftClosed() {
        pushNotObj.SoftCloseApp();

    }
    @Given("Put App In Background")
    public void PutAppInBackground() {
        pushNotObj.PutAppInBackground();

    }

    @Given("Send a push notification with  external link")
    public void sendAPushNotificationWithExternalLink() throws JsonProcessingException {
        UrbanAirshipUtils.getPushNotification("https://www.google.com");
    }

    @Given("Send a push notification with  deep link")
    public void sendAPushNotificationWithDeepLink() throws JsonProcessingException {
        UrbanAirshipUtils.getPushNotification("myvodafone://plan");
    }


    @Then("Validate Message Body {string}")
    public void validateMessageBody(String MessageBody) {
        pushNotObj.ValidateMessageBody(MessageBody);
    }
    @When("Send a MessageCenter notification With alert {string} and title {string} and body {string}")
    public void sendAMessageCenterNotification(String alert, String title, String body) throws JsonProcessingException {
        pushNotObj.sendAMessageCenterNotification( alert,  title,  body);

    }
    @And("Open {string} Notification from Notification Center")
    public void openNotificationFromNotificationCenter(String Notification) {
        pushNotObj.OpenPushNotification(Notification);
    }

    @When("Close App from Background")
    public void CloseAppFromBackground() throws InterruptedException {
        pushNotObj.CloseAppFromBackground();
    }
}