package cn.chengjie.trains.predicates;

import cn.chengjie.trains.entity.DefaultParam;

/**
 * @author ：Chengjie
 * @date ：Created in 2019/11/6 23:16
 * @description：
 */
public class DefaultPredicate implements Predicate<DefaultParam> {
    @Override
    public boolean test(DefaultParam defaultParam) {
        return false;
    }


}
