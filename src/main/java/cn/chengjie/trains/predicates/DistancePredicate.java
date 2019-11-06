package cn.chengjie.trains.predicates;
import cn.chengjie.trains.entity.Condition;
/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：
 */
public class DistancePredicate implements  Predicate {
    @Override
    public boolean test(Condition condition) {
        return condition.getDistance()<condition.getMaxDistance();
    }
}
