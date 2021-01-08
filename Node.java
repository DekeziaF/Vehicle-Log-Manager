
package vehichlelogmanager;


public class Node{
    //data fields 
    public String reg_plate;
    public String f_name;
    public String l_name;
    public String veh_make;
    public String veh_model;
    public String veh_color;
    public String current_date;
    public String entry_time;
    public String departure_time;
    //reference
    public Node link;
//default constructor 
public Node(){
    
    //initializes fields 
    reg_plate = "";
    f_name = "";
    l_name = "";
    veh_make = "";
    veh_model = "";
    veh_color = "";
    current_date = "";
    entry_time = " ";
    departure_time = " ";
    link = null;
}
//overloaded constructor 
public Node(String fN, String lN, int dPN, String eD, String rP, String vMA, String vMO,
        String vC, String cD, String dT, Node lnk){
    
    reg_plate = rP;
    f_name = fN;
    l_name = lN;
    veh_make = vMA;
    veh_model = vMO;
    veh_color = vC;
    current_date = cD;
    departure_time = dT;
    
    link = lnk;
}

}// end Node class

