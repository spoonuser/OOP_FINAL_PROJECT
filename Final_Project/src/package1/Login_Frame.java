package package1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Login_Frame extends JFrame implements ActionListener {
	JLabel login_Label = new JLabel("Login:");
    JLabel password_Label = new JLabel("Password:");
	public JTextField login_field = new JTextField();
	JTextField password_field = new JTextField();
	JButton login_button = new JButton("Log In");
	Login_Frame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setSize(500,500);

		login_Label.setBounds(50, 50, 100, 30); 
        login_field.setBounds(150, 50, 250, 30);

        password_Label.setBounds(50, 100, 100, 30);
        password_field.setBounds(150, 100, 250, 30);
        
        login_button.setBounds(150,150, 200, 50);
        
        this.add(login_Label);
        this.add(login_field);
        this.add(password_Label);
        this.add(password_field);
        this.add(login_button);
        
        this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==login_button){
			
			
		}
	}
}
