/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package icetaskone;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author annab
 */
public class ICETaskOne {


   
        public static void main(String[] args) {
        // Creating instances of Bird and Reptile classes
        Bird bird = new Bird(1, "");
        Reptile reptile = new Reptile(2, "");

        bird.enterData();
        reptile.enterData();

        JOptionPane.showMessageDialog(null, "Bird details:\n" + bird.displayData());
        JOptionPane.showMessageDialog(null, "Reptile details:\n" + reptile.displayData());
    }
        
        

    public static class Animal {

        private int uniqueID;
        private String speciesName;

        public int getUniqueID() {
            return uniqueID;
        }

        public void setUniqueID(int uniqueID) {
            this.uniqueID = uniqueID;
        }

        public String getSpeciesName() {
            return speciesName;
        }

        public void setSpeciesName(String speciesName) {
            this.speciesName = speciesName;
        }

        public Animal(int uniqueID, String speciesName) {
            this.uniqueID = uniqueID;
            this.speciesName = speciesName;
        }

        public void enterData() {
            uniqueID = Integer.parseInt(JOptionPane.showInputDialog("Please enter the unique ID:"));
            speciesName = JOptionPane.showInputDialog("Please enter the species name:");
        }

        public String displayData() {
            return "Unique ID: " + uniqueID + "\nSpecies Name: " + speciesName;
        }
    }
    
    
    //CHANGHE THIS TO A SWITCH CASE STATEMENT
    public static class Bird extends Animal {

        private int featherColorCode;
        private String[] colorOptions = {"Grey", "White", "Black"};

        public Bird(int uniqueID, String speciesName) {
            super(uniqueID, speciesName);
        }

        @Override
        public void enterData() {
            super.enterData();
            featherColorCode = Integer.parseInt(JOptionPane.showInputDialog("Please enter the feather color code of the bird (1-Grey, 2-White, 3-Black):"));
        }

        @Override
        public String displayData() {
            return super.displayData() + "\nFeather Color: " + colorOptions[featherColorCode - 1];
        }
    }

    
    
    public static class Reptile extends Animal {

        private double bloodTemperature;

        public Reptile(int uniqueID, String speciesName) {
            super(uniqueID, speciesName);
        }

        @Override
        public void enterData() {
            super.enterData();
            bloodTemperature = Double.parseDouble(JOptionPane.showInputDialog("Please enter the blood temperature of the reptile:"));
        }

        @Override
        public String displayData() {
            return super.displayData() + "\nBlood Temperature: " + bloodTemperature;
        }
    }
}
