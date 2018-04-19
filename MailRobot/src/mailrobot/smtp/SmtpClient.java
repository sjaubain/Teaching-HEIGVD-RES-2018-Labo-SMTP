
package mailrobot.smtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import mailrobot.models.mail.Message;

/**
 *
 * @author oussama
 */
public class SmtpClient implements ISmtpClient{
    private String serverAddress;
    private int smtpServerPort;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public SmtpClient(String serverAddress, int smtpServerPort) {
        this.serverAddress = serverAddress;
        this.smtpServerPort = smtpServerPort;
    }

    @Override
    public void sendMessage(Message message) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
