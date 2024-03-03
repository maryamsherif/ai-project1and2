package code;
import java.util.*;

//h(n) guides the search towards states that provide a higher prosperity relative to the cost incurred.
// It aims to strike a balance between reaching a high level of prosperity and minimizing the cost spent to get there.

public class Greedy2 {
    private Actions actions;

    public Greedy2(Actions actions) {
        this.actions = actions;
    }

    public SearchResult greedySearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new Greedy2Comparator());
        openSet.add(initialState);
        Set<State> visited = new HashSet<>();
        List<ActionsEnum> plan = new ArrayList<>();
        //State String
        List<String> statesString = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;

        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            nodesExpanded++;

            if (currentState.getProsperity() >= 100) {
                // Goal state found.
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(currentState.getAction());
                    currentState = currentState.getParent();
                }
                Collections.reverse(plan);
                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString);
            }
            visited.add(currentState);

            List<State> successors = null;
            if (currentState.getProsperity() < 100) {
                successors = currentState.generateSuccessors(actions);
            }
            if (successors != null) {
                for (State successor : successors) {
                    if (!visited.contains(successor) && !openSet.contains(successor)) {
                        openSet.add(successor);
                        successor.setParent(currentState);
                        successor.setAction(successor.getAction());
                    }
                }
        }
    }

        return null;
    }
}
