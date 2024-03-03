package code;
import java.util.ArrayList;
import java.util.Objects;

public class Node {

    private State state ;
    private String action;
    private Node parent;
    private int cost;
    private int depth;


    public Node(State initialState, String action, Object parentNode, int cost, int depth) {
        this.state = initialState;
        this.action = action;
        this.parent = (Node) parentNode;
        this.cost = cost;
        this.depth = depth;
    }
    //getter and setter methods
    public State getState() {
        return state;
    }

    public int getDepth() {
        return depth;
    }

    public int getCost() {
        return cost;
    }

    public Node getParent() {
        return parent;
    }

    public String getAction() {
        return action;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public void setAction(String action) {
        this.action = action;
    }

}

