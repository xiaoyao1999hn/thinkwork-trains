package cn.chengjie.trains.handler;

import cn.chengjie.trains.entity.Edge;
import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:13
 **/
public class TrainsMaxStopHandler extends TrainsHandler {

    public TrainsMaxStopHandler(List<Edge> trainsList, String start, String end, int maxStop) {
        super(trainsList, start, end, maxStop,true);
    }

    @Override
    public String execute() {
        try{
            List list=graph.listTrack(start,end);
            return String.valueOf(list.size());
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
