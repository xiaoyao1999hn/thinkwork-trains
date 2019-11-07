package cn.chengjie.trains.handler;

import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.entity.Track;

import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:22
 **/
public class TrainsExactlyStopHandler extends TrainsHandler {

    int stop;

    public TrainsExactlyStopHandler(List<Edge> trainsList, String start, String end, int maxStop) {
        super(trainsList, start, end, maxStop,true);
        //因为起点也在路径中,所以需要加1才能获取到正确的步数
        this.stop=maxStop+1;
    }

    @Override
    public String execute() {
        try{
            List<Track> list=graph.listTrack(start,end);
            int count=0;
            for (Track track:list){
                if(track.getPath().length()==this.stop){
                    count++;
                }
            }
            return String.valueOf(count);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
