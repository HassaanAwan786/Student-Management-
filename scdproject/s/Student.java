package com.mycompany.scdproject.s;
public class Student {
 private  String Name;
      private String FatherName;
       private String Semester; 
       private int Age;
       private String Regno;//used as uses name 
        private String Password;
        
       private String Email;
       private String Phone; 
       private String Major;
       private String Gpa;//used as uses name 
        private String No_OF_Awards;
        
    public String getEmail() {
        return Email;
    }

    public String getPhone() {
        return Phone;
    }

    public String getMajor() {
        return Major;
    }

    public String getGpa() {
        return Gpa;
    }

    public String getNo_OF_Awards() {
        return No_OF_Awards;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public void setMajor(String Major) {
        this.Major = Major;
    }

    public void setGpa(String Gpa) {
        this.Gpa = Gpa;
    }

    public void setNo_OF_Awards(String No_OF_Awards) {
        this.No_OF_Awards = No_OF_Awards;
    }
        
        
         public Student()
    {
       
        
    }
          public Student(String regno,String password)//used in authenthication function in loginframe
    {
       
          this.Regno=regno;
        this.Password=password;
    }
    public String getPassword() 
    {
        return Password;
    }
      public void setPassword(String password) 
    {
        this.Password = password;
    } 
    public void setName(String Name) {
        this.Name = Name;
    }

    public void setFatherName(String FatherName) {
        this.FatherName = FatherName;
    }

    public void setSemester(String Semester) {
        this.Semester = Semester;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setRegno(String Regno) {
        this.Regno = Regno;
    }

    public String getName() {
        return Name;
    }

    public String getFatherName() {
        return FatherName;
    }

    public String getSemester() {
        return Semester;
    }

    public int getAge() {
        return Age;
    }

    public String getRegno() {
        return Regno;
    }
   
   
    
}
