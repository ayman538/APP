package pages.SubsctionOverlay.ChargesTab;

import models.response.AdditionalChargesDetailsModel;
import models.response.AdditionalChargesResponseModel;
import models.response.ChargesResponseModel;
import models.response.DiscoverV2ResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PropertiesLoader;
import utils.AdditionalChargesDetailsUtils;
import utils.AdditionalChargesUtils;
import utils.ChargesUtils;

import java.math.BigDecimal;
import java.util.List;

import static utils.element_helpers.GenericHelpers.removeDollarSign;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ChargesTabIOS extends ChargesTabAbstract{

    public String monthlyChargesValue, additionalChargesValue, totalEstimatedChargesValue = null;
    static ChargesResponseModel chargesResponseModel ;
    static AdditionalChargesResponseModel additionalChargesResponseModel;
    static AdditionalChargesDetailsModel additionalChargesDetailsResponseModel;
    static Double quantityValueAPI;
    static Double MonthlyquantityValueAPI;
    static Double TotalquantityValueAPI;

    public ChargesTabIOS() {
        super();
    }

    public List<WebElement> AdditionalChargesItimes(){
        return (List<WebElement>) driver.findElements(By.xpath("//*[@name='Additional charges']/following::*[@type='XCUIElementTypeCell']"));
    }

    @Override
    public void setBeforeClass() {
        if (System.getProperty("isLiveTest", PropertiesLoader.readEnv("isLiveTest")).equalsIgnoreCase("true")) {
            billingTileHeaderCTA();
        }else {
            chargesResponseModel = ChargesUtils.GetCharges();
            additionalChargesResponseModel = AdditionalChargesUtils.getAdditionalCharges();
            additionalChargesDetailsResponseModel = AdditionalChargesDetailsUtils.getAdditionalChargesDetails();
            quantityValueAPI = chargesResponseModel.additionalChargesCard.header.quantityValue;
            MonthlyquantityValueAPI = chargesResponseModel.bundleCard.header.quantityValue;
            TotalquantityValueAPI = chargesResponseModel.totalChargesCard.header.quantityValue;
            billingTileHeaderCTA();
        }
    }
    @Override
    public void noAdditionalCard() {
        System.out.println("additionalChargesQuantity:" + additionalChargesQuantity.getText());
        AssertResult(additionalChargesQuantity.getText(), "£0.00");
        AssertResult(quantityValueAPI.toString(),"0.0");
        AssertResult(chargesResponseModel.additionalChargesCard.header.quantity.substring(3,8),additionalChargesQuantity.getText());
    }
    @Override
    public void billingTileHeaderCTA() {
        waitForVisibility(DB_billingTileHeader);
        DB_billingTileHeader.click();
        waitForVisibility(additionalChargesQuantity);
    }

    @Override
    public void validateAllowanceChargesDisplayed() {
        additionalChargesChevronCTA();
        assertAdditionalChargesHeaderDisplayed();
    }

    @Override
    public void assertAdditionalChargesHeaderDisplayed() {
        System.out.println("Additional Charges Displayed");
        for(int i=0; i<additionalChargesResponseModel.list.size();i++){
            switch (additionalChargesResponseModel.list.get(i).text) {
                case "Calls":
                    AssertResult(additionalChargesResponseModel.list.get(i).text, Calls.getText());
                    System.out.println(additionalChargesResponseModel.list.get(i).text);
                    System.out.println(Calls.getText());
                    break;
                case "Texts":
                    AssertResult(additionalChargesResponseModel.list.get(i).text, Texts.getText());
                    System.out.println(additionalChargesResponseModel.list.get(i).text);
                    System.out.println(Texts.getText());
                    break;
                case "Data":
                    AssertResult(additionalChargesResponseModel.list.get(i).text, Data.getText());
                    System.out.println(additionalChargesResponseModel.list.get(i).text);
                    System.out.println(Data.getText());
                    break;
                case "Other":
                    AssertResult(additionalChargesResponseModel.list.get(i).text, Other.getText());
                    System.out.println(additionalChargesResponseModel.list.get(i).text);
                    System.out.println(Other.getText());
                    break;
            }
        }
        System.out.println(quantityValueAPI.toString());
        System.out.println(additionalChargesQuantity.getText().replace("£",""));
        assertEquals(true,additionalChargesQuantity.getText().contains(quantityValueAPI.toString()));

    }

    @Override
    public void additionalChargesChevronCTA() {
        waitForVisibility(additionalChargesChevron);
        additionalChargesChevron.click();
    }

    @Override
    public void ItemizedJourney(){
        additionalChargesChevronCTA();
        detailsChevronCTA();
        assertLoginTitleDisplayed();
    }

    @Override
    public void assertLoginTitleDisplayed() {
        try{
            waitForVisibility(AcceptCookies);
            AssertDisplayed(AcceptCookies.isDisplayed());
        }catch (Exception e){
            waitForVisibility(LoginTitle);
            AssertDisplayed(LoginTitle.isDisplayed());
        }
    }

    @Override
    public void detailsChevronCTA() {
        waitForVisibility(additionalChargesNavigationChevron);
        additionalChargesNavigationChevron.click();
    }

    @Override
    public void assertDetailChevronText() {
        waitForVisibility(detailsChevronInItemizedView);
        detailsChevronInItemizedView.click();
        //waitForVisibility(additionalFirstFilter);
        System.out.println(additionalFirstFilter.getText());
        System.out.println(additionalChargesDetailsResponseModel.sortingDropDown.get(0).displayText);
        AssertResult(additionalFirstFilter.getText(), "Newest first");
        AssertResult(additionalFirstFilter.getText(),additionalChargesDetailsResponseModel.sortingDropDown.get(0).displayText);
        waitForVisibility(additionalSecondFilter);
        System.out.println(additionalSecondFilter.getText());
        System.out.println(additionalChargesDetailsResponseModel.sortingDropDown.get(1).displayText);
        AssertResult(additionalSecondFilter.getText(), "Oldest first");
        AssertResult(additionalSecondFilter.getText(),additionalChargesDetailsResponseModel.sortingDropDown.get(1).displayText);
        waitForVisibility(additionalThirdFilter);
        System.out.println(additionalThirdFilter.getText());
        System.out.println(additionalChargesDetailsResponseModel.sortingDropDown.get(2).displayText);
        AssertResult(additionalThirdFilter.getText(), "Highest price first");
        AssertResult(additionalThirdFilter.getText(),additionalChargesDetailsResponseModel.sortingDropDown.get(2).displayText);
        waitForVisibility(additionalFourthFilter);
        System.out.println(additionalFourthFilter.getText());
        System.out.println(additionalChargesDetailsResponseModel.sortingDropDown.get(3).displayText);
        AssertResult(additionalFourthFilter.getText(), "Lowest price first");
        AssertResult(additionalFourthFilter.getText(),additionalChargesDetailsResponseModel.sortingDropDown.get(3).displayText);
    }

    @Override
    public void unBilledChargesListMoreThanSix() {
        waitForVisibility(additionalChargesLoadMoreCTA);
        scrollDownTo(additionalChargesLoadMoreCTA);
        additionalChargesLoadMoreCTA.click();
    }

    @Override
    public void validateTotalEstimatedCharges() {
        monthlyChargesValue = removeDollarSign(monthlyChargesQuantity.getText());
        additionalChargesValue = removeDollarSign(additionalChargesQuantity.getText());
        BigDecimal result = new BigDecimal(monthlyChargesValue).add(new BigDecimal(additionalChargesValue));
        totalEstimatedChargesValue = removeDollarSign(totalEstimatedChargesQuantity.getText());
        AssertResult(totalEstimatedChargesValue, result.toString());
        System.out.println(totalEstimatedChargesValue);
        System.out.println(result);
        System.out.println(monthlyChargesQuantity.getText());
        System.out.println(chargesResponseModel.bundleCard.header.quantity);
        //AssertResult(monthlyChargesQuantity.getText().replace("£",""),MonthlyquantityValueAPI.toString());
        System.out.println(totalEstimatedChargesQuantity.getText());
        System.out.println(chargesResponseModel.totalChargesCard.header.quantity);
        assertEquals(true,totalEstimatedChargesQuantity.getText().contains(TotalquantityValueAPI.toString()));
    }

    @Override
    public void chargesSSOJourney() {
        scrollDownTo(chargesViewDetails);
        chargesViewDetails.click();
        waitForVisibility(LoginTitle);
        AssertDisplayed(LoginTitle.isDisplayed());
        loginCloseIcon.click();
    }

    @Override
    public void ClickOnViewDetailsCTA() {
        scrollDownTo(chargesViewDetails);
        chargesViewDetails.click();
        //waitForVisibility(LoginTitle);
    }

    @Override
    public void validateMonthlyCharges() {
        AssertDisplayed(monthlyChargesTile.isDisplayed());
        Assert.assertTrue(chargesResponseModel.bundleCard.header.quantity.contains(monthlyChargesQuantity.getText()));
        Assert.assertTrue(chargesResponseModel.bundleCard.header.subTitle.contains(monthlyChargesSubtile.getText()));
        if (chargesResponseModel.bundleCard.header.hasChargesBreakdown){
            monthlyChargesChevron.click();
            Assert.assertTrue(chargesResponseModel.bundleCard.body.get(0).title.contains(monthlyChargesPlan.getText()));
        }

    }

    @Override
    public void navigateToChargesOverlay() {
        chargesResponseModel = ChargesUtils.GetCharges();
        additionalChargesResponseModel = AdditionalChargesUtils.getAdditionalCharges();
        additionalChargesDetailsResponseModel = AdditionalChargesDetailsUtils.getAdditionalChargesDetails();
        quantityValueAPI = chargesResponseModel.additionalChargesCard.header.quantityValue;
        MonthlyquantityValueAPI = chargesResponseModel.bundleCard.header.quantityValue;
        TotalquantityValueAPI = chargesResponseModel.totalChargesCard.header.quantityValue;

        AssertDisplayed(monthlyChargesTile.isDisplayed());
        Assert.assertTrue(chargesResponseModel.bundleCard.header.quantity.contains(monthlyChargesQuantity.getText()));
        Assert.assertTrue(chargesResponseModel.bundleCard.header.subTitle.contains(monthlyChargesSubtile.getText()));
        if (chargesResponseModel.bundleCard.header.hasChargesBreakdown){
            monthlyChargesChevron.click();
            Assert.assertTrue(chargesResponseModel.bundleCard.body.get(0).title.contains(monthlyChargesPlan.getText()));
        }

    }

}
