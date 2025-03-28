 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendinneed;

/**
 *
 * @author monishv
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class page extends JFrame implements ActionListener {
    public page() {
        super("FRIEND IN NEED");
        
        setSize(1920,1030);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("friendinneed/icons/front.jpeg"));
        Image i3 = ic.getImage().getScaledInstance(1900, 950,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(icc3);
        
        
        add(l1);
        
        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("CABS");
        JMenuItem m1 = new JMenuItem("CABS DETAILS");
        JMenuItem m2 = new JMenuItem("CABS SHARE");
        master.setForeground(Color.blue);

        JMenuBar mb  = new JMenuBar();
        JMenu master = new JMenu("CABS");
        JMenuItem m1 = new JMenuItem("CABS DETAILS");
        JMenuItem m2 = new JMenuItem("CABS SHARE");
        master.setForeground(Color.blue);
        
        
        //for cabs 
        m1.setFont(new Font("monospaced",Font.BOLD,16));
        //ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon1.png"));
        //Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        //m1.setIcon(new ImageIcon(image1));
        m1.setMnemonic('A');
        m1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        m1.setBackground(Color.WHITE);
        
        m2.setFont(new Font("monospaced",Font.BOLD,16));
        //ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon2.png"));
        //Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        //m2.setIcon(new ImageIcon(image2));
        m2.setMnemonic('B');
        m2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        m2.setBackground(Color.WHITE);
    
        
        m1.addActionListener(this);
        m2.addActionListener(this);
        
        // for handbook
        
        JMenu handbook = new JMenu("SECOND HANDBOOK");
        JMenuItem u1 = new JMenuItem("FILLIN DETAILS");
        JMenuItem u2 = new JMenuItem("HANDBOOKS");
        handbook.setForeground(Color.red);
        
        u1.setFont(new Font("monospaced",Font.BOLD,16));
        //ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon3.png"));
        //Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        //u1.setIcon(new ImageIcon(image4));
        u1.setMnemonic('C');
        u1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        u1.setBackground(Color.WHITE);
        
        u2.setFont(new Font("monospaced",Font.BOLD,16));
        //ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("university/management/system/icons/icon4.jpg"));
        //Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        //u2.setIcon(new ImageIcon(image5));
        u2.setMnemonic('D');
        u2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        u2.setBackground(Color.WHITE);
        
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu los = new JMenu("LOST BELONG");
        JMenuItem v1 = new JMenuItem("ENTRIES");
        JMenuItem v2 = new JMenuItem("Belongs");
        los.setForeground(Color.red);
        
        v1.setFont(new Font("monospaced",Font.BOLD,16));
        v1.setMnemonic('E');
        v1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        v1.setBackground(Color.WHITE);
        
        
        v2.setFont(new Font("monospaced",Font.BOLD,16));
        v2.setMnemonic('F');
        v2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        v2.setBackground(Color.WHITE);
        
        v1.addActionListener(this);
        v2.addActionListener(this);
        
        JMenu Rent = new JMenu("RENT SHARING");
        JMenuItem o1  = new JMenuItem("Room details");
        JMenuItem o2 = new JMenuItem("Room availability");
        Rent.setForeground(Color.red);
        
        o1.setFont(new Font("monospaced",Font.BOLD,16));
        o1.setMnemonic('g');
        o1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        o1.setBackground(Color.WHITE);
        
        o2.setFont(new Font("monospaced",Font.BOLD,16));
        o2.setMnemonic('h');
        o2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        o2.setBackground(Color.WHITE);
        
        o1.addActionListener(this);
        o2.addActionListener(this);
        
        JMenu exit = new JMenu("EXIT");
        JMenuItem ex = new JMenuItem("Exit");
        exit.setForeground(Color.RED);
        
        ex.setFont(new Font("monospaced",Font.BOLD,16));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        
        ex.addActionListener(this);
        
        
        master.add(m1);
        master.add(m2);
        
        handbook.add(u1);
        handbook.add(u2);
        
        los.add(v1);
        los.add(v2);
        
        Rent.add(o1);
        Rent.add(o2);
        
        exit.add(ex);

        
        mb.add(master);
        mb.add(handbook);
        mb.add(los);
        mb.add(Rent);
        mb.add(exit);
        
        
        setJMenuBar(mb);
        
        setFont(new Font("Senserif",Font.BOLD,16));
        setLayout(new FlowLayout());
        setVisible(false);
    }
        public void actionPerformed(ActionEvent ae){
        //public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if(msg.equals("CABS SHARE")){
            new CabsShares().setVisible(true);
            
        }else if(msg.equals("CABS DETAILS")){
            new CabsDetails().f.setVisible(true);
            
        }else if(msg.equals("HANDBOOKS")){
            new Handbooks().setVisible(true);
            
        }else if(msg.equals("FILLIN DETAILS")){
            new FillinDetails().f.setVisible(true);
           
        }else if(msg.equals("Belongs")){
         new LostBelongs().setVisible(true);
         
    }else if(msg.equals("ENTRIES")){
        new Entries().f.setVisible(true);
        
    }else if(msg.equals("Room availability")){
        new RoomAvail().setVisible(true);
    
    }else if(msg.equals("Room details")){
        new Roomdetail().f.setVisible(true);
        
    }else if(msg.equals("Exit")){
            System.exit(0);}
        }
    public static void main(String[] args){
    new page().setVisible(true);
    }
 }
