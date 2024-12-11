package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.event.TableModelEvent;
import javax.swing.plaf.basic.BasicMenuItemUI;
import javax.swing.table.DefaultTableModel;

import xddddd.MyFrame;

public class Main{
	JButton submitbutton;
	JRadioButton button_13;
	JRadioButton button_37;
	JRadioButton button_710;
	JComboBox teacher_list;
	DefaultTableModel model;
    static JTable tablerg;
	static Cours_rgst_pan rgstPan = new Cours_rgst_pan();
	static rgst_frame rgs_frame;
	String[] teachs;
	static String Education;
	public static void main(String[] args) {
		////////////////////Courses
        Courses course = new Courses("Physical Education", 10, "Site");
	    //////////////////Courses
		ImageIcon bg_pan = new ImageIcon("bg_panel.jpg");
		JPanel bg_panel = new JPanel();
		bg_panel.setSize(300,300);
		Education = "Education";
		
		//change language buttons
		JButton ru_button = new JButton("RU");
		ru_button.setFocusable(false);
		ru_button.setBounds(1000,20,80,40);
		
		JButton eng_button = new JButton("ENG");
		eng_button.setFocusable(false);
		eng_button.setBounds(1100,20,80,40);
		//change language buttons
		JFrame courses_table_frame = new JFrame();
		courses_table_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		courses_table_frame.setBounds(300,300,800,500);
		//Rate Teachers
		JFrame Rate_frame = new JFrame();
		Rate_frame.setVisible(false);
		Rate_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Rate_frame.setBounds(300,300,500,500);
		String[] teachs = {"Izbasar Asylzhan","Dzhanka", "Arnur Kelgenbaev", "Larisa Li Borisovna","Usykin"};
		JComboBox teacher_list = new JComboBox(teachs);
		teacher_list.addActionListener(teacher_list);
		Rate_frame.setLayout(null);
		teacher_list.setBounds(50,50,400,50);
		Rate_frame.add(teacher_list);
		ButtonGroup group = new ButtonGroup();
		JButton submitbutton = new JButton("Submit");
		submitbutton.setBounds(200,400,100,50);
		
		JRadioButton button_13 = new JRadioButton("1-3");
		JRadioButton button_37 = new JRadioButton("3-7");
		JRadioButton button_710 = new JRadioButton("7-10");
		
		button_13.addActionListener(e -> {
		    JOptionPane.showMessageDialog(Rate_frame, 
		        teacher_list.getSelectedItem()+"'s rate is 1-3", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		button_37.addActionListener(e -> {
		    JOptionPane.showMessageDialog(Rate_frame, 
		        teacher_list.getSelectedItem()+"'s rate is 3-7", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		button_710.addActionListener(e -> {
		    JOptionPane.showMessageDialog(Rate_frame, 
		        teacher_list.getSelectedItem()+"'s rate is 7-10", 
		        "Rating Selected", 
		        JOptionPane.INFORMATION_MESSAGE);
		});
		submitbutton.addActionListener(e -> {
			Rate_frame.setVisible(false);
		});
		
		group.add(button_13);
		group.add(button_37);
		group.add(button_710);
		
		schedule_frame viewLessons = new schedule_frame();
		
		JLabel ratingLabel = new JLabel("Select a rating range:");
		ratingLabel.setBounds(150, 250, 300, 30);

		Font labelFont = new Font("Serif", Font.PLAIN, 24);
		ratingLabel.setFont(labelFont);

		Rate_frame.add(ratingLabel);
		
		button_13.setBounds(125,300,100,100);
		button_13.setFocusable(false);
		
		button_37.setBounds(225,300,100,100);
		button_37.setFocusable(false);
		
		button_710.setBounds(325,300,100,100);
		button_710.setFocusable(false);
		
		Rate_frame.add(button_13);
		Rate_frame.add(button_37);
		Rate_frame.add(button_710);
		Rate_frame.add(submitbutton);
		//RateTeachers///////////////////////////////////////////
		//view_transcript
		JButton download = new JButton("Download");
		download.setFocusable(false);
		download.setPreferredSize(new Dimension(100,50));
		JPanel buttonPanel = new JPanel();
        buttonPanel.add(download);
		JFrame TranscriptFrame = new JFrame("Transcript");
        TranscriptFrame.setBounds(300, 300, 900, 300);
        TranscriptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        TranscriptFrame.setLayout(new BorderLayout());
        TranscriptFrame.add(buttonPanel, BorderLayout.SOUTH);
		String[] transcript_columns = {"Cipher","Course name","Credits","ECTS","Rate","GPA"};
		String[][] argss = {{"LAN1183","English Intermediate","6","10","80","3.5"},
				{"STAT2201","Statistics","6","10","70.1","3.5"},
				{"MATH1203","Linear Algebra","6","10","70.1","3.5"},
				{"FUN1105","Physics","6","10","70.1","3.5"},
				{"CSCI1204","Programming Principle","6","10","70.1","3.5"},
				{"CSCI2104","Dara base","6","10","70.1","3.5"},
				{"CSCI2105","Alghoritms and Structures","6","10","70.1","3.5"},
				{"LAN1119","Russian","6","10","70.1","3.5"},
				{"MATH1202","Mathematical analysis","6","10","70.1","3.5"},
				{"PHE101","Physical Education","6","10","70.1","3.5"},
				{"CSCI1102","Discrete Structures","6","10","70.1","3.5"},
				{"HUM1141","Evolution and Global","6","10","70.1","3.5"},
				{"CSCI1126","OOP","6","10","70.1","3.5"}
				};
		/////Get Transcript
		////////////////
		
		Student student1 = new Student("Saitama", 29, "1punch", "man","bachelor","23B01");
		///////////////////////////////////////////////////
		JFrame frame = new JFrame();
		JMenuBar menuBar = new JMenuBar();
		JMenu transcript = new JMenu("Transcript");
		JMenuItem view_transcript = new JMenuItem("View Transcript");
		JMenuItem register_for_courses = new JMenuItem("Course Registration");
	    JMenu fileMenu = new JMenu(Education);
	    JMenu Teachers = new JMenu("Teachers");
	    JMenu Lessons = new JMenu("Lessons");
	    
	    JMenuItem ScheduleItem = new JMenuItem("Courses");
	    JMenuItem RateTeachers = new JMenuItem("Rates");
	    ImageIcon ScheduleIcon = new ImageIcon("file (1).png");
	    ImageIcon TeacherIcon = new ImageIcon("file (4) (1).png");
	    ImageIcon TransriptIcon = new ImageIcon("Remove background project.png");
	    ImageIcon RegistrationIcon = new ImageIcon("registration_icon.png");
	    JMenuItem ViewLessons = new JMenuItem("Lessons Schedule");

	    ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");
	    ImageIcon Lessons_Icon = new ImageIcon("file (7) (1).png");
	    JPanel hiddenPanel = new JPanel();
	    JLabel label = new JLabel(student1.view_courses());
	     
	    JLabel backgroundLabel = new JLabel(backgroundIcon);
	    
	    UIManager.put("MenuItem.borderPainted", false);
        UIManager.put("MenuItem.background", Color.decode("#fdda7e"));
        UIManager.put("MenuItem.borderPainted", false);
        
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());
        frame.setContentPane(backgroundLabel);
        
        //change language buttons
        frame.add(ru_button);
        frame.add(eng_button);
        
        
        backgroundLabel.setLayout(null);
        frame.setContentPane(backgroundLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setBounds(20,10,1200,700);

        ScheduleItem.setMnemonic(KeyEvent.VK_1);
        ScheduleItem.setIcon(ScheduleIcon);
        RateTeachers.setIcon(TeacherIcon);
        view_transcript.setIcon(TransriptIcon);
        register_for_courses.setIcon(RegistrationIcon);
        ViewLessons.setIcon(Lessons_Icon);
        Lessons.add(ViewLessons);

        fileMenu.add(ScheduleItem);
        fileMenu.add(register_for_courses);
        Teachers.add(RateTeachers);
        transcript.add(view_transcript);

        menuBar.add(fileMenu);
        menuBar.add(Teachers);
        menuBar.add(transcript);
        menuBar.add(Lessons);
        frame.setJMenuBar(menuBar);
        
        JLabel hiddenPanelBackground = new JLabel(new ImageIcon("Снимок экрана 2024-11-15 152145.png"));
        hiddenPanelBackground.setBounds(0, 0, 700, 500); 
        hiddenPanel.add(hiddenPanelBackground);

        hiddenPanel.setLayout(null);
        hiddenPanel.setBounds(50, 50, 300, 300);
        hiddenPanel.setBackground(new java.awt.Color(173, 216, 230));
        
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);  
        hiddenPanel.setBorder(border);  
        hiddenPanel.setVisible(false);

        label.setBounds(100, 50, 200, 200);
        hiddenPanel.add(label);
        frame.add(hiddenPanel);

        ScheduleItem.setUI(new BasicMenuItemUI() {
            protected void installDefaults() {
                super.installDefaults();
                selectionBackground = Color.decode("#e6b800");
                selectionForeground = Color.BLACK; 
            }

            public void paint(Graphics g, JComponent c) {
                ((AbstractButton) c).setBorderPainted(false);
                super.paint(g, c);
            }
        });
        
        
        frame.setVisible(false);
	    ///////////////////////////////////////////////////
		//////////////////////////////////////////////////////////////////
		
		User user1 = new User("Jhon", 18, "jhonny", "13579","bachelor");
		User user2 = new User("Maria", 18, "mary", "2468","bachelor");
		User user3 = new User("Gabriel", 37, "gabe", "1488","teacher");
		User user4 = new User("Gabriel", 37, "OOPTIMISTS", "1234","teacher");
		User user0 = new User("Gabriel", 37, "OOPTIMISTS", "1234","teacher");
		Object arr[] = {user1, user2, user3, student1};
		ArrayList <Object> list = new ArrayList<>();
	
		JLabel loginLabel = new JLabel("Login:");
        JLabel passwordLabel = new JLabel("Password:");
        JTextField loginField = new JTextField();
        JTextField passwordField = new JTextField();
        JButton loginButton = new JButton("Log In");
        JButton registrateLoginButton = new JButton("Registrate");

        JFrame login_frame = new JFrame("Login Window");
        login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login_frame.setLayout(null);
        login_frame.setBounds(400,200,500, 300);


        loginLabel.setBounds(50, 50, 100, 30);
        loginField.setBounds(150, 50, 250, 30);

        passwordLabel.setBounds(50, 100, 100, 30);
        passwordField.setBounds(150, 100, 250, 30);

        loginButton.setBounds(150, 150, 200, 50);
        registrateLoginButton.setBounds(150, 205, 200, 50);

      
        login_frame.add(loginLabel);
        login_frame.add(loginField);
        login_frame.add(passwordLabel);
        login_frame.add(passwordField);
        login_frame.add(loginButton);
        login_frame.add(registrateLoginButton);
        login_frame.setVisible(true);

        loginButton.addActionListener(e -> {
            boolean try_again = true;
            try {
                BufferedReader reader = new BufferedReader(new FileReader("login_password.txt"));
                String line;

                while ((line = reader.readLine()) != null) {
                    String[] credentials = line.split(":");
                    String fileLogin = credentials[0];
                    String filePassword = credentials[1];
                    if (loginField.getText().equals(fileLogin) && passwordField.getText().equals(filePassword)) {
                        login_frame.setVisible(false);
                        try_again = false;
                        frame.setVisible(true);
                        break;
                    }
                }
                reader.close();
                if (try_again) {
                    JOptionPane.showMessageDialog(login_frame, "Invalid login or password. Try again.", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(login_frame, "Error reading file.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        ScheduleItem.addActionListener(e -> {
        	JTable table = new JTable(course.getData(),course.getColumns());
    		JScrollPane pane = new JScrollPane(table);
    		courses_table_frame.add(pane);
    		courses_table_frame.setVisible(true);
    		
        });
        RateTeachers.addActionListener(e -> {
        	Rate_frame.setVisible(true);
        });
        view_transcript.addActionListener(e -> {
            JTable transcript_table = new JTable(argss , transcript_columns);
            JScrollPane pane = new JScrollPane(transcript_table);
            TranscriptFrame.add(pane);
            TranscriptFrame.setVisible(true);
        });
        ru_button.addActionListener(e -> {
        	Education = "Образование";
            fileMenu.setText(Education);
            transcript.setText("Транскрипт");
            Teachers.setText("Учителя");
            RateTeachers.setText("Рейтинги");
            ScheduleItem.setText("Курсы");
            view_transcript.setText("Посмотреть транскрипт");
        });
        eng_button.addActionListener(e -> {
        	Education = "Education";
            fileMenu.setText(Education);
            transcript.setText("Transcript");
            Teachers.setText("Employees");
            RateTeachers.setText("Rate Teachers");
            ScheduleItem.setText("Courses");
            view_transcript.setText("View Courses");
        });
        register_for_courses.addActionListener(e -> {
        	rgs_frame = new rgst_frame();
        });
        ViewLessons.addActionListener(e -> {
        	viewLessons.setVisible(true);
        });
        registrateLoginButton.addActionListener(e -> {
        	try {
				NewUser useRg = new NewUser();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        });
        download.addActionListener(e -> {
        	try {
    			FileWriter writer = new FileWriter("transcript .txt");
    			for (String[] row : argss) {
                    for (String cell : row) {
                        writer.write(cell + "\t");
                    }
                    writer.write("\n");
                }
    			writer.close();
    		}
    		catch(IOException e1) {
    			e1.printStackTrace();
    		}
        });
	}
}