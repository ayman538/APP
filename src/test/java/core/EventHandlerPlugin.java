package core;

import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventHandler;
import io.cucumber.plugin.event.EventPublisher;
import io.cucumber.plugin.event.Result;
import io.cucumber.plugin.event.TestRunFinished;
import org.openqa.selenium.JavascriptExecutor;

import java.util.Properties;

import static core.Hooks.getDriver;
import static utilities.PropertiesLoader.readPropertyFile;

public class EventHandlerPlugin implements ConcurrentEventListener {

    Hooks hooks= new Hooks();


    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {
        eventPublisher.registerHandlerFor(TestRunFinished.class,runFinishedHandler);
    }

    private EventHandler<TestRunFinished> runFinishedHandler = new EventHandler<TestRunFinished>() {
        @Override
        public void receive(TestRunFinished event) {
            hooks.getFinalResult(event);
            hooks.teardown();
        }
    };

}
