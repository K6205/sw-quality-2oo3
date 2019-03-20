package voter;

import interfaces.IVoter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityVoter implements IVoter {


    @Override
    public double vote(double[] results) throws RuntimeException {
        Map<Double, Integer> stats = new LinkedHashMap<>();
        for (double result : results) {
            int votes = stats.getOrDefault(result, 0);
            stats.put(result, votes +1);
        }
        for (double key : stats.keySet()) {
            int votes = stats.get(key);
            if (votes > results.length / 2) {
                return key;
            }
        }
        throw new RuntimeException("No majority.");
    }
}
