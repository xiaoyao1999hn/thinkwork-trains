package cn.chengjie.trains.domain;

/**
 * 边信息
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 9:42
 * @description：
 */
public class Edge {

    /**
     * 起始节点
     */
    String startV;

    /**
     * 结束节点
     */
    String endV;

    /**
     * 路径长度
     */
    int distance;

    public Edge(String startV,String endV,int distance){
        this.startV=startV;
        this.endV=endV;
        this.distance=distance;
    }

    public String getStartV() {
        return startV;
    }

    public void setStartV(String startV) {
        this.startV = startV;
    }

    public String getEndV() {
        return endV;
    }

    public void setEndV(String endV) {
        this.endV = endV;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
