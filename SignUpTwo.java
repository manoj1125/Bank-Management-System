
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class SignUpTwo extends JFrame implements ActionListener{
    
    JLabel addtionaldetails,rel,pan,aadhar,seniorcitizen,existingacnt,form1,form2;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JTextField panTextField,aadharTextField;
    JComboBox religion, category, income, qualification, occupation;
    String formno;
    SignUpTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ASimulatorSystem/icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l14 = new JLabel(i3);
        l14.setBounds(150, 0, 100, 100);
        add(l14);
        
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");
        
        addtionaldetails = new JLabel("Page 2: Additonal Details");
        addtionaldetails.setFont(new Font("Raleway", Font.BOLD, 18));
        addtionaldetails.setBounds(290, 80, 400, 30);
        add(addtionaldetails);
        
        rel = new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD, 18));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        
        String valReligion[] = {"Hindu, Muslim, Sikh, Christian, Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        String valcategory[] = {"General", "OBC", "SC", "ST"};
        category = new JComboBox(valcategory);
        category.setFont(new Font("Raleway", Font.BOLD, 18));
        category.setBounds(300, 190, 400, 30);
        add(category);
        
        String valincome[] = {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto <10,00,000"};
        income = new JComboBox(valincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);
        
        String valeducation[] = {"Student", "Non-Graduate", "Graduate", "Post Graduate","Doctrate", "Other"};
        qualification = new JComboBox(valeducation);
        qualification.setBounds(300, 315, 400, 30);
        qualification.setBackground(Color.WHITE);
        add(qualification);
        
        String valoccupation[] = {"Salaried", "Self-Employeed", "Businessman", "Student", "Retired"};
        JComboBox occupation = new JComboBox(valoccupation);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE); 
        add(occupation);
        
        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        pan.setBounds(300, 440, 400, 30);
        add(pan);
        
        panTextField = new JTextField();
        panTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        panTextField.setBounds(300, 490, 200, 30);
        add(panTextField);
                  
        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Raleway", Font.BOLD, 18));
        aadhar.setBounds(300, 490, 400, 30);
        add(aadhar);
        
        aadharTextField = new JTextField();
        aadharTextField.setFont(new Font("Raleway", Font.BOLD, 20));
        aadharTextField.setBounds(300, 490, 200, 30);
        add(aadharTextField);
                  
        
        seniorcitizen = new JLabel("Senior Citizen:");
        seniorcitizen.setFont(new Font("Raleway", Font.BOLD, 18));
        seniorcitizen.setBounds(100, 540, 200, 30);
        add(seniorcitizen);
        
        syes = new JRadioButton("YES");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);
        
        sno = new JRadioButton("NO");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);
        
        ButtonGroup sc = new ButtonGroup();
        seniorcitizen.add(syes);
        seniorcitizen.add(sno);
        
        existingacnt = new JLabel("Existing Account:");
        existingacnt.setFont(new Font("Raleway", Font.BOLD, 18));
        existingacnt.setBounds(100, 590, 200, 30);
        add(existingacnt);
        
        eyes = new JRadioButton("YES");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);
        
        eno = new JRadioButton("NO");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);
        
        ButtonGroup existingacnt = new ButtonGroup();
        existingacnt.add(eyes);
        existingacnt.add(eno);
        
        form1 = new JLabel("Form No:");
        form1.setFont(new Font("Raleway", Font.BOLD, 13));
        form1.setBound();
        add(form1);
        
        form2 = new JLabel(formno);
        form2.setFont(new Font("Raleway", Font.BOLD, 13));
        form2.setBounds();
        add(form2);
        
        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        
        l12.setBounds(700,10,60,30);
        add(l12);
        
        l13.setBounds(760,10,60,30);
        add(l13);
        
        l1.setBounds(280,30,600,40);
        add(l1);
        
        l2.setBounds(100,120,100,30);
        add(l2);
        
        c1.setBounds(350,120,320,30);
        add(c1);
        
        l3.setBounds(100,170,100,30);
        add(l3);
        
        c2.setBounds(350,170,320,30);
        add(c2);
        
        l4.setBounds(100,220,100,30);
        add(l4);
        
        c3.setBounds(350,220,320,30);
        add(c3);
        
        l5.setBounds(100,270,150,30);
        add(l5);
        
        c4.setBounds(350,270,320,30);
        add(c4);
        
        l11.setBounds(100,290,150,30);
        add(l11);
        
        l6.setBounds(100,340,150,30);
        add(l6);
        
        c5.setBounds(350,340,320,30);
        add(c5);
        
        l7.setBounds(100,390,150,30);
        add(l7);
        
        t1.setBounds(350,390,320,30);
        add(t1);
        
        l8.setBounds(100,440,180,30);
        add(l8);
        
        t2.setBounds(350,440,320,30);
        add(t2);
        
        l9.setBounds(100,490,150,30);
        add(l9);
        
        r1.setBounds(350,490,100,30);
        add(r1);
        
        r2.setBounds(460,490,100,30);
        add(r2);
        
        l10.setBounds(100,540,180,30);
        add(l10);
        
        r3.setBounds(350,540,100,30);
        add(r3);
        
        r4.setBounds(460,540,100,30);
        add(r4);
        
        b.setBounds(570,640,100,30);
        add(b);
        
        b.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,750);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String sreligion = (String) religion.getSelectedItem(); 
        String scategory = (String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String squalification = (String)qualification.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        
        
        
        String scitizen = null;
        if(syes.isSelected()){ 
            scitizen = "Yes";
        }
        else if(sno.isSelected()){ 
            scitizen = "No";
        } 
        
        String eaccount = null;
        if(eyes.isSelected()){ 
            eaccount = "Yes";
        }else if(eno.isSelected()){ 
            eaccount = "No";
        }
        
        String span = pan.getText();
        String saadhar = aadhar.getText();
        
        try{
            Conn c = new Conn();
            String query = "insert into SignUpTwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+squalification+"','"+soccupation+"','"+pan+"','"+aadhar+"','"+scitizen+"','"+eaccount+"')";
            c.s.executeUpdate(query);             
        } catch(Exception e){
            System.out.println(e);
        }

               
    }
    
    
    public static void main(String[] args){
        new SignUpTwo("").setVisible(true);
    }
}