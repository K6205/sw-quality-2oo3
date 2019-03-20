package interfaces;

import exceptions.VoteFailureException;

public interface IVoter {

    /**
     *
     * @param results 3 results from 3 ISystems
     * @return result based on 2/3 vote
     * @throws RuntimeException if not 3 elements in result or 2/3 vote fails
     */
    double vote(double[] results) throws RuntimeException, VoteFailureException;
}
