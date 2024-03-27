package pages.Tray.Settings;

public abstract class ImportantDocumentsAbstractLogic extends ImportantDocumentsPO{
    public ImportantDocumentsAbstractLogic(){super();}
    public abstract void validateImportantDocuments () throws InterruptedException;
    public abstract void clickOnImportantDocuments();
    public abstract void validateImportantDocumentsSSO() throws InterruptedException;
    public abstract void clickOnAccountSetting();

}
