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

public class RoomAvail extends JFrame implements ActionListener {
    JFrame f;
     JLabel l2;
    JTable j1;
    JButton b1,b2;
    String h[]={"NAME","ROOM TYPE","VACANCY","PHONE NO","ADDRESS"};
    String d[][]=new String[10][5];  
    int i=0,j=0;

    public RoomAvail() {
        setSize(750,650);
        setLocation(200,200);
        
        l2 = new JLabel("Add New Rooms");
        l2.setBounds(50,250,400,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        add(l2);
        
        b2 = new JButton("Add Rooms");
        b2.setBackground(Color.gray);
        b2.setForeground(Color.black);
        b2.setBounds(300, 250, 150 ,30);
        add(b2);
        
        b2.addActionListener(this);
        
        try{
            String q="select * from rooms";
            Conn c1=new Conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
            d[i][j++]=rs.getString("name");
                d[i][j++]=rs.getString("roomtype");
                d[i][j++]=rs.getString("vacancy");
                d[i][j++]=rs.getString("phoneNo");
                d[i][j++]=rs.getString("address");
                i++;
                j=0;
            }
        
            j1=new JTable(d,h);
            j1.setBackground(Color.cyan);

        }catch(Exception e){}
         
        
        
        JScrollPane sp = new JScrollPane(j1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.gray);

        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b2){
            new Roomdetail().f.setVisible(true);
            this.setVisible(false);
        }
        
    }
    public static void main(String args[]){
    new RoomAvail().setVisible(true);
    }
    
}
