package pages.NativeExtras.ConfirmOptingExtra;

import pages.Commons.CommonPo;

public abstract class ConfirmOptingExtraAbstract extends CommonPo {

    public abstract void validateConfirmOptOutExtraTrayIsOpened(String buttonName);

    public abstract void clickOnXCTAOnRemoveConfirmationTray();

    public abstract void clickOnOptCTAOnOptingConfirmationTray();

}

