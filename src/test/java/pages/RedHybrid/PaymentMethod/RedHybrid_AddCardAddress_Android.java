package pages.RedHybrid.PaymentMethod;

import models.response.AddressResponseModel;
import org.testng.Assert;
import testdata.RedHybridTestData;
import utils.AddressUtils;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class RedHybrid_AddCardAddress_Android extends RedHybrid_AddCardAddress {

    AddressResponseModel response;
    public RedHybrid_AddCardAddress_Android() {
        super();
        response = AddressUtils.getAddress(RedHybridTestData.GetValidPostCode());
    }

    @Override
    public void validateBillingScreen(){
        AssertResult(RedHybrid_BillingAddressHeader.getText(),"Billing address");
        AssertResult(RedHybrid_UKPostcodeTitle.getText(),"Postcode (UK only)");
        AssertDisplayed(RedHybrid_UKPostcodeText.isDisplayed());
        AssertResult(RedHybrid_enterAddressCTA.getText(),"Enter address manually");
        AssertResult(RedHybrid_searchAddressCTA.getText(),"Search address");
    }

    @Override
    public void enterUKPostcode(String postCode) {
        waitForVisibility(RedHybrid_UKPostcodeText);
        RedHybrid_UKPostcodeText.sendKeys(postCode);
    }

    @Override
    public void searchAddress() {
        waitForVisibility(RedHybrid_searchAddressCTA);
        RedHybrid_searchAddressCTA.click();
    }

    @Override
    public void checkDropdownList() {
        AssertDisplayed(RedHybrid_selectAddressDropdownChooseOne.isDisplayed());
    }

    @Override
    public void selectFirstElementFromDropDown() {
        waitForVisibility(RedHybrid_selectAddressDropdownFirstElement);
        RedHybrid_selectAddressDropdownFirstElement.click();
    }

    @Override
    public void checkAddressDetails(){
        response = AddressUtils.getAddress(System.getProperty("postCodeForApiCall"));
        waitForVisibility(RedHybrid_selectAddressTextField);
        AssertResult(RedHybrid_selectAddressTextField.getText(),response.addresses.get(0).addressShortDescription);
        System.out.println(RedHybrid_selectAddressTextField.getText());
        System.out.println(response.addresses.get(0).addressShortDescription);
        AssertResult(RedHybrid_flatNoTitle.getText(),"Flat number");
        AssertResult(RedHybrid_flatNoText.getText(),response.addresses.get(0).flatNumber);
        AssertResult(RedHybrid_houseNameTitle.getText(),"House name");
        AssertResult(RedHybrid_houseNameText.getText(),response.addresses.get(0).houseName);
        scrollDownTo(RedHybrid_houseNoText);
        AssertResult(RedHybrid_houseNoTitle.getText(),"House number");
        AssertResult(RedHybrid_houseNoText.getText(),response.addresses.get(0).houseNumber);
        scrollDownTo(RedHybrid_streetNameText);
        AssertResult(RedHybrid_streetNameTitle.getText(),"Street name");
        AssertResult(RedHybrid_streetNameText.getText(),response.addresses.get(0).streetName);
        scrollDownTo(RedHybrid_townText);
        AssertResult(RedHybrid_townTitle.getText(),"Town/city");
        AssertResult(RedHybrid_townText.getText(),response.addresses.get(0).city);
        scrollDownTo(RedHybrid_countryText);
        AssertResult(RedHybrid_countryTitle.getText(),"County");
        AssertResult(RedHybrid_countryText.getText(),response.addresses.get(0).country);
        scrollDownTo(RedHybrid_postcodeText);
        AssertResult(RedHybrid_postcodeTitle.getText(),"Postcode");
        AssertResult(RedHybrid_postcodeText.getText(),response.addresses.get(0).postCode);
    }

    @Override
    public void enterAddressManually() {
        waitForVisibility(RedHybrid_enterAddressCTA);
        RedHybrid_enterAddressCTA.click();
    }

    @Override
    public void checkHouseNotxtIsEmpty() {
        scrollDownTo(RedHybrid_houseNoText);
        AssertResult(RedHybrid_houseNoText.getText(), "");
    }

    @Override
    public void checkContinueBtnDimmed() {
        scrollDownTo(RedHybrid_ContinuePaymentCTA);
        RedHybrid_ContinuePaymentCTA.click();
        AssertDisplayed(RedHybrid_postcodeTitle.isDisplayed());
    }

    @Override
    public void checkDropdownListFilledElements() {
        //RedHybrid_selectAddressDropdown.click();
        waitForVisibility(RedHybrid_selectAddressDropdownChooseOne);
        AssertDisplayed(RedHybrid_selectAddressDropdownChooseOne.isDisplayed());
    }

    @Override
    public void checkDropdownListEmpty() {
        waitForVisibility(RedHybrid_selectAddressDropdownChooseOne);
        AssertDisplayed(!RedHybrid_selectAddressDropdownFirstElement.isDisplayed());
    }

    @Override
    public void checkCountryElementAfterSearchAddress() {
        scrollDownTo(RedHybrid_countryText);
        AssertResult(RedHybrid_countryText.getText(), "United Kingdom");
    }

    @Override
    public void checkStreetNameElementAfterSearchAddress() {
        scrollDownTo(RedHybrid_streetNameText);
        Assert.assertTrue(RedHybrid_selectAddressDropdownFirstElement.getText().contains(RedHybrid_streetNameText.getText()));
    }

    @Override
    public void insertPostcode(String postcode) {
        scrollDownTo(RedHybrid_postcodeText);
        RedHybrid_postcodeText.sendKeys(postcode);
    }

    @Override
    public void insertCountry(String country) {
        scrollDownTo(RedHybrid_countryText);
        RedHybrid_countryText.sendKeys(country);
    }

    @Override
    public void insertTown(String town) {
        scrollDownTo(RedHybrid_townText);
        RedHybrid_townText.sendKeys(town);
    }

    @Override
    public void insertStName(String stName) {
        scrollDownTo(RedHybrid_streetNameText);
        RedHybrid_streetNameText.sendKeys(stName);
    }

    @Override
    public void insertHouseNo(String houseNo) {
        scrollDownTo(RedHybrid_houseNoText);
        RedHybrid_houseNoText.sendKeys(houseNo);
    }

    @Override
    public void insertHouseName(String houseName) {
        scrollDownTo(RedHybrid_houseNameText);
        RedHybrid_houseNameText.sendKeys(houseName);
    }

    @Override
    public void insertFlatNo(String flatNo) {
        scrollDownTo(RedHybrid_flatNoText);
        RedHybrid_flatNoText.sendKeys(flatNo);
    }

}