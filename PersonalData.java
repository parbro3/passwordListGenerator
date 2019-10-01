import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class PersonalData {
    private String firstName;
    private String lastName;
    private List<String> otherInfo;

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

        System.out.print("first name : " + this.firstName + " last name: " + this.lastName);

        //get the rest
        otherInfo = new ArrayList<>();
        System.out.print("Enter in other words that relate to this person. High school? Pet names? Family names? etc. Click enter when done");
        String otherIn = userInput.nextLine();
        while(!otherIn.equals("")){
            this.otherInfo.add(otherIn);
            otherIn = userInput.nextLine();
        }
    }

    public void generateCombinations(){
        //should just run a hashcat combination thing
        //maybe just do it myself

        List<String> allWords = FileWriter.readInFileToList("./wordLists/testList.txt");
        List<String> allCombinations = new ArrayList<String>();

        for(String word: allWords){
            List<String> combinationsForOneWord = appendAllToWord(word, allWords);
            allCombinations.addAll(combinationsForOneWord);
        }

        FileWriter.writeStringToFile("./wordLists/allCombinations.txt", convertListToString(allCombinations));
    }

    public String convertListToString(List<String> allWords){
        StringBuilder sb = new StringBuilder();
        for(String word: allWords){
            sb.append(word);
            sb.append("\n");
        }
        return sb.toString();
    }

    public List<String> appendAllToWord(String word, List<String> words){
        List<String> combinations = new ArrayList<String>();
        for(String oneWord : words){
            StringBuilder sb = new StringBuilder();
            sb.append(word);
            sb.append(oneWord);
            combinations.add(sb.toString());
        }
        return combinations;
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
        System.out.print("writing to personal list");
        FileWriter.writeStringToFile("./wordLists/personalList.txt", sb.toString());
    }


    public Boolean hasData() {
        if(this.firstName == null)
            return false;
        if(this.lastName == null)
            return false;
        return true;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<String> getOtherInfo() {
        return this.otherInfo;
    }

    public void setOtherInfo(List<String> otherInfo) {
        this.otherInfo = otherInfo;
    }
}