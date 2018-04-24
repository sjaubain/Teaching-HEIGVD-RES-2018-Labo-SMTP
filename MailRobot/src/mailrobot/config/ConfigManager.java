/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailrobot.config;

import java.io.FileInputStream;
import java.io.IOException;
import mailrobot.models.mail.Person;
import java.util.LinkedList;
import java.util.Properties;

/**
 *
 * @author oussama
 */
public class ConfigManager implements IconfigManager {

    private String SMTPServerAdress;
    private String SMTPServerPort;
    private int nombreGroupe;
    private LinkedList<Person> witness;
    private LinkedList<Person> victims;

    public ConfigManager() throws IOException {
        loadFileProperties("./config/configuration/properties.properties");
    }

    @Override
    public void loadFileProperties(String fileName) throws IOException {

        FileInputStream in = new FileInputStream(fileName);
        Properties prop = new Properties();
        prop.load(in);
        this.SMTPServerAdress = prop.getProperty("ServerAdress");
        this.SMTPServerPort = prop.getProperty("serverPort");
        this.nombreGroupe = Integer.valueOf(prop.getProperty("nbGroups"));
        String Witns = prop.getProperty("witnessesToCC");
        String[] wit = Witns.split(",");
        for (String s : wit) {
            witness.add(new Person(s));
        }
    }

    @Override
    public void loadVictims(String fileName) {

    }

    @Override
    public void loadMessages(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
