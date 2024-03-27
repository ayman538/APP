package pages.OnePlatform_Tutorials;

import models.response.SegmentResponseModel;
import models.response.SubConfigResponseModel;
import utils.SegmentUtils;
import utils.SubConfigUtils;

import static core.Config.setTutorialsClosedStatus;
import static utils.element_helpers.ScrollHelpers.SwipeToElement;
import static utils.element_helpers.VerifyHelpers.*;
import static utils.element_helpers.WaitHelpers.waitForVisibility;

public class OnePlatform_TutorialAndroidLogic extends OnePlatform_TutorialAbstract{

    public SegmentResponseModel segmentResponseModel = SegmentUtils.GetSegment();
    public SubConfigResponseModel subConfigResponseModel = SubConfigUtils.getSubConfig();
    String tutorialTitle;
    String tutorialDescription;
    public OnePlatform_TutorialAndroidLogic(){
        super();
    }

    @Override
    public void checkFirstTutorial() {
        waitForVisibility(TUT_title);
        tutorialTitle = subConfigResponseModel.tutorials.items.get(0).title;
        tutorialDescription = subConfigResponseModel.tutorials.items.get(0).description;
        if(segmentResponseModel.segment.equalsIgnoreCase("PREPAY")){
            AssertDisplayed(TUT_video.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Close");        }
        else
        {
            AssertDisplayed(TUT_image.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Close");
        }

    }

    @Override
    public void checkSecondTutorial() {
        SwipeToElement(TUT_description,"Left");
        waitForVisibility(TUT_title);
        tutorialTitle = subConfigResponseModel.tutorials.items.get(1).title;
        tutorialDescription = subConfigResponseModel.tutorials.items.get(1).description;
        if (segmentResponseModel.segment.equalsIgnoreCase("PREPAY")){
            AssertDisplayed(TUT_image.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Close");
        }
        else {
            AssertDisplayed(TUT_video.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Close");        }

    }

    @Override
    public void checkThirdTutorial() {
        SwipeToElement(TUT_description,"Left");
        waitForVisibility(TUT_title);
        tutorialTitle = subConfigResponseModel.tutorials.items.get(2).title;
        tutorialDescription = subConfigResponseModel.tutorials.items.get(2).description;
        if (segmentResponseModel.segment.equalsIgnoreCase("PREPAY")){
            AssertDisplayed(TUT_video.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Go to my dashboard");

        }
        else {
            waitForVisibility(TUT_video);
            AssertDisplayed(TUT_video.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Close");
        }

    }

    @Override
    public void checkForthTutorial() {
        SwipeToElement(TUT_description,"Left");
        waitForVisibility(TUT_title);
        tutorialTitle = subConfigResponseModel.tutorials.items.get(3).title;
        tutorialDescription = subConfigResponseModel.tutorials.items.get(3).description;
        if (!segmentResponseModel.segment.equalsIgnoreCase("PREPAY")) {
            AssertDisplayed(TUT_video.isDisplayed());
            AssertResult(TUT_title.getText(),tutorialTitle);
            AssertResult(TUT_description.getText(),tutorialDescription);
            AssertDisplayed(TUT_pageIndicator.isDisplayed());
            AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
            AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Go to my dashboard");

        }

    }

    @Override
    public void closeTutorial() {
        waitForVisibility(TUT_closeGotoMyDasboardCTA);
        TUT_closeGotoMyDasboardCTA.click();

        waitForVisibility(DB_Tray_view);
        if (segmentResponseModel.segment.equalsIgnoreCase("PREPAY")){
            AssertDisplayed(DB_TopUpTray_icon.isDisplayed());
        }
        else {
            AssertDisplayed(DB_BillingTray_icon.isDisplayed());
        }

        setTutorialsClosedStatus();
    }
    @Override
    public void GoToDashboard() {
        if(elementIsPresent(RedHybrid_SkipLoginCTA)){
            RedHybrid_SkipLoginCTA.click();
        }
        waitForVisibility(DB_Tray_view);
        AssertDisplayed(DB_Tray_view.isDisplayed());
    }
    @Override
    public void checkRedHybridTutorialScreens() {
        int ScreenNumber=subConfigResponseModel.tutorials.items.size();

        for(int i=0 ;i<ScreenNumber;i++){
            waitForVisibility(TUT_title);
            tutorialTitle = subConfigResponseModel.tutorials.items.get(i).title;
            tutorialDescription = subConfigResponseModel.tutorials.items.get(i).description;
            if(i==ScreenNumber-1){
                AssertDisplayed(TUT_image.isDisplayed());
                AssertResult(TUT_title.getText(),tutorialTitle);
                AssertResult(TUT_description.getText(),tutorialDescription);
                AssertDisplayed(TUT_pageIndicator.isDisplayed());
                AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
                AssertResult(TUT_closeGotoMyDasboardCTA.getText(),"Go to my dashboard") ;
            }
            else {
                AssertDisplayed(TUT_image.isDisplayed());
                AssertResult(TUT_title.getText(), tutorialTitle);
                AssertResult(TUT_description.getText(), tutorialDescription);
                AssertDisplayed(TUT_pageIndicator.isDisplayed());
                AssertDisplayed(TUT_closeGotoMyDasboardCTA.isDisplayed());
                AssertResult(TUT_closeGotoMyDasboardCTA.getText(), "Close");
                SwipeToElement(TUT_description, "Left");
            }
        }
    }
    @Override
    public void CloseTutorial() {
        waitForVisibility(TUT_closeGotoMyDasboardCTA);
        TUT_closeGotoMyDasboardCTA.click();
        waitForVisibility(DB_Tray_view);
        AssertDisplayed(DB_PaymentIcon.isDisplayed());
    }



}
