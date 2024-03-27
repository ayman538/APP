package pages.Dashboard.NewVOV;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

public abstract class RemoveVOVAbstract extends RemoveVOVPO {

    public abstract void validateHidingVovFromUI();
    public abstract void SwitchToSubscription(WebElement userType)throws InterruptedException, ParseException;
}
