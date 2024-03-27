/*package pages.Dashboard.VOV;

import org.testng.SkipException;
import pages.SubsctionOverlay.TabMenuVariationPO;
import testdata.ReadResponse;

import java.util.LinkedHashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.SwipeBackForIOS;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

@Deprecated
public class VOVLogic extends VOVPO {

    public boolean furtherRoamingFlag = false;
    public boolean restOfWorldRoamingFlag = false;
    public boolean freeRoamingFlag = false;
    public boolean EuropeZoneFlag = false;
    public TabMenuVariationPO tabMenuVariationPO;
    public boolean lowCreditFlag = false;

    public VOVLogic() {
        super();
    }

    public void ValidateFurtherRoamingVOV() {
        if (furtherRoamingFlag) {
            assertFurtherRoamingCard();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertFurtherRoamingCard() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            if (((String) mapElement.getKey()).contains("Further")) {
                waitForVisibility(DB_VOVDescription);
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
            }
        }
    }

    public void ValidateFurtherRoamingVOVCTA() {
        if (furtherRoamingFlag) {
            assertFurtherRoamingCardCTA();
            WVXIconCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void WVXIconCTA() {
        WV_Xicon.click();
    }

    public void assertFurtherRoamingCardCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("action") && ((String) mapElement.getKey()).contains("Further")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(WV_Xicon);
                AssertDisplayed(WV_Xicon.isDisplayed());
                break;
            }
        }
    }

    public void ValidateEuropeRoamingVOV() {
        if (EuropeZoneFlag) {
            assertEuropeRoamingCard();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertEuropeRoamingCard() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            if (((String) mapElement.getKey()).contains("Europe")) {
                waitForVisibility(DB_VOVDescription);
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
            }
        }
    }

    public void ValidateEuropeRoamingVOVCTA() {
        if (EuropeZoneFlag) {
            assertEuropeRoamingCardCTA();
            WVXIconCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertEuropeRoamingCardCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("Europe") && ((String) mapElement.getKey()).contains("action")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(WV_Xicon);
                AssertDisplayed(WV_Xicon.isDisplayed());
                break;
            }
        }
    }

    public void ValidateFreeRoamingVOV() {
        if (freeRoamingFlag) {
            assertFreeRoamingCard();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertFreeRoamingCard() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("Free")) {
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
            }
        }
    }

    public void ValidateFreeRoamingVOVCTA() {
        if (freeRoamingFlag) {
            assertFreeRoamingCardCTA();
            WVXIconCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertFreeRoamingCardCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("Free") && ((String) mapElement.getKey()).contains("action")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(WV_Xicon);
                AssertDisplayed(WV_Xicon.isDisplayed());
                break;
            }
        }
    }

    public void ValidateRestOfWorldRoamingVOV() {
        if (restOfWorldRoamingFlag) {
            assertRestWorldRoamingCard();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertRestWorldRoamingCard() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("Rest")) {
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
            }
        }
    }

    public void ValidateRestOfWorldRoamingVOVCTA() {
        if (restOfWorldRoamingFlag) {
            assertRestWorldRoamingCardCTA();
            WVXIconCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertRestWorldRoamingCardCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("Rest") && ((String) mapElement.getKey()).contains("action")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(WV_Xicon);
                AssertDisplayed(WV_Xicon.isDisplayed());
                break;
            }
        }
    }

    public void ValidateLowCreditVOV() {
        if (lowCreditFlag) {
            assertLowCreditCard();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertLowCreditCard() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("low")) {
                AssertResult(driver.findElementByXPath(GetXpath((String) mapElement.getValue())).getText(), (String) mapElement.getValue());
            }
        }
    }

    public void ValidateLowCreditVOVTopUpCTA() {
        if (lowCreditFlag) {
            assertLowCreditCardCTA();
            SO_Xicon.click();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertLowCreditCardCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getValue()).contains("Top up now")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(SO_TopUpTab);
                AssertDisplayed(SO_TopUpTab.isDisplayed());
                break;
            }
        }
    }

    public void ValidateLowCreditVOVCloseCTA() {
        if (lowCreditFlag) {
            assertLowCreditCardCloseCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertLowCreditCardCloseCTA() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVCount);
            if (((String) mapElement.getValue()).contains("Close")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                if (DB_VOVCount.getText().isEmpty()) {
                    waitForVisibility(DB_VOVnoAlertText);
                    AssertDisplayed(DB_VOVnoAlertText.isDisplayed());
                } else {
                    waitForVisibility(DB_VOVDescription);
                    AssertDisplayed(DB_VOVDescription.isDisplayed());
                }
                break;
            }
        }
    }

    public void ValidateSecondVOV() {
        waitForVisibility(DB_VOVDescription);
        if (lowCreditFlag && DB_VOVCount.getText().equalsIgnoreCase("2")) {
            SwipeToElement(DB_VOVDescription, "Right");
            ValidateFurtherRoamingVOV();
            SwipeToElement(DB_VOVDescription, "Left");
        }
    }

    public void ValidateSecondVOVCTA() {
        waitForVisibility(DB_VOVDescription);
        if (lowCreditFlag && DB_VOVCount.getText().equalsIgnoreCase("2")) {
            SwipeToElement(DB_VOVDescription, "Right");
            ValidateFurtherRoamingVOVCTA();
            SwipeToElement(DB_VOVDescription, "Left");
        }
    }

    public void ValidateHideCTA() {
        assertVOVDescriptionDisplayedAfterHideCTA();
    }

    public void assertVOVDescriptionDisplayedAfterHideCTA() {
        waitForVisibility(DB_VOVhideCTA);
        if (DB_VOVhideCTA.isDisplayed()) {
            DB_VOVhideCTA.click();
            AssertDisplayed(!(DB_VOVDescription.isEnabled()));
        }
    }

    public void ValidateCloseCTAForHidingVOV() {
        assertVOVDescriptionDisplayedAfterCountCTA();
    }

    public void assertVOVDescriptionDisplayedAfterCountCTA() {
        waitForVisibility(DB_VOVhideCTA);
        if (DB_VOVhideCTA.isDisplayed()) {
            DB_VOVCount.click();
            AssertDisplayed(!(DB_VOVDescription.isDisplayed()));
        }
    }

    public void ValidateCloseCTAForShowingVOV() {
        waitForVisibility(DB_VOVCount);
        showVOV();
        AssertDisplayed(DB_VOVDescription.isDisplayed());
    }

    public void showVOV() {
        if (DB_VOVhideCTA.isDisplayed()) {
            DB_VOVCount.click();
            DB_VOVCount.click();
        } else {
            DB_VOVCount.click();
        }
    }

    public void ValidateNoAlert() {
        waitForVisibility(DB_VOVCount);
        if (lowCreditFlag && DB_VOVCount.getText().equalsIgnoreCase("1")) {
            DB_VOVCloseCTA.click();
            AssertDisplayed(DB_VOVnoAlertText.isDisplayed());
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void setFurtherRoamingFlag() {
        furtherRoamingFlag = true;
    }

    public void setRestOfWorldRoamingFlag() {
        restOfWorldRoamingFlag = true;
    }

    public void setFreeRoamingFlag() {
        freeRoamingFlag = true;
    }

    public void setEuropeZoneFlag() {
        EuropeZoneFlag = true;
    }

    public void setLowCreditFlag() {
        if (ReadResponse.GetPAYGBalance().contains("0.00"))
            lowCreditFlag = true;
    }

    public void ValidateSwipeBack() {
        if (furtherRoamingFlag) {
            assertWVXIconDisplayedAfterSwipeBack();
            WVXIconCTA();
        } else {
            throw new SkipException("This is not the correct roaming area");
        }
    }

    public void assertWVXIconDisplayedAfterSwipeBack() {
        LinkedHashMap<String, String> VOVs = ReadResponse.GetVOVNotifications();
        for (Map.Entry mapElement : VOVs.entrySet()) {
            waitForVisibility(DB_VOVDescription);
            if (((String) mapElement.getKey()).contains("action") && ((String) mapElement.getKey()).contains("Further")) {
                driver.findElementByXPath(GetXpath((String) mapElement.getValue())).click();
                waitForVisibility(WV_Xicon);
                SwipeBackForIOS();
                AssertDisplayed(WV_Xicon.isDisplayed());
                break;
            }
        }
    }


}
 */