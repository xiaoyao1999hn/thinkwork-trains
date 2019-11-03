package cn.chengjie.trains.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 10:21
 * @description：
 */
public class Route {

    List<String> stations;
    
    List<List<String>> tracks;

    public Route(){
        stations =new LinkedList<>();
        tracks=new LinkedList<>();
    }

    public int getStationCount(){
        return stations.size();
    }

    public void addStation(String station){
        stations.add(station);
    }

    public List<String> getStations() {
        return stations;
    }

    public void setStations(List<String> stations) {
        this.stations = stations;
    }
    
    public void addTracks(List<String> track){
        tracks.add(track);
    }

    public List<List<String>> getTracks() {
        return tracks;
    }

    public void setTracks(List<List<String>> tracks) {
        this.tracks = tracks;
    }

    @Override
    public String toString() {
        StringBuffer buffer =  new StringBuffer();
        stations.stream().forEach(x->buffer.append(x).append("->"));
        buffer.replace(buffer.length()-2,buffer.length(),"");
        return buffer.toString();
    }
}
