package cn.chengjie.trains.handler;

import cn.chengjie.trains.domain.Condition;
import cn.chengjie.trains.domain.Edge;

import java.util.List;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/10/27 21:37
 * @description：
 */
public interface TrainsHandler {
    /**
     * 获取结果
     * @param edges       单向图数据
     * @param vertices    节点
     * @param condition   过滤条件
     * @return
     */
    int getResult(List<Edge> edges, List<String> vertices, Condition condition);
}
