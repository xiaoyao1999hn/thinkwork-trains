package cn.chengjie.trains.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 10:21
 * @description：
 */
public class Route {

    List<String> vertices;
    
    List<List<String>> tracks;

    public Route(){
        vertices=new LinkedList<>();
        tracks=new LinkedList<>();
    }

    public int getVertexCount(){
        return vertices.size();
    }

    public void addVertex(String vertex){
        vertices.add(vertex);
    }

    public List<String> getVertices() {
        return vertices;
    }

    public void setVertices(List<String> vertices) {
        this.vertices = vertices;
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
        vertices.stream().forEach(x->buffer.append(x).append("->"));
        buffer.replace(buffer.length()-2,buffer.length(),"");
        return buffer.toString();
    }
}
