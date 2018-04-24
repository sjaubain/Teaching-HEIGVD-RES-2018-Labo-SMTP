
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
