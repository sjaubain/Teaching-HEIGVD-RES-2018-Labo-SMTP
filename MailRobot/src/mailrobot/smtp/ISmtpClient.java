/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
