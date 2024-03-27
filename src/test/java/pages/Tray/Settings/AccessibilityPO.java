package pages.Tray.Settings;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class AccessibilityPO extends CommonPo {
    public AccessibilityPO(){super();}

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Accessibility']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Accessibility']")

    })
    public WebElement AS_Accessibility;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Accessibility']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Accessibility']")

    })
    public WebElement SSO_Accessibility;
}
