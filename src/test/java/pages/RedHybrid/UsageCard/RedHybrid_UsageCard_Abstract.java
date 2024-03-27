package pages.RedHybrid.UsageCard;

import models.response.UsagesV3ResponseModel;

public abstract class RedHybrid_UsageCard_Abstract extends RedHybrid_UsageCardPO {
    String actualQuantity;
    UsagesV3ResponseModel usagesV3ResponseModel;

    public RedHybrid_UsageCard_Abstract() {
        super();
    }

    public abstract void navigateToSubsOverLay();

    public abstract void navigateToUsage();

    public abstract void validateRHUsageCardUI();

    public abstract void usageAPIDataMappingValidation();

    public abstract void addPaymentMethodOverlayDismiss();

    public abstract void ValidateContentOfActiveExtrasCard();

    public abstract void ValidateThatAddExtrasCTAIsRemoved();

    public abstract void CheckQuantitySuffixWord();
}