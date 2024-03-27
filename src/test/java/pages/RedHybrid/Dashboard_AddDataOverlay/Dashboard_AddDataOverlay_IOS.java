package pages.RedHybrid.Dashboard_AddDataOverlay;

import models.response.common.ListExtrasResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ListExtrasUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static utils.element_helpers.TextHelpers.GetXpath;
import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Dashboard_AddDataOverlay_IOS extends Dashboard_AddDataOverlay_Abstract {
    ListExtrasResponseModel listExtrasResponseModel;
    ArrayList<String> actualDataNames;
    String expectedTitle;
    String actualTitle;
    String expectedSubTitle;
    String actualSubTitle;


    public Dashboard_AddDataOverlay_IOS() {
        super();
    }


    @Override
    public void clickOnAddDataTileFromDashboard() throws InterruptedException {
        waitForVisibility(AddDashboardDataTile);
        AddDashboardDataTile.click();

    }

    @Override
    public void assertThatAddDataOverlayShouldBeDisplayed() {
        waitForVisibility(AddDataTitle);
        AssertDisplayed(AddDataTitle.isDisplayed());


    }

    @Override
    public void assertThatAddDataOverlayUIShouldBeDisplayedCorrectly() {
        waitForVisibility(addingDataCTA);

        Map<String, String> queryParameters;
        queryParameters = new HashMap<String, String>() {{

            put("extraType", "Data");
        }};
        Map<String, String> headers;
        headers = new HashMap<String, String>() {{

        }};
        listExtrasResponseModel = ListExtrasUtils.getListExtras(headers ,queryParameters);

        expectedTitle = listExtrasResponseModel.categories.get(0).addonCategoryInfo.title;
        actualTitle = screenTitle.getText();
        Assert.assertEquals(actualTitle, expectedTitle);

        expectedSubTitle = listExtrasResponseModel.categories.get(0).addonCategoryInfo.subTitle;
        actualSubTitle = addDataExtraTitle.getText();
        Assert.assertEquals(actualSubTitle, expectedSubTitle);

        actualDataNames = actualavailableData(listExtrasResponseModel);

        WebElement firstElement = driver.findElement(By.id("SelectExtraOverlyChooseExtraView_0"))
                .findElement(By.name("imgDrawerAddNewPlanSubIcon"));

        Assert.assertTrue(firstElement.isEnabled());

        for(int i=0;i<actualDataNames.size();i++) {
            String Data = driver.findElement(By.xpath(GetXpath(actualDataNames.get(i)))).getText();
            Assert.assertEquals(actualDataNames.get(i),Data);
        }
        AssertDisplayed(addingDataCTA.isDisplayed());
    }

    public ArrayList<String> actualavailableData(ListExtrasResponseModel listExtrasResponse) {
        ArrayList<String> DataNames = new ArrayList<>();
        int DataNumber = listExtrasResponse.categories.get(0).addonCategoryInfo.addonList.size();
        for (int i = 0; i < DataNumber; i++) {
            DataNames.add(i, listExtrasResponse.categories.get(0).addonCategoryInfo.addonList.get(i).name);
        }
        return DataNames;
    }
}