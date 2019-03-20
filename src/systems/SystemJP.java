package systems;

import interfaces.ISystem;

public class SystemJP implements ISystem {

    @Override
    public double calcReliability(double[] failureRates, double t) {
        double product = 1.0;
        for(int i = 0; i <= failureRates.length; i++){
            product *= 1-(Math.exp(-1*failureRates[0]*t));
        }
        return (1 - product);
    }
}
