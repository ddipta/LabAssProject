package labassistant;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



class LaboratoryTwo extends JFrame {

    Container containerLab;
    JPanel textPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
    JPanel infoPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));
    JPanel equpPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));
    JPanel stdPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
    
    JTextArea labText= new JTextArea(23,49);
    JScrollPane labScrollPane= new JScrollPane(labText);
    
    JTextField labTextField1= new JTextField(10); 
    JTextField labTextField2= new JTextField(10);
    
    LaboratoryTwo(){
        containerLab= getContentPane();
        containerLab.setLayout(new BoxLayout(containerLab, BoxLayout.X_AXIS));
        containerLab.add(textPanel, BorderLayout.EAST);//contain lab buttons
        containerLab.add(infoPanel, BorderLayout.WEST);//contain right and down panel
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        
        infoPanel.add(equpPanel);//add RightPanel: lab safety textArea
        infoPanel.add(stdPanel);//add DownPanel: media composition button
        
        //set size of panels
        textPanel.setPreferredSize(new Dimension(800,400));
        infoPanel.setPreferredSize(new Dimension(400,400));
        equpPanel.setPreferredSize(new Dimension(400,400));
        stdPanel.setPreferredSize (new Dimension(400,400));
        
        
        textPanel.setBorder(BorderFactory.createTitledBorder("Laboratory details"));
        textPanel.add(labText);
        
        equpPanel.setBorder(BorderFactory.createTitledBorder("Laboratory Equp details"));
        equpPanel.add(labTextField1);
        
        stdPanel.setBorder(BorderFactory.createTitledBorder("Laboratory Std details"));
        stdPanel.add(labTextField2);
    }
}
