package pages.RedHybrid.PaymentMethod;

import core.Config;
import org.testng.Assert;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Abstract;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_Android;
import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic_IOS;
import testdata.ReadResponse;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class RedHybrid_AddCardAddressLogic extends RedHybrid_AddCardAddressPO {
    private final String Card;
    private DX_IDM_FullLoginLogic_Abstract loginObject;
    private final Config config = new Config();


    public RedHybrid_AddCardAddressLogic() {
        super();
        Card = ReadResponse.GetPaymentCardList();
        if (config.isAndroid()) loginObject = new DX_IDM_FullLoginLogic_Android();
        if (config.isIos()) loginObject = new DX_IDM_FullLoginLogic_IOS();
    }

    public void selectFirstElementFromDropDown() {
        RedHybrid_selectAddressDropdownFirstElement.click();
    }


    public void beforeAddingDetails() throws InterruptedException {
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
        try {
            loginObject.enterPINAndClickOnContinue();
        } catch (Exception e) {

        }
        waitForVisibility(DB_PaymentIcon);
        DB_PaymentIcon.click();
        RedHybrid_PaymentAddCTA.click();
        RedHybrid_PaymentConfirmationToggle1.click();
        RedHybrid_PaymentConfirmationToggle2.click();
        RedHybrid_ContinuePaymentCTA.click();
    }

    public void enterUKPostcode(String postCode) {
        waitForVisibility(RedHybrid_UKPostcodeText);
        RedHybrid_UKPostcodeText.sendKeys(postCode);
    }

    public void searchAddress() {
        waitForVisibility(RedHybrid_searchAddressCTA);
        RedHybrid_searchAddressCTA.click();
    }


    public void checkDropdownList() {
        waitForVisibility(RedHybrid_selectAddressDropdown);
        AssertDisplayed(RedHybrid_selectAddressDropdown.isDisplayed());
    }

    public void checkDropdownListFilledElements() {
        //RedHybrid_selectAddressDropdown.click();
        waitForVisibility(RedHybrid_selectAddressDropdownChooseOne);
        AssertDisplayed(RedHybrid_selectAddressDropdownChooseOne.isDisplayed());
    }

    public void checkDropdownListEmpty() {
        waitForVisibility(RedHybrid_selectAddressDropdownChooseOne);
        AssertDisplayed(!RedHybrid_selectAddressDropdownFirstElement.isDisplayed());
    }

    public void checkCountryElementAfterSearchAddress() {
        scrollDownTo(RedHybrid_countryText);
        AssertResult(RedHybrid_countryText.getText(), "United Kingdom");
    }

    public void checkStreetNameElementAfterSearchAddress() {
        scrollDownTo(RedHybrid_streetNameText);
        Assert.assertTrue(RedHybrid_selectAddressDropdownFirstElement.getText().contains(RedHybrid_streetNameText.getText()));
    }

    public void enterAddressManually() {
        waitForVisibility(RedHybrid_enterAddressCTA);
        RedHybrid_enterAddressCTA.click();

    }

    public void pressXBtn() {
        waitForVisibility(RedHybrid_PaymentXIcon);
        RedHybrid_PaymentXIcon.click();
    }

    public void checkHouseNotxtIsEmpty() {
        scrollDownTo(RedHybrid_houseNoText);
        AssertResult(RedHybrid_houseNoText.getText(), "");
    }

    public void insertPostcode(String postcode) {
        scrollDownTo(RedHybrid_postcodeText);
        RedHybrid_postcodeText.sendKeys(postcode);
    }

    public void insertCountry(String country) {
        scrollDownTo(RedHybrid_countryText);
        RedHybrid_countryText.sendKeys(country);
    }

    public void insertTown(String town) {
        scrollDownTo(RedHybrid_townText);
        RedHybrid_townText.sendKeys(town);
    }

    public void insertStName(String stName) {
        scrollDownTo(RedHybrid_streetNameText);
        RedHybrid_streetNameText.sendKeys(stName);
    }

    public void insertHouseNo(String houseNo) {
        scrollDownTo(RedHybrid_houseNoText);
        RedHybrid_houseNoText.sendKeys(houseNo);
    }

    public void insertHouseName(String houseName) {
        scrollDownTo(RedHybrid_houseNameText);
        RedHybrid_houseNameText.sendKeys(houseName);
    }

    public void insertFlatNo(String flatNo) {
        scrollDownTo(RedHybrid_flatNoText);
        RedHybrid_flatNoText.sendKeys(flatNo);
    }

    public void pressContinueCTA() {
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
        waitForVisibility(RedHybrid_searchAddressCTA);
        AssertDisplayed(RedHybrid_searchAddressCTA.isDisplayed());
        RedHybrid_ContinuePaymentCTA.click();
    }

    public void checkSettingsInTrayAfterPressingX() {
        waitForVisibility(DB_SettingDashboardTray_icon);
        AssertDisplayed(DB_SettingDashboardTray_icon.isDisplayed());
    }

    public void checkContinueBtnDimmed() {
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
        AssertDisplayed(!RedHybrid_ContinuePaymentCTA.isEnabled());
    }


}