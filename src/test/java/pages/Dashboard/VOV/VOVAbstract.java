package pages.Dashboard.VOV;

import org.testng.SkipException;
import pages.SubsctionOverlay.TabMenuVariationPO;
import testdata.ReadResponse;

import java.util.LinkedHashMap;
import java.util.Map;

public abstract class VOVAbstract extends VOVPO{

    public VOVAbstract(){super();}

    public abstract void checkVOVItems();

    public abstract void VOVCTA();

    public abstract void VOVWebViewBackCTA();

    public abstract void DismissVOV();

    public abstract void checkVOVAfterSoftClose();

}
