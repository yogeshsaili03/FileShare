package Mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {

    private String username, password;

    public SMTPAuthenticator(String username, String password) {
        this.username = username;
        this.password = password;

    }

    @Override
    public javax.mail.PasswordAuthentication getPasswordAuthentication() {

        return new PasswordAuthentication(this.username, this.password);
    }

}
