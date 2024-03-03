package code;
import java.util.Comparator;

    public class Greedy2Comparator implements Comparator<State> {
        @Override
        public int compare(State o1, State o2) {
            double ratio1 = (double) o1.getProsperity() / o1.getMoney_spent();
            double ratio2 = (double) o2.getProsperity() / o2.getMoney_spent();

            // Compare in descending order based on the prosperity-to-cost ratio
            return Double.compare(ratio2, ratio1);
        }
    }


