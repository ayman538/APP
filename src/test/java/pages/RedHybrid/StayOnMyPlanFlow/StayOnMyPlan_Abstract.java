package pages.RedHybrid.StayOnMyPlanFlow;

import com.fasterxml.jackson.core.JsonProcessingException;


public abstract class StayOnMyPlan_Abstract extends StayOnMyPlanPO {

    public abstract void clickOnStayOnMyPlanCTAFromTealCard();
    public abstract void validateStayOnMyPlanOrNotTrayContent();

    public abstract void chooseToStayOnTheCurrentPlan();

    public abstract void ValidateStayOnCurrentPlanConfirmationTray() throws JsonProcessingException;

    public abstract void clickOnNoThanks();
}
