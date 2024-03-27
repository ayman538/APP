package pages.RedHybrid.AddNewPlan_AddPaymentMethodBeforeJourney;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class AddNewPlan_AddPaymentMethodBeforeJourney_Abstract extends AddNewPlan_AddPaymentMethodBeforeJourney_PO {

    public AddNewPlan_AddPaymentMethodBeforeJourney_Abstract(){super();}

    public abstract void ValidateContentOfOverlay(String ProcessType, String requestedActionValue) throws JsonProcessingException;

    public abstract void ClickOnAddNewCardCTA();

    public abstract void CheckFlexiPlansScreen();

    public abstract void ClickOnXCTA();

}
