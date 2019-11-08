package cn.chengjie.trains.entity;

/**
 * 条件参数类，主要用于graph和predicate交互数据
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:25
 * @description：
 */
public class Condition {

    /**
     * 当前路径信息
     */
    Track track;

    /**
     * 距离
     */
    int distance;

    /**
     * 路径管理类
     */
    Route route;

    /**
     * 当前处理边
     */
    Edge edge;

    public Condition(Track track, int distance, Route route, Edge edge) {
        this.track = track;
        this.distance = distance;
        this.route = route;
        this.edge = edge;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }
}
