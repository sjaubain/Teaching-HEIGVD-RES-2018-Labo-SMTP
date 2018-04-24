
package mailrobot.models.mail;

import java.util.LinkedList;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class Message {
    private String from;
    private LinkedList<Person>to;
    private LinkedList <Person>cc;
    private String subject;
    private String body;

    public Message(String from, String subject, String body,LinkedList<Person> to,LinkedList<Person>cc) {
        this.from = from;
        this.to=to;
        this.cc=cc;
        this.subject = subject;
        this.body = body;
    }

    
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public LinkedList<Person> getTo() {
        return to;
    }

    public void setTo(LinkedList<Person> to) {
        this.to = to;
    }

    public LinkedList<Person> getCc() {
        return cc;
    }

    public void setCc(LinkedList<Person> cc) {
        this.cc = cc;
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
    
}
