package pages.RedHybrid.UsageCard;

import models.response.UsagesResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.UsageUtils;
import static utils.element_helpers.ActionsHelpers.*;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.*;
import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.TextHelpers.*;
import static utils.element_helpers.GenericHelpers.*;


public class RedHybrid_UsageCardLogic_Android extends RedHybrid_UsageCard_Abstract {

    public RedHybrid_UsageCardLogic_Android() {
        super();
    }
    UsagesResponseModel usagesResponseModel;

    @Override
    public void addPaymentMethodOverlayDismiss() {
            try {
                waitForVisibility(returnToMyVodafoneCTA);
                returnToMyVodafoneCTA.click();
            }

            catch(Exception e){
                System.out.println("Add Payment Method overlay not appeared");

        }
    }


    @Override
    public void navigateToSubsOverLay() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        //HideVOV(DB_VOVhideCTA);
        waitForVisibility(DBControlTile);
        //scrollDownTo(DBControlTile);
        DBControlTile.click();
        waitForVisibility(SO_ExtrasTab);
        //subscriptionOverlayLogic.navigateToSubsOverLay();
        //*****
    }

    @Override
    public void navigateToUsage() {
        SO_UsageTab.click();

    }

    @Override
    public void validateRHUsageCardUI() {
        waitForVisibility(SO_UsageTabContainer);
        AssertDisplayed(SO_UsageTabContainer.isDisplayed());
        waitForVisibility(SO_UsageTabRHExpiryOrRenewalDate);
        AssertDisplayed(SO_UsageTabRHExpiryOrRenewalDate.isDisplayed());
    }

    @Override
    public void usageAPIDataMappingValidation() {

        try {
            usagesResponseModel = UsageUtils.getUsagesV2();
        } catch (Exception e) {
            System.out.println("MVAX API v3/usage has not been called");
        }
        String actualExpiryOrRenewalDate = usagesResponseModel.cards.get(0).sections.get(0).header;
        String expectedExpiryOrRenewalDate = SO_UsageTabRHExpiryOrRenewalDate.getAttribute("text");
        String actualTitle = usagesResponseModel.cards.get(0).title;
        String title = SO_UsageTabRHTitle.getAttribute("text");
        String expectedTitle = "<b>" + title + "</b>";
        Assert.assertEquals(expectedExpiryOrRenewalDate, actualExpiryOrRenewalDate);
        Assert.assertEquals(expectedTitle, actualTitle);
        int allowancesNO = SO_UsageTabRHAllowances.findElements(By.className("android.view.ViewGroup")).size();
        //get the size of the list returned from the recyclerView
        int i = 0;
        while (i < allowancesNO) {
            WebElement allowance = SO_UsageTabRHAllowances.findElements(By.className("android.view.ViewGroup")).get(i);
            //get the element no. i in the allowances
            String expectedQuantity = allowance.findElement(By.id("com.myvodafoneapp:id/quantityTextView")).getText();
            // get the expected value of quantity from the webElement as a string
            String quantity = usagesResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantity;
            String remainingUnit = usagesResponseModel.cards.get(0).sections.get(0).allowances.get(i).remainingUnit;
            String quantitySuffix = usagesResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantitySuffix;
            // from the response of the v3/usage MVAX API get the quantity, remainingUnit and quantitySuffix

            if (remainingUnit == null) {
                actualQuantity = quantity + " " + quantitySuffix;
            } else {
                actualQuantity = quantity + " " + remainingUnit + " " + quantitySuffix;
            }


            // concatenate the values returned from the response in actualQuantity string
            Assert.assertEquals(expectedQuantity, actualQuantity);
            // assert on the expected and actual values
            i++;
            // to take the second element in the allowances
        }

    }

    @Override
    public void ValidateContentOfActiveExtrasCard() {
        waitForVisibility(SO_UsageTabContainer);
        RH_ActiveExtrasCardTitle.isDisplayed();

       for (int Extra = 0; Extra< usagesResponseModel.cards.get(1).sections.size(); Extra++){
            scrollDownTo(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText);
            //to check the Title of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesResponseModel.cards.get(1).sections.get(Extra).header))).getText(), usagesResponseModel.cards.get(1).sections.get(Extra).header);
           //to check the Sub-Title of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).header))).getText(), usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).header);
           //to check the Expiry date of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText))).getText(), usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText);
            RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText))).isDisplayed();
        }

    }

    @Override
    public void ValidateThatAddExtrasCTAIsRemoved() {
        waitForVisibility(SO_UsageTabContainer);
        assertEquals(usagesResponseModel.buttons, null);

    }



    //to check whether the quantitySuffix contains Used or Remaining based on limitation type
    @Override
    public void CheckQuantitySuffixWord(){
        for (int Extra = 0; Extra< usagesResponseModel.cards.get(1).sections.size(); Extra++){
            if(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).unlimited){
                assertEquals(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).quantitySuffix.equalsIgnoreCase("used"),true);
            }else {
                assertEquals(usagesResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).quantitySuffix.equalsIgnoreCase("left"), true);
            }
        }

        for (int bundle = 0; bundle< usagesResponseModel.cards.get(0).sections.size(); bundle++){
            if(usagesResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).unlimited){
                assertEquals(usagesResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).quantitySuffix.equalsIgnoreCase("used"), true);
            }else {
                assertEquals(usagesResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).quantitySuffix.equalsIgnoreCase("left"), true);
            }
        }

    }
}