public class DataChecker {

    public static Boolean checkInput(String input){
        //they didn't put anything
        if(input.length() == 0)
            return true;

        //they put something that is not a url
        if(input.length() < 10)
            return false;

        return true;
    }

}