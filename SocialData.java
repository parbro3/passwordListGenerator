import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class SocialData {

    String fbUrl;
    String liUrl;

    public SocialData(){}
    public SocialData(String fbUrlIn, String liUrlIn){
        this.fbUrl = fbUrlIn;
        this.liUrl = liUrlIn;
    }

    public void generateLists(){
        List<String> params = new ArrayList<String>();
        params.add(this.fbUrl);
        params.add(this.liUrl);
        BashRunner.runProcess("./bashScripts/cewl.sh", params);
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

    public Boolean hasData() {
        if(this.fbUrl == null)
            return false;
        if(this.liUrl == null)
            return false;
        return true;
    }


}