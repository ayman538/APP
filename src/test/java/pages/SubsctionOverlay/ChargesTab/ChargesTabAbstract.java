package pages.SubsctionOverlay.ChargesTab;

import java.io.IOException;

public abstract class ChargesTabAbstract extends ChargesTabPO{

    public ChargesTabAbstract() {
        super();
    }

    public abstract void setBeforeClass() ;

    public abstract void billingTileHeaderCTA();

    public abstract void noAdditionalCard();

    public abstract void validateAllowanceChargesDisplayed() ;

    public abstract void assertAdditionalChargesHeaderDisplayed() ;

    public abstract void additionalChargesChevronCTA();

    public abstract void ItemizedJourney();

    public abstract void assertLoginTitleDisplayed();

    public abstract void detailsChevronCTA();

    public abstract void assertDetailChevronText() ;

    public abstract void validateTotalEstimatedCharges() ;

    public abstract void unBilledChargesListMoreThanSix();

    public abstract void chargesSSOJourney();

    public abstract void ClickOnViewDetailsCTA();


    public abstract void validateMonthlyCharges();

    public abstract void navigateToChargesOverlay();
}
