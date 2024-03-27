package pages.Tray.Settings;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ImportantDocumentsAndroidLogic extends ImportantDocumentsAbstractLogic {
    public ImportantDocumentsAndroidLogic(){super();}

    @Override
    public void validateImportantDocuments() throws InterruptedException {
        waitForVisibility(AS_ImportantDocuments);
        Thread.sleep(4000);
        AssertDisplayed(AS_ImportantDocuments.isDisplayed());
    }

    public void clickOnImportantDocuments(){
        AS_ImportantDocuments.click();
    }

    public void validateImportantDocumentsSSO() throws InterruptedException {
        waitForVisibility(SSO_ImportantDocuments);
        Thread.sleep(111000);
        AssertDisplayed(SSO_ImportantDocuments.isDisplayed());
    }
    public void clickOnAccountSetting(){
        AS_AccountSetting.click();
    }
}
