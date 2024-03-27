package stepdefs.TC_SubscriptionOverlay;

import core.Config;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pages.SubsctionOverlay.B2B_ChevronViewOfLoans.ChevronViewOfLoansAbstract;
import pages.SubsctionOverlay.B2B_ChevronViewOfLoans.ChevronViewOfLoansAndroid;
import pages.SubsctionOverlay.B2B_ChevronViewOfLoans.ChevronViewOfLoansIOS;

public class B2B_ChevronViewOfLoans {
    ChevronViewOfLoansAbstract chevronView;

    public B2B_ChevronViewOfLoans(Config config){
        if (config.isAndroid()) chevronView = new ChevronViewOfLoansAndroid();
        if (config.isIos()) chevronView = new ChevronViewOfLoansIOS();
    }
    
    @Then ("Validate the chevron icon functionality of first loan")
        public void checkFunctionalityOfChevronView(){
            chevronView.validateChevronIconFunctionalityofFirstLoan();
        }

    @Then("check that the chevron icon not exist")
    public void checkThatTheChevronIconNotExist() {
        chevronView.validateChevronIconnotdisplayed();
    }

    @And("Validate the chevron icon functionality of second loan")
    public void validateTheChevronIconFunctionalityOfSecondLoan() {
        chevronView.validateChevronIconFunctionalityofSecondLoan();
    }
}
