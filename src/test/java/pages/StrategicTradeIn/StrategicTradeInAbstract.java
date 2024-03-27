package pages.StrategicTradeIn;

public abstract class StrategicTradeInAbstract extends StrategicTradeInPO{
    public StrategicTradeInAbstract() {super();
    }

    public abstract void assertAcqNewDBHeaderTitleText();
    public abstract void goToStrategicTradeInPage();
    public  abstract void clickOnTradeInIcon();
    public abstract void clickOnTradeInAssistanceLink();
    public abstract void verifyStrategicTradeInPageTitle();
}
