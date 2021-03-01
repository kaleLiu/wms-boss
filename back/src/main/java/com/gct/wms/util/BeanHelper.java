package com.gct.wms.util;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright @2020 icarbonx.com
 * author kale
 * Description: 工具类
 * date 2021/2/24
 */
public class BeanHelper {

    public static <T> T copyProperties(Object source, Class<T> targetClass) {
        T target = null;
        try {
            if (source != null) {
                target = targetClass.newInstance();
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        if (target != null)
            BeanUtils.copyProperties(source, target);
        return target;
    }

    public static <T> List<T> copyProperties(List<?> sources, Class<T> targetClass) {
        List<T> targets = null;
        if (sources != null) {
            targets = new ArrayList<>();
            for (Object source : sources) {
                T target = copyProperties(source, targetClass);
                targets.add(target);
            }
        }
        return targets;
    }

    public static <T> T getOne(List<T> list) {
        return list == null || list.isEmpty() ? null : list.get(0);
    }
}
