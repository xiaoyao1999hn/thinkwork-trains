package cn.chengjie.trains.entity;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:25
 * @description：
 */
public class Condition {

    Track track;

    int distance;

    Route route;

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
