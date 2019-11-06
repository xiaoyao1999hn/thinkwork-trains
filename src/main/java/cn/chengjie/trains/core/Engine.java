package cn.chengjie.trains.core;

import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Track;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 15:42
 **/
public class Engine {
    
    public static void main(String[] args){
        Graph graph =new Graph(fromList());
        List<Track> list =graph.listTrack("C","C");
        list.forEach(x->{
            System.out.println(x.getPath().toString()+"--------"+x.getCount());
        });

        System.out.println();

    }

    public static List<Edge> fromList(){
        // AB5, BC4, CD8, DC8, DE6, AD5, CE2, EB3, AE7
        List<Edge> list=new ArrayList<>();
        Edge track1= new Edge("A","B",5);list.add(track1);
        Edge track2= new Edge("B","C",4);list.add(track2);
        Edge track3= new Edge("C","D",8);list.add(track3);
        Edge track4= new Edge("D","C",8);list.add(track4);
        Edge track5= new Edge("D","E",6);list.add(track5);
        Edge track6= new Edge("A","D",5);list.add(track6);
        Edge track7= new Edge("C","E",2);list.add(track7);
        Edge track8= new Edge("E","B",3);list.add(track8);
        Edge track9= new Edge("A","E",7);list.add(track9);

        return list;
    }
    
}
