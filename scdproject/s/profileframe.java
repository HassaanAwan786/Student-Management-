package com.mycompany.scdproject.s;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class profileframe extends JFrame {
    private JTextField nameField;
    private JTextField fatherNameField;
    private JTextField semesterField;
    private JTextField ageField;
    private JTextField regNoField;
    private JTextField passwordField;
    private JTextField emailField;
    private JTextField phoneField;
    private JTextField majorField;
    private JTextField no_of_awardsField;
    private JTextField gpaField;
    private JButton editPasswordButton;
    private JButton editEmailButton;
    private JButton editPhoneButton;
    public profileframe(Student student) {
        setTitle("Student Profile");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 550);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());

        // Set background color
        getContentPane().setBackground(new Color(240, 240, 240)); // Light gray

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 10, 5, 10);

        // Set label and field colors
        Color labelColor = new Color(80, 80, 80); // Dark gray
        Color fieldColor = new Color(220, 220, 220); // Lighter gray

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setForeground(labelColor);
        nameField = new JTextField(20);
        nameField.setBackground(fieldColor);

        JLabel fatherNameLabel = new JLabel("Father's Name:");
        fatherNameLabel.setForeground(labelColor);
        fatherNameField = new JTextField(20);
        fatherNameField.setBackground(fieldColor);

        JLabel semesterLabel = new JLabel("Semester:");
        semesterLabel.setForeground(labelColor);
        semesterField = new JTextField(20);
        semesterField.setBackground(fieldColor);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setForeground(labelColor);
        ageField = new JTextField(20);
        ageField.setBackground(fieldColor);

        JLabel regNoLabel = new JLabel("Registration No:");
        regNoLabel.setForeground(labelColor);
        regNoField = new JTextField(20);
        regNoField.setBackground(fieldColor);
         
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(labelColor);
        passwordField = new JTextField(20);
        passwordField.setBackground(fieldColor);
        
         JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(labelColor);
        emailField = new JTextField(20);
        emailField.setBackground(fieldColor);
        
         JLabel phoneLabel = new JLabel("Phone no:");
        phoneLabel.setForeground(labelColor);
        phoneField = new JTextField(20);
        phoneField.setBackground(fieldColor);
        
         JLabel majorLabel = new JLabel("Major:");
        majorLabel.setForeground(labelColor);
        majorField = new JTextField(20);
        majorField.setBackground(fieldColor);
        
         JLabel no_of_awardsLabel = new JLabel("No of Awards:");
        no_of_awardsLabel.setForeground(labelColor);
        no_of_awardsField = new JTextField(20);
        no_of_awardsField.setBackground(fieldColor);
        
        JLabel gpaLabel = new JLabel("GPA");
        gpaLabel.setForeground(labelColor);
        gpaField = new JTextField(20);
        gpaField.setBackground(fieldColor);
        
        editPasswordButton = new JButton("Edit Password");
        editPasswordButton.setBackground(new Color(120, 180, 220)); // Light blue
        editPasswordButton.setForeground(Color.white); // White text color
        
        editEmailButton = new JButton("Edit Email");
        editEmailButton.setBackground(new Color(120, 180, 220)); // Light blue
        editEmailButton.setForeground(Color.white); // White text color
        
        editPhoneButton = new JButton("Edit Phone");
        editPhoneButton.setBackground(new Color(120, 180, 220)); // Light blue
        editPhoneButton.setForeground(Color.white); // White text color
        
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(fatherNameLabel, gbc);

        gbc.gridx = 1;
        add(fatherNameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(semesterLabel, gbc);

        gbc.gridx = 1;
        add(semesterField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(ageLabel, gbc);

        gbc.gridx = 1;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        add(regNoLabel, gbc);

        gbc.gridx = 1;
        add(regNoField, gbc);
       
         gbc.gridx = 0;
        gbc.gridy = 5;
        add(passwordLabel, gbc);

        gbc.gridx = 1;
        add(passwordField, gbc);
        
           gbc.gridx = 0;
        gbc.gridy = 6;
        add(emailLabel, gbc);
        gbc.gridx = 1;
        add(emailField, gbc);
        
          gbc.gridx = 0;
        gbc.gridy = 7;
        add(phoneLabel, gbc);
        gbc.gridx = 1;
        add(phoneField, gbc);
        
          gbc.gridx = 0;
        gbc.gridy = 8;
        add(majorLabel, gbc);
        gbc.gridx = 1;
        add(majorField, gbc);
        
          gbc.gridx = 0;
        gbc.gridy = 9;
        add(gpaLabel, gbc);
        gbc.gridx = 1;
        add(gpaField, gbc);
        
         gbc.gridx = 0;
        gbc.gridy = 10;
        add(no_of_awardsLabel, gbc);
        gbc.gridx = 1;
        add(no_of_awardsField, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(editPasswordButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(editEmailButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.EAST;
        add(editPhoneButton, gbc);
        
        
        
        // Retrieve data from the database and populate the text fields
        StudentDAO studentDAO = new StudentDAO();
        Student updatedStudent = studentDAO.getStudentData(student.getRegno());
        if (updatedStudent != null) {
            nameField.setText(updatedStudent.getName());
            fatherNameField.setText(updatedStudent.getFatherName());
            semesterField.setText(updatedStudent.getSemester());
            ageField.setText(String.valueOf(updatedStudent.getAge()));
            regNoField.setText(updatedStudent.getRegno());
            passwordField.setText(updatedStudent.getPassword());
             emailField.setText(updatedStudent.getEmail());
             phoneField.setText(updatedStudent.getPhone());
             majorField.setText(updatedStudent.getMajor());
             gpaField.setText(updatedStudent.getGpa());
             no_of_awardsField.setText(updatedStudent.getNo_OF_Awards());
             
            
            // Make text fields read-only
         nameField.setEditable(false);
         fatherNameField.setEditable(false);
         semesterField.setEditable(false);
         ageField.setEditable(false);
         regNoField.setEditable(false);
         passwordField.setEditable(false);
          emailField.setEditable(false);
             phoneField.setEditable(false);
             majorField.setEditable(false);
             gpaField.setEditable(false);
             no_of_awardsField.setEditable(false);
             
             
        // Set up the action listener for the edit password button
        editPasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the password edit frame
                editPasswordFrame editpasswordframe = new editPasswordFrame();
                editpasswordframe.setVisible(true);
            }
        });

         editEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the password edit frame
                editEmailFrame editemailframe = new editEmailFrame();
                editemailframe.setVisible(true);
            }
        });
         
          editPhoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the password edit frame
                editPhoneFrame editphoneframe = new editPhoneFrame();
                editphoneframe.setVisible(true);
            }
        });
          
          
        
         
        }
    }

    
}
