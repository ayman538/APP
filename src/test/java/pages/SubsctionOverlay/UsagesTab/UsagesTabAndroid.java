package pages.SubsctionOverlay.UsagesTab;

import models.response.NativeExtrasResponseModel;
import models.response.UsagesResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.NativeExtrasUtils;
import utils.SegmentUtils;
import utils.UsageUtils;

import java.util.List;

import static utils.element_helpers.GenericHelpers.clickOnRetryButton;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class UsagesTabAndroid extends UsagesTabAbstract {

    public UsagesTabAndroid() {
        super();
    }

    UsagesResponseModel usagesResponseModel = UsageUtils.getUsagesV2();
    NativeExtrasResponseModel NativeExtrasResponseModel = NativeExtrasUtils.getExtras();

    //  CROUsageResponseModel CROusagesResponseModel = UsageUtils.getCROUsagesV2();


    String segment = SegmentUtils.GetSegment_Type();

    public boolean Roaming = false;
    public boolean Data = false;
    public boolean Calling = false;

    public List<WebElement> UsageTabPlanCardElementsRenwalDate() {
        String text = "";
        if (segment.equals("CONSUMER")) {
            scrollDownTo(US_PlanCardTitlePAYM);
            text = "Plan";
        } else if (segment.equals("PREPAY")) {
            scrollDownTo(US_PlanCardTitleBVB);
            text = "Big value bundle";
        }
        return driver.findElements(By.xpath("//*[@text='" + text + "' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']/parent::*/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/headerTextView' and @index='0']"));
    }

    public List<WebElement> UsageTabPlanCardElementsAllowanceType() {
        String text = "";
        if (segment.equals("CONSUMER")) {
            scrollDownTo(US_PlanCardTitlePAYM);
            text = "Plan";
        } else if (segment.equals("PREPAY")) {
            scrollDownTo(US_PlanCardTitleBVB);
            text = "Big value bundle";
        }
        return driver.findElements(By.xpath("//*[@text='" + text + "' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']/parent::*/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/headerTextView' and @index='1']"));
    }

    public List<WebElement> UsageTabPlanCardElementsUsedAmount() {
        String text = "";
        if (segment.equals("CONSUMER")) {
            scrollDownTo(US_PlanCardTitlePAYM);
            text = "Plan";
        } else if (segment.equals("PREPAY")) {
            scrollDownTo(US_PlanCardTitleBVB);
            text = "Big value bundle";
        }
        return driver.findElements(By.xpath("//*[@text='" + text + "' and @resource-id='com.myvodafoneapp:id/txtPlanListItemTitle']/parent::*/parent::*//android.widget.TextView[@resource-id='com.myvodafoneapp:id/quantityTextView']"));
    }

    public void navigateToUsages() {
        waitForVisibility(SO_UsageTab);
        SO_UsageTab.click();
        clickOnRetryButton();
        waitForVisibility(SO_UsageTabContainer);
    }

    public void checkPlanCardinUsage() {
        waitForVisibility(SO_UsageTabContainer);
        for (int i = 0; i < usagesResponseModel.cards.size(); i++) {
            if (usagesResponseModel.cards.get(i).title.equals("Plan")) {
                AssertResult(US_PlanCardTitlePAYM.getText(),
                        usagesResponseModel.cards.get(i).title);
                for (int k = 0; k < usagesResponseModel.cards.get(i).sections.size(); k++) {
                    AssertResult(UsageTabPlanCardElementsRenwalDate().get(k).getText(),
                            usagesResponseModel.cards.get(i).sections.get(k).header);
                    for (int j = 0; j < usagesResponseModel.cards.get(i).sections.get(k).allowances.size(); j++) {
                        if (!usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).unlimited) {
                            AssertResult(UsageTabPlanCardElementsAllowanceType().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header);
                            AssertResult(UsageTabPlanCardElementsUsedAmount().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).remainingUnit +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix);
                        } else {
                            AssertResult(UsageTabPlanCardElementsAllowanceType().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header);
                            AssertResult(UsageTabPlanCardElementsUsedAmount().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix);
                        }
                    }
                }
            } else if (usagesResponseModel.cards.get(i).title.equals("Big value bundle")) {
                AssertResult(US_PlanCardTitleBVB.getText(),
                        usagesResponseModel.cards.get(i).title);
                for (int k = 0; k < usagesResponseModel.cards.get(i).sections.size(); k++) {
                    AssertResult(UsageTabPlanCardElementsRenwalDate().get(k).getText(),
                            usagesResponseModel.cards.get(i).sections.get(k).header);
                    for (int j = 0; j < usagesResponseModel.cards.get(i).sections.get(k).allowances.size(); j++) {
                        if (!usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).unlimited) {
                            AssertResult(UsageTabPlanCardElementsAllowanceType().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header);
                            AssertResult(UsageTabPlanCardElementsUsedAmount().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).remainingUnit +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix);
                        } else {
                            AssertResult(UsageTabPlanCardElementsAllowanceType().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header);
                            AssertResult(UsageTabPlanCardElementsUsedAmount().get(j).getText(),
                                    usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity +
                                            " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix);
                        }
                    }
                }
            }
        }
    }

    public void checkViewPlanCTAinUsageTab() {
        scrollDownTo(US_ViewPlanCTA);
        for (int i = 0; i < usagesResponseModel.cards.size(); i++) {
            if (usagesResponseModel.cards.get(i).title.equals("Plan")) {
                AssertResult(US_ViewPlanCTA.getText(), usagesResponseModel.cards.get(i).buttons.get(0).text);
            }
        }
        US_ViewPlanCTA.click();
        waitForVisibility(Plan_TabContent);
        AssertDisplayed(Plan_TabContent.isDisplayed());
    }

    public void checkAddExtraCTAinUsageTab() {
        scrollDownTo(US_addExtraCTA);
        for (int i = 0; i < usagesResponseModel.buttons.size(); i++) {
            if (usagesResponseModel.buttons.get(i).text.equals("Add extras")) {
                US_addExtraCTA.click();
                waitForVisibility(Extras_TabContainer);
                AssertDisplayed(Extras_TabContainer.isDisplayed());
            }
        }
    }
    @Override
   public void checkCroExperience() {
        try {
            scrollDownTo(US_addExtraCTA);
            //if( CROusagesResponseModel.extras.title=="carousel"){
            System.out.println(US_ExtrasHeader.getText());
            AssertDisplayed(US_ExtrasHeader.isDisplayed());

            //}
        } catch (Exception e) {
            System.out.println("error " + e);
            AssertDisplayed(US_addExtraCTA.isDisplayed());
        }

    }

    @Override
    public void validateExperienceFunctionality() {
//        //2 variants experience
//
//        //carousel experience
//               scrollDownTo(US_addExtraCTA);
//               waitForVisibility(US_ExtrasHeader);
//               Assert.assertEquals("Our cost effective Extras",US_ExtrasHeader.getText());
//
//               System.out.println("card 1");
//
//        US_CarouselTitle1.click();
//        System.out.println("1 card");
//        waitForVisibility(BuyDataOption);
//        AssertDisplayed(BuyDataOption.isDisplayed());
//        XiConExtras.click();
//        waitForVisibility(US_CarouselTitle1);
//        SwipeToElement(US_CarouselTitle1, "Left");
//        US_CarouselTitle2.click();
//
//        System.out.println("2 card");
//        waitForVisibility(BuyCallsOption);
//        AssertDisplayed(BuyCallsOption.isDisplayed());
//        XiConExtras.click();
//        waitForVisibility(US_CarouselTitle2);
//        SwipeToElement(US_CarouselTitle2, "Right");
//        SwipeToElement(US_CarouselTitle2, "Left");
//
//        US_CarouselTitle3.click();
//        System.out.println("3 card");
//        waitForVisibility(BuyRoamingOption);
//        AssertDisplayed(BuyRoamingOption.isDisplayed());
//        XiConExtras.click();
//
//       /* for (int i = 0; i < 3; i++) {
//            System.out.println("item " + i);
//            US_ListTitle.get(i).click();
//            waitForVisibility(shopExtrasCard);
//            AssertDisplayed(shopExtrasCard.isDisplayed());
//            navigateToUsages();
//        }
//        */
////tile list experience

        AssertDisplayed(US_FirstTile.isDisplayed());
        Assert.assertEquals("Data add-ons",US_FirstTile.getText());
        US_FirstTile.click();
        AssertDisplayed(BuyDataOption.isDisplayed());
        XiConExtras.click();

        AssertDisplayed(US_SecondTile.isDisplayed());
        Assert.assertEquals("Call abroad - 75 minutes",US_SecondTile.getText());
        US_SecondTile.click();
        AssertDisplayed(BuyCallsOption.isDisplayed());
        XiConExtras.click();

         AssertDisplayed(US_ThirdTile.isDisplayed());
        Assert.assertEquals("Travelling abroad",US_ThirdTile.getText());
        US_ThirdTile.click();
        AssertDisplayed(BuyRoamingOption.isDisplayed());
        XiConExtras.click();
    }
    @Override
    public void ValidateExtrasCTA() {
        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_addExtraCTA);
        AssertResult(US_addExtraCTA.getText(),"See more available Extras");
    }

    @Override
    public void clickOnDataTile() {
        waitForVisibility(DB_data);
        DB_data.click();
    }

    @Override
    public void validateUsageTabIsOpened() {
        waitForVisibility(SO_UsageTab);
        //AssertDisplayed(shopExtrasCard.isDisplayed());
    }

    @Override
    public void validateManageExtrasCapsAndBarsCTAExistence() {
        scrollDownTo(US_manageExtrasCapsBarsCTA);
        assertElementDoesNotExist(US_manageExtrasCapsBarsCTA);
    }
    @Override
    public void validateSMBTilesNavigation(){
        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_ExtrasHeader);
        Assert.assertEquals("Our cost effective Extras",US_ExtrasHeader.getText());

        AssertDisplayed(US_FirstTile.isDisplayed());
        Assert.assertEquals("Data add-ons",US_FirstTile.getText());
        US_FirstTile.click();
        waitForVisibility(SO_ExtrasTab);
        AssertDisplayed(SO_ExtrasTab.isDisplayed());
        SO_UsageTab.click();

        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_SecondTile);
        Assert.assertEquals("Call abroad - 75 minutes",US_SecondTile.getText());
        US_SecondTile.click();
        waitForVisibility(SO_ExtrasTab);
        AssertDisplayed(SO_ExtrasTab.isDisplayed());
        SO_UsageTab.click();

        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_ThirdTile);
        Assert.assertEquals("Travelling abroad",US_ThirdTile.getText());
        US_ThirdTile.click();
        waitForVisibility(SO_ExtrasTab);
        AssertDisplayed(SO_ExtrasTab.isDisplayed());
        SO_UsageTab.click();
        waitForVisibility(US_addExtraCTA);
        US_addExtraCTA.click();
        waitForVisibility(SO_ExtrasTab);
        AssertDisplayed(SO_ExtrasTab.isDisplayed());
    }

    @Override
    public void iShouldSeeTilesTitle() {
        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_ExtrasHeader);
        Assert.assertEquals("Our cost effective Extras",US_ExtrasHeader.getText());
    }

    @Override
    public void iShouldSeeTheTileListAndValidateTheirFunctionality() {
        System.out.println(NativeExtrasResponseModel.status.analytics.guid);
        int ExtrasNo = NativeExtrasResponseModel.shopCategories.serviceGroups.size();
        System.out.println("ExtrasNO"+ ExtrasNo);
        for (int i = 0; i < ExtrasNo; i++) {
            if (NativeExtrasResponseModel.shopCategories.serviceGroups.get(i).name.equals("Roaming")) {
                Roaming = true;
                System.out.println("Roaming");
            } else if (NativeExtrasResponseModel.shopCategories.serviceGroups.get(i).name.equals("Calling")) {
                Calling = true;
                System.out.println("Calling");
            } else if (NativeExtrasResponseModel.shopCategories.serviceGroups.get(i).name.equals("Data")) {
                Data = true;
                System.out.println("Data");
            }
        }


        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_ExtrasHeader);

        if(Data){
            AssertDisplayed(US_FirstTile.isDisplayed());
            Assert.assertEquals("Data add-ons", US_FirstTile.getText());
            US_FirstTile.click();
            AssertDisplayed(BuyDataOption.isDisplayed());
            XiConExtras.click();
            AssertDisplayed(US_FirstTile.isDisplayed());
            Assert.assertEquals("Data add-ons",US_FirstTile.getText());
            US_FirstTile.click();
            AssertDisplayed(BuyDataOption.isDisplayed());
            XiConExtras.click();
        }

        else if(Calling) {
            AssertDisplayed(US_SecondTile.isDisplayed());
            Assert.assertEquals("Call abroad - 75 minutes", US_SecondTile.getText());
            US_SecondTile.click();
            AssertDisplayed(BuyCallsOption.isDisplayed());
            XiConExtras.click();
            AssertDisplayed(US_SecondTile.isDisplayed());
            Assert.assertEquals("Call abroad - 75 minutes",US_SecondTile.getText());
            US_SecondTile.click();
            AssertDisplayed(BuyCallsOption.isDisplayed());
            XiConExtras.click();
        }

        else if(Roaming){
        AssertDisplayed(US_ThirdTile.isDisplayed());
        Assert.assertEquals("Travelling abroad",US_ThirdTile.getText());
        US_ThirdTile.click();
        AssertDisplayed(BuyRoamingOption.isDisplayed());
        XiConExtras.click();
        AssertDisplayed(US_ThirdTile.isDisplayed());
        Assert.assertEquals("Travelling abroad",US_ThirdTile.getText());
        US_ThirdTile.click();
        AssertDisplayed(BuyRoamingOption.isDisplayed());
        XiConExtras.click();
        }
    }
}
