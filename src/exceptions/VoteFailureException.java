package exceptions;

public class VoteFailureException extends Exception{

    private int reason;

    public VoteFailureException(String message, int reason){
        super(message);
        this.reason= reason;
    }

    public int getReason() {
        return reason;
    }

}
