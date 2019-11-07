package cn.chengjie.trains.handler;

import cn.chengjie.trains.core.Graph;
import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Track;
import cn.chengjie.trains.predicates.DistancePredicate;

import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:51
 **/
public class TrainsMaxDistanceHandler extends TrainsHandler {

    public TrainsMaxDistanceHandler(List<Edge> trainsList, String start, String end,int maxDistance) {
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .predicate(new DistancePredicate(maxDistance))
                .isCycle(true)
                .build();
        this.start=start;
        this.end=end;
    }

    @Override
    public String execute() {
        try{
            List<Track> trackList=graph.listTrack(start,end);
            return String.valueOf(trackList.size());
        }catch (Exception e){
           return e.getMessage();
        }
    }
}
