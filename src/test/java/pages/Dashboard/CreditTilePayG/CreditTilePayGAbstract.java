package pages.Dashboard.CreditTilePayG;

import models.response.SegmentResponseModel;
import utils.SegmentUtils;

public abstract class CreditTilePayGAbstract extends CreditTilePayGPO{

    public CreditTilePayGAbstract(){
        super();
    }


    public abstract void ValidateCreditHeaderTextPREPAY();


    public abstract void ValidateCreditTitleTextPREPAY();


    public abstract void ValidateCreditAmountTextPREPAY();


    public abstract void ValidateCreditFooterTextPREPAY();


    public abstract void assertCreditHeaderTextPREPAY();


    public abstract void assertCreditTitleTextPrePay();


    public abstract void assertCreditAmountTextPREPAY();


    public abstract void assertCreditFooterTextPREPAY();

    public abstract void creditTileIsDisplayed();

    public abstract void assertCreditTile() throws Exception; //to check discover response and compare it to app

    public abstract void assertCreditTitleTextPrePayIsLow();

    public abstract void assertCreditAmountTextPREPAYIsLow();

    public abstract void ValidateChargesTile() ;
    public abstract void ValidateTilesForHbbUser() ;
    public abstract void ValidateVestaJoruneys() ;
    public abstract void ValidateVestaJoruneysforPayGChild() ;
    public abstract void navigateToPlanPayg();
    public abstract void navigateToBugBigValue();
    public abstract void validateBigValueBundleScreen();
    public abstract void validatePlanForPayg();
    public abstract void validateUsageForPayg();



}
