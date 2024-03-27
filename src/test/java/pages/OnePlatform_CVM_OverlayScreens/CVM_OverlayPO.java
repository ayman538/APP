package pages.OnePlatform_CVM_OverlayScreens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class CVM_OverlayPO extends CommonPo {

    public CVM_OverlayPO() { super();}



    @FindAll({
            @FindBy(how = How.ID, using = "overlayType1CenterImage"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeOther[@name=\"CVMview\"]/XCUIElementTypeScrollView/XCUIElementTypeOther") //VOXI IMAGE ID
    })
    public WebElement CVM_OverlayImage;

    @FindAll({
            @FindBy(how = How.ID_OR_NAME, using = "btnClose"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=\"icClose\"]")  //voxi X close
    })
    public WebElement CVM_OverlayXClose;


    @FindAll(value = {
            @FindBy(how = How.ID_OR_NAME, using = "overlayType1PrimaryText"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"overlayType1PrimaryText\"]"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"Hello, friend!\"]")
    })
    public WebElement CVM_OverlayHeaderTXT;

    @FindAll({
           @FindBy(how = How.ID_OR_NAME, using = "overlayBirthdaySecondaryText"),
          @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"The My Vodafone app doesn’t currently support VOXI, but you can manage your subscription through the link below. If you have another Vodafone service you’d like to manage, you can log in via the My Account page.\"]"),// Voxi user
          @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"overlayBirthdaySecondaryText\"]"),
    })
    public WebElement CVM_OverlaySecondaryTXT;


    @FindAll({
            @FindBy(how = How.ID_OR_NAME, using = "overlayCloseButton"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=\"overlayCloseButton\"]"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=\"CVMconfirmButton\"]")
    })
    public WebElement CVM_OverlayPrimarybtn;

    @FindAll({
            @FindBy(how = How.ID_OR_NAME, using = "overlaysecondaryButton"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeButton[@name=\"CVMsecondaryButton\"]"),
            @FindBy(how = How.ID, using = "com.myvodafoneapp:id/overlaysecondaryButton")
    })
    public WebElement CVM_OverlaySecondarybtn;

    @FindAll({
            @FindBy(how = How.ID_OR_NAME, using = "Accept All Cookies"),
            @FindBy(how = How.ID_OR_NAME, using = "TabBarItemTitle"),
            @FindBy(how = How.ID, using = "//XCUIElementTypeButton[@name=\"Accept All Cookies\"]")
    })
    public WebElement Voxi_Webview;


    @FindAll({
            @FindBy(how = How.ID, using = "txtAcquisitionNewDB_HeaderTitle"),
            @FindBy(how = How.XPATH, using = "//XCUIElementTypeStaticText[@name=\"txtAcquisitionNewDB_HeaderTitle\"]")
    })
    public WebElement AcquisitionScreen_Header;

    @FindAll({
            @FindBy(how = How.ID, using = "tobiImg"),
            @FindBy(how = How.ID, using = "//XCUIElementTypeOther[@name=\"Login | Vodafone\"]/XCUIElementTypeOther[7]/XCUIElementTypeOther[1]")
    })
    public WebElement LoginScreen_Header;



}


