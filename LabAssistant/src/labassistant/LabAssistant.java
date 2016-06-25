package labassistant;

import javax.swing.JFrame;

public class LabAssistant {

    public static void main(String[] args) {
        
        mainWindow frame= new mainWindow();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setTitle("Laboratory");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setSize(900,600);
        
        new mainWindow();
        
    }
    
}
