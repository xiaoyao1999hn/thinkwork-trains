package cn.chengjie.trains.core;

import cn.chengjie.trains.entity.Condition;
import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Route;
import cn.chengjie.trains.entity.Track;
import cn.chengjie.trains.predicates.Predicate;

import java.util.*;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:35
 **/
public class Graph {

    private Map<String, List<Edge>> trainsGraph;

    private Predicate predicate;

    private int stopCount;

    private int maxDistance;

    private  boolean isCycle;

    public Graph(Builder builder) {
        this.predicate=builder.predicate;
        this.stopCount=builder.stopCount;
        this.maxDistance=builder.maxDistance;
        this.isCycle=builder.isCycle;
        trainsGraph = new HashMap<>();
        builder.trainsList.forEach(x -> {
            List<Edge> temp = Optional.ofNullable(trainsGraph.get(x.getStart())).orElse(new LinkedList<Edge>());
            temp.add(x);
            trainsGraph.put(x.getStart(), temp);
        });
    }

    //A,B
    public List<Track> listTrack(String start, String end) {
        Route route = new Route(start);
        Optional.ofNullable(trainsGraph.get(start)).orElseThrow(() -> new RuntimeException("NO ROUTE")).forEach(x -> {
            Track track = new Track(start);
            track.getPath().append(x.getEnd());
            track.setPathLength(x.getDistance());
            traverseGraph(route, track, x.getEnd(), end);
        });
        return route.getTrackList();
    }

    //AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
    //A,C, AB&AD&AE    BC   CD&CE    DC   EB

    public void traverseGraph(Route route, Track currentTrack, String start, String end) {
        //先保存现场,用于后续递归时还原现场
        Track temp = currentTrack.clone();
        List<Edge> trainsPath = trainsGraph.get(start);
        for (Edge edge : trainsPath) {
            //是否循环之前走过的路径
            if (edge.getEnd().equals(route.getStart())&&!isCycle) {
                currentTrack.add(edge);
                route.getTrackList().add(currentTrack.clone());
                currentTrack=temp;
                continue;
            }
            //校验是否继续往下找
            if(predicate.test(new Condition(currentTrack,
                    stopCount,(currentTrack.getPathLength() + edge.getDistance()),
                    maxDistance,route,edge))){
                continue;
            }
            currentTrack.add(edge);
            //找到目标节点加入队列
            if (edge.getEnd().equals(end)) {
                route.getTrackList().add(currentTrack.clone());
            }
            traverseGraph(route, currentTrack, edge.getEnd(), end);
            //遍历完毕之后还原现场
            currentTrack = temp;
        }
    }


    public  static  class Builder{
        private List<Edge> trainsList;

        private Predicate predicate;

        private int stopCount;

        private int maxDistance;

        private boolean isCycle;

        public Builder trainsList(List<Edge> trainsList){
            this.trainsList=trainsList;
            return this;
        }

        public Builder predicate(Predicate predicate){
            this.predicate=predicate;
            return this;
        }
        public Builder stopCount(int stopCount){
            this.stopCount=stopCount;
            return this;
        }

        public Builder maxDistance(int maxDistance){
            this.maxDistance=maxDistance;
            return this;
        }

        public Builder isCycle(boolean isCycle){
            this.isCycle=isCycle;
            return this;
        }

        public Graph build(){
            return new Graph(this);
        }
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public void setMaxDistance(int maxDistance) {
        this.maxDistance = maxDistance;
    }

    public void setCycle(boolean cycle) {
        isCycle = cycle;
    }


//    public int showRouteDistance(List<String> stationList) {
//        Distance distance = new Distance();
//        distance.setWeight(0);
//        int index=0;
//        int temp =0;
//        while(index<stationList.size()-1){
//            temp=distance.getWeight();
//            String startNode=stationList.get(index);
//            String endNode=stationList.get(++index);
//            List<Edge> edges = trainsMap.get(startNode);
//            edges.stream().filter(x->x.getEndV().equals(endNode)).findFirst().ifPresent(x->distance.setWeight(distance.getWeight()+x.getDistance()));
//            if(temp==distance.getWeight()){
//                return -1;
//            }
//        }
//        return distance.getWeight();
//    }
}
