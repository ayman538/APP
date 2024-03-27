package pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links;

public abstract class Red_Hybrid_Add_Extras_Category_links_Abstract extends Red_Hybrid_Add_Extras_Category_links_PO {
    public Red_Hybrid_Add_Extras_Category_links_Abstract() {super();}

    public abstract void chooseExtra(String extraType);
    public abstract void extraOverlayAppears();
    public abstract void extraOverlayUIComplyWithListExtraResponse();
    public abstract void clickOnExtrasDescriptionLink();
    public abstract void userInTheCorrectWebView(String webViewTitle , String url);
    public abstract void AssertRenewPlanEarlyIsDisplayed();
    public abstract void  ClickOnRenewEarlyCTA();
}
