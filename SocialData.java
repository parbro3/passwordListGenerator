import java.util.Scanner;

public class SocialData {

    String fbUrl;
    String liUrl;

    public SocialData(){}
    public SocialData(String fbUrlIn, String liUrlIn){
        this.fbUrl = fbUrlIn;
        this.liUrl = liUrlIn;
    }

    public void retrieveSocial(){
        Scanner userInput = new Scanner(System.in);

        //get fb
        System.out.print("What is this person's Facebook URL? If not, then just hit enter.");
        String fbUrlIn = userInput.nextLine();
        if(DataChecker.checkInput(fbUrlIn))
            this.fbUrl = fbUrlIn;

        System.out.print("What is this person's LinkedIn URL? If not, then just hit enter.");
        String liUrlIn = userInput.nextLine();
        if(DataChecker.checkInput(liUrlIn))
            this.liUrl = liUrlIn;

        userInput.close();
    }


}