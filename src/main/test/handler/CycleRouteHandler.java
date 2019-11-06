package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Edge;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 23:45
 * @description：
 */
public class CycleRouteHandler extends AbstractRouteHandler {


    public CycleRouteHandler(List<Edge> stationList) {
        super(stationList);
    }

    public CycleRouteHandler(List<Edge> stationList, int maxStopNum) {
        super(stationList, maxStopNum);
    }

    public CycleRouteHandler(List<Edge> stationList, int maxStopNum, boolean isCycle) {
        super(stationList, maxStopNum, isCycle);
    }

    @Override
    public int getRouteCount(String startStation, String endStation) {
        return 0;
    }

    @Override
    public List<List<String>> getTracks(String startStation, String endStation) {
        return null;
    }

    @Override
    public int getShortestDistance(String startStation, String endStation) {
        return 0;
    }
}
