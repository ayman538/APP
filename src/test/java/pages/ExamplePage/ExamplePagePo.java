package pages.ExamplePage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.Commons.CommonPo;

public class ExamplePagePo extends CommonPo {

    @FindBy(xpath = "//*[@text = 'SKIP']")
    protected WebElement skip;
    @FindBy(id = "com.google.android.apps.maps:id/mainmap_container")
    protected WebElement googleMap;

    public ExamplePagePo() {
        super();
    }
}
