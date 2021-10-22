import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class LogTest {

// this writeLog method can be used by all of the other classes and the arguments are: the Class you are testing,
// the function you are testing, and whether the test was successful or not (true or false)

    public static void writeLog(String testClass, String testFunc,boolean res) throws IOException {

        FileWriter logWrite = new FileWriter("Log",true);  //file writer initialized
        LocalTime currTime = LocalTime.now(); // gets the current time
        DateTimeFormatter basic = DateTimeFormatter.ISO_TIME;  // formats the time correctly

        // Everything below this line is individual to this program it can be changed at will
        //currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) gets rid of trailing milliseconds in our time
        if (res){
            logWrite.write(currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) + " Running " + testFunc + " in " + testClass + " : It was a Success\n");
        }else{
            logWrite.write(currTime.truncatedTo(ChronoUnit.SECONDS).format(basic) + " Running " + testFunc + " in " + testClass + " : It was a Failure\n");
        }
        logWrite.close();
    }

    public static void main(String[] args) throws IOException {

    }
}
