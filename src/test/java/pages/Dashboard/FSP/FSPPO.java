package pages.Dashboard.FSP;

import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import pages.Commons.CommonPo;

public class FSPPO extends CommonPo {
    
    @AndroidFindBy(id = "com.myvodafoneapp:id/overlayCloseButton")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "CVMconfirmButton"),
            @iOSXCUITBy(xpath = "//*[@label='Upgrade Now']")
    })
    public WebElement FSP_LearnMore_CTA;

    @AndroidFindBy(id = "com.myvodafoneapp:id/overlaysecondaryButton")
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "CVMsecondaryButton"),
            @iOSXCUITBy(xpath = "//*[@label='Not today']")
    })
    public WebElement FSP_Close_CTA;

    @AndroidFindAll({
            @AndroidBy(id = "com.myvodafoneapp:id/tutorialPrimaryButton"),
            @AndroidBy(id = "com.myvodafoneapp:id/btnCloseCTA"),
            @AndroidBy(id = "com.myvodafoneapp:id/PrimaryTutorialButton")
    })
    @iOSXCUITFindAll({
            @iOSXCUITBy(id = "tutorialPrimaryButton"),
            @iOSXCUITBy(id = "btnCloseCTAtutorialPrimaryButton"),
            @iOSXCUITBy(id = "btnCloseCTA"),
            @iOSXCUITBy(id = "PrimaryTutorialButton"),
            @iOSXCUITBy(xpath = "//*[@label='Close']")
    })
    public WebElement TUT_closeCTA;

    @AndroidFindBy(id = "com.sec.android.app.sbrowser:id/customtab_close")
    public WebElement Webpage_closeCTA;
}
