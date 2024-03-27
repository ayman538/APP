package pages.Dashboard.ViewBasket;

public abstract class ViewBasketAbstract extends ViewBasketPO {

    public abstract void viewBasketExistsWithNoCounter();
    public abstract void viewBasketExistsWithCounter();
    public abstract void viewBasketDoesNotExist();
    public abstract void clickOnBasket();
    public abstract void assertShopCustomTabIsDisplayed() throws InterruptedException;
    public abstract void validateBasketWebpageIsDisplayed() throws InterruptedException;







}
