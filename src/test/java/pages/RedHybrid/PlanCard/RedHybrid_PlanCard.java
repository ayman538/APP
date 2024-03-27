package pages.RedHybrid.PlanCard;


import com.fasterxml.jackson.core.JsonProcessingException;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public abstract class RedHybrid_PlanCard extends RedHybrid_PlanCardPO {

    public RedHybrid_PlanCard() {
        super();
    }

    public abstract void navigateToPlan() throws InterruptedException;


    public abstract void dashboardIsDisplayed();

    public abstract void ValidatePlanCardUI();

    public abstract void DismissPaymentMethodOverlay();

    public abstract void addCardHyperLinkValidation(String displayed);

    public abstract void ValidateIncludesDisplayingAfterClickingShowmore();

    public abstract void userClosesSubsOverlay();

    //for masking and reflection for change plan
    public abstract void validateMangeYourPlanMaskAfterChangingThePlan() throws JsonProcessingException;

    public abstract void uiOfScreenThatNotifyTheUserThatARequestIsBeingProcessed();


    //For Plan Tab with Teal Card
    public abstract void checkContentOfTealCard();

    public abstract void iAmARedhybridUserWhoTurnsOffTheAutoRenewToggle();

    public abstract void validateContentOfPlanTab();
    public abstract void iShouldAbleToSeeThatReflectedPlanWithMessageOnThePlanTileAndTheResponceShouldBeAsPlanAPIResponse();
}

