package pages.Dashboard.ConnectedApps;

import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class ConnectedAppsAbstract extends ConnectedAppsPO{

    public ConnectedAppsAbstract(){
        super();
    }

    public abstract List<WebElement> ConnectedAppsImgs();

    public abstract List<WebElement> ConnectedAppsTexts();

    public abstract List<WebElement> ConnectedAppsCTAs();

    public abstract void checkConnectedAppsImgs();

    public abstract void checkConnectedAppsTitles();

    public abstract void checkConnectedAppsTextOrder();
}
