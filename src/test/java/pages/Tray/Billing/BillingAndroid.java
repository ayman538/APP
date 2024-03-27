package pages.Tray.Billing;

import models.response.BillHistoryResponseModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BillHistoryUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.element_helpers.ScrollHelpers.scrollDownTo;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class BillingAndroid extends BillingAbstract {
    BillHistoryResponseModel Billing= BillHistoryUtils.getBillHistory();
    public List<String> Titles() {
        List<String > elements = new ArrayList<>();
        for (int i=0 ; i<Billing.recentBills.size(); i++)
            elements.add(Billing.recentBills.get(i).title);
        return elements;
    }

    public List<WebElement> Bills() {
        List<WebElement> elements = new ArrayList<>();
        List<String> newList;
        newList = Titles();
        for (String TitleOfBill : newList)
            try{
                elements.add(driver.findElement(By.xpath("//*[@text='" + TitleOfBill + "']")));}
        catch (Exception e){
                scrollDownTo(TitleOfBill);
                elements.add(driver.findElement(By.xpath("//*[@text='" + TitleOfBill + "']")));
            }
        return elements;
    }

    @Override
    public void CheckBarChartDisplayed() {
        waitForVisibility(Billing_title);
        if(Billing.recentBills.size() >= 3)
            AssertDisplayed(Bill_Chart.isDisplayed());
        else {
            HardAssertNotDisplayed("Bill Chart",elementIsPresent(Bill_Chart));
            System.out.println("user has less than 3 bills");
        }
    }

    public void CheckViewAllCTAExistence() {
        HardAssertNotDisplayed("View All CTA",elementIsPresent(Bill_viewAllCTA));
        if (Billing.recentBills.size()>=6){
            scrollDownTo(Bill_DirectDebitCTA);
            HardAssertNotDisplayed("View All CTA",elementIsPresent(Bill_viewAllCTA));
        }
    }

    @Override
    public void ValidateBillsNumber() {
        List<String> Monthes;
        Monthes = Titles();
        List<WebElement> cardsOfBills;
        cardsOfBills = Bills();
        for (int i=0; i<Monthes.size(); i++){
            System.out.println(Monthes.get(i));
            System.out.println(cardsOfBills.get(i).getText());
            Assert.assertEquals(Monthes.get(i),cardsOfBills.get(i).getText());}
        }
    }
