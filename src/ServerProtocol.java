/**
 * Created by cyonkee on 4/2/17.
 */

public class ServerProtocol {
    private static final int WAITING = 0;
    private static final int SENTWELCOME = 1;
    private static final int SENTCONFIRMATION = 2;
    private static final int SENTPREPARE = 3;
    private final String tournamentpassword = "password";
    private final String username = "groupc";
    private final String password = "password";
    private static int pid;
    private boolean isAuthenticationProtocol = true;
    private boolean isChallengeProtocol = false;
    private boolean isRoundProtocol = false;
    private boolean isMatchProtocol = false;
    private boolean isMoveProtocol = false;

    private int state = WAITING;

    public String processInput(String theInput) {
        if(isAuthenticationProtocol) {
            return authenticationProtocol(theInput);
        }
        else if (isChallengeProtocol && !isRoundProtocol){
            return challengeProtocol(theInput);
        }
        else return null;
    }

    private String authenticationProtocol(String theInput) {
        String theOutput = null;
        if (state == WAITING) {
            theOutput = "WELCOME TO ANOTHER EDITION OF THUNDERDOME!";
            state = SENTWELCOME;
        } else if (state == SENTWELCOME) {
            if (theInput.equalsIgnoreCase("ENTER THUNDERDOME " + tournamentpassword)) {
                theOutput = "TWO SHALL ENTER, ONE SHALL LEAVE";
                state = SENTCONFIRMATION;
            } else {
                theOutput = "INCORRECT PASSWORD!";
                state = WAITING;
            }
        } else if (state == SENTCONFIRMATION) {
            if (theInput.equalsIgnoreCase("I AM " + username + " " + password)) {
                if(username == "groupc"){
                    pid = 1;
                }
                theOutput = "WAIT FOR THE TOURNAMENT TO BEGIN " + pid;
                state = SENTPREPARE;
                isAuthenticationProtocol = false;
                isChallengeProtocol = true;
            } else {
                theOutput = "INCORRECT PASSWORD!";
                state = WAITING;
            }
        }
        return theOutput;
    }

    private String challengeProtocol(String theInput){
        String theOutput = null;
        return theOutput;
    }
}
