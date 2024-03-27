package pages.RedHybrid.Dashboard_ExtrasList_overlay;

import models.response.common.ListExtrasResponseModel;
import org.openqa.selenium.By;
import org.testng.Assert;
import utils.ListExtrasUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.ScrollHelpers.androidScrollToElement;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Dashboard_ExtrasList_Overlay_Android_Logic extends Dashboard_ExtrasList_Overlay_Abstract {
    ListExtrasResponseModel listExtrasResponseModel;
    String expectedTitle;
    String actualTitle;
    String expectedSubTitle;
    String actualSubTitle;
    ArrayList<String> extrasNames;
    String expectedExtra;


    public Dashboard_ExtrasList_Overlay_Android_Logic() {
        super();
    }

    @Override
    public void addExtrasTileClick() throws InterruptedException {
        androidScrollToElement(addExtrasTile, "down");
        waitForVisibility(addExtrasTile);
        addExtrasTile.click();
        waitForVisibility(addExtrasOverlayTitle);
    }

    @Override
    public void addExtrasOverlayAppears() {
        try {
            AssertDisplayed(addExtrasOverlaySubtitle.isDisplayed());
        } catch (Exception e) {
            System.out.println("screen did not opened");
        }
    }

    @Override
    public void addExtrasOverlayUIValidation() {
        extrasNames = new ArrayList<String>();
        //API call
        Map<String, String> headers;
        headers = new HashMap<String, String>() {{
        }};
        Map<String, String> queryParameters;
        queryParameters = new HashMap<String, String>() {{
        }};

//API call
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers ,queryParameters);
        String responseText = listExtrasResponseModel.categories.get(0).text;
        //get the list of extras
        extrasNames = extras(listExtrasResponseModel);
        //assert on screen Title
        expectedTitle = addExtrasOverlayTitle.getText();
        actualTitle = listExtrasResponseModel.title;
        Assert.assertEquals(actualTitle, expectedTitle);
        //assert on screen subTitle
        expectedSubTitle = addExtrasOverlaySubtitle.getText();
        actualSubTitle = listExtrasResponseModel.description;
        Assert.assertEquals(actualSubTitle, expectedSubTitle);

        //assert on screen extras
        for (int i = 0; i < extrasNames.size(); i++) {
            expectedExtra = extrasList.findElements(By.className("android.widget.TextView")).get(i).getText();
            Assert.assertEquals(extrasNames.get(i), expectedExtra);
        }

    }


    public ArrayList<String> extras(ListExtrasResponseModel listExtrasResponse) {
        int extrasNumber = listExtrasResponse.categories.size();
        ArrayList<String> extrasNames = new ArrayList<String>();
        for (int i = 0; i < extrasNumber; i++) {
            extrasNames.add(i, listExtrasResponse.categories.get(i).text);
        }
        return extrasNames;
    }


}
