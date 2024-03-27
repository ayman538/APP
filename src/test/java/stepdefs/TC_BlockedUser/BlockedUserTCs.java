package stepdefs.TC_BlockedUser;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BlockedUser.BlockedUserLogic;

import java.io.IOException;

public class BlockedUserTCs {

    BlockedUserLogic blockedUserLogic;

    @Given("Init Blocked User")
    public void setBeforeClass() throws IOException {
        blockedUserLogic = new BlockedUserLogic();
    }

    @Then("Validate Cant Use Card Title")
    public void ValidateCantUseCardTitle() {
        blockedUserLogic.ValidateCantUseCardTitle();
    }

    @Then("Validate Cant Use Card Text")
    public void ValidateCantUseCardText() {
        blockedUserLogic.ValidateCantUseCardText();
    }

    @Given("Go to FAQs")
    public void FAQsCTA() {
        blockedUserLogic.FAQsCTA();
    }

    @Then("Validate Cant Use Card")
    public void ValidateCantUseCardCTAText() {
        blockedUserLogic.ValidateCantUseCardCTAText();
    }

    @Then("Validate Cant Use Card CTA")
    public void ValidateCantUseCardCTA() {
        blockedUserLogic.ValidateCantUseCardCTA();
    }

    @Then("Validate Settings Card Title")
    public void ValidateSettingCardTitle() {
        blockedUserLogic.ValidateSettingCardTitle();
    }

    @Then("Validate Setting Card Text")
    public void ValidateSettingCardText() {
        blockedUserLogic.ValidateSettingCardText();
    }

    @Then("Validate Settings Card CTA Text")
    public void ValidateSettingCardCTAText() {
        blockedUserLogic.ValidateSettingCardCTAText();
    }

    @Given("Go To Settings")
    public void SettingCTA() {
        blockedUserLogic.SettingCTA();
    }

    @Then("Validate Settings Card CTA")
    public void ValidateSettingCardCTA() {
        blockedUserLogic.ValidateSettingCardCTA();
    }
}
