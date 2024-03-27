package pages.RedHybrid.ManageyourPlanCard_ToggleAutoRenewOff;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class ManageyourPlanCard_ToggleAutoRenewOffAbstract extends ManageyourPlanCard_ToggleAutoRenewOff_PO{


    public abstract void scrollDownToMangeYourPlanCard();

    public abstract void CheckUIOfManageYourPlanCard();

    public abstract void SwitchToggle();

    public abstract void checkThatDisclaimerMaskCard() throws JsonProcessingException;

    public abstract void openDeepLinkForChangePlanForNextMonth();

    public abstract void CheckAutoRenewConfirmationScreen();

}
