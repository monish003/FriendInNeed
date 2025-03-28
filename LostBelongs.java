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

public class LostBelongs extends JFrame implements ActionListener {
    
    JFrame f; 
    JLabel l2;
    JTable j1;
    JButton b1,b2;
    String h[]={"NAME","ITEM NAME","FOUND AT","PHONE NO"};
    String d[][]=new String[15][4];  
    int i=0,j=0;

    public LostBelongs() {
        setSize(750,650);
        setLocation(200,200);
        
        l2 = new JLabel("Add New Entry");
        l2.setBounds(50,250,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add lost items");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.black);
        b2.setBounds(300, 250, 150 ,30);
        add(b2);
        
        b2.addActionListener(this);
        

        try{
            String q="select * from LostThings";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
            d[i][j++]=rs.getString("Name");
                d[i][j++]=rs.getString("ItemName");
                d[i][j++]=rs.getString("FoundAt");
                d[i][j++]=rs.getString("PhoneNo");
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

        b2 = new JButton("Add lost items");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.black);
        b2.setBounds(300, 250, 150 ,30);
        add(b2);
        
    }
        public void actionPerformed(ActionEvent ae){
            
        
        if(ae.getSource() == b2){
            new Entries().f.setVisible(true);
            this.setVisible(false);
            
        }
    }
        public static void main (String args[]){
        new LostBelongs().setVisible(true);
            
        }
   
}
