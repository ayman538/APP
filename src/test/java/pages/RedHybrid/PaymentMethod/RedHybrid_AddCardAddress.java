package pages.RedHybrid.PaymentMethod;

import pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
import testdata.ReadResponse;

public abstract class RedHybrid_AddCardAddress extends RedHybrid_AddCardAddressPO {

    public RedHybrid_AddCardAddress() {
        super();
    }

    public abstract void selectFirstElementFromDropDown();

    public abstract void validateBillingScreen();

    public abstract void enterUKPostcode(String postCode);

    public abstract void searchAddress();

    public abstract void checkDropdownList();

    public abstract void checkDropdownListEmpty();

    public abstract void enterAddressManually();

    public abstract void checkHouseNotxtIsEmpty();

    public abstract void checkContinueBtnDimmed();

    public abstract void checkAddressDetails();

    public abstract void checkDropdownListFilledElements();

    public abstract void checkCountryElementAfterSearchAddress();

    public abstract void checkStreetNameElementAfterSearchAddress();

    public abstract void insertPostcode(String postcode);

    public abstract void insertCountry(String country);

    public abstract void insertTown(String town);

    public abstract void insertStName(String stName);

    public abstract void insertHouseNo(String houseNo);

    public abstract void insertHouseName(String houseName);

    public abstract void insertFlatNo(String flatNo);
}