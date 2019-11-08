package cn.chengjie.trains.handler;

import cn.chengjie.trains.core.Graph;
import cn.chengjie.trains.entity.Edge;
import java.util.List;

/**
 * 指定路径长度处理辅助类
 * @author ChengJie
 * @desciption
 * @date 2019/11/7 11:03
 **/
public class TrainsDistanceHandler implements Handler {

    /**
     * 图对象
     */
    Graph graph;

    /**
     * 路径信息
     */
    List<String> stationList;

    public TrainsDistanceHandler(List<Edge> trainsList,List<String> stationList){
        graph =new Graph.Builder()
                .trainsList(trainsList)
                .isCycle(false)
                .build();
        this.stationList=stationList;
    }

    @Override
    public String execute() {
        try{
            //先获取该路径边信息，如果无合适的边信息返回NO SUCH ROUTE
            List<Edge> list=graph.showRoute(this.stationList);
            int distance=0;
            for(Edge edge:list){
                distance+=edge.getDistance();
            }
            return String.valueOf(distance);
        }catch (Exception e){
            return e.getMessage();
        }
    }
}
