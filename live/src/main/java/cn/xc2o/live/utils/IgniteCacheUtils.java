package cn.xc2o.live.utils;

import cn.xc2o.live.entity.GroupInfo;
import org.apache.ignite.configuration.CacheConfiguration;

/**
 * Created by cc on 2017/7/4.
 */
public class IgniteCacheUtils {

    public static <V> String getCacheName(Class<V> vClz){
        return vClz.getSimpleName()+"Cache";
    }

    public static <K,V> CacheConfiguration springDataCacheCfg(Class<K> kClz, Class<V> vClz){
        String name = getCacheName(vClz);
        //定义一个SpringData使用的缓存对象
        CacheConfiguration ccfg = new CacheConfiguration(name);
        //设置cache的 SQL schema
        ccfg.setIndexedTypes(kClz, vClz);
        return ccfg;
    }
}
