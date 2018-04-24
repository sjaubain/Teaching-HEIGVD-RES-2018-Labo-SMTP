/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailrobot.config;

import java.io.File;
import java.io.IOException;
import mailrobot.models.prank.Prank;

/**
 *
 * @author oussama
 */
public interface IconfigManager {
    public void loadFileProperties(String fileName)throws IOException;
    public void loadVictims(String fileName)throws IOException;
    public void loadMessages(String filename)throws IOException;
    
}
