package voter;

import exceptions.VoteFailureException;
import interfaces.IVoter;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class MajorityVoter implements IVoter {


    @Override
    public double vote(double[] results) throws RuntimeException, VoteFailureException {
        Map<Double, Integer> stats = new LinkedHashMap<>();
        for (double result : results) {
            int votes = stats.getOrDefault(result, 0);
            stats.put(result, votes +1);
        }
        boolean someIdenticalResults = false;
        for (double key : stats.keySet()) {
            int votes = stats.get(key);
            if (votes >= 2) {
                someIdenticalResults = true;
            }
            if (votes > results.length / 2) {
                return key;
            }
        }

        int errorType = someIdenticalResults ? VoteFailureException.REASON_NO_MAJORITY : VoteFailureException.REASON_NO_MATCH;
        throw new VoteFailureException("No majority.", errorType);
    }
}
