package cn.chengjie.trains.core;

import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Route;
import cn.chengjie.trains.entity.Track;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:35
 **/
public class Graph_bak {

//    Map<String,List<Edge>> trainsGraph;
//
//    public Graph_bak(List<Edge> list){
//        trainsGraph=new HashMap<>();
//        list.forEach(x->{
//            List<Edge> temp=trainsGraph.get(x.getStart());
//            if(temp==null||temp.size()==0){
//                temp=new LinkedList<>();
//            }
//            temp.add(x);
//            trainsGraph.put(x.getStart(),temp);
//        });
//    }
//
//    //A,B
//    public List<Track> listTrack(String start,String end){
//        Route route =new Route(start);
//        List<Edge> stationList=trainsGraph.get(start);
//        for (Edge edge:stationList){
//            Track track=new Track(start);
//            track.getPath().ap(edge.getEnd());
//            traverseGraph(route,track,edge.getEnd(),end);
//        }
//        return route.getTrackList();
//    }
//
//    //AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
//    //A,C, AB&AD&AE    BC   CD&CE    DC   EB
//    public void traverseGraph(Route route,Track currentTrack,String start,String end){
//        List<Edge> trainsPath=trainsGraph.get(start);
//        for(Edge edge:trainsPath){
//            //遇到前面已经访问过的节点直接跳出
//            if(currentTrack.getPath().contains(edge.getEnd())){
//                if(route.getStart().equals(edge.getEnd())){
//                    currentTrack.getPath().add(edge.getEnd());
//                    route.getTrackList().add(currentTrack.clone());
//                    return;
//                }else if(currentTrack.getPath().size()>2){
//                    //破解环
//                    return;
//                }
//            }
//            currentTrack.getPath().add(edge.getEnd());
//            //找到目标节点退出,没找到则递归继续找
//            if(edge.getEnd().equals(end)){
//                route.getTrackList().add(currentTrack.clone());
//                return;
//            }else {
//                traverseGraph(route,currentTrack,edge.getEnd(),end);
//            }
//        }
//    }
}
