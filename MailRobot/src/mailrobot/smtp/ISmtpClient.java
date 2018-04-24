
package mailrobot.smtp;

import java.io.IOException;
import mailrobot.models.mail.Message;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public interface ISmtpClient {
    public void sendMessage(Message message)throws IOException;
}
