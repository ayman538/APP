package pages.Dashboard.Tooltips;

import models.response.ContentV2ResponseModel;
import models.response.DashboardV4ResponseModel;
import org.openqa.selenium.By;
import utils.ContentUtils;
import utils.DashboardUtils;

import static utils.element_helpers.VerifyHelpers.assertIsTrueSoftly;
import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;


public class TooltipsIOS  extends TooltipsAbstract{
    DashboardV4ResponseModel dashboard = DashboardUtils.GetDashboard() ;
    ContentV2ResponseModel content = ContentUtils.getContent();


    public boolean validateIfBingo() {

        try {
            dashboard.tooltips.get(0).journeyName.contains("HOME");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void ValidateSeparateTip(int tipNumber , String KindOfCTA ){
        waitForVisibility(CTA);
        assertIsTrueSoftly(dashboard.tooltips.get(0).items.get(tipNumber).title,
                driver.findElement(By.name("TVtitleLabel"))
                .isDisplayed());
        assertIsTrueSoftly(dashboard.tooltips.get(0).items.get(tipNumber).description,
                driver.findElement(By.name("TVdescriptionLabel"))
                        .isDisplayed());

    }
    public void ValidateFirstTip() {
        if(validateIfBingo()){
            System.out.println("its a Bingo user lets proceed");
            ValidateSeparateTip(0,"Next");
            assertIsTrueSoftly("There is no Dismiss CTA", dismissCTA.isDisplayed());
        }


    }
    public void SubmitFirstTip(){
        if(validateIfBingo()) {
            ValidateFirstTip();
            CTA.click();
        } else{
            System.out.println("it's not a Bingo user");
        }
    }
    public void ValidateSecondTip(){
        if(validateIfBingo()){
            ValidateSeparateTip(1,"Next");
            assertIsTrueSoftly("There is no Dismiss CTA", dismissCTA.isDisplayed());
        }


    }
    public void SubmitSecondTip(){
        if(validateIfBingo()) {
            ValidateSecondTip();
            CTA.click();
        }

    }
    public void ValidateThirdTip(){
        if(validateIfBingo()){
            ValidateSeparateTip(2,"Thanks");
        }
    }
    public void SubmitThirdTip() {
        if (validateIfBingo()) {
            ValidateThirdTip();
            waitForVisibility(CTA);
            CTA.click();
        }
    }

    public void TooltipsNotDisplayed() {
        if (validateIfBingo()) {
            waitForVisibility(DX_IDM_MyAccountTray);
            DX_IDM_MyAccountTray.click();
        }
    }
    public void DismissSecondTip(){
        if (validateIfBingo()) {
            ValidateSecondTip();
            dismissCTA.click();
        }

    }

    public void DismissFirstTip(){
        if (validateIfBingo()&& elementIsPresent(dismissCTA) ) {
            if (dashboard.tiles.get(0).status.code == 0
                    && dashboard.tiles.get(1).status.code == 0
                    && dashboard.tiles.get(2).status.code == 0
                    && dashboard.tiles.get(3).status.code == 0){
                ValidateFirstTip();
                dismissCTA.click();
            } else {
                System.out.println("Subsoverlays are failing and this can make Tooltips won't appear ");
            }
        }
        }





}
