package pages.Dashboard.EshopLinks;

import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.DashboardUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class EshopLinksAndroid extends EshopLinksAbstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    List<WebElement> EshopLinksElements = new ArrayList<>();
    DashboardV4ResponseModel DashboardResponse;
    private final By assistance_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/headerTextView') and @text='Assistance']");
    private final By eshop_title = By.xpath("//android.widget.TextView[contains(@resource-id, 'com.myvodafoneapp:id/headerTextView') and @text='Shop']");

    List<String> live_assistance_links = Arrays.asList("Trade in Tool", "Phones", "Sim Only",
            "Home Broadband", "Insurance", "Mobile Wifi", "Watches", "Connect another device");

    public EshopLinksAndroid() {
        super();
        if (!live) DashboardResponse = DashboardUtils.GetDashboard();
    }


    public List<WebElement> EshopLinks() {
        List<WebElement> elements = new ArrayList<>();
        for (String text : getAPIEshopLinksText()) {
            try {
                elements.add(driver.findElement(By.xpath("//*[@text='" + text + "']")));
            } catch (Exception e) {
                break;
            }
        }

        return elements;
    }


    public void scrollToEshopLinks() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        if (live) {
            scrollDownTo((eshop_title));
            AssertResult(driver.findElement(eshop_title).getText(), "Shop");
        } else {
            scrollDownTo((DB_SeeMoreEshopCTA));
            System.out.println("App:" + DB_EshopTitle.getText());
            System.out.println("Api:" + DashboardResponse.linksMenu.menuItems.get(0).title);
            AssertResult(DB_EshopTitle.getText(), DashboardResponse.linksMenu.menuItems.get(0).title);
        }
    }

    public void assertOnlyFourLinksDisplayed(int count) {
        if (live) {
            assertEshopLive(live_assistance_links);
        } else {
            try {
                EshopLinksElements = EshopLinks();
                System.out.println(EshopLinksElements.size());
                if (DB_SeeMoreEshopCTA.getText().equals("Show more")) {
                    Assert.assertEquals(EshopLinksElements.size(), count);
                }
            } catch (Exception e) {
                System.out.println("No. of links less than the expected size");
                Assert.assertTrue(EshopLinksElements.size() <= count);
            }
        }
    }

    private void assertEshopLive(List<String> live_assistance_links) {
        for (int i = 0; i < live_assistance_links.size(); i++) {
            if (i < live_assistance_links.size() - 3) {
                scrollDownTo(assistance_title);
                scrollUpTo(By.xpath("//*[@text='" + live_assistance_links.get(i) + "']"));
                Assert.assertTrue(driver.findElement(By.xpath("//*[@text='" + live_assistance_links.get(i) + "']")).isDisplayed());
                System.out.println(live_assistance_links.get(i));
            } else {
                scrollDownTo(assistance_title);                if (i == 5) {
                    DB_SeeMoreEshopCTA.click();
                    System.out.println("clicked .....");
                }
                scrollDownTo(assistance_title);
                scrollUpTo(By.xpath("//*[@text='" + live_assistance_links.get(i) + "']"));
                System.out.println(live_assistance_links.get(i));
            }
        }
    }


    public void EshopLinkShowMoreCTA() {
        // scrollDownElementOverCenterScreen(DB_SeeMoreEshopCTA);
        DB_SeeMoreEshopCTA.click();
        EshopLinksElements = EshopLinks();
        Assert.assertTrue(EshopLinksElements.size() > 5);
    }


    public void ValidateEshopLinksOrderAndText() throws InterruptedException {
        String[] EshopLinks = {"Trade in Tool", "Phones", "Sim Only", "Home Broadband", "Insurance", "Mobile Wifi", "Watches", "Connect another device"};
        System.out.println("Size:  " + getAPIEshopLinksText().size());
        String verifyLink;
        EshopLinksElements = EshopLinks();
        for (int k = 0; k < getAPIEshopLinksText().size(); k++) {
            // Handling scroll in case of dashboard is being reloaded
            try {
                scrollDownTo(EshopLinksElements.get(k));
            } catch (Exception e) {
                scrollToEshopLinks();
                EshopLinkShowMoreCTA();
            }
            System.out.println("Link:  " + EshopLinksElements.get(k).getText());
            Assert.assertEquals(getAPIEshopLinksText().get(k), EshopLinksElements.get(k).getText());
            Assert.assertEquals(EshopLinksElements.get(k).getText(), EshopLinks[k]);
            /* if(k > 5){

                scrollDownElementOverCenterScreen(DB_SeeLessEshopCTA);
            }*/
            verifyLink = EshopLinksElements.get(k).getText();
            WebElement shopLink = EshopLinksElements.get(k);
            shopLink.click();
            if (verifyLink.equals("Trade in Tool")) {
                closeTradeINScreen();
            } else if (verifyLink.equals("Connect another device")) {
                verifyExternalBrowserdisplayed();
            } else {
                verifyInternalBrowserdisplayed();
            }
        }
    }


    public List<String> getAPIEshopLinksText() {
        DashboardV4ResponseModel DashboardResponse = DashboardUtils.GetDashboard();
        List EshopLinks = DashboardResponse.linksMenu.menuItems.get(0).subItems;
        List<String> APIEshopLinksText = new ArrayList<>();
        for (int j = 0; j < EshopLinks.size(); j++) {
            APIEshopLinksText.add(DashboardResponse.linksMenu.menuItems.get(0).subItems.get(j).title);
        }
        return APIEshopLinksText;
    }


    public void verifyInternalBrowserdisplayed() {
        waitForVisibility(closeInternalWebview);
        AssertDisplayed(closeInternalWebview.isDisplayed());
        closeInternalWebview.click();
        waitForVisibility((DB_SettingDashboardTray_icon));

    }

    public void verifyExternalBrowserdisplayed() {
        waitForVisibility(DoneCtaInExternalbrowser);
        AssertDisplayed(DoneCtaInExternalbrowser.isDisplayed());
        DoneCtaInExternalbrowser.click();
        waitForVisibility((DB_SettingDashboardTray_icon));
    }


    public void closeTradeINScreen() throws InterruptedException {
        Thread.sleep(1000);
        waitForVisibility(Trade_XIcon);
        Trade_XIcon.click();
    }


    public void EshopLinkShowLessCTA() {
        // Handling in case of dashboard page reloaded
        try {
            //scrollDownTo((DB_SeeLessEshopCTA));
            AssertDisplayed(DB_SeeLessEshopCTA.isDisplayed());
        } catch (Exception e) {
            scrollDownTo(DB_SeeMoreEshopCTA);
            DB_SeeMoreEshopCTA.click();
            scrollDownTo(DB_SeeLessEshopCTA);
        }
        DB_SeeLessEshopCTA.click();
        scrollUpTo(DB_EshopTitle);
    }


    /***********************/
    public void validateEachShopLinks() throws InterruptedException {
        validateEshopTitle();
        validateShowMore();
        int counter = 0;
        for (DashboardV4ResponseModel.DashboardSubItem subItem : DashboardResponse.linksMenu.menuItems.get(0).subItems) {
            String title = subItem.title;
            if (counter <= 2) {
                scrollDownTo((DB_EshopTitle));
                vlidateEachLinkJourney(title);
            }

            if (counter > 2) {
                scrollUpTo(DB_EshopTitle);
                scrollDownAndroid();
                clickOnShowMoreIfDisplayed();
                vlidateEachLinkJourney(title);
            }
            counter++;
        }
    }

    public void validateEshopTitle() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo((DB_EshopTitle));
        AssertResult(DB_EshopTitle.getText(), DashboardResponse.linksMenu.menuItems.get(0).title);
    }

    public void validateShowMore() {
        if (DashboardResponse.linksMenu.menuItems.get(0).subItems.size() > 4) {
            Assert.assertTrue(driver.findElement(By.xpath(GetXpath("Show more"))).isDisplayed());
        }
    }

    public void validatEshopLinksNavigation(String linkTitle) {
        driver.findElement(By.xpath(GetXpath(linkTitle))).click();
        Assert.assertTrue(driver.getPageSource().contains("vodafone"));
    }

    public void navigateBackFromEshopLinks(String title) {
        if (title.equals("Trade in Tool")) {
            try {
                closeTradeINScreen();
            } catch (Exception e) {
                System.out.println("trade in has some issues");
            }
        } else if (title.equals("Connect another device")) {
            verifyExternalBrowserdisplayed();
        } else {
            verifyInternalBrowserdisplayed();
        }
    }

    public void clickOnShowMoreIfDisplayed() {
        try {
            driver.findElement(By.xpath(GetXpath("Show more"))).click();

        } catch (Exception e) {
            System.out.println("show more doesn't displayed this time");
        }
    }

    public void vlidateEachLinkJourney(String title) {
        System.out.println(title);
        validatEshopLinksNavigation(title);
        navigateBackFromEshopLinks(title);
    }


}