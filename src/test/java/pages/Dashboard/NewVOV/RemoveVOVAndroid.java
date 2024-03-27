package pages.Dashboard.NewVOV;

import models.response.AccountsResponseModel;
import models.response.SegmentResponseModel;
import models.response.SubscriptionsResponseModel;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import pages.Tray.MyAccount.MyAccountAndroid;
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

public class RemoveVOVAndroid extends RemoveVOVAbstract {

    MyAccountAndroid myAccountLogic;
    SegmentResponseModel segmentResponseModel;
    AccountsResponseModel accountsResponseModel;
    SubscriptionsResponseModel response;

    public RemoveVOVAndroid() {
        super();
    }

    public void subscriptionSwitchingPreconditions() {
        segmentResponseModel = SegmentUtils.GetSegment();
        if (!segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            accountsResponseModel = AccountsUtils.getAccounts(segmentResponseModel.segment, segmentResponseModel.subscriptionType.name);
            response = SubscriptionsUtils.getSubscriptions(segmentResponseModel.segment,
                    segmentResponseModel.subscriptionType.name,
                    System.getProperty("LOA3AccountId"),
                    accountsResponseModel.accounts.get(0).accountIdHash,
                    accountsResponseModel.accounts.get(0).accountType);
        }
        try {
            myAccountLogic = new MyAccountAndroid();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void SwitchToSubscription(WebElement userType) throws ParseException, InterruptedException {
        subscriptionSwitchingPreconditions();
        try {
            myAccountLogic.clickOnMyAccount();
        } catch (Exception e) {
            waitForVisibility(GetSubscription_List);

            int currentSwipe = 0;
            boolean isDisplayed = false;
            System.out.println(response.subscriptions.size());
            int totalNumberSwipes = response.subscriptions.size();

            while (!isDisplayed && currentSwipe++ <= totalNumberSwipes / 2) {
                try {
                    //condition for PayM MPS child
                    if (userType == PayMChild && (currentSwipe >= 2 || !Objects.equals(SelectedUserType.getText(), "Pay monthly"))) {
                        userType = PayMChildAfterScroll;
                    }

                    isDisplayed = userType.isDisplayed();

                } catch (NoSuchElementException | AssertionError | IndexOutOfBoundsException ee) {
                    //scroll(900, 1300, 50, 1300);
                    SwipeToElement(GetSubscription_List, "Left");
                }
            }
            //Assert.assertTrue(format("Subscription was not found after [%s] scrolls", currentSwipe), isDisplayed);

            userType.click();
            Thread.sleep(5000);
            waitForVisibility(SelectedUserType);
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
