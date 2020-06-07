package cn.hzby.lhj.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

public class ObjectToMap {
    // object 2 map
    @SuppressWarnings("unchecked")
	public static <T> Map<String, Object> object2Map(T object) {

        if (null == object) {
            return null;
        }

        BeanMap beanMap = BeanMap.create(object);
        Map<String, Object> map = new HashMap<>();
        beanMap.keySet().forEach((item) -> map.put("" + item, beanMap.get(item)));
        return map;
    }

}
