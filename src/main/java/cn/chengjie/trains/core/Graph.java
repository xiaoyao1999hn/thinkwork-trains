package cn.chengjie.trains.core;

import cn.chengjie.trains.entity.*;
import cn.chengjie.trains.predicates.Predicate;

import java.util.*;

/**
 * 图的核心类,对外提供图遍历和路径长度查询API
 * @author ChengJie
 * @desciption
 * @date 2019/11/5 14:35
 **/
public class Graph {

    /**
     * 每个节点可达边的数据
     */
    private Map<String, List<Edge>> trainsGraph;

    /**
     * 源路径数据
     */
    private List<Edge> trainsList;

    /**
     * 校验类
     */
    private Predicate predicate;

    /**
     * 是否处理环
     */
    private boolean isCycle;

    public Graph(Builder builder) {
        this.predicate = builder.predicate;
        this.trainsList = builder.trainsList;
        this.isCycle=builder.isCycle;
        trainsGraph = new HashMap<>();
        //每个节点可达边的数据
        builder.trainsList.forEach(x -> {
            List<Edge> temp = Optional.ofNullable(trainsGraph.get(x.getStart())).orElse(new LinkedList<Edge>());
            temp.add(x);
            trainsGraph.put(x.getStart(), temp);
        });
    }

    /**
     * 获取符合规则的路径数据
     * @param start  起始节点
     * @param end    结束节点
     * @return
     */
    public List<Track> listTrack(String start, String end) {
        Route route = new Route(start);
        //先获取起始节点所有的可达边再递归搜索
        Optional.ofNullable(trainsGraph.get(start)).orElseThrow(() -> new RuntimeException("NO SUCH ROUTE")).forEach(x -> {
            Track track = new Track(start);
            track.refreshTrack(x);
            traverseGraph(route, track, x.getEnd(), end);
        });
        return route.getTrackList();
    }

    /**
     *  遍历整个图，搜索符合规则的路径
     * @param route             路径管理者
     * @param currentTrack      当前路径
     * @param start             起始节点
     * @param end               结束节点
     */
    public void traverseGraph(Route route, Track currentTrack, String start, String end) {
        //先保存现场,用于后续递归时还原现场继续遍历
        Track temp = currentTrack.clone();
        List<Edge> trainsPath = trainsGraph.get(start);
        for (Edge edge : trainsPath) {
            //是否循环之前走过的路径
            if (edge.getEnd().equals(route.getStart()) && !isCycle) {
                currentTrack.refreshTrack(edge);
                route.getTrackList().add(currentTrack.clone());
                currentTrack = temp;
                continue;
            }
            //校验是否继续往下找
            if (predicate.test(new Condition(currentTrack,(currentTrack.getPathLength() + edge.getDistance()),route, edge))) {
                continue;
            }
            //更新路径信息
            currentTrack.refreshTrack(edge);
            //找到目标节点加入队列
            if (edge.getEnd().equals(end)) {
                route.getTrackList().add(currentTrack.clone());
            }
            traverseGraph(route, currentTrack, edge.getEnd(), end);
            //遍历完毕之后还原现场
            currentTrack = temp;
        }
    }

    /**
     * 获取指定路径的长度信息
     * @param stationList
     * @return
     */
    public List<Edge> showRoute(List<String> stationList) {
        List<Edge> result = new LinkedList<>();
        for (int i = 0; i < stationList.size() - 1; i++) {
            final int index = i;
            trainsList.stream()
                    .filter(x -> x.getStart().equals(stationList.get(index)))
                    .filter(x -> x.getEnd().equals(stationList.get(index + 1)))
                    .forEach(x ->result.add(x));
        }
        if(result.size()!=(stationList.size()-1)) throw  new RuntimeException("NO SUCH ROUTE");
        return result;
    }

    public static class Builder {
        private List<Edge> trainsList;

        private Predicate predicate;

        private boolean isCycle;

        public Builder trainsList(List<Edge> trainsList) {
            this.trainsList = trainsList;
            return this;
        }

        public Builder predicate(Predicate predicate) {
            this.predicate = predicate;
            return this;
        }

        public Builder isCycle(boolean isCycle) {
            this.isCycle = isCycle;
            return this;
        }

        public Graph build() {
            return new Graph(this);
        }
    }

}
