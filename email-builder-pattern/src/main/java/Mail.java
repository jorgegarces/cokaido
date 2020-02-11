import java.util.Objects;

public class Mail {

    private final String from;
    private final String to;
    private final String title;
    private final String body;
    private final String attachments;

    public Mail(String from, String to, String title, String body, String attachments) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.body = body;
        this.attachments = attachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mail mail = (Mail) o;
        return Objects.equals(from, mail.from) &&
                Objects.equals(to, mail.to) &&
                Objects.equals(title, mail.title) &&
                Objects.equals(body, mail.body) &&
                Objects.equals(attachments, mail.attachments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, title, body, attachments);
    }
}
