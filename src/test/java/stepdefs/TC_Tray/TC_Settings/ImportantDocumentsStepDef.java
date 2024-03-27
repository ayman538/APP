package stepdefs.TC_Tray.TC_Settings;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Tray.Settings.ImportantDocumentsAbstractLogic;
import pages.Tray.Settings.ImportantDocumentsAndroidLogic;
import pages.Tray.Settings.ImportantDocumentsIOSLogic;

public class ImportantDocumentsStepDef {

    ImportantDocumentsAbstractLogic importantDocumentsAbstractLogic;



    public ImportantDocumentsStepDef(Config config){
        if(config.isAndroid()) importantDocumentsAbstractLogic = new ImportantDocumentsAndroidLogic();
        if (config.isIos()) importantDocumentsAbstractLogic = new ImportantDocumentsIOSLogic();
    }

    @Then("Validate Important Documents")
    public void validateImportantDocuments () throws InterruptedException {
        importantDocumentsAbstractLogic.validateImportantDocuments();

    }

    @When("click on important documents")
    public void clickOnImportantDocuments() {
        importantDocumentsAbstractLogic.clickOnImportantDocuments();


    }

    @Then("Validate Important Documents SSO is opened")
    public void validateImportantDocumentsSSOIsOpened() throws InterruptedException {
        importantDocumentsAbstractLogic.validateImportantDocumentsSSO();
    }

    @And("Click on Account Setting")
    public void clickOnAccountSetting() {
        importantDocumentsAbstractLogic.clickOnAccountSetting();
    }
}
