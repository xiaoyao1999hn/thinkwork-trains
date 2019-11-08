package cn.chengjie.trains.entity;

/**
 * 图中的边
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:32
 **/
public class Edge {

    /**
     * 开始节点
     */
    String start;

    /**
     * 结束节点
     */
    String end;

    /**
     * 两点之间的直接距离
     */
    int distance;

    public Edge(String start, String end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
