package pages.ClickToUpgrade.NewPlanSpendManager;

import models.response.SelectedUpgradePlanResponseModel;
import utils.SelectedUpgradePlanUtils;

import java.util.Properties;

import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;

public class NewPlanSpendManagerAndroid extends NewPlanSpendManagerAbstract {
    SelectedUpgradePlanResponseModel selectedUpgradePlan;
    Properties envProp = readPropertyFile("config/env.properties");

    public NewPlanSpendManagerAndroid() {
        super();
        if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")) {
            selectedUpgradePlan = SelectedUpgradePlanUtils.getSelectedUpgradePlan();
        }
    }


    @Override
    public void VerifyTheTitle() {
        AssertResult(C2U_spendManagerHeader.getText(), selectedUpgradePlan.spendManager.header);
    }


    @Override
    public void VerifyTheDescriptiveTextExist() {
        C2U_spendManagerText.isDisplayed();
    }


    @Override
    public void VerifyThePriceLabelIsCorrect() {
        AssertResult(C2U_spendManagerNewPlanPriceLabel.getText(), selectedUpgradePlan.spendManager.newPlanPriceLabel);
    }

    @Override
    public void VerifyThePlanPriceExist() {
        C2U_spendManagerNewPlanPrice.isDisplayed();
    }


    @Override
    public void VerifyThePlanPriceCyclePerMonth() {
        AssertResult(C2U_spendManagerNewPlanPriceCycle.getText(), selectedUpgradePlan.spendManager.newPlanPriceCycle);
    }

    @Override
    public void VerifyTheSpendLimitLabelExist() {
        AssertResult(C2U_spendManagerSpendLimitsLabel.getText(), selectedUpgradePlan.spendManager.spendLimitsLabel);
    }

    @Override
    public void ValidateTheDefaultValueForSpendLimitMenu() {
        System.out.println(C2U_spendManagerSpendLimitsMenu.getText());
        AssertResult(C2U_spendManagerSpendLimitsMenu.getText(), selectedUpgradePlan.spendManager.spendLimits.get(0));
    }

    @Override
    public void VerifyTheGreenBoxAppearsWithCheckmarkAfterSelectingTheValue() {
        C2U_spendManagerSpendLimitsMenu.click();
        C2U_spendManagerSpendLimitsMenuUnlimitedOption.click();
        C2U_spendManagerPostSelectionMsg.isDisplayed();
    }

    @Override
    public void scrollToSpendManager() {
        scrollToElement(newPlanTermAndCondContinueBtn,10);
    }

}
