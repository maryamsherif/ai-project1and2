package code;

import java.util.Comparator;

    public class AstarComparator2 implements Comparator<State> {
        @Override
        public int compare(State o1, State o2) {
            // Heuristic: Resource shortages
            int resourceShortages1 = Math.max(0, Math.min(50 - o1.getFood(), Math.min(50 - o1.getMaterials(), 50 - o1.getEnergy())));
            int resourceShortages2 = Math.max(0, Math.min(50 - o2.getFood(), Math.min(50 - o2.getMaterials(), 50 - o2.getEnergy())));

            // Estimated cost based on heuristic
            int estimatedCost1 = o1.getMoney_spent() + resourceShortages1;
            int estimatedCost2 = o2.getMoney_spent() + resourceShortages2;

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





