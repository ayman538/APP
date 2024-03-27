package pages.Dashboard.VeryMe;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

@Deprecated
public class VeryMeTitleCTAPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/vodafoneLogoImageView"),
            @FindBy(how = How.XPATH, using = "(//XCUIElementTypeButton[@name='Get'])[1]")
    })
    public WebElement DB_VFLogo;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDashboardVeryMeRewardsTitle"),
            @FindBy(how = How.ID, using = "txtDashboardVeryMeRewardsTitle")
    })
    public WebElement DB_VeryMe_Title;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnDashboardVeryMeRewardsCTA"),
            @FindBy(how = How.ID, using = "btnDashboardVeryMeRewardsCTA")
    })
    public WebElement DB_ViewAll_CTA;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgDashboardVeryMeOffer"),
            @FindBy(how = How.ID, using = "imgDashboardVeryMeOffer")
    })
    public WebElement DB_CarouselVeryMe_Image;

    public VeryMeTitleCTAPO() {
        super();
    }
}
