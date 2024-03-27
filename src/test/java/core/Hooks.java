package core;

import com.google.common.collect.ImmutableMap;
import core.drivers_initializer.drivers.AppiumMobileDriver;
import core.drivers_initializer.instance.MobileDriverInstance;
import enums.DXIDM;
import enums.DXIDMPAYLOAD;
import enums.IDJOURNEYS;
import helpers.CleanObject;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestRunFinished;
import models.response.AppConfigResponseModel;
import models.response.IDTokenResponseModels;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.DevSettings.DevSettings;
import pages.DevSettings.DevSettingsAndroid;
import pages.DevSettings.DevSettingsiOS;
import pages.Welcome.WelcomeLogicAbstract;
import pages.Welcome.WelcomeLogicAndroid;
import pages.Welcome.WelcomeLogic_IOS;
import utils.*;

import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static core.Config.*;
import static stepdefs.DX_IDM.FullLogin.LoginState;
import static utilities.PropertiesLoader.readPropertyFile;
import static utils.element_helpers.DriverHelps.startActivity;
import static utils.element_helpers.GenericHelpers.navigateToURL;

public class Hooks {
    public static AppiumMobileDriver appiumMobileDriver;
    private static AppiumDriver driver;
    private static SoftAssertions softAssert;
    private final Config config = new Config();
    private WelcomeLogicAbstract welcomeLogic;
    private DevSettings devSettings;


    public Hooks() {
        setDriver(driver);
        //driver = appiumMobileDriver.getDriver();
        softAssert = new SoftAssertions();
    }

    public static SoftAssertions getSoftAssert() {
        return softAssert;
    }

    public static AppiumDriver getDriver() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        return driver;
    }

    private static void setDriver(AppiumDriver driver) {
        Hooks.driver = driver;
    }

    public static void embedScreenshot(Scenario scenario) {
        try {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "embedScreenShot");
        } catch (WebDriverException | NullPointerException e) {
            System.out.println("Failed to take embed Screenshot");
        }
    }

    public static void teardown() {
        driver.quit();
    }

    public static void getFinalResult(TestRunFinished event) {
        Properties browserStackProp1 = readPropertyFile("config/env.properties");
        if (System.getProperty("browserStackRun", browserStackProp1.getProperty("browserStackRun")).equalsIgnoreCase("true")) {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            Result result = event.getResult();
            if (result.getStatus().toString().toLowerCase().equals("passed")) {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"Results found!\"}}");
            } else {
                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\":\"failed\", \"reason\": \"See logs and Screenshots\"}}");
            }

        }
    }

    public static void returnToDashboard() {
        String deepLinkURL;
        if (getPlatformType().equalsIgnoreCase("Android")) {
            if (!getUnknownUser().equalsIgnoreCase("True")) {
                navigateToURL("myvodafone://HOME");
            } else {
                navigateToURL("myvodafone://dashboard");
            }
            System.out.println("========/n Return to the dashborad /n===========");
            try {
                driver.switchTo().alert().dismiss();
            } catch (Exception e) {
                System.out.println("No Alert");
            }
        } else {
            if (!getUnknownUser().equalsIgnoreCase("True")) {
                deepLinkURL = "myvodafone://HOME";
            } else {
                deepLinkURL = "myvodafone://dashboard";
                System.out.println("Basic dashboard");
            }
            System.out.println("========/n Return to the dashborad /n===========");
            By safariURLBarSelector = By.xpath("//XCUIElementTypeTextField[@name='TabBarItemTitle']");
            By safariURLTextSelector = By.xpath("//XCUIElementTypeTextField[@name='URL']");
            ((RemoteWebDriver) driver).executeScript("mobile: terminateApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
            ((RemoteWebDriver) driver).executeScript("mobile: launchApp", ImmutableMap.of("bundleId", "com.apple.mobilesafari"));
            ((RemoteWebDriver) driver).findElement(safariURLBarSelector).click();
            ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(deepLinkURL);
            ((RemoteWebDriver) driver).findElement(safariURLTextSelector).sendKeys(Keys.ENTER);
            ((RemoteWebDriver) driver).manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            ((RemoteWebDriver) driver).findElement(By.id("Open")).click();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
            try {
                driver.switchTo().alert().dismiss();
            } catch (Exception e) {
                System.out.println("No Alert");
            }


//            driver.launchApp();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }

    // TODO to be removed
    public static void testAfterLastScenario() {
//        if (getUFLStatus().equalsIgnoreCase("3g")) {
//            System.out.println("if the UFL status is equal false");
//            returnToDashboard();
//            try {
//                driver.switchTo().alert().dismiss();
//            } catch (Exception e) {
//                System.out.println("No Alert");
//            }
//            System.out.println("The test case is finished and the back to dashboard ");
//        } else {
//            System.out.println("if the UFL status Equal True");
//            driver.navigate().back();
//        }
    }

    @Before(order = 1)
    public void beforeAll(Scenario scenario) throws MalformedURLException, InterruptedException {
        Properties envProp = readPropertyFile("config/env.properties");
        Properties apiURL = readPropertyFile("config/api-url.properties");
        if (getNeedAPIHooks().equalsIgnoreCase("true")) {
            try {
                if (System.getProperty("LOA1Token") == null && System.getProperty("isLiveTest",envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")) {
                    IDTokenResponseModels idTokenResponseModels = DXIDMUtils.getLOA1TokenModel(System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
                    System.setProperty("LOA1Token", idTokenResponseModels.loaToken);
                    System.setProperty("LOA1AccountId", idTokenResponseModels.accountId);
                    System.out.println(idTokenResponseModels.loaToken);
                    System.out.println("MSISDN:   "+ System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
                    System.out.println("API URL:   "+ System.getProperty("url", apiURL.getProperty("url")));
                }
                if (System.getProperty("LOA3Token") == null && System.getProperty("PINLogin",envProp.getProperty("PINLogin")).equalsIgnoreCase("true")) {
                    AppConfigResponseModel AppconfRes = new AppConfigResponseModel();
                    AppconfRes = AppConfigUtils.getAppConfig();
                    String encryptedMessage = PinEncryption.encryptWithCertificate(AppconfRes.startupSettings.pinEncryptionCertificate, System.getProperty("PIN",envProp.getProperty("PIN")));
                    Map<DXIDMPAYLOAD, Object> targetAndQueryPin;
                    targetAndQueryPin = ContentUtils.GetTargetAndQueryParameters(IDJOURNEYS.FULL_LOGIN_WITH_PIN);
                    HashMap PINquery = CleanObject.getObjectAsMap(targetAndQueryPin.get(DXIDMPAYLOAD.QUERY));
                    PINquery.put("login_hint",envProp.getProperty("username"));
                    PINquery.put("acr_values", "LOA:3 " + " deviceId:0d79ccf1-ff4a-41dc-b754-ed8c93ff9496 "+"pin:"+encryptedMessage);
                    if(envProp.getProperty("isLiveTest").equalsIgnoreCase("True")){
                        PINquery.put("acr_values", "LOA:3 " + " deviceId:"+System.getProperty("DeviceUID",envProp.getProperty("DeviceUID")) +" pin:"+encryptedMessage);
                    }
                    Map<DXIDM, String> PincodeWithCorrelation = DXIDMUtils.LOA1DXIDMRequest(targetAndQueryPin.get(DXIDMPAYLOAD.TARGET).toString(), PINquery);
                    String code = PincodeWithCorrelation.get(DXIDM.CODE);
                    IDTokenResponseModels idTokenResponseModels = IdTokenUtils.GetIdToken(code);
                    System.out.println(idTokenResponseModels.loaToken);
                    System.setProperty("LOA3Token", idTokenResponseModels.loaToken);
                    System.setProperty("LOA3AccountId", idTokenResponseModels.accountId);
                }
                if (System.getProperty("LOA3Token") == null && System.getProperty("PINLogin",envProp.getProperty("PINLogin")).equalsIgnoreCase("false")) {
                    IDTokenResponseModels idTokenResponseModels = DXIDMUtils.getLOA3TokenModel(System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
                    System.setProperty("LOA3Token", idTokenResponseModels.loaToken);
                    System.setProperty("LOA3AccountId", idTokenResponseModels.accountId);
                    System.out.println(idTokenResponseModels.loaToken);
                }

            } catch (Exception e) {
                System.out.println("Could Not Get LOA1 OR LOA3 Tokens");
                System.out.println("MSISDN:   " + System.getProperty("MSISDN", envProp.getProperty("MSISDN")));
                System.out.println("API URL:   " + System.getProperty("url", apiURL.getProperty("url")));
            }

        }


        if (!scenario.getId().contains("SeparateFeature_NormalWelcomeFlow")) {
            if (driver == null) {
                appiumMobileDriver = MobileDriverInstance.getAppiumMobileDriver();
                appiumMobileDriver.setup();
                setDriver(appiumMobileDriver.getDriver());
                if (getCleanStatus().equalsIgnoreCase("True")) {
                    appiumMobileDriver.resetApp();
                    startActivity();
                    if (config.isAndroid()) devSettings = new DevSettingsAndroid();
                    if (config.isIos()) devSettings = new DevSettingsiOS();
                    if (System.getProperty("isLiveTest", envProp.getProperty("isLiveTest")).equalsIgnoreCase("false")) {
                        devSettings.setDevSetting();
                    }
                    if (config.isAndroid()) welcomeLogic = new WelcomeLogicAndroid();
                    if (config.isIos()) welcomeLogic = new WelcomeLogic_IOS();
                    welcomeLogic.WelcomeFlow();
                }
            }
        }
    }


    //Used for DX IDM Welcome Flow Tests
    @Before("@SeparateFeatureWelcomeFlowTests")
    public void beforeDXIDMWelcomeFlowTests() throws MalformedURLException, InterruptedException {
        appiumMobileDriver = MobileDriverInstance.getAppiumMobileDriver();
        appiumMobileDriver.setup();
        setDriver(appiumMobileDriver.getDriver());
        if (config.isAndroid()) devSettings = new DevSettingsAndroid();
        if (config.isIos()) devSettings = new DevSettingsiOS();
        devSettings.setDevSetting();
    }
    @Before("@UFLDXIDM")
    public void beforeDXIDMWelcomeFlowTest() throws MalformedURLException, InterruptedException {
        LoginState = false;
        appiumMobileDriver = MobileDriverInstance.getAppiumMobileDriver();
        appiumMobileDriver.setup();
        setDriver(appiumMobileDriver.getDriver());
        if (config.isAndroid()) devSettings = new DevSettingsAndroid();
        if (config.isIos()) devSettings = new DevSettingsiOS();
        devSettings.setDevSetting();
        if (config.isAndroid()) welcomeLogic = new WelcomeLogicAndroid();
        if (config.isIos()) welcomeLogic = new WelcomeLogic_IOS();
        welcomeLogic.WelcomeFlow();
    }
    //Used for Tutorial Tests
    @Before("@OnePlatfrom_Tutorial")
    public void beforeOnePlatfrom_Tutorial(Scenario scenario) throws MalformedURLException, InterruptedException {
        //driver.resetApp();
        //factory = new DriverFactory(config.getUrl(), config.getCapabilities());
        //setDriver(factory.createDriver());
        if (config.isAndroid()) devSettings = new DevSettingsAndroid();
        if (config.isIos()) devSettings = new DevSettingsiOS();
        devSettings.SaveandRestart();
        if (scenario.getId().contains("DX_IDM") || getUFLStatus().equalsIgnoreCase("3g")) {
            if (config.isAndroid()) welcomeLogic = new WelcomeLogicAndroid();
            if (config.isIos()) welcomeLogic = new WelcomeLogic_IOS();
            welcomeLogic.WelcomeFlow();
        }
    }


    public void clearAllureReport() throws IOException {
        String[] cmd = {"allure", "generate", "--clean", "--output", "allure-results"};
        Runtime.getRuntime().exec(cmd);
    }

    public void publishAllureReport() throws IOException, InterruptedException {
        String[] cmd = {"allure", "serve", "allure-results"};
        Runtime.getRuntime().exec(cmd);
        Thread.sleep(90000);
    }


    @After
    public void afterAll1(Scenario scenario) {
        try {
            if (scenario.isFailed()) embedScreenshot(scenario);
            if (!softAssert.errorsCollected().isEmpty()) softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("Failed to take screenshot");
        }
    }

    @After(order = 1)
    public void afterScenario(Scenario scenario) {
        try {
            if (!scenario.getId().contains("SeparateFeature_NormalWelcomeFlow")) {
                if (scenario.getId().contains("DX_IDM") || scenario.getId().contains("RedHybrid_Login") || scenario.getId().contains("AcquisitionBoard"))
                    driver = null;
                    //if u want the beforeAll to run before each scenario
                else returnToDashboard();
            }
        }catch (Exception e){
            System.out.println(e.getStackTrace());
        }
    }

}

