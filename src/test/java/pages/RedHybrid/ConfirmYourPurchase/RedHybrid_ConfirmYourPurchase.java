package pages.RedHybrid.ConfirmYourPurchase;


import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class RedHybrid_ConfirmYourPurchase extends RedHybrid_ConfirmYourPurchasePO {
  public RedHybrid_ConfirmYourPurchase() {
    super();
  }

  public abstract void barclaysScreenIsDisplayed();

  public abstract void clickOnTermsAndConditionsToggle();

  public abstract void validateEnablingTermsAndConditionsToggle() throws InterruptedException;

  public abstract void confirmPurchaseScreenIsDisplayed() throws JsonProcessingException;

  public abstract void validateConfirmPurchaseUIScreen() throws JsonProcessingException, InterruptedException;

  public abstract void clickOnPayNowInBarcalysScreen();

  public abstract void clickOnPaySecurelyCTA();
  public abstract void maskOverDashboardTile();

  public abstract void validateUIOfNewPlanAddedScreen() throws JsonProcessingException;
  public abstract void validateConfirmPurchaseUIScreen( String orderType) throws JsonProcessingException;


}
