package pages.Dashboard.NewVOV;

import models.response.AccountsResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.Tray.MyAccount.MyAccountIOS;
import utils.AccountsUtils;
import utils.SegmentUtils;
import utils.SubscriptionsUtils;

import java.io.IOException;
import java.util.Objects;

import static java.lang.String.format;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.assertDisplayed;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RemoveVOVIOS extends RemoveVOVAbstract {
    MyAccountIOS myAccountLogic;
    SegmentResponseModel segmentResponseModel;
    AccountsResponseModel  accountsResponseModel;
    SubscriptionsResponseModel response;


    public RemoveVOVIOS() throws IOException {
        super();
        segmentResponseModel = SegmentUtils.GetSegment();
        if(!segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            accountsResponseModel = AccountsUtils.getAccounts(segmentResponseModel.segment, segmentResponseModel.subscriptionType.name);
            response = SubscriptionsUtils.getSubscriptions(segmentResponseModel.segment,
                    segmentResponseModel.subscriptionType.name,
                    System.getProperty("LOA3AccountId"),
                    accountsResponseModel.accounts.get(0).accountIdHash,
                    accountsResponseModel.accounts.get(0).accountType);
        }
        myAccountLogic = new MyAccountIOS();

    }

//Passes a Child User webelement to Function
    @Override
    public void SwitchToSubscription(WebElement userType) throws ParseException, InterruptedException {
     try {
         myAccountLogic.clickOnMyAccount();
     }catch (Exception ee) {
         waitForVisibility(MyAccountXIcon);

         int currentSwipe = 0;
         boolean isDisplayed = false;
         System.out.println(response.subscriptions.size());
         int totalNumberSwipes = response.subscriptions.size();

         while (!isDisplayed && currentSwipe++ <= totalNumberSwipes/2) {
             try {
                 //condition for PayM MPS child
                 if(userType == PayMChild && (currentSwipe >= 2 || !Objects.equals(SelectedUserType.getText(), "Pay monthly"))){
                     userType = PayMChildAfterScroll;
                 }

                 isDisplayed = userType.isDisplayed();

             } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException e) {
                 //scroll(390, 640, 80, 640);
                 SwipeToElement(GetSubscription_List,"Left");
             }
         }
         //Assert.assertTrue(format("Subscription was not found after [%s] scrolls", currentSwipe), isDisplayed);

         userType.click();

         Thread.sleep(10000);

         System.out.println(format("User Switched to [%s]", SelectedUserType.getText()));
     }

    }

    @Override
    public void validateHidingVovFromUI() {
        assertDisplayed(DB_MyAccountTray_icon, 10);
        Assertions.assertFalse(elementIsPresent(DB_VOVDescription));
        Assertions.assertFalse(elementIsPresent(DB_VOVhideCTA));
    }

}
