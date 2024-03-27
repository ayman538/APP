package stepdefs.TC_Tray.TC_RewardsInTray;

import core.Config;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.Tray.Rewards.RewardsAbstract;
import pages.Tray.Rewards.RewardsLogicAndroid;
import pages.Tray.Rewards.RewardsLogicIOS;

public class Rewards {
    private RewardsAbstract rewardsAbstract;
    static boolean navigatedToDashboard = false;

    public Rewards(Config config){
        if (config.isAndroid()) rewardsAbstract = new RewardsLogicAndroid();
        if (config.isIos()) rewardsAbstract = new RewardsLogicIOS();
    }

    @Given("I click on Rewards")
    public void setupRewards() {
            rewardsAbstract.goToRewardsTray();
    }

    @Then("Validate Veryme Card")
    public void validateVerymeCard() {
        rewardsAbstract.checkVeryMeInRewardsTrayForPAYGMPS();
    }

    @Then("Click on veryme card")
    public void clickOnVeryme() throws InterruptedException {
        rewardsAbstract.clickVeryMeInDBTray();
    }

    @Then("Validate offers for you Card")
    public void validateOffersCard() {
        rewardsAbstract.checkOffersForYouInRewardsTray();
    }

    @Then("Click on offers for you")
    public void clickOnOffers() {
        rewardsAbstract.clickOnOffersForYou();
    }

    @Then("offers for you displayed")
    public void checkOffersForYouPage(){
        rewardsAbstract.checkClickingOffersForYou();
    }

    @Then("Veryme is displayed")
    public void checkVerymePage() throws InterruptedException {
       rewardsAbstract.checkVeryMeInRewards();
    }
}
