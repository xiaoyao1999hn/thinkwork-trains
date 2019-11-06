package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:16
 * @description：
 */
public class DefaultPredicate implements Predicate {
    @Override
    public boolean test(Condition condition) {
        return condition.getEdge().getEnd().equals(condition.getRoute().getStart());
    }
}
