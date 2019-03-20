package exceptions;

public class VoteFailureException extends Exception{

    public final static int REASON_NO_MATCH = 0;
    public final static int REASON_NO_MAJORITY = 1;


    private int reason;

    public VoteFailureException(String message, int reason){
        super(message);
        this.reason= reason;
    }

    public int getReason() {
        return reason;
    }

}
