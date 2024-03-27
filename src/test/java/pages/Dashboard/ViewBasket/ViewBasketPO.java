package pages.Dashboard.ViewBasket;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class ViewBasketPO extends CommonPo {

            @AndroidFindAll({
                    @AndroidBy(id = "shoppingCartImageView"),
                    @AndroidBy(id = "ic-shopping-cart")
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name='shoppingCartButton']"),
                    @iOSXCUITBy(xpath = "//XCUIElementTypeButton[@name='shoppingCartImageView']"),
                    @iOSXCUITBy(id = "ic-shopping-cart")
            })
    
    public WebElement DB_BasketIcon;

            @AndroidFindBy(id = "cartBadgeTextView")
            @iOSXCUITFindBy(xpath = "//XCUIElementTypeOther[@name='cartItemsView']/XCUIElementTypeOther")
    public WebElement DB_BasketCounter;

    
            @AndroidFindBy(xpath = "*//android.view.View/android.widget.TextView[1][@text='Review your basket']")
            @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Review your basket']")
    public WebElement basketWebpage;


}
