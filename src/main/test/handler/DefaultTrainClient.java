package cn.chengjie.trains.handler;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 22:53
 * @description：
 */
public class DefaultTrainClient implements AbstractTrainClient {

    AbstractDistanceHandler distanceHandler;

    RouteHandler routeHandler;

    @Override
    public int getDistance(List<String> places) {
        return distanceHandler.getDistance(places);
    }

    @Override
    public int getShortestDistance(String startStation, String endStation) {
        return routeHandler.getShortestDistance(startStation,endStation);
    }

    @Override
    public int getRouteCount(String startStation, String endStation) {
        return routeHandler.getRouteCount(startStation,endStation);
    }

    public AbstractDistanceHandler getDistanceHandler() {
        return distanceHandler;
    }

    @Override
    public void setDistanceHandler(AbstractDistanceHandler distanceHandler) {
        this.distanceHandler = distanceHandler;
    }

    public RouteHandler getRouteHandler() {
        return routeHandler;
    }

    @Override
    public void setRouteHandler(RouteHandler routeHandler) {
        this.routeHandler = routeHandler;
    }
}
