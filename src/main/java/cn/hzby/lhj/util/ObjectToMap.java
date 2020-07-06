package cn.hzby.lhj.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cglib.beans.BeanMap;

/**
 * @author lhj
 */
public class ObjectToMap {
    /**
     * @version: V1.0
     * @author:  LHJ
     * @methodsName: object2Map
     * @description: JSON 转 Map
     * @param: T object
     * @return: <T>
     * @throws:
     */
    @SuppressWarnings("unchecked")
	public static <T> Map<String, Object> object2Map(T object) {

        if (null == object) {
            return null;
        }

        BeanMap beanMap = BeanMap.create(object);
        Map<String, Object> map = new HashMap<>(16);
        beanMap.keySet().forEach((item) -> map.put("" + item, beanMap.get(item)));
        return map;
    }

}
