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

    Map<String, List<Edge>> trainsGraph;

    Predicate predicate;

    int stopCount;

    int maxDistance;


    public Graph(List<Edge> list) {
        trainsGraph = new HashMap<>();
        list.forEach(x -> {
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
        //先保存现场
        Track temp = currentTrack.clone();
        System.out.println("保存现场: " + temp.getPath());
        List<Edge> trainsPath = trainsGraph.get(start);
        System.out.println("当前路径: " + currentTrack.getPath() + "，start：" + start);
        for (Edge edge : trainsPath) {
            //第6题
//            if (currentTrack.getPath().length()>4) {
//                continue;
//            }
            //第7题
//            if(currentTrack.getPath().length()>5){
//                continue;
//            }

            //第10题的条件
//            if ((currentTrack.getPathLength() + edge.getDistance()) > 30) {
//                continue;
//            }

            //第8,9题
            if (edge.getEnd().equals(route.getStart())) {
                currentTrack.getPath().append(edge.getEnd());
                route.getTrackList().add(currentTrack.clone());
                System.out.println("满足条件加入队列: 【" + currentTrack.getPath() + "】");
                currentTrack=temp;
                System.out.println("恢复现场: " + currentTrack.getPath());
                continue;
            }
            if (currentTrack.getPath().indexOf(edge.getEnd()) > -1 && currentTrack.getPath().length() > 2) {
                System.out.println("条件不满足跳出: " + currentTrack.getPath() + "，start：" + edge.getStart() + " ，end：" + edge.getEnd());
                continue;
            }
//            if(predicate.test(new Condition(currentTrack,
//                    stopCount,(currentTrack.getPathLength() + edge.getDistance()),
//                    maxDistance,route,edge))){
//                continue;
//            }

            currentTrack.add(edge);
            //找到目标节点退出,没找到则递归继续找
            if (edge.getEnd().equals(end)) {
                route.getTrackList().add(currentTrack.clone());
                System.out.println("满足条件加入队列: 【" + currentTrack.getPath() + "】");
            }
            traverseGraph(route, currentTrack, edge.getEnd(), end);
            //遍历完毕之后还原现场
            currentTrack = temp;
            System.out.println("恢复现场: " + currentTrack.getPath());
        }

    }


    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
    }
}
