package systems;

import interfaces.ISystem;

public class SystemFelix implements ISystem {

    @Override
    public double calcReliability(double[] failureRates, double t) {
        double p = 1f;
        for (double failureRate : failureRates) {
            p *= 1 - this.reliability(failureRate, t);
        }
        return 1 - p;
    }

    private double reliability(double failureRate, double t) {
        return Math.exp(- failureRate * t);
    }
}
