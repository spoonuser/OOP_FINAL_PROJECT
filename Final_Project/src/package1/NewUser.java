package package1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewUser extends JFrame {
	
	public NewUser() throws IOException{
		FileWriter writer = new FileWriter("login_password.txt",true);
		JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField loginField = new JTextField();
        JTextField passwordField = new JTextField();
        JButton registrateButton = new JButton("Registrate");
        String[] roles = {"Student","Manager", "Admin", "Finance Manager","Teacher"};
        JComboBox student = new JComboBox(roles);
        student.addActionListener(student);
        student.setBounds(40,150,100,20);

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(null);
        this.setBounds(400,200,500, 300);


        loginLabel.setBounds(50, 50, 100, 30);
        loginField.setBounds(150, 50, 250, 30);

        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 250, 30);
        registrateButton.setBounds(150, 205, 200, 50);

        this.add(loginLabel);
        this.add(loginField);
        this.add(passwordLabel);
        this.add(passwordField);
        this.add(registrateButton);
        this.setVisible(true);
        this.add(student);
 
        registrateButton.addActionListener(e -> {
        	this.setVisible(false);
        	JOptionPane.showMessageDialog(this, "Succes", "Error", JOptionPane.DEFAULT_OPTION);
        	try {
                writer.write("\n"+loginField.getText()+":"+passwordField.getText());
                writer.flush();
    		}
    		catch(IOException e1) {
    			e1.printStackTrace();
    		}
        });
	}
}