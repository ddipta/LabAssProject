package labassistant;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;


class MediaResultWindow extends JFrame{

    public MediaResultWindow(String mediaName, String quantity) throws FileNotFoundException{
        double qty=Double.parseDouble(quantity);
		
		Scanner read = new Scanner(new FileReader("medias/"+mediaName));
		String whole="";
		
		while(read.hasNextLine())
			whole=whole.concat(read.nextLine()+"\n");
		
		String[] lines = whole.split("\n");
		//System.out.println(whole);
		
		JPanel boxpanel = new JPanel();
		JFrame frame = new JFrame();
		
		boxpanel.setLayout(new GridLayout(lines.length,1));
		
		
		
		for(int i = 0; i<lines.length;i++){
			String[] splited_line = lines[i].split("=");
			double res=(Double.parseDouble(splited_line[1])*qty)/1000;
			JPanel linePanel = new JPanel();
			JLabel name = new JLabel();
			JLabel amount = new JLabel();
			name.setText(splited_line[0]+": ");
			amount.setText(res+" mg");
			linePanel.add(name);
			linePanel.add(Box.createHorizontalGlue());
			linePanel.add(amount);
			//System.out.println(splited_line);
			boxpanel.add(linePanel);
	
			
		}
		
		JScrollPane jScrollPane = new JScrollPane(boxpanel);
		
	    
	    frame.getContentPane().add(jScrollPane, BorderLayout.CENTER);
		
		frame.setTitle(qty+" ml "+mediaName);
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setVisible(true);
    }

    
}
