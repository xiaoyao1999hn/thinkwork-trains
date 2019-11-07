package cn.chengjie.trains.handler;

import cn.chengjie.trains.core.Graph;
import cn.chengjie.trains.entity.Edge;
import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:03
 **/
public class TrainsDistanceHandler implements Handler {

    Graph graph;

    List<String> stationList;

    public TrainsDistanceHandler(List<Edge> trainsList,List<String> stationList){
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .isCycle(false)
                .build();
        this.stationList=stationList;
    }

    @Override
    public String execute() {
        try{
            List<Edge> list=graph.showRoute(this.stationList);
            int distance=0;
            for(Edge edge:list){
                distance+=edge.getDistance();
            }
            return String.valueOf(distance);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
