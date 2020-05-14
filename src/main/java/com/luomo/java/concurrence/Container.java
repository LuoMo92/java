package com.luomo.java.concurrence;

import java.util.*;

/**
 * @author Liumei
 * @date 2020/5/14  0014
 */
public class Container {

    public static void main(String[] args) {

        List list = Collections.synchronizedList(new ArrayList());
        Set set = Collections.synchronizedSet(new HashSet());
        Map map = Collections.synchronizedMap(new HashMap());
    }

}
