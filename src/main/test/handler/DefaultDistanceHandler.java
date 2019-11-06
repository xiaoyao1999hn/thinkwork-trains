package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Distance;
import cn.chengjie.trains.domain.Edge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/30 23:40
 * @description：
 */
public class DefaultDistanceHandler implements AbstractDistanceHandler {

    Map<String, List<Edge>> trainsMap;

    public DefaultDistanceHandler(List<Edge> stationList){
        trainsMap = new HashMap<>();
        for(Edge station:stationList){
            List<Edge> edges=trainsMap.get(station.getStartV());
            if(edges==null){
                edges=new ArrayList<>();
            }
            edges.add(station);
            trainsMap.put(station.getStartV(),edges);
        }
    }

    @Override
    public int getDistance(List<String> stationList) {
        Distance distance = new Distance();
        distance.setWeight(0);
        int index=0;
        int temp =0;
        while(index<stationList.size()-1){
            temp=distance.getWeight();
            String startNode=stationList.get(index);
            String endNode=stationList.get(++index);
            List<Edge> edges = trainsMap.get(startNode);
            edges.stream().filter(x->x.getEndV().equals(endNode)).findFirst().ifPresent(x->distance.setWeight(distance.getWeight()+x.getDistance()));
            if(temp==distance.getWeight()){
                return -1;
            }
        }
        return distance.getWeight();
    }
}
