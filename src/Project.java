package src;

import com.opencsv.CSVWriter;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;


public class Project {

    private ArrayList<Student> allStudentList = new ArrayList<>();
    private ArrayList<Group> allGroupList = new ArrayList<>();
    private int groupMaxNumberStudents;

    public void run() {
        boolean flag = true;
        Scanner input = new Scanner(System.in);
        while (flag) {
            System.out.println();
            System.out.println("\n------------------------\nOptions\n------------------------\n" +
                    "1: Upload CSV\n" +
                    "2: Select Maximum Capacity of group members\n" +
                    "3: Add Students to a group\n" +
                    "4: Display All Groups\n" +
                    "5: Save Group to CSV\n" +
                    "6: Quit\n");

            System.out.print("Choose an option: ");
            int option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1 ->
//                  uploadCSV("Data/Team allocation preferences(1-1).csv"); //CSV file to be imported
                        uploadCSV("Data/testData.csv"); //Testing my random data generator
                case 2 -> setMaxStudents();
                case 3 -> addStudentsToGroup();
                case 4 -> listGroups();
                case 5 -> saveToCSV(allGroupList.get(0)); // For purpose of testing, this passes the first and only group
                case 6 -> flag = false;
                default -> System.out.println("Invalid option.");
            }
        }
    }

    private void saveToCSV(Group group) {
        // Creating filename from group number
        String fileName = ("Group" + group.getID() + ".csv");

        try {
            // create FileWriter object with file as parameter
            FileWriter outputFile = new FileWriter("Output/" + fileName);

            // create CSVWriter object filewriter object as parameter
            CSVWriter csvw = new CSVWriter(new PrintWriter(outputFile));

            // Adding Header to CSV
            String[] header = {"ID", "Name", "Student Number"};
            csvw.writeNext(header);

            // adding data to csv
            for (int i = 0; i < group.getGroupSize(); i++) {
                String[] line = {
                        group.getStudentAtIndex(i).getId(),
                        group.getStudentAtIndex(i).getName(),
                        group.getStudentAtIndex(i).getStudentID()
                };
                csvw.writeNext(line);
            }
            csvw.close(); //Equivalent of saving the file
            System.out.println();
            System.out.println("The file has been saved in Output/" + fileName);
            System.out.println();

        } catch (IOException e) {
            System.out.println("File was not created or saved correctly.");
            e.printStackTrace();

        }
    }

    private void addStudentsToGroup() {
        // Creating a new Group with the argument of the maximum number allowed in the group
        Group tempGroup = new Group(groupMaxNumberStudents);

        // Just adding the first students in the all student list for testing, will need to be updated with logic in the future
        for (int i = 0; i < groupMaxNumberStudents; i++) {
            tempGroup.addStudent(this.allStudentList.get(i));
        }

        // Adding the group to the all group list
        allGroupList.add(tempGroup);

        // Printing the group list to command line
        tempGroup.printStudentList();

    }

    private void uploadCSV(String filePath) {
        if (filePath.contains(".csv")) {
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

                    System.out.println();
                    System.out.println("List has been uploaded");

                } catch (NumberFormatException e) {
                    System.out.println();
                    System.out.println("There has been an error while uploading a list of student in CSV file");
                    System.out.println("some/all listings will not have been loaded into the program.");
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println();
                    System.out.println("The file is corrupted, please select a valid file");
                }
            } catch (FileNotFoundException e) {
                System.out.println();
                System.out.println("Error! CSV file not found, there was no listings loaded into the program");
            }
        } else {
            System.out.println();
            System.out.println("Please only upload the correct file type!");
        }

    }

    private void listGroups() {
//        Iterator myIterator = this.allGroupList.iterator();
//        while (myIterator.hasNext()) {
//            Group t = (Group) myIterator.next();
//            System.out.println(t);
//        }

        //Printing the list of groups
        System.out.println("The list of groups:");
        for (Group g: allGroupList){
            System.out.println("    - Group " + g.getID());
        }
    }

    private void setMaxStudents() {
        Scanner input = new Scanner(System.in);
        int option;

        System.out.println();
        System.out.println("What is the maximum number of students allowed in each group?");
        System.out.println();

        while (true) {
            System.out.print("Maximum number of students: ");
            option = input.nextInt();
            if (option >= 5 && option <= 7) {
                groupMaxNumberStudents = option;
                break;
            } else {
                System.out.println("You need to select an integer between 5-7");
            }
        }


        System.out.println();
        System.out.println("Maximum group size has been set.");
    }

    //Fills array with test data for viewing output
//        public void fillTestGroup () {
////            Group[] testG = {new Group("John", "Fred", "Lisa", "Jennifer", "Tom", "Jessica", "Vinh")};
//            for (int i = 0; i < testG.length; i++)
//                allGroupList.add(testG[i]);
//        }


}