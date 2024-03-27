package pages.NewBilling.PreviousBillsCard;

public abstract class PreviousBillsCard_Abstract extends PreviousBillsCard_PO{

    public PreviousBillsCard_Abstract(){super();}

    public abstract void iScrollDownToPreviousBillCard();

    public abstract void iShouldValidatePreviousBillCardContent();

    public abstract void iCheckLoadMoreCTAFunctionality();

    public abstract void iClickOnArrowIcon();

    public abstract void iValidateThePreviousBillReinventJourneyIsOpen();
}