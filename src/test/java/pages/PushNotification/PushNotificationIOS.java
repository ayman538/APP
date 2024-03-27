package pages.PushNotification;


import com.fasterxml.jackson.core.JsonProcessingException;
import core.drivers_initializer.drivers.AppiumMobileDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import models.response.UrbanAirshipResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.UrbanAirshipUtils;

import java.time.Duration;

import static utils.element_helpers.DriverHelps.runAppInBackground;
import static utils.element_helpers.GenericHelpers.navigateBackForiOS;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.verticalSwipeByPercentages;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class PushNotificationIOS extends PushNotificationPage {
    UrbanAirshipResponseModel urbanAirshipResponseObj;
    public PushNotificationIOS() {
        super();
    }

    @Override
    public void OpenPushNotification() {
        ((AndroidDriver) driver).openNotifications();
        pushNotificationItem.click();
    }

    @Override
    public void ValidateAppIsOpened() {
        waitForVisibility(SplashScreen);
        AssertDisplayed(SplashScreen.isDisplayed());
    }

    @Override
    public void SoftCloseApp() {
        runAppInBackground();
    }

    @Override
    public void AssertRedirectToExternalLink() {
        AssertDisplayed(Google_search_btn.isDisplayed());

    }

    @Override
    public void AssertRedirectToDeepLink() {
        AssertDisplayed(SO_DevicePlanTab.isDisplayed());
    }

    @Override
    public void OpenPushNotification(String Notification) {
        ((AndroidDriver) driver).openNotifications();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+Notification+"']")));
        driver.findElement(By.xpath("//*[@text='"+Notification+"']")).click();
    }
    @Override
    public void ValidateMessageBody(String MessageBody) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='"+MessageBody+"']")));
        System.out.println(driver.findElement(By.xpath("//*[@text='"+MessageBody+"']")).getText());
        Assert.assertTrue(driver.findElement(By.xpath("//*[@text='"+MessageBody+"']")).getText().contains(MessageBody));
        navigateBackForiOS();
    }

    @Override
    public void CloseAppFromBackground() {
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.APP_SWITCH));
        SwipeToElement(driver.findElement(By.xpath("//*[@content-desc='My Vodafone']")),"Right");
        verticalSwipeByPercentages(0.7 ,0.2,0.5);
    }

    @Override
    public void PutAppInBackground() {
        runAppInBackground();
    }

    @Override
    public void sendAMessageCenterNotification(String alert, String title, String body) throws JsonProcessingException {
        urbanAirshipResponseObj = UrbanAirshipUtils.SendMessageCenterNotification(alert,title, body);
        Assert.assertEquals(urbanAirshipResponseObj.ok,true);
    }


}
