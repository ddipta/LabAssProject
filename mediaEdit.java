package labassistant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class mediaEdit {
    
    ///creating multiclass usable variables
    int len;
    JTextField[] names;
    JTextField[] amounts;
    String mediaName2;
    JFrame finalframe;

    public mediaEdit(String mediaName) throws FileNotFoundException {
		//saving medianame in a global string
		mediaName2 = mediaName;
		
		//reading the file
		Scanner in = new Scanner(new FileReader("medias/" + mediaName));
		
		//parsing file contents to string str
		String str = "";
		while (in.hasNextLine())
			str = str.concat(in.nextLine() + "\n");
		
		//spliting at newline and creating a array of strings
		String[] lines = str.split("\n");
		len = lines.length;
		
		//boxpanel will contain each individual panel for each line
		JPanel boxPanel = new JPanel();
		boxPanel.setLayout(new GridLayout(len + 2, 1));
		JPanel topLine = new JPanel();
		topLine.add(new JLabel("   Name:"));
		topLine.add(Box.createHorizontalGlue());
		topLine.add(new JLabel(
				"                                    Amount(mg):"));
		boxPanel.add(topLine);
		names = new JTextField[len];
		amounts = new JTextField[len];
		
		//creating window for editing
		for (int i = 0; i < len; i++) {
			JPanel linePanel = new JPanel();
			JTextField xfield = new JTextField(20);
			JTextField yfield = new JTextField(5);
			String[] splitedLine = lines[i].split("=");
			xfield.setText(splitedLine[0]);
			yfield.setText(splitedLine[1]);
			linePanel.add(xfield);
			linePanel.add(Box.createHorizontalGlue());
			linePanel.add(yfield);
			names[i] = xfield;
			amounts[i] = yfield;

			boxPanel.add(linePanel);
		}
		//button job!
		JPanel buttonPanel = new JPanel();
		JButton okButton = new JButton("Ok");
		JButton cancelButton = new JButton("Cancel");
		okButton.addActionListener(new updateAction());
		okButton.setBackground(Color.blue);
		cancelButton.addActionListener(new cancelAction());
		cancelButton.setBackground(Color.red);
		buttonPanel.add(okButton);
		buttonPanel.add(Box.createVerticalGlue());
		buttonPanel.add(cancelButton);
		boxPanel.add(buttonPanel);

		//jframe is required for implementing a scrollable interface
		finalframe = new JFrame();
		finalframe.setTitle("Editing "+mediaName);
		JScrollPane jScrollPane = new JScrollPane(boxPanel);

		finalframe.getContentPane().add(jScrollPane, BorderLayout.CENTER);

		finalframe.pack();
		finalframe.setLocationRelativeTo(null);
		finalframe.setVisible(true);

	}
    
    class updateAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			int i;
			//final confirmation
			int confirm = JOptionPane.showConfirmDialog(null,
					"Confirm change?", "Updating " + mediaName2,
					JOptionPane.OK_CANCEL_OPTION);
			String text = "";
			if (confirm == 0) {
				
				
				///validation of amounts
				double t;
				String fix;
				int flag = 0;
				while (true) {
					flag=0;
					for (i = 0; i < len; i++) {
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
				
				//creating a string 'text' to write in a file
				for ( i = 0; i < len; i++)
					text = text.concat(names[i].getText() + "="
							+ amounts[i].getText() + "\n");
				//writing to file
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
					} catch (IOException e2) {
						e2.printStackTrace();
					}

				}
				finalframe.dispose();
				JOptionPane.showMessageDialog(null,"Successfully Updated "+mediaName2);
			}
		}
	}

	class cancelAction implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			finalframe.dispose();
		}
	}

    
    
}
