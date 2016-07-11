package labassistant;

import java.io.File;
import java.io.FilenameFilter;   

public class fileName {
    public File[] finder(String dirName){
        File dir= new File(dirName);
        File[] listofFiles= dir.listFiles(); 
        return listofFiles;
    };
    
}
