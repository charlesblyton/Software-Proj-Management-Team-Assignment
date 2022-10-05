package src;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;


public class Project {

    private ArrayList<Student> allStudentList = new ArrayList<>();

    public void run() {
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while (flag) {
            System.out.println("Options\n------------------------\n" +
                    "1: Upload CSV\n" +
                    "2: Upload XLSX\n" +
                    "3: Select Maximum Capacity of group members\n" +
                    "4: Display All Groups\n" +
                    "5: Quit\n");

            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();
            System.out.println("Is the All Student List Empty before uploadCSV()? " + allStudentList.isEmpty()); //This is for checking if the uploadCSV() method is working

            switch (option) {
                case 1 -> {
//                  uploadCSV("Data/Team allocation preferences(1-1).csv"); //CSV file to be imported
                    uploadCSV("Data/testData.csv"); //Testing my random data generator
                    System.out.println("Is the All Student List Empty after uploadCSV()? " + allStudentList.isEmpty()); //This is for checking if the uploadCSV() method is working
                }
                case 2 -> uploadXLSX();
                case 3 -> changeMaximum();
                case 4 -> listGroups();
                case 5 -> flag = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    public void uploadCSV(String filePath) {
        File path = new File(filePath);
        ArrayList<String> listings = new ArrayList<>();
        String[] parameters;

        try {
            Scanner scan = new Scanner(path);
            scan.nextLine();

            while (scan.hasNextLine()) {
                String info = scan.nextLine();
                listings.add(info); // at the end of loop will have String array of all the lines in the CSV file
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println();
            System.out.println("Error! CSV file not found, there was no listings loaded into the program");
            System.out.println();
        }
        try {
            for (String p : listings) {
                parameters = p.split(",");
                allStudentList.add(new Student(
                        parameters[0],
                        parameters[1],
                        parameters[2],
                        parameters[3],
                        parameters[4],
                        parameters[5],
                        parameters[6],
                        parameters[7],
                        parameters[8],
                        parameters[9],
                        parameters[10],
                        parameters[11],
                        parameters[12],
                        parameters[13]
                ));

            }
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("There has been an error while uploading a list of student in CSV file");
            System.out.println("some/all listings will not have been loaded into the program.");
            System.out.println();
        }

    }

    public void uploadXLSX() {

    }

    public void changeMaximum() {

    }

    public void listGroups() {

    }


}