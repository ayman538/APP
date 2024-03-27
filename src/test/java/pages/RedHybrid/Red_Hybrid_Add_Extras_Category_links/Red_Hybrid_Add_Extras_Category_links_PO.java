package pages.RedHybrid.Red_Hybrid_Add_Extras_Category_links;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class Red_Hybrid_Add_Extras_Category_links_PO extends CommonPo {
    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='What destinations are included?']"),
            @FindBy(how = How.XPATH, using = "//*[@label='What destinations are included?']")

    })
    public WebElement WhatDestinationsAreIncludedCTA;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='What is premium rate credit?']"),
            @FindBy(how = How.XPATH, using = "//*[@label='What is premium rate credit?']")

    })
    public WebElement whatIsPremiumRateCredit;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/btnClose"),
            @FindBy(how = How.ID, using = "VFGwebCloseButton")

    })
    public WebElement X_CTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/tvTitle")
    })
    public WebElement AddExtrasWebViewTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "International Extras")
    })
    public WebElement internationalExtraWebViewTitle;
    @FindAll({
                @FindBy(how = How.ID, using = "International Roaming")
    })
    public WebElement RoamingExtraWebViewTitle;
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/txtRedHybridTitle"),
            @FindBy(how = How.ID, using = "bottomSheetTitleIdentifier")
    })
    public WebElement screenTitle;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addDataSubtitle"),
            @FindBy(how = How.ID, using = "SelectExtraOverlySubTitle")
    })
    public WebElement ExtrasSubtitle;

    //Extras
    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/dataExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='Data Extra']")
    })
    public WebElement dataExtra;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/europeRoamingExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='Europe Roaming Extra']")
    })
    public WebElement europeRoamingExtra;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/aroundTheWorldRoamingExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='Around the World Roaming Extra']")
    })
    public WebElement aroundTheWorldRoamingExtra;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/premiumRateCreditExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='Premium Rate Credit Extra']")

    })
    public WebElement premiumRateCreditExtra;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/internationalExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='International Extra']")
    })

    public WebElement internationalExtra;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/internationalExtra"),
            @FindBy(how = How.XPATH, using = "//*[@label='Rest of the World Roaming Extra']")
    })

    public WebElement restOftheWorldExtra;


    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/addDataList"),
            @FindBy(how = How.ID, using = "listOfDataOptions")
    })

    public WebElement listOfDataOptions;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Continue']"),
            @FindBy(how = How.ID, using = "Continue")
    })
    public WebElement continueCTA;

    @FindAll({
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/extrasListView")
    })
    public WebElement extrasList;

    @FindAll({
            @FindBy(how = How.ID, using = "SelectExtraOverlyChooseExtraView_0")
    })
    public WebElement firstExtrabundle;

    @FindAll({
            @FindBy(how = How.XPATH, using = "//*[@text='Renew plan early']"),
            @FindBy(how = How.ID, using = "action_1")
    })
    public WebElement RenewPlanEarlyCTA;
}
