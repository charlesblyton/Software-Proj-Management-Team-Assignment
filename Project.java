public class Project {

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
  public void uploadCSV {

  }

  public void uploadXLSX {

  }

  public void changeMaximum {

  }

  public void listGroups {

  }

  
}