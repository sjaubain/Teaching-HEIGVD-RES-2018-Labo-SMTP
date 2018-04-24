/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailrobot.config;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
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
        loadFileProperties("./configuration/properties.properties");
        loadVictims("./configuration/listVictims.txt");
        loadMessages("./configuration/messages.txt");
    }

    public String getSMTPServerAdress() {
        return SMTPServerAdress;
    }

    public String getSMTPServerPort() {
        return SMTPServerPort;
    }

    public int getNombreGroupe() {
        return nombreGroupe;
    }

    public LinkedList<Person> getWitness() {
        return witness;
    }

    public LinkedList<Person> getVictims() {
        return victims;
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
    public void loadVictims(String fileName)throws IOException {
        FileReader fileReader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String mail;
        while((mail=bufferedReader.readLine())!=null){
            victims.add(new Person(mail));
        }
    }

    @Override
    public void loadMessages(String filename)throws IOException {
                FileReader fileReader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String message;
        while((message=bufferedReader.readLine())!=null){
            victims.add(new Person(message));
        }
    }

}
