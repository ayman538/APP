package pages.PushNotification;

import com.fasterxml.jackson.core.JsonProcessingException;

public abstract class PushNotificationPage extends PushNotificationPo {

    public PushNotificationPage() {
        super();
    }

    public abstract void OpenPushNotification();

    public abstract void ValidateAppIsOpened();

    public abstract void SoftCloseApp();

    public abstract void AssertRedirectToExternalLink();

    public abstract void AssertRedirectToDeepLink();
    public abstract  void OpenPushNotification(String Notification);
    public abstract void ValidateMessageBody(String MessageBody);
    public abstract void CloseAppFromBackground() throws InterruptedException;
    public abstract void PutAppInBackground();
    public abstract void sendAMessageCenterNotification(String alert, String title, String body) throws JsonProcessingException;
}
