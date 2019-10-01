import java.util.Scanner;
import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.List;

public class Generator {

    SocialData socialData;
    PersonalData personalData;

    public Generator(){
        personalData = new PersonalData();
        personalData.retrievePersonal();

        socialData = new SocialData();
        socialData.retrieveSocial();
    }

    public void generateAll(){
        //write personal data to file
        if(this.personalData.hasData()) {
            this.personalData.writePersonal();
            //this is working well!!
            this.personalData.generateCombinations();
        }

        /*
        //run cewl on social URLs
        if(this.socialData.hasData()){
            this.socialData.generateLists();
        }

        //generate permutations
        this.generatePermutations();
        */

    }

    public void generatePermutations() {
        List<String> params = new ArrayList<String>();
        BashRunner.runProcess("./bashScripts/socialPermutate.sh", params);
    }

}

/*
    Ask all these questions to get information.. fb url and li url.
    The goal is to pass these in as arguments... so i shouldn't have to write them to a file at all
    That would be dumb.

    Set them as command line arguments.
    Looks like I'm about to do some bash scripting.

    wait I do have to write the personal words word list to a file!!!


    Steps to run:
    1. Write personal words to a file called personalWords.txt
    2. Run a hashcat concatenate thing on personalWords.txt
    3. Run a cewl and pass in the facebook url.
    4. Run a cewl and pass in the linkedIn url.
    5. Run a permutation on each of them separately.
    6. Compile all files into one.

*/