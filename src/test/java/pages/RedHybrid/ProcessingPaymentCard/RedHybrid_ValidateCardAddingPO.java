package pages.RedHybrid.ProcessingPaymentCard;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class RedHybrid_ValidateCardAddingPO extends CommonPo {


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtProcessingRedHybridBody"),
            @FindBy(how = How.ID, using = "txtProcessingRedHybridBody")
    })
    public WebElement RedHybrid_ProcessingBody;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtSuccessRedHybridBody"),
            @FindBy(how = How.ID, using = "txtSuccessRedHybridBody")
    })
    public WebElement RedHybrid_SuccessBody;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/imgFailedRedHybridTik"),
            @FindBy(how = How.ID, using = "imgFailedRedHybridTik")
    })
    public WebElement RedHybrid_FailedTik;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtFailedRedHybridBody"),
            @FindBy(how = How.ID, using = "txtFailedRedHybridBody")
    })
    public WebElement RedHybrid_FailedBody;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtDetailsFailedBody"),
            @FindBy(how = How.ID, using = "txtDetailsFailedBody")
    })
    public WebElement RedHybrid_FailedDetails;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnTryAgainFailedCTA"),
            @FindBy(how = How.ID, using = "btnTryAgainFailedCTA")
    })
    public WebElement RedHybrid_FailedCTA;

    public RedHybrid_ValidateCardAddingPO() {
        super();
    }

}
