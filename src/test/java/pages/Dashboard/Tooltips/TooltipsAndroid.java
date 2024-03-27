package pages.Dashboard.Tooltips;

import models.response.ContentV2ResponseModel;
import models.response.DashboardV4ResponseModel;
import utils.ContentUtils;
import utils.DashboardUtils;

import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class TooltipsAndroid extends TooltipsAbstract{
    DashboardV4ResponseModel dashboard = DashboardUtils.GetDashboard() ;
    ContentV2ResponseModel content = ContentUtils.getContent();


    public boolean validateIfBingo() {

        try {
            System.out.println(dashboard.tooltips.get(0).journeyName);
            dashboard.tooltips.get(0).journeyName.contains("HOME");
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public void ValidateSeparateTip(int tipNumber , String KindOfCTA){

        waitForVisibility(CTA);
        AssertDisplayed(circleView.isDisplayed());
        AssertDisplayed(triangleView.isDisplayed());
        assertIsTrueSoftly("Invalid tip title",tipTitle.getText()
                .contains(dashboard.tooltips.get(0).items.get(tipNumber).title));
        assertIsTrueSoftly("Invalid tip body message",currentTip.getText()
                .contains(dashboard.tooltips.get(0).items.get(tipNumber).description));
        assertIsTrueSoftly("Invalid CTA",CTA.getText()
                .contains(KindOfCTA));

    }
    public void ValidateFirstTip() {
        if(validateIfBingo()){
            System.out.println("its a Bingo user lets proceed");
            ValidateSeparateTip(0,"Next");
        }


    }
    public void SubmitFirstTip(){
        if(validateIfBingo()) {
            ValidateFirstTip();
            CTA.click();
        }else{
            System.out.println("it's not a Bingo user");
        }
    }
    public void ValidateSecondTip(){
        if(validateIfBingo()){
            ValidateSeparateTip(1,"Next");
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
            CTA.click();
        }
    }

    public void TooltipsNotDisplayed(){
       waitForVisibility(DX_IDM_MyAccountTray);
       DX_IDM_MyAccountTray.click();

    }

    public void DismissSecondTip(){
        if (validateIfBingo()) {
            ValidateSecondTip();
            waitForVisibility(dismissCTA);
            dismissCTA.click();
        }
    }

    public void DismissFirstTip(){
        if (validateIfBingo()&& elementIsPresent(dismissCTA)) {
            if (dashboard.tiles.get(0).status.code == 0
                    && dashboard.tiles.get(1).status.code == 0
                    && dashboard.tiles.get(2).status.code == 0
                    && dashboard.tiles.get(3).status.code == 0) {
                    ValidateFirstTip();
                    waitForVisibility(dismissCTA);
                    dismissCTA.click();
            }
            else{
                System.out.println("Subsoverlays are failing and this can make Tooltips won't appear");
            }
        }
    }




}
