package pages.RedHybrid.UsageCard;

import models.response.UsagesResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.UsageUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.assertEquals;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_UsageCardLogic_IOS extends RedHybrid_UsageCard_Abstract {

    public RedHybrid_UsageCardLogic_IOS() {
        super();
    }
    UsagesResponseModel usagesV2ResponseModel;

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
        waitForVisibility(DBControlTile);
        scrollDownTo(DBControlTile);
        DBControlTile.click();
        waitForVisibility(SO_MSISDN);
    }

    @Override
    public void navigateToUsage() {
        SO_UsageTab.click();
    }

    @Override
    public void validateRHUsageCardUI() {
        usagesV2ResponseModel = UsageUtils.getUsagesV2();
        waitForVisibility(SO_UsageTabContainer);
        AssertDisplayed(SO_UsageTabContainer.isDisplayed());
        waitForVisibility(SO_UsageTabRHExpiryOrRenewalDate.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(0).sections.get(0).header))));
        AssertDisplayed(SO_UsageTabRHExpiryOrRenewalDate.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(0).sections.get(0).header))).isDisplayed());
    }

    @Override
    public void usageAPIDataMappingValidation() {
        try {
            usagesV2ResponseModel = UsageUtils.getUsagesV2();
        } catch (Exception e) {
            System.out.println("MVAX API v3/usage has not been called");
        }
        String actualExpiryOrRenewalDate = usagesV2ResponseModel.cards.get(0).sections.get(0).header;
        String expectedExpiryOrRenewalDate = SO_UsageTabRHExpiryOrRenewalDate.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(0).sections.get(0).header))).getText();
        String actualTitle = usagesV2ResponseModel.cards.get(0).title;
        String titleAPI = usagesV2ResponseModel.cards.get(0).title.replace("</b>","").replace("<b>","");
        String title = SO_UsageTabRHTitle.findElement(By.xpath(GetXpath(titleAPI))).getText();
        String expectedTitle = "<b>" + title + "</b>";
        Assert.assertEquals(expectedExpiryOrRenewalDate, actualExpiryOrRenewalDate);
        Assert.assertEquals(expectedTitle, actualTitle);
        int allowancesNO = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.size();
        //get the size of the list returned from the recyclerView
        int i = 0;
        while (i < allowancesNO) {
            WebElement allowance = SO_UsageTabRHAllowances.findElements(By.className("android.view.ViewGroup")).get(i);
            //get the element no. i in the allowances

            String quantity = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantity;
            String remainingUnit = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).remainingUnit;
            String quantitySuffix = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantitySuffix;
            // from the response of the v3/usage MVAX API get the quantity, remainingUnit and quantitySuffix

            String usedQuantity;
            if(remainingUnit == null){
                usedQuantity = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantity + " ";
            }else {
                usedQuantity = usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantity + " " + usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).remainingUnit;
            }
            String expectedUsedQuantity = allowance.findElement(By.xpath(GetXpath(usedQuantity))).getText();
            String expectedQuantity = allowance.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(0).sections.get(0).allowances.get(i).quantitySuffix))).getText();
            // get the expected value of quantity from the webElement as a string


            if (remainingUnit == null) {
                actualQuantity = quantity + " " + quantitySuffix;
                expectedQuantity = quantity + " " + expectedQuantity;
            } else {
                actualQuantity = quantity + " " + remainingUnit + " " + quantitySuffix;
                expectedQuantity = expectedUsedQuantity + " " + expectedQuantity;
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

        for (int Extra = 0; Extra< usagesV2ResponseModel.cards.get(1).sections.size(); Extra++){
            scrollDownTo(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText);
            //to check the Title of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(1).sections.get(Extra).header))).getText(), usagesV2ResponseModel.cards.get(1).sections.get(Extra).header);
            //to check the Sub-Title of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).header))).getText(), usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).header);
            //to check the Expiry date of extra
            assertEquals(RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText))).getText(), usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText);
            RH_ActiveExtras.findElement(By.xpath(GetXpath(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).riderText))).isDisplayed();
        }

    }

    @Override
    public void ValidateThatAddExtrasCTAIsRemoved() {
        waitForVisibility(SO_UsageTabContainer);
        assertEquals(usagesV2ResponseModel.buttons, null);
    }



    //to check whether the quantitySuffix contains Used or Remaining based on limitation type
    @Override
    public void CheckQuantitySuffixWord(){
        for (int Extra = 0; Extra< usagesV2ResponseModel.cards.get(1).sections.size(); Extra++){
            if(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).unlimited){
                assertEquals(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).quantitySuffix.equalsIgnoreCase("used"),true);
            }else {
                assertEquals(usagesV2ResponseModel.cards.get(1).sections.get(Extra).allowances.get(0).quantitySuffix.equalsIgnoreCase("left"), true);
            }
        }

        for (int bundle = 0; bundle< usagesV2ResponseModel.cards.get(0).sections.size(); bundle++){
            if(usagesV2ResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).unlimited){
                assertEquals(usagesV2ResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).quantitySuffix.equalsIgnoreCase("used"), true);
            }else {
                assertEquals(usagesV2ResponseModel.cards.get(0).sections.get(bundle).allowances.get(0).quantitySuffix.equalsIgnoreCase("left"), true);
            }
        }

    }


}

