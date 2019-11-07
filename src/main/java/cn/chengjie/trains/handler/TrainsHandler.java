package cn.chengjie.trains.handler;

import cn.chengjie.trains.core.Graph;
import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.predicates.StopPredicate;

import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:23
 **/
public abstract class TrainsHandler implements Handler {

    Graph graph;

    String start;

    String end;

    public TrainsHandler(){
    }
    public TrainsHandler(List<Edge> trainsList, String start, String end, int maxStop){
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .predicate(new StopPredicate(maxStop))
                .isCycle(false)
                .build();
        this.start=start;
        this.end=end;
    }

    public TrainsHandler(List<Edge> trainsList, String start, String end, int maxStop, boolean isCycle){
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .predicate(new StopPredicate(maxStop))
                .isCycle(isCycle)
                .build();
        this.start=start;
        this.end=end;
    }

    @Override
    public abstract String execute();
}
