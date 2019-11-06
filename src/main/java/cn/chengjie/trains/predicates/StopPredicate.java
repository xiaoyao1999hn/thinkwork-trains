package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;
/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：
 */
public class StopPredicate implements  Predicate{
    @Override
    public boolean test(Condition condition) {
        return condition.getTrack().getPath().length()>condition.getStop();
    }
}
