package code;

import java.util.Comparator;

public class UCSComparator implements Comparator<State> {

    @Override
    public int compare(State o1, State o2) {
        // Compare based on total money spent
        if (o1.getMoney_spent() < o2.getMoney_spent()) {
            return -1; // State 1 has lower cost, so it comes first
        } else if (o1.getMoney_spent() > o2.getMoney_spent()) {
            return 1; // State 2 has lower cost, so it comes first
        } else {
            return 0; // Both states have the same cost
        }
    }
}
