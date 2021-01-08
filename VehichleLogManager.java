
package vehichlelogmanager;

import java.util.*;

public class VehichleLogManager {

    
    public static void main(String[] args) {
    
//variables 
    String first_name;
    String last_name;
    String registration_plate;
    String vehicle_make;
    String vehicle_model;
    String vehicle_color;
    String current_date;
    String entry_time;
    String departure_time;
    String search_item;
    String delete_item;
    char operation = ' ';
   
    //instances
    Scanner input = new Scanner(System.in);
    LinkedList list = new LinkedList();
    
    System.out.print("\t\tUNIVERSITY OF THE SOUTHERN CARIBBEAN(USC)"+
             "\n\t\tTEMPORARY VEHICLE PASS MANAGEMENT SYSTEM"+
            "\n\t\t\t\tWELCOME!!!!");
    
    System.out.print("\n\n");
    list.printLogEntries();// prints entries from vehicle data file
    
    do{
    //the menu     
    System.out.print("\n*******************************************************************************************************"+
            "\n\nEnter the letter that corresponds with the action you would like to take."+
            "\t\n 1. ADD a New Vehicle Entry."+
            "\t\n 2. EDIT/UPDATE an entry."+
            "\t\n 3. VIEW the number of vehicles on the compound."+
            "\t\n 4. DISPLAY the log entries for all the vehicles on the compound."+
            "\t\n 5. DISPLAY the entries for vehicles that have left the compound."+
            "\t\n X. Exit this program. Enter X."+
            "\n*******************************************************************************************************");
    
    System.out.print("\nEnter your option here(1, 2, 3, 4, 5, X): ");
    operation = input.next().charAt(0);
    
    //evaluates user input 
    switch(operation){
        
        case '1':
            input.nextLine();
            System.out.print("\nEnter the vehicle registration plate: ");
            registration_plate = input.nextLine();            
            System.out.print("\nEnter the first name of the vehicle driver: ");
            first_name = input.nextLine();
            System.out.print("\nEnter the last name of the vehicle driver: ");
            last_name = input.nextLine();
            System.out.print("\nEnter the vehicle make: ");
            vehicle_make = input.next();
            System.out.print("\nEnter the vehicle model: ");
            input.nextLine();
            vehicle_model = input.nextLine();
            System.out.print("\nEnter the vehicle color: ");
            vehicle_color = input.nextLine();
            System.out.print("\nEnter today's date(dd/mm/yyyy): ");
            current_date = input.nextLine();
            System.out.print("\nEnter the vehicle's time of entry(HH:MM): ");
            entry_time = input.nextLine();
            System.out.print("\nEnter the vehicle's time of departure(HH:MM, 'IN' if the vehicle has not left): ");
            departure_time = input.nextLine();
            
            String append = "new";
            list.insertBack(registration_plate, first_name, last_name, vehicle_make, vehicle_model, vehicle_color, current_date, entry_time, departure_time, append);
         
           break;
         
        case '2':
        
            input.nextLine();
            System.out.print("\nEnter the Registration Plate of the Vehicle Log that needs updating:  ");
            search_item = input.nextLine();
            
            System.out.print("\nEnter the departure time(HH:MM) of vehicle " + search_item + ":");
            departure_time = input.nextLine();
            
            list.Update(search_item, departure_time);
                                 
         break;
         
        case '3':
                 
            list.vehicleCount();
            
         break;
         
        case '4':
                    
            list.printLogEntries();
                        
         break;
         
        case '5':
           
            list.printHistoryFile();
            
         break;
         
        case 'X':
        case 'x':
            
             System.out.print("\nYou are about to exit the program.");
             
         break;
             
        default:
            
            System.out.print("\nI'm sorry. Please enter a letter from the menu provided. :-)");
            
    }//end switch
    
    }while(operation != 'X');//end do while loop
    
    System.out.println("\nByeeeeeee!!!!!!!!!");
    
    }// end main
    
}// end Vehicle Log Manager
