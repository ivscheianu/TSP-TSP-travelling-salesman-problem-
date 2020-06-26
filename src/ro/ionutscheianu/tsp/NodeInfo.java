package ro.ionutscheianu.tsp;

import java.util.Objects;

public class NodeInfo {

    private Integer nodeNumber;
    private Integer cost;

    public NodeInfo(Integer nodeNumber, Integer cost) {
        this.nodeNumber = nodeNumber;
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeInfo nodeInfo = (NodeInfo) o;
        return Objects.equals(nodeNumber, nodeInfo.nodeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeNumber, cost);
    }

    @Override
    public String toString() {
        return nodeNumber.toString() + ":" + cost.toString();
    }

    public Integer getNodeNumber() {
        return nodeNumber;
    }

    public void setNodeNumber(Integer nodeNumber) {
        this.nodeNumber = nodeNumber;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


}
