/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignmenttrytwo;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author annab
 */
public class Student {
    
        //declaring the scanner
    final static Scanner kb = new Scanner(System.in);
    
        //using array lists to store given data
    public static ArrayList <Integer> studentsIDs = new ArrayList <Integer> ();
    public static ArrayList <String> studentsNames = new ArrayList <String> ();
    public static ArrayList <String> studentsAges = new ArrayList <String> ();
    public static ArrayList <String> studentsEmails = new ArrayList <String> ();
    public static ArrayList <String> studentsCourses = new ArrayList <String> ();
    
    //Declaring the variables globally as they will be used throughout the whole program
    public static String userChoice;
    public static int studentID;
    public static String studentName;
    public static String studentAge;
    public static String studentEmail;
    public static String studentCourse;

    public static int getStudentID() {
        return studentID;
    }

    public static void setStudentID(int studentID) {
        Student.studentID = studentID;
    }

    public static String getStudentName() {
        return studentName;
    }

    public static void setStudentName(String studentName) {
        Student.studentName = studentName;
    }

    public static String getStudentAge() {
        return studentAge;
    }

    public static void setStudentAge(String studentAge) {
        Student.studentAge = studentAge;
    }

    public static String getStudentEmail() {
        return studentEmail;
    }

    public static void setStudentEmail(String studentEmail) {
        Student.studentEmail = studentEmail;
    }

    public static String getStudentCourse() {
        return studentCourse;
    }

    public static void setStudentCourse(String studentCourse) {
        Student.studentCourse = studentCourse;
    }
    
    
    public static void saveStudent(int studentID, String studentName, String studentAge, String studentEmail, String studentCourse) { 

        // Add the student's information to corresponding lists or data structures
        studentsIDs.add(studentID);
        studentsNames.add(studentName);
        studentsAges.add(studentAge);
        studentsEmails.add(studentEmail);
        studentsCourses.add(studentCourse);
    } // end of save
    
    // This method is used to validate the age input for a student.
    public static void validAge(String studentAge){
        
        //while loop is used to repeatedly prompt the user for their age until
        //a valid age (greater than or equal to 16) is entered.
        while (true) {
         try {
            // Attempt to parse the studentAge string to an integer
            int age = Integer.parseInt(studentAge);
            
             // Check if the age is greater than or equal to 16 (a valid age)
            if (age >= 16) {
                break; // Valid age, exit the loop
            } else {
                // If age is less than 16, prompt the user to re-enter a valid age
                System.out.println("Invalid age. Age must be greater than or equal to 16.");
                System.out.print("Re-enter the student age: ");
                studentAge = kb.next();
            }
        }//end of try
        catch (NumberFormatException e) {
             // If the input cannot be parsed as an integer, it's invalid
            System.out.println("Invalid input. Please enter a valid number for age.");
            System.out.print("Re-enter the student age: ");
            studentAge = kb.next();
        }//end of catch
    }//end of while loop  
    }//end of validAge method
    
    //This is a method used to check the students age  
    // Returns:true if the student's age is greater than or equal to 16, false otherwise.
    public boolean checkStudentAge (int studentAge){
    // Check if the student's age is greater than or equal to 16   
    return studentAge >=16;
    }
    
    
    public static void searchstudent(int studentSearch){
        
        // Initialize the index to -1, indicating that the student is not found by default
        int index = -1;
        
         // Iterate through the list of student IDs to find a match
         for(int i=0; i<studentsIDs.size(); i++){
            if (studentsIDs.get(i).equals(studentSearch)){
               // If a match is found, update the index
              index = i;
          } // end if
         } // end for
      
         // Check if the student was found or not
         if (index == -1){
             // Student not found, display a message
             System.out.println("Student with Student ID: " + studentSearch + " was not found");
         }else{
             // Student found, display their information
            System.out.println("STUDENT ID: "+studentsIDs.get(index));
            System.out.println("STUDENT NAME: "+studentsNames.get(index));
            System.out.println("STUDENT AGE: "+studentsAges.get(index));
            System.out.println("STUDENT EMAIL: "+studentsEmails.get(index));
            System.out.println("STUDENT COURSE: "+studentsCourses.get(index));
         } // end if else

    }//end of searchStudent method
    
    
    //Method to delet a student from the array list using their student ID
    public static void deleteStudent(int deleteStudent){
      

        // Find the index of the student with the provided ID
        int index = studentsIDs.indexOf(deleteStudent);

        if (index == -1) {
            // If the student is not found, display a message
            System.out.println("Student with student ID: " + deleteStudent + " was not found.");
        } else {
            // If the student is found, ask for confirmation before deleting
            System.out.println("Are you sure you want to delete student " + deleteStudent + " from the system? (Y/N)");
            String confirm = kb.next();

            if (confirm.equalsIgnoreCase("Y")) {
                // If the user confirms deletion, remove the student's data from all lists
                studentsIDs.remove(index);
                studentsNames.remove(index);
                studentsAges.remove(index);
                studentsEmails.remove(index);
                studentsCourses.remove(index);
                //confirms with user that the student was deleted
                System.out.println("Student with ID: " + deleteStudent + " was deleted.");
            }
        }

    }//end of deleteStudent method
    
     public static void checkDeleteStudent( int index) {
        
                studentsIDs.remove(index);
                studentsNames.remove(index);
                studentsAges.remove(index);
                studentsEmails.remove(index);
                studentsCourses.remove(index);
    } // end method
    
    
    public static void studentReport(){
        
        // Check if the list of student IDs is empty
        if (studentsIDs.isEmpty()) {
        // If there are no students, display a message indicating that there are no students to display
        System.out.println("No students to display.");
        }
        else {
        // If there are students, generate a student report
        System.out.println("STUDENT REPORT");
        System.out.println("*******************************************");

        for (int i = 0; i < studentsIDs.size(); i++) {
            // Calculate the student number
            int studentNumber = i + 1; 
            
            // Display the information for each student
            System.out.println("STUDENT1 " + studentNumber );
            System.out.println("Student ID: " + studentsIDs.get(i));
            System.out.println("Student Name: " + studentsNames.get(i));
            System.out.println("Student Age: " + studentsAges.get(i));
            System.out.println("Student Email: " + studentsEmails.get(i));
            System.out.println("Student Course: " + studentsCourses.get(i));
            System.out.println("*******************************************");
        }
    }//end of else statement
    }//end of studentReport method
    
}//end of student class
