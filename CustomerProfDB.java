import java.io.*;                    // imports all of the java.io
import java.util.ArrayList;             // imports the ArrayList data structure and its operations

public class CustomerProfDB {

    private int numCustomer = 0;                     // number of total customers
    private int currentCustomerIndex = 0;
    private String fileName;
    //CustomerProf[] customerList;
    private ArrayList<CustomerProf> customerList = new ArrayList<CustomerProf>();

    public CustomerProfDB(String f){

        fileName = f;                  // this holds the filename of the file holding aal of the profile data
    }

    //This method adds a new profile to the customerList private variable
    public void insertNewProfile(CustomerProf cProf){
        customerList.add(cProf);                                           // the arraylist add method adds the customer profile object given as an argument
        numCustomer++;
        System.out.println(numCustomer);
    }

    //this methods finds the profile specified by the admin id and the last name and then deletes it
    public boolean deleteProfile(String adId, String lastName){
        for (int n = 0; n < customerList.size();n++){
            if (customerList.get(n).getAdminID() == adId && customerList.get(n).getLastName() == lastName){
                numCustomer--;
                return customerList.remove(customerList.get(n));               //arraylist remove method removes the specific object from the arraylist
            }
        }
        return false;
    }

    // this method finds a specific profile when given the admin who made it and the last name of the customer
    public CustomerProf findProfile(String adID, String lName){
        for (int n = 0; n < customerList.size();n++){
            if (customerList.get(n).getAdminID() == adID && customerList.get(n).getLastName() == lName){
                return customerList.get(n);
            }
        }
        return null;
    }


    //findFirstProfile():CustomerProf                                 // These methods need the interface working
    //findNextProfile():CustomerProf



    // the function below writes all of the objects to the ProfileData file
    // this still needs some work it has issues
    // the File once an object is written to it becomes un-openable

    public void writeAllCustomerProf() throws IOException {
        String path = "C:\\Users\\Owner\\IdeaProjects\\CSE 2102 Project 1\\src\\" + fileName;
        for (int n = 0; n < customerList.size();n++){
            FileOutputStream fOut = new FileOutputStream(path);
            ObjectOutputStream oOut = new ObjectOutputStream(fOut);
            oOut.writeObject(customerList.get(n));
            oOut.close();
        }
    }

    // the function below checks to see if the database file  exists and it it doesn't it will make one

    public void initializeDatabase(String file){
        File f = new File(file);
        if (!f.exists()){
            try{
                f.createNewFile();
            }catch (Exception e){
                System.out.println(e);
            }
        }
    }


}
