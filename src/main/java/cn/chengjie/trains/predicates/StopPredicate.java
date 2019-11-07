package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;
/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：
 */
public class StopPredicate implements  Predicate{
    int stopCount=0;

    public StopPredicate(int stopCount) {
        this.stopCount = stopCount;
    }

    @Override
    public boolean test(Condition condition) {
        return condition.getTrack().getPath().length()>stopCount;
    }
}
