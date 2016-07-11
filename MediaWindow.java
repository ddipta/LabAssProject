package labassistant;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.*;

class MediaWindow extends JFrame {

    String[] MediaComboBoxItemList;
    JComboBox MediaComboBox= new JComboBox();
    JTextField MediaQuantityTextField;
    JButton MediaCalculate, MediaCreate, MediaUpdate, MediaDelete;
    
    boolean MediaNewlyStarted;
    
    public MediaWindow(){
//        this.setDefaultCloseOperation(MediaWindow.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(5,1));
        MediaNewlyStarted=true;
        
        File dir= new File("medias/");
        
        File[] listofFiles = dir.listFiles();
        
        MediaComboBoxItemList = new String[listofFiles.length+1];
        MediaComboBoxItemList[0]="Select Media Name";
        
        for(int i=0; i<listofFiles.length; i++){
            MediaComboBoxItemList[i+1]=listofFiles[i].getName();
        }
        
        MediaComboBox= new JComboBox(MediaComboBoxItemList);
        MediaComboBox.setSize(100, 100);
        
        MediaCalculate= new JButton("Calculate");
//        MediaCalculate.addActionListener(new calculateActionListener());
        
        
        MediaCreate= new JButton("Create New");
//        MediaCreate.addActionListener(new createMediaConfig());
        
        MediaUpdate= new JButton("Update");
//        MediaUpdate.addActionListener(new mediaUpdate());
        
        MediaDelete = new JButton("Delete");
//	MediaDelete.addActionListener(new mediaDelete());
        
        this.add(MediaComboBox);
        this.add(MediaCalculate);
        this.add(MediaCreate);
        this.add(MediaUpdate);
        this.add(MediaDelete);
        
        
//        this.setSize(300, 400);
//        this.setLocationRelativeTo(null);
//        this.setVisible(true);    
    }
    
//    public static void main(String[] args) {
//        new MediaWindow(); 
//    }
    
/*
    private static class calculateActionListener implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            String mediaName= MediaComboBox.getSelectedItem().toString();
            if(!"Select Media Name".equals(mediaName)){
                String quantity= JOptionPane.showInputDialog(null, 
                                    "Enter the quantity in ml", "Caculating"+mediaName, 
                                    JOptionPane.QUESTION_MESSAGE);
                
                try{
                    new MediaResultWindow(mediaName, quantity);
                }catch(FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, mediaName+" Not Found");
                }
            }
        }

        
    }

    private static class createMediaConfig implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            new createMedia();
        }
    }

    private static class mediaUpdate implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e){
            String mediaName = MediaComboBox.getSelectedItem().toString();
            if(mediaName != "Select Media Name"){
                try{
                    int count=0;
                    
                    new mediaEdit(mediaName);
                }catch (FileNotFoundException e1) {
                    JOptionPane.showMessageDialog(null, mediaName+" Not Found");
                }
            }
        }
    }

    private static class mediaDelete implements ActionListener {
        
        @Override
        public void actionPerformed(ActionEvent e){
            String mediaName= MediaComboBox.getSelectedItem().toString();
            File file=new File("medias/"+mediaName);
            int confirm= JOptionPane.showConfirmDialog(null, "Confirm Delete?", "Deleting" +mediaName,
                            JOptionPane.OK_CANCEL_OPTION);
            
            if(confirm==0){
                file.delete();
            }
            JOptionPane.showMessageDialog(null,"Deleted"+ mediaName);
            
        }

        
    }

  */  
    
}
