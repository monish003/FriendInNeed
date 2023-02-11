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

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;


public class Entries implements ActionListener {
    JFrame f;
    JLabel id1,id2,id3,id4,id15,id8;
    JTextField t1,t2,t3,t4;
    JButton b;


    public Entries() {
        
        f = new JFrame("Lost Belonings");
        f.setBackground(Color.white);
        f.setLayout(null);
        
        id15=new JLabel();
        id15.setBounds(0,0,900,700);
        id15.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("friendinneed/icons/lost.jpeg"));
        Image i3 = img.getImage().getScaledInstance(920, 600,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id15.setIcon(icc3);
        
        id8 = new JLabel("Entries for lost things");
        id8.setBounds(320,5,500,50);
        id8.setFont(new Font("serif",Font.ITALIC,25));
        id8.setForeground(Color.black);
        id15.add(id8);
        f.add(id15);
        
        id1 = new JLabel("Name");
        id1.setBounds(50,150,100,30);
        id1.setFont(new Font("serif",Font.BOLD,20));
        id1.setForeground(Color.white);
        id15.add(id1);

        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id15.add(t1);

        id2 = new JLabel("Item Name");
        id2.setBounds(400,150,200,30);
        id2.setFont(new Font("serif",Font.BOLD,20));
        id2.setForeground(Color.white);

        id15.add(id2);

        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id15.add(t2);

        id3= new JLabel("Found At");
        id3.setBounds(50,200,100,30);
        id3.setFont(new Font("serif",Font.BOLD,20));
        id3.setForeground(Color.white);

        id15.add(id3);

        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id15.add(t3);
        
        id4= new JLabel("Phone Number");  
        id4.setBounds(400,200,200,30);
        id4.setFont(new Font("serif",Font.BOLD,20));
        id4.setForeground(Color.white);
        id15.add(id4);

        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id15.add(t4);
        
        b = new JButton("Submit");
        b.setBackground(Color.white);
        b.setForeground(Color.black);
        b.setBounds(250,550,150,40);
        
        id15.add(b);
        
        b.addActionListener(this);
        
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
        
        if (ae.getSource() == b){
        
            try{
                Conn cc = new Conn();
                String q = "insert into LostThings values('"+a+"','"+bb+"','"+c+"','"+d+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Lost Things Details Inserted Successfully");
                f.setVisible(false);
                
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }
    
    }
    
    public static void main(String args[]){
    new Entries().f.setVisible(true);
    }
}
