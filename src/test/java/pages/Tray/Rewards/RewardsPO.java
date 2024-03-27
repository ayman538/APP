package pages.Tray.Rewards;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class RewardsPO extends CommonPo {
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='VeryMe']"),
            @FindBy(how = How.ID, using = "txtDrawerRewardsSubTitle_VeryMe")
    })
    public WebElement DB_veryMeInDashboardTrayDrawer;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Offers for you']"),
            @FindBy(how = How.ID, using = "txtDrawerRewardsSubTitle_Offers for you")
    })
    public WebElement DB_OffersForYou_txt;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Topup Rewards']"),
            @FindBy(how = How.ID, using = "txtDrawerRewardsSubTitle_Topup Rewards")
    })
    public WebElement DB_TopupRewardsDrawer_txt;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle"),
            @FindBy(how = How.ID, using = "txtScreenTitleLabel"),
            @FindBy(how = How.ID, using = "Offers for you")
    })
    public WebElement DB_PontisOffer_webview;



    public RewardsPO() {
        super();
    }

}
