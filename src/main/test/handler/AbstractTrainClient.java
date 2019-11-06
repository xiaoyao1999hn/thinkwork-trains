package cn.chengjie.trains.handler;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 22:50
 * @description：
 */
public interface AbstractTrainClient {
    /**
     * 获取路径距离总数
     * @param stationList
     * @return
     */
    int getDistance(List<String> stationList);

    /**
     * 获取最短路径
     * @param startStation  起始站
     * @param endStation    结束站
     * @return
     */
    int getShortestDistance(String startStation,String endStation);

    /**
     *  获取路径条数
     * @param startStation  起始站
     * @param endStation    结束站
     * @return
     */
    int getRouteCount(String startStation,String endStation);

    /**
     * 设置路径长度代理类
     * @param distanceHandler
     */
    void setDistanceHandler(AbstractDistanceHandler distanceHandler);

    /**
     * 设置路径数量代理类
     * @param routeHandler
     */
    void setRouteHandler(RouteHandler routeHandler);
}
