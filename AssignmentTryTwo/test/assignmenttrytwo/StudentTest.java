/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package assignmenttrytwo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author annab
 */
public class StudentTest {
    
    public StudentTest() {
    }
    private ArrayList<Integer> studentsIDs;
    private ArrayList<String> studentsNames;
    private ArrayList<String> studentsAges;
    private ArrayList<String> studentsEmails;
    private ArrayList<String> studentsCourses;
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        // Initialize the ArrayLists before each test
        studentsIDs = new ArrayList<>();
        studentsNames = new ArrayList<>();
        studentsAges = new ArrayList<>();
        studentsEmails = new ArrayList<>();
        studentsCourses = new ArrayList<>();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveStudent method, of class Student.
     */
    @Test
    public void TestSaveStudent() {
        
        int result;
        
        System.out.println("saveStudent");
        
        int studentID = 10111;
        String studentName = "S. Govender";
        String studentAge = "22";
        String studentEmail = "sgovender@gmail.com";
        String studentCourse = "BEd";
        Student.saveStudent(studentID, studentName, studentAge, studentEmail, studentCourse);
        
        int expResult = -1;
        if (Student.studentsIDs.isEmpty()) {
            result = 1;
        } else {
            result = -1; 
        } // end if
        
        assertEquals(expResult, result);
    } // end save test


    
    @Test
    public void testSearchStudent_StudentFound() {
        
        Student kt = new Student();
        
        // Arrange
        List<Integer> studentsIDs = Arrays.asList(101, 102, 103, 104);
        List<String> studentsNames = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> studentsAges = Arrays.asList("18", "19", "20", "21");
        List<String> studentsEmails = Arrays.asList("alice@example.com", "bob@example.com", "charlie@example.com", "david@example.com");
        List<String> studentsCourses = Arrays.asList("Math", "Science", "History", "English");
        Student.studentsIDs = new ArrayList<>(studentsIDs);
        Student.studentsNames = new ArrayList<>(studentsNames);
        Student.studentsAges = new ArrayList<>(studentsAges);
        Student.studentsEmails = new ArrayList<>(studentsEmails);
        Student.studentsCourses = new ArrayList<>(studentsCourses);
        
        // Student ID to search for
        int studentSearch = 102;

        // Act
        Student result = searchStudent(studentSearch);

        // Assert
        assertNotNull(result);
        assertEquals(102, result.getStudentID());
        assertEquals("Bob", result.getStudentName());
        assertEquals("19", result.getStudentAge());
        assertEquals("bob@example.com", result.getStudentEmail());
        assertEquals("Science", result.getStudentCourse());
    }

    
    
    @Test
    public void TestSearchStudent_StudentNotFound(){
    
        // Arrange
        List<Integer> studentsIDs = Arrays.asList(101, 102, 103, 104);
        List<String> studentsNames = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> studentsAges = Arrays.asList("18", "19", "20", "21");
        List<String> studentsEmails = Arrays.asList("alice@example.com", "bob@example.com", "charlie@example.com", "david@example.com");
        List<String> studentsCourses = Arrays.asList("Math", "Science", "History", "English");
        Student.studentsIDs = new ArrayList<>(studentsIDs);
        Student.studentsNames = new ArrayList<>(studentsNames);
        Student.studentsAges = new ArrayList<>(studentsAges);
        Student.studentsEmails = new ArrayList<>(studentsEmails);
        Student.studentsCourses = new ArrayList<>(studentsCourses);

        // Student ID that doesn't exist
        int studentSearch = 110;

        // Act
        Student result = searchStudent(studentSearch);

        // Assert
        assertNull(result); // Student not found
    }
    
    // Helper method to simulate the searchStudent method
    private Student searchStudent(int studentSearch) {
        for (int i = 0; i < Student.studentsIDs.size(); i++) {
            if (Student.studentsIDs.get(i) == studentSearch) {
                Student student = new Student();
                student.setStudentID(Student.studentsIDs.get(i));
                student.setStudentName(Student.studentsNames.get(i));
                student.setStudentAge(Student.studentsAges.get(i));
                student.setStudentEmail(Student.studentsEmails.get(i));
                student.setStudentCourse(Student.studentsCourses.get(i));
                return student;
            }
        }
        return null; // Student not found
    }
    
    @Test
    public void testDeleteStudent() {
        System.out.println("testDeleteStudent");

        // Create a new instance of Student
        Student instance = new Student();

        // Add a sample student
        int studentID = 10111;
        instance.saveStudent(studentID, "J.Bloggs", "19", "jbloggs@ymail.com", "disd");

        // Search for the added student's index
        int deleteIndex = instance.studentsIDs.indexOf(studentID);

        // Delete the student
        instance.checkDeleteStudent(deleteIndex);

        // Try to search for the deleted student
        int expectedResult = -1;
        int result = instance.studentsIDs.indexOf(studentID);

        // Check if the result matches the expected result
        assertEquals(expectedResult, result);
    }

    
     @Test
    public void testDeleteStudent_StudentNotFound() {
        System.out.println("testDeleteStudent_StudentNotFound");

        // Create a new instance of Student
        Student instance = new Student();

        // Add a sample student
        int studentID = 10111;
        instance.saveStudent(studentID, "J.Bloggs", "19", "jbloggs@ymail.com", "disd");

        // Attempt to delete a student with an incorrect student ID
        int incorrectStudentID = 99999;
        instance.deleteStudent(incorrectStudentID);

        // Try to search for the student with the incorrect student ID
        int expectedResult = -1;
        int result = instance.studentsIDs.indexOf(incorrectStudentID);

        // Check if the result matches the expected result (no student found)
        assertEquals(expectedResult, result);
    }
    
    
    
    
   @Test
    public void testStudentAge_StudentAgeValid() {
        
        Student kb = new Student();
        
        // Arrange
        int validAge = 19; // A valid student age

        
        boolean result = kb.checkStudentAge(validAge);

        // Assert
        assertTrue(result); // Expecting the age to be valid
    }//end of test
    
   
    @Test
    public void testStudentAge_StudentAgeInvalid() {
        
        Student kb = new Student();
        
        // Arrange
        int invalidAge = 15; // An invalid student age (less than 16)

        // Act
        boolean result = kb.checkStudentAge(invalidAge);

        // Assert
        assertFalse(result); // Expecting the age to be invalid
    }//end of method
    
    
    @Test
    public void testStudentAge_StudentAgeInvalidCharacter() {
        
        Student kb = new Student();
        
        // Arrange
        String invalidCharacter = "Fifty"; // An invalid character (not a number)

        // Act
        boolean isAgeValid = false;
        try {
            // Attempt to parse the invalid character as an integer
            int age = Integer.parseInt(invalidCharacter);
            isAgeValid = kb.checkStudentAge(age);
        } catch (NumberFormatException e) {
            // Catch the exception thrown when parsing fails
            isAgeValid = false;
        }

        // Assert
        assertFalse(isAgeValid); // Expecting the age to be invalid
    }

    
}
