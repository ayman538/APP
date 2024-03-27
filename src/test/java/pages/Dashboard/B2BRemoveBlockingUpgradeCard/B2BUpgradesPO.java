package pages.Dashboard.B2BRemoveBlockingUpgradeCard;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class B2BUpgradesPO extends CommonPo {


            @AndroidFindBy(xpath = "//*[@text='Airtime Plan']")
            @FindBy(how = How.XPATH, using = "//*[@label='Airtime Plan']")
    public WebElement AirtimeTab;

            @AndroidFindAll({
                    @AndroidBy(id = "btnPlanCTA"),
                    @AndroidBy(id = "planCardCTA_0_0")
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "btnPlanCTA"),
                    @iOSXCUITBy(id = "planCardCTA_0_0")
            })
    public WebElement UpgradenowCTA;

            @AndroidFindAll({
                    @AndroidBy(id = "txtPlanDetails"),
                    @AndroidBy(id = "planCardDescription_0")
            })
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "txtPlanDetails"),
                    @iOSXCUITBy(id = "planCardDescription_0")
            })


    public WebElement VerifyTextINCard;


}
