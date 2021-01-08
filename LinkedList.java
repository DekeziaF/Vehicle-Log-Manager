
package vehichlelogmanager;

import java.io.*;
import java.util.Scanner;

public class LinkedList{
     public Node head; 
     public Node current;
     public Node tail;
     public int listLength;
     
     //variables 
    public String regPlate;
    public String fName;
    public String lName;
    public String vehMake;
    public String vehModel;
    public String vehColor;
    public String currentDate;
    public String entryTime;
    public String departureTime; 
//default constructor      
public LinkedList(){
     head = null;
     current = null;
     tail = null;
     listLength = 0;
}//end constructor

//method that adds elements to the back of the list 
public void insertBack(String RP, String FN, String LN, String VMa, String VMo,
        String VC, String CD, String ET, String dT, String append){
    
    Node newNode = new Node();
    newNode.reg_plate = RP;//stores data in the Node class
    newNode.f_name = FN;//stores data in the Node class
    newNode.l_name = LN;//stores data in the Node class
    newNode.veh_make = VMa;//stores data in the Node class
    newNode.veh_model = VMo;//stores data in the Node class
    newNode.veh_color = VC;//stores data in the Node class
    newNode.current_date = CD;//stores data in the Node class
    newNode.entry_time = ET;//stores data in the Node class
    newNode.departure_time = dT;//stores data in the Node class
    
    //checks is the list is null before adding
    if(head == null){
        // makes both head and tail equal the new node
        head = newNode;
        tail = newNode;
    }
    else{
        // makes tail point to the newly added node
        tail.link = newNode;
        tail = newNode;
    }// end else
    //increments list length
    listLength++;
    
    // appends item to the file if it is new data being added
    if(append.equals("new")){
        
        append(RP, FN, LN, VMa, VMo, VC, CD, ET, dT, "log");
        deleteList();
    }// end if
    
}// end of insertion method


// creates file and appends to file
public static void append(String RP, String FN, String LN, String VMa, String VMo, String VC, String CD, String ET, String dT, String file){
    // appends to vehicle_data_log file when necessary 
    if(file.equals("log")){
        try{
                
            File newFile = new File("C:\\Users\\dekez\\Desktop\\vehicle_data_log.txt"); // creates file
            FileWriter write = new FileWriter(newFile, true);// allows for data to be appended to the file 
            BufferedWriter buffer = new BufferedWriter(write);
            PrintWriter printWrite = new PrintWriter(buffer);
    
            // appends data to the file
            printWrite.print(RP);
            printWrite.print("\t\t");
            printWrite.print(FN);
            printWrite.print("\t\t");
            printWrite.print(LN);
            printWrite.print("\t\t");
            printWrite.print(VMa);
            printWrite.print("\t\t");
            printWrite.print(VMo);
            printWrite.print("\t\t");
            printWrite.print(VC);
            printWrite.print("\t\t");
            printWrite.print(CD);
            printWrite.print("\t\t");
            printWrite.print(ET);
            printWrite.print("\t\t");
            printWrite.println(dT);
            printWrite.close();
            
        }
        catch(IOException e){
        
        System.out.println("File does not exist.");
        }// end try catch exception
                
    }// end append to log file if
    
    // writes data to the file after an update has been made
    if(file.equals("newLog")){  
        
                try{
            
                    File newFile = new File("C:\\Users\\dekez\\Desktop\\vehicle_data_log.txt");
                    FileWriter write = new FileWriter(newFile, true);
                    BufferedWriter buffer = new BufferedWriter(write);
                    PrintWriter printWrite = new PrintWriter(buffer);
            
                    //appends data to file                        
                    printWrite.print(RP);
                    printWrite.print("\t\t\t");
                    printWrite.print(FN);
                    printWrite.print("\t\t");
                    printWrite.print(LN);
                    printWrite.print("\t\t");
                    printWrite.print(VMa);
                    printWrite.print("\t\t");
                    printWrite.print(VMo);
                    printWrite.print("\t\t");
                    printWrite.print(VC);
                    printWrite.print("\t\t");
                    printWrite.print(CD);
                    printWrite.print("\t\t");
                    printWrite.print(ET);
                    printWrite.print("\t\t");
                    printWrite.println(dT);
                    printWrite.close();
    
                }
                catch(IOException e){
                    System.out.println("File does not exist.");
                }// end try catch exception 
            
    }// end append to log file 
    // appends data to history file after being deleted from log history    
    if(file.equals("history")){
        
        try{
         
            File newFile = new File("C:\\Users\\dekez\\Desktop\\vehicle_log_history.txt");
            FileWriter write = new FileWriter(newFile, true);
            BufferedWriter buffer = new BufferedWriter(write);
            PrintWriter printWrite = new PrintWriter(buffer);
    
    
            printWrite.print(RP);
            printWrite.print("\t\t");
            printWrite.print(FN);
            printWrite.print("\t\t");
            printWrite.print(LN);
            printWrite.print("\t\t");
            printWrite.print(VMa);
            printWrite.print("\t\t");
            printWrite.print(VMo);
            printWrite.print("\t\t");
            printWrite.print(VC);
            printWrite.print("\t\t");
            printWrite.print(CD);
            printWrite.print("\t\t");
            printWrite.print(ET);
            printWrite.print("\t\t");
            printWrite.println(dT);
            printWrite.close();
    
        }
        catch(IOException e){
        
            System.out.println("File does not exist.");
        }// end try catch exception 
    }// end append to log file
             
}// end append function

// method to read data from files
public void Read(String toReadFrom){
    
    // reads data from the vehicle_log entry file
    if(toReadFrom.equals("LogEntries")){
        try{
           // new instance of file Scanner and FileReader 
           Scanner inFile = new Scanner(new FileReader ("C:\\Users\\dekez\\Desktop\\vehicle_data_log.txt"));
                            
           //reads from the file until an empty line                             
           while(inFile.hasNextLine() || inFile.hasNext()){               
                //variables that store the data that is read from the file                 
                String rPlate = inFile.next();
                String fNme = inFile.next();
                String lNme = inFile.next();
                String vMake = inFile.next();
                String vModel = inFile.next();
                String vColor = inFile.next();
                String cDate = inFile.next();
                String eTime = inFile.next();                
                String dTime = inFile.next();
                String append = "old";
                      
                inFile.nextLine();// moves unto the next line
                
                // allows the data that is read from the file to be added to a linked list
                insertBack(rPlate, fNme, lNme, vMake, vModel, vColor, cDate, eTime, dTime, append);
                                     
            }// end while loop 
            inFile.close(); // stop reading from file   
            }// end try           
            catch(FileNotFoundException e){
                      System.err.println("Sorry. An Errror Occurred.");

            }//end catch
    }// end if 
    // reads data from the history file
    else if(toReadFrom.equals("HistoryFile")){        
        try{
           // new instance of file Scanner and FileReader 
           Scanner inFile = new Scanner(new FileReader ("C:\\Users\\dekez\\Desktop\\vehicle_log_history.txt"));
                             
           // reads from the file until an empty line                               
           while(inFile.hasNextLine() || inFile.hasNext()){
               
                // variables that store the data that is read from the file                 
                String rPlate = inFile.next();
                String fNme = inFile.next();
                String lNme = inFile.next();
                String vMake = inFile.next();
                String vModel = inFile.next();
                String vColor = inFile.next();
                String cDate = inFile.next();
                String eTime = inFile.next();
                String dTime = inFile.next();
                String append = "old";
                      
                inFile.nextLine();// moves unto the next line
                // stores the data that is read from the file into a linked list                               
                insertBack(rPlate, fNme, lNme, vMake, vModel, vColor, cDate, eTime, dTime, append);
                                     
            }// end while loop 
            inFile.close(); // stop reading from file   
            }// end try           
            catch(FileNotFoundException e){
                      System.err.println("Sorry. An Errror Occurred.");

            }//end catch
    }//end else statement
}// end read function 

//method used to search an item 
public void Update(String searchItem, String departure){
    
    Scanner input = new Scanner(System.in);
    
    Read("LogEntries");
                
    boolean found = false; 
    current = head;//makes current point to the first node in the list

    //searches until current reaches the end pf the list and if the item has not been found
    while (current != null && !found){

    //checks if f_name holds the search item
        if(current.reg_plate.equals(searchItem)){
            found = true;
            System.out.print("\nPlease Confirm that you would like to update this entry:"+
                             "\n\t Vehicle Registration Plate: "+ current.reg_plate + 
                             "\n\n ***** "+ current.f_name + " "+ current.l_name + " *****" + 
                             "\n\t Vehicle Make: "+ current.veh_make+
                             "\n\t Vehicle Model: " + current.veh_model+
                             "\n\t Vehicle Color: " + current.veh_color+
                             "\n\t Current Date: " + current.current_date + 
                             "\n\t Entry Time: " + current.entry_time +   
                             "\nEnter Y to update and N to cancel: ");
            char opt = ' ';
                        
            opt = input.next().charAt(0);

            if(opt == 'Y' || opt == 'y'){

                append(current.reg_plate, current.f_name, current.l_name, current.veh_make, current.veh_model, current.veh_color, current.current_date, current.entry_time, departure, "history");
                                
                delete(current.reg_plate);
                
                File oldFile = new File("C:\\Users\\dekez\\Desktop\\vehicle_data_log.txt");
                oldFile.delete();
                
                current = head;
                
                while(current != null){
                    
                    append(current.reg_plate, current.f_name, current.l_name, current.veh_make, current.veh_model, current.veh_color, current.current_date, current.entry_time, current.departure_time, "newLog");
                    current = current.link;
                }// end while
                System.out.println("The details of registration plate "+ searchItem +  " have been updated.");
           }// end if
            else{
                System.out.println("The updating progess has been cancelled. You will now return to the main menu.");
            }
        }// end if
        else{
        current = current.link;// move to next node
        found = false;
        }// end else
                     
    } //end while 
    if(!found){
        
        System.out.println("The entry of Registration Plate " + searchItem + " has not been found.");
    }  
    
    deleteList();
    
}//end search method
public void vehicleCount(){
    
    Read("LogEntries");// reads data from vehicle log entries file
    
    current = head;//makes current hold the link to the first node in the list
    
    int lineCount = 0;// variable that counts the number of items in teh list
    
    // checks if the list is empty
    if(head== null){
        
        System.out.println("There are no vehicles on compound at this moment!");
    }
    // counts the items in the list
    else{
        while(current != null){
            
            lineCount+=1;// keeps count of the number of nodes in the list
            
            current = current.link;
        }// end while
    }// end else
    // displays line count to the user
    System.out.println("There are currently " + lineCount + " vehicle/s on the University's Coumpound.");
    deleteList();// deletes items in the list
    
}// end vehicleCount

// method that remerges the items after being sorted 
public Node sortLogEntries (Node left, Node right){
    
    Node sorting = null;// stores the new list
    // base cases
    if(left == null){
        
        return right;
    }
    else if(right == null){
        
        return left;
    }
    // compares the items in the list and returns by how much they differ from each other "lexographically"
    int compare = (left.reg_plate).compareTo(right.reg_plate);
    
    // switches the places of the items in the list based on how which one precedes the other the merges the lists
    if(compare < 0){
        
        sorting = left;
        sorting.link = sortLogEntries(left.link, right);
        
    }
    else if (compare > 0){
        
        sorting = right;
        sorting.link = sortLogEntries(left, right.link);
                
    }  
  
    return sorting;// returns the sorted list
}// end merge

//method to partition the list till reaches it's base case
public Node mergeLogEntries(Node head){
   
    Node trailCurrent;
    // Base case    
    if(head == null || head.link == null){
            
        return head;
    }// end if
    
   current = head.link;//makes current hold the link to the second node in the list 
   trailCurrent = head;// makes trail current hold the link to the first node in the list so that it "follows" current
                
        // finds the middle of the linked list      
    while(current != null){
            
        current = current.link;
            
        if(current!= null){
                
            trailCurrent = trailCurrent.link;
            current = current.link;
            
        }// end if 
            
   }// end while
   // gives a "head" to each list 
   Node righthead = trailCurrent.link;
   Node lefthead = head;
   trailCurrent.link = null;// partitions the list
                
   // breaks down the list into individual lists          
   Node right = mergeLogEntries(righthead);
   Node left = mergeLogEntries(lefthead);
      
   // remerges the list  
   Node sortedMerge = sortLogEntries(left, right);
       
   return sortedMerge;
} //end sort method

// prints the sorted vehicle log entries
public void printLogEntries(){        
    
    Read("LogEntries");// reads from the vehicle log entries file into a linked list
    current = mergeLogEntries(head);// gives current the head to the merged sorted list
    
   // lets the user know if the list is empty
    if (head==null){
        
        System.err.println("There are no vehicles on compound at this moment.");
    }
    // prints the items in the list
    while(current != null){
        
        System.out.print("Vehicles On University's Compound Presently: "+
                "\n\n Vehicle Registration Plate: "+ current.reg_plate + 
                "\n *****  "+ current.f_name + " "+ current.l_name + " *****" + 
                "\n\t Vehicle Make: "+ current.veh_make+
                "\n\t Vehicle Model: " + current.veh_model+
                "\n\t Vehicle Color: " + current.veh_color+
                "\n\t Current Date: " + current.current_date);
        
        current = current.link;// moves to the next node
    }// end while
  
    deleteList();// deletes the items in the list to prevent replication 
}//end print method
// method that prints the items in the history file
public void printHistoryFile(){
    
    Read("HistoryFile");// reads data from log history file into linked list
    current = head;// makes current point to the first item in the list 
    // lets the user know if there are no items in the file
    if (head==null){
                
        System.err.println("There are no vehicles entries in this file at this moment.");
    }
    // prints the items in the file
    while(current != null){
        
        System.out.print("Information on Driver's who have recieved passes for campus access: "+
                "\n\n Vehicle Registration Plate: "+ current.reg_plate + 
                "\n *****  "+ current.f_name + " "+ current.l_name + " *****" + 
                "\n\t Vehicle Make: "+ current.veh_make+
                "\n\t Vehicle Model: " + current.veh_model+
                "\n\t Vehicle Color: " + current.veh_color+
                "\n\t Current Date: " + current.current_date);
        
        current = current.link;// moves to the next node
    }// end while
    
    deleteList(); // deltes the items in the list to avoid replication 
}// end printHistoryFile

//deletes the list
public void deleteList(){
    
    head= null;
}// end delete list
    
//method that deletes an item from the list
public void delete(String deleteItem){
  
    Node trailCurrent;
    boolean found = false;
    
    //checks if list is empty
    if(head == null){
        
        System.err.println("My bad. This list is empty and cannot be deleted from.");
       
    }// end if 
    else {
        //checks if the item is in the first node
        if(head.reg_plate.equals(deleteItem)){
            
            head = head.link;
            
            //checks if there is only one node in the list 
            if (head == null){
                
                tail = null;
                //decrements list length
                listLength--;
            }//end if
        }// end if
        //executes if there is not only one item in the list
        else {
            
            trailCurrent = head;
            current = head.link;
            //searches the list for the item to be deleted
            while(current != null && !found){
                
                if(current.reg_plate.equals(deleteItem)){
                    
                    found = true;
                }// end if 
                else {
                    trailCurrent = current;
                    current = current.link;
                }
                
            }// end while
            if(found){
                listLength--;// decrements list length                 
                //removes node from list 
                trailCurrent.link = current.link;  
                
            //deleted node was the last Node 
                if(tail == current){
                    tail = trailCurrent; 
                }
            }
            else {
                  System.err.print("Sorry the item to be deleted is not in the list.");
                }
        }
    }// end else
   
}// end delete item method
    
}// end linked lists class
