package pages.SubsctionOverlay.DevicePlanTab;


import models.response.DeviceLoanDetailsResponseModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DeviceLoanDetailsUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
public class DevicePlanAndroid extends DevicePlanAbstract {

    public DevicePlanAndroid() {
        super();
    }

    DeviceLoanDetailsResponseModel deviceLoanDetailsResponseModel = DeviceLoanDetailsUtils.getDeviceLoanDetailsNoStub();

    public void navigateToDevicePlanTab() {
        waitForVisibility(SO_DevicePlanTab);
        SO_DevicePlanTab.click();
        AssertDisplayed(SO_DevicePlanTab.isDisplayed());
        SO_DevicePlanTab.click();
        waitForVisibility(SO_DevicePlanTabContainer);
    }

    public void checkDevicePlanCard() {
        checkDevicePlanTitle();
        checkDevicePlanAmountBar();
        checkDevicePlanAmountPaid();
        checkNextPayment();
    }

    public void checkNextPayment() {
        AssertResult(SO_DevicePlanNextPaymentDate.getText(), deviceLoanDetailsResponseModel.cards.get(1).nextPayment);
        AssertResult(SO_DevicePlanMonthlyPaymentTxt.getText(), deviceLoanDetailsResponseModel.cards.get(1).loanChargesLabel);
        AssertResult(SO_DevicePlanMonthlyPaymentAmount.getText(), deviceLoanDetailsResponseModel.cards.get(1).loanChargesValue);
    }

    public void checkDevicePlanAmountPaid() {
        System.out.println(deviceLoanDetailsResponseModel.cards.get(1).paidValue);
        waitForVisibility(SO_DevicePlanPaidAmount);
       Assert.assertTrue((SO_DevicePlanPaidAmount.getText().contains(deviceLoanDetailsResponseModel.cards.get(1).paidValue)));
//       Assert.assertTrue(driver.findElement(By.xpath(GetXpath(deviceLoanDetailsResponseModel.cards.get(1).paidValue))).isDisplayed());
//        AssertResult(SO_DevicePlanTotalAmountPaid.getText().replace(" ", ""), deviceLoanDetailsResponseModel.cards.get(1).totalPrice);
    }

    public void checkDevicePlanAmountBar() {
        scrollDownTo(SO_DevicePlanPaidAmountBar);
        AssertDisplayed(SO_DevicePlanPaidAmountBar.isDisplayed());
    }

    public void checkDevicePlanTitle() {
        scrollDownTo(SO_DevicePlanTitle);
        System.out.println(SO_DevicePlanTitle.getText());
        System.out.println(deviceLoanDetailsResponseModel.cards.get(1).title);
//        AssertResult(SO_DevicePlanTitle.getText(), deviceLoanDetailsResponseModel.cards.get(1).title);
    }

    public void checkDevicePlanCTAs() {
        checkMakePaymentCTADisplayed();
        checkPaymentHistoryCTADisplayed();
        checkViewMoreDetailsCTADisplayed();
    }

    public void checkViewMoreDetailsCTADisplayed() {
        scrollDownTo(SO_DevicePlanViewMoreDetailsCTA);
        AssertDisplayed(SO_DevicePlanViewMoreDetailsCTA.isDisplayed());
    }

    public void checkPaymentHistoryCTADisplayed() {
        scrollDownTo(SO_DevicePlanPaymentHistoryCTA);
        AssertDisplayed(SO_DevicePlanPaymentHistoryCTA.isDisplayed());
    }

    public void checkMakePaymentCTADisplayed() {
        scrollDownTo(SO_DevicePlanMakePaymentCTA);
        AssertDisplayed(SO_DevicePlanMakePaymentCTA.isDisplayed());
    }

    public void checkMakePaymentCTAColour() {
        Assert.assertFalse(deviceLoanDetailsResponseModel.cards.get(1).actions.get(0).color == deviceLoanDetailsResponseModel.cards.get(1).actions.get(1).color);
    }

    public void checkTotalCareWarrantyAsIncludes() {
        if (elementIsPresent(SO_DevicePlan_TotalCareWarrantyLink))
                {
                    scrollDownTo(SO_DevicePlan_TotalCareWarrantyLink);
                }
        else {
            SO_DevicePlan_Chevron.click();
            scrollDownTo(SO_DevicePlan_TotalCareWarrantyLink);
        }
        boolean found = false;
        for (int i = 0; i < deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.size(); i++) {
            if (deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.get(i).title.equals("Total Care Warranty")) {
                AssertResult(SO_DevicePlan_TotalCareWarrantyLink.getText(),
                        deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.get(i).title);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Total Care Warranty element not found");
        }
    }

    public void checkTotalCareWarrantyLink() {
        scrollDownTo(SO_DevicePlan_TotalCareWarrantyLink);
        SO_DevicePlan_TotalCareWarrantyLink.click();
        waitForVisibility(SO_DevicePlan_TotalCareWarrantyDescription);
        AssertDisplayed(SO_DevicePlan_TotalCareWarrantyDescription.isDisplayed());
        scrollDownTo(SO_DevicePlan_TotalCareWarrantyCTA);
        AssertDisplayed(SO_DevicePlan_TotalCareWarrantyCTA.isDisplayed());
    }

    public void checkBatteryRefreshAsIncludes() {
        if (elementIsPresent(SO_DevicePlan_Chevron))
        {
            SO_DevicePlan_Chevron.click();
        }
        else {
            scrollDownTo(SO_DevicePlan_TotalCareWarrantyLink);
        }
        boolean found = false;
        for (int i = 0; i < deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.size(); i++) {
            if (deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.get(0).title.equals("Battery Refresh")) {
                AssertResult(SO_DevicePlan_BatteryRefreshLink.getText(),
                        deviceLoanDetailsResponseModel.cards.get(1).sections.get(0).list.get(0).title);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Battery Refresh element not found");
        }
    }

    public void checkBatteryRefreshLink() {
        scrollDownTo(SO_DevicePlan_BatteryRefreshLink);
        SO_DevicePlan_BatteryRefreshLink.click();
        waitForVisibility(SO_DevicePlan_BatteryRefreshDescription);
        AssertDisplayed(SO_DevicePlan_BatteryRefreshDescription.isDisplayed());
        scrollDownTo(SO_DevicePlan_BatteryRefreshCTA);
        AssertDisplayed(SO_DevicePlan_BatteryRefreshCTA.isDisplayed());
    }

    public void checkManageDevicePlanCTA() {
        scrollDownTo(Manage_Device_PlanCTA);
        AssertDisplayed(Manage_Device_PlanCTA.isDisplayed());
        //check that each card has "Manage device pla" cta
        int numOfLoans = deviceLoanDetailsResponseModel.cards.size();
        for (int i = 1; i < numOfLoans; i++) {
            Assert.assertEquals(deviceLoanDetailsResponseModel.cards.get(i).actions.get(0).text, Manage_Device_PlanCTA.getText());
        }
    }


    @Override
    public void WhatIsDevicePlanCTA() {
        waitForVisibility(What_Is_Device_PlanCTA);
        What_Is_Device_PlanCTA.click();
    }

    @Override
    public void WhatIsDevicePlanOverlay() {
        waitForVisibility(What_Is_Device_PlanIcon);
        Assert.assertTrue(Your_DevicePlan_Explained_Title.getText().equals("Your Device Plan explained"));
        Assert.assertTrue(Your_DevicePlan_ExplanationMessage.getText().contains("Your Device Plan covers"));
    }

    @Override
    public void WhatIsDevicePlanNewCopyOverlay() {
        waitForVisibility(What_Is_Device_PlanIcon);
        Assert.assertTrue(Your_DevicePlan_Explained_Title.getText().equals("Your Device Plan explained"));
        Assert.assertTrue(Your_DevicePlan_ExplanationMessage.getText().contains("Your Device Plan is a flexible payment"));

    }

    @Override
    public void OkThanksCTA() {
        Ok_ThanksCTA.click();
    }

    @Override
    public void DevicePlanTab() {
        waitForVisibility(SO_DevicePlanTab);
        Assert.assertFalse(elementIsPresent(Your_DevicePlan_ExplanationMessage));
        AssertDisplayed(SO_DevicePlanTab.isDisplayed());
        AssertDisplayed(SO_DevicePlanTabContainer.isDisplayed());
    }

    @Override
    public void checkTrayList() {
        Manage_Device_PlanCTA.click();
        AssertDisplayed(Manage_Payment_Method.isDisplayed());
        AssertDisplayed(Complete_your_Payment.isDisplayed());
        AssertDisplayed(Payment_History.isDisplayed());
        AssertDisplayed(Important_Documents.isDisplayed());
    }

    @Override
    public void checkURL(String CTAName) {
        WebElement CTALocator = null;
        switch (CTAName) {
            case "Manage Payment Method":
                CTALocator = Manage_Payment_Method;
                Assert.assertEquals(Manage_Payment_Method_Description.getText(),"View or change payment details for this Device Plan");
                break;
            case "Make a payment":
                CTALocator = Complete_your_Payment;
                waitForVisibility(Complete_your_Payment_Description);
                Assert.assertEquals(Complete_your_Payment_Description.getText(),"Make a payment");
                break;
            case "Payment History":
                CTALocator = Payment_History;
                waitForVisibility(Payment_History_Description);
                Assert.assertEquals(Payment_History_Description.getText(),"Review your payment history");
                break;
            case "Important Documents":
                CTALocator = Important_Documents;
                waitForVisibility(Important_Documents_Description);
                Assert.assertEquals(Important_Documents_Description.getText(),"Go to your important documents");
                break;
            default:
                System.out.println("Undefined CTA name");
        }
        assert CTALocator != null;
        String CTAText = CTALocator.getText();
        CTALocator.click();
        Assert.assertTrue(driver.getPageSource().contains(CTAText));
        //close internal browser
        waitForVisibility(closeInternalWebview);
        AssertDisplayed(closeInternalWebview.isDisplayed());
        closeInternalWebview.click();
    }
    public void clickOnCancelButton() {
        Cancel_btn.click();
    }

}