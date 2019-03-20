import javax.swing.*;
import java.util.ArrayList;

import exceptions.VoteFailureException;
import systems.*;
import interfaces.*;
import voter.*;

public class Main {
    public static void main(String[] args) {
       double[] fR = new double[]{ 0.5, 0.43, 0.18 };
        ISystem daniel = new SystemDaniel();
        ISystem jp = new SystemJP();
        ISystem felix = new SystemFelix();

        IVoter m = new MajorityVoter();
        double t = 1.0;
        double[] r = {daniel.calcReliability(fR, t), jp.calcReliability(fR,t), felix.calcReliability(fR, t)};
        double res = -1;
        try {
            res = m.vote(r);
        }catch (VoteFailureException VFD){
            //do something
        }
        System.out.println(res);
    }

}
