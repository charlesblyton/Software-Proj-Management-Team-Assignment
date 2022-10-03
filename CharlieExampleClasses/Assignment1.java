package CharlieExampleClasses;

import CharlieExampleClasses.Property;

import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Assignment1 {
//
//    double totalCost;
    private ArrayList<Property> allPropertiesList = new ArrayList<>();
//    private Property selectedProperty = null;
//    private Customer selectedCustomer = null;
//    private LinkedList<LocalDate> selectedDates = null;


    //EDDIE THE METHOD populateList() IS THE METHOD I CREATED FOR READING CSV FILES
    // IT WOULD PROBABLY BE HELPFUL TO CREATE A FEW MORE ENTRIES IN THE '/ /Team allocation preferences[1-1].csv' DOCUMENT FOR TESTING



    public void populateList() {
        File file = new File("./src/CharlieExampleClasses/Melbnb.csv"); //bringing the file into the program as a File object
        ArrayList<String> listings = new ArrayList<>(); //Creating an arraylist to save the entries into
        String[] parameters;

        try {
            Scanner scan = new Scanner(file); // Scanning the file object into a scanner object
            scan.nextLine(); //This skips the first line, and we don't do anything with it

            while (scan.hasNextLine()) { //While the scanner still has a next line
                String line = scan.nextLine(); //save each line to a string variable
                listings.add(line); //Add that string to the arraylist
            }
            scan.close();
        } catch (FileNotFoundException e) { //Shows message to user if the file is not found
            System.out.println();
            System.out.println("No Valid CSV file was found, there we no listings loaded into the program.");
            System.out.println();
        }
        try {
            for (String p : listings) { //Splitting the parameters into individual entries in an array
                parameters = p.split(","); // Splitting the string so
                allPropertiesList.add(new Property( //Creating a new property inputting the data into the constructor
                        parameters[0],
                        parameters[1],
                        parameters[2],
                        parameters[3],
                        parameters[4],
                        Integer.parseInt(parameters[5]),
                        Double.parseDouble(parameters[6]),
                        Double.parseDouble(parameters[7]),
                        Double.parseDouble(parameters[8]),
                        Double.parseDouble(parameters[9]),
                        Integer.parseInt(parameters[10])
                ));
            }
        } catch (NumberFormatException e) { //For catching any errors while parsing data to integers and doubles
            System.out.println();
            System.out.println("There has been a number format exception while parsing the CSV file,");
            System.out.println("some/all listings will not have been loaded into the program.");
            System.out.println();
        }
    }

//    public void run(InputStream input) {
//        ArrayList<Property> tempPropertiesList;
//
//        System.out.println();
//        System.out.println("Welcome to Melbnb!");
//
//        while (true) {
//            System.out.println();
//            System.out.println("----------------------------------------------------------------------------------------------------------");
//            System.out.println("> Select from main menu");
//            System.out.println("----------------------------------------------------------------------------------------------------------");
//            System.out.println("    1) Search by location");
//            System.out.println("    2) Browse by type of place");
//            System.out.println("    3) Filter by rating");
//            System.out.println("    4) Exit");
//
//            switch (checkSelectionInt(4, input)) { //Runs the selection checking method, the parameter is the number of selections allowed
//                case 1 -> {
//                    tempPropertiesList = searchByLocation(input);
//                    selectedProperty = saveProperty(tempPropertiesList, input); //saving the selected property
//                }
//                case 2 -> {
//                    tempPropertiesList = searchByType(input);
//                    selectedProperty = saveProperty(tempPropertiesList, input);  //saving the selected property
//                }
//                case 3 -> {
//                    tempPropertiesList = searchByRating(input);
//                    selectedProperty = saveProperty(tempPropertiesList, input);  //saving the selected property
//                }
//                case 4 -> {
//                    System.out.println("Thank-you for using Melbnb. Goodbye");
//                    System.exit(0);
//                }
//            }
//
//            if (selectedProperty == null)
//                continue;
//
//            selectedDates = checkValidDates(input); //Saving the selected dates
//
//            totalCost = printBookingDetails(selectedDates, selectedProperty); //Saving the total cost
//
//            System.out.print("Would you like to reserve this property? (Y/N): ");
//            if (yesOrNoCheck(input) == 'Y') {
//                selectedCustomer = addCustomer(input, selectedProperty); //saving the selected customer
//
//                System.out.print("Confirm and pay (Y/N): ");
//                if (yesOrNoCheck(input) == 'Y') {
//                    printConfirmation(selectedCustomer, selectedProperty, selectedDates, totalCost);
//                }
//            }
//        }
//    }
//
//    public ArrayList<Property> searchByLocation(InputStream input) {
//        ArrayList<Property> tempProperty = new ArrayList<>(); //For storing when there are multiple properties that match the search criteria
//
////        Method for capturing user search, finding matching properties and saving it to the tempProperty array
//
//        System.out.print("Please provide a location: "); //Not println because we want user input on same line
//        String userSearch = readUserInput(input);
//
//        userSearch = userSearch.toLowerCase(); //converting the user's entry to lower case
//
//        for (Property p : allPropertiesList) {
//            String tempLocation = p.getLocation();
//            tempLocation = tempLocation.toLowerCase(); //converting the location saved in object to lower case
//            if (tempLocation.contains(userSearch)) {
//                tempProperty.add(p); //If the location matches the user search, add the property to the temporary arraylist
//            }
//        }
//        return tempProperty;
//    }
//
//    public ArrayList<Property> searchByType(InputStream input) {
//        ArrayList<Property> tempProperty = new ArrayList<>(); //For storing when there are multiple properties that match the search criteria
//
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Browse by type of place:");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        ArrayList<String> tempSet = new ArrayList<>(); //arraylist to store types of properties for listing to the user
//        for (Property p : allPropertiesList) {
//            if (!tempSet.contains(p.getAccomType())) { //If the arraylist doesn't contain a type of accommodation
//                tempSet.add(p.getAccomType()); //add the accommodation type to tempSet
//            }
//        }
//
//        int menuIncrementer = 1; //loop for displaying the menu list of accommodation types for selection
//        for (String i : tempSet) {
//            System.out.println("    " + menuIncrementer + ") " + i);
//            menuIncrementer++;
//        }
//        System.out.println("    " + menuIncrementer + ") Go to main menu"); //is always the last option displayed
//
//        int typeSelected = checkSelectionInt(menuIncrementer, input) - 1; //Saving and checking the selection of property type for user input errors
//        if (typeSelected > tempSet.size()) {  //If the selection was higher than the length of the array, they must have selected 'exit to main menu'
//            return null;
//        } // else will just continue the code
//
//        for (Property p : allPropertiesList) { //Loop for adding properties to tempProperty array and saving it to the saveProperty method
//            if (p.getAccomType().equals(tempSet.get(typeSelected))) { //if property type matches the type selected then display the property
//                tempProperty.add(p);
//            }
//        }
//        return tempProperty;
//    }
//
//    public ArrayList<Property> searchByRating(InputStream input) {
//        ArrayList<Property> tempProperty = new ArrayList<>(); //For storing when there are multiple properties that match the search criteria
//        Double selection;
//
//
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Search by property rating:");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        while (true) { //While loop to keep asking until the user gives a valid response
//            System.out.print("Please provide the minimum rating: ");  //Not println because we want user input on same line
//            try {
//                selection = Double.parseDouble(readUserInput(input)); //Scanning the user's response
//                if (selection < 0 || selection > 5) {
//                    throw new IndexOutOfBoundsException();
//                } else {
//                    break; //Else break out of the loop
//                }
//            } catch (NumberFormatException e) {
//                System.out.println(" - That is not a Double data type. Try again.");
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println(" - That is not a valid rating out of 5. Try again.");
//            }
//        }
//
//        for (Property p : allPropertiesList) {
//            Double tempRating = p.getRating();
//            if (tempRating > selection) {
//                tempProperty.add(p); //If the location matches the user search, add the property to the temporary arraylist
//            }
//        }
//
//        return tempProperty;
//    }
//
//    public Property saveProperty(ArrayList<Property> tempProperty, InputStream input) {
////        Method for displaying the results of the search, and taking user's selection and saving it
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Select from matching list:");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        if (tempProperty.isEmpty()) {
//            System.out.println("There were no properties matching your search. Enter '1' to return to the main menu. ");
//        }
//
//        int incrementer = 1;
//        for (Property p : tempProperty) { //Loop to display search results
//            System.out.println("    " + incrementer + ") " + p.getProperty());
//            incrementer++;
//        }
//        System.out.println("    " + incrementer + ") Go to main menu"); //is always the last option displayed
//
//        int indexPropertySelected = checkSelectionInt(incrementer, input) - 1; //The selection -1 will be the index of the selected property
//        if (indexPropertySelected > tempProperty.size() - 1) { //If the selection was higher than the length of the array, they must have selected 'exit to main menu'
//            return null; //Return nothing
//        } else {
//            return tempProperty.get(indexPropertySelected); // Adding selected property to the program-wide selectedProperty variable
//        }
//    }
//
//    public LinkedList<LocalDate> checkValidDates(InputStream input) {
//        LinkedList<LocalDate> dates = new LinkedList<>();
//        LocalDate checkIn, checkOut;
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Provide Dates");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        do { // Do-While loop to check that check-in date is before check-out date
//            do { //loop until a valid check-in date is entered
//                System.out.print("Please provide check-in date (dd/mm/yyyy): "); //Not println because we want user input on same line
//                checkIn = retrieveDateFromUser(input);
//            } while (checkIn == null);
//
//            do {  // Loop until a valid check-out date is entered
//                System.out.print("Please provide check-out date (dd/mm/yyyy): "); //Not println because we want user input on same line
//                checkOut = retrieveDateFromUser(input);
//            } while (checkOut == null);
//
//            if (checkIn.isBefore(checkOut)) {
//                dates.addFirst(checkIn);
//                dates.addLast(checkOut);
//            } else {
//                System.out.println("Your check-out date should be after your check-in date, try again.");
//            }
//        } while (dates.isEmpty()); //Loop until valid dates are saved in the ArrayList
//
//        return dates;
//    }
//
//    public LocalDate retrieveDateFromUser(InputStream input) {
//        LocalDate date = null;
//        int year, month, day;
//
//        boolean escape = true; //Boolean to escape the loop
//        do { // do-while Loop to retrieve date
//            try {
//                String[] inputCheckOut = readUserInput(input).split("/");  //saving the user input to an array by splitting the string
//                year = Integer.parseInt(inputCheckOut[2]);
//                month = Integer.parseInt(inputCheckOut[1]);
//                day = Integer.parseInt(inputCheckOut[0]);
//                date = LocalDate.of(year, month, day);
//
//                if (date.isAfter(LocalDate.now())) { //Checking if the date entered is in the past
//                    escape = false;
//                } else {
//                    System.out.println("The date you've entered is in the past, try again.");
//                }
//            } catch (NumberFormatException e) {
//                System.out.println("You must enter integers separated by '/', try again. ");
//            } catch (ArrayIndexOutOfBoundsException e) {
//                System.out.println("The date was not in the specified format, try again.");
//            } catch (DateTimeException e) {
//                System.out.println("The date you entered was not valid, try again.");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } while (escape);
//        return date;
//    }
//
//    public double printBookingDetails(LinkedList<LocalDate> dates, Property selectedProperty) {
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Show Property Details");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        long periodDays = ChronoUnit.DAYS.between(dates.getFirst(), dates.getLast()); //Method for calculating the number of days between check-in and check-out
////        long periodDays = 1; // For testing
//
//        String property = selectedProperty.getProperty() + " hosted by " + selectedProperty.getHostName();
//        System.out.printf("%-20s%-10s\n",
//                "Property:", property);
//
//        String type = selectedProperty.getAccomType();
//        System.out.printf("%-20s%-10s\n",
//                "Type of Place:", type);
//
//        String location = selectedProperty.getLocation();
//        System.out.printf("%-20s%-10s\n",
//                "Location:", location);
//
//        double rating = selectedProperty.getRating();
//        System.out.printf("%-20s%-3.2f\n",
//                "Rating:", rating);
//
//        String description = selectedProperty.getDescription();
//        System.out.printf("%-20s%-10s\n",
//                "Description:", description);
//
//        int guests = selectedProperty.getMaxGuests();
//        System.out.printf("%-20s%-10d\n",
//                "Number of Guests:", guests);
//
//        double price1 = selectedProperty.getPricePerNight() * periodDays;
//        String price2 = "($" + String.format("%.2f", selectedProperty.getPricePerNight()) + " * " + periodDays + " nights)";
//        System.out.printf("%-20s$%-10.2f%-10s\n",
//                "Price:", price1, price2);
//
//        double discountPrice1 = 0;//Declared outside the loop so can access to calculate total;
//        if (periodDays >= 7) {
//            double tempDisPrice = selectedProperty.getPricePerNight() * ((100 - (double) selectedProperty.getWeeklyDiscount()) / 100);
//            discountPrice1 = tempDisPrice * periodDays; //Declared outside the loop so can access to calculate total;
//            String discountPrice2 = "($" + String.format("%.2f", tempDisPrice) + " * " + periodDays + " nights)";
//            System.out.printf("%-20s$%-10.2f%-10s\n",
//                    "Discounted Price:", discountPrice1, discountPrice2);
//        } else {
//            System.out.printf("%-20s%-10s\n",
//                    "Discounted Price:", "No Discount applied for booking less than 7 days.");
//        }
//
//        double serviceFee1 = selectedProperty.getServiceFee() * periodDays;
//        String serviceFee2 = "($" + String.format("%.2f", selectedProperty.getServiceFee()) + " * " + periodDays + " nights)";
//        System.out.printf("%-20s$%-10.2f%-10s\n",
//                "Service Fee:", serviceFee1, serviceFee2);
//
//        double cleaningFee = selectedProperty.getCleaningFee();
//        System.out.printf("%-20s$%-10.2f\n",
//                "Cleaning Fee:", cleaningFee);
//
//        double total;
//        if (periodDays >= 7) {
//            total = discountPrice1 + serviceFee1 + cleaningFee;
//
//        } else {
//            total = price1 + serviceFee1 + cleaningFee;
//        }
//        System.out.printf("%-20s$%-10.2f\n",
//                "Total:", total);
//
//        return total;
//    }
//
//    public Customer addCustomer(InputStream input, Property selectedProperty) {
//
//        String firstname, surname, email = null;
//        int noGuests;
//
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("> Provide personal information");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//
//        System.out.print("Firstname: ");
//        firstname = readUserInput(input);
//
//        System.out.print("Surname: ");
//        surname = readUserInput(input);
//
//        do {
//            System.out.print("Email address: ");
//            String tempEmail = readUserInput(input);
//            if (tempEmail.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$")) { //Strict regular expression validation regex I took from a website
//                email = tempEmail;
//            } else {
//                System.out.println("That is not a valid email address, try again.");
//            }
//        } while (email == null);
//
//        int maxGuests = selectedProperty.getMaxGuests();
//        System.out.println("Number of guests (1-" + maxGuests + ")");
//        noGuests = checkSelectionInt(maxGuests, input); //Using the property's maximum number of guests
//
//        return new Customer(firstname, surname, email, noGuests);
//    }
//
//    public void printConfirmation(Customer selectedCustomer, Property selectedProperty, LinkedList<LocalDate> selectedDates, double totalCost) {
//        System.out.println();
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println("Your trip is booked, and payment will be handled by the 3rd party portal.");
//        System.out.println("----------------------------------------------------------------------------------------------------------");
//        System.out.println();
//
//        String name = selectedCustomer.getGivenName() + " " + selectedCustomer.getSurname();
//        System.out.printf("%-20s%-10s\n",
//                "Name:", name);
//
//        String email = selectedCustomer.getEmail();
//        System.out.printf("%-20s%-10s\n",
//                "Email:", email);
//
//        String property = selectedProperty.getProperty() + " hosted by " + selectedProperty.getHostName();
//        System.out.printf("%-20s%-10s\n",
//                "Your stay:", property);
//
//        String guest = selectedCustomer.getNoOfGuests() + " guests";
//        System.out.printf("%-20s%-10s\n",
//                "Who's coming:", guest);
//
//        String checkIn = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(selectedDates.getFirst());
//        System.out.printf("%-20s%-10s\n",
//                "Check-in date:", checkIn);
//
//        String checkOut = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG).format(selectedDates.getLast());
//        System.out.printf("%-20s%-10s\n",
//                "Check-out date:", checkOut);
//        System.out.println();
//
//        System.out.printf("%-20s$%-10s\n",
//                "Total Payment:", totalCost);
//
//        System.out.println();
//        System.out.println("Thank-you for using Melbnb!");
//
//        System.exit(0);
//    }
//
//    public Character yesOrNoCheck(InputStream input) {
//
//        while (true) {
//            String userResponse = readUserInput(input);
//            userResponse = userResponse.toUpperCase();
//            char response;
//            try {
//                response = userResponse.charAt(0);
//            } catch (StringIndexOutOfBoundsException e) {
//                System.out.print("Please respond to the prompt (Y/N): ");
//                continue;
//            }
//
//            if (response == 'Y') {
//                return response;
//            } else if (response == 'N') {
//                return response;
//            } else {
//                System.out.print("Please only respond with (Y/N): ");
//            }
//        }
//    }
//
//    public String readUserInput(InputStream input) throws IndexOutOfBoundsException {
//        //Using this now instead of straight scanner, so I can input data into system prompts where the user would normally input data
//        Scanner sc = new Scanner(input);
//        return sc.nextLine();
//    }
//
//    public int checkSelectionInt(int numberOfOptions, InputStream input) { // Method for checking that a user's selection is valid
//        while (true) { //While loop to keep asking until the user gives a valid response
//            System.out.print("Please Select: ");  //Not println because we want user input on same line
//            try {
//                int selection = Integer.parseInt(readUserInput(input)); //Scanning the
//                if (selection < 1 || selection > numberOfOptions) {
//                    throw new IndexOutOfBoundsException();
//                } else {
//                    return selection;
//                }
//            } catch (NumberFormatException e) {
//                System.out.println(" - This is not an integer, Try again.");
//            } catch (IndexOutOfBoundsException e) {
//                System.out.println(" - This selection is not within the given range of options, try again.");
//            }
//        }
//    }
//
//    public ArrayList<Property> getAllPropertiesList() {
//        return allPropertiesList;
//    }
//
//    public Property getSelectedProperty() {
//        return selectedProperty;
//    }
//
//    public Customer getSelectedCustomer() {
//        return selectedCustomer;
//    }
//
//    public LinkedList<LocalDate> getSelectedDates() {
//        return selectedDates;
//    }
}