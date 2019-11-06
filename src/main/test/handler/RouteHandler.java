package cn.chengjie.trains.handler;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 22:55
 * @description：
 */
public interface RouteHandler {

    /**
     *  获取路径条数
     * @param startStation  起始站
     * @param endStation    结束站
     * @return
     */
    int getRouteCount(String startStation,String endStation);

    /**
     *  获取路径明细
     * @param startStation  起始站
     * @param endStation    结束站
     * @return
     */
    List<List<String>> getTracks(String startStation, String endStation);


    /**
     * 获取最短路径
     * @param startStation  起始站
     * @param endStation    结束站
     * @return
     */
    int getShortestDistance(String startStation,String endStation);
}
