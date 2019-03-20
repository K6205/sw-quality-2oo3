package systems;

import interfaces.ISystem;

import java.util.ArrayList;

public class SystemJP implements ISystem {

    @Override
    public double calcReliability(Double[] failureRates, double t) {
        ArrayList<Double> reliabilities = new ArrayList<>();
        for (double failureRate : failureRates) {
            reliabilities.add(calcComponentReliability(failureRate, t));
        }

        double total = 1;
        for (double reliability : reliabilities) {
            total *= (1 - reliability);
        }
        return 1-total;
    }

    private double calcComponentReliability(double failureRate, double t){
        return Math.exp(-failureRate*t);
    }
}
