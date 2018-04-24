package mailrobot.models.prank;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import mailrobot.config.ConfigManager;
import mailrobot.config.IconfigManager;
import mailrobot.models.mail.Message;
import mailrobot.models.mail.Person;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class Prank {

    private Person victimSender;
    private final LinkedList<Person> victimRecipients = new LinkedList<>();
    private final LinkedList<Person> witnessRecipients = new LinkedList<>();
    private String message;

    public Person getVictimSender() {
        return victimSender;
    }

    public void setVictimSender(Person person) {
        this.victimSender = person;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void addVictimRespients(List<Person> victims) {
        victimRecipients.addAll(victims);
    }

    public void addWitnessRecipients(List<Person> witness) {
        witnessRecipients.addAll(witness);
    }

    public List<Person> getVictimRecipients() {
        return victimRecipients;
    }

    public List<Person> getWitnessRecipients() {
        return witnessRecipients;
    }

    public void generateMailMessage() {
       
    }
}
