package pages.Dashboard.VOV;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;


public class VOVPO extends CommonPo {


    @FindBy(how = How.XPATH, using ="com.myvodafoneapp:id/salutationTextView")
    public WebElement DB_VOVSalutation;
    
            @AndroidFindBy(xpath="com.myvodafoneapp:id/closeButton")
            @iOSXCUITFindBy(id = "btnVOVHideCTA")
    public WebElement DB_VOVhideCTA;
    
            @AndroidFindBy(xpath="com.myvodafoneapp:id/dashboard_VOV_title_label")
            @iOSXCUITFindBy(id = "txtVOVTitle")
    public WebElement DB_VOVTitle;
    
            @AndroidFindBy(xpath="com.myvodafoneapp:id/dashboard_VOV_message_label")
            @iOSXCUITFindBy(id = "txtVOVDescription")
    public WebElement DB_VOVDescription;
    
            @AndroidFindBy(xpath="com.myvodafoneapp:id/dashboard_VOV_left_button")
            @iOSXCUITFindBy(id = "btnVOVDefaultCTA")
    public WebElement DB_VOVCTA;
    

    
            @AndroidFindBy(xpath="com.myvodafoneapp:id/messagesCountTextView")
            @iOSXCUITFindBy(id = "imgVOVCount")
    
    public WebElement DB_VOVCount;
    


    public VOVPO() {
        super();
    }
}
