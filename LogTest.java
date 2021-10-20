import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LogTest {

    public static int square(int x){
        int squared = x*x;
        return squared;
    }

    public static void main(String[] args) throws IOException {

        FileWriter logWrite = new FileWriter("Log",true);  //file writer initialized
        int output = square(Integer.parseInt(args[0]));    // gets the output of the example square function
        System.out.println(output);  // prints output to terminal
        LocalTime currTime = LocalTime.now(); // gets the current time
        DateTimeFormatter basic = DateTimeFormatter.ISO_TIME;  // formats the time correctly

        // Everything below this line is individual to this program it can be changed at will
        //currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) gets rid of trailing milliseconds in our time

        if(output == 4){
            logWrite.write(currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) + " Running square in LogTest: It was a Success\n");
        }else{
            logWrite.write(currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) + " Running square in LogTest: It was a failure\n");
        }
        logWrite.close();
    }
}
