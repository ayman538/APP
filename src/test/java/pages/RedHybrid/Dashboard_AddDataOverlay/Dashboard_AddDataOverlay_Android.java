package pages.RedHybrid.Dashboard_AddDataOverlay;


import models.response.common.ListExtrasResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.ListExtrasUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.element_helpers.VerifyHelpers.AssertDisplayed;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class Dashboard_AddDataOverlay_Android extends Dashboard_AddDataOverlay_Abstract {
    ListExtrasResponseModel listExtrasResponseModel;
    ArrayList<String> actualDataNames;
    String expectedTitle;
    String actualTitle;
    String expectedSubTitle;
    String actualSubTitle;
    public Dashboard_AddDataOverlay_Android() {
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

        WebElement firstElement = listOfDataOptions.findElements(By.className("android.view.ViewGroup"))
                .get(0).findElement(By.className("android.widget.RadioButton"));
        Assert.assertTrue(firstElement.isSelected());
        List<WebElement> DataName = listOfDataOptions.findElements(By.className("android.view.ViewGroup"));
        for(int i=0;i<actualDataNames.size();i++) {

            String Data = DataName.get(i).findElement(By.className("android.widget.LinearLayout")).findElement(By.id("com.myvodafoneapp:id/dataItemName")).getText();
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
