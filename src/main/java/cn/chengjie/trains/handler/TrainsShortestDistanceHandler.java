package cn.chengjie.trains.handler;

import cn.chengjie.trains.core.Graph;
import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Track;
import cn.chengjie.trains.predicates.DefaultPredicate;
import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:36
 **/
public class TrainsShortestDistanceHandler extends TrainsHandler {

    public TrainsShortestDistanceHandler(List<Edge> trainsList, String start, String end) {
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .predicate(new DefaultPredicate())
                .isCycle(false)
                .build();
        this.start=start;
        this.end=end;
    }

    @Override
    public String execute() {
        try{
            List<Track> trackList=graph.listTrack(start,end);
            int minDistance=Integer.MAX_VALUE;
            for(Track track:trackList){
                minDistance=track.getPathLength()<minDistance?track.getPathLength():minDistance;
            }
            return String.valueOf(minDistance);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
