package pages.SubsctionOverlay.NewPlanDesign.OneNumberCard;

import org.openqa.selenium.WebElement;
import pages.SubsctionOverlay.SubscriptionOverlayHeader.SubscriptionOverlayLogic;
import testdata.ReadResponse;

import static core.Config.getSegment;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class OneNumberCardLogic extends OneNumberCardPO {

    SubscriptionOverlayLogic subsOverLay;

    public OneNumberCardLogic() {
        super();
        subsOverLay = new SubscriptionOverlayLogic();
    }

    public void navigateToPlanTab() {
        subsOverLay.navigateToSubsOverLay();
        waitForVisibility(SO_PlanTabContent);
    }

    public void validateImage() {
        System.out.println("Given validate the one number image");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoImageDisplayedMBB();
        } else {
            assertPlanOneNoImageDisplayedNonMBB();
        }
    }

    public void assertPlanOneNoImageDisplayedNonMBB() {
        System.out.println("Else the user type is not MBB");
        scrollDownTo(Plan_OneNumber_Hero_Image);
        System.out.println("Scroll to one number hero image");
        AssertDisplayed(Plan_OneNumber_Hero_Image.isDisplayed());
        System.out.println("Should the one number hero image displayed ");
    }

    public void assertPlanOneNoImageDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_Hero_Image);
    }

    public void assertElementNotExistForMBB(WebElement element) {
        System.out.println("if the user type is MBB");
        AssertDisplayed(CheckElementNotExist(element));
        System.out.println("Check the one number element " + (element));
    }

    public void validateTitle() {
        System.out.println(" Given validate the one number title ");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoTitleDisplayedMBB();
        } else {
            assertPlanOneNoTitleTextMBB();
        }
    }

    public void assertPlanOneNoTitleTextMBB() {
        System.out.println("Else the user type is not MBB");
        scrollDownTo(Plan_OneNumber_title);
        System.out.println("Scroll to the one number title " + (Plan_OneNumber_title));
        AssertResult(Plan_OneNumber_title.getText(), "Vodafone OneNumber");
        System.out.println("Should the one number title displayed successfully as " + Plan_OneNumber_title.getText());
    }

    public void assertPlanOneNoTitleDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_title);
    }

    public void validateDescription() {
        System.out.println("Given validate the one number description ");
        if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
            assertPlanOneNoDescriptionDisplayedMBB();
        } else {
            assertPlanOneNoDescriptionTextNonMBB();
        }
    }

    public void assertPlanOneNoDescriptionTextNonMBB() {
        System.out.println("Else the user type is not a MBB");
        scrollDownTo(Plan_OneNumber_description);
        System.out.println("Scroll to the one number description ");
        AssertResult(Plan_OneNumber_description.getText(), "Our Service that lets you share your mobile number and allowance across a range of different devices.");
        System.out.println("Should the one number description " + Plan_OneNumber_description.getText());
    }

    public void assertPlanOneNoDescriptionDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_description);
    }

    public void validateCTAsDisplayed() {
        System.out.println(" Given validate the CTA displayed for one login");
        if (getSegment().toLowerCase().contains("consumer")) {
            System.out.println("if the user type is eligible to one login ");
            if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
                assertPlanOneNoManageDevicesDisplayedMBB();
            } else {
                assertPlanOneNoManageDevicesTextNonMBB();
            }
        } else {
            System.out.println("Else the user is not MBB and not eligible ");
            if (ReadResponse.GetSubscriptionType().equalsIgnoreCase("MBB")) {
                System.out.println("if the uses MBB  ");
                assertPlanOneNoGetConnectedDisplayedMBB();
                assertPanOneNoFindOutMoreDisplayedMBB();

            } else {
                assertPlanOneNoGetConnectedTextNonMBB();
                assertPanOneNoFindOutMoreTextNonMBB();
            }
        }
    }

    public void assertPanOneNoFindOutMoreTextNonMBB() {
        AssertResult(Plan_OneNumber_Findoutmore.getText(), "Find out more");
        System.out.println("Should the one number find out more displayed " + Plan_OneNumber_Findoutmore.getText());
    }

    public void assertPlanOneNoGetConnectedTextNonMBB() {
        System.out.println("Else the user is not MBB");
        scrollDownTo(Plan_OneNumber_Findoutmore);
        System.out.println("Scroll to the the one number get connected " + (Plan_OneNumber_GetConnected));
        AssertResult(Plan_OneNumber_GetConnected.getText(), "Get connected");
        System.out.println("Should the one number get connected button displayed " + Plan_OneNumber_GetConnected.getText());
    }

    public void assertPanOneNoFindOutMoreDisplayedMBB() {
        AssertDisplayed(CheckElementNotExist(Plan_OneNumber_Findoutmore));
        System.out.println("Check The one number find more button is not displayed ");
    }

    public void assertPlanOneNoGetConnectedDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_GetConnected);
    }

    public void assertPlanOneNoManageDevicesTextNonMBB() {
        System.out.println("Else the user type is not MBB");
        scrollDownTo(Plan_OneNumber_Managedevices);
        System.out.println("scroll down to the one number manged devices " + (Plan_OneNumber_Managedevices));
        AssertResult(Plan_OneNumber_Managedevices.getText(), "Manage Devices");
        System.out.println("Should the the one number manged " + Plan_OneNumber_Managedevices.getText());
    }

    public void assertPlanOneNoManageDevicesDisplayedMBB() {
        assertElementNotExistForMBB(Plan_OneNumber_Managedevices);
    }

    public void validateCTAsFunctional() throws InterruptedException {
        if (getSegment().toLowerCase().contains("consumer")) {
            PlanOneNoManageDevicesCTA();
            assertDoneCTADisplayed();
        } else {
            PlanOneNoGetConnectedCTA();
            assertDoneCTADisplayed();
            DoneCTA();
            PlanOneNoFindOutMoreCTA();
            assertDoneCTADisplayed();
            DoneCTA();
        }
    }

    public void PlanOneNoFindOutMoreCTA() throws InterruptedException {
        scrollDownTo(Plan_OneNumber_Findoutmore);
        Plan_OneNumber_Findoutmore.click();
        Thread.sleep(3000);
    }

    public void DoneCTA() {
        DoneCtaInExternalbrowser.click();
        waitForVisibility(SO_PlanTabContent);
    }

    public void PlanOneNoGetConnectedCTA() {
        scrollDownTo(Plan_OneNumber_GetConnected);
        Plan_OneNumber_GetConnected.click();
    }

    public void assertDoneCTADisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
    }

    public void PlanOneNoManageDevicesCTA() {
        System.out.println("If the user has eligibility contain One Number ");
        scrollDownTo(Plan_OneNumber_Managedevices);
        System.out.println("Scroll down to ");
        Plan_OneNumber_Managedevices.click();
    }
}
