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

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CabsShares extends JFrame implements ActionListener{
    JFrame f;
    JLabel l2,id15,id8;
    JTable j1;
    JButton b1,b2;
    String h[]={"FROM","TIME","DATE","CONTACT"};
    String d[][]=new String[15][4]; 
    int i=0,j=0;

    public CabsShares() {
        super("CAB SHARING");
        setSize(750,650);
        setLocation(200,200);
        setBackground(Color.black);
        
        f = new JFrame("CAB SHARING");
        f.setBackground(Color.BLACK);
     
        
        
        id15=new JLabel();
        id 16 = new JLable();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("friendinneed/icons/car2.jpeg"));
        Image i3 = img.getImage().getScaledInstance(920, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);
        f.add(id15);
        
        
        setLayout(new BorderLayout());
        JLabel background=new JLabel(new ImageIcon("/Users/monishv/NetBeansProjects/FriendInNeed/src/friendinneed/icons/car2.jpeg"));
        add(background);

        
        id8 = new JLabel("Cab Share availability");
        id8.setBounds(320,5,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id8.setBackground(Color.BLACK);
        id15.add(id8);
        f.add(id15);
        
        l2 = new JLabel("Add New Cabs");
        l2.setBounds(50,250,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        //l2.setBackground(Color.black);
       // l2.setForeground(Color.red);
        add(l2);
        
        b2 = new JButton("Add Cabs");
        b2.setBackground(Color.black);
        b2.setForeground(Color.black);
        b2.setBounds(350, 250, 150 ,30);
        add(b2);
        
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.black);

        try{
            String q="select * from cabs";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
            d[i][j++]=rs.getString("Destination");
                d[i][j++]=rs.getString("time");
                d[i][j++]=rs.getString("date");
                d[i][j++]=rs.getString("contact_number");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);
            j1.setBackground(Color.CYAN);

        }catch(Exception e){}
         //b1=new JButton("Print");
        //add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        //b1.addActionListener(this);
        
        f.getContentPane().setBackground(Color.black);
        setVisible(true);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b2){
            new CabsDetails().f.setVisible(true);
            //this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new CabsShares().setVisible(true);
    }
}
