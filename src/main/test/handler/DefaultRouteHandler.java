package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Edge;
import cn.chengjie.trains.domain.Route;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/31 8:38
 * @description：
 */
public class DefaultRouteHandler extends AbstractRouteHandler {

    public DefaultRouteHandler(List<Edge> stationList) {
        super(stationList);
    }

    public DefaultRouteHandler(List<Edge> stationList, int maxStopNum) {
        super(stationList, maxStopNum);
    }

    public DefaultRouteHandler(List<Edge> stationList, int maxStopNum, boolean isCycle) {
        super(stationList, maxStopNum, isCycle);
    }

    @Override
    public int getRouteCount(String startStation, String endStation) {
        initRoute(startStation,endStation,route);
        return route.getTracks().size();
    }

    @Override
    public List<List<String>> getTracks(String startStation, String endStation) {
        initRoute(startStation,endStation,route);
        return route.getTracks();
    }

    @Override
    public int getShortestDistance(String startStation, String endStation) {
        initRoute(startStation,endStation,route);
        route.getTracks();
        return 0;
    }
}
