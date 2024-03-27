package pages.Welcome;

import java.io.IOException;

public abstract class WelcomeLogicAbstract extends WelcomePO {


    public WelcomeLogicAbstract() {
        super();
    }

    public abstract void WelcomeFlow();

    public abstract void getStartedCTA();

    public abstract void DismissLoginScreen();

    public abstract void noThanksCTA();

    public abstract void acceptAlert();

    public abstract void WelcomeBackFlow() throws IOException;

    public abstract void continueCTA();

    public abstract void welcomeFlowForOldApp();

}
