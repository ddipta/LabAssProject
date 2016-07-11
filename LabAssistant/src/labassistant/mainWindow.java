package labassistant;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class mainWindow extends JFrame {
    public Container container;
    //panels main window
    public JPanel LeftPanel= new JPanel(new FlowLayout(FlowLayout.LEFT));//Lab names
    public JPanel SubPanel= new JPanel (new FlowLayout(FlowLayout.RIGHT));//for contain right and down panel
    public JPanel RightPanel= new JPanel(new FlowLayout(FlowLayout.RIGHT));//lab safety textArea
    public JPanel DownPanel= new JPanel (new FlowLayout(FlowLayout.TRAILING));//media composition
    
    //buttons of labs
    public JButton Lab1=new JButton ("Go Lab 1");//Lab1
    public JButton Lab2=new JButton ("Go Lab 2");//Lab2
    public JButton Lab3=new JButton ("Go Lab 3");//Lab3
    public JButton Lab4=new JButton ("Go Lab 4");//Lab4
    public JButton Lab5=new JButton ("Go Lab 5");//Lab5
    
    //media
    JButton Media= new JButton ("Media Composition");//media button; go to media composition window; 
    
//    public JTextField TextField= new JTextField(10);//textField: change to textArea; input from file; 
    public JTextArea TextArea= new JTextArea(23,49);
    JScrollPane ScrollPane= new JScrollPane(TextArea);

    public mainWindow(){
        
        container= getContentPane();
        container.setLayout(new BoxLayout(container, BoxLayout.X_AXIS));
        container.add(LeftPanel, BorderLayout.EAST);//contain lab buttons
        container.add(SubPanel, BorderLayout.WEST);//contain right and down panel
        SubPanel.setLayout(new BoxLayout(SubPanel, BoxLayout.Y_AXIS));
        
        SubPanel.add(RightPanel);//add RightPanel: lab safety textArea
        SubPanel.add(DownPanel);//add DownPanel: media composition button
        
        //set size of panels
        LeftPanel.setPreferredSize(new Dimension(250,100));
        SubPanel.setPreferredSize(new Dimension(800,400));
        RightPanel.setPreferredSize(new Dimension(800,400));
        DownPanel.setPreferredSize(new Dimension(300,150));
        
        //set Lab Buttons: size
        Lab1.setPreferredSize(new Dimension(250,60));
        Lab2.setPreferredSize(new Dimension(250,60));
        Lab3.setPreferredSize(new Dimension(250,60));
        Lab4.setPreferredSize(new Dimension(250,60));
        Lab5.setPreferredSize(new Dimension(250,60));
        
        //set LabButtons at LeftPanel
        LeftPanel.setBorder(BorderFactory.createTitledBorder("Laboratory Names"));
        LeftPanel.add(Lab1, BorderLayout.NORTH);
        LeftPanel.add(Lab2, BorderLayout.EAST);
        LeftPanel.add(Lab3, BorderLayout.EAST);
        LeftPanel.add(Lab4, BorderLayout.EAST);
        LeftPanel.add(Lab5, BorderLayout.SOUTH);
        
        //at SubPanel
        //set RightPanel with TextArea**(textField)
        RightPanel.setBorder(BorderFactory.createTitledBorder("Laboratory Safety"));
        RightPanel.add(TextArea);
        
        //set DownPanel with Meadia button 
        DownPanel.setBorder(BorderFactory.createTitledBorder("Know About Media Composition"));
        DownPanel.add(Media);
        
        
        //media button action
        MediaWindow mediaWindow= new MediaWindow();
//        Media.addActionListener((ActionListener) mediaWindow);
            
        
     
        
        
    }
}