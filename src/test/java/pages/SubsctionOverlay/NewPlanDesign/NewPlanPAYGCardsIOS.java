package pages.SubsctionOverlay.NewPlanDesign;

import testdata.ReadResponse;

import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.ScrollHelpers.scrollUp;
import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.TextHelpers.getElementByText;
import static utils.element_helpers.VerifyHelpers.AssertResult;
import static utils.element_helpers.WaitHelpers.waitForVisibility;
public class NewPlanPAYGCardsIOS extends NewPlanPAYGCardsAbstract {

    public NewPlanPAYGCardsIOS() {
        super();
    }

    public void WVXIconCTAPlan() {
        WV_Xicon.click();
        waitForVisibility(PlanTitle);
    }

    public void ValidateNewPlanPageForPAYG() {
        scrollUp();
        assertPlanDetailsTextPAYG();
        scrollUp();
    }

    public void assertPlanDetailsTextPAYG() {
        HashMap<String, String> planPage = ReadResponse.GetNewPlanPageForPAYG();
        for (String name : planPage.values()) {
            scrollDownTo(name);
            try {
                waitForVisibility(getElementByText(GetXpath(name)));
                System.out.println("expect " + getElementByText(GetXpath(name)).getText() + " & found " + name);
                AssertResult(getElementByText(GetXpath(name)).getText(), name);
            } catch (Exception e) {
                System.out.println("Assertion Failed");
            }
        }
    }

    public void ValidateNewPlanPageOffersCardForBVB() {
        scrollUp();
        assertPlanDetailsOffersCardTextBVB();
        scrollUp();
    }

    public void assertPlanDetailsOffersCardTextBVB() {
        HashMap<String, String> planPage = ReadResponse.GetNewPlanOffersCardForBVB();
        for (String name : planPage.values()) {
            try {
                scrollDownTo(name);
                AssertResult(getElementByText(GetXpath(name)).getText(), name);
                System.out.println("expect " + getElementByText(GetXpath(name)).getText() + " & found " + name);
            } catch (Exception e) {
                System.out.println("Assertion Failed");
            }
        }
    }

    public void ValidateNewPlanPageForPAYGCTA() {
        scrollUp();
        assertPlanPageCTAPAYG();
        WVXIconCTATopUp();
        scrollUp();
    }

    public void assertPlanPageCTAPAYG() {
        HashMap<String, String> planPage = ReadResponse.GetNewPlanPageForPAYG();
        for (Map.Entry mapElement : planPage.entrySet()) {
            try {
                if (((String) mapElement.getKey()).contains("action")) {
                    scrollDownTo((String) mapElement.getValue());
                    System.out.println((String) mapElement.getValue());
                    getElementByText(GetXpath((String) mapElement.getValue())).click();
                    waitForVisibility(WV_Title);
                    AssertResult(WV_Title.getText(), "Big Value Bundle");
                }
            } catch (Exception e) {
                System.out.println("Assertion Failed");
            }
        }
    }

    public void WVXIconCTATopUp() {
        WV_Xicon.click();
        waitForVisibility(SO_TopUpTab);
    }

    public void ValidateNewPlanPageOffersCardCTAForBVB() {
        scrollUp();
        assertPlanDetailsOffersCardCTABVB();
        WVXIconCTAPlan();
        scrollUp();
    }

    public void assertPlanDetailsOffersCardCTABVB() {
        HashMap<String, String> planPage = ReadResponse.GetNewPlanOffersCardForBVB();
        for (Map.Entry mapElement : planPage.entrySet()) {
            try {
                System.out.println(((String) mapElement.getKey()));
                if (((String) mapElement.getKey()).contains("action")) {
                    scrollDownTo((String) mapElement.getValue());
                    getElementByText(GetXpath((String) mapElement.getValue())).click();
                    waitForVisibility(WV_Title);
                    AssertResult(WV_Title.getText(), "Offers for you");
                }
            } catch (Exception e) {
                System.out.println("Assertion Failed");
            }
        }
    }

    public void ValidateNewPlanPageForPAYG1Content(){
        waitForVisibility(Plan_PAYG1Title);
        AssertResult(Plan_PAYG1Title.getText(),"Pay as you go 1");
        AssertResult(Plan_PAYG1Desc.getText(),"You’ll pay just £1 each day you use your phone, which gives you unlimited minutes and texts, plus 50MB of data to use until midnight.");
        AssertResult(Plan_GetMoreBundleTitle.getText(),"Get more with a bundle");
        AssertResult(Plan_GetMoreBundleDesc.getText(),"If you’re looking for more data, you might want to switch to a Big Value Bundle. These 30-day bundles come packed with data, minutes and texts – and they’ll keep renewing as long as you have credit on your account.");
        AssertResult(Plan_GetMoreBundleCTA.getText(),"Buy a bundle");
        scrollDownTo(Plan_OffersForYouCTA);
        AssertResult(Plan_OffersForYouTitle.getText(),"Offers for you");
        AssertResult(Plan_OffersForYouDesc.getText(),"See your latest offers");
        AssertResult(Plan_OffersForYouCTA.getText(),"See my offers");
    }

    public void ValidateNewPlanPageForPAYG1CTAs(){
        waitForVisibility(Plan_PAYG1Title);
        scrollDownTo(Plan_GetMoreBundleCTA);
        Plan_GetMoreBundleCTA.click();
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "Big Value Bundle");
        WV_Xicon.click();

        waitForVisibility(Plan_GetMoreBundleCTA);
        scrollDownTo(Plan_OffersForYouCTA);
        Plan_OffersForYouCTA.click();
        waitForVisibility(WV_Title);
        AssertResult(WV_Title.getText(), "Offers for you");

    }
}
