package cn.chengjie.trains.predicates;
import cn.chengjie.trains.entity.Condition;
/**
 * 最大距离断言器
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：根据最大距离跳出循环
 */
public class DistancePredicate implements  Predicate {

    int maxDistance;

    public DistancePredicate(int maxDistance){
        this.maxDistance=maxDistance;
    }

    @Override
    public boolean test(Condition condition) {
        return condition.getDistance()>=maxDistance;
    }
}
