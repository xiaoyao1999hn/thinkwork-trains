package cn.chengjie.trains.handler;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 22:55
 * @description：
 */
public interface AbstractDistanceHandler {

    /**
     * 获取路径长度
     * @param stationList
     * @return
     */
    int getDistance(List<String> stationList);
}
