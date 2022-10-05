package src.CreatingRandomStudents;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class RandomStudentGenerator {


    public static void main(String[] args) throws FileNotFoundException {
        int numberOfStudents = 100; //Use this to set the number of students to create
        int numberOfWorkshops = 6;
        int minStudentNumber = 3109000;
        int maxSudentNumebr = 3120999;
        String platformOptions[] = {"iOS", "Android", "Desktop", "Web"};
        String languageOptions[] = {"Java", "Python", "C++"};
        String timezoneOptions[] = {"Not Important to me", "AEST", "ACWST", "ACST", "AWST"};

        Random randomInt = new Random(); //For making random studentID's
        RandomNameGenerator randomName = new RandomNameGenerator(0); //Making the random name generator, clear seed '1" to make it truly random
        List<String[]> dataLines = new ArrayList<>(); //Arraylist for storing data before writing to file

        String[] workshopList = new String[numberOfWorkshops];
        for (int i = 0; i < numberOfWorkshops; i++) { //creating the workshop names ie WRK1, WRK2, WRK3 etc depending on how many workshops specified

            workshopList[i] = "WRK" + (i + 1);
        }

        // Adding first line of CSV
        dataLines.add(new String[]{
                "ID",
                "Start time",
                "Completion time",
                "Email",
                "Name",
                "Your name(FirstName LastName)",
                "Your student ID",
                "Your workshop class",
                "Preferred student IDs separated by commas (max. 6 student IDs):", "Platform",
                "languages",
                "Timezone",
                "Preferred week days",
                "Preferred day / nighttimes for team - work"
        });

        //Variables for creating students
        String id, startTime, completionTime, email, name, yourName, studentID, workshop, preferredStudents, platform, language, timezone, preferredWeekDays, preferredTimes;


        int counter = 1;
        while (counter < (numberOfStudents+1)) { //Loop for creating all the test data
            id = String.valueOf(counter); //Setting consecutive ID's
            startTime = "-"; // Start time and end time don't matter yet
            completionTime = "-";
            studentID = "s" + randomInt.nextInt(minStudentNumber, maxSudentNumebr); //Will provide random int between these two numbers
            email = studentID + "@rmit.edu.au";
            String tempName = randomName.next();
            yourName = tempName;
            name = tempName;
            workshop = workshopList[randomInt.nextInt(0, numberOfWorkshops)];

            // Creating Random numbers of random students (6 max),
            String tempStudentList = "\"";
            for (int i = 0; i < randomInt.nextInt(1,6); i++) {
                String tempRandoStudentNumber = ("s" + randomInt.nextInt(minStudentNumber, maxSudentNumebr));
                if (tempRandoStudentNumber.equals(studentID)) { //just making sure the preferences aren't the student's own student number
                    continue;
                }
                tempStudentList = tempStudentList.concat(tempRandoStudentNumber + ",");
            }
            tempStudentList = tempStudentList.concat("\"");
            if (tempStudentList.equals("\"\"")) {
                tempStudentList = "-";
            }
            preferredStudents = tempStudentList;

            platform = platformOptions[randomInt.nextInt(0, platformOptions.length)];

            Collections.shuffle(Arrays.asList(languageOptions));
            language = languageOptions[0] + ";" + languageOptions[1] + ";" + languageOptions[2] + ";";
//            language = languageOptions[randomInt.nextInt(0, languageOptions.length)];

            timezone = timezoneOptions[randomInt.nextInt(0, timezoneOptions.length)];

            preferredWeekDays = "-";
            preferredTimes = "-";


            dataLines.add(new String[]{id, startTime, completionTime, email, name, yourName, studentID, workshop, preferredStudents, platform, language, timezone, preferredWeekDays, preferredTimes});
            counter++;
        }

        // Writing Data to File
        File csvOutputFile = new File("Data/testData.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(RandomStudentGenerator::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public static String convertToCSV(String[] data) {
        return String.join(",", data);
    }
}




