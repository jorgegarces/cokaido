public class MailBuilder implements MailWithRecipient, MailWithTitle, MailWithBody, MailWithAttachments, MailBox {

    private String sender;
    private String recipient;
    private String title;
    private String body;
    private String attachments;

    private MailBuilder() {
    }

    public static MailWithRecipient createWithSender(String sender) {
        MailBuilder mailBuilder = new MailBuilder();
        mailBuilder.sender = sender;
        return mailBuilder;
    }

    public MailWithTitle withRecipient(String recipient) {
        this.recipient = recipient;
        return this;
    }

    public MailWithBody withTitle(String title) {
        this.title = title;
        return this;
    }

    public MailWithAttachments withBody(String body) {
        this.body = body;
        return this;
    }

    public MailBox withAttachments(String attachments) {
        this.attachments = attachments;
        return this;
    }

    public Mail create() {
        return new Mail(sender, recipient, title, body, attachments);
    }
}
