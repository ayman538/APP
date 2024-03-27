package pages.Dashboard.EshopLinks;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class EshopLinksAbstract extends EshopLinksPO {

    public EshopLinksAbstract(){
        super();
    }

    public abstract List<WebElement> EshopLinks();
    public abstract void assertOnlyFourLinksDisplayed(int count);
    public abstract void EshopLinkShowMoreCTA();
    public abstract void scrollToEshopLinks() throws InterruptedException;
    public abstract void ValidateEshopLinksOrderAndText() throws InterruptedException;
    public abstract List<String> getAPIEshopLinksText();
    public abstract void closeTradeINScreen() throws InterruptedException;
    public abstract void EshopLinkShowLessCTA();
    public abstract void verifyInternalBrowserdisplayed();
    public abstract void validateEachShopLinks() throws InterruptedException;







}

