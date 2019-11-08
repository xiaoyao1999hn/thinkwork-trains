package cn.chengjie.trains;
import cn.chengjie.trains.entity.Edge;
import cn.chengjie.trains.handler.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 起始类
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 9:56
 * @description：
 */
public class App {

    public static void main(String[] args) {

        Stream<String> lines = null;
        try {
            //获取文本里面的数据
            lines = Files.lines(Paths.get(App.class.getClassLoader().getResource("data.txt").getPath().replaceFirst("\\/","")));
            //初始化路径数据
            List<Edge> trainsList=lines.flatMap(line -> Arrays.stream(line.split(",")))
                    .map(String::trim)
                    .filter(str -> !str.isEmpty())
                    .map(str -> new Edge(String.valueOf(str.charAt(0)),String.valueOf(str.charAt(1)),Character.getNumericValue(str.charAt(2)))).collect(Collectors.toList());

            //访问路线列表
            List<List<String>> stationList = Arrays.asList(Arrays.asList("A", "B", "C"), Arrays.asList("A", "D"),
                    Arrays.asList("A", "D", "C"), Arrays.asList("A", "E", "B", "C", "D"), Arrays.asList("A", "E", "D"));

            //初始化各个handler
            List<Handler> handlerList =initHandler(trainsList,stationList);
            //输出
            for (int i=0;i<handlerList.size();i++) {
                System.out.println(String.format("Output #%d: %s",i+1,handlerList.get(i).execute()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化各个handler去处理相应的业务
     * @param trainsList    路径列表
     * @param stationList   访问路线列表
     * @return
     */
    public static List<Handler> initHandler(List<Edge> trainsList,List<List<String>> stationList){

        List<Handler> handlerList =new ArrayList<>();

        //保存5个求路径距离的handler
        for(List<String> station: stationList){
            handlerList.add(new TrainsDistanceHandler(trainsList,station));
        }

        //保存求最大步数不超过3的handler
        Handler maxStopHandler= new TrainsMaxStopHandler(trainsList,"C", "C",3);
        handlerList.add(maxStopHandler);

        //保存求精准4步的handler
        Handler exactlyStopHandler= new TrainsExactlyStopHandler(trainsList,"A", "C",4);
        handlerList.add(exactlyStopHandler);

        //保存求最短路径的handler
        Handler shortestDistanceHandler=new TrainsShortestDistanceHandler(trainsList,"A", "C");
        handlerList.add(shortestDistanceHandler);

        Handler shortestDistanceHandler2=new TrainsShortestDistanceHandler(trainsList,"B", "B");
        handlerList.add(shortestDistanceHandler2);

        //保存求最大路径handler
        Handler maxDistanceHandler=new TrainsMaxDistanceHandler(trainsList,"C", "C",30);
        handlerList.add(maxDistanceHandler);

        return handlerList;
    }
}
