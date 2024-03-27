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
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollUpTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
import static utils.element_helpers.WaitHelpers.waitForVisibilityForReinvent;

public class EshopLinksIOS extends EshopLinksAbstract {
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    List<WebElement> EshopLinksElements = new ArrayList<>();
    List<String> linkElements;
    DashboardV4ResponseModel DashboardResponse;
    List EshopLinks;
    public EshopLinksIOS() {
        super();
        if(!live){
            DashboardResponse = DashboardUtils.GetDashboard();
            DashboardResponse = DashboardUtils.GetDashboard();
            EshopLinks = DashboardResponse.linksMenu.menuItems.get(0).subItems;
        }

    }


    public List<WebElement> EshopLinks() {
        linkElements = getAPIEshopLinksText();
        List<WebElement> elements = new ArrayList<>();
        for (String text : linkElements) {
            try {
                elements.add(driver.findElement(By.xpath("//*[@label='" + text + "']")));
            } catch (Exception e) {
                break;
            }
        }

        return elements;
    }


    public void scrollToEshopLinks() throws InterruptedException {
        Thread.sleep(5000);
        waitForVisibility(DB_SettingDashboardTray_icon);
        scrollDownTo((DB_SeeMoreEshopCTA));
        if (live) {
            AssertResult(DB_EshopTitle.getText(), "Shop");
        } else {
            AssertResult(DB_EshopTitle.getText(), DashboardResponse.linksMenu.menuItems.get(0).title);
        }
    }


    public void assertOnlyFourLinksDisplayed(int count) {
        List<String> live_assistance_links = Arrays.asList("Trade in Tool", "Phones", "Sim Only",
                "Home Broadband", "Insurance", "Mobile Wifi", "Watches", "Connect another device");
        if (live) {
            for (int i = 0; i < live_assistance_links.size(); i++) {
                if (i < live_assistance_links.size() - 3) {
                    scrollDownTo(By.xpath("//XCUIElementTypeStaticText[@name='txtDashboardLinksMenuSectionTitle_Assistance']"));
                    scrollUpTo(By.xpath("//*[@value='" + live_assistance_links.get(i) + "']"));
                    Assert.assertTrue(driver.findElement(By.xpath("//*[@value='" + live_assistance_links.get(i) + "']")).isDisplayed());
                    System.out.println(live_assistance_links.get(i));
                } else {
                    scrollDownTo((By.xpath("//XCUIElementTypeStaticText[@name='txtDashboardLinksMenuSectionTitle_Assistance']")));
                    if (i == 5) {
                        DB_SeeMoreEshopCTA.click();
                        System.out.println("clicked .....");
                    }
                    scrollDownTo((By.xpath("//XCUIElementTypeStaticText[@name='txtDashboardLinksMenuSectionTitle_Assistance']")));
                    scrollUpTo(By.xpath("//*[@value='" + live_assistance_links.get(i) + "']"));
                    System.out.println(live_assistance_links.get(i));
                }
            }
        } else {

            try {

                EshopLinksElements = EshopLinks();
                System.out.println(EshopLinksElements.size());
                if (DB_SeeMoreEshopCTA.getText().equals("Show more")) {
                    Assert.assertEquals(EshopLinksElements.size(), count);
                }
            } catch (Exception e) {
                List<WebElement> EshopLinksElements = new ArrayList<>();
                System.out.println("Less than four links");
                Assert.assertTrue(EshopLinksElements.size() <= count);
            }
        }
    }


    public void EshopLinkShowMoreCTA() {
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
            Assert.assertEquals(EshopLinksElements.get(k).getText(), EshopLinks[k]);
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
        List<String> APIEshopLinksText = new ArrayList<>();
        for (int j = 0; j < EshopLinks.size(); j++) {
            APIEshopLinksText.add(DashboardResponse.linksMenu.menuItems.get(0).subItems.get(j).title);
            System.out.println(DashboardResponse.linksMenu.menuItems.get(0).subItems.get(j).title);
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
        waitForVisibilityForReinvent(Trade_XIcon, 100);
        Trade_XIcon.click();
    }


    public void EshopLinkShowLessCTA() {
        try {
            scrollDownTo((DB_SeeLessEshopCTA));
        } catch (Exception e) {
            scrollDownTo(DB_SeeMoreEshopCTA);
            DB_SeeMoreEshopCTA.click();
            scrollDownTo(DB_SeeLessEshopCTA);
        }
        DB_SeeLessEshopCTA.click();
        scrollUpTo(DB_EshopTitle);
    }

    public void validateEachShopLinks() {

    }
}