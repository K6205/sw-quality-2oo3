package systems;

import interfaces.ISystem;

public class SystemDaniel implements ISystem {

    @Override
    public double calcReliability(double[] failureRates, double t){

        double tempRes = 1;

        for(double failureRate : failureRates){
            tempRes *= 1 - (Math.exp(-failureRate*t));
        }

        return (1 - tempRes);
    }
}
