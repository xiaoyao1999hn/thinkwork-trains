package cn.chengjie.trains.utils;

import cn.chengjie.trains.domain.Edge;
import cn.chengjie.trains.domain.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 21:43
 * @description：
 */
public class TrainsUtil {

    public static void findPath(List<Edge> edges, String startV, String endV, Route route) {
        if (route.getVertices().indexOf(startV) > -1) {
            return;
        }
        for (int i = 0; i < edges.size(); i++) {
            Edge node = edges.get(i);
            if (node.getStartV().equals(startV)) {
                //如果相等则找到路径
                if (node.getEndV().equals(endV)) {
                    route.addVertex(node.getStartV());
                    route.addVertex(node.getEndV());
                    System.out.println("find path:" + route.toString() + "\n");
                    route.addTracks(route.getVertices());
                    route.getVertices().clear();
                    return;
                }
                route.addVertex(node.getStartV());
                findPath(edges, node.getEndV(), endV, route);
            }
        }
    }


    public int getDistance(Map<String, List<Edge>> trainsMap, List<String> nodeList) {
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

    public static void main(String[] args) {

        List<Edge> nodeList = new ArrayList<>();
        Edge node1 = new Edge("A", "B", 5);
        Edge node2 = new Edge("B", "C", 4);
        Edge node3 = new Edge("C", "D", 8);
        Edge node4 = new Edge("D", "C", 8);
        Edge node5 = new Edge("D", "E", 6);
        Edge node6 = new Edge("A", "D", 5);
        Edge node7 = new Edge("C", "E", 2);
        Edge node8 = new Edge("E", "B", 3);
        Edge node9 = new Edge("A", "E", 7);
        nodeList.add(node1);
        nodeList.add(node2);
        nodeList.add(node3);
        nodeList.add(node4);
        nodeList.add(node5);
        nodeList.add(node6);
        nodeList.add(node7);
        nodeList.add(node8);
        nodeList.add(node9);
        Route route = new Route();

        findPath(nodeList, "A", "D", route);

        Map<String,List<Edge>> map =new HashMap<>();
        nodeList.forEach(x->{
            List<Edge> edges= map.get(x.getStartV());
            if (edges==null||edges.size()==0){
                edges=new ArrayList<>();
            }
            edges.add(x);
            map.put(x.getStartV(),edges);
        });
        System.out.print(route.getTracks().size());
    }
}
