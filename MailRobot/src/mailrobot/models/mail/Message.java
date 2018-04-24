
package mailrobot.models.mail;

import java.util.LinkedList;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class Message {
    private String subject;
    private String body;

    public Message( String subject, String body) {
        this.subject = subject;
        this.body = body;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    public String toString(){
        return "SUBJECT :"+subject+"\r\n\n"+body;
    }
}
