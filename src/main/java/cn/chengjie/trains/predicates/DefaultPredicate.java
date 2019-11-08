package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;

/**
 * 默认不循环遍历起点断言器
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:16
 * @description：处理不循环图遍历，获取最短路径
 */
public class DefaultPredicate implements Predicate {
    @Override
    public boolean test(Condition condition) {
        return condition.getTrack().getPath().indexOf(condition.getEdge().getEnd()) > -1 && condition.getTrack().getPath().length() > 2;
    }
}
