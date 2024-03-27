package pages.RedHybrid.ProcessingPaymentCard;

public abstract class RedHybrid_ValidateCardAdding extends RedHybrid_ValidateCardAddingPO{

    public RedHybrid_ValidateCardAdding() {
        super();
    }


    public abstract void ClickOnContinue() ;

    public abstract void ClickOnCancel();

    public abstract void ClickOnXicon() ;

    public abstract void TapOnAndroidPhysicalBackOnSuccessScreen() ;

    public abstract void ClickOnTryAgain() ;

    public abstract void TapOnAndroidPhysicalBackOnProcessingScreen() ;

    public abstract void ValidateVerifiedCardScreen();

    public abstract void ValidateFailedCardScreen() ;

    public abstract void ValidateProcessingScreen() ;

}

