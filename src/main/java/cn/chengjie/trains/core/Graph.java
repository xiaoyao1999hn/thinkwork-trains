package cn.chengjie.trains.core;

import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Route;
import cn.chengjie.trains.entity.Track;

import java.util.*;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:35
 **/
public class Graph {

    Map<String, List<Edge>> trainsGraph;

    public Graph(List<Edge> list) {
        trainsGraph = new HashMap<>();
        list.forEach(x -> {
            List<Edge> temp = trainsGraph.get(x.getStart());
            if (temp == null || temp.size() == 0) {
                temp = new LinkedList<>();
            }
            temp.add(x);
            trainsGraph.put(x.getStart(), temp);
        });
    }

    //A,B
    public List<Track> listTrack(String start, String end) {
        Route route = new Route(start);
        List<Edge> stationList = trainsGraph.get(start);
        for (Edge edge : stationList) {
            Track track = new Track(start);
            track.getPath().append(edge.getEnd());
            track.setCount(edge.getDistance());
            traverseGraph(route, track, edge.getEnd(), end);
        }
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

            int length = currentTrack.getCount() + edge.getDistance();
            //第6题
            if (currentTrack.getPath().length()>4) {
                continue;
            }

            //第7题
//            if(currentTrack.getPath().length()>5){
//                continue;
//            }

            //第10题的条件
//            if (length > 30) {
//                continue;
//            }

            //第8,9题
//            if (edge.getEnd().equals(route.getStart())) {
//                currentTrack.getPath().append(edge.getEnd());
//                route.getTrackList().add(currentTrack.clone());
//                System.out.println("满足条件加入队列: 【" + currentTrack.getPath() + "】");
//                currentTrack=temp;
//                System.out.println("恢复现场: " + currentTrack.getPath());
//                continue;
//            }
//
//            if (currentTrack.getPath().indexOf(edge.getEnd()) > -1 && currentTrack.getPath().length() > 2) {
//                System.out.println("条件不满足跳出: " + currentTrack.getPath() + "，start：" + edge.getStart() + " ，end：" + edge.getEnd());
//                continue;
//            }


            currentTrack.getPath().append(edge.getEnd());
            currentTrack.setCount(length);
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
