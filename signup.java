/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendinneed;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author monishv
 */
public class signup extends JFrame implements ActionListener {
    
    JFrame f;
    JLabel i1,i2,i3,i4,i5;
    JTextField t1,t2,t3,t4,t5;
    JButton b,b1;
    
    
    public signup(){
        
    setBackground(Color.black);
    setLayout(null);
     f = new JFrame("SIGN UP");
     f.setBackground(Color.black);
     f.setLayout(null);
     
        i1 = new JLabel("Name : ");
        i1.setBounds(50,150,100,30);
        i1.setFont(new Font("serif",Font.BOLD,20));
        i1.setForeground(Color.black);
        f.add(i1);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        f.add(t1);
            
        i1 = new JLabel("Name : ");
        i1.setBounds(50,150,100,30);
        i1.setFont(new Font("serif",Font.BOLD,20));
        i1.setForeground(Color.black);
        f.add(i1);
        
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        f.add(t1);
        
        i2 = new JLabel("Password : ");
        i2.setBounds(50,200,100,30);
        i2.setFont(new Font("serif",Font.BOLD,20));
        i2.setForeground(Color.black);
        f.add(i2);
        
        t2=new JTextField();
        t2.setBounds(200,200,150,30);
        f.add(t2);
        
        i3 = new JLabel("Gender : ");
        i3.setBounds(50,250,100,30);
        i3.setFont(new Font("serif",Font.BOLD,20));
        i3.setForeground(Color.black);
        f.add(i3);
        
        t3=new JTextField();
        t3.setBounds(200,250,150,30);
        f.add(t3);
        
        i4 = new JLabel("DateOfBirth");
        i4.setBounds(50,300,100,30);
        i4.setFont(new Font("serif",Font.BOLD,18));
        i4.setForeground(Color.black);
        f.add(i4);
        
        t4=new JTextField();
        t4.setBounds(200,300,150,30);
        f.add(t4);
        
        i5 = new JLabel("Email : ");
        i5.setBounds(50,350,100,30);
        i5.setFont(new Font("serif",Font.BOLD,20));
        i5.setForeground(Color.black);
        f.add(i5);
        
        t5=new JTextField();
        t5.setBounds(200,350,150,30);
        f.add(t5);
        
        b = new JButton("Submit");
        b.setBackground(Color.blue);
        b.setForeground(Color.black);
        b.setBounds(250,550,150,40);
        
        f.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.gray);
        b1.setForeground(Color.black);
        b1.setBounds(450,550,150,40);
        
        f.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        
        
        f.setVisible(true);
        f.setSize(900,700);
        f.setLocation(400,150);
        f.getContentPane().setBackground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
         String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
        
        if (ae.getSource() == b){
        
            try{
                Conn cc = new Conn();
                String q = "insert into login values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Signup Details Inserted Successfully");
                f.setVisible(false);
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Login().setVisible(true);
            
        }
        
    }
    public static void main(String args[]){
    new signup().f.setVisible(true);
    }
}
