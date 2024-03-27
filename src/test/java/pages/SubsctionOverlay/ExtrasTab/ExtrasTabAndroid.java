package pages.SubsctionOverlay.ExtrasTab;

import models.response.ExtrasResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ExtrasUtils;

import java.util.List;

import static utilities.PropertiesLoader.readEnv;
import static utils.element_helpers.GenericHelpers.clickOnRetryButton;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ExtrasTabAndroid extends ExtrasTabAbstract{
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    private final By extras_tab = By.xpath("//*[@content-desc='Extras']");
    ExtrasResponseModel extrasResponseModel ;
    public ExtrasTabAndroid(){
        super();
        if(!live)extrasResponseModel = ExtrasUtils.getExtras();
    }

    public List<WebElement>  ExtraBarsCapsElements() throws InterruptedException {
        Thread.sleep(3000);
        return driver.findElements(By.xpath("//*[@text='Active controls, limits and extras']/parent::*//android.widget.LinearLayout[@resource-id='com.myvodafoneapp:id/txtExtrasItem']"));
        /*
        WebElement myExtrasSection= driver.findElement(By.id("com.myvodafoneapp:id/wdgMyExtraAllowencesSection"));
        scrollDownTo(Extras_BuyManageExtrasCTA);
        return myExtrasSection.findElements(By.id("com.myvodafoneapp:id/txtExtrasItem"));

         */
    }

    public List<WebElement>  MyExtraAllowancesElements() throws InterruptedException {
        Thread.sleep(3000);
        List<WebElement> found = driver.findElements(By.xpath("//*[@text='My extra allowances']/parent::*//android.widget.LinearLayout[@resource-id='com.myvodafoneapp:id/txtExtrasItem']"));
        return found;
    }

    public List<WebElement> MyExtraAllowancesRenwalDate(){
        return (List<WebElement>) driver.findElements(By.xpath("//*[@text='My extra allowances']/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/txtExtraSubTitle']"));
    }

    public void checkExtraBarsCapsCard() throws InterruptedException {
        scrollDownTo(Extras_BuyManageExtrasCTA);
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("Active controls, limits and extras")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(ExtraBarsCapsElements().get(k));
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).title,ExtraBarsCapsElements().get(k).findElement(By.id("com.myvodafoneapp:id/extraDetailsText")).getText());
                }
            }
        }
    }

    public void checkExtraAllowancesCard() throws InterruptedException {
        //scrollDownTo(Extras_MyExtraAllowencesTitle);
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("My extra allowances")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(MyExtraAllowancesElements().get(k));
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).title,MyExtraAllowancesElements().get(k).findElement(By.id("com.myvodafoneapp:id/extraDetailsText")).getText());
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).text,MyExtraAllowancesElements().get(k).findElement(By.id("com.myvodafoneapp:id/extraExpiryDateText")).getText());
                }
            }
        }
    }

    public void checkManageBarsExtrasCTA(){
        scrollDownTo(Extras_BuyManageExtrasCTA);
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).displayType.contains("EXTRAS_ACTION_CARD")){
                scrollDownTo(Extras_BuyManageExtrasCTA);
                Assert.assertEquals(extrasResponseModel.cards.get(i).actions.get(0).text,Extras_BuyManageExtrasCTA.getText());
                Extras_BuyManageExtrasCTA.click();
            }
        }
    }

    public void checkLoginScreenAppear(){
        try{
            waitForVisibility(AcceptCookies);
            AcceptCookies.click();
        }
        catch (Exception e){

        }
        waitForVisibility(DX_IDM_X_Button);
        AssertDisplayed(DX_IDM_X_Button.isDisplayed());
    }

    public void navigateToExtras(){
        ExtrasCTA();
    }

    public void ExtrasCTA() {
        if(live){
            SwipeToElement(extras_tab, "Left");
            driver.findElement(extras_tab).click();
            waitForVisibility(Extras_TabContainer);
        }else {
            SwipeToElement(SO_ExtrasTab, "Left");
            SO_ExtrasTab.click();
            clickOnRetryButton();
            waitForVisibility(Extras_TabContainer);
        }
    }

    @Override
    public void TapOnDataCapProduct() {
        waitForVisibility(Extra_DataCaps);
        Extra_DataCaps.click();
        waitForVisibility(Extra_ManageDataCapCTA);
        Extra_ManageDataCapCTA.click();
    }

    public void checkAffiliateOrPromoDiscount(){
        Assert.assertTrue(User_Discount.getText().contains("Broadband discount"));
    }

    public void ValidateManageControlsLimitsCopy()
    {
        Assert.assertEquals("Manage Controls and Limits",ManageControlsAndLimitsCTA.getText());
    }

    public void ValidateRedirectionOfManageControlsLimits()
    {
        ManageControlsAndLimitsCTA.click();
        waitForVisibility(ManageControlsAndLimitsWebView);
        Assert.assertTrue(ManageControlsAndLimitsWebView.getText().contains("Controls and limits"));
    }



    public void checkExtraAllowancesCTADetails() throws InterruptedException {
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("My extra allowances")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(MyExtraAllowancesElements().get(k));
                    MyExtraAllowancesElements().get(k).click();
                    waitForVisibility(Extras_MyExtrasAllowancesTitle);
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentTitleAlignedLeft.
                            replace("<b>","").replace("</b>",""),
                            Extras_MyExtrasAllowancesTitle.getText());
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentText.replaceAll("\n","").replaceAll(" ","")
                            .replaceAll("<ahref=\"https://www.vodafone.co.uk/terms-and-conditions/consumer/vodafone-passes/Vodafone-passes/index.htm\"target=\"_blank\">","")
                            .replaceAll("</a>",""),
                            Extras_MyExtrasAllowancesDescription.getText().replaceAll("\n","").replaceAll(" ",""));
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentButton.text,
                            Extra_detailsCTA.getText());
                    Extra_backIcon.click();
                    waitForVisibility(MyExtraAllowancesElements().get(k));
                    scrollDownTo(MyExtraAllowancesElements().get(k));
                }
            }
        }
    }
}
