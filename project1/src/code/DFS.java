package code;
import java.util.*;
public class DFS extends DFSComparator {
    private Actions actions;
    private Set<State> visited= new HashSet<>();

    public DFS(Actions actions) {
        super();
        this.actions = actions;
    }

    public SearchResult dfsSearch(State initialState) {
        // Change PriorityQueue to Stack
        Stack<State> openSet = new Stack<>();
        openSet.push(initialState);

        List<ActionsEnum> plan = new ArrayList<>();
        // State String
        List<String> statesString = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;

        while (!openSet.isEmpty()) {
            State currentState = openSet.pop(); // Change poll to pop for Stack
            nodesExpanded++;

            // Check if the current state is the goal state.
            if (currentState.getProsperity() >= 100) {
                // Goal state found.
                monetaryCost = currentState.getMoney_spent();
                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(currentState.getAction());
                    currentState = currentState.getParent();
                }
                //reverse the plan
                Collections.reverse(plan);
                return new SearchResult(plan, monetaryCost, nodesExpanded, statesString); // Goal state found.
            }
            visited.add(currentState);

            // Expand and add unvisited successors to the openSet.
            List<State> successors = null;
            if (currentState.getProsperity() < 100) {
                successors = currentState.generateSuccessors(actions);
            }
            if (successors != null) {
                for (State successor : successors) {
                    if (!visited.contains(successor) && !openSet.contains(successor)) {
                        openSet.push(successor);
                        successor.setParent(currentState);
                        successor.setAction(successor.getAction());
                    }
                }
            }
        }

        return null;
    }
}
