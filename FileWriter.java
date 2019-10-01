import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.BufferedOutputStream;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.PrintWriter;

public class FileWriter {

    public static void writeStringToFile(String fileName, String content) {
        try (PrintWriter out = new PrintWriter(fileName)) {
            out.println(content);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public static List<String> readInFileToList(String path){

        BufferedReader bufReader = null;
        try{
            bufReader = new BufferedReader(new FileReader(path));
            ArrayList<String> listOfLines = new ArrayList<>();
        
            try{
                String line = bufReader.readLine();
                while (line != null) {
                    listOfLines.add(line);
                    line = bufReader.readLine();
                }
                bufReader.close();
                return listOfLines;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}