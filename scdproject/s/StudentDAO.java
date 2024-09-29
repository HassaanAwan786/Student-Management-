 package com.mycompany.scdproject.s;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentDAO {
     //public String username="root";
     //public String password="new_password";
      
    public StudentDAO()
    {
        
    }
    public Student authenticateStudent(String regno, String password) {
        Student student = null;
        
       String query = "SELECT * FROM studentdata WHERE regno = ? AND password = ?"; //change username into regno as u ill make in database 
        try {
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentprofile", this.username, this.password); for local database 
            Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12625232","sql12625232","fYb5YRs82U"); //online database
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1,regno);
            statement.setString(2, password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                 
                String REGNO = resultSet.getString("regno");  
                String PASSWORD = resultSet.getString("password"); 
                student = new Student(REGNO,PASSWORD);//from local variable data is transfering into entity class 
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }
    
     public Student getStudentData(String registrationno) {
        
        Student student = null;
        try {
            // Establish database connection and execute query
           // Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentprofile", this.username, this.password);//local database
               Connection conn=DriverManager.getConnection("jdbc:mysql://sql12.freesqldatabase.com:3306/sql12625232","sql12625232","fYb5YRs82U");
            String query = "SELECT * FROM studentdata WHERE regno = ? LIMIT 1";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, registrationno);
            ResultSet resultSet = statement.executeQuery();

            // Retrieve data and create Student object
            if (resultSet.next()) {
                student = new Student();
                student.setRegno(resultSet.getString("regno"));
                student.setName(resultSet.getString("name"));
                student.setFatherName(resultSet.getString("fathername"));
                student.setSemester(resultSet.getString("semester"));
                student.setAge(resultSet.getInt("age"));
                student.setPassword(resultSet.getString("password"));
                
                student.setEmail(resultSet.getString("email"));
                 student.setPhone(resultSet.getString("phone"));
                 student.setMajor(resultSet.getString("major"));
                 student.setGpa(resultSet.getString("gpa"));
                student.setNo_OF_Awards(resultSet.getString("no_of_awards"));
                // Add more attributes if needed
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }  

        return student;
    }
}
