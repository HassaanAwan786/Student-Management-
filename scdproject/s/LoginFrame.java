package com.mycompany.scdproject.s;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame extends JFrame {
    private JLabel regnolable;
    private JLabel passwordlable;
    private JTextField regnoField;
    private JPasswordField passwordField;
    private JButton loginButton;

    public LoginFrame()
    {
        super("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        regnolable = new JLabel("USERNAME");
        passwordlable = new JLabel("PASSWORD");
        regnoField = new JTextField(15);
        passwordField = new JPasswordField(15);
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() 
        { 
             
          public void actionPerformed(ActionEvent e)
           {            
                String regno = regnoField.getText();//local variable for getting data from textfield
                String password = new String(passwordField.getPassword());

               StudentDAO studentDAO = new StudentDAO();///making object so that can call atuntication function
               Student student = studentDAO.authenticateStudent(regno , password);//name 
              
                if ( student!=null) {
                     
                                                             
                         profileframe pframe=new profileframe(studentDAO.getStudentData(regno));
                         pframe.setVisible(true);
                                              
               
                     
                    dispose();
                } 
                else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Invalid credentials!,check username or password and try again.");
                }
                
            }
        });
        
        add(regnolable);
        add(regnoField);
        add(passwordlable);
        add(passwordField);
        add(loginButton);
        pack();
        setLocationRelativeTo(null);
    }
    
   
}

