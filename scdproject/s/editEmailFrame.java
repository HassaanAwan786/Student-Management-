/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.scdproject.s;
 import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class editEmailFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField emailField;
    private JPasswordField confirmemailField;
    //private String username="root";
    // private String password="new_password ";
   
    public editEmailFrame() {
        setTitle("Edit Email");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("New Email:"));
        emailField = new JPasswordField();
        panel.add(emailField);

        panel.add(new JLabel("Confirm Email:"));
        confirmemailField = new JPasswordField();
        panel.add(confirmemailField);

        JButton updateButton = new JButton("Update");
         updateButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String uname = usernameField.getText();
        String nEmail = String.valueOf(emailField.getPassword());
        String confirmEmail = String.valueOf(confirmemailField.getPassword());

        if (confirmEmail.equals(nEmail)) {
            // Insert password into the database
            try {
                // Establish database connection
               // Student student=new Student();

                // Prepare the SQL statement
                String query = "UPDATE studentdata SET email = ? WHERE regno = ?";
                int rowsAffected;
                //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentprofile", "root", "new_password")local database
                
                try (Connection conn =DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12625232","sql12625232","fYb5YRs82U")) {
                    PreparedStatement statement = conn.prepareStatement(query);
                    statement.setString(1,nEmail);
                    statement.setString(2,uname);
                     
                    // Execute the update query
                    rowsAffected = statement.executeUpdate();
                    // Close the statement and connection
                    statement.close();
                }

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Email updated successfully!");
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to update Email!");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "An error occurred while updating the email!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Email don't match!");
        }
    }
});

        panel.add(updateButton);

        getContentPane().add(panel);
    }

   
}
