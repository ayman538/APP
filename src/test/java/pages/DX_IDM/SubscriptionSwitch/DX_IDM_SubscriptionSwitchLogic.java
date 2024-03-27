//package pages.DX_IDM.SubscriptionSwitch;
//
//import Pages.DX_IDM.FullLogin.DX_IDM_FullLoginLogic;
//import Pages.Tray.MyAccountLogic;
//import org.json.simple.parser.ParseException;
//import java.io.IOException;
//
//public class DX_IDM_SubscriptionSwitchLogic {
//    DX_IDM_FullLoginLogic FL_Logic;
//    MyAccountLogic MA_Logic;
//
//
//    public  DX_IDM_SubscriptionSwitchLogic() throws IOException {
//        super();
//        FL_Logic = new DX_IDM_FullLoginLogic();
//        MA_Logic = new MyAccountLogic();
//    }
//
//    public void navigateToMyAccount() throws InterruptedException {
//        FL_Logic.navigateToMyAccount();
//        Thread.sleep(10000);
//        FL_Logic.DX_IDM_Password.sendKeys("testing1");
//        FL_Logic.DX_IDM_LoginCTA.click();
//        Thread.sleep(30000);
//    }
//
//    public void SwitchSubscription(String userType) throws ParseException {
//        MA_Logic.SwitchToSubscription(userType);
//    }
//
//}