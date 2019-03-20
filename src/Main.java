import javax.swing.*;
import java.util.ArrayList;

import exceptions.VoteFailureException;
import systems.*;
import interfaces.*;
import voter.*;

public class Main {
    public static void main(String[] args){
        double t = 1;

        String s = javax.swing.JOptionPane.showInputDialog("n:");
        int n = Integer.parseInt(s);

        ArrayList<Double> failureRates = new ArrayList<>();

        String message;
        for(int i=0; i<n; i++){
            message = "Failure rate "+(i+1);
            s = javax.swing.JOptionPane.showInputDialog(message);
            failureRates.add(Double.parseDouble(s));
        }

        ISystem daniel = new SystemDaniel();
        ISystem jp = new SystemJP();
        ISystem felix = new SystemFelix();

        IVoter m = new MajorityVoter();

        Double[] fR = new Double[n];
        failureRates.toArray(fR);

        double[] results = {daniel.calcReliability(fR, t), jp.calcReliability(fR,t), felix.calcReliability(fR, t)};

        try {
            double vote = m.vote(results);
            System.out.println(vote);
        }catch (VoteFailureException VFD){
           if (VFD.getReason() == VoteFailureException.REASON_NO_MATCH){
               System.out.println("Not enough votes.");
           }else if (VFD.getReason() == VoteFailureException.REASON_NO_MAJORITY){
               System.out.println("No consensus reached.");
           }else{
               System.out.println("Unknown VoteFailureException.");
           }
        }
    }

}
