package pages;

import org.junit.jupiter.api.Test;

import javax.mail.*;
import javax.mail.internet.MimeMultipart;
import javax.mail.search.FlagTerm;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Forgetpassword {

    public static String tempPass;

    public static String getTempPass() {
        try {
            String host = "smtp.gmail.com";
            String username = "uk.testing.vis@gmail.com";
            String password = "dqqairjptbewdtlr";
            String d_port = "993";

            Properties props = new Properties();
            props.put("mail.smtp.user", username);
            props.put("mail.smtp.host", host);
            props.put("mail.smtp.port", d_port);
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.debug", "true");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
            props.put("mail.smtp.ssl.protocols", "TLSv1.2");
            props.put("mail.smtp.connectiontimeout", 5000);

            Session emailSession = Session.getDefaultInstance(props);

            // create the imap store object and connect to the imap server
            Store store = emailSession.getStore("imaps");
            store.connect(host, username, password);

            // create the inbox object and open it
            Folder inbox = store.getFolder("Inbox");
            inbox.open(Folder.READ_WRITE);

            // retrieve the messages from the folder in an array and print it
            Message[] messages = inbox.search(new FlagTerm(new Flags(Flags.Flag.SEEN), false));

            //for (int i = 0, n = messages.length; i < n; i++)
            for (int i = messages.length - 1; i >= 0; i--) {
                Message message = messages[i];
                if (message.getSubject().equals("Forgotten username or password")) {


                    message.setFlag(Flags.Flag.SEEN, true);
                    System.out.println("Subject: " + message.getSubject());
                    System.out.println("From: " + message.getFrom()[0]);
                    System.out.println("Text: " + getTextFromMessage(message));
                    System.out.println("Email Sent Time: " + message.getReceivedDate());
                    String finalResult = getTextFromMessage(message);

                    tempPass = returnTempPass(finalResult);

                    System.out.println("Temporary Password Value is:" + tempPass);

                }
                break;
            }

            inbox.close(false);
            store.close();

        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tempPass.trim();

    }

    public static String returnTempPass(String Result) {

        String tempPassword = "";

        String regex = "account.(.*?)You’ll be able to change";

        Pattern p = Pattern.compile(regex);
        Matcher m1 = p.matcher(Result);
        if (m1.find()) {
            tempPassword = m1.group(1);
        }
        return tempPassword;
    }

    private static String getTextFromMessage(Message message) throws MessagingException, IOException {
        String result = "";
        if (message.isMimeType("text/plain")) {
            result = message.getContent().toString();
        } else if (message.isMimeType("multipart/*")) {
            MimeMultipart mimeMultipart = (MimeMultipart) message.getContent();
            result = getTextFromMimeMultipart(mimeMultipart);
        }
        return result;
    }

    private static String getTextFromMimeMultipart(
            MimeMultipart mimeMultipart) throws MessagingException, IOException {
        String result = "";
        int count = mimeMultipart.getCount();
        for (int i = 0; i < count; i++) {
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            if (bodyPart.isMimeType("text/plain")) {
                result = result + "\n" + bodyPart.getContent();
                break; // without break same text appears twice in my tests
            } else if (bodyPart.isMimeType("text/html")) {
                String html = (String) bodyPart.getContent();
                result = result + "\n" + org.jsoup.Jsoup.parse(html).text();
            } else if (bodyPart.getContent() instanceof MimeMultipart) {
                result = result + getTextFromMimeMultipart((MimeMultipart) bodyPart.getContent());
            }
        }
        return result;
    }

    @Test
    public void getTempPassword() {
        System.out.println(getTempPass());
    }
}
