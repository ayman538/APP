package pages.RedHybrid.AutoRenewTooltip;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AutoRenewTooltipPO  extends CommonPo {


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgLeftButton"),
            @FindBy(how = How.NAME, using = "imgRedPlanAutoRenewView_0")
    })
    public WebElement iIcon;

    @FindAll({

            @FindBy(how = How.ID,using = "com.myvodafoneapp:id/pageBannerPositiveActionButton"),
            @FindBy(how = How.NAME, using = "Thanks")
    })
    public WebElement ThanksCTA;





    public AutoRenewTooltipPO() {
        super();
    }
}

