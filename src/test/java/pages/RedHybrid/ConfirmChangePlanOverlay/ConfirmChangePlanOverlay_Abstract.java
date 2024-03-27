package pages.RedHybrid.ConfirmChangePlanOverlay;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class ConfirmChangePlanOverlay_Abstract extends ConfirmChangePlanOverlayPO {
    public ConfirmChangePlanOverlay_Abstract() {
        super();
    }

    public abstract void clickContinueCTA();

    public abstract void changePlanOverlayAppears();

    public abstract void changePlanOverlayUiIsCorrect() throws JsonProcessingException, InterruptedException;

    public abstract void clickOnTurnOnCTA();
}
