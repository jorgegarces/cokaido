public interface MailWithTitle {
    MailWithBody withTitle(String title);

    Mail create();
}
