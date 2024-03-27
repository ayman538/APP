package pages.OnePlatform_Tutorials;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import pages.Commons.CommonPo;

public class OnePlatform_TutorialPO extends CommonPo {

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_image"),
            @FindBy(how = How.ID, using = "tutorialImageView")
    })
    public WebElement TUT_image;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorialVideoView"),
            @FindBy(how = How.ID, using = "Video"),
            @FindBy(how= How.NAME,using = "Media")
    })
    public WebElement TUT_video;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_title"),
            @FindBy(how = How.ID, using = "tutorialTitleLabel")
    })
    public WebElement TUT_title;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_description"),
            @FindBy(how = How.ID, using = "tutorialDescriptionLabel")
    })
    public WebElement TUT_description;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_title"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialTitleLabel'])[2]")
    })
    public WebElement TUT_title2;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_description"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialDescriptionLabel'])[2]")
    })
    public WebElement TUT_description2;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_title"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialTitleLabel'])[3]")
    })
    public WebElement TUT_title3;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_description"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialDescriptionLabel'])[3]")
    })
    public WebElement TUT_description3;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_title"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialTitleLabel'])[4]")
    })
    public WebElement TUT_title4;

    @FindAll({
            @FindBy(how = How.ID, using = "tutorial_description"),
            @FindBy(how = How.XPATH, using = "(//*[@name='tutorialDescriptionLabel'])[4]")
    })
    public WebElement TUT_description4;

    @FindAll({
            @FindBy(how = How.ID, using = "bubblePageIndicator"),
            @FindBy(how = How.ID, using = "tutorialBubblePageIndicator")
    })
    public WebElement TUT_pageIndicator;

    @FindAll({
            @FindBy(how = How.ID, using = "PrimaryTutorialButton"),
            @FindBy(how = How.ID, using = "tutorialPrimaryButton")
    })
    public WebElement TUT_closeGotoMyDasboardCTA;

    public OnePlatform_TutorialPO(){super();}
}
