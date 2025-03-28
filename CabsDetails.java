/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package friendinneed;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author monishv
 */
public class CabsDetails implements ActionListener{
    
    JFrame f;
    JLabel id8,id1,id2,id3,id4,id15,id5;
    JTextField t1,t2,t3,t4,t5;
    JButton b,b1;
    
    

    public CabsDetails() {
        
        f = new JFrame("CABS DETAILS");
        f.setBackground(Color.white);
        
        f.setLayout(null);
        
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("friendinneed/icons/car.jpg"));
        Image i3 = img.getImage().getScaledInstance(920, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);
        
        
        id8 = new JLabel("CABS Details");
        id8.setBounds(320,5,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);
        
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.WHITE);
        id15.add(id1);
        

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Destination");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.WHITE);
        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Time");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.WHITE);
        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);
        
                id4= new JLabel("Date");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id4.setForeground(Color.WHITE);
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);

        id5= new JLabel("Contant No");
        id5.setBounds(50,250,100,30);
        id5.setFont(new Font("serif",Font.BOLD,20));
        id5.setForeground(Color.WHITE);
        id15.add(id5);

        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        id15.add(t5);
        
        
        b = new JButton("Submit");
        b.setBackground(Color.white);
        b.setForeground(Color.black);
        b.setBounds(250,550,150,40);
        
        id15.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.gray);
        b1.setForeground(Color.black);
        b1.setBounds(450,550,150,40);
        
        id15.add(b1);
        
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
                String q = "insert into cabs values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Cabs Details Inserted Successfully");
                f.setVisible(false);
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new page().setVisible(true);
            
        }
    
        }
    public static void main(String args[]){
    new CabsDetails().f.setVisible(true);
    }
    }
    

