package com.stark.entity;

import java.util.List;

/**
 * Created by Stark on 2017/9/6.
 */
public interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
}
