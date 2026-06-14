package Task1;

import java.util.ArrayList;
import java.util.List;

public class StationNode {
    String StationName;
    String StationCode;
    String region;

    StationNode parent;
    List<StationNode> children;

    public StationNode(String stationCode, String stationName, String region) {
        StationName = stationName;
        StationCode = stationCode;
        this.region = region;

        children = new ArrayList<>();
        parent =  null;
    }

    public void addChild(StationNode child) {
        child.parent = this;
        children.add(child);
    }

    public void removeChild(StationNode child) {
        children.remove(child);
        child.parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    @Override
    public String toString() {
        return " ["+StationCode +"] "
                + StationName
                + " - "
                +region;
    }
}
