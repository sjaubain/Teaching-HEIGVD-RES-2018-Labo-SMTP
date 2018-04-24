package mailrobot.models.mail;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lagha Oussama - Jobin Simon 
 */
public class Group {
    
    private final List<Person> members = new ArrayList();
    public void addMember(Person person){
        members.add(person);
    }
    public List<Person> getMembers(){
        return members;
    }
}
