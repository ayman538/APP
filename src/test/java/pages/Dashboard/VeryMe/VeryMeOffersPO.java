package pages.Dashboard.VeryMe;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITBy;
import io.appium.java_client.pagefactory.iOSXCUITFindAll;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class VeryMeOffersPO extends CommonPo {

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/imgDashboardVeryMeOfferLogo")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='imgDashboardVeryMeOfferLogo']"),
                    @iOSXCUITBy(id = "imgDashboardVeryMeOfferLogo")
            })
    
    public WebElement DB_CarouselVeryMe_logo;
    
            @AndroidFindBy(id = "com.myvodafoneapp:id/imgDashboardVeryMeOffer")
            @FindBy(how = How.ID_OR_NAME, using = "imgDashboardVeryMeOffer")
    
    public WebElement DB_CarouselVeryMe_Image;
    
            @AndroidFindBy(id = "com.myvodafoneapp:id/txtDashboardVeryMeOfferTitle")
            @FindBy(how = How.ID_OR_NAME, using = "txtDashboardVeryMeOfferTitle")
    
    public WebElement DB_CarouselVeryMe_text;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/txtDashboardVeryMeRewardsTitle")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@label='VeryMe Rewards']"),
            })
    public WebElement DB_VeryMe_Title;
    
            @AndroidFindBy(id = "com.myvodafoneapp:id/btnDashboardVeryMeRewardsCTA")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(id = "btnDashboardVeryMeRewardsCTA")
            })
    public WebElement DB_ViewAll_CTA;

    
            @AndroidFindBy(id = "com.myvodafoneapp:id/container")
            @iOSXCUITFindAll({
                    @iOSXCUITBy(xpath = "//*[@name='Veryme']"),
                    @iOSXCUITBy(id = "Veryme")
            })
    
    public WebElement DB_VerMePage;
    public VeryMeOffersPO() {
        super();
    }


}
