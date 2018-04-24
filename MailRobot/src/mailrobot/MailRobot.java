/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailrobot;

import java.io.IOException;
import mailrobot.config.ConfigManager;
import mailrobot.models.prank.Prank;
import mailrobot.models.prank.PrankGenerator;
import mailrobot.smtp.SmtpClient;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class MailRobot {

    /**
     * @param args the command line arguments
     */
    public static void main(String []args) throws IOException {
        ConfigManager cf =new ConfigManager();
        PrankGenerator pg=new PrankGenerator(cf);
        SmtpClient smtpClient=new SmtpClient(cf.getSMTPServerAdress(), cf.getSMTPServerPort());
        for(Prank p:pg.getPranks()){
            smtpClient.sendMessage(p);
        }
        
    }
    
}
