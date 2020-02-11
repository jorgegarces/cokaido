import org.junit.Assert;
import org.junit.Test;

public class MailBuilderShould {

    @Test
    public void create_a_new_mail_with_the_given_parameters_by_methods() {

        Mail mail = MailBuilder
                .createWithSender("ara@celi.com")
                .withRecipient("jor@ge.com")
                .withTitle("olakase")
                .withBody("ara manjon mola un monton")
                .withAttachments("arapeineta.jpg")
                .create();

        Mail expectedMail = new Mail("ara@celi.com", "jor@ge.com", "olakase", "ara manjon mola un monton", "arapeineta.jpg");

        Assert.assertEquals(expectedMail, mail);
    }

}
