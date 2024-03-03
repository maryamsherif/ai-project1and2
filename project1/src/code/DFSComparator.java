package code;
import java.util.Comparator;

public class DFSComparator implements Comparator<State>{

    @Override
    public int compare(State o1, State o2) {
        if (o1.getDepth() > o2.getDepth()) {
            return -1; //state1 has higher depth, so it comes first
        } else if (o1.getDepth() < o2.getDepth()) {
            return 1; //state2 has higher depth, so it comes first
        } else {
            return 0; //both states have the same depth
        }
    }

}
