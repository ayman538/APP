package pages.Dashboard.ViewBasket;

import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ViewBasketIOS extends ViewBasketAbstract {
    @Override
    public void viewBasketExistsWithNoCounter() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_BasketIcon.isDisplayed());
        Assert.assertFalse(elementIsPresent(DB_BasketCounter));
    }


    @Override
    public void viewBasketExistsWithCounter() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_BasketIcon.isDisplayed());
        AssertDisplayed(DB_BasketCounter.isDisplayed());
    }

    @Override
    public void viewBasketDoesNotExist() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        Assert.assertFalse(elementIsPresent(DB_BasketIcon));

    }

    @Override
    public void clickOnBasket() {
        waitForVisibility(DB_BasketIcon);
        DB_BasketIcon.click();
    }

    @Override
    public void assertShopCustomTabIsDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println(driver.getPageSource());
        assertEquals(true, driver.getPageSource().contains("SIM only deals"));
        CheckElementNotExist(DB_MyAccountTray_icon);
    }

    @Override
    public void validateBasketWebpageIsDisplayed() throws InterruptedException {
        Thread.sleep(20000);
        waitForVisibility(basketWebpage);
        System.out.println(driver.getPageSource());
        Assert.assertTrue(driver.getPageSource().contains("Review your basket"));
        CheckElementNotExist(DB_MyAccountTray_icon);
    }

}
