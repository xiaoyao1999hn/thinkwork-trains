package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;
/**
 * 步数断言器
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：处理根据步数情况来处理跳出循环
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
