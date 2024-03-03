package code;
import java.util.Comparator;
public class Greedy1Comparator  implements Comparator<State> {
    @Override
    public int compare(State o1, State o2) {
        int distance1 = estimateDistanceToGoal(o1);
        int distance2 = estimateDistanceToGoal(o2);

        // Compare in ascending order based on the estimated distance to the goal
        return Integer.compare(distance1, distance2);
    }

    private int estimateDistanceToGoal(State state) {
        // Implement your heuristic to estimate the remaining distance to the goal
        return Math.max(0, 100 - state.getProsperity());

    }
    }

