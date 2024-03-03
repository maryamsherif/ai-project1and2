package code;
import java.util.*;

public class State {
    private int prosperity, food, materials, energy, money_spent, TotalMoneyOwned;
    private int delayFood, delayMaterials, delayEnergy;
    private int depth;

    //enum for actions (WAIT, BUILD1, BUILD2, REQUESTFOOD, REQUESTMATERIALS, REQUESTENERGY)
    private ActionsEnum action;
    private State parent;


    //Constructor 2 that contains prosperity, food, materials, energy, money_spent
    public State(int prosperity, int food, int materials, int energy,
                 int money_spent, int TotalMoneyOwned,
                 int delayFood, int delayMaterials, int delayEnergy, int depth, ActionsEnum action, State parent) {

        this.prosperity = prosperity;
        this.food = food;
        this.materials = materials;
        this.energy = energy;
        this.money_spent = money_spent;
        this.TotalMoneyOwned = TotalMoneyOwned;
        this.delayFood = delayFood;
        this.delayMaterials = delayMaterials;
        this.delayEnergy = delayEnergy;
        this.depth = depth;
        this.action = action;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        State otherState = (State) o;
        return prosperity == otherState.prosperity &&
                food == otherState.food &&
                materials == otherState.materials &&
                energy == otherState.energy &&
                money_spent == otherState.money_spent &&
                delayFood == otherState.delayFood &&
                delayMaterials == otherState.delayMaterials &&
                delayEnergy == otherState.delayEnergy &&
                depth == otherState.depth &&
                action == otherState.action;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prosperity, food, materials, energy, money_spent, delayFood, delayMaterials, delayEnergy, depth, action);
    }

    public ActionsEnum getAction() {
        return action;
    }

    public int getProsperity() {
        return prosperity;
    }

    public int getFood() {
        return food;
    }

    public int getMaterials() {
        return materials;
    }

    public int getEnergy() {
        return energy;
    }
    public int getMoney_spent() {
        return money_spent;
    }

    public int getTotalMoneyOwned() {
        return TotalMoneyOwned;
    }

    public int getDelayFood() {
        return delayFood;
    }

    public int getDelayMaterials() {
        return delayMaterials;
    }

    public int getDelayEnergy() {
        return delayEnergy;
    }

    public int getDepth() {
        return depth;
    }

    public State getParent() {
        return parent;
    }

    //set parent
    public void setParent(State parent) {
        this.parent = parent;
    }

    //set action
    public void setAction(ActionsEnum action) {
        this.action = action;
    }

    //generate successors according to the 6 actions
    public List<State> generateSuccessors(Actions actions){
        Set<State> successors = new HashSet<>();
        List<ActionsEnum> enumVal =Arrays.asList(ActionsEnum.values());
        for (ActionsEnum action : enumVal) {
            State nextState = actions.performAction(this, action);
            if (nextState != null) {
                successors.add(nextState);
            }
        }

        if (successors.isEmpty()) {
            return null;
        }

        return new ArrayList<>(successors);
    }


    public String stateString(){
        return "State{" +
                "prosperity=" + prosperity +
                ", food=" + food +
                ", materials=" + materials +
                ", energy=" + energy +
                ", money_spent=" + money_spent +
                ", depth=" + depth +
                ", action=" + action +
                '}';
    }

    @Override
    public String toString() {
        return "State{" +
                "prosperity=" + prosperity +
                ", food=" + food +
                ", materials=" + materials +
                ", energy=" + energy +
                ", money_spent=" + money_spent +
                ", TotalMoneyOwned=" + TotalMoneyOwned +
                ", delayFood=" + delayFood +
                ", delayMaterials=" + delayMaterials +
                ", delayEnergy=" + delayEnergy +
                ", depth=" + depth +
                ", action=" + action +
                '}';
    }

}
