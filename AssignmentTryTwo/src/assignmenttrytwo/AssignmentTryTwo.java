/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package assignmenttrytwo;

import static assignmenttrytwo.Student.kb;
import java.util.Scanner;



public class AssignmentTryTwo {

    //Declaring the variables globally as they will be used throughout the whole program
    public static String userChoice;
    public static int studentID;
    public static String studentName;
    public static String studentAge;
    public static String studentEmail;
    public static String studentCourse;
    
    //declaring the scanner
    final static Scanner kb = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
     //calling the SetUp() method
        SetUp();
    }
    
        // Method for setting up the application
        public static void SetUp() {
        
        // Printing a welcome message
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*******************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit \n");
        userChoice = kb.next();
        
        // Check if the user wants to continue or exit
        if (userChoice.equals("1")) {
            // If user enters '1', call the menu
           Menu();
        } else {
            // If user enters anything else, exit the program
           System.exit(0);
        } // end if else
    }//end of SetUp Method
        

// Method for displaying and handling the main menu
    public static void Menu (){
        
        // Declare variables to store user input and control the menu loop
        int choice;
        boolean quit = false;
        
        // While loop to display the menu until the user decides to quit
        while (!quit){
            // Displaying menu options to the user
            System.out.println("Please select one of the following menu items: " + "\n" 
                    + "Please enter (1) to capture a new student" + "\n"
                    + "Please enter (2) to search for a new student"+ "\n"
                    + "Please enter (3) to delete a student" + "\n"
                    + "Please enter (4) to print student report" + "\n"
                    + "Please enter (5) to exit the application ");
            choice = kb.nextInt();
            
                    // Use a switch statement to perform actions based on user choice
            switch (choice) {
                case 1:
                    // Allows user a new student's information
                    System.out.println("CAPTURE A NEW STUDENT ");
                    System.out.println("********************* ");
                    
                    // Prompt the user to enter the student's ID
                    System.out.println("Enter the student ID");
                    studentID = kb.nextInt();
//                    while ( Student.searchStudent(studentID) >= 0) {
//                    System.out.println("Student Id already exists. Please re-enter student ID.");
//                    studentID = kb.nextInt();
//                } // end while
                    
                    // Prompt the user to enter the student's name
                    System.out.println("Enter the student name");
                    studentName = kb.next();
        
                    // Prompt the user to enter the student's age
                    System.out.println("Enter the student age");
                    studentAge = kb.next();
        
                    //calling the valid age method to check if the user input is correct
                    Student.validAge(studentAge);

                    // Prompt the user to enter the student's email
                    System.out.println("Enter the student email");
                    studentEmail = kb.next();
        
                    // Prompt the user to enter the student's course
                    System.out.println("Enter the student course");
                    studentCourse = kb.next(); 
        
                    Student.saveStudent(studentID, studentName, studentAge, studentEmail, studentCourse);
                    System.out.println("Student added successfully!");
                  
                    break;
                case 2:
                    // Allows user to search for student
                    
                    // Prompt the user to enter a student ID to search
                    System.out.println("Please enter student ID to search");
                    int studentSearch = kb.nextInt();
                    //calls a method that searches for the student
                    Student.searchstudent(studentSearch);
               
                    break;
                case 3:
                    // Calls a method to delete a student
                    
                    // Prompt the user to enter a student ID to delete
                    System.out.println("Please enter student ID to delete:");
                    int deleteStudent = kb.nextInt();
                    
                    //calls a method that deletes a student by their ID
                    Student.deleteStudent(deleteStudent);
        
                    break;
                case 4:
                    // Calls a method to print a student report
                    Student.studentReport();
                    break;
                case 5:
                    // Exits the application
                    System.out.println("Exiting the application...");
                    System.exit(0);
                    break;
                default:
                    // Handle invalid input by informing the user to try again
                    System.out.println("Invalid entry, please try again");
                    break;
            } // end of switch case
        } // end of while loop
    } // end of Menu Method
}//end of whole program

        
        
        
        
        

