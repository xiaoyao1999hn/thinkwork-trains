package cn.chengjie.trains.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:34
 **/
public class Route {

    List<Track> trackList;

    String start;

    public Route(String start){
        this.start=start;
        trackList=new ArrayList<>();
    }


    public List<Track> getTrackList() {
        return trackList;
    }

    public void setTrackList(List<Track> trackList) {
        this.trackList = trackList;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }
}
