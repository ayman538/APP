package pages.ExamplePage;

public abstract class ExamplePage extends ExamplePagePo {

    public ExamplePage() {
        super();
    }

    public abstract void assertPagePresent();

    public abstract void openNeatGif();
}
