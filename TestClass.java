import java.io.IOException;                // io exception is imported for file writing errors
/*
* This class is for the testing of any of the classes that are developed,
* "REMEMBER THAT WHENEVER YOU TEST SOMETHING WRITE IT TO LOG FOR DOCUMENTATION"
*
*
*
*
* */




public class TestClass {




    public static void main(String[] args) throws IOException {



        //When you want to test something in the classes use the try structure below
        //these comments. Alter freely as you want
        //Anything that is tested will be put in the Log File


        try {
            VehicleInfo vIf = new VehicleInfo("Nissan","2003","Altima","New");           // new vehicleInfo object
            CustomerProf testCProf = new CustomerProf("001","Harold","Keeling","1132 Bridge ave",
                    "(475) 455-0975",30000,"Active","Work",vIf);  //new CustomerProfile object
            CustomerProfDB dbBasic = new CustomerProfDB("ProfileData");   // new Customer Database object
            dbBasic.initializeDatabase("ProfileData");
            dbBasic.insertNewProfile(testCProf);
            //dbBasic.writeAllCustomerProf();
            LogTest.writeLog("CustomerProfDB.java","Assorted Functions (initializeDatabase, insert etc.)" ,true);
        }catch (Exception e){
            System.out.println("There was an error while testing!!");
            System.out.println(e);
            LogTest.writeLog("CustomerProf.java","Initialization, and returning data inputted" ,false);
        }

    }
}
