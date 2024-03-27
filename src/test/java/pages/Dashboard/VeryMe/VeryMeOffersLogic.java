//package pages.Dashboard.VeryMe;
//
//import models.response.VeryMeResponseModel;
//import org.json.simple.parser.ParseException;
//import org.openqa.selenium.Point;
//import utils.VeryMeUtils;
//
//import java.util.List;
//import java.util.Properties;
//
//import static utilities.PropertiesLoader.readPropertyFile;
//
//
//@Deprecated
//public class VeryMeOffersLogic extends VeryMeOffersPO {
//
//    public List<VeryMeResponseModel.Item> VeryMeOffers = null;
//    private static VeryMeResponseModel VeryMeResponse;
//    static boolean run = false;
//
//    public VeryMeOffersLogic() {
//        super();
//        Properties envProp = readPropertyFile("config/env.properties");
//        String UI = System.getProperty("UI", envProp.getProperty("UI"));
//        String UFL = System.getProperty("UFL", envProp.getProperty("UFL"));
//        if (!run && UI.equalsIgnoreCase("new")
//                && UFL.equalsIgnoreCase("3g")) {
//            waitForVisibility(DX_IDM_SkipLoginCTA);
//            DX_IDM_SkipLoginCTA.click();
//            run = true;
//        }
//    }
//
//    public void ValidateOfferImage() throws ParseException {
//
//        System.out.println(("Given validate the offer Image"));
//        GetResponse();
//        if (VeryMeOffers == null || VeryMeOffers.size() == 0) {
//            assertCarouselVeryMeImgDisplayed();
//        } else {
//            //TODO
//            System.out.println("Else the very me offer not equal 0");
//
//        }
//    }
//
//    public void assertCarouselVeryMeImgDisplayed() {
//        System.out.println("if the very me offers is null and size = 0 ");
//        AssertDisplayed(DB_CarouselVeryMe_Image.isDisplayed());
//        System.out.println(" The image of the very me displayed successfully");
//    }
//
//    public void ValidateOfferTitle() throws ParseException {
//
//        System.out.println("Given Validate the very me offer title");
//        GetResponse();
//        if (VeryMeOffers == null || VeryMeOffers.size() == 0) {
//            assertCarouselVeryMeText();
//        } else {
//            //TODO
//            System.out.println("Else the very me offer not equal null or size equal 0 ");
//        }
//    }
//
//    public void assertCarouselVeryMeText() {
//        System.out.println("If the very me offers is equal null or the my offer size = 0 ");
//        AssertResult(DB_CarouselVeryMe_text.getText(), "A world of rewards built around what you love");
//        System.out.println("Should the very me text displayed successfully with A world of rewards built around what you love");
//    }
//
//    public void ValidateOfferLogo() throws ParseException {
//
//        System.out.println("Given to validate the offer logo ");
//        GetResponse();
//        if (VeryMeOffers == null || VeryMeOffers.size() == 0) {
//            assertCarouselVeryMeLogoDisplayed();
//        } else {
//            //TODO
//            System.out.println("Check else the very me offer not equal null and very me offer size not equal 0");
//        }
//    }
//
//    public void assertCarouselVeryMeLogoDisplayed() {
//        System.out.println("Check if the very me offer is equal null and size is equal 0");
//        AssertDisplayed(DB_CarouselVeryMe_logo.isDisplayed());
//        System.out.println("should the very me logo displayed ");
//    }
//
//    public void ValidateOfferIsOpened() throws InterruptedException, ParseException {
//        System.out.println("Given Validate offer IS Opened ");
//        GetResponse();
//        if (VeryMeOffers == null || VeryMeOffers.size() == 0) {
//            carouselVeryMeImgCTA();
//            assertLassieDisplayed();
//            lassieCTA();
//        } else {
//            //TODO
//            System.out.println("Else the very me offer not null and the size not equal 0");
//        }
//    }
//
//    public void lassieCTA() throws InterruptedException {
//        Thread.sleep(6000);
//        Point location = DB_Lassie.getLocation();
//        tapAtt(location.x - 50, location.y);
//        System.out.println("Tab on the back button ");
//        waitForVisibility(DB_SettingDashboardTray_icon);
//        System.out.println(" wait till the dashboard displayed successfully ");
//    }
//
//    public void assertLassieDisplayed() {
//        waitForVisibility(DB_Lassie);
//        System.out.println("Wait till the lassie displayed ");
//        AssertDisplayed(DB_Lassie.isDisplayed());
//        System.out.println("should the web page displayed successfully ");
//    }
//
//    public void carouselVeryMeImgCTA() {
//        System.out.println("Check if the very me offer is equal null and the very me offer size is equal 0");
//        DB_CarouselVeryMe_Image.click();
//        System.out.println("Click on very me image ");
//    }
//
//    public void GetResponse() {
//        VeryMeResponse = VeryMeUtils.getVeryMe();
//        try {
//            VeryMeOffers = VeryMeResponse.veryMeOffers.items;
//        }
//        catch (Exception e){
//            System.out.println("The user not has very me offers");
//        }
//        waitForVisibility(DB_SettingDashboardTray_icon);
//        scrollDownTo(DB_CarouselVeryMe_logo);
//    }
//
//}
