package code;
import java.util.Comparator;

    public class AstarComparator1 implements Comparator<State> {
        @Override
        public int compare(State o1, State o2) {
            // Heuristic: Remaining prosperity needed
            int remainingProsperity1 = Math.max(0, 100 - o1.getProsperity());
            int remainingProsperity2 = Math.max(0, 100 - o2.getProsperity());

            // Estimated cost based on heuristic
            int estimatedCost1 = o1.getMoney_spent() + remainingProsperity1;
            int estimatedCost2 = o2.getMoney_spent() + remainingProsperity2;

            // Compare based on the total estimated cost
            if (estimatedCost1 < estimatedCost2) {
                return -1; // State 1 has a lower estimated cost, so it comes first
            } else if (estimatedCost1 > estimatedCost2) {
                return 1; // State 2 has a lower estimated cost, so it comes first
            } else {
                return 0; // Both states have the same estimated cost
            }
        }
    }


