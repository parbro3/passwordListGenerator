import java.io.FileOutputStream;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;

public class FileWriter {

    public static void writeStringToFile(String fileName, String content) {

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            DataOutputStream dataOutStream = new DataOutputStream(new BufferedOutputStream(outputStream));
            dataOutStream.writeUTF(content);
            dataOutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}