package code;
import java.util.*;

public class Greedy1 {
    private Actions actions;
    private Set<State> visited= new HashSet<>();

    public Greedy1(Actions actions) {
        this.actions = actions;
    }

    public SearchResult greedySearch(State initialState) {
        Greedy1Comparator distanceHeuristic = new Greedy1Comparator();
        PriorityQueue<State> openSet = new PriorityQueue<>(distanceHeuristic);
        openSet.add(initialState);
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

            List<State> successors = currentState.generateSuccessors(actions);
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
