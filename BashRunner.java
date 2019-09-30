import java.lang.Process;
import java.lang.ProcessBuilder;
import java.lang.Runtime;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class BashRunner {

    public static void runProcess(String location, List<String> arguments) {
        Process p;
        try {

            ArrayList<String> allParams = new ArrayList<String>();
            allParams.add("sh");
            allParams.add(location);
            for(String argument : arguments)
                allParams.add(argument);

            //convert to array
            String [] cmd = allParams.toArray(new String[0]);

            //String[] cmd = { "sh", location};

            p = Runtime.getRuntime().exec(cmd); 
            p.waitFor(); 
            BufferedReader reader=new BufferedReader(new InputStreamReader(
                p.getInputStream())); 
            String line; 
            while((line = reader.readLine()) != null) { 
                System.out.println(line);
            } 
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
