//package bank.management.system;
/* 
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {


    JButton login , signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

Login(){

    setTitle("AUTOMATED TELLER MACHINE");

    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 =  i1.getImage() .getScaledInstance(100 , 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel labil = new JLabel(i3);
    labil.setBounds(70 , 10 , 100 , 100);
    add(labil);


    JLabel text = new JLabel(" WELCOME TO ATM ");
    text.setFont(new Font (" Osward ", Font.BOLD, 30) );
    text.setBounds(200 , 50 , 350, 40 );
    add(text);

    JLabel cardno = new JLabel(" CARD NO : ");
    cardno.setFont(new Font (" Osward ", Font.BOLD, 28) );
    cardno.setBounds(120 , 150 , 250, 40 );
    add(cardno);

    cardTextField = new JTextField();
    cardTextField.setBounds(300, 150, 250, 40);
    add(cardTextField);


    JLabel pin = new JLabel(" PIN : ");
    pin.setFont(new Font (" Osward ", Font.BOLD, 28) );
    pin.setBounds(120 , 220 , 350, 40 );
    add(pin);

    pinTextField = new JPasswordField();
    pinTextField.setBounds(300, 220,350, 40);
    add(pinTextField);

    login = new JButton("SIGN IN ");
    login.setBounds(300, 300, 100 , 30);
    login.addActionListener(this);
    add(login);

    clear = new JButton(" CLEAR ");
    clear.setBounds(430, 300, 100 , 30);
    clear.addActionListener(this);
    add(clear);

    signup = new JButton(" SIGN UP ");
    signup.setBounds(300, 350, 230 , 30);
    signup.addActionListener(this);
    add(signup);


    getContentPane () .setBackground(Color.WHITE);



    setSize(800,480);
    setVisible(true);
    setLocation(350,200);

}
public void actionPerformed(ActionEvent ae4){

if (ae4.getSource() == clear) {
    cardTextField.setText("");
    pinTextField.setText("");
        

}
else if (ae4.getSource() == login) {
    cardTextField.setText("");
}

else if (ae4.getSource() == signup ){
    cardTextField.setText("");
    setVisible(false);
    new Signup().setVisible(true);


}
}

    public static void main(String[] args) {

        new Login();
        
    }
}

*/

//package bank.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {


    JButton login , signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;

Login(){

    setTitle("AUTOMATED TELLER MACHINE");

    setLayout(null);

    ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
    Image i2 =  i1.getImage() .getScaledInstance(100 , 100, Image.SCALE_DEFAULT);
    ImageIcon i3 = new ImageIcon(i2);
    JLabel labil = new JLabel(i3);
    labil.setBounds(70 , 10 , 100 , 100);
    add(labil);


    JLabel text = new JLabel(" WELCOME TO ATM ");
    text.setFont(new Font (" Osward ", Font.BOLD, 30) );
    text.setBounds(200 , 50 , 350, 40 );
    add(text);

    JLabel cardno = new JLabel(" CARD NO : ");
    cardno.setFont(new Font (" Osward ", Font.BOLD, 28) );
    cardno.setBounds(120 , 150 , 250, 40 );
    add(cardno);

    cardTextField = new JTextField();
    cardTextField.setBounds(300, 150, 250, 40);
    add(cardTextField);


    JLabel pin = new JLabel(" PIN : ");
    pin.setFont(new Font (" Osward ", Font.BOLD, 28) );
    pin.setBounds(120 , 220 , 350, 40 );
    add(pin);

    pinTextField = new JPasswordField();
    pinTextField.setBounds(300, 220,350, 40);
    add(pinTextField);

    login = new JButton("SIGN IN ");
    login.setBounds(300, 300, 100 , 30);
    login.addActionListener(this);
    add(login);

    clear = new JButton(" CLEAR ");
    clear.setBounds(430, 300, 100 , 30);
    clear.addActionListener(this);
    add(clear);

    signup = new JButton(" SIGN UP ");
    signup.setBounds(300, 350, 230 , 30);
    signup.addActionListener(this);
    add(signup);


    getContentPane () .setBackground(Color.WHITE);



    setSize(800,480);
    setVisible(true);
    setLocation(350,200);

}
public void actionPerformed(ActionEvent ae4){

if (ae4.getSource() == clear) {
    cardTextField.setText("");
    pinTextField.setText("");
        

}
else if (ae4.getSource() == login) {
    try {
        String cardnumber = cardTextField.getText();
        String pinnumber = new String(pinTextField.getPassword());
        
        if (cardnumber.equals("") || pinnumber.equals("")) {
            JOptionPane.showMessageDialog(null, "Please enter both Card Number and PIN");
            return;
        }
        
        Conn conn = new Conn();
        String query = "select * from login where cardno = '" + cardnumber + "' and pin = '" + pinnumber + "'";
        ResultSet rs = conn.s.executeQuery(query);
        
        if (rs.next()) {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
        }
    } catch (Exception e) {
        System.out.println(e);
    }
}

else if (ae4.getSource() == signup ){
    setVisible(false);
    new Signup().setVisible(true);


}
}

    public static void main(String[] args) {

        new Login();
        
    }
}