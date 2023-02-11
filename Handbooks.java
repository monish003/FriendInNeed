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

public class Handbooks extends JFrame implements ActionListener {
    
    JFrame f; 
    JLabel l2,id15;
    JTable j1;
    JButton b1,b2;
    String h[]={"BOOK NAME","AUTHOR","PUBLICATION","PRICE"};
    String d[][]=new String[15][4];  
    int i=0,j=0;


    public Handbooks() {
        
        setSize(750,650);
        setLocation(200,200);
        
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("friendinneed/icons/books.jpeg"));
        Image i3 = img.getImage().getScaledInstance(920, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);
        
        l2 = new JLabel("Add New Books");
        l2.setBounds(50,250,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add Books");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.black);
        b2.setBounds(300, 250, 150 ,30);
        add(b2);
        
        b2.addActionListener(this);
        

        try{
            String q="select * from books";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
            d[i][j++]=rs.getString("BookName");
                d[i][j++]=rs.getString("AuthorName");
                d[i][j++]=rs.getString("publication");
                d[i][j++]=rs.getString("price");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);
            j1.setBackground(Color.cyan);
            

        }catch(Exception e){}
         //b1=new JButton("Print");
        //add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        //b1.addActionListener(this);
        
        getContentPane().setBackground(Color.gray);
        
        
    }
        public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b2){
            new FillinDetails().f.setVisible(true);
            //this.setVisible(false);
        }
        
    }
    
    public static void main(String[] args){
        new Handbooks().setVisible(true);
    }
    }
    
