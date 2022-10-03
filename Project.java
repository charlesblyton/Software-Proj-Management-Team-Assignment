import java.io.*;
import java.util.*;

public class Project {

    private ArrayList<Value> allValuesList = new ArrayList<>();

    public void run() {
    boolean flag = true;
    Scanner input = new Scanner(System.in);
    while (flag) {
      System.out.println("Options\n------------------------\n"+
      "1: Upload CSV\n" +    
      "2: Upload XLSX\n"+              
      "3: Select Maximum Capacity of group members\n"+    
      "4: Display All Groups\n"+             
      "5: Quit\n");
      
      System.out.print("Choose an option: ");
      int option = input.nextInt();
      input.nextLine();
      switch (option) {
        case 1:
          uploadCSV();
          break;
        case 2:
          uploadXLSX();
          break;
        case 3:
          changeMaximum();
          break;
        case 4: 
          listGroups();
        break;
        case 5:
          flag = false;
          break;
        default:
          System.out.println("Invalid option.");
        }
    
    }
   
  } 
  public void uploadCSV() {
      File path = new File("./data/Team allocation preferences[1-1].csv");
      ArrayList<String> listings = new ArrayList<>();
      String[] parameters;

      try {
        Scanner scan = new Scanner(file);
        scan.nextLine();

        while (scan.hasNextLine()) {
          String info = scan.nextLine();
          lisings.add(info);
        }
        scan.close();
      }
      catch (FileNotFoundException e) {
          System.out.println();
          System.out.println("Error! CSV file not found, there was no listings loaded into the program");
          System.out.println();
      }
      try {
          for (String p : listings) {
              parameters = p.split(",");
              allValuesList.add (new Value (
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
                      parameters[13],
                      parameters[14],
              ));

          }
      } catch (NumberFormatException e) {
          System.out.println();
          System.out.println("There has been an error while uploading a list of student in CSV file");
          System.out.println("some/all listings will not have been loaded into the program.");
          System.out.println();
      }

  }

  public void uploadXLSX {

  }

  public void changeMaximum {

  }

  public void listGroups {

  }

  
}