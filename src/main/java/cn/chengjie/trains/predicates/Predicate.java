package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.Condition;
/**
 * 断言器顶层解扣子类
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:09
 * @description：
 */
public interface Predicate {
    boolean test(Condition condition);
}
