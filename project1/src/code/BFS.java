package code;
import java.util.*;

public class BFS extends BFSComparator {
        private Actions actions;
        private Set<State> visited= new HashSet<>();

    public BFS(Actions actions) {
        super();
        this.actions = actions;
    }


    public SearchResult bfsSearch(State initialState) {
        // Create a priority queue with the BFSComparator.
        PriorityQueue<State> openSet = new PriorityQueue<>(new BFSComparator());
        openSet.add(initialState);
        List<ActionsEnum> plan = new ArrayList<>();
        //State String
        List<String> statesString = new ArrayList<>();

        int monetaryCost = 0;
        int nodesExpanded = 0;


        while (!openSet.isEmpty()) {
            State currentState = openSet.poll();
            nodesExpanded++;

            // Check if the current state is the goal state.
            if (currentState.getProsperity() >= 100) {
                //Goal state found.
                monetaryCost = currentState.getMoney_spent();

                while (currentState != null) {
                    statesString.add(currentState.toString());
                    plan.add(currentState.getAction()); // Add action at the beginning of the list.
                    currentState = currentState.getParent();
                }
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

