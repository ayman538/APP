package pages.RedHybrid.ChangeNextPlan_ChangeProcessing;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class ChangeNextPlaneChangeProcessing_Abstract extends ChangeNextPlaneChangeProcessing_PO {

    public ChangeNextPlaneChangeProcessing_Abstract() {
        super();
    }

    public abstract void clickOnChangePlanForNextMonth();

    public abstract void clickOnConfirmNextPlanCTA();

    public abstract void validateChangePlaneProcessingScreenUI();

    public abstract void validateChangePlanNotificationScreenUI();

    public abstract void validatePlanTabIsDisplayed();


    public abstract void redHybridDismissIconClick();

    public abstract void iShouldAbleToSeeQuickLinks();

    public abstract void validate_UI_of_confirmation_screen_in_changePlan(String JourneyType) throws JsonProcessingException;
}

