import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PersonalData {
    String firstName;
    String lastName;
    List<String> otherInfo;

    public PersonalData(){ }

    public void retrievePersonal(){

        Scanner userInput = new Scanner(System.in);

        //get first name
        System.out.print("What is the person's first name?");
        String firstName = userInput.nextLine();
        if(DataChecker.checkInput(firstName))
            this.firstName = firstName;

        //get last name
        System.out.print("What is the person's first name?");
        String lastNameIn = userInput.nextLine();
        if(DataChecker.checkInput(lastNameIn))
            this.lastName = lastNameIn;

        //get the rest
        otherInfo = new ArrayList<>();
        System.out.print("Enter in other words that relate to this person. High school? Pet names? Family names? etc. Click enter when done");
        String otherIn = userInput.nextLine();
        while(!otherIn.equals("")){
            this.otherInfo.add(otherIn);
            otherIn = userInput.nextLine();
        }

    }

    public void writePersonal(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.firstName);
        sb.append("\n");
        sb.append(this.lastName);
        sb.append("\n");

        Integer sizeOfData = this.otherInfo.size();
        for(Integer i = 0; i < sizeOfData; i++) {
            sb.append(this.otherInfo.get(i));
            sb.append("\n");
        }
        FileWriter.writeStringToFile("./wordLists/personalList.txt", sb.toString());
    }

    public Boolean hasData() {
        if(this.firstName == null)
            return false;
        if(this.lastName == null)
            return false;
        if(this.otherInfo != null && this.otherInfo.size() == 0)
            return false;
        return true;
    }
}