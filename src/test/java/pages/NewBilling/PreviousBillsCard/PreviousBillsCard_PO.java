package pages.NewBilling.PreviousBillsCard;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class PreviousBillsCard_PO extends CommonPo {

    public PreviousBillsCard_PO(){super();}

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/previous_card_title"),
            @FindBy(how = How.XPATH, using = "//*[@name='Previous bills']")
    })
    public WebElement Previous_Bill_Title;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='com.myvodafoneapp:id/previous_card_item_month_name']"),
            @FindBy(how = How.XPATH, using = "//*[@name='previous_card_item_month_name']")
    })
    public WebElement Month_Name;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='com.myvodafoneapp:id/previous_card_item_bill_date_range']"),
            @FindBy(how = How.XPATH, using = "//*[@name='previous_card_item_bill_date_range']")
    })
    public WebElement Billing_Period;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/previous_card_item_bill_amount"),
            @FindBy(how = How.XPATH, using = "//*[@name='previous_card_item_bill_amount']")
    })
    public WebElement Bill_Amount;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/previous_card_load_more"),
            @FindBy(how = How.XPATH, using = "//*[@name='Load More']")
    })
    public WebElement LoadMore_CTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@resource-id='com.myvodafoneapp:id/previous_card_month_item_arrow_icon']"),
            @FindBy(how = How.XPATH, using = "//*[@name='previous_card_month_item_arrow_icon']")

    })
    public WebElement Arrow_Icon;

    @FindAll({
        @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[starts-with(@name, 'Previous bill')]"),
        @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]"),
            @FindBy(how = How.XPATH, using = "//*[contains(@text, 'Previous bill')]"),
        @FindBy(how = How.XPATH, using = "//android.view.View[@resource-id='root']/android.view.View/android.view.View[1]/android.view.View[1]/android.widget.TextView[1]")

    })
    public WebElement PreviousBillCard_ReinventJourney;
}