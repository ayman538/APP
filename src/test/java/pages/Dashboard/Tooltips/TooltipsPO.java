package pages.Dashboard.Tooltips;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class TooltipsPO extends CommonPo {
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/pageBannerBody")
    public WebElement currentTip;
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/pageBannerTitle")
    public WebElement tipTitle;
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/triangleView")
    public WebElement triangleView;
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/circleView")
    public WebElement circleView;

            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='Next']"),
                    @iOSXCUITBy(xpath = "//*[@name='Thanks']")
            })
            @AndroidFindAll({
                    @AndroidBy(id = "com.myvodafoneapp:id/pageBannerPositiveActionButton"),
                    @AndroidBy(xpath = "//*[@name='Next']"),
                    @AndroidBy(xpath = "//*[@name='Thanks']")
            })
    public WebElement CTA;
            @AndroidFindBy(id = "com.myvodafoneapp:id/pageBannerNegativeActionButton")
            @iOSXCUITFindBy(id  = "TVdismissButton")
    public WebElement dismissCTA;


    public TooltipsPO() {
        super();
    }
}
