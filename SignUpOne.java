
package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class SignUpOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, addressTextField, cityTextField, stateTextField, pincodeTextField, countryTextField; 
    JButton next;
    JRadioButton male, female, other, married, unmarried;
    JDateChooser datechooser;
  SignUpOne(){
     
      setLayout(null);
      
      Random ran =new Random();
      random = (Math.abs(ran.nextLong() & 9000L) +1000L);
        
      JLabel formno = new JLabel("Application Form NO. " +random);
      formno.setFont(new Font("Raleway", Font.BOLD, 38));
      formno.setBounds(140, 20, 600, 40);
      add(formno);
      
      JLabel personaldetails = new JLabel("Page 1: Personal Details");
      personaldetails.setFont(new Font("Raleway", Font.BOLD, 38));
      personaldetails.setBounds(290, 60, 300, 40);
      add(personaldetails);
      
      
      JLabel name = new JLabel("Name:");
      name.setFont(new Font("Raleway", Font.BOLD, 38));
      name.setBounds(100, 140, 100, 30);
      add(name);
      
      nameTextField = new JTextField();
      nameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      nameTextField.setBounds(300, 140, 400, 30);
      add(nameTextField);
      
      JLabel fname = new JLabel("FathersName: ");
      fname.setFont(new Font("Raleway", Font.BOLD, 38));
      fname.setBounds(100, 190, 200, 30);
      add(fname);
      
      fnameTextField = new JTextField();
      fnameTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      fnameTextField.setBounds(300, 190, 400, 30);
      add(fnameTextField);
        
      JLabel dob = new JLabel("Date of Birth:");
      dob.setFont(new Font("Raleway", Font.BOLD, 38));
      dob.setBounds(100, 240, 200, 30);
      add(dob);
      
      datechooser = new JDateChooser();
      datechooser.setBounds(300, 240, 400, 30);
      datechooser.setForeground(new Color (105, 105, 105));
      add(datechooser);
        
      JLabel gender = new JLabel("Gender:");
      gender.setFont(new Font("Raleway", Font.BOLD, 38));
      gender.setBounds(100, 290, 200, 30);
      add(gender);
      
      male = new JRadioButton("Male");
      male.setBounds(300, 290, 60, 30);
      male.setBackground(Color.WHITE);
      add(male);
      
      female = new JRadioButton("Female");
      female.setBounds(450, 290, 120, 30);
      female.setBackground(Color.WHITE);
      add(female);
      
      ButtonGroup gendergroup = new ButtonGroup();
      gendergroup.add(male);
      gendergroup.add(female);
      
            
      JLabel email = new JLabel("Email Address:");
      email.setFont(new Font("Raleway", Font.BOLD, 38));
      email.setBounds(100, 340, 200, 30);
      add(email);
      
      emailTextField = new JTextField();
      emailTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      emailTextField.setBounds(300, 390, 400, 30);
      add(emailTextField);
        
      
      JLabel maritalstatus = new JLabel("Marital Status:");
      maritalstatus.setFont(new Font("Raleway", Font.BOLD, 38));
      maritalstatus.setBounds(100, 390, 200, 30);
      add(maritalstatus); 
      
      married = new JRadioButton("Married");
      married.setBounds(300, 390, 100, 30);
      married.setBackground(Color.WHITE);
      add(married);
      
      unmarried = new JRadioButton("Unmarried");
      unmarried.setBounds(450, 390, 100, 30);
      unmarried.setBackground(Color.WHITE);
      add(unmarried);
      
      other = new JRadioButton("Other");
      other.setBounds(630, 390, 100, 30);
      other.setBackground(Color.WHITE);
      add(other);
      
      ButtonGroup maritalgroup  = new ButtonGroup();
      maritalstatus.add(married);
      maritalstatus.add(unmarried);  
      maritalstatus.add(other);
      
      
      
      JLabel address = new JLabel("Address:");
      address.setFont(new Font("Raleway", Font.BOLD, 38));
      address.setBounds(100, 390, 200, 30);
      add(address);
      
      addressTextField = new JTextField();
      addressTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      addressTextField.setBounds(300, 440, 400, 30);
      add(addressTextField);
        
      
      JLabel city = new JLabel("City:");
      city.setFont(new Font("Raleway", Font.BOLD, 38));
      city.setBounds(100, 440, 200, 30);
      add(city); 
     
      cityTextField = new JTextField();
      cityTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      cityTextField.setBounds(300, 440, 400, 30);
      add(cityTextField);
       
      JLabel state = new JLabel("State:");
      state.setFont(new Font("Raleway", Font.BOLD, 38));
      state.setBounds(100, 490, 200, 30);
      add(state);
      
      stateTextField = new JTextField();
      stateTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      stateTextField.setBounds(300, 490, 400, 30);
      add(stateTextField);
      
      JLabel pincode = new JLabel("Pincode:");
      pincode.setFont(new Font("Raleway", Font.BOLD, 38));
      pincode.setBounds(100, 490, 200, 30);
      add(pincode);
      
      pincodeTextField = new JTextField();
      pincodeTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      pincodeTextField.setBounds(300, 540, 400, 30);
      add(pincodeTextField);
      
      JLabel country = new JLabel("Country:");
      country.setFont(new Font("Raleway", Font.BOLD, 38));
      country.setBounds(100, 540, 200, 30);
      add(country);
      
      countryTextField = new JTextField();
      countryTextField.setFont(new Font("Raleway", Font.BOLD, 14));
      countryTextField.setBounds(300, 590, 400, 30);
      add(countryTextField);
      
      
      next = new JButton("Next");
      next.setBackground(Color.BLACK);
      next.setForeground(Color.WHITE);
      next.setFont(new Font("Raleway", Font.BOLD, 14));
      next.setBounds(620, 660, 80, 30);
      next.addActionListener(this);
      add(next);
      
      
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,800);
        setLocation(500,120);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){ 
            gender = "Male";
        }else if(female.isSelected()){ 
            gender = "Female";
        }
            
        String email = emailTextField.getText();
        String marital = null;
        if(married.isSelected()){ 
            marital = "Married";
        }else if(unmarried.isSelected()){ 
            marital = "Unmarried";
        }else if(other.isSelected()){ 
            marital = "Other";
        }
           
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String pincode = pincodeTextField.getText();
        String state = stateTextField.getText();
        String country = countryTextField.getText();
        

        try{
           
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required:");
            }else{
                Conn c = new Conn();
                String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pincode+"', '"+country+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignUpTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
             e.printStackTrace();
        }
        
    }
    
    
    
    public static void main(String[] args){
        new SignUpOne().setVisible(true);
    }
}
