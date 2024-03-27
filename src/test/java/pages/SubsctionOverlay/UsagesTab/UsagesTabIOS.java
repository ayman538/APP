package pages.SubsctionOverlay.UsagesTab;

import models.response.CROUsageResponseModel;
import models.response.NativeExtrasResponseModel;
import models.response.UsagesResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.NativeExtrasUtils;
import utils.SegmentUtils;
import utils.UsageUtils;

import static utils.element_helpers.ScrollHelpers.*;
import static utils.element_helpers.VerifyHelpers.assertElementDoesNotExist;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class UsagesTabIOS extends UsagesTabAbstract {

    public UsagesTabIOS() {
        super();
    }

    UsagesResponseModel usagesResponseModel = UsageUtils.getUsagesV2();
    models.response.NativeExtrasResponseModel NativeExtrasResponseModel = NativeExtrasUtils.getExtras();
    //CROUsageResponseModel CROusagesResponseModel = UsageUtils.getCROUsagesV2();

    public boolean Roaming =  false;
    public boolean Data = false;
    public boolean Calling = false;
    public void navigateToUsages() {
        waitForVisibility(SO_UsageTab);
        SO_UsageTab.click();
        waitForVisibility(SO_UsageTabContainer);
    }

    public void checkPlanCardinUsage() {
        waitForVisibility(SO_UsageTabContainer);
        for (int i = 0; i < usagesResponseModel.cards.size(); i++) {
            if (usagesResponseModel.cards.get(i).title.equals("Plan")) {
                AssertResult(US_PlanCardTitlePAYM.getText(),
                        usagesResponseModel.cards.get(i).title);
                for (int k = 0; k < usagesResponseModel.cards.get(i).sections.size(); k++) {
                    AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).header).isDisplayed());
                    for (int j = 0; j < usagesResponseModel.cards.get(i).sections.get(k).allowances.size(); j++) {
                        if (!usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).unlimited) {
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header).isDisplayed());
                            String temp = usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity
                                    + " " + usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).remainingUnit;
                            System.out.println(temp);
                            AssertDisplayed(GetElement(temp).isDisplayed());
                            temp = usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix;
                            AssertDisplayed(GetElement(temp).isDisplayed());
                        } else {
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header).isDisplayed());
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity + " ").isDisplayed());
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix).isDisplayed());
                        }
                    }
                }
            } else if (usagesResponseModel.cards.get(i).title.equals("Big value bundle")) {
                AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).title).isDisplayed());
                for (int k = 0; k < usagesResponseModel.cards.get(i).sections.size(); k++) {
                    AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).header).isDisplayed());
                    for (int j = 0; j < usagesResponseModel.cards.get(i).sections.get(k).allowances.size(); j++) {
                        if (!usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).unlimited) {
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header).isDisplayed());
                            String quantity = usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity;
                            String remainingUnit = usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).remainingUnit;
                            String actualQuantity = quantity + " " + remainingUnit;
                            AssertDisplayed((GetElement(actualQuantity).isDisplayed()));
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix).isDisplayed());
                        } else {
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).header).isDisplayed());
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantity + " ").isDisplayed());
                            AssertDisplayed(GetElement(usagesResponseModel.cards.get(i).sections.get(k).allowances.get(j).quantitySuffix).isDisplayed());

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
            //  iosScrollToElement(US_addExtraCTA,"down");
            //scrollUpTo(US_addExtraCTA);
            scrollDownTo(US_addExtraCTA);
            //SwipeToElement(US_addExtraCTA, "Up");
//                if( CROusagesResponseModel.extras.title.contains("carousel")){
            System.out.println(US_ExtrasHeader.getText());
            AssertDisplayed(US_ExtrasHeader.isDisplayed());

//
//                }
        } catch (NullPointerException e) {
            AssertDisplayed(US_addExtraCTA.isDisplayed());
        }

    }

    @Override
    public void validateExperienceFunctionality() {
//
//
//        //carousel experience
//
//        scrollDownTo(US_addExtraCTA);
//        waitForVisibility(US_ExtrasHeader);
//        Assert.assertEquals("Our cost effective Extras",US_ExtrasHeader.getText());
//
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
//
//       /* for (int i = 0; i < 3; i++) {
//            System.out.println("item " + i);
//            US_ListTitle.get(i).click();
//            waitForVisibility(shopExtrasCard);
//            AssertDisplayed(shopExtrasCard.isDisplayed());
//          navigateToUsages();
//        */
////tileList experience
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
    public void iShouldSeeTilesTitle() {
        scrollDownTo(US_addExtraCTA);
        waitForVisibility(US_ExtrasHeader);
        Assert.assertEquals("Our cost effective Extras",US_ExtrasHeader.getText());
    }

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
}}
