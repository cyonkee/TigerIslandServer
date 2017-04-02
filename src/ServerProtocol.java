/**
 * Created by cyonkee on 4/2/17.
 */

public class ServerProtocol {
    private static final int WAITING = 0;
    private static final int SENTWELCOME = 1;
    private static final int SENTCONFIRMATION = 2;
    private static final int SENTPREPARE = 3;
    //private static final String tournamentPassword = "password";

   //private static final int NUMJOKES = 5;

    private int state = WAITING;
    //private int currentJoke = 0;

//    private String[] clues = { "Turnip", "Little Old Lady", "Atch", "Who", "Who" };
//    private String[] answers = { "Turnip the heat, it's cold in here!",
//            "I didn't know you could yodel!",
//            "Bless you!",
//            "Is there an owl in here?",
//            "Is there an echo in here?" };

    public String processInput(String theInput) {
        return authenticationProtocol(theInput);
    }

    private String authenticationProtocol(String theInput) {
        String theOutput = null;
        if (state == WAITING) {
            theOutput = "WELCOME TO ANOTHER EDITION OF THUNDERDOME!";
            state = SENTWELCOME;
        } else if (state == SENTWELCOME) {
            if (theInput.equalsIgnoreCase("ENTER THUNDERDOME password")) {
                theOutput = "TWO SHALL ENTER, ONE SHALL LEAVE";
                state = SENTCONFIRMATION;
            } else {
                theOutput = "INCORRECT PASSWORD!";
                state = WAITING;
            }
        } else if (state == SENTCONFIRMATION) {
            if (theInput.equalsIgnoreCase("I AM groupc password")) {
                theOutput = "WAIT FOR THE TOURNAMENT TO BEGIN groupc";
                state = SENTPREPARE;
            } else {
                theOutput = "INCORRECT PASSWORD!";
                state = WAITING;
            }
        }
        return theOutput;
    }
}
