package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Edge;
import cn.chengjie.trains.domain.Route;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 23:42
 * @description：
 */
public abstract class AbstractRouteHandler implements  RouteHandler{

    List<Edge> stationList;

    int maxStopNum;

    boolean isCycle;

    Route route =new Route();


    public AbstractRouteHandler(List<Edge> stationList){
        this.stationList=stationList;
        this.maxStopNum=-1;
        this.isCycle=false;
    }

    public AbstractRouteHandler(List<Edge> stationList, int maxStopNum){
        this.stationList=stationList;
        this.maxStopNum=maxStopNum;
        this.isCycle=false;
    }

    public AbstractRouteHandler(List<Edge> stationList, int maxStopNum, boolean isCycle){
        this.stationList=stationList;
        this.maxStopNum=maxStopNum;
        this.isCycle=isCycle;
    }

    @Override
    public abstract int getRouteCount(String startStation, String endStation);

    @Override
    public abstract int getShortestDistance(String startStation, String endStation);


    public  void initRoute(String startV, String endV, Route route){
        if (route.getStations().indexOf(startV) > -1) {
            return;
        }
        for (int i = 0; i < stationList.size(); i++) {
            Edge node = stationList.get(i);
            if (node.getStartV().equals(startV)) {
                //如果相等则找到路径
                if (node.getEndV().equals(endV)) {
                    route.addStation(node.getStartV());
                    route.addStation(node.getEndV());
                    System.out.println("find path:" + route.toString() + "\n");
                    route.addTracks(route.getStations());
                    route.getStations().clear();
                    return;
                }
                route.addStation(node.getStartV());
                initRoute(node.getEndV(), endV, route);
            }
        }
    }
}
