
package chatting.application;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;

public class Client extends JFrame implements ActionListener{
    
    JPanel p1;
    JTextField t1;
    JButton b1;
    static JTextArea a1;
    
    static Socket s;
    static DataInputStream din;
    static DataOutputStream dout;
    
    Client(){
        p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(7, 94, 84));
        p1.setBounds(0, 0, 300, 50);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l1 = new JLabel(i3);
        l1.setBounds(5,15,20,20);
        p1.add(l1);
        
        l1.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent ae){
                    System.exit(0);
                }
        });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/Ron.png"));
        Image i5 = i4.getImage().getScaledInstance(40,40, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel l2 = new JLabel(i6);
        l2.setBounds(35,5,40,40);
        p1.add(l2);
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(20,20, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel l5 = new JLabel(i9);
        l5.setBounds(220,15,20,20);
        p1.add(l5);
        
        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25,20, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel l6 = new JLabel(i12);
        l6.setBounds(250,15,25,20);
        p1.add(l6);
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("chatting/application/icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10,25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel l7 = new JLabel(i15);
        l7.setBounds(285,12,10,25);
        p1.add(l7);
        
        JLabel l3 = new JLabel("Ron");
        l3.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        l3.setBounds(80,8,100,22);
        l3.setForeground(Color.WHITE);
        p1.add(l3);
        
        JLabel l4 = new JLabel("Active Now");
        l4.setFont(new Font("SAN_SERIF", Font.PLAIN, 14));
        l4.setBounds(80,30,80,12);
        l4.setForeground(Color.WHITE);
        p1.add(l4);
        
        a1 = new JTextArea();
        a1.setBounds(5, 55 ,290, 400);
//        a1.setBackground(Color.pink);
        a1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        a1.setEditable(false);
        a1.setLineWrap(true);
        a1.setWrapStyleWord(true);
        add(a1);
        
        t1 = new JTextField();
        t1.setBounds(5, 465, 210, 30);
        t1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(t1);
        
        b1 = new JButton("Send");
        b1.setBounds(220, 465, 75, 30);
        b1.setBackground(new Color(7, 94,84));
        b1.setForeground(Color.WHITE);
        b1.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        b1.addActionListener(this);
        add(b1);
        
        
//        getContentPane().setBackground(Color.YELLOW);
        setLayout(null);
        setSize(300, 500);
        setLocation(800, 30);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        try{
        String out = t1.getText();
        a1.setText(a1.getText()+"\n\t\t\t"+out);
        dout.writeUTF(out);
        t1.setText("");
        }catch(Exception e){
            
        }
    }
    
    public static void main(String[] args){
        new Client().setVisible(true);
        
        try{
            s = new Socket("127.0.0.1", 6001);
            din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());
            
            String msginput = "";
            
            msginput = din.readUTF();
            a1.setText(a1.getText()+"\n"+msginput);
            
            
        }catch(Exception e){}
    
    }
}
