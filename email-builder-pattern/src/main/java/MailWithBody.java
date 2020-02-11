public interface MailWithBody {
    MailWithAttachments withBody(String body);

    Mail create();
}
