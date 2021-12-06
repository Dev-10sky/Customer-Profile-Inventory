import java.io.IOException;                // io exception is imported for file writing errors
/*
 * This class is for the testing of any of the classes that are developed,
 * "REMEMBER THAT WHENEVER YOU TEST SOMETHING WRITE IT TO LOG FOR DOCUMENTATION"
 *
 *
 *
 *
 */
import java.util.concurrent.TimeUnit;
public class TesterClass {


    public static void main(String[] args) throws IOException {



        //When you want to test something in the classes use the try structure below
        //these comments. Alter freely as you want
        //Anything that is tested will be put in the Log File


        try {
            VehicleInfo vf = new VehicleInfo("Altima","2001","sedan","Used");
            CustomerProf pf1 = new CustomerProf("001","Harold","Keeling","123 Thorty Ave.","2034782345",30000,"Active","Work",vf);

            VehicleInfo vf2 = new VehicleInfo("Toyota","2005","Minivan","New");
            CustomerProf pf2 = new CustomerProf("PA1","Susan","Ford","1572 Ellenant St.","2035791369",45030,"Inactive","School",vf2);

            VehicleInfo vf3 = new VehicleInfo("Subaru","2008","sedan","Used");
            CustomerProf pf3 = new CustomerProf("001","Kelly","Anderson","1982 Ellecate Rd.","2038731929",30030,"Active","Leisure",vf3);

            CustomerProfDB db = new CustomerProfDB("DB.txt");
            db.insertNewProfile(pf1);
            db.insertNewProfile(pf2);
            db.insertNewProfile(pf3);
            UpdateProfile up = new UpdateProfile(db);
            up.main();
            //FindProfile fp = new FindProfile(db);
            //fp.main();
            //Update up = new Update();
            //up.makeFrame("001","Johnson","address");
            //DisplayAllProfiles dap1 = new DisplayAllProfiles(db);
            //dap1.main();
            LogTest.writeLog("DisplayAllProfiles.java","Testing the display all profile function" ,true);
        }catch (Exception e){
            System.out.println("There was an error while testing!!");
            System.out.println(e);
            LogTest.writeLog("DisplayAllProfiles.java","Testing the display all profile function" ,false);
        }
    }
}
