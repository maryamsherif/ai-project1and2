package code;
import java.util.*;

public class AStar1 {
    private Actions actions;
    private Set<State> visited= new HashSet<>();

    public AStar1(Actions actions) {
        this.actions = actions;
    }

    public SearchResult aStarSearch(State initialState) {
        PriorityQueue<State> openSet = new PriorityQueue<>(new AstarComparator1());
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

            List<State> successors = null;
            if (currentState.getProsperity() < 100) {
                successors = currentState.generateSuccessors(actions);
            }
            if (successors!=null){
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