package pages.Tray.Billing;

import org.openqa.selenium.By;
import testdata.ReadResponse;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollUpTo;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class BillingLogic extends BillingPO {
    private final By billing_From_tray = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/txtPlanListItemTitle') and @text='Billing']");


    public BillingLogic() {
        super();
    }

    public void navigateToBilling() {
        waitForVisibility(billing_From_tray);
        driver.findElement(billing_From_tray).click();
    }
    public void validateBillingScreen() {
        if (ReadResponse.GetSegment().equalsIgnoreCase("CONSUMER")) {
            assertBillXiconIsDisplayed();
        } else if (ReadResponse.GetSegment().equalsIgnoreCase("SOLE_TRADER") || ReadResponse.GetSegment().equalsIgnoreCase("SMB")) {
            assertLoginUsernameIsDisplayed();
            Login_Xicon.click();
        }
    }

    public void assertLoginUsernameIsDisplayed() {
        waitForVisibility(Login_username);
        AssertDisplayed(Login_username.isDisplayed());
    }

    public void assertBillXiconIsDisplayed() {
        waitForVisibility(Bill_Xicon);
        AssertDisplayed(Bill_Xicon.isDisplayed());
    }

    public void ValidateAccountName() {
        String accountName = ReadResponse.GetBillingAccountName();
        String actualAccName = "";

        scrollDownTo(Bill_accountName);
        if (Bill_accountName.getText().contains("Account: ")) {
            actualAccName = Bill_accountName.getText().replace("Account: ", "");
        } else {
            actualAccName = Bill_accountName.getText();
        }
        AssertResult(actualAccName, accountName);
    }

    public void ValidateVatsDisplayed() {
        if (ReadResponse.checkVatsAppearance()) {
            scrollUpTo(Bill_Vats);
            AssertResult(Bill_Vats.getText(), "All costs include VAT");
        }
    }

    public void ValidateGraphAppearance() {
        if (ReadResponse.checkBillingGraphAppearance()) {
            AssertDisplayed(Bill_graph.isDisplayed());
        }
    }

    public void ValidateGraphTitle() throws InterruptedException {
        waitForVisibility(Bill_graphTitle);
        Thread.sleep(500);
        AssertResult(Bill_graphTitle.getText(), "Latest bills");
    }

    public void ValidateViewAllCTAText() {
        scrollDownTo(Bill_viewAllCTA);
        AssertResult(Bill_viewAllCTA.getText(), "View all");
        scrollUpTo(Bill_graphTitle);
    }

    public void ValidateViewAllCTA() {
        clickBillingViewAllCTA();
        waitForVisibility(Login_username);
        AssertDisplayed(Login_username.isDisplayed());
        Login_Xicon.click();
        waitForVisibility(Bill_viewAllCTA);
        scrollUpTo(Bill_accountName);
    }

    public void clickBillingViewAllCTA() {
        scrollDownTo(Bill_viewAllCTA);
        Bill_viewAllCTA.click();
    }

    public void ValidateCloseCTADisplayed() {
        assertBillXiconIsDisplayed();
    }

    public void ValidateCloseCTAFunctionality() {
        clickBillXicon();
        assertBillingTrayIcon();
    }

    public void assertBillingTrayIcon() {
        waitForVisibility(DB_BillingTray_icon);
        AssertDisplayed(DB_BillingTray_icon.isDisplayed());
    }

    public void clickBillXicon() {
        waitForVisibility(Bill_Xicon);
        Bill_Xicon.click();
    }

    public void ValidateBillingCardsDisplayed() {
        LinkedHashMap<String, String> billingOfMonths = ReadResponse.GetBillingMonths();
        waitForVisibility(Bill_Xicon);
        for (String elementOfCard : billingOfMonths.values()) {
            scrollDownToCard(elementOfCard);
            AssertResult(getElementByText(elementOfCard).getText(), elementOfCard);
        }
        scrollUpTo(Bill_accountName);
    }

    public void scrollDownToCard(String cardElement) {
        try {
            getElementByText(cardElement);
        } catch (Exception e) {
            scrollDownTo(getElementByText(cardElement));
        }
    }

    public void ValidateBillingCardsCTA() {
        List year = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "September", "August", "October", "November", "December");
        LinkedHashMap<String, String> billingOfMonths = ReadResponse.GetBillingMonths();
        for (String elementOfCard : billingOfMonths.values()) {
            if (year.contains(elementOfCard)) {
                waitForVisibility(Bill_Xicon);
                scrollDownTo(getElementByText(elementOfCard));
                getElementByText(elementOfCard).click();
                assertLoginUsernameIsDisplayed();
                Login_Xicon.click();
                break;
            }
        }
    }

}