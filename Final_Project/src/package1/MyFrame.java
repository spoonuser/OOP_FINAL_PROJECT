package package1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicMenuItemUI;

public class MyFrame extends JFrame implements ActionListener {
    JMenuBar menuBar = new JMenuBar();
    JMenu fileMenu = new JMenu("Education");
    JMenu ResearchMenu = new JMenu("Researches");
    JMenuItem ScheduleItem = new JMenuItem("Courses");
    ImageIcon ScheduleIcon = new ImageIcon("file (1).png");
    JPanel hiddenPanel = new JPanel();
    JLabel label = new JLabel("Тут короче рассписание, добавим другие кнопки для коментариев и research");
    
    ImageIcon backgroundIcon = new ImageIcon("zaeb.jpg");  
    JLabel backgroundLabel = new JLabel(backgroundIcon);
    
   

    MyFrame() {
        UIManager.put("MenuItem.borderPainted", false);
        UIManager.put("MenuItem.background", Color.decode("#fdda7e"));
        UIManager.put("MenuItem.borderPainted", false);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1200, 600);

        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.setContentPane(backgroundLabel);
        
        
        backgroundLabel.setLayout(null);
        this.setContentPane(backgroundLabel);

        ScheduleItem.addActionListener(this);
        ScheduleItem.setMnemonic(KeyEvent.VK_1);
        ScheduleItem.setIcon(ScheduleIcon);

        fileMenu.add(ScheduleItem);

        menuBar.add(fileMenu);
        menuBar.add(ResearchMenu);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        
        JLabel hiddenPanelBackground = new JLabel(new ImageIcon("Снимок экрана 2024-11-15 152145.png"));
        hiddenPanelBackground.setBounds(0, 0, 700, 500); 
        hiddenPanel.add(hiddenPanelBackground);

        hiddenPanel.setLayout(new BorderLayout());
        hiddenPanel.setBounds(50, 50, 300, 300);
        hiddenPanel.setBackground(new java.awt.Color(173, 216, 230));
        
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 10);  
        hiddenPanel.setBorder(border);  
        hiddenPanel.setVisible(false);

        label.setBounds(100, 50, 200, 200);
        hiddenPanel.add(label);
        this.add(hiddenPanel);

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
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ScheduleItem) {
            hiddenPanel.setVisible(true);  
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}