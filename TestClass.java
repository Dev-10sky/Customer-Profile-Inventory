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

            VehicleInfo vIf2 = new VehicleInfo("Nissan","2001","Sentra","Used");           // new vehicleInfo object
            CustomerProf testCProf2 = new CustomerProf("002","Jessica","Serrera","456 Logger St.",
                    "(456) 768-9746",40000,"Inactive","Work",vIf2);  //new CustomerProfile object

            VehicleInfo vIf3 = new VehicleInfo("Honda","2006","Civic","New");           // new vehicleInfo object
            CustomerProf testCProf3 = new CustomerProf("001","Larry","Secra","7869 Stoneway ave.",
                    "(203) 495-0875",25000,"Active","Transportation",vIf3);  //new CustomerProfile object

            CustomerProfDB dbBasic = new CustomerProfDB("newDB.txt");   // new Customer Database object
            dbBasic.initializeDatabase("newDB.txt");
            dbBasic.insertNewProfile(testCProf);
            dbBasic.insertNewProfile(testCProf2);
            dbBasic.writeAllCustomerProf();
            CustomerProf curr = dbBasic.findFirstProfile();
            System.out.println("First profile: "+ (curr.getFirstName() == testCProf.getFirstName()));
            curr = dbBasic.findNextProfile();
            System.out.println("Next profile: "+ (curr.getFirstName() == testCProf2.getFirstName()));
            dbBasic.initializeDatabase("newDB.txt");
            LogTest.writeLog("CustomerProfDB.java","Writing profiles to new Database (updated)" ,true);
        }catch (Exception e){
            System.out.println("There was an error while testing!!");
            System.out.println(e);
            LogTest.writeLog("CustomerProf.java","Writing profiles to new Database (updated)",false);
        }

    }
}
