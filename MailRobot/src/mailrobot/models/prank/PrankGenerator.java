/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailrobot.models.prank;

import java.io.IOException;
import mailrobot.config.ConfigManager;
import java.util.LinkedList;
import java.util.Random;

/**
 *
 * @author Lagha Oussama - Jobin Simon
 */
public class PrankGenerator {
    
    private ConfigManager cf;
    
    private LinkedList<Prank> pranks;
    
    public PrankGenerator() throws IOException {
        cf = new ConfigManager();
        pranks = new LinkedList();
        
        for(int i = 0; i < cf.getNombreGroupe(); ++i) {
            pranks.add(new Prank());
        }
    }
    
    public void generatePrank() {
       
        Random rand = new Random();
        
        int nbVictims = cf.getVictims().size();
        
        for(Prank prank : pranks) {
            
            prank.addWitnessRecipients(cf.getWitness());
            int idVictimSender = rand.nextInt(nbVictims);
            prank.setVictimSender(cf.getVictims().get(idVictimSender));
            
            LinkedList randomVictims = new LinkedList();
            for(int i = 0; i < nbVictims / cf.getNombreGroupe(); ++i) {
                
                int idVictim = rand.nextInt(nbVictims);
                while(idVictim == idVictimSender) {
                    idVictim = rand.nextInt(nbVictims);                 
                }
                randomVictims.add(cf.getVictims().get(rand.nextInt(nbVictims)));
            }
            prank.addVictimRecipients(randomVictims);
        }
    }
}
