package pages.RedHybrid.Dashboard_ExtrasList_overlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class Dashboard_ExtrasList_Overlay_PO extends CommonPo {



    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addExtrasDescription"),
            @FindBy(how = How.ID, using = "addExtrasDescription"),
            @FindBy(how = How.XPATH, using = "//*[@label='Which Extra would you like?']")
    })
    public WebElement addExtrasOverlaySubtitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/extrasListView")
    })
    public WebElement extrasList;


}
