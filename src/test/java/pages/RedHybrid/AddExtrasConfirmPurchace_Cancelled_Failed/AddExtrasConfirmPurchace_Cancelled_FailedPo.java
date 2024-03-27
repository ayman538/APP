package pages.RedHybrid.AddExtrasConfirmPurchace_Cancelled_Failed;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class AddExtrasConfirmPurchace_Cancelled_FailedPo extends CommonPo {

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = "android.widget.EditText"),
            @FindBy(how = How.ID, using = "confirmCsc")

    })

    public static WebElement NewCardSecurityCode;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Payment method']"),
            @FindBy(how = How.ID, using = "Payment method")

    })

    public static WebElement AddExtraBarcalysHeader;
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID, using = "Continue")
    })
    public WebElement AddExtracontinueCTA;

    public AddExtrasConfirmPurchace_Cancelled_FailedPo() {
        super();
    }


}
