
package mailrobot.smtp;

import java.io.IOException;
import mailrobot.models.prank.Prank;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public interface ISmtpClient {
    public void sendMessage(Prank prank)throws IOException;
}
