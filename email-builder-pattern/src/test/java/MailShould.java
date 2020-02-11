import org.junit.Assert;
import org.junit.Test;

public class MailShould {
    @Test
    public void compose_a_proper_email() {

        Mail mail = new Mail("ara@celi.com", "jor@ge.com", "olakase", "ara manjon mola un monton", "arapeineta.jpg");
        Mail expectedMail = new Mail("ara@celi.com", "jor@ge.com", "olakase", "ara manjon mola un monton", "arapeineta.jpg");

        Assert.assertEquals(expectedMail, mail);
    }
}
