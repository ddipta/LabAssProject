package labassistant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


class createMedia {
    
    JTextField[] names;
    JTextField[] amounts;
    JFrame finalFrame;
    int n;
    String mediaName2;

    public createMedia() {
        
        //getting media name
        String mediaName= JOptionPane.showInputDialog(null,"Enter Media Name", "Getting Media name",
                            JOptionPane.QUESTION_MESSAGE);
        
        // getting number of components
        String numberOfComponent = JOptionPane.showInputDialog(null, "Enter number of component", "Getting number of component ",
                             JOptionPane.QUESTION_MESSAGE);
        
        //saving in global string for other class usage
        mediaName2 = mediaName;
        
        // converting number of components to int n and validating 
        int flag =0;
        while(true){
            flag=0;
            try{
                n=Integer.parseInt(numberOfComponent);
            }catch(NumberFormatException e){
                numberOfComponent = JOptionPane.showInputDialog(null,
                                "Enter number of component", "Getting number of component ",
                                JOptionPane.QUESTION_MESSAGE);
                flag=1;
            }
            
            if(flag==0)
                break;
        }
        
        //conversion and validation
		
        int i;
        //this panel contains all individual lines 
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new GridLayout(n + 2, 1));

        JPanel topLine = new JPanel();
        topLine.add(new JLabel("        Name:"));
        topLine.add(Box.createHorizontalGlue());
        topLine.add(new JLabel("           Amount:"));
        boxPanel.add(topLine);

        names = new JTextField[n];
        amounts = new JTextField[n];
        ///creating window for input of component name and quantity
        for (i = 0; i < n; i++) {
            JPanel linePanel = new JPanel();
            JTextField xfield = new JTextField(20);
            JTextField yfield = new JTextField(5);
            linePanel.add(new JLabel("component: " + i));
            linePanel.add(xfield);
            linePanel.add(Box.createHorizontalGlue());
            linePanel.add(new JLabel("Quantity:"));
            linePanel.add(yfield);
            boxPanel.add(linePanel);
            names[i] = xfield;
            amounts[i] = yfield;

        }
        //button job!
        JPanel buttonPanel = new JPanel();
        JButton create = new JButton("Create");
        JButton cancel = new JButton("Cancel");
        create.setBackground(Color.BLUE);
        create.addActionListener(new createAction());
        cancel.setBackground(Color.red);
        cancel.addActionListener(new cancelAction());

        buttonPanel.add(create);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(cancel);

        boxPanel.add(buttonPanel);

        //JFrame is important to implement scrollable interface
        finalFrame = new JFrame();
        finalFrame.setTitle("Creating " + mediaName);
        JScrollPane jScrollPane = new JScrollPane(boxPanel);

        finalFrame.getContentPane().add(jScrollPane, BorderLayout.CENTER);

        finalFrame.pack();
        finalFrame.setLocationRelativeTo(null);
        finalFrame.setVisible(true);
    }
    
    class createAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i;
			int confirm = JOptionPane.showConfirmDialog(null,
					"Confirm creation?", "Saving.." + mediaName2,
					JOptionPane.OK_CANCEL_OPTION);
			//final confirmation
			if (confirm == 0) {
				String text="";
				
				///validation of amounts
				double t;
				String fix;
				int flag = 0;
				while (true) {
					flag=0;
					for (i = 0; i < n; i++) {
						try {
							t = Double.parseDouble(amounts[i].getText());
						} catch (NumberFormatException ne) {

							fix = JOptionPane
									.showInputDialog("Enter numeric value for "
											+ "component " + names[i].getText(),amounts[i].getText());
							amounts[i].setText(fix);
							flag=1;
						}
						
					
					}
					if(flag==0)
						break;
				}
				///validation

				///text is a multiline string containing the inputs in a multiline
				///writable to file format
				for (i = 0; i < n; i++)
					text = text.concat(names[i].getText() + "="
							+ amounts[i].getText() + "\n");
				
				///writing to file
				BufferedWriter output = null;
				try {
					File file = new File("medias/" + mediaName2);
					output = new BufferedWriter(new FileWriter(file));
					output.write(text);
				} catch (IOException e1) {
					e1.printStackTrace();

				} finally {
					try {
						output.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				///
				finalFrame.dispose();
				JOptionPane.showMessageDialog(null,"Successfully Created "+mediaName2);
			}
		}

	}

	class cancelAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e){
			finalFrame.dispose();
		}
	}
    
    
}
