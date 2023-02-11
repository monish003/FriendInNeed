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
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,id15,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2,b3;
    
    Login(){
    super("Login");
    
    setBackground(Color.black);
    setLayout(null);
     
 
        
    l1 = new JLabel("Username");
    l1.setBounds(40,20,100,30);
    l1.setForeground(Color.white);
    add(l1);
    
        
    l2 = new JLabel("Password");
    l2.setBounds(40,70,100,30);
    l2.setForeground(Color.white);

    add(l2);
    
    
 
    t1=new JTextField();
    t1.setBounds(150,20,150,30);
    add(t1);

    t2=new JPasswordField();
    t2.setBounds(150,70,150,30);
    add(t2);    
        
        
    b1 = new JButton("Login");
    b1.setBounds(40,140,120,30);
    b1.setFont(new Font("serif",Font.BOLD,15));
    b1.addActionListener(this);
    b1.setBackground(Color.white);
    b1.setForeground(Color.black);
    add(b1);

    b2=new JButton("Cancel");
    b2.setBounds(180,140,120,30);
    b2.setFont(new Font("serif",Font.BOLD,15));
    b2.setBackground(Color.white);
    b2.setForeground(Color.black);
    add(b2);
    


    b2.addActionListener(this);
    getContentPane().setBackground(Color.darkGray);
    
    b3=new JButton("SIGN UP");
    b3.setBounds(360,140,120,30);
    b3.setFont(new Font("serif",Font.BOLD,18));
    b3.setBackground(Color.white);
    b3.setForeground(Color.black);
    add(b3);
        
    b3.addActionListener(this);

    setVisible(true);
    setSize(600,300);
    setLocation(500,300);
    
    
    
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == b3){
                    new signup().f.setVisible(true);
                    this.setVisible(false);
                   }
        
        try{
          
           
            Conn c1 = new Conn();
                    String u = t1.getText();
                    String v = t2.getText();
                    
                    String q = "select * from login where username='"+u+"' and password='"+v+"'";
                    
                    ResultSet rs = c1.s.executeQuery(q);
                   
                    
                    if(rs.next()){
                    new page().setVisible(true);
                    setVisible(false);
                     }
                    
                    else{
                   // JOptionPane.showMessageDialog(null, "invalid login entered");
                    setVisible(false);
                    }
                    
              
                            
        }
        catch(Exception e){
        e.printStackTrace();
        }
       
        
            
         
    }
            
    public static void main(String args[]){
    Login l = new Login();
    //new signup().setVisible(true);
    }
}
