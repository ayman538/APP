package pages.RedHybrid.SubsOverlayExtrasListOverlay;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class SubsOverlayExtrasListOverlayPO extends CommonPo {


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Add Extras']"),
            @FindBy(how = How.XPATH, using = "//*[@label='Add Extras']")
    })
    public WebElement addExtrasTile;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Buy Extras']"),
            @FindBy(how = How.ID, using = "Buy Extras")

    })
    public WebElement BuyExtrasCTA;


    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Extras']"),
            @FindBy(how = How.ID, using = "Extras")

    })
    public WebElement ExtrasTab;
}
