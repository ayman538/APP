package pages.Dashboard.VOV;

import models.response.VOVResponseModel;
import utils.VoVUtils;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class VOVIOS extends VOVAbstract{

    public VOVIOS(){
        super();
    }

    VOVResponseModel VOVResponse = VoVUtils.GetVoV();

    public void VOVCTA(){
        DB_VOVCTA.click();
        waitForVisibility(WV_Title);
        AssertDisplayed(WV_Title.isDisplayed());
    }

    public void VOVWebViewBackCTA(){
        WV_TitleBackCTA.click();
        waitForVisibility(DB_VOVTitle);
        AssertDisplayed(DB_VOVTitle.isDisplayed());
    }

    public void DismissVOV(){
        DB_VOVhideCTA.click();
    }

    public void checkVOVAfterSoftClose(){
        waitForVisibility(DB_VOVSalutation);
        AssertDisplayed(!DB_VOVDescription.isDisplayed());
    }

    public void checkVOVItems(){
        waitForVisibility(DB_VOVDescription);
        AssertDisplayed(DB_VOVhideCTA.isDisplayed());
        AssertDisplayed(DB_VOVSalutation.isDisplayed());
        AssertDisplayed(DB_VOVCount.isDisplayed());
        AssertResult(DB_VOVTitle.getText(),VOVResponse.notifications.get(0).title);
        AssertResult(DB_VOVDescription.getText(),VOVResponse.notifications.get(0).message);
        AssertDisplayed(DB_VOVCTA.isDisplayed());
    }
}
