package avochoc.palindrome.SectionA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.opencsv.exceptions.CsvValidationException;

public class DataStructures2 
{
    public static void main(String[] args) throws CsvValidationException, FileNotFoundException, IOException 
    {
        String csvFilePath = "app/src/main/resources/datastructures2.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) 
        {
            // Skip the first line
            String line = reader.readLine();

            Map<String, String> data = new HashMap<>();

            while ((line = reader.readLine()) != null) 
            {
                // Assuming your CSV file has two values in each line separated by a semicolon
                String[] values = line.split(";");

                if (values.length >= 2) 
                {                   
                    String firstName = values[0];
                    String lastName = values[1];
                    data.put(firstName, lastName);                   
                }
            }
            Scanner scan = new Scanner(System.in);

            int choice;
            do {
                System.out.println("------- Menu ------- \n" + 
                               "1. Display Records \n" + 
                               "2. Insert Record \n" + 
                               "3. Edit Record \n" + 
                               "4. Delete Record \n" + 
                               "5. Exit Program");
                System.out.print("Enter your choice: ");
                choice = scan.nextInt();
    
                switch (choice) {
                    case 1:
                        displayRecords(data);
                        break;
                    case 2:
                        insertRecord(data, scan);
                        break;
                    case 3:
                        editRecord(data, scan);
                        break;
                    case 4:
                        deleteRecord(data, scan);
                        break;
                    case 5:
                        System.out.println("Exiting the program...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        }
    }
   
        private static void displayRecords(Map<String, String> map) 
        {
            System.out.println("--- Records ---");
            for (Map.Entry<String, String> entry : map.entrySet()) 
            {
                String firstName = entry.getKey();
                String lastName = entry.getValue();
                System.out.println("Name: " + firstName + " Surname: " + lastName);
            }
            System.out.println();
        }
    
        private static void insertRecord(Map<String, String> map, Scanner scanner) 
        {
            System.out.print("Enter first name: ");
            String firstName = scanner.next();
    
            System.out.print("Enter last name: ");
            String lastName = scanner.next();
    
            map.put(firstName, lastName);
            System.out.println("Record inserted successfully.\n");
        }
    
        private static void editRecord(Map<String, String> map, Scanner scanner) 
        {
            System.out.print("Enter the key of the record to edit: ");
            String record = scanner.next();
        
            boolean found = false;
        
            for (Map.Entry<String, String> entry : map.entrySet()) 
            {
                if (entry.getKey().equals(record)) {
                    System.out.print("Enter first name: ");
                    String editFirstName = scanner.next();
        
                    System.out.print("Enter last name: ");
                    String editLastName = scanner.next();
        
                    if (!record.equals(editFirstName) || !record.equals(editLastName)) 
                    {
                        // Remove the old key-value pair
                        String oldValue = map.remove(record);
                        System.out.println("Old record deleted: Name " + record + " Surname " + oldValue);
                    }
        
                    map.put(editFirstName, editLastName);
                    System.out.println("Record edited successfully.\n");
        
                    found = true;
                    break;
                }
            }
        
            if (!found) {
                System.out.println("Record not found.\n");
            }
        }
        
        
        
    
        private static void deleteRecord(Map<String, String> map, Scanner scanner) 
        {
            System.out.print("Enter the name or surname of the record to delete: ");
            String record = scanner.next();
        
            //Using Iterator to remove elements of hashmap while it iterates
            Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
            boolean found = false;
        
            while (iterator.hasNext()) 
            {
                Map.Entry<String, String> entry = iterator.next();
                //Checking if the key(Name) or value(surname) is matching what user has typed in
                if (entry.getKey().equals(record) || entry.getValue().equals(record)) 
                {
                    //Removes the record if it matches
                    iterator.remove();
                    System.out.println("Record removed: Name " + entry.getKey() + " Surname " + entry.getValue());
                    found = true;
                }
            }
        
            if (!found) 
            {
                System.out.println("Record not found.");
            }
        }    
}
