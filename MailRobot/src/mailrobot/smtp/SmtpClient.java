
package mailrobot.smtp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import mailrobot.models.mail.Message;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class SmtpClient implements ISmtpClient{
    private String serverAddress;
    private int smtpServerPort=25;
    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;

    public SmtpClient(String serverAddress, int smtpServerPort) {
        this.serverAddress = serverAddress;
        this.smtpServerPort = smtpServerPort;
    }

    @Override
    public void sendMessage(Message message) throws IOException {
        socket =new Socket(serverAddress, smtpServerPort);
        writer =new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"UTF-8"),true);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
        String line = reader.readLine();
        writer.print("EHLO localhost\r\n");
        line =reader.readLine();
        if(!line.startsWith("250")){
            throw new IOException("SMTP error "+line);
        }
        while(line.startsWith("250-")){
            line=reader.readLine();
        }
        writer.write("MAIL FROM:");
        writer.write(message.getFrom());
        writer.write("\r\n");
        writer.flush();
        line=reader.readLine();
        for(String to :message.getTo()){
        writer.write("RCPT TO:");
        writer.write(to);
        writer.write("\r\n");
        writer.flush();   
    }
        for(String to:message.getCc()){
        writer.write("RCPT TO:");
        writer.write(to);
        writer.write("\r\n");
        writer.flush();   
            
        }
        writer.write("DATA");
        writer.write("\r\n");
        writer.flush();
        line=reader.readLine();
        writer.write("from: "+message.getFrom()+"\r\n");
        writer.write("To: "+message.getTo()[0]);
        for(int i=1;i<message.getTo().length;++i){
            writer.write(","+message.getTo()[i]);
        }
        writer.write("\r\n");
        writer.write("Cc: "+message.getCc()[0]);
        for(int i=1;i<message.getCc().length;++i){
            writer.write(","+message.getCc()[i]);
        }
        writer.write("\r\n");
        writer.flush();
        writer.write(message.getBody());
        writer.write("\n\r");
        writer.write(".");
        writer.write("\r\n");
        writer.flush();
        line=reader.readLine();
        writer.write("QUIT\r\n");
        writer.flush();
        reader.close();
        writer.close();
        socket.close();
        
    }
    
}
