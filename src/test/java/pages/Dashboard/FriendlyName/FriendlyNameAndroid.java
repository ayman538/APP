package pages.Dashboard.FriendlyName;


import org.testng.Assert;

import static utils.element_helpers.VerifyHelpers.elementIsPresent;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class FriendlyNameAndroid extends FriendlyNameAbstract{
    public FriendlyNameAndroid() {
        super();
    }

    @Override
    public void verifyPencilIconExist() {
        DB_PencilIcon.click();    }

    @Override
    public void verifyPencilIconNotExist() {
        Assert.assertFalse(elementIsPresent(DB_PencilIcon));
    }

    @Override
    public void enterValidFriendlyName() {
        waitForVisibility(FriendlyNameText);
        FriendlyNameText.clear();
        FriendlyNameText.sendKeys("Abdeen");
    }

    @Override
    public void clickOnSaveCTA() {
        waitForVisibility(FriendlyNameSaveCTA);
        FriendlyNameSaveCTA.click();
    }

    @Override
    public void verifyFriendlyNameUpdatedScreen() {
        waitForVisibility(FriendlyNameUpdatingScreen);
        Assert.assertEquals(FriendlyNameUpdatingScreen.getText(),"Your plan name has been updated");
    }

    @Override
    public void closeUpdatingScreen() {
        UpdatingScreenClosCTA.click();
    }

    @Override
    public void verifyFriendlyNamePendingScreen() {
        waitForVisibility(FriendlyNamePendingScreen);
        Assert.assertEquals(FriendlyNamePendingScreen.getText(),"Your name update is currently pending");
    }

    @Override
    public void enterInvalidFriendlyName() {
        waitForVisibility(FriendlyNameText);
        FriendlyNameText.clear();
        FriendlyNameText.sendKeys(" test ");
    }

    @Override
    public void verifyInvalidFriendlyNameMsg() {
        Assert.assertTrue(InvalidFriendlyNameMsg.getText().contains("less than"));
    }

    @Override
    public void clickOnSubsInfoContainer() {
        SubscriptionInfoContainer.click();
    }

    @Override
    public void validateFriendlyNameOverlay() {
        waitForVisibility(FriendlyNameText);
    }

}



