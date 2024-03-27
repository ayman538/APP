package pages.NativeExtras.ConfirmBottomSheet;

import models.response.NativeExtrasSubGroupResponseModelAnalyticsVersion;
import org.testng.Assert;
import utils.NativeExtrasProductsDetailsUtils;

import static utils.element_helpers.TextHelpers.removeHtmlTag;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class ConfirmBottomSheetLogicIOS extends ConfirmBottomSheetAbstract{
    NativeExtrasSubGroupResponseModelAnalyticsVersion nativeExtrasProductsDetailsResponseModel;
    private static String extraCategoryName;

    private void callAPI(String categoryName){
        nativeExtrasProductsDetailsResponseModel = NativeExtrasProductsDetailsUtils.getNativeExtrasSubGroupResponseModelAnalyticsVersion(categoryName);
    }

    private NativeExtrasSubGroupResponseModelAnalyticsVersion.ConfirmExtra getConfirmExtraFromAPI(){
        if (nativeExtrasProductsDetailsResponseModel.itemGroups != null)
            return nativeExtrasProductsDetailsResponseModel.itemGroups.serviceSubGroups.get(0).extras.get(0).confirmExtra;
        else
            return nativeExtrasProductsDetailsResponseModel.confirmExtra;
    }

    @Override
    public void validateConfirmBottomSheetTitle(String categoryName) throws Exception {
        callAPI(categoryName);
        if (nativeExtrasProductsDetailsResponseModel.itemGroups != null){
            try {
                waitForVisibility(confirmScreenCategoryTitle);
                Assert.assertEquals(nativeExtrasProductsDetailsResponseModel.itemGroups.header.title, confirmScreenCategoryTitle.getText());
                Assert.assertTrue(confirmScreenBackArrow.isDisplayed());
            }
            catch (Exception e) {
                throw new Exception("This category has multiple extras");
            }
        }
        else {
            waitForVisibility(confirmScreenCategoryTitle);
            Assert.assertEquals(nativeExtrasProductsDetailsResponseModel.confirmExtra.header.title, confirmScreenCategoryTitle.getText());
        }
    }

    @Override
    public void validateConfirmBottomSheetContent(String categoryName) {
        callAPI(categoryName);
        Assert.assertEquals(getConfirmExtraFromAPI().title, confirmScreenExtraTitle.getText());
        Assert.assertEquals(removeHtmlTag(getConfirmExtraFromAPI().name), confirmScreenExtraSubtitle.getText());
        Assert.assertEquals(getConfirmExtraFromAPI().productDetails, confirmScreenExtraPrice.getText());
        Assert.assertEquals(removeHtmlTag(getConfirmExtraFromAPI().moreInformationText), confirmScreenMoreInformationTitle.getText());
        Assert.assertEquals(getConfirmExtraFromAPI().moreInformationDescription, confirmScreenMoreInformationDescription.getText());
        if (confirmScreenExtraSubtitle.getText().equals("Vodafone Secure Net"))
            Assert.assertEquals(confirmScreenExtraDescription.getText(),getConfirmExtraFromAPI().description.replace("<a target=\"_blank\"  href=\"https://www.vodafone.co.uk/network/data-features/securenet\">Secure Net</a>", "Secure Net"));
        else
            Assert.assertEquals(confirmScreenExtraDescription.getText(),getConfirmExtraFromAPI().description);
        AssertDisplayed(confirmScreenXCTA.isDisplayed());
        AssertDisplayed(confirmScreenBuyCTA.isDisplayed());
    }

    @Override
    public void clickOnConfirmScreenBuyCTA() {
        confirmScreenBuyCTA.click();
    }

    @Override
    public void clickOnConfirmScreenBackArrowIcon() {
        confirmScreenBackArrow.click();
    }
}
