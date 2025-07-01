/* 
import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener {

    long random;
    JTextField pan, aadhar;
    String formno;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, Occupation, education, income;

    Signup2(String formno){
        this.formno = formno;




        

        setLayout(null);

        setTitle("NEW ACCOUNT FORM - PAGE 2");


      


        JLabel AdditonalDetails = new JLabel(" PAGE 2 : Additonal Details ");
        AdditonalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        AdditonalDetails.setBounds(290 , 80 , 400, 30);
        add(AdditonalDetails);


        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100 , 140 , 100, 30);
        add(name);


        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);



        


        JLabel fname = new JLabel("Category :");        
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100 , 190 , 200, 30);
        add(fname);
        

        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        add(category);


        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100 , 240 , 200, 30);
        add(dob);

        String incomecategory[] = {"Null","<1,50,000","<2,50,000","<3,50,000","<3,50,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        add(income);


        JLabel gender = new JLabel("Educational :");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100 , 290 , 200, 30);
        add(gender);

     


        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100 , 315 , 200, 30);
        add(email);


        String educationValues [] = {"Non-Graduate","Graduation","Post-Graduation","Other",};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        add(education);


       

        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(100 , 390 , 200, 30);
        add(marital);


        String OccupationalValues [] = {"Salaried","Self Empolyed","Bussiness","Student","Other"};
        Occupation = new JComboBox(OccupationalValues);
        Occupation.setBounds(300, 390, 400, 30);
        add(Occupation);


        JLabel add = new JLabel("PAN Number :");
        add.setFont(new Font("Raleway",Font.BOLD, 20));
        add.setBounds(100 , 440 , 200, 30);
        add(add);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);


        JLabel city = new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100 , 490 , 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100 , 540 , 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 540 , 100, 30);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        add(sno);


        ButtonGroup emaritalGroup  = new ButtonGroup();
        emaritalGroup.add(syes);
        emaritalGroup.add(sno);


        JLabel pincode = new JLabel("Exisiting Account :");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100 , 590 , 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590 , 100, 30);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        add(eno);


        ButtonGroup omaritalGroup = new ButtonGroup();
        omaritalGroup.add(eyes);
        omaritalGroup.add(eno);


        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(620, 660, 80 ,30);
        next.addActionListener(this);
        add(next);



        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }








    public void actionPerformed(ActionEvent ae4){

        String form = this.formno;
        String sreligion = (String) religion.getSelectedItem(); //set text
        String scategory = (String) category.getSelectedItem();
        String sincome =    (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String sOccupation = (String) Occupation.getSelectedItem();
        String scitizen = null;
        if (syes.isSelected()) {
            scitizen = "Yes";
            
        } else if(sno.isSelected()){
            scitizen = "No";
        }

        

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";            
        } else if (eno.isSelected()) {
            existingaccount = "NO";
        }

        String span =  pan.getText();
        String saadhar = aadhar.getText();
        

        try {
          
                Conn c = new Conn();
                String query = "INSERT INTO signup2(formno, religion, category, income, education, Occupation, pan, aadhar, scitizen, existingaccount) " +
               "VALUES('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + sOccupation + "','" + span + "','" + saadhar + "','" + scitizen + "','" + existingaccount + "')";
              
              
               c.s.executeUpdate(query);

                //signup3
            } catch (Exception e) {
            e.printStackTrace();
        }  
    }




    public static void main(String[] args) {
        new Signup2("");
    }

    
}
*/

import java.awt.Color;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.*;


public class Signup2 extends JFrame implements ActionListener {

    long random;
    JTextField pan, aadhar;
    String formno;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religion, category, Occupation, education, income;

    Signup2(String formno){
        this.formno = formno;

        setLayout(null);

        setTitle("NEW ACCOUNT FORM - PAGE 2");

        JLabel AdditonalDetails = new JLabel(" PAGE 2 : Additonal Details ");
        AdditonalDetails.setFont(new Font("Raleway",Font.BOLD, 22));
        AdditonalDetails.setBounds(290 , 80 , 400, 30);
        add(AdditonalDetails);

        JLabel name = new JLabel("Religion :");
        name.setFont(new Font("Raleway",Font.BOLD, 20));
        name.setBounds(100 , 140 , 100, 30);
        add(name);

        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"}; 
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        add(religion);

        JLabel fname = new JLabel("Category :");        
        fname.setFont(new Font("Raleway",Font.BOLD, 20));
        fname.setBounds(100 , 190 , 200, 30);
        add(fname);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300, 190, 400, 30);
        add(category);

        JLabel dob = new JLabel("Income :");
        dob.setFont(new Font("Raleway",Font.BOLD, 20));
        dob.setBounds(100 , 240 , 200, 30);
        add(dob);

        String incomecategory[] = {"Null","<1,50,000","<2,50,000","<3,50,000","<3,50,000","upto 10,00,000"};
        income = new JComboBox(incomecategory);
        income.setBounds(300, 240, 400, 30);
        add(income);

        JLabel gender = new JLabel("Educational :");
        gender.setFont(new Font("Raleway",Font.BOLD, 20));
        gender.setBounds(100 , 290 , 200, 30);
        add(gender);

        JLabel email = new JLabel("Qualification :");
        email.setFont(new Font("Raleway",Font.BOLD, 20));
        email.setBounds(100 , 315 , 200, 30);
        add(email);

        String educationValues [] = {"Non-Graduate","Graduation","Post-Graduation","Other"};
        education = new JComboBox(educationValues);
        education.setBounds(300, 315, 400, 30);
        add(education);

        JLabel marital = new JLabel("Occupation :");
        marital.setFont(new Font("Raleway",Font.BOLD, 20));
        marital.setBounds(100 , 390 , 200, 30);
        add(marital);

        String OccupationalValues [] = {"Salaried","Self Empolyed","Bussiness","Student","Other"};
        Occupation = new JComboBox(OccupationalValues);
        Occupation.setBounds(300, 390, 400, 30);
        add(Occupation);

        JLabel add = new JLabel("PAN Number :");
        add.setFont(new Font("Raleway",Font.BOLD, 20));
        add.setBounds(100 , 440 , 200, 30);
        add(add);

        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14));
        pan.setBounds(300, 440, 400, 30);
        add(pan);

        JLabel city = new JLabel("Aadhar Number :");
        city.setFont(new Font("Raleway",Font.BOLD, 20));
        city.setBounds(100 , 490 , 200, 30);
        add(city);

        aadhar = new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD,14));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);

        JLabel state = new JLabel("Senior Citizen :");
        state.setFont(new Font("Raleway",Font.BOLD, 20));
        state.setBounds(100 , 540 , 200, 30);
        add(state);

        syes = new JRadioButton("YES");
        syes.setBounds(300, 540 , 100, 30);
        add(syes);

        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        add(sno);

        ButtonGroup emaritalGroup  = new ButtonGroup();
        emaritalGroup.add(syes);
        emaritalGroup.add(sno);

        JLabel pincode = new JLabel("Exisiting Account :");
        pincode.setFont(new Font("Raleway",Font.BOLD, 20));
        pincode.setBounds(100 , 590 , 200, 30);
        add(pincode);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590 , 100, 30);
        add(eyes);

        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        add(eno);

        ButtonGroup omaritalGroup = new ButtonGroup();
        omaritalGroup.add(eyes);
        omaritalGroup.add(eno);

        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,15));
        next.setBounds(620, 660, 80 ,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae4){

        String form = this.formno;
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String seducation = (String) education.getSelectedItem();
        String sOccupation = (String) Occupation.getSelectedItem();
        String scitizen = null;
        if (syes.isSelected()) {
            scitizen = "Yes";
        } else if(sno.isSelected()){
            scitizen = "No";
        }

        String existingaccount = null;
        if (eyes.isSelected()) {
            existingaccount = "Yes";            
        } else if (eno.isSelected()) {
            existingaccount = "No";
        }

        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try {
            if (span.equals("")) {
                JOptionPane.showMessageDialog(null, "PAN Number is Required");
            } else {
                Conn c = new Conn();
                String query = "INSERT INTO signup2(formno, religion, category, income, education, Occupation, pan, aadhar, scitizen, existingaccount) " +
                "VALUES('" + formno + "','" + sreligion + "','" + scategory + "','" + sincome + "','" + seducation + "','" + sOccupation + "','" + span + "','" + saadhar + "','" + scitizen + "','" + existingaccount + "')";
                
                c.s.executeUpdate(query);
                
                // Navigate to Signup3 page
                setVisible(false);
                new Signup3(formno).setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }

    public static void main(String[] args) {
        new Signup2("");
    }
}

