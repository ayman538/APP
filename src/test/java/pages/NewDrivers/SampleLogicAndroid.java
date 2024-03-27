package pages.NewDrivers;


import org.openqa.selenium.By;

import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class SampleLogicAndroid extends SampleAbstract {





    public void validateNewImplement() throws InterruptedException {
        startActivity();
        Thread.sleep(7000);
//        waitVisibility(And_continueCTA);
        By And_continueCTA = By.xpath("//*[@text ='Continue']");
        waitForVisibility(And_continueCTA);
        driver.findElement(And_continueCTA).click();
        System.out.println("tmaaaaam");
    }


}
