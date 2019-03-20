package interfaces;

public class VoteFailException extends Exception{

    private int reason;

    public VoteFailException(String message, int reason){
        super(message);
        this.reason= reason;
    }

    public int getReason() {
        return reason;
    }

}
