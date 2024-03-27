package stepdefs.RedHybrid;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RedHybrid.AddExtrasAndData.AddExtrasAndData_Abstract;
import pages.RedHybrid.AddExtrasAndData.AddExtrasAndData_Android;
import pages.RedHybrid.AddExtrasAndData.AddExtrasAndData_IOS;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Abstract;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_Android;
import pages.RedHybrid.PaymentReminderOverlay.RedHybrid_PaymentReminderOverlay_IOS;

public class AddExtrasAndData
{
    private AddExtrasAndData_Abstract addExtrasAbstract ;
    private RedHybrid_PaymentReminderOverlay_Abstract redHybrid_paymentReminderOverlay_abstract;
    public AddExtrasAndData(Config config){
        if(config.isAndroid()){
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_Android();
            addExtrasAbstract = new AddExtrasAndData_Android();
        }
        if(config.isIos()){
            redHybrid_paymentReminderOverlay_abstract = new RedHybrid_PaymentReminderOverlay_IOS();
            addExtrasAbstract = new AddExtrasAndData_IOS();
        }
    }

    @When("User click on add data CTA")
    public void ClickOnAddDataDashboard ()
    {
        try {
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        } catch (Exception exception) {
            System.out.println("No overlay appeared");
        }
        addExtrasAbstract.ClickOnAddDataDashboard();
    }

    @Then("User should be redirected to an overlay informing him to add a payment card to add data")
    public void ValidateAddDataOverlay ()
    {
        addExtrasAbstract.ValidateAddDataOverlay();
    }
    @When("User click on add extras CTA")
    public void ClickOnAddExtras ()
    {
        try {
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        } catch (Exception exception) {
            System.out.println("No overlay appeared");
        }
        addExtrasAbstract.ClickOnAddExtras();
    }
    @Then("User should be redirected to an overlay informing him to add a payment card to add extras")
    public void ValidateAddExtrasOverlay ()
    {
        addExtrasAbstract.ValidateAddExtrasOverlay();
    }
    @And("user click on plan tile")
    public void ClickOnPlanTile ()
    {
        try {
            redHybrid_paymentReminderOverlay_abstract.clickOnBackToVodafoneCTA();
        } catch (Exception exception) {
            System.out.println("No overlay appeared");
        }
        addExtrasAbstract.ClickOnPlanTile();
    }
    @And("user click on extras tab")
    public void ClickOnExtrasTab ()
    {
        addExtrasAbstract.ClickOnExtrasTab();
    }
    @And("User click on add extras CTA in subs overlay")
    public void ClickOnAddExtrasSubsOverlay ()
    {
        addExtrasAbstract.ClickOnAddExtrasSubsOverlay();
    }
}