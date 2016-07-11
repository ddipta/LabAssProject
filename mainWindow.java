package labassistant;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
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
        
        //lab Button action
        Lab1.addActionListener((ActionEvent e) -> {
            LaboratoryOne frameLab1= new LaboratoryOne();
            frameLab1.setVisible(true);
            frameLab1.setTitle("Laboratory One"); 
            frameLab1.pack();
            frameLab1.setLocationRelativeTo(null);
            frameLab1.setSize(900,600);
            
            LaboratoryOne labOne= new LaboratoryOne(); 
        });
        
        Lab2.addActionListener((ActionEvent e) -> {
            LaboratoryTwo frameLab2= new LaboratoryTwo();
            frameLab2.setVisible(true);
            frameLab2.setTitle("Laboratory Two"); 
            frameLab2.pack();
            frameLab2.setLocationRelativeTo(null);
            frameLab2.setSize(900,600);
            
            LaboratoryTwo labTwo= new LaboratoryTwo(); 
        });
        
        Lab3.addActionListener((ActionEvent e) -> {
            LaboratoryThree frameLab3= new LaboratoryThree();
            frameLab3.setVisible(true);
            frameLab3.setTitle("Laboratory Three"); 
            frameLab3.pack();
            frameLab3.setLocationRelativeTo(null);
            frameLab3.setSize(900,600);
            
            LaboratoryThree labThree= new LaboratoryThree(); 
        });
        
        Lab4.addActionListener((ActionEvent e) -> {
            LaboratoryFour frameLab4= new LaboratoryFour();
            frameLab4.setVisible(true);
            frameLab4.setTitle("Laboratory Four"); 
            frameLab4.pack();
            frameLab4.setLocationRelativeTo(null);
            frameLab4.setSize(900,600);
            
            LaboratoryFour labFour= new LaboratoryFour(); 
        });
        
        Lab5.addActionListener((ActionEvent e) -> {
            LaboratoryFive frameLab5= new LaboratoryFive();
            frameLab5.setVisible(true);
            frameLab5.setTitle("Laboratory Five"); 
            frameLab5.pack();
            frameLab5.setLocationRelativeTo(null);
            frameLab5.setSize(900,600);
            
            LaboratoryFive labFive= new LaboratoryFive(); 
        });
        
        
        
        
        //at SubPanel
        //set RightPanel with TextArea**(textField)
        RightPanel.setBorder(BorderFactory.createTitledBorder("Laboratory Safety"));
        RightPanel.add(TextArea);
        
        //set DownPanel with Meadia button 
        DownPanel.setBorder(BorderFactory.createTitledBorder("Know About Media Composition"));
        DownPanel.add(Media);
        
        
        //media button action
//        MediaWindow mediaWindow= new MediaWindow();
//        Media.addActionListener((ActionListener) new MediaWindow());
//        Media.addActionListener((ActionListener) mediaWindow);
        Media.addActionListener((ActionEvent e) -> {
            MediaWindow mediaFrame= new MediaWindow();
            mediaFrame.setVisible(true);
            mediaFrame.setTitle("Media Information"); 
            mediaFrame.pack();
            mediaFrame.setLocationRelativeTo(null);
            mediaFrame.setSize(300, 400);
            
            MediaWindow mediaDetail= new MediaWindow(); 
        });    
        
     
        
        
    }
}