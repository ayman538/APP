package pages.Dashboard.CreditTilePayG;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class CreditTilePayGPO extends CommonPo {

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/cardHeaderTextView")
            @iOSXCUITFindBy(id = "txtDashboardChargesCardHeader")
    public WebElement DB_creditTileHeader;
            
            @AndroidFindBy(id = "com.myvodafoneapp:id/cardTitleTextView")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "txtDashboardWarningLabel"),//for low credit iOS
                    @iOSXCUITBy(id = "txtDashboardCurrentSpendsAccountName"),
                    @iOSXCUITBy(xpath = "(//*[@label='Your credit is low'])")
            })
    public WebElement DB_creditTileText;
    
            @AndroidFindBy(id = "com.myvodafoneapp:id/balanceTextView")
            @iOSXCUITFindBy(id = "txtDashboardCurrentSpendsDetails")
    public WebElement DB_creditTileAmount;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/currentChargesContainer")
            @iOSXCUITFindBy(id = "Dashboard_CurrentSpends_Section")
    public WebElement DB_creditTileIcon;

    
            @iOSXCUITFindBy(xpath = "//*[@label='Top up this number by card']")
            @AndroidFindBy(xpath = "//*[@text='Top up this number by card']")
    public WebElement TopUpThisNumberByCard;

    
            @iOSXCUITFindBy(xpath = "//*[@label='Auto top up']")
            @AndroidFindBy(xpath = "//*[@text='Auto top up']")
    public WebElement AutoTopUp;
    
            @iOSXCUITFindBy(xpath = "//*[@label='Manage payment cards']")
            @AndroidFindBy(xpath = "//*[@text='Manage payment cards']")
    public WebElement ManagePaymentCards;
    
            @iOSXCUITFindBy(xpath = "//*[@label='Activate voucher']")
            @AndroidFindBy(xpath = "//*[@text='Activate voucher']")
    public WebElement ActivateVoucher;

    
            @AndroidFindBy(xpath = "//*[contains(@text,'Plan: Pay as you go')]")
            @iOSXCUITFindBy(xpath = "//*[contains(@label,'Plan: Pay as you go')]")
    public WebElement PaygPlan;

    
            @AndroidFindBy(xpath = "//*[@text='Buy a Big Value Bundle']")
            @iOSXCUITFindBy(xpath = "//*[@label='Buy a Big Value Bundle']")
    public WebElement BugBigValue;

    
            @AndroidFindBy(xpath = "//*[contains(@text,'Add or manage')]")
            @iOSXCUITFindBy(xpath = "//*[@name='Add or manage a Big Value Bundle']")
    public WebElement SSO_BigValue;


            @AndroidFindBy(id = "com.myvodafoneapp:id/rv_ln")
            @iOSXCUITFindBy(xpath="//*[@label='Plan']")
            public WebElement plancontainerPAYG;


             @AndroidFindBy(id= "com.myvodafoneapp:id/headerContainerView")
             @iOSXCUITFindBy(xpath= "//*[@label='Usage']")
    public WebElement usagecontainerPAYG;

    
            @iOSXCUITFindBy(xpath = "//*[@label='Top up with PayPal']")
            @AndroidFindBy(xpath = "//*[@text='Top up with PayPal']")
    public WebElement TopUpWithPayPal;

    
            @iOSXCUITFindBy(xpath = "//*[@label='Top up any number']")
            @AndroidFindBy(xpath = "//*[@text='Top up any number']")
    public WebElement TopUpAnyNumber;
    
            @iOSXCUITFindBy(xpath = "//*[@label='Add a data pack']")
            @AndroidFindBy(xpath = "//*[@text='Add a data pack']")
    public WebElement AddDataPack;

    public CreditTilePayGPO() {
        super();
    }
}
