package pages.SubsctionOverlay.ExtrasTab;

import models.response.ExtrasResponseModel;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ExtrasUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readEnv;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.ActionsHelpers.tapAtt;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class ExtrasTabIOS extends ExtrasTabAbstract{

    public ExtrasTabIOS(){
        super();
    }

    ExtrasResponseModel extrasResponseModel;
    static Properties envProp = readPropertyFile("config/env.properties");
    Boolean live = System.getProperty("isLiveTest", readEnv("isLiveTest")).equalsIgnoreCase("true");
    public void checkExtraBarsCapsCard(){
        if(live)
        {
            AssertDisplayed(SO_ExtrasTab.isDisplayed());
        }
        else{
        extrasResponseModel = ExtrasUtils.getExtras();
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("Active controls, limits and extras")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(extrasResponseModel.cards.get(i).list.get(k).title);
                    WebElement element = getElementByText((extrasResponseModel.cards.get(i).list.get(k).title));
                    AssertDisplayed(element.isDisplayed());
                }}
            }
        }
    }

    public void checkExtraAllowancesCard(){
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("My extra allowances")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(extrasResponseModel.cards.get(i).list.get(k).title);
                    WebElement element = getElementByText(extrasResponseModel.cards.get(i).list.get(k).title);
                    AssertDisplayed(element.isDisplayed());
                    WebElement element2 = getElementByText(extrasResponseModel.cards.get(i).list.get(k).text);
                    AssertDisplayed(element2.isDisplayed());
                }
            }
        }
    }

    public void checkManageBarsExtrasCTA(){
        scrollDownTo(Extras_BuyManageExtrasCTA);
        Extras_BuyManageExtrasCTA.click();
       /* scrollDownTo(Extras_BuyManageExtrasCTA);
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).displayType.contains("EXTRAS_ACTION_CARD")){
                scrollDownTo(Extras_BuyManageExtrasCTA);
                Assert.assertEquals(extrasResponseModel.cards.get(i).actions.get(0).text,Extras_BuyManageExtrasCTA.getText());
                Extras_BuyManageExtrasCTA.click();
            }
        }*/
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
        SwipeToElement(SO_ExtrasTab, "Left");
        SO_ExtrasTab.click();
        waitForVisibility(Extras_TabContainer);
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


    public void checkExtraAllowancesCTADetails(){
        for(int i = 0; i<extrasResponseModel.cards.size();i++) {
            if (extrasResponseModel.cards.get(i).title != null && extrasResponseModel.cards.get(i).title.contains("My extra allowances")){
                for(int k=0; k<extrasResponseModel.cards.get(i).list.size();k++){
                    scrollDownTo(extrasResponseModel.cards.get(i).list.get(k).title);
                    WebElement element = getElementByText(extrasResponseModel.cards.get(i).list.get(k).title);
                    tapAtt(element.getRect().x,element.getRect().y);
                    waitForVisibility(Extras_MyExtrasAllowancesTitle);
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentTitleAlignedLeft.
                                    replace("<b>","").replace("</b>",""),
                            Extras_MyExtrasAllowancesTitle.getText());
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentText.replaceAll("\n","").replaceAll(" ",""),
                            Extras_MyExtrasAllowancesDescription.getText().replaceAll("\n","").replaceAll(" ",""));
                    Assert.assertEquals(extrasResponseModel.cards.get(i).list.get(k).subContent.subContentButton.text,
                            Extra_detailsCTA.getText());
                    Extra_backIcon.click();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    scrollDownTo(extrasResponseModel.cards.get(i).list.get(k).title);
                }
            }
        }
    }
}
