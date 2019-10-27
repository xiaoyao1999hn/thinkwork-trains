package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Edge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 21:42
 * @description：
 */
public class DistanceHandler {

    Map<String, List<Edge>> trainsMap;

    public void init(List<Edge> nodeList) {
        trainsMap = new HashMap<>();

    }

    public int getDistance(List<String> nodeList) {
        int distance = 0;
        String startNode = nodeList.get(0);
        nodeList.remove(startNode);
        int count = 0;
        for (String node : nodeList) {
            List<Edge> edges = trainsMap.get(node);
            for (Edge edge : edges) {
                count++;
                if (edge.getEndV().equals(node)) {
                    distance += edge.getDistance();
                    break;
                }
            }
            if (count == edges.size()) {
                return 0;
            }
        }
        return distance;
    }

}
